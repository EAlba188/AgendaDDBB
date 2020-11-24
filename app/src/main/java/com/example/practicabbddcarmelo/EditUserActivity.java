package com.example.practicabbddcarmelo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.practicabbddcarmelo.db.AppDatabase;
import com.example.practicabbddcarmelo.db.User;
import com.example.practicabbddcarmelo.viewmodel.ViewModel;

import java.util.List;

public class EditUserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_user);
        Bundle data = this.getIntent().getExtras();

        TextView tvId = findViewById(R.id.idCheck);
        tvId.setText("Id: "+(data.getString("id")));


        TextView firstName = findViewById(R.id.editName);
        TextView lastName = findViewById(R.id.editLastname);
        TextView phoneNumber = findViewById(R.id.editPhone);
        TextView birthDate = findViewById(R.id.editBirth);
        TextView location = findViewById(R.id.editLocation);
        TextView street = findViewById(R.id.editStreet);
        TextView number = findViewById(R.id.editNumber);

        Button btVolver = findViewById(R.id.btVolver);
        Button changeFirstname = findViewById(R.id.changeFirstname);
        Button changeLastname = findViewById(R.id.changeLastname);
        Button changePhone = findViewById(R.id.changePhone);
        Button changeBday = findViewById(R.id.changeBday);
        Button changeLocation = findViewById(R.id.changeLocation);
        Button changeStreet = findViewById(R.id.changeStreet);
        Button changeNumber = findViewById(R.id.changeNumber);

        AppDatabase db = AppDatabase.getDbInstance(this.getApplicationContext());
        int finalID = Integer.parseInt(data.getString("id"));

        User user = new User();
        user = db.userDao().getIdData(finalID);
        firstName.setText(user.firstName);
        lastName.setText(user.lastName);
        phoneNumber.setText(user.phoneNumber);
        birthDate.setText(user.birthDate);
        location.setText(user.location);
        street.setText(user.street);
        number.setText(user.number);

        btVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        changeFirstname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                builder.setTitle("Cambiar nombre");
                String nuevo = firstName.getText().toString();
                builder.setMessage("¿Cambiar a "+nuevo+"?");
                builder.setPositiveButton("Guardar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        ViewModel v = new ViewModel(getApplication());
                        v.updateFirstName(nuevo, finalID, getApplicationContext());

                        Toast.makeText(EditUserActivity.this, "Guardado con exito", Toast.LENGTH_SHORT).show();

                    }
                });

                builder.setNegativeButton("Cancelar",null);

                AlertDialog alert = builder.create();
                builder.show();
            }
        });

        changeLastname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                builder.setTitle("Cambiar nombre");
                String nuevo = lastName.getText().toString();
                builder.setMessage("¿Cambiar a "+nuevo+"?");
                builder.setPositiveButton("Guardar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        ViewModel v = new ViewModel(getApplication());
                        v.updateLastName(nuevo, finalID, getApplicationContext());
                        Toast.makeText(EditUserActivity.this, "Guardado con exito", Toast.LENGTH_SHORT).show();
                    }
                });

                builder.setNegativeButton("Cancelar",null);

                AlertDialog alert = builder.create();
                builder.show();
            }
        });

        changePhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                builder.setTitle("Cambiar nombre");
                String nuevo = phoneNumber.getText().toString();
                builder.setMessage("¿Cambiar a "+nuevo+"?");
                builder.setPositiveButton("Guardar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        ViewModel v = new ViewModel(getApplication());
                        v.updatePhone(nuevo, finalID, getApplicationContext());
                        Toast.makeText(EditUserActivity.this, "Guardado con exito", Toast.LENGTH_SHORT).show();
                    }
                });

                builder.setNegativeButton("Cancelar",null);

                AlertDialog alert = builder.create();
                builder.show();
            }
        });

        changeBday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                builder.setTitle("Cambiar nombre");
                String nuevo = birthDate.getText().toString();
                builder.setMessage("¿Cambiar a "+nuevo+"?");
                builder.setPositiveButton("Guardar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        ViewModel v = new ViewModel(getApplication());
                        v.updateBday(nuevo, finalID, getApplicationContext());
                        Toast.makeText(EditUserActivity.this, "Guardado con exito", Toast.LENGTH_SHORT).show();
                    }
                });

                builder.setNegativeButton("Cancelar",null);

                AlertDialog alert = builder.create();
                builder.show();
            }
        });

        changeLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                builder.setTitle("Cambiar nombre");
                String nuevo = location.getText().toString();
                builder.setMessage("¿Cambiar a "+nuevo+"?");
                builder.setPositiveButton("Guardar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        ViewModel v = new ViewModel(getApplication());
                        v.updateLocation(nuevo, finalID, getApplicationContext());
                        Toast.makeText(EditUserActivity.this, "Guardado con exito", Toast.LENGTH_SHORT).show();
                    }
                });

                builder.setNegativeButton("Cancelar",null);

                AlertDialog alert = builder.create();
                builder.show();
            }
        });

        changeStreet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                builder.setTitle("Cambiar nombre");
                String nuevo = street.getText().toString();
                builder.setMessage("¿Cambiar a "+nuevo+"?");
                builder.setPositiveButton("Guardar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        ViewModel v = new ViewModel(getApplication());
                        v.updateStreet(nuevo, finalID, getApplicationContext());
                        Toast.makeText(EditUserActivity.this, "Guardado con exito", Toast.LENGTH_SHORT).show();
                    }
                });

                builder.setNegativeButton("Cancelar",null);

                AlertDialog alert = builder.create();
                builder.show();
            }
        });

        changeNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                builder.setTitle("Cambiar nombre");
                String nuevo = number.getText().toString();
                builder.setMessage("¿Cambiar a "+nuevo+"?");
                builder.setPositiveButton("Guardar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        ViewModel v = new ViewModel(getApplication());
                        v.updateNumber(nuevo, finalID, getApplicationContext());
                        Toast.makeText(EditUserActivity.this, "Guardado con exito", Toast.LENGTH_SHORT).show();
                    }
                });

                builder.setNegativeButton("Cancelar",null);

                AlertDialog alert = builder.create();
                builder.show();
            }
        });







    }
}