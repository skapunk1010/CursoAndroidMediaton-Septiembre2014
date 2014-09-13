package com.example.corruptusinextremis.practica04_intent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MyActivity extends Activity implements OnClickListener{
    private EditText editNombre;
    private EditText editEscuela;
    private Button btnAceptar;
    private TextView txtResultado;

    private final int REQUEST_SALUDO = 0x03123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        editNombre = (EditText)findViewById(R.id.editNombre);
        editEscuela = (EditText)findViewById(R.id.editNombreEscuela);
        btnAceptar 	= (Button)findViewById(R.id.btnAceptar);
        btnAceptar.setOnClickListener(this);
        txtResultado = (TextView)findViewById(R.id.txtResultado);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent i) {
        if(requestCode == 1){
            if(resultCode == RESULT_OK){
                Toast.makeText(getApplicationContext(),"Regreso exitosamente de la activity",Toast.LENGTH_LONG).show();
            } else if(resultCode == RESULT_CANCELED){
                Toast.makeText(getApplicationContext(),"Se canceló la segunda activity",Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    public void onClick(View view) {
        // TODO Auto-generated method stub

        switch(view.getId())
        {
            case R.id.btnAceptar:
                String nombre = editNombre.getText().toString();
                String escuela = editEscuela.getText().toString();
                editNombre.setText("");
                editEscuela.setText("");
                //txtResultado.setText("Me llamo "+nombre+" y estudio en "+escuela );

                /************* Practica 04 a partir de aquí ***********/

                Intent i = new Intent(this.getApplicationContext(),SegundaActivity.class);

                i.putExtra("nombre",nombre);
                i.putExtra("escuela",escuela);

                startActivityForResult(i,1);

                break;
        }
    }

}
