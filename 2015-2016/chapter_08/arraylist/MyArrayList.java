package arraylist;

public class MyArrayList<E>
{
	private Object[] a;
	private int size;

	public MyArrayList()
	{
	    a = new Object[10];
	    size = 0;
	}

	public MyArrayList(int initialCapacity)
	{
		if (initialCapacity < 0) // Replace this with the correct condition
			throw new IllegalArgumentException();
		else
			a = new Object[initialCapacity];
		size = 0;
	}

	public int size()
	{
		return size;
	}

    public E get(int index)
	{
    	E returnedobject = null;
    	
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException();
		else
			returnedobject = (E)a[index];
		
		return returnedobject;
		
		// Note: You must cast the reference from the array to type E.
		// For example, to return element 6 from a: return (E) a[6];
		
	}

	public E set(int index, E element)
	{
		E retobj = null;
		
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException();
		else 
		{
			retobj = (E)a[index];
			a[index ] = element;
		}
		return retobj;
	}

	public boolean contains(Object elem)
	{
		boolean containselement = false;
		for(int i = 0; i < size; i++)
		{
			if(elem.equals(a[i]))
				containselement = true;
		}	
		return containselement;
	}

	public void trimToSize()
	{
		if (size < a.length)
		{
			Object[] temp = new Object[size];
			System.arraycopy(a, 0, temp, 0, size);
			a = temp;
		}
		
//		for(int i = 0; i < size; i++)
//			a[i] = a[i];
	}

	public void add(E elem)
	{
		add(size, elem);
	}

	public void add(int index, E element)
	{
		if (index < 0 || index > size())
			throw new IndexOutOfBoundsException();
		
		else 
		{
			if(size >= a.length)
			{
				Object[] temp = a;
				
				a = new Object[a.length * 2 + 1];
				
				System.arraycopy(temp, 0, a, 0, size);
			}
			
			System.arraycopy(a, index, a, index + 1, size - index);
			a[index] = element;	
			size++;
		}
	}

	public E remove(int index)
	{
		E removedobj = null;
		if (index < 0 || index >= size )
			throw new IndexOutOfBoundsException();
		else
		{
			removedobj = (E)a[index];
			System.arraycopy(a, index + 1, a, index, size - 1 - index);
			size--;
		}
		return removedobj;
	}

	public boolean remove(Object elem)
	{
		boolean elemfound = false;
		for(int i = 0; i < size; i++)
		{
			if(elem.equals(a[i]) && !elemfound)
			{
				remove(i);
				elemfound = true;
			}
		}
		return elemfound;
	}
	
}
