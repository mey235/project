package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class historyofcurrencies extends AppCompatActivity {
    String [] currenc ={" IND"," RUB"," USD","JPY","EUR","CNY","BRL","AUD","CAD"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historyofcurrencies);
        ListView le = (ListView) findViewById(R.id.listview1);
        ArrayAdapter<String> ar = new ArrayAdapter<>(historyofcurrencies.this, android.R.layout.simple_dropdown_item_1line,currenc);
        le.setAdapter(ar);

        le.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0)
                {
                    Intent is = new Intent(historyofcurrencies.this,IND.class);
                    startActivity(is);
                }
                else if(position==1)
                {
                    Intent is = new Intent(historyofcurrencies.this,RUBE.class);
                    startActivity(is);
                }
                else if(position==2)
            {
                Intent is = new Intent(historyofcurrencies.this,USD.class);
                startActivity(is);
            }

            }
        });
    }
}