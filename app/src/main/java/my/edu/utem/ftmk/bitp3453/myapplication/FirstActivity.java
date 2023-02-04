package my.edu.utem.ftmk.bitp3453.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import my.edu.utem.ftmk.bitp3453.myapplication.databinding.ActivityFirstBinding;

public class FirstActivity extends AppCompatActivity {

    ActivityFirstBinding firstBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        firstBinding = ActivityFirstBinding.inflate(getLayoutInflater());
        setContentView(firstBinding.getRoot());

        firstBinding.btnMe.setOnClickListener(this::fnGreet);

        firstBinding.btnActivity.setOnClickListener(this::fnThreadedActivity);
    }

    private void fnGreet(View view) {
        String strName = firstBinding.edtTxtName.getText().toString();
        int yearBorn = Integer.parseInt(firstBinding.edtYear.getText().toString());
        Calendar calendar = new GregorianCalendar();
        int age = calendar.get(Calendar.YEAR) - yearBorn;

        firstBinding.txtvwAge.setText("Hello and welcome " + strName + ". You are " + age + " years old.");
    }

    private void fnThreadedActivity(View view) {
        Intent intent = new Intent(this, ThreadedActivity.class);
        String strMsg = firstBinding.edtTxtName.getText().toString();
        intent.putExtra("strName", strMsg);
        startActivity(intent);
    }

}