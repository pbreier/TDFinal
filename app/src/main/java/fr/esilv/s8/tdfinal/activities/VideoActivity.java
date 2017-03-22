package fr.esilv.s8.tdfinal.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import fr.esilv.s8.tdfinal.Constants;
import fr.esilv.s8.tdfinal.R;
import fr.esilv.s8.tdfinal.adapters.VideoAdapter;
import fr.esilv.s8.tdfinal.interfaces.OnVideoSelectedListener;
import fr.esilv.s8.tdfinal.models.Item;
import fr.esilv.s8.tdfinal.models.ResponseGson;

public class VideoActivity extends AppCompatActivity implements OnVideoSelectedListener {

    private static final String YOUTUBE_URL = "https://www.googleapis.com/youtube/v3/search";
    private RecyclerView recyView;
    public static String VIDEO="VIDEO";
    private String recherche;



    public static void start(Context context, String recherche) {
        Intent intent = new Intent(context, VideoActivity.class);
        intent.putExtra(VIDEO, recherche);

        context.startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        recherche= getIntent().getStringExtra(VIDEO);
        recyView = (RecyclerView) findViewById(R.id.recyclerView);
        recyView.setLayoutManager(new LinearLayoutManager(this));
        getVideos();
    }

    private void getVideos() {

        StringRequest videosRequest = new StringRequest(YOUTUBE_URL + "?part=snippet&q="+recherche+"&type=video&key=" + Constants.API_KEY, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                if (response != null) {
                    ResponseGson videosGson = new Gson().fromJson(response, ResponseGson.class);
                    Log.d("test", String.valueOf(videosGson.getItems().size()));
                    setAdapter(videosGson);
                }
            }



        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Videos", "Error");
            }
        });




        Volley.newRequestQueue(this).add(videosRequest);
    }

    private void setAdapter(ResponseGson videosGson) {

        VideoAdapter adapter = new VideoAdapter(videosGson);
        adapter.setOnVideoSelectedListener(this);
        recyView.setAdapter(adapter);

    }
    @Override
    public void onVideoSelected(Item item){
        PlayerActivity.start(this, item);
        startActivity(new Intent(this, PlayerActivity.class));
    }


}
