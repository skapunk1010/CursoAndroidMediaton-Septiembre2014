package com.example.corruptusinextremis.practica05_listview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class MyActivity extends Activity {
    private ListView listView;
    private ListViewAdapter adapter;
    private ArrayList<Item> lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);


        lista = new ArrayList<Item>();
        lista.add(new Item("Australia","Es una islota",false,R.drawable.australia));
        lista.add(new Item("Belgica","Es pais europeo",true, R.drawable.belgium));
        lista.add(new Item("Bolivia","Está en centroamerica", true, R.drawable.bolivia));
        lista.add(new Item("Chile","Chile chilenos", true, R.drawable.chile));
        lista.add(new Item("Costa rica","Ticos", false, R.drawable.costa_rica));
        lista.add(new Item("Cuba","Es una isla chiquita", false, R.drawable.cuba));
        lista.add(new Item("Alemania","Es potencia",true,R.drawable.germany));
        lista.add(new Item("Honduras","Está en el caribe",false, R.drawable.honduras));
        lista.add(new Item("México","Awuevo!!",true,R.drawable.mexico));

        //Declaramos nuestro adapter
        adapter = new ListViewAdapter(this,lista);

        //Asignamos adapter a nuestro listview
        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int position, long l) {
                Toast.makeText(getApplicationContext()," Posicion:"+position, Toast.LENGTH_LONG).show();
                Intent i = new Intent();
                Item item = new Item("titulo","descripcion",false,R.id.titulo);
                //Mandar objeto a Activity por un Intent
                //i.putExtra("objeto",item);
                ///Recuperar objeto en Activity por un Intent
                //i.getBundleExtra("objeto");

            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
