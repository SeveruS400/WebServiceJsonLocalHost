package com.teknodate.webservicejsonlocalhost;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnSorgula;
    EditText pid;
    RequestQueue mQueue;
    Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSorgula = findViewById(R.id.btnSorgula);
        btnSorgula.setOnClickListener(this);
        pid = findViewById(R.id.pid);

        mQueue = Volley.newRequestQueue(context);
    }

    @Override
    public void onClick(View v) {
        int productId = Integer.parseInt(pid.getText().toString());
        String url="http://";
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject jsonObject) {
                //Toast.makeText(context, "Başarılı", Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                //Toast.makeText(context, "Hata", Toast.LENGTH_SHORT).show();
            }
        });
        mQueue.add(request);
    }
}
