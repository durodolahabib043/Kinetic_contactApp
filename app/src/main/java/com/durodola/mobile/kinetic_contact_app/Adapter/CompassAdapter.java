package com.durodola.mobile.kinetic_contact_app.Adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.durodola.mobile.kinetic_contact_app.Activity.MainActivity;
import com.durodola.mobile.kinetic_contact_app.MapFragment;
import com.durodola.mobile.kinetic_contact_app.R;
import com.durodola.mobile.kinetic_contact_app.Utils.Contact;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by mobile on 2016-04-01.
 */
public class CompassAdapter extends RecyclerView.Adapter<CompassAdapter.PersonViewHolder> {

    ArrayList<Contact> contactResultArrayList;
    Context context;
    Contact contact;
    String master;
    String master2;
    int hotfix = 1;
    MapFragment mapFragment;

    public CompassAdapter(Context context, ArrayList<Contact> contactResultArrayList) {
        this.contactResultArrayList = contactResultArrayList;
        this.context = context;
        // olawepo


    }

    @Override
    public PersonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_card_layout, parent, false);
        PersonViewHolder pvh = new PersonViewHolder(v);
        contact = Contact.getInstance();
        mapFragment = new MapFragment();
        return pvh;
    }


    @Override
    public void onBindViewHolder(PersonViewHolder holder, final int position) {
        holder.name.setText(contactResultArrayList.get(position).getName().title + " " +
                contactResultArrayList.get(position).getName().first + " " + contactResultArrayList.get(position).getName().last);
        holder.gender.setText(" " + contactResultArrayList.get(position).getGender());
        holder.email.setText(" " + contactResultArrayList.get(position).getEmail());
        holder.phone.setText(" " + contactResultArrayList.get(position).getPhone());
        holder.location.setText(" " + contactResultArrayList.get(position).getLocation().street + " " +
                contactResultArrayList.get(position).getLocation().city + " " + contactResultArrayList.get(position).getLocation().state);
        Picasso.with(this.context).load(contactResultArrayList.get(position).getPicture().large).into(holder.displayPicture);
        holder.location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // switchFragment(mapFragment);
                if (context == null)
                    return;
                if (context instanceof MainActivity) {
                    MainActivity _mainactivity = (MainActivity) context;
                    _mainactivity.Switchfragment(R.id.mylayout, mapFragment, " " + contactResultArrayList.get(position).getLocation().street + " " +
                            contactResultArrayList.get(position).getLocation().city + " " + contactResultArrayList.get(position).getLocation().state);
                }
            }
        });
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public int getItemCount() {
        return contactResultArrayList.size();
    }

    public static class PersonViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView name;
        TextView gender;
        ImageView displayPicture;
        TextView email;
        TextView phone;
        TextView location;

        PersonViewHolder(View itemView) {
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.cv);
            name = (TextView) itemView.findViewById(R.id.name);
            gender = (TextView) itemView.findViewById(R.id.gender2);
            displayPicture = (ImageView) itemView.findViewById(R.id.display_picture);
            email = (TextView) itemView.findViewById(R.id.email2);
            phone = (TextView) itemView.findViewById(R.id.phone2);
            location = (TextView) itemView.findViewById(R.id.location2);
        }
    }
}
