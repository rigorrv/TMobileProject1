package com.example.tmobileproject;

import android.app.Activity;
import android.widget.ImageView;

public class Subject {
    public String texto1;
    public String texto2;
    public String texto3;
    public String image;
    public String texto_color;
    public String text_size;
    public String width_text;
    public String height_text;
    Activity activity;



    public String advert;



    public Subject() {
        this.texto1 = texto1;
        this.texto2 = texto2;
        this.texto3 = texto3;
        this.image = image;
        this.texto_color = texto_color;
        this.text_size = text_size;
        this.width_text = width_text;
        this.height_text = height_text;
        this.activity = activity;
        this.advert = advert;


    }

    public String getTexto1() {
        return texto1;
    }

    public void setTexto1(String texto1) {
        this.texto1 = texto1;
    }

    public String getTexto2() {
        return texto2;
    }

    public void setTexto2(String texto2) {
        this.texto2 = texto2;
    }

    public String getTexto3() {
        return texto3;
    }

    public void setTexto3(String texto3) {
        this.texto3 = texto3;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTexto_color() {
        return texto_color;
    }

    public void setTexto_color(String texto_color) {
        this.texto_color = texto_color;
    }

    public String getText_size() {
        return text_size;
    }

    public void setText_size(String text_size) {
        this.text_size = text_size;
    }

    public String getWidth_text() {
        return width_text;
    }

    public void setWidth_text(String width_text) {
        this.width_text = width_text;
    }

    public String getHeight_text() {
        return height_text;
    }

    public void setHeight_text(String height_text) {
        this.height_text = height_text;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public String getAdvert() {
        return advert;
    }

    public void setAdvert(String advert) {
        this.advert = advert;
    }

}

