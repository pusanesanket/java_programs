@SuppressWarnings("unchecked")
public class DynamicArray<T> {
	private int length;
	private T[] array;
	private int capacity;

	public DynamicArray() {
		this(16);
	}

	public DynamicArray(int capacity) {
		if(capacity<0) throw new IllegalArgumentException("Illegal Capacity : "+capacity);
		this.capacity = capacity;
		array = (T[])new Object[capacity];

	}

	public int size() {
		return length;
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	public T get(int index) {
		if(index<0 || index>length) {
			throw new IndexOutOfBoundsException();
		}
		return array[index];
	}

	public void set(int index,T element) {
		array[index] = element;
	}

	public void add(T element) {
		if(length+1 >= capacity) {
			if(capacity == 0)
				capacity = 1;
			else
				capacity *= 2;
			T[] new_array = (T[]) new Object[capacity];
			for(int index=0;index<length;index++) {
				new_array[index] = array[index];
			}
			array = new_array;
		}
		array[length] = element;
		length++;
	}

	public T removeAt(int rm_index) {
		if(rm_index<0 || rm_index>length) {
			throw new IndexOutOfBoundsException();
		}
		T data = array[rm_index];
		T[] new_array = (T[]) new Object[length-1];
		for(int i = 0 ,j = 0 ;i<length; i++,j++) {
			if(rm_index == i)
				j--;
			else
				new_array[j] = array[i];

		}
		array = new_array;
		length--;
		return data;
	}

	public boolean remove(Object obj) {
		int index = indexOf(obj);
		if(index == -1) {
			return false;
		}
		removeAt(index);
		return true;
	}

	public int indexOf(Object obj) {
		for(int index=0;index<length;index++) {
			if(obj == null) {
				if(array[index] == null) {
					return index;
				}
			}else {
				if(obj.equals(array[index]))
					return index;
			}
		}
		return -1;
	}

	public boolean contains(Object obj) {
		return indexOf(obj)!=-1;
	}

	public void clear() {
		for(int index=0;index<length;index++) {
			array[index] = null;
		}
		length = 0;
	}

}
