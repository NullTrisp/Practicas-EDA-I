package edai.tema6.ejercicio1;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.graphstream.graph.Graph;
import org.junit.jupiter.api.Test;

class ProgramTest {
	@Test
	void testCreateGraph() {
		final Graph graph = Program.createGraph();
		assertEquals(8, graph.getNodeCount());
		assertEquals(12, graph.getEdgeCount());
	}

	@Test
	void testCreateMatrix() {
		final Graph graph = Program.createGraph();
		final String[] result = Program.createMatrix(graph);
		final String[] expected = { "A (0, -)", "B (3, G)", "C (7, F)", "D (3, G)", "E (5, D)", "F (6, E)", "G (2, A)",
				"Z (8, E)" };
		assertArrayEquals(expected, result);
	}
}