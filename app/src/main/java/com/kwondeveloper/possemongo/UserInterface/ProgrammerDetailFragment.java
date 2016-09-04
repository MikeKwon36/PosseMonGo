package com.kwondeveloper.possemongo.UserInterface;

import android.app.Activity;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kwondeveloper.possemongo.Data.Posse;
import com.kwondeveloper.possemongo.Helpers.PosseSingleton;
import com.kwondeveloper.possemongo.R;

/**
 * A fragment representing a Programmer's details in a {@link ProgrammerListActivity} in
 * 2-pane mode (on tablets) or a {@link ProgrammerDetailActivity} on phones.
 */
public class ProgrammerDetailFragment extends Fragment {

    public static final String POSSE_IDENTIFIER = "index";
    private Posse mProgrammer;

    public ProgrammerDetailFragment() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(POSSE_IDENTIFIER)) {
            mProgrammer = PosseSingleton.getProgrammer(getArguments().getInt(POSSE_IDENTIFIER));

            Activity activity = this.getActivity();
            CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar_layout);
            if (appBarLayout != null) {
                appBarLayout.setTitle(mProgrammer.getName());
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.programmer_detail, container, false);
        if (mProgrammer != null) {
            ((TextView) rootView.findViewById(R.id.tvName)).setText(mProgrammer.getName());
            ((TextView) rootView.findViewById(R.id.tvPlatform)).setText(mProgrammer.getPlatform());
            ((TextView) rootView.findViewById(R.id.tvArtist)).setText(mProgrammer.getArtist().toString());
            ((TextView) rootView.findViewById(R.id.tvColor)).setText(mProgrammer.getFavoriteColor());
            ((TextView) rootView.findViewById(R.id.tvAge)).setText(mProgrammer.getAge().toString());
            ((TextView) rootView.findViewById(R.id.tvWeight)).setText(mProgrammer.getWeight().toString());
            ((TextView) rootView.findViewById(R.id.tvPhone)).setText(mProgrammer.getPhone());
            ((TextView) rootView.findViewById(R.id.tvLocality)).setText(mProgrammer.getLocality());
            ((TextView) rootView.findViewById(R.id.tvRegion)).setText(mProgrammer.getRegion());
            ((TextView) rootView.findViewById(R.id.tvPostalCode)).setText(mProgrammer.getPostalCode());
            ((TextView) rootView.findViewById(R.id.tvCountry)).setText(mProgrammer.getCountry());
        }
        switch (mProgrammer.getFavoriteColor()){
            case "red":
                rootView.setBackgroundColor(getResources().getColor(R.color.red));
                break;
            case "green":
                rootView.setBackgroundColor(getResources().getColor(R.color.green));
                break;
            case "black":
                rootView.setBackgroundColor(getResources().getColor(R.color.black));
                break;
            case "aqua":
                rootView.setBackgroundColor(getResources().getColor(R.color.aqua));
                break;
            case "purple":
                rootView.setBackgroundColor(getResources().getColor(R.color.purple));
                break;
            case "brown":
                rootView.setBackgroundColor(getResources().getColor(R.color.brown));
                break;
            case "blue":
                rootView.setBackgroundColor(getResources().getColor(R.color.blue));
                break;
        }
        return rootView;
    }
}