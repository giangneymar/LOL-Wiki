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
import com.example.lolwiki.view.activity.ChampionActivity;
import com.example.lolwiki.view.activity.FeedbackActivity;
import com.example.lolwiki.view.activity.RankActivity;
import com.example.lolwiki.view.activity.WallpaperActivity;
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
        getLocale();
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

    private void openDialogSelectLanguage() {
        Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_select_language);

        Window window = dialog.getWindow();
        if (window == null) {
            return;
        }
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        WindowManager.LayoutParams windowAttributes = window.getAttributes();
        windowAttributes.gravity = Gravity.CENTER;
        window.setAttributes(windowAttributes);

        TextView vietnamese = dialog.findViewById(R.id.vietnamese);
        TextView english = dialog.findViewById(R.id.english);
        vietnamese.setOnClickListener(view -> {
            setLocale("");
            recreate();
            dialog.dismiss();
        });
        english.setOnClickListener(view -> {
            setLocale("en");
            recreate();
            dialog.dismiss();
        });

        dialog.show();
    }

    private void setLocale(String lang) {
        Locale locale = new Locale(lang);
        Locale.setDefault(locale);
        Configuration configuration = new Configuration();
        configuration.locale = locale;
        getBaseContext().getResources().updateConfiguration(configuration, getBaseContext().getResources().getDisplayMetrics());
        SharedPreferences.Editor editor = getSharedPreferences(LOCALE, MODE_PRIVATE).edit();
        editor.putString(LANGUAGE, lang);
        editor.apply();
    }

    private void getLocale() {
        SharedPreferences preferences = getSharedPreferences(LOCALE, MODE_PRIVATE);
        String language = preferences.getString(LANGUAGE, "");
        setLocale(language);
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
            case R.id.rank:
                startActivity(new Intent(this, RankActivity.class));
                overridePendingTransition(0, 0);
                break;
            case R.id.language:
                openDialogSelectLanguage();
                break;
            case R.id.feedback:
                startActivity(new Intent(this, FeedbackActivity.class));
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