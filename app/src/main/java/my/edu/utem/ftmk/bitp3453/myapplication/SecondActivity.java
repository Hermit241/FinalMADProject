package my.edu.utem.ftmk.bitp3453.myapplication;

import android.content.Intent;
import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;

import my.edu.utem.ftmk.bitp3453.myapplication.databinding.ActivitySecondBinding;

public class SecondActivity extends AppCompatActivity {

    ActivitySecondBinding secondBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        secondBinding = ActivitySecondBinding.inflate(getLayoutInflater());
        setContentView(secondBinding.getRoot());

        Intent intent = getIntent();
        User user = (User) intent.getSerializableExtra("objUser");

        secondBinding.txtRegistrationResult.setText("Here is your info:"
        + "\nName: " + user.getFullName()
        + "\nEmail: " + user.getEmail()
        + "\nPassword : " + user.getPwd()
        + "\nGender: " + user.getGender()
        + "\nBorn on: " + user.getBirthdate()
        + "\nAddress: "+ user.getAddress());

    }
}