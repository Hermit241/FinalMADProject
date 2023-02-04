package my.edu.utem.ftmk.bitp3453.myapplication;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class StudentViewHolder extends RecyclerView.ViewHolder {

    private final TextView lblFullName,
            lblStudNo,
            lblGender,
            lblBirthdate,
            lblEmail,
            lblState;

    public StudentViewHolder(@NonNull View itemView) {
        super(itemView);
        this.lblFullName = itemView.findViewById(R.id.lblFullname);
        this.lblStudNo = itemView.findViewById(R.id.lblStudNo);
        this.lblEmail = itemView.findViewById(R.id.lblEmail);
        this.lblBirthdate = itemView.findViewById(R.id.lblBirthdate);
        this.lblGender = itemView.findViewById(R.id.lblGender);
        this.lblState = itemView.findViewById(R.id.lblState);
    }

    public void setStudent(Student student){
        lblFullName.setText(student.getStrFullname());
        lblStudNo.setText(student.getStrStudNo());
        lblEmail.setText(student.getStrEmail());
        lblBirthdate.setText(student.getStrBirthdate());
        lblGender.setText(student.getStrGender());
        lblState.setText(student.getStrState());
    }
}
