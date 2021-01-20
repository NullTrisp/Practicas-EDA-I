package proyecto.views;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import org.graphstream.algorithm.Dijkstra;
import org.graphstream.graph.Edge;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.MultiGraph;
import proyecto.datatypes.Airport;
import proyecto.datatypes.DataGenerator;
import proyecto.datatypes.Route;

public class GraphGenerator {
	private Graph graph;
	private DataGenerator dataGenerator;
	private Airport source;
	private Airport destination;

	public GraphGenerator(DataGenerator dataGenerator) {
		System.setProperty("org.graphstream.ui", "swing");
		this.graph = new MultiGraph("Graph");
		this.dataGenerator = dataGenerator;
	}

	public GraphGenerator(DataGenerator dataGenerator, Airport source, Airport destination) {
		System.setProperty("org.graphstream.ui", "swing");
		this.graph = new MultiGraph("Graph");
		this.dataGenerator = dataGenerator;
		this.source = source;
		this.destination = destination;
	}

	public GraphGenerator setNodes() {
		for (int i = 0; i < this.dataGenerator.getAirports().size(); i++) {
			this.graph.addNode(this.dataGenerator.getAirports().get(i).getAirportID()).setAttribute("ui.style",
					"size: 6px, 6px; fill-color: darkgray;");
			this.graph.getNode(i).setAttribute("x", this.dataGenerator.getAirports().get(i).getLongitude());
			this.graph.getNode(i).setAttribute("y", this.dataGenerator.getAirports().get(i).getLatitude());
		}
		return this;
	}

	public GraphGenerator setRoutes() {
		Airport source, destination;
		Route routes[] = new Route[this.dataGenerator.getRoutes().size()];
		routes = this.dataGenerator.getRoutes().toArray(routes);

		for (int i = 0; i < routes.length; i++) {
			try {
				source = this.searchAirport(routes[i].getSourceAirportID());
				destination = this.searchAirport(routes[i].getDestinationAirportID());
				if (source != null && destination != null) {
					Map<String, Object> options = new HashMap<String, Object>();
					options.put("ui.style", "fill-color: dodgerblue; stroke-width: 2px;");
					options.put("length", "1");
					// TODO change edge id
					this.graph.addEdge(Integer.toString(i), source.getAirportID(), destination.getAirportID())
							.setAttributes(options);
				}
			} catch (Exception err) {
				System.out.println(err);
				System.out.println(i);
				System.out.println(routes[i].getSourceAirportID());
				System.out.println(routes[i].getDestinationAirportID());
				break;
			}
		}
		return this;
	}

	private Airport searchAirport(String id) {
		Airport airport = null;
		Airport[] airports = new Airport[this.dataGenerator.getAirports().size()];
		airports = this.dataGenerator.getAirports().toArray(airports);

		for (int i = 0; i < airports.length; i++) {
			if (airports[i].getAirportID().equals(id)) {
				airport = airports[i];
				break;
			}
		}
		return airport;
	}

	public GraphGenerator setDijkstra(MainView view) {
		Dijkstra dijkstra = new Dijkstra(Dijkstra.Element.EDGE, null, "length");
		dijkstra.init(this.graph);
		dijkstra.setSource(this.graph.getNode(this.source.getAirportID()));
		dijkstra.compute();
		for (Node node : dijkstra.getPathNodes(this.graph.getNode(this.destination.getAirportID()))) {
			node.setAttribute("ui.style", "fill-color: black; text-size: 24; text-color: blue; "
					+ "text-alignment: above; text-background-color: grey; text-background-mode: plain;");
			node.setAttribute("ui.label", this.searchAirport(node.getId()).getName());
		}

		for (Edge edge : dijkstra.getPathEdges(this.graph.getNode(this.destination.getAirportID()))) {
			edge.setAttribute("ui.style", "fill-color: forestgreen; stroke-width: 10px;");
		}

		ArrayList<String> airports = new ArrayList<String>();
		dijkstra.getPathNodesStream(this.graph.getNode(this.destination.getAirportID())).forEach(node -> {
			Airport aux = this.searchAirport(node.getId());
			airports.add(aux.getAirportID() + ", " + aux.getName() + ", " + aux.getCountry());
		});

		if (dijkstra.getPathLength(this.graph.getNode(this.destination.getAirportID())) == Double.POSITIVE_INFINITY) {
			JOptionPane.showMessageDialog(view, "There´s no available path for the inputs recieved :c", "oops :/",
					JOptionPane.ERROR_MESSAGE);
			MainView frame = new MainView(dataGenerator);
			frame.setVisible(true);
		} else {
			this.setUp();
			new Path(airports.toArray(new String[airports.size()])).setVisible(true);
		}

		return this;
	}

	public void setUp() {
		this.graph.display(false);
	}
}
