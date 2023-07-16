package com.example.myapplication;

import android.annotation.SuppressLint;
import android.nfc.Tag;
import android.os.AsyncTask;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;



public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    String[] countryNames = {"INR","AED","AFN","ALL","AMD","ANG","AOA","ARS","AUD","AZN","BAM","BBD","BDT","BGN","BHD","BIF","BMD","BND","BOB","BRL","BSD","BTC","BWP","BYN","BZD","CAD","CDF","CHF","CLF","CNY","COP","CRC","CUP","CVE","CZK","DJF","DKK","DOP","DZD","EGP","ETB","EUR","FJD","FKP","GMD","GNF","GTQ","GYD","HKD","HNL","HRK","HTG","HUF","IDR","ILS","IQD","IRR","ISK","JMD","JOD","JPY","KES","KGS","KHR","KPW","KRW","KWD","KYD","LAL","LBP","LKR","LRD","LVL","LYD","MAD","MDL","MGA","MMK","MNT","MRO","MVR","MWK","MXN","MYR","MZN","NAD","NGN","NIO","NOK","NPR","NZD","OMR","PAB","PEN","PGK","PHP","PLN","PYG","QAR","RON","RSD","RUB","RWF","SAR","SBD","SCR","SDG","SEK","SGD","SLL","SOS","SRD","SVC","SYP","SZL","THB","TMT","TND","TRY","TTD","TWD","TZS","UAH","UGX","USD","UYU","UZS","VEF","VND","VUV"};
    int[] flags = {R.drawable.download,R.drawable.uae, R.drawable.afghan, R.drawable.albania,R.drawable.almenia,R.drawable.nether,R.drawable.angola,R.drawable.argentina,R.drawable.maxresdefault,R.drawable.azerbaijan,R.drawable.bosnia,R.drawable.barbados,R.drawable.bangladesh,R.drawable.bulgaria,R.drawable.bahrain,R.drawable.burund,R.drawable.bermuda,R.drawable.brunei,R.drawable.bolivia,R.drawable.brazil,R.drawable.bahamas,R.drawable.bitcoin,R.drawable.botswana,R.drawable.belarus,R.drawable.belize,R.drawable.canada,R.drawable.congo,R.drawable.switzerland,R.drawable.chile,R.drawable.china,R.drawable.colombia,R.drawable.costa,R.drawable.cuba,R.drawable.capeverde,R.drawable.czech,R.drawable.djibout,R.drawable.denmark,R.drawable.dominic,R.drawable.algeria,R.drawable.egypt,R.drawable.ethopia,R.drawable.oip,R.drawable.figi,R.drawable.falkland,R.drawable.gambia,R.drawable.guinea,R.drawable.guatemela,R.drawable.guyana,R.drawable.hongkong,R.drawable.hondura,R.drawable.croatia,R.drawable.haitia,R.drawable.hungary,R.drawable.indonesia,R.drawable.israel,R.drawable.iraq,R.drawable.iran,R.drawable.iceland,R.drawable.jamaica,R.drawable.jordon,R.drawable.japa,R.drawable.kenya,R.drawable.krygstan,R.drawable.cambodia,R.drawable.northkorea,R.drawable.southkorea,R.drawable.kuwait,R.drawable.cayman,R.drawable.lao,R.drawable.lebanon,R.drawable.srilanka,R.drawable.liberia,R.drawable.latvia,R.drawable.libya,R.drawable.morocco,R.drawable.moldova,R.drawable.macedona,R.drawable.myanmar,R.drawable.mongolia,R.drawable.mauritus,R.drawable.maldives,R.drawable.malavi,R.drawable.mexico,R.drawable.malyasia,R.drawable.mozmbique,R.drawable.nambia,R.drawable.nigeria,R.drawable.nicagura,R.drawable.norwegia,R.drawable.nepal,R.drawable.newzealand,R.drawable.oman,R.drawable.panama,R.drawable.peru,R.drawable.papau,R.drawable.philphine,R.drawable.poland,R.drawable.paraguay,R.drawable.qatar,R.drawable.qatar,R.drawable.serbia,R.drawable.russia_flag,R.drawable.rwanda,R.drawable.saudiarabia,R.drawable.solomon,R.drawable.seychelles,R.drawable.sudan,R.drawable.sweden,R.drawable.singapore,R.drawable.sierralonne,R.drawable.somalia,R.drawable.suriname,R.drawable.salvador,R.drawable.syria,R.drawable.swaziland,R.drawable.thailand,R.drawable.turkmenistan,R.drawable.tunisia,R.drawable.turkey,R.drawable.trindadtobago,R.drawable.taiwan,R.drawable.tanzania,R.drawable.ukraine,R.drawable.uganda,R.drawable.usa,R.drawable.uruguay,R.drawable.uzbekistan,R.drawable.venezula,R.drawable.vietnam,R.drawable.vanautu};
    String [] countries={"india","uae","afghanistan","albania","armenia","netherlands","angola","argentina","australia","azerbaijan","bosnia","barbados","bangladesh","bulgaria","bahrain","burund","bermuda","brunei","bolivia","brazil","bahamas","bitcoin","botswana","belarus","belize","canada","congo","switzerland","chile","china","colombia","costa rica","cuba","capeverde","czech republic","DJibout","denmark","dominic","algeria","egypt","ethopia","euro","fiji","falkland","gambia","guinea","guatamela","guyana","hong kong","hondura","croatia","haitia","hungary","indonesia","israel","iraq","iran","iceland","jamaica","jordon","japan","kenya","krygstan","combodia","north korea","south korea","kuwait","cayman islands","lao","lebanon","sri lanka","liberia","latvia","libya","morocco","moldova","macedona","myanmar","mongolia","maurituis","maldives","malavi","mexico","malyasia","mozimbique","nambia","nigeria","nicagura","norwegia","nepal","new zealand","oman","panama","peru","papau new guinea","philipine","poland","paraguay","qatar","romania","serbia","russia","rwanda","saudi arabia","solomon islands","seychelles","sudan","sweden","singapore","sierraleone","somalia","suriname","salvador","syria","swaziland","thailand","turkmenistan","tunisia","turkey","trindad and tobago","taiwan","tanzania","ukraine","uganda","usa","uruguay","uzbekistan","venezula","vietnam","vanatu"};
    Float[] values = {70.8f, 3.2f, 4.1f, 5.0f, 7.0f, 8.0f};
    Float den;
    String base = "GBP";
    String low = "INR";
    String got;
    Float fgh = 0.0f;
    @Override
    public void finishAndRemoveTask() {
        super.finishAndRemoveTask();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





        EditText dollarText = findViewById(R.id.den);


        Spinner spin = (Spinner) findViewById(R.id.spinner);
        Spinner spins = (Spinner) findViewById(R.id.spinner2);
        spins.setOnItemSelectedListener(this);
        spin.setOnItemSelectedListener(this);
        customadapter Customadapter = new customadapter(getApplicationContext(), flags, countryNames,countries);
        spin.setAdapter(Customadapter);
        spins.setAdapter(Customadapter);

        Toast.makeText(getApplicationContext(), "asdaasd", Toast.LENGTH_SHORT).show();



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);


        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onItemSelected(AdapterView<?> parent, View arg1, int position, long id) {



        if(parent.getId()== R.id.spinner) {
            base = countryNames[position];
            async runner = new async();
            runner.execute(got);

        }
            else
            {
                low = countryNames[position];
                async runner = new async();
                runner.execute(got);

            }
        }









    public void onNothingSelected(AdapterView<?> arg0) {
// TODO Auto-generated method stub

    }

    public void convertCurrency(View view) {

        EditText dollarText = findViewById(R.id.den);
        TextView textView = findViewById(R.id.textView);
        Spinner spin = (Spinner) findViewById(R.id.spinner);


        if (!dollarText.getText().toString().equals("")) {

            Float dollarValue = Float.valueOf(dollarText.getText().toString());
            Float euroValue;
            euroValue = dollarValue * fgh;
            textView.setText(euroValue.toString());
        } else {
            textView.setText("No Value");
        }
    }
    private class async extends AsyncTask<String, String,String> {


        protected String doInBackground(String... params) {

            String api = "https://api.ratesapi.io/api/latest?base=USD&symbols="+ low +"";

           TextView textVies = findViewById(R.id.textView5);
            String des="";
             String sersfe="";
            String fullstory="" ;
            try {


                URL url = new URL("https://prepaid.currconv.com/api/v7/convert?apiKey=pr_2409656a70314552a4fb0dd20549ddd7&q="+base+"_"+low+"&compact=y");
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();

                BufferedReader buffer = new BufferedReader(new InputStreamReader(conn.getInputStream()));

                fullstory= buffer.readLine();
                des = fullstory.substring(18,24);

                fgh = Float.parseFloat(des);





            } catch (MalformedURLException e) {

            } catch (Exception e) {
                Log.e("tag", "sdaadaasd", e);

            }
            return  fullstory;
        }

        protected void onPostExecute(String result) {



        }

        protected void onPreExecute() {
        }

        public void cancel() {
        }
    }



}