package my.edu.utem.ftmk.bitp3453.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import my.edu.utem.ftmk.bitp3453.myapplication.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    boolean clicked = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.button.setOnClickListener(click -> changeText());
    }

    public void changeText(){
        if(clicked) {
            binding.textView.setText(R.string.firstResponse);
        }else{
            binding.textView.setText(R.string.secondResponse);
        }
        clicked = !clicked;
    }
}