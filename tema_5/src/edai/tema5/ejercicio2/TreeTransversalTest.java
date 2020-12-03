package ejercicio2;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import tema_5.BinaryTree;

class TreeTraversalTest {
	@Test
	void testTraversePreOrder() {
		BinaryTree<Integer> tree = new BinaryTree<Integer>();
		tree.insert(15);
		tree.insert(9);
		tree.insert(6);
		tree.insert(14);
		tree.insert(13);
		tree.insert(20);
		tree.insert(17);
		tree.insert(64);
		tree.insert(26);
		tree.insert(72);

		assertArrayEquals(new Integer[] { 15, 9, 6, 14, 13, 20, 17, 64, 26, 72 }, TreeTraversal.traversePreOrder(tree));

	}

	@Test
	void testTraversePostOrder() {
		BinaryTree<Integer> tree = new BinaryTree<Integer>();
		tree.insert(15);
		tree.insert(9);
		tree.insert(6);
		tree.insert(14);
		tree.insert(13);
		tree.insert(20);
		tree.insert(17);
		tree.insert(64);
		tree.insert(26);
		tree.insert(72);
		assertArrayEquals(new Integer[] { 6, 13, 14, 9, 17, 26, 72, 64, 20, 15 },
				TreeTraversal.traversePostOrder(tree));

	}
}