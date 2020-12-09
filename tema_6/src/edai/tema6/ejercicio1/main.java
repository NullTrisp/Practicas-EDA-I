package edai.tema6.ejercicio1;

import org.graphstream.graph.*;
import org.graphstream.graph.implementations.SingleGraph;

public class main {

	public static void main(String[] args) {
		System.setProperty("org.graphstream.ui", "swing");
		Graph graph = new SingleGraph("Grafo");
		graph.addNode("A");
		graph.addNode("B");
		graph.addNode("C");
		graph.addNode("D");
		graph.addNode("E");
		graph.addNode("F");
		graph.addNode("G");
		graph.addNode("Z");
		graph.addEdge("AB", "A", "B").setAttribute("length", 4);
		graph.addEdge("AG", "A", "G");
		graph.addEdge("AD", "A", "D");
		graph.addEdge("BG", "B", "G");
		graph.addEdge("BC", "B", "C");
		graph.addEdge("DG", "D", "G");
		graph.addEdge("DE", "D", "E");
		graph.addEdge("EF", "E", "F");
		graph.addEdge("EZ", "E", "Z");
		graph.addEdge("CF", "C", "F");
		graph.addEdge("CZ", "C", "Z");
		graph.addEdge("FZ", "F", "Z");
		System.out.print(graph.getEdge("AB").getAttribute("length"));

		for (Node node : graph) {
			node.setAttribute("ui.label", node.getId());
		}
		graph.setAttribute("ui.stylesheet", "node { fill-color: green;" + "text-alignment: at-right; text-style: bold;"
				+ "text-size: 20; text-color: blue; }");

		graph.display();
	}

}
