package com.luvellana.tarea_listas;

        import android.content.Context;
        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.AdapterView;
        import android.widget.ListView;

        import com.google.gson.Gson;

        import java.util.ArrayList;
        import java.util.List;

public class ListaActivity extends AppCompatActivity {

    private Context mContext;

    private ListView platos;
    private FoodAdapter FoodAdapter;

    private List<Food> foodArray = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);
        mContext = this;

        foodArray.add(new Food(1, R.drawable.hamburguesas , "Hamburguesa", 20.50));
        foodArray.add(new Food(1, R.drawable.alitas , "Alitas", 25.40));
        foodArray.add(new Food(1, R.drawable.hot_dog , "Hot Dog", 12.60));
        foodArray.add(new Food(1, R.drawable.nuggets , "Nuggets", 18.99));
        foodArray.add(new Food(1, R.drawable.papas , "Papas", 11.70));
        foodArray.add(new Food(1, R.drawable.pollo_frito , "Pollo Frito", 28.90));
        foodArray.add(new Food(1, R.drawable.salchipapas , "Salchipapas", 15.30));
        foodArray.add(new Food(1, R.drawable.sandwich , "Sandwich", 26.30));

        initViews();
        addEvents();
    }

    private void initViews() {

        platos = findViewById(R.id.plato);

        FoodAdapter = new FoodAdapter(mContext, foodArray);
        platos.setAdapter(FoodAdapter);
    }

    private void addEvents() {

        platos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Food plato = foodArray.get(position);
                Intent intent = new Intent(mContext, PlayActivity.class);
                intent.putExtra(Constants.KEY_PLATO, new Gson().toJson(plato));
                startActivity(intent);
            }
        });
    }



}
