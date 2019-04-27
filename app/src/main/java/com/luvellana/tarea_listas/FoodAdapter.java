package com.luvellana.tarea_listas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import com.luvellana.tarea_listas.R;

public class FoodAdapter extends BaseAdapter {

    private Context context;
    private List<Food> items;

    public FoodAdapter(Context context, List<Food> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Food getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return items.get(position).getId();
    }

    @Override
    public View getView(int position, View vista, ViewGroup parent) {
        ViewHolder viewHolder;
        if (vista == null) { //No se puede reciclar
            viewHolder = new ViewHolder();

            //Inflater nos permite usar un layout dentro de un componente
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            vista = inflater.inflate(R.layout.layout_song, null); //Cual layout y principal o no.

            viewHolder.image = vista.findViewById(R.id.image);
            viewHolder.precio = vista.findViewById(R.id.songArtist);
            viewHolder.nombrePlato = vista.findViewById(R.id.sontTitle);
            vista.setTag(viewHolder); //Guardar para reciclar
        } else {
            viewHolder = (ViewHolder) vista.getTag(); //Obtener el dato reciclado
        }

        Food cancionActual = items.get(position);
        viewHolder.nombrePlato.setText(cancionActual.getNombrePlato());
        viewHolder.precio.setText(cancionActual.getPrecio());
        viewHolder.image.setImageResource(cancionActual.getCoverImage());
        return vista;
    }

    static class ViewHolder {
        ImageView image;
        TextView nombrePlato;
        TextView precio;
    }
}
