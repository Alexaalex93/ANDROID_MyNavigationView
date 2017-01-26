package com.example.alex.mynavigationview;

import android.os.PersistableBundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private boolean menu_visible;
    private DrawerLayout drawerLayout;

    //HEMOS HECHO UN LISTENER PARA EL DRAWER(EJEMPLO MIS LUGARES EN GOOGLE MAPS)
    //TENEMOS QUE HACER UN LISTENER PARA EL BOTON QUE DESPLIEGUE EL DRAWER
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawer_layout);

        menu_visible = false;

        getSupportActionBar().setHomeAsUpIndicator(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        NavigationView navigationView = (NavigationView) findViewById(R.id.navView);

        navigationView.setNavigationItemSelectedListener(new NavigationMenuListener(this)) ;

        drawerLayout = (DrawerLayout) findViewById(R.id.drawerlayout);

    }

    public void cierraMenu(){

        menu_visible = false;
        drawerLayout.closeDrawers();

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){

            case android.R.id.home: //Le hemos dicho antes que home era el icono de android
            {
                if (menu_visible){
                    drawerLayout.closeDrawers();
                    menu_visible = false;
                }
                else{
                    drawerLayout.openDrawer(GravityCompat.START);
                    menu_visible = true;
                }
            }

        }
        return super.onOptionsItemSelected(item);
    }
}
