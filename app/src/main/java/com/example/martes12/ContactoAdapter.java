package com.example.martes12;// ContactoAdapter.java
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class ContactoAdapter extends RecyclerView.Adapter<ContactoAdapter.ContactoViewHolder> {

    private final List<Contacto> contactos;
    private final Context context;

    public ContactoAdapter(List<Contacto> contactos, Context context) {
        this.contactos = contactos;
        this.context = context;
    }

    @NonNull
    @Override
    public ContactoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_contacto, parent, false);
        return new ContactoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactoViewHolder holder, int position) {
        Contacto contacto = contactos.get(position);
        holder.nombreTextView.setText(contacto.getNombre() + " " + contacto.getApellidos());
        holder.emailTextView.setText(contacto.getEmail());
        holder.telefonoTextView.setText(contacto.getTelefono());
        holder.fotoImageView.setImageResource(contacto.getFoto());

        // Añadimos el evento de clic para cada elemento
        holder.itemView.setOnClickListener(v -> {
            String info = "Nombre: " + contacto.getNombre() + "\nEmail: " + contacto.getEmail() +
                    "\nTeléfono: " + contacto.getTelefono();
            Toast.makeText(context, info, Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public int getItemCount() {
        return contactos.size();
    }

    static class ContactoViewHolder extends RecyclerView.ViewHolder {
        TextView nombreTextView, emailTextView, telefonoTextView;
        ImageView fotoImageView;

        public ContactoViewHolder(@NonNull View itemView) {
            super(itemView);
            nombreTextView = itemView.findViewById(R.id.nombreTextView);
            emailTextView = itemView.findViewById(R.id.emailTextView);
            telefonoTextView = itemView.findViewById(R.id.telefonoTextView);
            fotoImageView = itemView.findViewById(R.id.fotoImageView);
        }
    }
}
