package com.example.shashvatkedia.applock;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Shashvat Kedia on 15-08-2017.
 */

public class ApplicationAdapter extends ArrayAdapter<ApplicationInfo> {
    PackageManager p;
    public ApplicationAdapter(Context a, List<ApplicationInfo> info, PackageManager pm){
        super(a,0,info);
         p=pm;
    }
    @Override
    public View getView(int position,View convertView,ViewGroup parent){
        if(convertView==null){
            convertView= LayoutInflater.from(getContext()).inflate(R.layout.appinfo,parent,false);
        }
        ApplicationInfo a=getItem(position);
        TextView info=(TextView) convertView.findViewById(R.id.AppName);
        info.setText(a.packageName);
        ImageView icon=(ImageView) convertView.findViewById(R.id.icon1);
        try {
            Drawable icon1 = p.getApplicationIcon(info.getText().toString());
            icon.setImageDrawable(icon1);
        }
        catch(PackageManager.NameNotFoundException e){
            Log.e("Hash","NameNotFound Error");
        }
        return convertView;
    }

}
