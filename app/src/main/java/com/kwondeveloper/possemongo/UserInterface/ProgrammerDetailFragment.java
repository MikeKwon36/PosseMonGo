package com.kwondeveloper.possemongo.UserInterface;

import android.app.Activity;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.kwondeveloper.possemongo.Data.Posse;
import com.kwondeveloper.possemongo.Helpers.PosseSingleton;
import com.kwondeveloper.possemongo.R;
import com.squareup.picasso.Picasso;

/**
 * A fragment representing a Programmer's details in a {@link ProgrammerListActivity} in
 * 2-pane mode (on tablets) or a {@link ProgrammerDetailActivity} on phones.
 */
public class ProgrammerDetailFragment extends Fragment {

    public static final String POSSE_IDENTIFIER = "index";
    private CollapsingToolbarLayout mAppBarLayout;
    private Posse mProgrammer;

    public ProgrammerDetailFragment() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(POSSE_IDENTIFIER)) {
            mProgrammer = PosseSingleton.getProgrammer(getArguments().getInt(POSSE_IDENTIFIER));

            Activity activity = this.getActivity();
            CollapsingToolbarLayout mAppBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar_layout);
            if (mAppBarLayout != null) {
                mAppBarLayout.setTitle(mProgrammer.getName());
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
            switch (mProgrammer.getFavoriteColor()){
                case "red":
                    ((LinearLayout) rootView.findViewById(R.id.detailBackground))
                            .setBackgroundColor(getResources().getColor(R.color.red));
                    if (PosseSingleton.mTwoPane) {
                        Picasso.with(getContext()).load(R.drawable.red)
                                .fit().centerCrop()
                                .into(((ImageView) rootView.findViewById(R.id.ivPosseMon)));
                    } else {
                        ((CardView) rootView.findViewById(R.id.ivPosseMonContainer)).setVisibility(View.GONE);
                    }
                    break;
                case "green":
                    ((LinearLayout) rootView.findViewById(R.id.detailBackground))
                            .setBackgroundColor(getResources().getColor(R.color.green));
                    if (PosseSingleton.mTwoPane) {
                        Picasso.with(getContext()).load(R.drawable.green)
                                .fit().centerCrop()
                                .into(((ImageView) rootView.findViewById(R.id.ivPosseMon)));
                    } else {
                        ((CardView) rootView.findViewById(R.id.ivPosseMonContainer)).setVisibility(View.GONE);
                    }
                    break;
                case "black":
                    ((LinearLayout) rootView.findViewById(R.id.detailBackground))
                            .setBackgroundColor(getResources().getColor(R.color.black));
                    if (PosseSingleton.mTwoPane) {
                        Picasso.with(getContext()).load(R.drawable.black)
                                .fit().centerCrop()
                                .into(((ImageView) rootView.findViewById(R.id.ivPosseMon)));
                    } else {
                        ((CardView) rootView.findViewById(R.id.ivPosseMonContainer)).setVisibility(View.GONE);
                    }
                    break;
                case "aqua":
                    ((LinearLayout) rootView.findViewById(R.id.detailBackground))
                            .setBackgroundColor(getResources().getColor(R.color.aqua));
                    if (PosseSingleton.mTwoPane) {
                        Picasso.with(getContext()).load(R.drawable.aqua)
                                .fit().centerCrop()
                                .into(((ImageView) rootView.findViewById(R.id.ivPosseMon)));
                    } else {
                        ((CardView) rootView.findViewById(R.id.ivPosseMonContainer)).setVisibility(View.GONE);
                    }
                    break;
                case "purple":
                    ((LinearLayout) rootView.findViewById(R.id.detailBackground))
                            .setBackgroundColor(getResources().getColor(R.color.purple));
                    if (PosseSingleton.mTwoPane) {
                        Picasso.with(getContext()).load(R.drawable.purple)
                                .fit().centerCrop()
                                .into(((ImageView) rootView.findViewById(R.id.ivPosseMon)));
                    } else {
                        ((CardView) rootView.findViewById(R.id.ivPosseMonContainer)).setVisibility(View.GONE);
                    }
                    break;
                case "brown":
                    ((LinearLayout) rootView.findViewById(R.id.detailBackground))
                            .setBackgroundColor(getResources().getColor(R.color.brown));
                    if (PosseSingleton.mTwoPane) {
                        Picasso.with(getContext()).load(R.drawable.brown)
                                .fit().centerCrop()
                                .into(((ImageView) rootView.findViewById(R.id.ivPosseMon)));
                    } else {
                        ((CardView) rootView.findViewById(R.id.ivPosseMonContainer)).setVisibility(View.GONE);
                    }
                    break;
                case "blue":
                    ((LinearLayout) rootView.findViewById(R.id.detailBackground))
                            .setBackgroundColor(getResources().getColor(R.color.blue));
                    if (PosseSingleton.mTwoPane) {
                        Picasso.with(getContext()).load(R.drawable.blue)
                                .fit().centerCrop()
                                .into(((ImageView) rootView.findViewById(R.id.ivPosseMon)));
                    } else {
                        ((CardView) rootView.findViewById(R.id.ivPosseMonContainer)).setVisibility(View.GONE);
                    }
                    break;
            }
        }
        return rootView;
    }
}