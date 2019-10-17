package com.example.hp.com.dummyvoteproject;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.hp.com.dummyvoteproject.ui.home.HomeFragment;
import com.example.hp.com.dummyvoteproject.ui.notifications.NotificationsFragment;
import com.example.hp.com.dummyvoteproject.ui.search.SearchFragment;
import com.example.hp.com.dummyvoteproject.ui.vote.VoteFragment;

public class bottom_navigation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_search, R.id.navigation_notifications,R.id.navigation_vote)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        //NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
    }
        HomeFragment homeFragment = new HomeFragment();
        SearchFragment searchFragment = new SearchFragment();
        NotificationsFragment notificationsFragment = new NotificationsFragment();
        VoteFragment voteFragment = new VoteFragment();



}
