package com.example.ad37_nguyenquyton_day07;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterContact extends RecyclerView.Adapter<AdapterContact.Viewhoder>  {

    List<Contact> contacts;
    IonClickContact ionClickContact;
    RecyclerView recyclerView;
    public AdapterContact(IonClickContact ionClickContact) {
        this.ionClickContact = ionClickContact;
    }

    Context context;
    SharedPreferences sharedPreferences;

    public AdapterContact(List<Contact> contacts, Context context) {
        this.contacts = contacts;
        this.context = context;
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

    @NonNull
    @Override
    public AdapterContact.Viewhoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.messages_contact, parent, false);

        Viewhoder viewhoder = new Viewhoder(view);
        return viewhoder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterContact.Viewhoder holder, int position) {
        final Contact contact = contacts.get(position);
        holder.tvName.setText(contact.name);
        holder.tvNoidung.setText(contact.noidung);

        boolean messages =sharedPreferences.getBoolean("messages",false);
        if(messages)
        {
            holder.tvNoidung.setVisibility(View.GONE);
            holder.img.setVisibility(View.GONE);
            holder.tvName.setVisibility(View.VISIBLE);
            holder.tvhaicham.setVisibility(View.GONE);


        }
        else {

                holder.tvNoidung.setVisibility(View.VISIBLE);
                holder.img.setVisibility(View.VISIBLE);
                holder.tvhaicham.setVisibility(View.VISIBLE);

            if(holder.tvNoidung.getText()=="")
            {
                holder.tvNoidung.setVisibility(View.GONE);
                holder.img.setVisibility(View.GONE);
                holder.tvhaicham.setVisibility(View.GONE);
                holder.tvName.setVisibility(View.GONE);
            }


        }
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    public class Viewhoder extends RecyclerView.ViewHolder {
        TextView tvName, tvNoidung,tvhaicham;
        ImageView img,icon;

        public Viewhoder(@NonNull View itemView) {
            super(itemView);
            recyclerView = itemView.findViewById(R.id.rvList);
            tvName=itemView.findViewById(R.id.namemess);
            tvNoidung=itemView.findViewById(R.id.noidung);
            img=itemView.findViewById(R.id.imagemess);
            tvhaicham=itemView.findViewById(R.id.haicham);
            icon=itemView.findViewById(R.id.image2);


        }
    }
}
