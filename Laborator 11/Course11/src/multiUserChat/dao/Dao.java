package multiUserChat.dao;

import java.util.List;
import java.util.Optional;

//Data Access Object - abstract API that performs CRUD operations on objects of generic type
//keeps the domain model completely decoupled from the persistence layer

public interface Dao<T> {

    List<T> getAll();

    Optional<T> getByUsername(String username);

    void update(T t);

    void save(T t);

    void delete(T t);
}
