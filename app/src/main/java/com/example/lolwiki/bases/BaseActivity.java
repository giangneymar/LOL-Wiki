package com.example.lolwiki.bases;

import static com.example.lolwiki.utils.KeyConstant.LANGUAGE;
import static com.example.lolwiki.utils.KeyConstant.LOCALE;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.lolwiki.R;
import com.example.lolwiki.ui.activity.ChampionActivity;
import com.example.lolwiki.ui.activity.WallpaperActivity;
import com.google.android.material.navigation.NavigationView;

import java.util.Locale;

public class BaseActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    /*
     * Area : variable
     */
    private NavigationView navigation;
    private DrawerLayout drawerLayout;
    private FrameLayout frameLayout;
    private Toolbar toolbar;

    @Override
    public void setContentView(View view) {
        init();
        frameLayout.addView(view);
        super.setContentView(drawerLayout);
        setNavigation();
    }

    /*
     * Area : function
     */
    private void init() {
        drawerLayout = (DrawerLayout) getLayoutInflater().inflate(R.layout.activity_base, null);
        frameLayout = drawerLayout.findViewById(R.id.activity_container);
        toolbar = drawerLayout.findViewById(R.id.toolbar);
        navigation = drawerLayout.findViewById(R.id.navigation);
    }

    private void setNavigation() {
        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this,
                drawerLayout,
                toolbar,
                R.string.open_nav_drawer,
                R.string.close_nav_drawer
        );
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigation.setNavigationItemSelectedListener(this);
    }

    public void setActivityTitle(int title) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
    }

    public void checkItemNavigation(int id) {
        navigation.getMenu().findItem(id).setChecked(true);
    }

    /*
     * Area : override
     */
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        drawerLayout.closeDrawer(GravityCompat.START);
        switch (item.getItemId()) {
            case R.id.champion:
                startActivity(new Intent(this, ChampionActivity.class));
                overridePendingTransition(0, 0);
                break;
            case R.id.wallpaper:
                startActivity(new Intent(this, WallpaperActivity.class));
                overridePendingTransition(0, 0);
                break;
        }
        return true;
    }
}