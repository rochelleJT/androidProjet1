package com.example.rochelle.androideval;

import android.app.Application;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private DerniereQuestionsFragment derniereQuestions = new DerniereQuestionsFragment();
    private MeilleursUtilisateursFragment meilleursUtilisateursFragment = new MeilleursUtilisateursFragment();
    private QuestionFavoritesFragment questionFavoritesFragment = new QuestionFavoritesFragment();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDrawerLayout = findViewById(R.id.drawer_layout);

        mDrawerLayout.addDrawerListener(
                new DrawerLayout.DrawerListener() {
                    @Override
                    public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {
                        // Respond when the drawer's position changes
                    }

                    @Override
                    public void onDrawerOpened(@NonNull View drawerView) {
                        // Respond when the drawer is opened
                    }

                    @Override
                    public void onDrawerClosed(@NonNull View drawerView) {
                        // Respond when the drawer is closed
                    }

                    @Override
                    public void onDrawerStateChanged(int newState) {
                        // Respond when the drawer motion state changes
                    }
                }
        );

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {

                        if (menuItem.getItemId() == R.id.derniere_questions) {
                            //Toast.makeText(MainActivity.this, "cool", Toast.LENGTH_SHORT).show();
                            replaceFragment(derniereQuestions);
                        } else if (menuItem.getItemId() == R.id.meilleurs_utilisateurs) {
                            replaceFragment(meilleursUtilisateursFragment);
                        } else if (menuItem.getItemId() == R.id.questions_favorites) {
                            replaceFragment(questionFavoritesFragment);
                        }

                        // set item as selected to persist highlight
                        menuItem.setChecked(true);
                        // close drawer when item is tapped
                        mDrawerLayout.closeDrawers();

                        // Add code here to update the UI based on the item selected
                        // For example, swap UI fragments here

                        return true;
                    }
                });

        ActionBar actionbar = getSupportActionBar();
        assert actionbar != null;
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public  void replaceFragment (Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_fragment, fragment).commit();
    }
}
