package com.example.corruptusinextremis.practica06_database;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


public class MainActivity extends Activity implements OnClickListener{
    private EditText editCodigo,editNombre,editTelefono,editApellido,editEdad;
    private Button btnSelect,btnUpdate,btnInsert,btnDelete,btnClear;
    private RadioGroup grupoSexo;
    private RadioButton sexoSeleccionado;

    private MyOpenHelper helper;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editCodigo = (EditText)findViewById(R.id.editCodigo);
        editNombre = (EditText)findViewById(R.id.editNombre);
        editTelefono  = (EditText)findViewById(R.id.editTelefono);
        editApellido = (EditText)findViewById(R.id.editApellido);
        editEdad = (EditText)findViewById(R.id.editEdad);

        btnSelect = (Button) findViewById(R.id.btnSelect);
        btnInsert= (Button) findViewById(R.id.btnInsert);
        btnUpdate = (Button) findViewById(R.id.btnUpdate);
        btnDelete = (Button) findViewById(R.id.btnDelete);
        btnClear = (Button) findViewById(R.id.btnClear);

        btnInsert.setOnClickListener(this);
        btnSelect.setOnClickListener(this);
        btnDelete.setOnClickListener(this);
        btnClear.setOnClickListener(this);
        btnUpdate.setOnClickListener(this);

        grupoSexo = (RadioGroup)findViewById(R.id.RadioSexo);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btnInsert:
                insertar();
                break;
            case R.id.btnSelect:
                selecccionar();
                break;
            case R.id.btnDelete:
                eliminar();
                break;
            case R.id.btnUpdate:
                actualizar();
                break;
            case R.id.btnClear:
                limpiar();
                break;
            default:
                break;
        }
    }

    public void insertar(){
        //Creamos objeto de nuestro helper
        helper = new MyOpenHelper(this);
        db = helper.getWritableDatabase();

        //Recuperamos datos
        ContentValues values = new ContentValues();
        values.put("nombre",editNombre.getText().toString());
        values.put("apellido",editApellido.getText().toString());
        values.put("codigo",editCodigo.getText().toString());

        sexoSeleccionado = (RadioButton) findViewById(grupoSexo.getCheckedRadioButtonId());

        values.put("sexo",sexoSeleccionado.getText().toString());
        values.put("telefono",editTelefono.getText().toString());
        values.put("edad",editEdad.getText().toString());

        //Limpiamos campos
        limpiar();

        //Insertamos el registro en la BD
        db.insert("Alumno", null, values);
        db.close();
        Toast.makeText(getApplicationContext(), "Datos insertados correctamente!",Toast.LENGTH_SHORT).show();
    }

    public void actualizar(){
        //Creamos objeto de nuestro helper
        helper = new MyOpenHelper(this);
        db = helper.getWritableDatabase();

        //Recuperamos datos
        ContentValues values = new ContentValues();
        values.put("nombre",editNombre.getText().toString());
        values.put("apellido",editApellido.getText().toString());
        String codigo = editCodigo.getText().toString();
        values.put("codigo",codigo);
        //sexoSeleccionado = (RadioButton) findViewById(grupoSexo.getCheckedRadioButtonId());
        //values.put("sexo",sexoSeleccionado.getText().toString());
        values.put("telefono",editTelefono.getText().toString());
        values.put("edad",editEdad.getText().toString());

        //Limpiamos campos
        limpiar();

        //Actiualizamos el registro en la BD. Nos regresa entero mayot a ceri si lo hizo correctamente!
        int x = db.update("Alumno", values, "codigo = ?",new String[]{codigo});
        if(x > 0){
            Toast.makeText(getApplicationContext(), "Datos actualizados correctamente!",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(getApplicationContext(), "Hubo errores al actualizar!",Toast.LENGTH_SHORT).show();
        }

        db.close();

    }

    public void eliminar(){
        //Creamos objeto de nuestro helper
        helper = new MyOpenHelper(this);
        db = helper.getWritableDatabase();

        //Recuperamos datos
        String codigo = editCodigo.getText().toString();

        //Limpiamos campos
        limpiar();

        //Actiualizamos el registro en la BD
        int x = db.delete("Alumno","codigo = ?", new String[]{codigo});

        if(x > 0){
            Toast.makeText(getApplicationContext(), "Datos borrados correctamente!",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(getApplicationContext(), "Hubo errores al intentar eliminar!",Toast.LENGTH_SHORT).show();
        }

        db.close();
    }

    public void selecccionar(){
        //Creamos objeto de nuestro helper
        helper = new MyOpenHelper(this);
        db = helper.getReadableDatabase();

        //Recuperamos codigo
        String codigo = editCodigo.getText().toString();

        Cursor cursor = db.rawQuery("SELECT * FROM Alumno WHERE codigo = ?",new String[]{codigo});

        if(cursor.moveToFirst()){
            editNombre.setText(cursor.getString(2));
            editApellido.setText(cursor.getString(3));
            editTelefono.setText(cursor.getString(4));
            editEdad.setText(cursor.getString(6));

            Toast.makeText(getApplicationContext(),"SEXO:"+cursor.getString(5),Toast.LENGTH_LONG).show();
        } else{
            Toast.makeText(getApplicationContext(),"No hubo coincidencias!",Toast.LENGTH_LONG).show();
        }
        db.close();
    }

    public void limpiar(){
        editTelefono.setText("");
        editCodigo.setText("");
        editApellido.setText("");
        editEdad.setText("");
        editNombre.setText("");
        grupoSexo.clearCheck();
    }

}
