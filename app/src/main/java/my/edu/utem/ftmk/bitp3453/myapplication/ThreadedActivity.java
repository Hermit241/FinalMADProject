package my.edu.utem.ftmk.bitp3453.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;

import my.edu.utem.ftmk.bitp3453.myapplication.databinding.ActivityThreadedBinding;

public class ThreadedActivity extends AppCompatActivity {

    ActivityThreadedBinding threadedBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        threadedBinding = ActivityThreadedBinding.inflate(getLayoutInflater());
        setContentView(threadedBinding.getRoot());

        Intent intent = getIntent();

        String strMsg = intent.getStringExtra("strName");
        threadedBinding.tv1.setText("Welcome to the second activity, " + strMsg);

        threadedBinding.btnTakePic.setOnClickListener(this::fnTakePic);
    }

    private void fnTakePic(View view) {
        Runnable run = new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 0);

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        threadedBinding.tv1.setText(threadedBinding.tv1.getText().toString()
                                + "\n.. This is your picture heheh...");
                    }
                });
            }
        };
        Thread thread = new Thread(run);
        thread.start();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Bitmap bp = (Bitmap) data.getExtras().get("data");
        threadedBinding.imgVwProfile.setImageBitmap(bp);
    }
}