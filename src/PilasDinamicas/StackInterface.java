package PilasDinamicas;

public interface StackInterface<T> {
	
	public void clear();
	public boolean isEmpty();
	public Object peek();
	public Object pop();
	public boolean push(Object object);
	public int size();
	public boolean search(Object object);
	public void sort();
	public void reverse();
	public String toString();
	

}
