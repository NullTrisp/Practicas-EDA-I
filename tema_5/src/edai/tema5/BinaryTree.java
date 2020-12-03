package tema_5;

import java.util.Arrays;
import tema_5.IDataStructure;

public class BinaryTree<T extends Comparable<T>> implements IDataStructure<T> {
	private TreeNode<T> root;

	public TreeNode<T> getRoot() {
		return root;
	}

	public void insert(T data) {
		if (root == null) {
			root = new TreeNode<T>(data);
		} else {
			insert(data, root);
		}
	}

	private void insert(T data, TreeNode<T> node) {
		if (node != null) {
			final int comparison = data.compareTo(node.getData());
			if (comparison < 0) {
				if (node.getLeftNode() == null) {
					node.setLeftNode(new TreeNode<T>(data));
				} else {
					insert(data, node.getLeftNode());
				}
			} else if (comparison > 0) {
				if (node.getRightNode() == null) {
					node.setRightNode(new TreeNode<T>(data));
				} else {
					insert(data, node.getRightNode());
				}
			}
		}
	}

	public TreeNode<T> search(T data) {
		return searchNode(root, data);
	}

	private TreeNode<T> searchNode(TreeNode<T> node, T data) {
		if (node == null) {
			return null;
		} else {
			if (node.getData() == data)
				return node;
			final TreeNode<T> inLeft = searchNode(node.getLeftNode(), data);
			if (inLeft != null)
				return inLeft;
			return searchNode(node.getRightNode(), data);
		}
	}

	public void remove(T data) {
		final TreeNode<T> node = search(data);
		if (node != null) {
			final boolean hasLeft = node.getLeftNode() != null;
			final boolean hasRight = node.getRightNode() != null;
			final TreeNode<T> parent = findParent(node);
			if (hasLeft && hasRight) {
				removeTwoChildNode(node, parent);
			} else {
				removeEmptyOrSingleChildNode(node, parent);
			}
		}
	}

	private TreeNode<T> findParent(TreeNode<T> search) {
		return findParent(root, search);
	}

	private TreeNode<T> findParent(TreeNode<T> node, TreeNode<T> search) {
		if (node != null) {
			if (node.getLeftNode() == search)
				return node;
			if (node.getRightNode() == search)
				return node;
			final TreeNode<T> inLeft = findParent(node.getLeftNode(), search);
			if (inLeft != null)
				return inLeft;
			return findParent(node.getRightNode(), search);
		} else {
			return null;
		}
	}

	private void removeTwoChildNode(TreeNode<T> node, TreeNode<T> parent) {
		final TreeNode<T> leftmostValue = findLeftmostChild(node.getRightNode());
		removeEmptyOrSingleChildNode(leftmostValue, findParent(leftmostValue));
		node.setData(leftmostValue.getData());
	}

	private TreeNode<T> findLeftmostChild(TreeNode<T> node) {
		if (node.getLeftNode() != null) {
			return findLeftmostChild(node.getLeftNode());
		} else {
			return node;
		}
	}

	private void removeEmptyOrSingleChildNode(TreeNode<T> node, TreeNode<T> parent) {
		final TreeNode<T> child = (node.getLeftNode() != null) ? node.getLeftNode() : node.getRightNode();
		if (parent != null) {
			if (node == parent.getLeftNode()) {
				parent.setLeftNode(child);
			} else {
				parent.setRightNode(child);
			}
		} else {
			root = child;
		}
	}

	private int countNodes(TreeNode<T> node) {
		if (node != null) {
			return 1 + countNodes(node.getLeftNode()) + countNodes(node.getRightNode());
		} else {
			return 0;
		}
	}

	public boolean isEmpty() {
		return root == null;
	}

	public int size() {
		return countNodes(root);
	}

	public Object[] listData() {
		final Object[] arr = new Object[size()];
		fillInOrder(arr, root, 0);
		return arr;
	}

	private int fillInOrder(Object[] arr, TreeNode<T> node, int firstIndex) {
		if (node != null) {
			int leftCount = fillInOrder(arr, node.getLeftNode(), firstIndex);
			arr[firstIndex + leftCount] = node.getData();
			int rightCount = fillInOrder(arr, node.getRightNode(), firstIndex + leftCount + 1);
			return leftCount + 1 + rightCount;
		} else {
			return 0;
		}
	}

	public Object[] listPath(T data) {
		final Object[] path = new Object[size()];
		final int size = fillPath(path, root, 0, data);
		return Arrays.copyOfRange(path, 0, size);
	}

	private int fillPath(Object[] path, TreeNode<T> node, int firstIndex, T data) {
		if (node != null) {
			if (node.getData() == data) {
				path[firstIndex] = data;
				return firstIndex + 1;
			}
			final int size = fillSubPath(path, node.getLeftNode(), node, firstIndex, data);
			if (size > 0)
				return size;
			return fillSubPath(path, node.getRightNode(), node, firstIndex, data);
		} else {
			return 0;
		}
	}

	private int fillSubPath(Object[] path, TreeNode<T> node, TreeNode<T> parent, int firstIndex, T data) {
		final int size = fillPath(path, node, firstIndex + 1, data);
		if (size > 0)
			path[firstIndex] = parent.getData();
		return size;
	}
}