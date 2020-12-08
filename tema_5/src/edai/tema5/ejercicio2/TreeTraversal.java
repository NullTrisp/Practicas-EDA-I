package edai.tema5.ejercicio2;

import java.util.ArrayList;
import edai.tema5.BinaryTree;
import edai.tema5.TreeNode;

public class TreeTraversal {

	public static <T extends Comparable<T>> Object[] traversePreOrder(BinaryTree<T> tree) {
		ArrayList<T> dataPreOrder = new ArrayList<T>();
		preOrder(dataPreOrder, tree.getRoot());

		return dataPreOrder.toArray();
	}

	private static <T> void preOrder(ArrayList<T> dataPreOrder, TreeNode<T> current) {
		if (current != null) {
			dataPreOrder.add(current.getData());

			preOrder(dataPreOrder, current.getLeftNode());
			preOrder(dataPreOrder, current.getRightNode());
		}

	}

	public static <T extends Comparable<T>> Object[] traversePostOrder(BinaryTree<T> tree) {
		ArrayList<T> dataPostOrder = new ArrayList<T>();
		postOrder(dataPostOrder, tree.getRoot());

		return dataPostOrder.toArray();
	}

	private static <T> void postOrder(ArrayList<T> dataPreOrder, TreeNode<T> current) {
		if (current != null) {
			postOrder(dataPreOrder, current.getLeftNode());
			postOrder(dataPreOrder, current.getRightNode());
			
			dataPreOrder.add(current.getData());
		}

	}

}
