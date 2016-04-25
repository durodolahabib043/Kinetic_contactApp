package com.durodola.mobile.kinetic_contact_app.AbstractClass;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.app.Fragment;

/**
 * Created by mobile on 2016-04-22.
 */
public abstract class AbstractContactFragment extends Fragment {

    // check for internet
    public boolean isConnected() {
        ConnectivityManager connectivity = (ConnectivityManager) getContext().getSystemService(Context.CONNECTIVITY_SERVICE);

        if (connectivity != null) {
            NetworkInfo[] info = connectivity.getAllNetworkInfo();
            if (info != null)
                for (int i = 0; i < info.length; i++)
                    if (info[i].getState() == NetworkInfo.State.CONNECTED) {
                        return true;
                    }
        }
        return false;
    }

    // no internet
    public void noNetworkAlert() {
        // display dialog when no internet
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Uh Oh");
        builder.setMessage("We couldn't retrieve the data. Please check your network connection and try again.");
        builder.setPositiveButton("Okay", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(1);

            }

        });
        builder.show();
    }

}
