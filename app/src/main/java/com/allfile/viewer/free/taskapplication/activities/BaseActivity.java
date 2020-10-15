package com.allfile.viewer.free.taskapplication.activities;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.allfile.viewer.free.taskapplication.R;
import com.allfile.viewer.free.taskapplication.databinding.NaavigationDrawerBinding;
import com.allfile.viewer.free.taskapplication.fragments.HomeFragment;
import com.allfile.viewer.free.taskapplication.fragments.PostsFragment;
import com.allfile.viewer.free.taskapplication.fragments.ServicesFragment;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class BaseActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private NaavigationDrawerBinding binding;
    private Fragment mSelectedFrag = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = NaavigationDrawerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        init();
    }

    private void init() {
        setSupportActionBar(binding.mainLayout.toolbar);
        binding.navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, binding.drawerLayout, binding.mainLayout.toolbar,
                R.string.open_drawer, R.string.close_drawer);
        binding.drawerLayout.setDrawerListener(toggle);
        set_bottom_DrawerImages();

        toggle.syncState();
        set_bottom_NavigationImages();
        HomeFragment homeFragment = new HomeFragment();
        final FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, homeFragment);
        transaction.addToBackStack(null);
        transaction.commit();

        binding.mainLayout.bottomNavigationId.setSelectedItemId(R.id.home);
        binding.mainLayout.bottomNavigationId.setOnNavigationItemSelectedListener(navlistner);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }



    BottomNavigationView.OnNavigationItemSelectedListener navlistner =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                    switch (item.getItemId()) {
                        case R.id.home:
                            mSelectedFrag = new HomeFragment();
                            //Toast.makeText(BottomNavigationActivity.this, "all pdf", Toast.LENGTH_SHORT).show();
                            break;

                        case R.id.services:
                            mSelectedFrag = new ServicesFragment();
                            //Toast.makeText(BottomNavigationActivity.this, "recent", Toast.LENGTH_SHORT).show();
                            break;

                        case R.id.posts:
                            mSelectedFrag = new PostsFragment();
                            //Toast.makeText(BottomNavigationActivity.this, "favourites", Toast.LENGTH_SHORT).show();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            mSelectedFrag).commit();

                    return true;
                }
            };

    private void set_bottom_NavigationImages() {
        Menu menu = binding.mainLayout.bottomNavigationId.getMenu();
        final MenuItem homeItem = menu.getItem(0);
        final MenuItem servicesItem = menu.getItem(1);
        final MenuItem postsItem = menu.getItem(2);
        set_nav_Icon(R.drawable.ic_home, homeItem);
        set_nav_Icon(R.drawable.ic_services, servicesItem);
        set_nav_Icon(R.drawable.ic_post, postsItem);
    }

    private void set_bottom_DrawerImages() {
        Menu navigationMenu = binding.navigationView.getMenu();
        final MenuItem navgationHomeItem = navigationMenu.getItem(0);
        set_nav_Icon(R.drawable.ic_home, navgationHomeItem);
        final MenuItem navgationServiceItem = navigationMenu.getItem(1);
        set_nav_Icon(R.drawable.ic_services, navgationServiceItem);
    }

    public void set_nav_Icon(int img_id, final MenuItem menuItem) {
        Glide.with(this).asBitmap().load(img_id).into(new SimpleTarget<Bitmap>(100, 100) {
            @Override
            public void onResourceReady(@NonNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {
                menuItem.setIcon(new BitmapDrawable(getResources(), resource));
            }
        });
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.home_id: {
                mSelectedFrag = new HomeFragment();
                break;
            }
            case R.id.services_id: {
                mSelectedFrag = new ServicesFragment();
                break;
            }
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                mSelectedFrag).commit();
        binding.drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}