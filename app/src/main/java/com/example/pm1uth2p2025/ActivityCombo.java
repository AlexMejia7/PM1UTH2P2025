package com.example.pm1uth2p2025;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.pm1uth2p2025.Configuracion.Personas;
import com.example.pm1uth2p2025.Configuracion.SQLiteConexion;
import com.example.pm1uth2p2025.Configuracion.Transacciones;

import java.util.ArrayList;

public class ActivityCombo extends AppCompatActivity {

    SQLiteConexion conexion;

    Spinner combopersonas;

    EditText nombres,apellidos,correo;

    ArrayList<Personas> lista;

    ArrayList<String> Arreglolista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_combo);

       combopersonas = (Spinner) findViewById(R.id.spinner);
       nombres = (EditText) findViewById(R.id.cbnombre);
        apellidos = (EditText) findViewById(R.id.cbapellido);
        correo = (EditText) findViewById(R.id.cbcorreo);

        conexion = new SQLiteConexion(this, Transacciones.NameDB,null,1);

        ObtenerDatos();

        ArrayAdapter<CharSequence> adp = new ArrayAdapter(this, android.R.layout.simple_spinner_item,Arreglolista);

        combopersonas.setAdapter(adp);

    }

    private void ObtenerDatos()
    {
        SQLiteDatabase db = conexion.getReadableDatabase();
        Personas person = null;
        lista = new ArrayList<Personas>();

        Cursor cursor = db.rawQuery(Transacciones.SelectPersonas,null);

        while(cursor.moveToNext())

        {
            person = new Personas();
            person.setId(cursor.getInt(0));
            person.setNombres(cursor.getString(1));
            person.setApellidos(cursor.getString(2));
            person.setCorreo(cursor.getString(3));
            person.setTelefono(cursor.getString(4));

            lista.add(person);
        }
        cursor.close();

        FillData();
    }

    private void FillData()
    {
        Arreglolista = new ArrayList<String>();

        for(int i = 0; i< lista.size(); i++)
        {
            Arreglolista.add(lista.get(i).getNombres() + "\n" +
                    lista.get(i).getApellidos() +"\n" +
                    lista.get(i).getCorreo() +"\n" +
                    lista.get(i).getTelefono());

        }
    }
}