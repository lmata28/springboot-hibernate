package pe.edu.tecsup.hibernate.helper;

import java.util.List;

//T???.... maybe tabla
public interface GenericDAO<T> {

    public List<T> list();

    public T get(Long t);

    public void save(T t);

    public void update(T t);

    public void delete(T t);

}
