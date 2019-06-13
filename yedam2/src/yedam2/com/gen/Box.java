package yedam2.com.gen;

public class Box<T> {
//	private Object object;
	private T object;
	public void set(T object) { 
		this.object = object;
	}
	
	public T get() {
		return object;
	}
	
	public String toString() {
		
		return (String)object;
	}
}
