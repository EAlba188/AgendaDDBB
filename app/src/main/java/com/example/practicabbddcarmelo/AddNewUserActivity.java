package com.example.practicabbddcarmelo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.practicabbddcarmelo.db.AppDatabase;
import com.example.practicabbddcarmelo.db.User;

public class AddNewUserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_user);

        final EditText firstNameInput = findViewById(R.id.firstNameInput);
        final EditText lastNameInput = findViewById(R.id.lastNameInput);
        final EditText phoneNumberInput = findViewById(R.id.phoneNumberInput);
        final EditText birthDateInput = findViewById(R.id.birthDateInput);
        final EditText locationInput = findViewById(R.id.locationInput);
        final EditText streetInput = findViewById(R.id.streetInput);
        final EditText numberInput = findViewById(R.id.numberInput);

        Button saveButton = findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveNewUser(firstNameInput.getText().toString(), lastNameInput.getText().toString(),
                        phoneNumberInput.getText().toString(), birthDateInput.getText().toString(),
                        locationInput.getText().toString(), streetInput.getText().toString(),
                        numberInput.getText().toString());
            }
        });
    }

    private void saveNewUser(String firstName, String lastname, String phone, String birth, String location, String street, String number){
        AppDatabase db = AppDatabase.getDbInstance(this.getApplicationContext());

        User user = new User();
        user.firstName = firstName;
        user.lastName = lastname;
        user.phoneNumber = phone;
        user.birthDate = birth;
        user.location = location;
        user.street = street;
        user.number = number;
        db.userDao().insertUser(user);
        finish();
    }











}