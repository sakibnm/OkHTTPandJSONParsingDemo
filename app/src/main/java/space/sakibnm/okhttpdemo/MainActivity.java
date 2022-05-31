package space.sakibnm.okhttpdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class MainActivity extends AppCompatActivity {

    private final OkHttpClient client = new OkHttpClient();
    private final String TAG = "demo";

    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        getPerson();

    }

    private void getPerson(){

        Log.d(TAG, "getContacts: Started!");
        Request request = new Request.Builder()
                .url("https://www.theappsdr.com/persons/json")
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                if(response.isSuccessful()){
//                    String string = response.body().string();
                    Gson gsonData = new Gson();
                    Persons persons =  gsonData.fromJson(response.body().charStream(), Persons.class);
                    Log.d(TAG, "onResponse: "+persons.toString());
                }else{
                    Log.d(TAG, "onResponse: "+response.body().string());
                }
            }
        });
        Log.d(TAG, "getContacts: Ended!");
    }


}