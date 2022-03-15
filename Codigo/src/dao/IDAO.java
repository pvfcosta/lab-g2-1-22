package dao;

import java.util.List;

public interface IDAO<T> {
	public void add(T p);
	public T get(T p);
	public void update(T p);
	public void delete(T p);
	public List<T> getAll();
}
