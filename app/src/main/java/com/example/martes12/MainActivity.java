package com.example.martes12;// MainActivity.java
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
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
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        contactos = obtenerListaDeContactos();
        adapter = new ContactoAdapter(contactos, this);  // Pasamos el contexto
        recyclerView.setAdapter(adapter);
    }

    private List<Contacto> obtenerListaDeContactos() {
        List<Contacto> lista = new ArrayList<>();
        lista.add(new Contacto("Juan", "Pérez", "juan.perez@ejemplo.com", "123456789", R.drawable.icono));
        lista.add(new Contacto("Ana", "García", "ana.garcia@ejemplo.com", "987654321", R.drawable.icono));
        // Añadir más contactos aquí
        return lista;
    }
}

