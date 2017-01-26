package com.example.alex.mynavigationview;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

/**
 * Created by cice on 26/1/17.
 */

public class NavigationMenuListener implements NavigationView.OnNavigationItemSelectedListener {


    private Context mContext;
    public NavigationMenuListener(Context context){

        mContext = context;

    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        String opcion_seleccionada = (String) item.getTitle();
        Log.e(getClass().getCanonicalName(), "Ha tocado" + item.getTitle());

        Activity a = (Activity)mContext;
        TextView textView = (TextView) a.findViewById(R.id.cajaTexto);
        textView.setText(opcion_seleccionada);
        //Despues de que el usuario clica, hay que cerrar el menú

        MainActivity mainActivity = (MainActivity) mContext;
        mainActivity.cierraMenu();



        return true;
    }

}
