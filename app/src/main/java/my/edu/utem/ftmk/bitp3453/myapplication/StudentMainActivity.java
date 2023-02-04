package my.edu.utem.ftmk.bitp3453.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Vector;

import my.edu.utem.ftmk.bitp3453.myapplication.databinding.ActivityStudentMainBinding;

public class StudentMainActivity extends AppCompatActivity {

    ActivityStudentMainBinding activityStudentMainBinding;
    Student student;

    Vector<Student> students;
    StudentAdapter studentAdapter;

    DatePickerDialog datePickerDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityStudentMainBinding = ActivityStudentMainBinding.inflate(getLayoutInflater());
        setContentView(activityStudentMainBinding.getRoot());

        activityStudentMainBinding.fabAdd.setOnClickListener(this::Add);

        activityStudentMainBinding.edtBirth.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                final Calendar calendar = Calendar.getInstance();
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                int month = calendar.get(Calendar.MONTH);
                int year = calendar.get(Calendar.YEAR);

                int mHour = calendar.get(Calendar.HOUR);
                int mMinute = calendar.get(Calendar.MINUTE);
                String strDay = "";
                datePickerDialog = new DatePickerDialog(StudentMainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        activityStudentMainBinding.edtBirth.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
                    }
                }, year, month, day);
                datePickerDialog.show();
            }
        });

        students = new Vector<>();
        studentAdapter = new StudentAdapter(getLayoutInflater(), students);

        activityStudentMainBinding.rcvStud.setAdapter(studentAdapter);
        activityStudentMainBinding.rcvStud.setLayoutManager(new LinearLayoutManager(this));

    }


    private void Add(View view) {
        String fullname = activityStudentMainBinding.edtFullName.getText().toString();
        String studNo = activityStudentMainBinding.studentNumber.getText().toString();
        String email = activityStudentMainBinding.edtEmail.getText().toString();
        String birth = activityStudentMainBinding.edtBirth.getText().toString();
        String gender = "";
        String state = activityStudentMainBinding.spnState.getSelectedItem().toString();

        if (activityStudentMainBinding.rbMale.isChecked())
            gender = activityStudentMainBinding.rbMale.getText().toString();
        else if (activityStudentMainBinding.rbFemale.isChecked())
            gender = activityStudentMainBinding.rbFemale.getText().toString();

        student = new Student(fullname, studNo, email, birth, gender, state);

        students.add(student);
        studentAdapter.notifyItemInserted(students.size());
    }
}