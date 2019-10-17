package com.example.hp.com.dummyvoteproject.ui.search;


import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.support.annotation.Nullable;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;

import com.example.hp.com.dummyvoteproject.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchFragment extends Fragment {

    //defining
    SearchView  searchView ;
    ListView searchList;

    //for adapter
    ArrayList<String> list;
    ArrayAdapter<String> adapter;
    private Context context;

    private SearchViewModel searchViewModel;
    public SearchFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        searchViewModel=ViewModelProviders.of(this).get(SearchViewModel.class);
        View root = inflater.inflate(R.layout.fragment_search, container, false);
        //final TextView textView = root.findViewById(R.id.text_search);



        //casting
        searchView =  (SearchView)root.findViewById(R.id.searchView);
        searchList = (ListView)root.findViewById(R.id.searchList);


        list=new ArrayList<>();
        list.add("Bahujan Samaj Party");
        list.add("Bharatiya Janata Party");
        list.add("Indian National Congress");
        list.add("Communist Party of India");
        list.add("Aam Aadmi Party");
        list.add("Janata Dal United");

        adapter=new ArrayAdapter<>(getActivity().getApplicationContext(),android.R.layout.simple_list_item_1,list);
        searchList.setAdapter(adapter);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                adapter.getFilter().filter(s);
                return false;
            }
        });
        searchViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                //textView.setText(s);
            }
        });
        return root;
    }


}
