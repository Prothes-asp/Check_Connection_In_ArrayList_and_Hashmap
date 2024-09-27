package com.prothes.checkconnectioninarraylistandhashmap;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.AppCompatButton;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;

public class CustomBaseAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater layoutInflater;
    private ArrayList<HashMap<String, String>> arrayList;
    private HashMap<String, String> hashMap;
    private AppCompatButton copyBtn;
    public static ImageView imageViewInlist;
    public static TextView textViewTitle,textViewDetails;
    public static String getImageUrl,getTitle,getDetails;
    public CustomBaseAdapter(MainActivity mainActivity, ArrayList<HashMap<String, String>> arrayList, HashMap<String, String> hashMap) {
        this.context = mainActivity;
        this.arrayList = arrayList;
        this.hashMap = hashMap;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null){
            layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.listview_items_design,parent,false);
        }
        imageViewInlist = convertView.findViewById(R.id.imageViewInlist);
        textViewTitle = convertView.findViewById(R.id.textViewTitle);
        textViewDetails = convertView.findViewById(R.id.textViewDetails);
        copyBtn = convertView.findViewById(R.id.copyBtn);

        hashMap = arrayList.get(position);
        getImageUrl = hashMap.get("image");
        getTitle = hashMap.get("title");
        getDetails = hashMap.get("details");

        textViewTitle.setText(""+getTitle);
        textViewDetails.setText(""+getDetails);

        getImagefromOnline();

        copyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hashMap = arrayList.get(position);
                String details = hashMap.get("details");
                ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clipData = ClipData.newPlainText("Text",details);
                clipboardManager.setPrimaryClip(clipData);
                Toast.makeText(context, "Copied", Toast.LENGTH_SHORT).show();
            }
        });

        return convertView;
    }

    public static void getImagefromOnline(){
        Picasso.get().load(getImageUrl).into(imageViewInlist);
    }

}
