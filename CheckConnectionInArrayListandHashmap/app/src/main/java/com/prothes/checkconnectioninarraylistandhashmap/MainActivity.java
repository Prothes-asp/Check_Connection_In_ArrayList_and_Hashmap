package com.prothes.checkconnectioninarraylistandhashmap;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private ArrayList< HashMap<String,String> > arrayList;
    private HashMap<String,String> hashMap = new HashMap<>();
    private NetworkConnectionCheck networkConnectionCheck = new NetworkConnectionCheck();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setNavigationBarColor(getColor(R.color.sky));
        this.getWindow().setStatusBarColor(getColor(R.color.sky));
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        arrayList = new ArrayList<>();

        hashMap = new HashMap<>();
        hashMap.put("image","https://raw.githubusercontent.com/developerprothes/base_adapter_With_layoutinflater/refs/heads/main/BaseAdapterWithLayoutInflater/app/src/main/res/drawable/bangladesh.png");
        hashMap.put("title","Bangladesh");
        hashMap.put("details","This is Bangladesh. It is beautiful country");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("image","https://raw.githubusercontent.com/developerprothes/base_adapter_With_layoutinflater/refs/heads/main/BaseAdapterWithLayoutInflater/app/src/main/res/drawable/india.png");
        hashMap.put("title","India");
        hashMap.put("details","This is India. It is beautiful country");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("image","https://raw.githubusercontent.com/developerprothes/base_adapter_With_layoutinflater/refs/heads/main/BaseAdapterWithLayoutInflater/app/src/main/res/drawable/brazil.png");
        hashMap.put("title","Brazil");
        hashMap.put("details","This is Brazil. It is beautiful country");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("image","https://raw.githubusercontent.com/developerprothes/base_adapter_With_layoutinflater/refs/heads/main/BaseAdapterWithLayoutInflater/app/src/main/res/drawable/japan.png");
        hashMap.put("title","Japan");
        hashMap.put("details","This is Japan. It is beautiful country");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("image","https://raw.githubusercontent.com/developerprothes/base_adapter_With_layoutinflater/refs/heads/main/BaseAdapterWithLayoutInflater/app/src/main/res/drawable/unitedstates.png");
        hashMap.put("title","U.S.A");
        hashMap.put("details","This is U.S.A. It is beautiful country");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("image","https://raw.githubusercontent.com/developerprothes/base_adapter_With_layoutinflater/refs/heads/main/BaseAdapterWithLayoutInflater/app/src/main/res/drawable/russia.png");
        hashMap.put("title","Russia");
        hashMap.put("details","This is Russia. It is beautiful country");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("image","https://raw.githubusercontent.com/developerprothes/base_adapter_With_layoutinflater/refs/heads/main/BaseAdapterWithLayoutInflater/app/src/main/res/drawable/canada.png");
        hashMap.put("title","Canada");
        hashMap.put("details","This is Canada. It is beautiful country");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("image","https://raw.githubusercontent.com/developerprothes/base_adapter_With_layoutinflater/refs/heads/main/BaseAdapterWithLayoutInflater/app/src/main/res/drawable/germany.png");
        hashMap.put("title","Germany");
        hashMap.put("details","This is Germany. It is beautiful country");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("image","https://raw.githubusercontent.com/developerprothes/base_adapter_With_layoutinflater/refs/heads/main/BaseAdapterWithLayoutInflater/app/src/main/res/drawable/australia.png");
        hashMap.put("title","Australia");
        hashMap.put("details","This is Australia. It is beautiful country");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("image","https://raw.githubusercontent.com/developerprothes/base_adapter_With_layoutinflater/refs/heads/main/BaseAdapterWithLayoutInflater/app/src/main/res/drawable/nepal.png");
        hashMap.put("title","Nepal");
        hashMap.put("details","This is Nepal. It is beautiful country");
        arrayList.add(hashMap);


        CustomBaseAdapter customBaseAdapter = new CustomBaseAdapter(this,arrayList,hashMap);
        listView.setAdapter(customBaseAdapter);


    }

    @Override
    public void onBackPressed() {
        if (isTaskRoot()){
            AlertDialog alertDialog = new AlertDialog.Builder(this)
                    .setTitle("Warning !!")
                    .setMessage("Do you want to exit this app ?")
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    })
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    })
                    .show();
            alertDialog.getButton(DialogInterface.BUTTON_POSITIVE).setTextColor(getColor(R.color.sky));
            alertDialog.getButton(DialogInterface.BUTTON_NEGATIVE).setTextColor(getColor(R.color.sky));
        }else{
            super.onBackPressed();
        }
    }

    @Override
    protected void onStart() {
        IntentFilter intentFilter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(networkConnectionCheck,intentFilter);
        super.onStart();
    }

    @Override
    protected void onStop() {
        unregisterReceiver(networkConnectionCheck);
        super.onStop();
    }
}