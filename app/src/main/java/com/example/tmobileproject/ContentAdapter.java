package com.example.tmobileproject;

import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.net.URL;
import java.util.List;

public class ContentAdapter extends RecyclerView.Adapter<ContentAdapter.ViewHolder> {


    public static class OnItemClickListener {
        void onItemClick(Subject item, View view, int position) {

        }
    }

    private final List<Subject> list;
    private final OnItemClickListener listener;
    Bitmap bitmap;
    String urlImg;
    RelativeLayout layout;
    ViewGroup.LayoutParams params;
    Context activity;
    AlertDialog alertDialog;


    public ContentAdapter(List<Subject> list, OnItemClickListener listener) {
        this.list = list;
        this.listener = listener;
    }

    @Override public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.tmobil_list, parent, false);
        return new ViewHolder(v);
    }

    @Override public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(list.get(position), listener);
    }

    @Override public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView text1, text2, text3;
        private ImageView img;


        public ViewHolder(View itemView) {
            super(itemView);
            text1 = (TextView) itemView.findViewById(R.id.texto1);
            text2 = (TextView) itemView.findViewById(R.id.texto2);
            text3 = (TextView) itemView.findViewById(R.id.texto3);
            img = (ImageView) itemView.findViewById(R.id.img);
            layout = itemView.findViewById(R.id.layoutImg);



        }

        public void bind(final Subject item, final OnItemClickListener listener) {
            text1.setText(item.texto1);
            text2.setText(item.texto2);
            text3.setText(item.texto3);
            activity = item.activity;
            String msg = item.texto1;
            String font_size = item.text_size;
            String font_color = item.texto_color;
            final String adverTising = item.advert;
            int sizeFont = Integer.parseInt(font_size);
            text1.setTextSize(sizeFont);
            text2.setTextSize(sizeFont);
            text3.setTextSize(sizeFont);
            text1.setTextColor(Color.parseColor(font_color));
            text2.setTextColor(Color.parseColor(font_color));
            text3.setTextColor(Color.parseColor(font_color));
            urlImg = item.image;

            Log.d("urlImg", ""+urlImg);
            if (urlImg == null){
                params = layout.getLayoutParams();
                params.height = 100;
                layout.setLayoutParams(params);
            }else {
                img.setVisibility(View.VISIBLE);
                try {
                    URL url = new URL(urlImg);
                    bitmap = BitmapFactory.decodeStream(url.openConnection().getInputStream());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                img.setImageBitmap(bitmap);

            }
            if (item.texto1 == null){
                text1.setVisibility(View.GONE);
            }
            if (item.texto2 == null){
                text2.setVisibility(View.GONE);
            }
            if (item.texto3 == null){
                text3.setVisibility(View.GONE);
            }
            // Gets linearlayout





            itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    // get position
                    int pos = getAdapterPosition();

                    // check if item still exists
                    if(pos != RecyclerView.NO_POSITION){
                        Subject clickedDataItem = list.get(pos);
                        Log.d("Response", "Test");


                        new AlertDialog.Builder(activity)
                                .setTitle(clickedDataItem.getTexto2())
                                .setMessage(""+adverTising)
                                .setNeutralButton("Click here", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {

                                        String urlString = "https://www.t-mobile.com/coverage/4g-lte-5g-networks?ds_rl=1264241&ds_rl=1082060&ds_rl=1264208&cmpid=ADV_PB_P_EVGRNBHV_43700042487691056_439705554640&gclid=CjwKCAjwrvv3BRAJEiwAhwOdMwv-l1pXMv2sVL-RyLvwoKLzHrXWiomB-sme2-1_uIhhIAFAY__1fhoCylcQAvD_BwE&gclsrc=aw.ds";
                                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(urlString));
                                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                        intent.setPackage("com.android.chrome");
                                        try
                                        {
                                            activity.startActivity(intent);
                                        }
                                        catch (ActivityNotFoundException ex)
                                        {
                                            //if Chrome browser not installed
                                            intent.setPackage(null);
                                            activity.startActivity(intent);
                                        }

                                    }
                                })
                                .setPositiveButton(android.R.string.ok, null)
                                .show();
                    }
                }
            });
        }
    }
}