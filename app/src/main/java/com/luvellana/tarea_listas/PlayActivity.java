package com.luvellana.tarea_listas;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;

public class PlayActivity extends AppCompatActivity {
    private Context mContext;

    private ImageView image;

    private TextView nombre;
    private TextView precio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
        initViews();
        modifyContent();
        receiveData();
    }

    private void initViews() {
        image = findViewById(R.id.cover);
        nombre = findViewById(R.id.nombre);
        precio = findViewById(R.id.precio);
    }


    private void modifyContent() {
        nombre.setText("Hamburguesa");
        image.setImageResource(R.drawable.crash);
        precio.setText("20.50");
    }

    private void receiveData() {
        Intent intent = getIntent();
        String json = intent.getStringExtra(Constants.KEY_PLATO);
        Food plato = new Gson().fromJson(json, Food.class);
        nombre.setText(plato.getNombrePlato());
        image.setImageResource(plato.getCoverImage());
        precio.setText((int) plato.getPrecio());
    }
}
