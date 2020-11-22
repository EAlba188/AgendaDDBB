package com.example.practicabbddcarmelo.db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity
public class User {

    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo(name = "first_name")
    public String firstName;

    @ColumnInfo(name = "last_name")
    public String lastName;

    @ColumnInfo(name = "phone_number")
    public String phoneNumber;

    @ColumnInfo(name = "birth_date")
    public String birthDate;

    @ColumnInfo(name = "location")
    public String location;

    @ColumnInfo(name = "street")
    public String street;

    @ColumnInfo(name = "number")
    public String number;


}
