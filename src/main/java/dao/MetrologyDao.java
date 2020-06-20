package dao;


import java.util.List;

/**
 * MetrologyDao.
 * General interface for working with databases.
 * @author Aydar_Safiullin
 */
public interface MetrologyDao<T> {
    boolean addItem(T item);

    T getItemById(long id);

    boolean updateItemById(long id, T item);

    boolean deleteItemById(long id);

    List<T> getAllItems();
}
