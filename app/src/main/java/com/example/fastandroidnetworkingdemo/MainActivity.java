package com.example.fastandroidnetworkingdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONArrayRequestListener;

import org.json.JSONArray;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AndroidNetworking.initialize(getApplicationContext());


        AndroidNetworking.get("https://api.apis.guru/v2/list.json")
                //.addPathParameter("pageNumber", "0")
                //.addQueryParameter("limit", "3")
                //.addHeaders("token", "1234")
                //.setTag("test")
                .setPriority(Priority.LOW)
                .build()
                .getAsJSONArray(new JSONArrayRequestListener() {
                    @Override
                    public void onResponse(JSONArray response) {
                        // do anything with response

                    }
                    @Override
                    public void onError(ANError error) {
                        // handle error
                    }
                });

    }
}
