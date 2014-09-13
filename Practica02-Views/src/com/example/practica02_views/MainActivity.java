package com.example.practica02_views;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener{
	private EditText editNombre;
	private EditText editEscuela;
	private Button btnAceptar;
	private TextView txtResultado;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        editNombre = (EditText)findViewById(R.id.editNombre);
        editEscuela = (EditText)findViewById(R.id.editNombreEscuela);
        btnAceptar 	= (Button)findViewById(R.id.btnAceptar);
        btnAceptar.setOnClickListener(this);
        txtResultado = (TextView)findViewById(R.id.txtResultado);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
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
				txtResultado.setText("Me llamo "+nombre+" y estudio en "+escuela );
				break;
		}
	}
    
}
