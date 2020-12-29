package proyecto.views;

import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;
import proyecto.datatypes.Airport;
import proyecto.datatypes.DataGenerator;

public class GraphGenerator {
	private Graph graph;
	private DataGenerator dataGenerator;
	private Airport source;
	private Airport destination;

	public GraphGenerator(DataGenerator dataGenerator) {
		System.setProperty("org.graphstream.ui", "swing");
		this.graph = new SingleGraph("Graph");
		this.dataGenerator = dataGenerator;
	}

	public GraphGenerator(DataGenerator dataGenerator, Airport source, Airport destination) {
		System.setProperty("org.graphstream.ui", "swing");
		this.graph = new SingleGraph("Graph");
		this.dataGenerator = dataGenerator;
		this.source = source;
		this.destination = destination;
	}

	public GraphGenerator setNodes() {
		for (int i = 0; i < this.dataGenerator.getAirports().size(); i++) {
			if (this.source != null && (this.dataGenerator.getAirports().get(i).getAirportID() == this.source
					.getAirportID()
					|| this.dataGenerator.getAirports().get(i).getAirportID() == this.destination.getAirportID())) {
				this.graph.addNode(this.dataGenerator.getAirports().get(i).getAirportID()); // airports.get(i).getName()
				this.graph.getNode(i).setAttribute("x", this.dataGenerator.getAirports().get(i).getLongitude());
				this.graph.getNode(i).setAttribute("y", this.dataGenerator.getAirports().get(i).getLatitude());
				this.graph.getNode(i).setAttribute("ui.style", "fill-color: red; text-size: 24; text-color: blue; "
						+ "text-alignment: above; text-background-color: grey; text-background-mode: plain;");
				this.graph.getNode(i).setAttribute("ui.label", this.dataGenerator.getAirports().get(i).getName());
			} else {
				this.graph.addNode(this.dataGenerator.getAirports().get(i).getAirportID()); // airports.get(i).getName()
				this.graph.getNode(i).setAttribute("x", this.dataGenerator.getAirports().get(i).getLongitude());
				this.graph.getNode(i).setAttribute("y", this.dataGenerator.getAirports().get(i).getLatitude());
			}
		}
		return this;
	}

	// TODO implement all edges as routes
	public GraphGenerator setRoutes() {
		/*
		 * ArrayList<Route> routes = this.dataGenerator.getRoutes(); ArrayList<Airport>
		 * airports = this.dataGenerator.getAirports();
		 * 
		 * for (int i = 0; i < routes.size(); i++) { for (int j = 0; j <
		 * this.graph.getNodeCount(); j++) { for (int k = 0; k <
		 * this.graph.getNodeCount(); k++) { if
		 * (routes.get(i).getSourceAirportID().equals(this.graph.getNode(j).getId()) &&
		 * routes.get(i).getDestinationAirportID().equals(this.graph.getNode(k).getId())
		 * ) { this.graph.addEdge(airports.get(j).getAirportID() + ", " +
		 * airports.get(k).getAirportID(), airports.get(j).getAirportID(),
		 * airports.get(k).getAirportID()); } } } }
		 */
		this.graph
				.addEdge(this.source.getAirportID() + ", " + this.destination.getAirportID(),
						this.source.getAirportID(), this.destination.getAirportID())
				.setAttribute("ui.style", "fill-color: red;");

		return this;
	}

	public void setUp() {
		this.graph.display(false);
	}
}
