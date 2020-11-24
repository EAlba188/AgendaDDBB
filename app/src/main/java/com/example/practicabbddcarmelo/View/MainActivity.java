package com.example.practicabbddcarmelo.View;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.practicabbddcarmelo.R;
import com.example.practicabbddcarmelo.UserListAdapter;
import com.example.practicabbddcarmelo.db.User;
import com.example.practicabbddcarmelo.viewmodel.ViewModel;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    private UserListAdapter userListAdapter;
    private static ViewModel v;
    ArrayList<User> lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button addNewUserButton = findViewById(R.id.addNewUserButton);
        addNewUserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AddNewUserActivity.class));
            }

        });

        v = new ViewModelProvider(this).get(ViewModel.class);

        v.getListLiveData().observe(this, new Observer<List<User>>() {

            @Override
            public void onChanged(List<User> users) {
                lista = new ArrayList<>();
                for (int i = 0; i < users.size(); i++){
                    lista.add(users.get(i));
                }

                initRecyclerView();

            }
        });



    }





    private void initRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);
        userListAdapter = new UserListAdapter(this);



        userListAdapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                builder.setTitle("Opciones");
                builder.setMessage("¿Qué deseas hacer?");

                builder.setNegativeButton("Editar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(getApplicationContext(), EditUserActivity.class);

                        TextView preID = view.findViewById(R.id.tvId);
                        String id2 = preID.getText().toString();

                        intent.putExtra("id", id2);
                        startActivity(intent);

                    }
                });

                builder.setPositiveButton("Borrar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        TextView preID = view.findViewById(R.id.tvId);
                        String id2 = preID.getText().toString();
                        int id = Integer.parseInt(id2);
                        v = new ViewModel(getApplication());
                        v.delete(id, getApplicationContext());
                    }
                });

                builder.setNeutralButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });

                AlertDialog alert = builder.create();
                builder.show();
            }
        });

        recyclerView.setAdapter(userListAdapter);
        userListAdapter.setUserList(lista);
    }






}