package edai.tema3;

public class List<T> implements IDataStructure<T> {
	private Node<T> first;
	
	public List() {
		
	}
	
	public List<T> insert(T data, int index) {
		if (index == 0 || (index == -1 && isEmpty())) {
			insertAtBeginning(data);
		} else if (index == -1) {
			insertAtEnd(data);
		} else if (index < -1) {
			throw new IndexOutOfBoundsException();
		} else {
			insertAtIndex(data, index);
		}
		return this;
	}
	
	private void insertAtBeginning(T data) {
		Node<T> node = new Node<T>(data);
		node.setNext(getFirst());
		first = node;
	}
	
	private void insertAtEnd(T data) {
		Node<T> current = getFirst();
		while (current.getNext() != null) {
			current = current.getNext();
		}
		current.setNext(new Node<T>(data));
	}
	
	private void insertAtIndex(T data, int index) {
		int control = 0;
		Node<T> current = getFirst();
		while (current != null && control < index - 1) {
			current = current.getNext();
			control++;
		}
		if (current != null) {
			Node<T> newNode = new Node<T>(data);
			newNode.setNext(current.getNext());
			current.setNext(newNode);
		} else {
			throw new IndexOutOfBoundsException();
		}
	}
	
	public List<T> remove(int index) {
		if (isEmpty() || index < -1) {
			throw new IndexOutOfBoundsException();
		} else if (index == 0 || (index == -1 && first.getNext() == null)) {
			removeFirst(); 
		} else if (index == -1) {
			removeLast();
		} else {
			removeAtIndex(index);
		}
		return this;
	}
	
	private void removeFirst() {
		first = first.getNext();
	}
	
	private void removeLast() {
		Node<T> current = first;
		while (current.getNext() != null
				&& current.getNext().getNext() != null) {
			current = current.getNext();
		}
		current.setNext(null);
	}
	
	private void removeAtIndex(int index) {
		int control = 0;
		Node<T> current = first;
		while (current != null && control < index - 1) {
			current = current.getNext();
			control++;
		}
		if (current != null && current.getNext() != null) {
			current.setNext(current.getNext().getNext());
		} else {
			throw new IndexOutOfBoundsException();
		}
	}
	
	public Node<T> getFirst() {
		return first;
	}
	
	public int size() {
		int count = 0;
		Node<T> current = getFirst();
		while (current != null) {
			count++;
			current = current.getNext();
		}
		return count;

	}
	
	public boolean isEmpty() {
		return getFirst() == null;
	}
	
	public T[] listData() {
		@SuppressWarnings("unchecked")
		T[] array = (T[])new Object[size()];
		int index = 0;
		Node<T> current = getFirst();
		while (current != null) {
			array[index] = current.getData();
			index++;
			current = current.getNext();
		}
		return array;
	}
}
