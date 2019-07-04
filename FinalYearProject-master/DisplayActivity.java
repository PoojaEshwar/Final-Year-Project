package com.example.finalyearproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.widget.Toast.LENGTH_SHORT;

public class DisplayActivity extends AppCompatActivity {

    List<Activities> activity_list;
    ListView listView;
    private Retrofit retrofit;
    Bundle bundle;
    ArrayList<AndroidVersion> json;
    private OkHttpClient client;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        String url = "http://127.0.0.1:5000/appname/activity";
        activity_list = new ArrayList<>();

        retrofit = new Retrofit.Builder().baseUrl(Retrofit_API.base_url).addConverterFactory(GsonConverterFactory.create()).build();
        Retrofit_API api = retrofit.create(Retrofit_API.class);

        Call<ResponseBody> call = api.predict_activity();
        Log.e("REST RESPONSE", "Connected");

        call.enqueue(new Callback<ResponseBody>()
        {
            @Override
            public void onResponse(Call<ResponseBody> call, retrofit2.Response<ResponseBody> response) {

                JSONArray jsonArray = null;


                try {

                    jsonArray = new JSONArray(response.body().string());
                    int count=0;
                    while(count<jsonArray.length()){
                        JSONObject jsonObject = jsonArray.getJSONObject(count);
                        Activities activities = new Activities(R.drawable.example,jsonObject.getString("Name"),jsonObject.getString("Area"),jsonObject.getString("Description"));
                        activity_list.add(activities);
                        Log.e("REST RESPONSE", jsonObject.toString());
                        count++;


                    }

                    listView = (ListView) findViewById(R.id.activity_list_view);
                    ListViewAdapter listViewAdapter = new ListViewAdapter(getApplicationContext(),R.layout.activity_display_on_preference,activity_list);
                    listView.setAdapter(listViewAdapter);

                }
                catch (Exception e)
                {
                    System.out.println("Error : "+e);
                }

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                t.printStackTrace();
            }
        });



    }
}
