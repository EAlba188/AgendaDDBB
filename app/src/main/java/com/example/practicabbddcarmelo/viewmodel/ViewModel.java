package com.example.practicabbddcarmelo.viewmodel;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.practicabbddcarmelo.MainActivity;
import com.example.practicabbddcarmelo.db.Repository;
import com.example.practicabbddcarmelo.db.User;

import java.util.List;

public class ViewModel extends AndroidViewModel {

    private Repository repository;
    private LiveData<List<User>> listLiveData;


    public ViewModel(@NonNull Application application){
        super(application);
        repository = new Repository(application);
        listLiveData = repository.getLiveUserList();

    }


    public LiveData<List<User>> getListLiveData(){
        return listLiveData;
    }

    public void insert(User user, Context context){
        repository.insert(user);
    }

    public void delete(int id, Context context){
        repository.delete(id);
    }

    public void updateFirstName(String arg ,int id, Context context){
        repository.updateFirstName(arg, id);
    }

    public void updateLastName(String arg ,int id, Context context){
        repository.updateLastName(arg, id);
    }

    public void updatePhone(String arg ,int id, Context context){
        repository.updatePhone(arg, id);
    }

    public void updateBday(String arg ,int id, Context context){
        repository.updateBday(arg, id);
    }

    public void updateLocation(String arg ,int id, Context context){
        repository.updateLocation(arg, id);
    }

    public void updateStreet (String arg ,int id, Context context){
        repository.updateStreet(arg, id);
    }

    public void updateNumber(String arg ,int id, Context context){
        repository.updateNumber(arg, id);
    }

}
