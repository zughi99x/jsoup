package com.example.jsoup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
CustomAdapterListview customAdapterListview;
ListView listView;
TextView textView;
ArrayList<TiengAnh> anhArrayList;
String url="https://www.youtube.com/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView =(ListView)findViewById(R.id.listView);
        textView=(TextView)findViewById(R.id.txtis);

        anhArrayList=new ArrayList<>();
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        StringRequest stringRequest=new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                textView.setText("thanh cong");
                String ten="";
                String Hinhanh="";
                Document document= Jsoup.parse(response);

            if(document!=null){
                Elements elements=document.select("div.lga  ");

                for (Element element:elements){
                    Element elementten = element.getElementsByTag("h3").first();
                    Element elementHinhanh=element.getElementsByTag("img").first();
                    if ( elementten!=null){
                        ten=elementten.text();

                    }
                    if (elementHinhanh!=null){
                        Hinhanh=elementHinhanh.attr("src");
                    }
                    anhArrayList.add(new TiengAnh(ten,Hinhanh));
                }
                customAdapterListview=new CustomAdapterListview(anhArrayList,MainActivity.this);
                listView.setAdapter(customAdapterListview);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                textView.setText("cos loi");

            }
        });
        requestQueue.add(stringRequest);
    }
}
