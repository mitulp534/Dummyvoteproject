package com.example.hp.com.dummyvoteproject.ui.home;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.support.annotation.Nullable;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;

import com.example.hp.com.dummyvoteproject.News;
import com.example.hp.com.dummyvoteproject.NewsAdapter;
import com.example.hp.com.dummyvoteproject.R;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    NewsAdapter adapter;
    List<News> newsList = new ArrayList<>();

    public HomeFragment(){

    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        RecyclerView recyclerView= root.findViewById(R.id.recycler_view_news);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        newsList.add(
                new News(
                        1,
                        "Not Concerned By Interference in US Election, Trump Told Russians In 2017",
                        "President Donald Trump told two senior Russian officials in a 2017 Oval Office meeting that he was unconcerned about Moscow's interference in the U.S. election because the United States did the same in other countries, an assertion that prompted alarmed White House officials to limit access to the remarks to an unusually small number of people, according to three former officials with knowledge of the matter.",
                        R.drawable.news_image1)
        );
        newsList.add(
                new News(
                        2,
                        "WhatsApp Was Extensively Abused During India Elections, Study Claims",
                        "Despite WhatsApp's efforts to reduce the spread of fake news by limiting the number of forwards to five, the platform was extensively abused to spread unfounded rumours and create misinformation campaigns during recent elections in India and Brazil, a study has revealed.",
                        R.drawable.news_image_2)
        );

        newsList.add(
                new News(
                        3,
                        "Congress announces candidates for by-elections",
                        "The Congress on Saturday announced the names of candidates for the upcoming Assembly by-elections in Assam, Puducherry and Chhattisgarh",
                        R.drawable.news_image_3)
        );

        newsList.add(
                new News(
                        4,
                        "Maharashtra Assembly Elections 2019: Date, full schedule, results, all you need to know",
                        "The Election Commission announced the dates for the Maharashtra Assembly Elections today. The state will go to polls on October 21st while the result is scheduled to be out on October 24th.",
                        R.drawable.news_image_4)

        );

        adapter = new NewsAdapter( getActivity().getApplicationContext(),newsList);
        recyclerView.setAdapter(adapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        homeViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {

            }
        });
        return root;
    }
}