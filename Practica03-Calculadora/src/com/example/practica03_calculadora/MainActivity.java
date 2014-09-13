package com.example.practica03_calculadora;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity implements OnClickListener{
	//Botones para los números
	private Button btn1;
	private Button btn2;
	private Button btn3;
	private Button btn4;
	private Button btn5;
	private Button btn6;
	private Button btn7;
	private Button btn8;
	private Button btn9;
	private Button btn0;
	
	//Botones para las operaciones
	private Button btnSumar;
	private Button btnRestar;
	private Button btnMultiplicar;
	private Button btnDividir;
	private Button btnIgual;
	private Button btnLimpiar;
	
	//EditText del resultado
	private EditText resultado;
	
	//Resultado temporal
	private int temporal;
	private int operacion;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        btn0	= (Button)findViewById(R.id.btn0);
        btn1	= (Button)findViewById(R.id.btn1);
        btn2	= (Button)findViewById(R.id.btn2);
        btn3	= (Button)findViewById(R.id.btn3);
        btn4	= (Button)findViewById(R.id.btn4);
        btn5	= (Button)findViewById(R.id.btn5);
        btn6	= (Button)findViewById(R.id.btn6);
        btn7	= (Button)findViewById(R.id.btn7);
        btn8	= (Button)findViewById(R.id.btn8);
        btn9	= (Button)findViewById(R.id.btn9);
        
        btnSumar = (Button)findViewById(R.id.btnSuma);
        btnRestar = (Button)findViewById(R.id.btnResta);
        btnMultiplicar = (Button)findViewById(R.id.btnMultiplicar);
        btnDividir = (Button)findViewById(R.id.btnDividir);
        btnIgual = (Button)findViewById(R.id.btnIgual);
        btnLimpiar = (Button)findViewById(R.id.btnLimpiar);
        
        resultado = (EditText)findViewById(R.id.editResultado);
        
        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btnSumar.setOnClickListener(this);
        btnMultiplicar.setOnClickListener(this);
        btnRestar.setOnClickListener(this);
        btnDividir.setOnClickListener(this);
        btnIgual.setOnClickListener(this);
        btnLimpiar.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId())
		{
			case R.id.btn0: resultado.append("0");break;
			case R.id.btn1: resultado.append("1");break;
			case R.id.btn2: resultado.append("2");break;
			case R.id.btn3: resultado.append("3");break;
			case R.id.btn4: resultado.append("4");break;
			case R.id.btn5: resultado.append("5");break;
			case R.id.btn6: resultado.append("6");break;
			case R.id.btn7: resultado.append("7");break;
			case R.id.btn8: resultado.append("8");break;
			case R.id.btn9: resultado.append("9");break;
			
			case R.id.btnSuma: 
					operacion = 1;
					break;
			case R.id.btnResta: 
					operacion = 2;
					break;
			case R.id.btnMultiplicar: 
					operacion = 3;
					break;
			case R.id.btnDividir: 
					operacion = 4;
					break;
			case R.id.btnIgual:
					operacion = 5;
					break;
			case R.id.btnLimpiar: 
					operacion = 6;
					break;
			
			default: break;
		}
		hacerOperacion(operacion);
	}
	
	public void hacerOperacion(int x){
		switch(x)
		{
			//Suma
			case 1: 
				temporal += Integer.parseInt(resultado.getText().toString());
				resultado.setText("");
				break;
			//Resta
			case 2: 
				temporal -= Integer.parseInt(resultado.getText().toString());
				resultado.setText("");
				break;
			//Multiplica
			case 3: temporal *= Integer.parseInt(resultado.getText().toString());
				resultado.setText("");
				break;
			//Divide
			case 4: temporal /= Integer.parseInt(resultado.getText().toString());
				resultado.setText("");
				break;
			//Igual
			case 5:
				temporal = 0;
				break;
			//Limpiar
			case 6:
				temporal = 0;
				resultado.setText(""); 
				break;
			default: break;
		}
	}

    
}

















