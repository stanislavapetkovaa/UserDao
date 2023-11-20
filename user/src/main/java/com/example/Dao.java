package com.example;
import java.util.List;
import java.util.Optional;

public interface Dao<T> {
    Optional<T> get(long id);
    List<T> getallUsers();
    void insertToDB(T t);
    void updateFirstName(T t,String updatedValue);
    void deleteUser(T t);
    void getUserById(int id);
    
}
