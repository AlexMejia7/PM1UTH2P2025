package com.example.pm1uth2p2025;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ActivityResult extends AppCompatActivity {

    TextView txtnombres,txtapellidos,txtcorreo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_result);

        txtnombres = (TextView) findViewById(R.id.txtnombres);
        txtapellidos = (TextView) findViewById(R.id.txtapellidos);
        txtcorreo = (TextView) findViewById(R.id.txtcorreo);

        txtnombres.setText(getIntent().getStringExtra("nombres"));
        txtnombres.setText(getIntent().getStringExtra("apellidos"));
        txtnombres.setText(getIntent().getStringExtra("correo"));

    }
}