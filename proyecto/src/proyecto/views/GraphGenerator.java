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
import org.graphstream.ui.view.Viewer;

import proyecto.datatypes.Airport;
import proyecto.datatypes.DataGenerator;
import proyecto.datatypes.Route;

public class GraphGenerator {
	private Graph graph;
	private DataGenerator dataGenerator;
	private Airport source;
	private Airport destination;
	private Viewer view;

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
		this.graph.setAttribute("ui.stylesheet", "graph { fill-color: black; }");
		Airport[] aux = this.dataGenerator.getAirports().toArray(new Airport[this.dataGenerator.getAirports().size()]);
		for (int i = 0; i < this.dataGenerator.getAirports().size(); i++) {
			Map<String, Object> options = new HashMap<String, Object>();
			options.put("ui.style", "size: 6px, 6px; fill-color: rgba(69, 69, 69, 35); text-color: rgba(0, 0, 0, 35);");
			options.put("x", aux[i].getLongitude());
			options.put("y", aux[i].getLatitude());

			this.graph.addNode(aux[i].getAirportID()).setAttributes(options);
		}
		return this;
	}

	public GraphGenerator setNodesWholeDataSet() {
		Airport[] aux = this.dataGenerator.getAirports().toArray(new Airport[this.dataGenerator.getAirports().size()]);
		for (int i = 0; i < this.dataGenerator.getAirports().size(); i++) {
			Map<String, Object> options = new HashMap<String, Object>();
			options.put("ui.style", "size: 6px, 6px; fill-color: darkgray;");
			options.put("x", aux[i].getLongitude());
			options.put("y", aux[i].getLatitude());
			options.put("ui.label", aux[i].getName());

			this.graph.addNode(aux[i].getAirportID()).setAttributes(options);
		}
		return this;
	}

	public GraphGenerator setRoutes(boolean path) {
		Airport source, destination;
		Route routes[] = new Route[this.dataGenerator.getRoutes().size()];
		routes = this.dataGenerator.getRoutes().toArray(routes);
		String edgeColor = (path) ? "rgba(255, 98, 0, 15)" : "#1aff1a";
		for (int i = 0; i < routes.length; i++) {
			try {
				source = this.searchAirport(routes[i].getSourceAirportID());
				destination = this.searchAirport(routes[i].getDestinationAirportID());
				if (source != null && destination != null) {
					Map<String, Object> options = new HashMap<String, Object>();
					options.put("ui.style", "fill-color: " + edgeColor + "; stroke-width: 2px;");
					options.put("length", "1");
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
			node.setAttribute("ui.style", "fill-color: black; text-size: 16; text-color: rgb(0, 64, 255); "
					+ "text-alignment: above; text-background-color: rgb(150, 200, 255); text-background-mode: plain; z-index: 1;");
			node.setAttribute("ui.label", this.searchAirport(node.getId()).getName());
		}

		for (Edge edge : dijkstra.getPathEdges(this.graph.getNode(this.destination.getAirportID()))) {
			edge.setAttribute("ui.style", "fill-color: #ff0000; size: 6px; z-index: 1;");
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
			new Path(airports.toArray(new String[airports.size()]), this.dataGenerator, this.view).setVisible(true);
		}

		return this;
	}

	public void setUp() {
		this.graph.setAttribute("ui.stylesheet", "node { z-index: 0; } edge { z-index: 0; }");
		this.view = this.graph.display(false);
		this.view.setCloseFramePolicy(Viewer.CloseFramePolicy.HIDE_ONLY);
	}
}
