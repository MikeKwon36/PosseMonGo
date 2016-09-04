package com.kwondeveloper.possemongo.UserInterface;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.ActionBar;
import android.view.MenuItem;
import android.widget.ImageView;

import com.kwondeveloper.possemongo.Helpers.PosseSingleton;
import com.kwondeveloper.possemongo.R;
import com.squareup.picasso.Picasso;

public class ProgrammerDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_programmer_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.detail_toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        //Identify which programmer was clicked and load their information in the fragment
        if (savedInstanceState == null) {
            Bundle arguments = new Bundle();
            arguments.putInt(ProgrammerDetailFragment.POSSE_IDENTIFIER,
                    getIntent().getIntExtra(ProgrammerDetailFragment.POSSE_IDENTIFIER,0));
            ProgrammerDetailFragment fragment = new ProgrammerDetailFragment();
            fragment.setArguments(arguments);
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.programmer_detail_container, fragment).commit();
        }

        //Load the appropriate pokemon image based on the programmer selected
        switch (PosseSingleton.getProgrammer(getIntent().getIntExtra(ProgrammerDetailFragment.POSSE_IDENTIFIER,0)).getFavoriteColor()){
            case "red":
                if (!PosseSingleton.mTwoPane) {
                    Picasso.with(this).load(R.drawable.red)
                            .fit().centerCrop()
                            .into(((ImageView) findViewById(R.id.ivToolbarImage)));
                }
                break;
            case "green":
                if (!PosseSingleton.mTwoPane) {
                    Picasso.with(this).load(R.drawable.green)
                            .fit().centerCrop()
                            .into(((ImageView) findViewById(R.id.ivToolbarImage)));
                }
                break;
            case "black":
                if (!PosseSingleton.mTwoPane) {
                    Picasso.with(this).load(R.drawable.black)
                            .fit().centerCrop()
                            .into(((ImageView) findViewById(R.id.ivToolbarImage)));
                }
                break;
            case "aqua":
                if (!PosseSingleton.mTwoPane) {
                    Picasso.with(this).load(R.drawable.aqua)
                            .fit().centerCrop()
                            .into(((ImageView) findViewById(R.id.ivToolbarImage)));
                }
                break;
            case "purple":
                if (!PosseSingleton.mTwoPane) {
                    Picasso.with(this).load(R.drawable.purple)
                            .fit().centerCrop()
                            .into(((ImageView) findViewById(R.id.ivToolbarImage)));
                }
                break;
            case "brown":
                if (!PosseSingleton.mTwoPane) {
                    Picasso.with(this).load(R.drawable.brown)
                            .fit().centerCrop()
                            .into(((ImageView) findViewById(R.id.ivToolbarImage)));
                }
                break;
            case "blue":
                if (!PosseSingleton.mTwoPane) {
                    Picasso.with(this).load(R.drawable.blue)
                            .fit().centerCrop()
                            .into(((ImageView) findViewById(R.id.ivToolbarImage)));
                }
                break;
        }
    }

    //Give users in the programmer detail activity a way to navigate back to the list
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            navigateUpTo(new Intent(this, ProgrammerListActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
