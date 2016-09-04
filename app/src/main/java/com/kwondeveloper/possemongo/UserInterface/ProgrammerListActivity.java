package com.kwondeveloper.possemongo.UserInterface;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.Toast;

import com.kwondeveloper.possemongo.Helpers.ItemTouchHelperCallback;
import com.kwondeveloper.possemongo.Helpers.PosseRecyclerAdapter;
import com.kwondeveloper.possemongo.Helpers.PosseSingleton;
import com.kwondeveloper.possemongo.R;

public class ProgrammerListActivity extends AppCompatActivity {

    private FloatingActionButton mFab;
    private Toolbar mToolbar;
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private PosseRecyclerAdapter mRecyclerAdapter;
    private ItemTouchHelper mItemTouchHelper;
    private SetUpProgrammerListTask mSetupTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_programmer_list);
        mFab = (FloatingActionButton) findViewById(R.id.fab);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        mToolbar.setTitle(getTitle());

        //Async task to populate programmer list and use it to build the RecyclerView
        mSetupTask = new SetUpProgrammerListTask();
        mSetupTask.execute(this);

        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PosseSingleton.resetRoster();
                mRecyclerAdapter.notifyDataSetChanged();
                Toast.makeText(ProgrammerListActivity.this, getString(R.string.roster_reset), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (findViewById(R.id.programmer_detail_container) != null) {
            PosseSingleton.mTwoPane = true;
        } else {
            PosseSingleton.mTwoPane = false;
        }
    }

    public class SetUpProgrammerListTask extends AsyncTask<Context,Void,Void>{

        Context context;

        @Override
        protected Void doInBackground(Context... contexts) {
            //Instantiate singleton list of programmers
            context = contexts[0];
            PosseSingleton.getInstance(context);
            // Detail container view present only in the large-screen layouts (res/values-w900dp).
            // If this view is present, then the activity should be in two-pane mode.
            if (findViewById(R.id.programmer_detail_container) != null) {
                PosseSingleton.mTwoPane = true;
            } else {
                PosseSingleton.mTwoPane = false;
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            //Build recyclerview & adapter to display programmers
            mRecyclerView = (RecyclerView) findViewById(R.id.programmer_list);
            assert mRecyclerView != null;
            mRecyclerView.setHasFixedSize(true);
            mRecyclerAdapter = new PosseRecyclerAdapter(PosseSingleton.getRoster(),context);
            mLayoutManager = new LinearLayoutManager(context);
            mRecyclerView.setLayoutManager(mLayoutManager);
            mRecyclerView.setAdapter(mRecyclerAdapter);

            //Enable swipeToDismiss and drag&drop functionality in RecyclerView
            ItemTouchHelper.Callback callback = new ItemTouchHelperCallback(mRecyclerAdapter);
            mItemTouchHelper = new ItemTouchHelper(callback);
            mItemTouchHelper.attachToRecyclerView(mRecyclerView);

            Toast.makeText(context, context.getString(R.string.launch_instructions), Toast.LENGTH_SHORT).show();
        }
    }
}
