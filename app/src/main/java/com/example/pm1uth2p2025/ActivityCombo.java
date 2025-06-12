package com.example.pm1uth2p2025;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.pm1uth2p2025.Configuracion.Personas;
import com.example.pm1uth2p2025.Configuracion.SQLiteConexion;
import com.example.pm1uth2p2025.Configuracion.Transacciones;

import java.util.ArrayList;

public class ActivityCombo extends AppCompatActivity {

    SQLiteConexion conexion;
    Spinner combopersonas;
    EditText nombres, apellidos, correo;

    ArrayList<Personas> lista;
    ArrayList<String> Arreglolista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_combo);

        combopersonas = findViewById(R.id.spinner);
        nombres = findViewById(R.id.cbnombre);
        apellidos = findViewById(R.id.cbapellido);
        correo = findViewById(R.id.cbcorreo);

        conexion = new SQLiteConexion(this, Transacciones.NameDB, null, 1);

        ObtenerDatos();

        // Cambiado para usar dropdown layout adecuado
        ArrayAdapter<String> adp = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, Arreglolista);
        adp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        combopersonas.setAdapter(adp);

        // Evento cuando se selecciona una persona del combo
        combopersonas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Personas personaSeleccionada = lista.get(position);

                nombres.setText(personaSeleccionada.getNombres());
                apellidos.setText(personaSeleccionada.getApellidos());
                correo.setText(personaSeleccionada.getCorreo());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                nombres.setText("");
                apellidos.setText("");
                correo.setText("");
            }
        });
    }

    private void ObtenerDatos() {
        SQLiteDatabase db = conexion.getReadableDatabase();
        Personas person = null;
        lista = new ArrayList<>();

        Cursor cursor = db.rawQuery(Transacciones.SelectPersonas, null);

        while (cursor.moveToNext()) {
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

    private void FillData() {
        Arreglolista = new ArrayList<>();

        for (int i = 0; i < lista.size(); i++) {
            Arreglolista.add(lista.get(i).getNombres() + "\n" +
                    lista.get(i).getApellidos() + "\n" +
                    lista.get(i).getCorreo() + "\n" +
                    lista.get(i).getTelefono());
        }
    }
}