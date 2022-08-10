package com.cst2335.mycovidapplication;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Empty Activity to be used for fragment showing listview details
 * @author Junnias
 * @version 1.0
 * @see DetailsFragment
 * @see PastQueries
 */
public class EmptyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empty);

        Intent fromPastQ = getIntent();
        String qResults = fromPastQ.getStringExtra("results");
        int id = fromPastQ.getIntExtra("id",0);
        String msgDetails = fromPastQ.getStringExtra("message");

        DetailsFragment detailsFragment = new DetailsFragment();
        Bundle args = new Bundle();
        args.putInt("id", id);
        args.putString("message", msgDetails);
        args.putString("results", qResults);

        detailsFragment.setArguments(args);

        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.setReorderingAllowed(true);
        ft.add(R.id.detail_frag1, detailsFragment);

        ft.commit();

    }
}