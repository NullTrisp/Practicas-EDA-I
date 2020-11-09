package edai.tema3;

import java.util.EmptyStackException;
import edai.tema3.IDataStructure;
import edai.tema3.List;

public class Stack<T> implements IDataStructure<T> {
	private List<T> list;
	
	public Stack() {
		list = new List<T>();
	}
	
	public void push(T elem) {
		list.insert(elem, 0);
	}
	
	public T pop() {
		if (isEmpty()) {
			throw new EmptyStackException();
		} else {
			T elem = list.getFirst().getData();
			list.remove(0);
			return elem;
		}
	}
	
	public T top() {
		if (isEmpty()) {
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
