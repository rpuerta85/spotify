package es.miw.spotify.models.daos;

import java.util.List;

public interface GenericDao<T, ID> {

    public void create(T entity);

    public T read(ID id);

    public void update(T entity);

    public void deleteById(ID id);

    public List<T> findAll();
    
  	public T readUUID(String idUUID);

}
