package proyecto.views;

import java.util.ArrayList;

import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;

import proyecto.datatypes.Airport;

public class GraphGenerator {
	private Graph graph;

	public GraphGenerator() {
		System.setProperty("org.graphstream.ui", "swing");
		this.graph = new SingleGraph("Graph");
		//this.graph.setAttribute("ui.stylesheet", "url(D:\\1Main\\Libraries\\Documents\\Uni\\2020-2021\\Semestre 1\\EDA I\\Practicas\\proyecto\\src\\proyecto);");
	}

	public GraphGenerator setNodes(ArrayList<Airport> airports) {
		for (int i = 0; i < airports.size(); i++) {
			this.graph.addNode(airports.get(i).getAirportID() + " " + airports.get(i).getName());
			this.graph.getNode(i).setAttribute("x", airports.get(i).getLongitude());
			this.graph.getNode(i).setAttribute("y", airports.get(i).getLatitude());
			// this.graph.getNode(i).setAttribute("ui.label", airports.get(i).getName()); //
			// causes performance an ui issues
		}
		return this;
	}

	public void setUp() {
		this.graph.display(false);
	}
}
