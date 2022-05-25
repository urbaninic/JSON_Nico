package com.example.json_nico;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {


    private Button btnRequest;
    private TextView textView;
    private RequestQueue queue;
    private StringRequest stringRequest;
    private String url = "https://run.mocky.io/v3/9b00d9bb-a55b-4a28-b80c-bc634df63d40";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnRequest = (Button) findViewById(R.id.button);
        textView = (TextView) findViewById(R.id.textView);
        btnRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getData();
            }
        });
    }

    private void getData()
    {
        // Creazione coda di richieste
        queue = Volley.newRequestQueue(this);

        // creazione coda richieste
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                // visualizzare risulato richiesta (Stringa cioe string response)
                textView.setText(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // visualizzare messaggio d'errore
                textView.setText("Errore");
            }
        });

        // aggiunta richiesta alla coda di una risorsa esterna http con il metodo get
        queue.add(stringRequest);

    }
}