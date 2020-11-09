package edai.tema4;

import java.util.EmptyStackException;

import edai.tema4.IDataStructure;
import edai.tema4.List;

public class Queue<T> implements IDataStructure<T> {
	private List<T> list;
	
	public Queue() {
		list = new List<T>();
	}

	public void push(T elem) {
		list.insert(elem, -1);
	}
	
	public T pop() {
		if (list.isEmpty()) {
			throw new EmptyStackException();
		} else {
			T elem = list.getFirst().getData();
			list.remove(0);
			return elem;
		}
	}
	
	public T top() {
		if (list.isEmpty()) {
			throw new EmptyStackException();
		} else {
			return list.getFirst().getData();
		}
	}
	
	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	@Override
	public int size() {
		return list.size();
	}

	@Override
	public T[] listData() {
		return list.listData();
	}

}
