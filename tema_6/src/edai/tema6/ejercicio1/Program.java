package edai.tema6.ejercicio1;

import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;

public class Program {

	public Program() {

	}

	public static Graph createGraph() {
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

		return graph;

	}

	public static String[] createMatrix(Graph graph) {
		String[] nodesArr = new String[graph.getNodeCount()];
		int i = 0;
		for (Node node : graph) {
			nodesArr[i] = node.toString() + " " + "(",;
			++i;
		}
		return nodesArr;

	}
}
