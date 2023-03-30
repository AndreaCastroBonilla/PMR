package android.pmr;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.pmr.databinding.ActivityMainBinding;
import android.view.MenuItem;
import android.widget.ViewFlipper;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    // Constante Contenido Actividad
    private final static int CONT_ACTIVIDAD = 0;

    private ActivityMainBinding binding;
    private DrawerLayout drawerLayout;
    private NavigationView nav;
    private ViewFlipper vf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Componente ViewFlipper
        vf = (ViewFlipper)findViewById(R.id.viewFlipper);
        vf.setDisplayedChild(CONT_ACTIVIDAD);

        // Componente NavigationDrawer
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        nav = (NavigationView) findViewById(R.id.nav_view);
        nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Intent sendIntent;
                switch (item.getItemId()) {
                    case R.id.navItem1:
                        // Se inicia Actividad 1
                        sendIntent = new Intent(MainActivity.this, MainActivity.class);
                        startActivity(sendIntent);
                        break;
                    case R.id.navItem2:
                        // Se inicia Actividad 2
                        sendIntent = new Intent(MainActivity.this, Activity_2_Home.class);
                        startActivity(sendIntent);
                        break;
                    case R.id.navItem3:
                        // Se inicia Actividad 3
                        sendIntent = new Intent(MainActivity.this, Activity_3_Wishlist.class);
                        startActivity(sendIntent);
                        break;
                    case R.id.navItem4:
                        // Se inicia Actividad 3
                        sendIntent = new Intent(MainActivity.this, Activity_4_Filter.class);
                        startActivity(sendIntent);
                        break;
                    case R.id.navItem5:
                        // Se inicia Actividad 3
                        sendIntent = new Intent(MainActivity.this, Activity_5_Map.class);
                        startActivity(sendIntent);
                        break;
                    case R.id.navItem6:
                        // Se inicia Actividad 3
                        sendIntent = new Intent(MainActivity.this, Activity_6_Weather.class);
                        startActivity(sendIntent);
                        break;
                }
                // Close the navigation drawer when an item is selected
                drawerLayout.closeDrawers();
                return true;
            }
        });
    }


}