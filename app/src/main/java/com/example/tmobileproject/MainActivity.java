package com.example.tmobileproject;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.StrictMode;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.JobIntentService;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Subject> subjectList;
    Context activity = this;
    ImageView img;
    RecyclerView recyclerView;
    List<String> sujeto;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        img =findViewById(R.id.img);
        recyclerView = findViewById(R.id.recycleview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(activity);
        recyclerView.setLayoutManager(linearLayoutManager);

        AsyncTaskclass asyncTaskclass = new AsyncTaskclass();
        asyncTaskclass.execute();




    }





    class AsyncTaskclass extends AsyncTask<Object, Void, Bitmap> {

        @SuppressLint("WrongThread")
        @Override
        protected Bitmap doInBackground(Object[] objects) {
            try {
                InputStream is = getResources().openRawResource(R.raw.codebeautify);
                int sizeFile = is.available();
                byte[] buffer = new byte[sizeFile];
                is.read(buffer);
                is.close();
                String json = new String(buffer, "UTF-8");
                JSONObject cards, card, atributes, font, title, description, font_description, title_1;
                try {
                    JSONArray jsonArray = new JSONArray(json);
                    subjectList = new ArrayList<>();
                    sujeto = new ArrayList<>();
                    for (int i = 0; i < jsonArray.length(); i++) {
                        Subject subject = new Subject();
                        cards = jsonArray.getJSONObject(i);
                        String card_type;
                        switch (i) {
                            case 0:
                                Log.d("codigo", "" + i);
                                card_type = cards.getString("card_type");
                                Log.e("card_type", "" + card_type);
                                card = cards.getJSONObject("card");


                                //get value
                                String value = card.getString("value");
                                Log.e("value", value);


                                //get attributes
                                atributes = card.getJSONObject("attributes");
                                //Log.e("attributes", ""+ atributes);

                                //get text_color
                                String text_color = atributes.getString("text_color");
                                Log.e("text_color", text_color);

                                //get font
                                font = atributes.getJSONObject("font");
                                //Log.d("font", ""+font);

                                //get size
                                String size = font.getString("size");
                                Log.e("font", "" + size);

                                //subject.setTexto1(cards.getString("card_type"));
                                subject.setTexto2(card.getString("value"));
                                subject.setTexto_color(text_color);
                                subject.setText_size(size);

                                subjectList.add(subject);
                                break;
                            case 1:
                                Log.d("codigo", "" + i);
                                card_type = cards.getString("card_type");
                                Log.e("card_type", "" + card_type);
                                card = cards.getJSONObject("card");


                                //Geting 1  of JSON
                                // Card tittle
                                title = card.getJSONObject("title");
                                //Log.d("title", ""+ title);

                                //get value
                                value = title.getString("value");
                                Log.e("value", value);


                                //get attributes
                                atributes = title.getJSONObject("attributes");
                                //Log.e("attributes", ""+ atributes);

                                //get text_color
                                text_color = atributes.getString("text_color");
                                Log.e("text_color", text_color);

                                //get font
                                font = atributes.getJSONObject("font");
                                //Log.d("font", ""+font);

                                //get size
                                size = font.getString("size");
                                Log.e("font size", "" + size);

                                description = card.getJSONObject("description");
                                //Log.e("font", "" + description);
                                String values_description = description.getString("value");
                                Log.e("value", "" + values_description);


                                JSONObject attributes_description = description.getJSONObject("attributes");
                                //Log.e("atribute", "" + attributes_description);

                                String text_color_description = attributes_description.getString("text_color");
                                Log.e("text_color", "" + text_color_description);

                                //get font
                                font_description = attributes_description.getJSONObject("font");
                                //Log.e("font", ""+font_description);

                                //get size
                                String size_description = font_description.getString("size");
                                Log.e("font size", "" + size_description);

                                //subject.setTexto1(cards.getString("card_type"));
                                subject.setTexto2(title.getString("value"));
                                subject.setTexto3(description.getString("value"));
                                subject.setTexto_color(text_color);
                                subject.setText_size(size);
                                subjectList.add(subject);
                                break;
                            case 2:
                                Log.d("codigo", "" + i);
                                card_type = cards.getString("card_type");
                                Log.e("card_type", "" + card_type);
                                card = cards.getJSONObject("card");


                                JSONObject image = card.getJSONObject("image");
                                //Log.e("image", ""+ image);

                                String url = image.getString("url");
                                Log.e("image", "" + url);

                                JSONObject sizeImage = image.getJSONObject("size");
                                //Log.e("image", ""+ sizeImage);

                                String width = sizeImage.getString("width");
                                Log.e("width", "" + width);

                                String height = sizeImage.getString("height");
                                Log.e("height", "" + height);

                                //Geting 1  of JSON
                                // Card tittle
                                JSONObject title_2 = card.getJSONObject("title");
                                //Log.d("title", ""+ title);

                                //get value
                                value = title_2.getString("value");
                                Log.e("value", value);

                                //get attributes
                                atributes = title_2.getJSONObject("attributes");
                                //Log.e("attributes", ""+ atributes);

                                //get text_color
                                text_color = atributes.getString("text_color");
                                Log.e("text_color", text_color);

                                //get font
                                font = atributes.getJSONObject("font");
                                //Log.d("font", ""+font);

                                //get size
                                size = font.getString("size");
                                Log.e("font size", "" + size);

                                description = card.getJSONObject("description");
                                //Log.e("font", "" + description);
                                values_description = description.getString("value");
                                Log.e("value", "" + values_description);

                                attributes_description = description.getJSONObject("attributes");
                                //Log.e("atribute", "" + attributes_description);

                                text_color_description = attributes_description.getString("text_color");
                                Log.e("text_color", "" + text_color_description);

                                //get font
                                font_description = attributes_description.getJSONObject("font");
                                //Log.e("font", ""+font_description);

                                //get size
                                size_description = font_description.getString("size");
                                Log.e("font size", "" + size_description);

                                String advertising = "In TMobile we appreciate you, and we don’t want that you miss the opportunity to see the new Movies in All The movies theaters of your city or whatever you there that the reason because we give you Discounts that you can loss. \n" +
                                        "If you are interested in this promotion please click in the next link and enjoy all the movies";
                                subject.setAdvert(advertising);

                                //subject.setTexto1(cards.getString("card_type"));
                                subject.setTexto2(title_2.getString("value"));
                                subject.setTexto3(description.getString("value"));
                                subject.setImage(url);
                                subject.setTexto_color(text_color);
                                subject.setText_size(size);

                                subjectList.add(subject);
                                break;
                            case 3:
                                Log.d("codigo", "" + i);
                                card_type = cards.getString("card_type");
                                Log.e("card_type", "" + card_type);
                                card = cards.getJSONObject("card");


                                //Geting 1  of JSON
                                // Card tittle
                                title_2 = card.getJSONObject("title");
                                //Log.d("title", ""+ title);

                                //get value
                                value = title_2.getString("value");
                                Log.e("value", value);

                                //get attributes
                                atributes = title_2.getJSONObject("attributes");
                                //Log.e("attributes", ""+ atributes);

                                //get text_color
                                text_color = atributes.getString("text_color");
                                Log.e("text_color", text_color);

                                //get font
                                font = atributes.getJSONObject("font");
                                //Log.d("font", ""+font);

                                //get size
                                size = font.getString("size");
                                Log.e("font size", "" + size);

                                description = card.getJSONObject("description");
                                //Log.e("font", "" + description);
                                values_description = description.getString("value");
                                Log.e("value", "" + values_description);

                                attributes_description = description.getJSONObject("attributes");
                                //Log.e("atribute", "" + attributes_description);

                                text_color_description = attributes_description.getString("text_color");
                                Log.e("text_color", "" + text_color_description);

                                //get font
                                font_description = attributes_description.getJSONObject("font");
                                //Log.e("font", ""+font_description);

                                //get size
                                size_description = font_description.getString("size");
                                Log.e("font size", "" + size_description);

                                //subject.setTexto1(cards.getString("card_type"));
                                subject.setTexto2(title_2.getString("value"));
                                subject.setTexto3(description.getString("value"));
                                subject.setTexto_color(text_color);
                                subject.setText_size(size);
                                subjectList.add(subject);
                                break;
                            case 4:
                                Log.d("codigo", "" + i);
                                card_type = cards.getString("card_type");
                                Log.e("card_type", "" + card_type);
                                card = cards.getJSONObject("card");


                                image = card.getJSONObject("image");

                                //Log.e("image", ""+ image);

                                url = image.getString("url");
                                Log.e("image", "" + url);

                                sizeImage = image.getJSONObject("size");
                                //Log.e("image", ""+ sizeImage);

                                width = sizeImage.getString("width");
                                Log.e("width", "" + width);

                                height = sizeImage.getString("height");
                                Log.e("height", "" + height);

                                //Geting 1  of JSON
                                // Card tittle
                                title_2 = card.getJSONObject("title");
                                //Log.d("title", ""+ title);

                                //get value
                                value = title_2.getString("value");
                                Log.e("value", value);

                                //get attributes
                                atributes = title_2.getJSONObject("attributes");
                                //Log.e("attributes", ""+ atributes);

                                //get text_color
                                text_color = atributes.getString("text_color");
                                Log.e("text_color", text_color);

                                //get font
                                font = atributes.getJSONObject("font");
                                //Log.d("font", ""+font);

                                //get size
                                size = font.getString("size");
                                Log.e("font size", "" + size);

                                description = card.getJSONObject("description");
                                //Log.e("font", "" + description);
                                values_description = description.getString("value");
                                Log.e("value", "" + values_description);

                                attributes_description = description.getJSONObject("attributes");
                                //Log.e("atribute", "" + attributes_description);

                                text_color_description = attributes_description.getString("text_color");
                                Log.e("text_color", "" + text_color_description);

                                //get font
                                font_description = attributes_description.getJSONObject("font");
                                //Log.e("font", ""+font_description);

                                //get size
                                size_description = font_description.getString("size");
                                Log.e("font size", "" + size_description);

                                advertising = "In TMobile we appreciate you, and we don’t want that you miss the opportunity to see the new Games of MLB in All The stadiums of your city or where ever you are, that the reason because we give you Discounts that you can't loss. \n" +
                                        "If you are interested in this promotion please click in the next link and enjoy all the Games of MLB";
                                subject.setAdvert(advertising);

                                //subject.setTexto1(cards.getString("card_type"));
                                subject.setTexto2(title_2.getString("value"));
                                subject.setTexto3(description.getString("value"));
                                subject.setImage(url);
                                subject.setTexto_color(text_color);
                                subject.setText_size(size);

                                subjectList.add(subject);
                                break;
                            case 5:
                                Log.d("codigo", "" + i);
                                card_type = cards.getString("card_type");
                                Log.e("card_type", "" + card_type);
                                card = cards.getJSONObject("card");


                                //Geting 1  of JSON
                                // Card tittle
                                title_1 = card.getJSONObject("title");
                                //Log.d("title", ""+ title);

                                //get value
                                value = title_1.getString("value");
                                Log.e("value", value);

                                //get attributes
                                atributes = title_1.getJSONObject("attributes");
                                //Log.e("attributes", ""+ atributes);

                                //get text_color
                                text_color = atributes.getString("text_color");
                                Log.e("text_color", text_color);

                                //get font
                                font = atributes.getJSONObject("font");
                                //Log.d("font", ""+font);

                                //get size
                                size = font.getString("size");
                                Log.e("font size", "" + size);

                                description = card.getJSONObject("description");
                                //Log.e("font", "" + description);
                                values_description = description.getString("value");
                                Log.e("value", "" + values_description);

                                attributes_description = description.getJSONObject("attributes");
                                //Log.e("atribute", "" + attributes_description);

                                text_color_description = attributes_description.getString("text_color");
                                Log.e("text_color", "" + text_color_description);

                                //get font
                                font_description = attributes_description.getJSONObject("font");
                                //Log.e("font", ""+font_description);

                                //get size
                                size_description = font_description.getString("size");
                                Log.e("font size", "" + size_description);

                                //subject.setTexto1(cards.getString("card_type"));
                                subject.setTexto2(title_1.getString("value"));
                                subject.setTexto3(description.getString("value"));
                                subject.setTexto_color(text_color);
                                subject.setText_size(size);
                                subjectList.add(subject);
                                break;
                        }
                        subject.setActivity((Activity) activity);
                        recyclerView.setAdapter(new ContentAdapter(subjectList, new ContentAdapter.OnItemClickListener()));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }


            return null;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            //img.setImageBitmap(bitmap);


        }
    }
}

