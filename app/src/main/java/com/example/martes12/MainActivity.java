package com.example.martes12;

import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ContactoAdapter adapter;
    private List<Contacto> contactos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Configuración de insets para ajustar la vista a los bordes del sistema
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Configuración del RecyclerView
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Obtener la lista de contactos y configurar el adapter
        contactos = obtenerListaDeContactos();
        adapter = new ContactoAdapter(contactos);
        recyclerView.setAdapter(adapter);
    }

    // Método para obtener la lista de contactos
    private List<Contacto> obtenerListaDeContactos() {
        List<Contacto> lista = new ArrayList<>();
        lista.add(new Contacto("Juan", "Pérez", "juan.perez@ejemplo.com", "123456789", R.drawable.icono));
        lista.add(new Contacto("Ana", "García", "ana.garcia@ejemplo.com", "987654321", R.drawable.icono));
        // Agregar más contactos si es necesario
        return lista;
    }
}

