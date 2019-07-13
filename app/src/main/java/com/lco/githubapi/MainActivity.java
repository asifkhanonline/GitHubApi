package com.lco.githubapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.JsonArray;
import com.google.gson.JsonIOException;
import com.lco.githubapi.Model.User;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    List<User> user;
    String URL_Data="https://api.github.com/users";
    RequestQueue reqQue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recyclerView);
       recyclerView.setHasFixedSize(true);
       recyclerView.setLayoutManager(new LinearLayoutManager(this));
       recyclerView.setItemAnimator(new DefaultItemAnimator());
       recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        user=new ArrayList<>();
        loadurl();


    }
    public void loadurl(){
        JsonArrayRequest sttringRequest=new JsonArrayRequest(URL_Data, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                getValue(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }

    });
        reqQue= Volley.newRequestQueue(this);
        reqQue.add(sttringRequest);
    }
    public void getValue(JSONArray array){
        for(int i=0; i< array.length(); i++){
            User userlist=new User();
            JSONObject json=null;
            try {
                json=array.getJSONObject(i);
                userlist.setLogin(json.getString("login"));
                userlist.setAvatarUrl(json.getString("avatar_url"));

            }catch (JsonIOException | JSONException e){
                e.printStackTrace();
            }
            user.add(userlist);

        }
        adapter=new CourseAdapter(user,this);
        recyclerView.setAdapter(adapter);
    }

}
