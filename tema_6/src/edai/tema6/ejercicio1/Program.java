package edai.tema6.ejercicio1;

import java.util.ArrayList;

import org.graphstream.algorithm.Dijkstra;
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
		graph.addEdge("AG", "A", "G").setAttribute("length", 2);
		graph.addEdge("AD", "A", "D").setAttribute("length", 5);
		graph.addEdge("BG", "B", "G").setAttribute("length", 1);
		graph.addEdge("BC", "B", "C").setAttribute("length", 5);
		graph.addEdge("DG", "D", "G").setAttribute("length", 1);
		graph.addEdge("DE", "D", "E").setAttribute("length", 2);
		graph.addEdge("EF", "E", "F").setAttribute("length", 1);
		graph.addEdge("EZ", "E", "Z").setAttribute("length", 3);
		graph.addEdge("CF", "C", "F").setAttribute("length", 1);
		graph.addEdge("CZ", "C", "Z").setAttribute("length", 1);
		graph.addEdge("FZ", "F", "Z").setAttribute("length", 2);

		return graph;

	}

	public static String[] createMatrix(Graph graph) {
		Dijkstra dijkstra = new Dijkstra(Dijkstra.Element.EDGE, null, "length");
		ArrayList<String> path = new ArrayList<String>();
		dijkstra.init(graph);
		dijkstra.setSource(graph.getNode("A"));
		dijkstra.compute();
		String lastNode;
		for (Node node : graph) {
			lastNode = (dijkstra.getParent(node) == null) ? "-" : dijkstra.getParent(node).getId();
			path.add(node.getId() + " (" + (int) dijkstra.getPathLength(node) + ", " + lastNode + ")");
		}
		return path.toArray(new String[path.size()]);
	}
}
