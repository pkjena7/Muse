package com.example.muse;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new TodayFragment()).commit();

        bottomNavigationView = findViewById(R.id.button_nav);
        bottomNavigationView.setSelectedItemId(R.id.today);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;
                switch (item.getItemId()) {
                    case R.id.today:
                        fragment = new TodayFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, fragment).commit();
                        return true;
                    case R.id.log:
                        fragment = new LogFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, fragment).commit();
                        return true;
                    case R.id.health_data:
                        fragment = new HealthFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, fragment).commit();
                        return true;
                }
                return true;
            }
        });
    }
}