package android.pmr;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.pmr.databinding.ActivityMainBinding;
import android.pmr.db.DbHelper;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    // ---------> ATTRIBUTES & CONSTANS <---------
    private final static int CONT_ACTIVIDAD = 0; // activity id

    private DrawerLayout drawerLayout;
    private NavigationView nav;
    private ViewFlipper vf;

    private Button doBtn; // botón para crear la bd

    // ---------> DEVELOPMENT <---------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // create Database
        doBtn = findViewById(R.id.doBtn);
        doBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DbHelper dbHelper = new DbHelper(MainActivity.this);
                SQLiteDatabase db = dbHelper.getWritableDatabase();

                if(db != null) {
                    Toast.makeText(MainActivity.this, "DATABASE CREATED", Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(MainActivity.this, "CAN'T CREATE DATABASE", Toast.LENGTH_LONG).show();
                }

            }
        });

        // ViewFlipper component
        vf = (ViewFlipper)findViewById(R.id.viewFlipper);
        vf.setDisplayedChild(CONT_ACTIVIDAD);

        // NavigationDrawer component
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        nav = (NavigationView) findViewById(R.id.nav_view);
        nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Intent sendIntent;
                switch (item.getItemId()) {
                    case R.id.navItem1:
                        // start Activity 1
                        sendIntent = new Intent(MainActivity.this, MainActivity.class);
                        startActivity(sendIntent);
                        break;
                    case R.id.navItem2:
                        // start Activity 2
                        sendIntent = new Intent(MainActivity.this, Activity_2_Home.class);
                        startActivity(sendIntent);
                        break;
                    case R.id.navItem3:
                        // start Activity 3
                        sendIntent = new Intent(MainActivity.this, Activity_3_Wishlist.class);
                        startActivity(sendIntent);
                        break;
                    case R.id.navItem4:
                        // start Activity 4
                        sendIntent = new Intent(MainActivity.this, Activity_4_Filter.class);
                        startActivity(sendIntent);
                        break;
                    case R.id.navItem5:
                        // start Activity 5
                        sendIntent = new Intent(MainActivity.this, Activity_5_Map.class);
                        startActivity(sendIntent);
                        break;
                    case R.id.navItem6:
                        // start Activity 6
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