package com.durodola.mobile.kinetic_contact_app;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.durodola.mobile.kinetic_contact_app.AbstractClass.AbstractContactFragment;
import com.durodola.mobile.kinetic_contact_app.Adapter.ContactAdapter;
import com.durodola.mobile.kinetic_contact_app.Services.Restclient;
import com.durodola.mobile.kinetic_contact_app.Utils.Contact;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class ContactFragment extends AbstractContactFragment {
    Restclient restclient;
    Context context;
    Retrofit retrofit;
    LinearLayoutManager llm;
    RecyclerView rv;
    private ContactAdapter adapter;
    private ArrayList<Contact> data;
    MapFragment mapFragment;

    public ContactFragment() {
        // Required empty public constructor
    }


    public static ContactFragment newInstance() {
        return new ContactFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_contact, container, false);
        context = getContext();
        restclient = new Restclient();
        data = new ArrayList<Contact>();
        llm = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        rv = (RecyclerView) view.findViewById(R.id.rv);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(llm);
        mapFragment = new MapFragment();
        downloadContact();
        return view;

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // check if internet is available
        if (isConnected() == true) {

        } else {
            noNetworkAlert();
        }
    }

    /// download and  parsing of random api
    private void downloadContact() {
        final ProgressDialog loading = ProgressDialog.show(getContext(), "Fetching Contact", "Please wait...", false, false);
        Call<ContactResult> call = restclient.getContact().getdetailedContact();
        //asynchronous call
        call.enqueue(new Callback<ContactResult>() {
            @Override
            public void onResponse(Call<ContactResult> call, Response<ContactResult> response) {
                data = (ArrayList<Contact>) response.body().results;
                adapter = new ContactAdapter(getContext(), data);
                rv.setAdapter(adapter);
                loading.dismiss();

            }

            @Override
            public void onFailure(Call<ContactResult> call, Throwable t) {
                Log.e(" error", "error");

            }
        });
    }
}
