package com.example.retrofit_api;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    androidx.recyclerview.widget.RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        final ListView view=findViewById(R.id.listview);
recyclerView=findViewById(R.id.recycleview);
        Retrofit retro=new Retrofit.Builder().
                baseUrl("https://jsonplaceholder.typicode.com").
                addConverterFactory(GsonConverterFactory.create()).build();
        RequestInterface requestInterface=retro.create(RequestInterface.class);
        Call<List<hero>> listCall=requestInterface.getjson();
        listCall.enqueue(new Callback<List<hero>>() {
            @Override
            public void onResponse(Call<List<hero>> call, Response<List<hero>> response) {
                Log.d("response",response.message());
            Toast.makeText(getApplicationContext(), response.body().toString(),Toast.LENGTH_LONG).show();
                List<hero> heroes=response.body();
recyclerView.setHasFixedSize(true);
recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                ArrayList<hero> list=new ArrayList<>();
                for (int i=0;i<heroes.size();i++)
                {
                    String userid=heroes.get(i).getUserid();
                    String id=heroes.get(i).getId();
                    String title=heroes.get(i).getTitle();
                    String body=heroes.get(i).getBody();
list.add(new hero(userid,id,title,body));


                }
DataAdapter dataAdapter=new DataAdapter(list);
                recyclerView.setAdapter(dataAdapter);


                /*for (hero h:heroes)
                {
                    Log.d("userid",h.getUserid());
                    Log.d("id",h.getId());
                    Log.d("title",h.getTitle());
                    Log.d("body",h.getBody());
                }*/
            }

            @Override
            public void onFailure(Call<List<hero>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "network connection lost", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
