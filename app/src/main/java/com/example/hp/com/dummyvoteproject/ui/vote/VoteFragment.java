package com.example.hp.com.dummyvoteproject.ui.vote;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.support.annotation.Nullable;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;

import com.example.hp.com.dummyvoteproject.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class VoteFragment extends Fragment {
        private VoteViewModel voteViewModel;

    public VoteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
      voteViewModel=ViewModelProviders.of(this).get(VoteViewModel.class);
        View root = inflater.inflate(R.layout.fragment_vote, container, false);
        final TextView textView = root.findViewById(R.id.text_vote);
        voteViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {

                    textView.setText(s);
            }
        });
        return root;
    }

}
