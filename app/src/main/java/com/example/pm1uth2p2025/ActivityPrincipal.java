package com.example.pm1uth2p2025;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ActivityPrincipal extends AppCompatActivity {

    Button btnadd,btnlista,btcombo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_principal);

      btnadd = (Button) findViewById(R.id.btnadd);
      btnlista = (Button) findViewById(R.id.btnlist);
      btcombo = (Button) findViewById(R.id.btncombo);

      btnadd.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Intent intent = new Intent(getApplicationContext(), MainActivity.class);
              startActivity(intent);
          }
      });
      btnlista.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Intent intent = new Intent(getApplicationContext(), MainActivityLista.class);
              startActivity(intent);

          }
      });
        btcombo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ActivityCombo.class);
                startActivity(intent);

            }
        });

    }
}