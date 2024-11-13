package com.example.martes12;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.martes12.Contacto;

import java.util.List;

public class ContactoAdapter extends RecyclerView.Adapter<ContactoAdapter.ContactoViewHolder> {

    private List<Contacto> contactos;

    public ContactoAdapter(List<Contacto> contactos) {
        this.contactos = contactos;
    }

    @NonNull
    @Override
    public ContactoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_contacto, parent, false);
        return new ContactoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactoViewHolder holder, int position) {
        Contacto contacto = contactos.get(position);
        holder.contactoFoto.setImageResource(contacto.getFoto());
        holder.contactoNombre.setText(contacto.getNombre() + " " + contacto.getApellidos());
        holder.contactoEmail.setText(contacto.getEmail());
        holder.contactoTelefono.setText(contacto.getTelefono());
    }

    @Override
    public int getItemCount() {
        return contactos.size();
    }

    static class ContactoViewHolder extends RecyclerView.ViewHolder {
        ImageView contactoFoto;
        TextView contactoNombre, contactoEmail, contactoTelefono;

        public ContactoViewHolder(@NonNull View itemView) {
            super(itemView);
            contactoFoto = itemView.findViewById(R.id.contactoFoto);
            contactoNombre = itemView.findViewById(R.id.contactoNombre);
            contactoEmail = itemView.findViewById(R.id.contactoEmail);
            contactoTelefono = itemView.findViewById(R.id.contactoTelefono);
        }
    }
}
