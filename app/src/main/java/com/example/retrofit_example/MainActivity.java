package com.example.retrofit_example;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView textView = findViewById(R.id.tv1);

        NetworkService.getInstance()
                .getJSONApi()
                .getPostWithID(1)
                   .enqueue(new Callback<Post>() {
                    @Override
                    public void onResponse(Call<Post> call, Response<Post> response) {
                        Post post = response.body();
                        textView.append(post.getId() + "\n");
                        textView.append(post.getUserId() + "\n");
                        textView.append(post.getTitle() + "\n");
                        textView.append(post.getBody() + "\n");
                    }

                    @Override
                    public void onFailure(Call<Post> call, Throwable t) {
                        textView.append("Error occurred while getting request!");
                        t.printStackTrace();
                    }


                });

    }
}