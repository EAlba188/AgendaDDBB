package com.example.practicabbddcarmelo.db;

import android.app.Application;
import android.content.Context;

import androidx.lifecycle.LiveData;

import java.util.List;

public class Repository {

    private AppDatabase repositoryDB;
    private LiveData<List<User>> liveUserList;
    private UserDao userDao;

    public Repository(Context context){
        Context appContext = context.getApplicationContext();
        repositoryDB = AppDatabase.getDbInstance(context);
        userDao = repositoryDB.userDao();

        liveUserList = userDao.getAllLive();
    }

    public LiveData<List<User>> getLiveUserList(){
        return liveUserList;
    }


    public void insert(User user){
        ThreadExecutor.threadExecutor.execute(new Runnable() {
            @Override
            public void run() {
                userDao.insertUser(user);
            }
        });
    }

    public void delete(int id){
        ThreadExecutor.threadExecutor.execute(new Runnable() {
            @Override
            public void run() {
                userDao.supUser(id);
            }
        });
    }

    public void updateFirstName(String arg, int id){
        ThreadExecutor.threadExecutor.execute(new Runnable() {
            @Override
            public void run() {
                userDao.updateFirstname(arg, id);
            }
        });
    }

    public void updateLastName(String arg, int id){
        ThreadExecutor.threadExecutor.execute(new Runnable() {
            @Override
            public void run() {
                userDao.updateLastname(arg, id);
            }
        });
    }

    public void updatePhone(String arg, int id){
        ThreadExecutor.threadExecutor.execute(new Runnable() {
            @Override
            public void run() {
                userDao.updatePhone(arg, id);
            }
        });
    }

    public void updateBday(String arg, int id){
        ThreadExecutor.threadExecutor.execute(new Runnable() {
            @Override
            public void run() {
                userDao.updateBday(arg, id);
            }
        });
    }

    public void updateLocation(String arg, int id){
        ThreadExecutor.threadExecutor.execute(new Runnable() {
            @Override
            public void run() {
                userDao.updateLocation(arg, id);
            }
        });
    }

    public void updateStreet(String arg, int id){
        ThreadExecutor.threadExecutor.execute(new Runnable() {
            @Override
            public void run() {
                userDao.updateStreet(arg, id);
            }
        });
    }

    public void updateNumber(String arg, int id){
        ThreadExecutor.threadExecutor.execute(new Runnable() {
            @Override
            public void run() {
                userDao.updateNumber(arg, id);
            }
        });
    }




}
