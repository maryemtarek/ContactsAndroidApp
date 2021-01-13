package com.example.contactsapp;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdaptor extends RecyclerView.Adapter<RecyclerViewAdaptor.viewHolder> {


    ArrayList<Contact> contacts;
    OnItemClickListener mListener;
    public interface OnItemClickListener{
        void onItemClick(int position);
        void onLongClickListener(int position);

    }
    public void setOnClickListener(OnItemClickListener listener)
    {
        mListener = listener;
    }
    RecyclerViewAdaptor(ArrayList<Contact> contacts)
    {
        this.contacts = contacts;
    }
    @NonNull
    @Override
    public RecyclerViewAdaptor.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview, parent, false);
        return new viewHolder(view,mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdaptor.viewHolder holder, int position) {
        holder.contactImage.setImageResource(contacts.get(position).getContact_Image());
        holder.contactName.setText(contacts.get(position).contact_name);

    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }
    public static class viewHolder extends RecyclerView.ViewHolder{
        ImageView contactImage;
        TextView contactName;
        public viewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);
            contactImage = itemView.findViewById(R.id.contactPhoto);
            contactName = itemView.findViewById(R.id.contactName);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (listener!=null)
                    {
                        int position = getAdapterPosition();
                        if (position!=RecyclerView.NO_POSITION)
                        {
                            listener.onItemClick(position);
                        }
                    }
                }
            });
            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    if (listener!=null)
                    {
                        int position = getAdapterPosition();
                        if (position!=RecyclerView.NO_POSITION)
                        {
                            listener.onLongClickListener(position);
                        }
                    }

                    return false;
                }
            });

        }

    }
}
