package edai.tema4;

import java.util.EmptyStackException;
import edai.tema4.IDataStructure;
import edai.tema4.Node;

public class Queue<T> implements IDataStructure<T> {
	private Node<T> first;

	public void push(T elem) {
		final Node<T> node = new Node<T>(elem);
		if (first == null) {
			first = node;
		} else {
			Node<T> current = first;
			while (current.getNext() != null) {
				current = current.getNext();
			}
			current.setNext(node);
		}
	}

	public T pop() {
		if (first == null) {
			throw new EmptyStackException();
		} else {
			final Node<T> node = first;
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

	@Override
	public boolean isEmpty() {
		return first == null;
	}

	@Override
	public int size() {
		if (first == null) {
			return 0;
		} else {
			return first.count();
		}
	}

	@Override
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