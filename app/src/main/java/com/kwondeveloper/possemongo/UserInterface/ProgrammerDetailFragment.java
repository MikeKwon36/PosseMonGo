package com.kwondeveloper.possemongo.UserInterface;

import android.app.Activity;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.util.Log;
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
    private Posse mProgrammer;
    private View mRootView;

    public ProgrammerDetailFragment() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //pull programmer details from the Singleton Arraylist containing all Programmer objects
        if (getArguments().containsKey(POSSE_IDENTIFIER)) {
            mProgrammer = PosseSingleton.getProgrammer(getArguments().getInt(POSSE_IDENTIFIER));
            Activity activity = this.getActivity();
            CollapsingToolbarLayout appBar = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar_layout);
            if (appBar != null) {
                appBar.setTitle(mProgrammer.getName());
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.programmer_detail, container, false);

        //Populate the programmer details on screen by pulling the data from the Programmer object
        if (mProgrammer != null) {
            String artist = mProgrammer.getArtist() ? getString(R.string.is_an_artist) : getString(R.string.is_not_an_artist);
            ((TextView) mRootView.findViewById(R.id.tvName)).setText(mProgrammer.getName());
            ((TextView) mRootView.findViewById(R.id.tvPlatform)).setText(mProgrammer.getPlatform());
            ((TextView) mRootView.findViewById(R.id.tvArtist)).setText(artist);
            ((TextView) mRootView.findViewById(R.id.tvColor)).setText(mProgrammer.getFavoriteColor());
            ((TextView) mRootView.findViewById(R.id.tvAge)).setText(String.valueOf(mProgrammer.getAge()));
            ((TextView) mRootView.findViewById(R.id.tvWeight)).setText(String.valueOf(mProgrammer.getWeight()));
            ((TextView) mRootView.findViewById(R.id.tvPhone)).setText(mProgrammer.getPhone());
            ((TextView) mRootView.findViewById(R.id.tvLocality)).setText(mProgrammer.getLocality());
            ((TextView) mRootView.findViewById(R.id.tvRegion)).setText(mProgrammer.getRegion());
            ((TextView) mRootView.findViewById(R.id.tvPostalCode)).setText(mProgrammer.getPostalCode());
            ((TextView) mRootView.findViewById(R.id.tvCountry)).setText(mProgrammer.getCountry());
        }

        return mRootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mProgrammer != null) {
            setImageAndBackground();
        }
    }

    //Depending on if the layout is for tablet or phone, the pokemon image will be populated
    // in the AppBar (phone) or an imageView (tablet).  Called in onResume, in order to preserve
    // the UI look between state/lifecycle changes.
    private void setImageAndBackground(){
        Log.d("***DetailFragment", "setImageAndBackground() called");
        switch (mProgrammer.getFavoriteColor()){
            case "red":
                mRootView.findViewById(R.id.detailBackground).setBackgroundColor(getResources().getColor(R.color.red));
                if (PosseSingleton.mTwoPane) {
                    Picasso.with(getContext()).load(R.drawable.red).fit().centerCrop()
                            .into(((ImageView) mRootView.findViewById(R.id.ivPosseMon)));
                } else {
                    mRootView.findViewById(R.id.ivPosseMonContainer).setVisibility(View.GONE);
                }
                break;
            case "green":
                mRootView.findViewById(R.id.detailBackground).setBackgroundColor(getResources().getColor(R.color.green));
                if (PosseSingleton.mTwoPane) {
                    Picasso.with(getContext()).load(R.drawable.green).fit().centerCrop()
                            .into(((ImageView) mRootView.findViewById(R.id.ivPosseMon)));
                } else {
                    mRootView.findViewById(R.id.ivPosseMonContainer).setVisibility(View.GONE);
                }
                break;
            case "black":
                mRootView.findViewById(R.id.detailBackground).setBackgroundColor(getResources().getColor(R.color.black));
                if (PosseSingleton.mTwoPane) {
                    Picasso.with(getContext()).load(R.drawable.black).fit().centerCrop()
                            .into(((ImageView) mRootView.findViewById(R.id.ivPosseMon)));
                } else {
                    mRootView.findViewById(R.id.ivPosseMonContainer).setVisibility(View.GONE);
                }
                break;
            case "aqua":
                mRootView.findViewById(R.id.detailBackground).setBackgroundColor(getResources().getColor(R.color.aqua));
                if (PosseSingleton.mTwoPane) {
                    Picasso.with(getContext()).load(R.drawable.aqua).fit().centerCrop()
                            .into(((ImageView) mRootView.findViewById(R.id.ivPosseMon)));
                } else {
                    mRootView.findViewById(R.id.ivPosseMonContainer).setVisibility(View.GONE);
                }
                break;
            case "purple":
                mRootView.findViewById(R.id.detailBackground).setBackgroundColor(getResources().getColor(R.color.purple));
                if (PosseSingleton.mTwoPane) {
                    Picasso.with(getContext()).load(R.drawable.purple).fit().centerCrop()
                            .into(((ImageView) mRootView.findViewById(R.id.ivPosseMon)));
                } else {
                    mRootView.findViewById(R.id.ivPosseMonContainer).setVisibility(View.GONE);
                }
                break;
            case "brown":
                mRootView.findViewById(R.id.detailBackground).setBackgroundColor(getResources().getColor(R.color.brown));
                if (PosseSingleton.mTwoPane) {
                    Picasso.with(getContext()).load(R.drawable.brown).fit().centerCrop()
                            .into(((ImageView) mRootView.findViewById(R.id.ivPosseMon)));
                } else {
                    mRootView.findViewById(R.id.ivPosseMonContainer).setVisibility(View.GONE);
                }
                break;
            case "blue":
                mRootView.findViewById(R.id.detailBackground).setBackgroundColor(getResources().getColor(R.color.blue));
                if (PosseSingleton.mTwoPane) {
                    Picasso.with(getContext()).load(R.drawable.blue).fit().centerCrop()
                            .into(((ImageView) mRootView.findViewById(R.id.ivPosseMon)));
                } else {
                    mRootView.findViewById(R.id.ivPosseMonContainer).setVisibility(View.GONE);
                }
                break;
        }
    }
}