package arraylist;

public class MyArrayList2<E>
{
	private Object[] a;
	private int size;

	public MyArrayList2(){
		a = new Object[10];
	}

	public MyArrayList2(int initialCapacity){
		if (initialCapacity<0) 
			throw new IllegalArgumentException();
		
		else 
			a = new Object[initialCapacity];
	}
	
	public int size(){
		return size;
	}

    public E get(int index){
		if (index < 0 || index >= size())
			throw new IndexOutOfBoundsException();
		
		else
			return (E) a[index];
	}

	public E set(int index, E element){
		E toReturn;
		
		if (index < 0 || index >= size())
			throw new IndexOutOfBoundsException();
		
		toReturn = get(index);
		a[index] = element;
		
		return toReturn;
	}

	public boolean contains(Object elem){
		for (int i = 0; i < size(); i++)
			if (get(i).equals(elem))
				return true;
		
		return false;
	}

	public void trimToSize(){
		if (size < a.length){
			Object[] temp = new Object [size];
			System.arraycopy(a, 0, temp, 0, size);
			a=temp;
		}
	}

	public void add(E elem){
		add (size, elem);
	}

	public void add(int index, E element){
		if (index < 0 || index > size())
			throw new IndexOutOfBoundsException();
		
		if (size >= a.length){
			Object[] temp= new Object[a.length * 2 + 1];

			System.arraycopy(a, 0, temp, 0, index);
			System.arraycopy(a, index, temp, index + 1, size -index);
			
			a = temp;
		}
		
		else
			System.arraycopy(a, index, a, index + 1, size -index);
		
		a[index]=element;
		size++;
	}

	public E remove(int index){
		if (index < 0 || index >= size())
			throw new IndexOutOfBoundsException();
		
		
		E toRemove = get(index);
		
		System.arraycopy(a, index + 1, a, index, size - index - 1);
		size--;
		a [size] = null;
		
		return toRemove;
		
	}

	public boolean remove(Object o){
		if (contains(o)){
			for (int i = 0; i< size; i++){
				if (a[i].equals(o)){
					remove(i);
					return true;
				}
			}
		}
		
		return false;
	}
}
