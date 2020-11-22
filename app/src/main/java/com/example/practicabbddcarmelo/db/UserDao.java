package com.example.practicabbddcarmelo.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface UserDao {

    @Query("SELECT * FROM user")
    List<User> getAllUsers();

    @Insert
    void insertUser(User... users);

    @Delete
    void delete(User user);

    @Query("DELETE FROM user WHERE uid = :id")
    void supUser(int id);

    @Query("SELECT * FROM user WHERE uid= :id")
    User getIdData(int id);

    @Query("UPDATE user SET first_name= :fn WHERE uid= :id")
    void updateFirstname(String fn, int id);

    @Query("UPDATE user SET last_name= :fn WHERE uid= :id")
    void updateLastname(String fn, int id);

    @Query("UPDATE user SET phone_number= :fn WHERE uid= :id")
    void updatePhone(String fn, int id);

    @Query("UPDATE user SET birth_date= :fn WHERE uid= :id")
    void updateBday(String fn, int id);

    @Query("UPDATE user SET location= :fn WHERE uid= :id")
    void updateLocation(String fn, int id);

    @Query("UPDATE user SET street= :fn WHERE uid= :id")
    void updateStreet(String fn, int id);

    @Query("UPDATE user SET number= :fn WHERE uid= :id")
    void updateNumber(String fn, int id);


}
