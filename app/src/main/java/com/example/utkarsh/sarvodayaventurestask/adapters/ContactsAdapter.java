package com.example.utkarsh.sarvodayaventurestask.adapters;

import android.content.Context;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.utkarsh.sarvodayaventurestask.R;

import java.util.ArrayList;

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ItemHolderContacts> {

    Context context;
    ArrayList<String> arraylist_phone;

    public ContactsAdapter(Context context, ArrayList<String> arraylist_phone) {
        this.context = context;
        this.arraylist_phone = arraylist_phone;

    }

    @NonNull
    @Override
    public ItemHolderContacts onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.contactslist,parent,false);
        return new ItemHolderContacts(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolderContacts holder, int position) {

        holder.txtphone.setText(arraylist_phone.get(position));

    }

    @Override
    public int getItemCount() {
        return arraylist_phone.size();
    }


    public class ItemHolderContacts extends RecyclerView.ViewHolder
    {
        TextView txtphone;

        public ItemHolderContacts(View itemView) {
            super(itemView);
            txtphone = itemView.findViewById(R.id.phoneContacts);

        }
    }
}
