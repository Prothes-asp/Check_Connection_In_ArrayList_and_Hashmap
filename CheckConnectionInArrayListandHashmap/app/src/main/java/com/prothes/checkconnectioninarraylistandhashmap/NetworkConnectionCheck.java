package com.prothes.checkconnectioninarraylistandhashmap;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.AppCompatButton;

public class NetworkConnectionCheck extends BroadcastReceiver {
    private AppCompatButton retryBtn;

    @Override
    public void onReceive(Context context, Intent intent) {
        if (!Common.isconnectedNetwork(context)){
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            View view = LayoutInflater.from(context).inflate(R.layout.networkcheck_dialogue,null);
            retryBtn = view.findViewById(R.id.retryBtn);
            builder.setView(view);
            AlertDialog alertDialog = builder.create();
            alertDialog.setCancelable(false);
            alertDialog.getWindow().setGravity(Gravity.CENTER);
            alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            alertDialog.show();

            retryBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    alertDialog.dismiss();
                    onReceive(context,intent);
                    CustomBaseAdapter.getImagefromOnline();
                }
            });

        }
    }
}
