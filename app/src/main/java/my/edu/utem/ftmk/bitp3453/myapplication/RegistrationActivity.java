package my.edu.utem.ftmk.bitp3453.myapplication;

import java.util.Calendar;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.ActionMenuView;
import android.widget.CalendarView;
import android.widget.DatePicker;

import my.edu.utem.ftmk.bitp3453.myapplication.databinding.ActivityRegistrationBinding;

public class RegistrationActivity extends AppCompatActivity {

    DatePickerDialog datePicker;
    ActivityRegistrationBinding registrationBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        registrationBinding = ActivityRegistrationBinding.inflate(getLayoutInflater());
        setContentView(registrationBinding.getRoot());
        registrationBinding.edtBirth.setOnFocusChangeListener(new View.OnFocusChangeListener(){

            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                fnInvokeDatePicker();
            }
        });

        registrationBinding.edtBirth.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                fnInvokeDatePicker();
            }
        });

        registrationBinding.fabAddUser.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(AllChecked()){
                    registrationBinding.fabAddUser.setEnabled(true);
                }
                else
                    registrationBinding.fabAddUser.setEnabled(false);
            }
        });
        registrationBinding.fabAddUser.setOnClickListener(this::fnAddUser);
    }

    private void fnInvokeDatePicker() {
        final Calendar cldr = Calendar.getInstance();
        int day = cldr.get(Calendar.DAY_OF_MONTH);
        int month = cldr.get(Calendar.MONTH);
        int year = cldr.get(Calendar.YEAR);
        datePicker = new DatePickerDialog(RegistrationActivity.this,
                new DatePickerDialog.OnDateSetListener(){
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        registrationBinding.edtBirth.setText(dayOfMonth + "/" + (month+1) + "/" + year);
                    }
                },year, month, day);
        datePicker.show();
    }

    private void fnAddUser(View view) {
        String strFullName = registrationBinding.edtFullname.getText().toString(),
                strPwd = registrationBinding.edtPwd.getText().toString(),
                strEmail = registrationBinding.edtEmail.getText().toString(),
                strBirth = registrationBinding.edtBirth.getText().toString(),
                strAddress = registrationBinding.edtAddress.getText().toString(),
                strGender = "";

        if(registrationBinding.rbMale.isChecked()){
            strGender = registrationBinding.rbMale.getText().toString();
        }else if (registrationBinding.rbFemale.isChecked()){
            strGender = registrationBinding.rbFemale.getText().toString();
        }

        User user = new User(strFullName, strPwd, strAddress, strEmail, strBirth, strGender);

        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("objUser", user);
        startActivity(intent);
    }

    private boolean AllChecked(){
        if(registrationBinding.edtFullname.getText().toString() == "")
            return false;
        else if(registrationBinding.edtPwd.getText().toString() == "")
            return false;
        else if(registrationBinding.edtBirth.getText().toString() == "")
            return false;
        else if(registrationBinding.edtEmail.getText().toString() == "")
            return false;
        else if(registrationBinding.edtAddress.getText().toString() == "")
            return false;
        else
            return true;
    }
}