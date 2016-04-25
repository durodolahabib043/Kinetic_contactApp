package com.durodola.mobile.kinetic_contact_app.Activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.durodola.mobile.kinetic_contact_app.ContactFragment;
import com.durodola.mobile.kinetic_contact_app.MapFragment;
import com.durodola.mobile.kinetic_contact_app.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ContactFragment frag = ContactFragment.newInstance();
        android.support.v4.app.FragmentManager manager = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.container, frag);
        transaction.commit();
    }





  public  void Switchfragment(int layout, Fragment fragment, String addresss) {
        FragmentManager fm = getSupportFragmentManager();
        //fm.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left);
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left);
        transaction.replace(layout, fragment);
        transaction.addToBackStack(null);
        Bundle bundle = new Bundle();
        bundle.putString(String.valueOf(MapFragment.DATA_RECEIVE_ADDRESS), addresss);
        fragment.setArguments(bundle);
        transaction.commit();
    }
}
