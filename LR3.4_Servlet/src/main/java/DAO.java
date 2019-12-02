import java.util.List;

public interface DAO<T> extends Iterable<T> {

    // TODO: dao, servlet, bus packages

    T getByID(long id);
    T getByPosition(int pos);

    List<T> getAsList();

    long add(T bus);
    boolean update(long id, T bus);
    boolean delete(long id);

    void refresh();
}
