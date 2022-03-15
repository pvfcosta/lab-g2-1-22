package dao;

import java.util.List;

public interface IDAO<T> {
	public void add(T s);
	public T get(T s);
	public void update(T s);
	public void delete(T s);
	public List<T> getAll();
}
