package com.example.lab6;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ProgressBar;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    private ImageView catImageView;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        catImageView = findViewById(R.id.catImageView);
        progressBar = findViewById(R.id.progressBar);

        CatImages catImagesTask = new CatImages();
        catImagesTask.execute();
    }

    private class CatImages extends AsyncTask<String, Integer, String> {
        private Bitmap currentCatImage;

        @Override
        protected String doInBackground(String... strings) {
            while (!isCancelled()) {
                try {
                    // Rest of the code...

                    // Update the ImageView on the UI thread
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            catImageView.setImageBitmap(currentCatImage);
                        }
                    });

                    // Rest of the code...
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return null; // This can be modified based on your requirements
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            // Update the ProgressBar with the current progress value
            progressBar.setProgress(values[0]);
        }
    }


}
