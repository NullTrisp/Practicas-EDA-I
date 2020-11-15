package edai.tema3;

import java.util.EmptyStackException;
import edai.tema3.IDataStructure;
import edai.tema3.Node;

public class Stack<T> implements IDataStructure<T> {
	private Node<T> first;

	public void push(T elem) {
		Node<T> node = new Node<T>(elem);
		if (first == null) {
			first = node;
		} else {
			node.setNext(first);
			first = node;
		}
	}

	public T pop() {
		if (first == null) {
			throw new EmptyStackException();
		} else {
			Node<T> node = first;
			first = first.getNext();
			return node.getData();
		}
	}

	public T top() {
		if (first == null) {
			throw new EmptyStackException();
		} else {
			return first.getData();
		}
	}

	public boolean isEmpty() {
		return first == null;
	}

	public int size() {
		if (first == null) {
			return 0;
		} else {
			return first.count();
		}
	}

	public Object[] listData() {
		Object[] array = new Object[size()];
		Node<T> node = first;
		for (int i = 0; i < array.length; ++i) {
			array[i] = node.getData();
			node = node.getNext();
		}
		return array;
	}
}