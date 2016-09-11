package com.kwondeveloper.possemongo.Helpers;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.kwondeveloper.possemongo.Data.Posse;
import com.kwondeveloper.possemongo.R;
import com.kwondeveloper.possemongo.UserInterface.ProgrammerDetailActivity;
import com.kwondeveloper.possemongo.UserInterface.ProgrammerDetailFragment;
import com.kwondeveloper.possemongo.UserInterface.ProgrammerListActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Mike on 9/3/2016.
 */
public class PosseRecyclerAdapter extends RecyclerView.Adapter<PosseRecyclerAdapter.ViewHolder> implements ItemTouchHelperAdapter {
    private ArrayList<Posse> mList;
    private FragmentActivity mContext;

    public PosseRecyclerAdapter (ArrayList<Posse> array, Context context) {
        mList = array;
        mContext = (FragmentActivity) context;
    }

    @Override
    public PosseRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.programmer_list_content, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(PosseRecyclerAdapter.ViewHolder holder, int position) {
        //build the details of each list item with programmer name, city, and graphic indicating
        //their programming language expertise
        holder.mName.setText(mList.get(position).getName());
        holder.mLocation.setText(mList.get(position).getLocality());
        if (mList.get(position).getPlatform() != null) {
            switch (mList.get(position).getPlatform()) {
                case "iOS":
                    Picasso.with(mContext).load(R.drawable.applelogo)
                            .fit().centerCrop().into(holder.mService);
                    break;
                case "Android":
                    Picasso.with(mContext).load(R.drawable.androidlogo)
                            .fit().centerCrop().into(holder.mService);
                    break;
                case "Ruby":
                    Picasso.with(mContext).load(R.drawable.rubylogo)
                            .fit().centerCrop().into(holder.mService);
                    break;
            }
        }
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    //Remove programmer list item from list via swipe and notify the RecyclerViewAdapter
    @Override
    public void onItemDismiss(int position) {
        Toast.makeText(mContext, PosseSingleton.getProgrammer(position).getName()
                        + " " + mContext.getString(R.string.roster_swipe_delete), Toast.LENGTH_SHORT).show();
        PosseSingleton.removeProgrammer(position);
        notifyItemRemoved(position);
    }

    //drag & drop programmer list item into new position on the list and notify the RecyclerViewAdapter
    @Override
    public void onItemMove(int fromPosition, int toPosition) {
        Posse prev = PosseSingleton.removeProgrammer(fromPosition);
        PosseSingleton.addProgrammer(prev, toPosition);
        notifyItemMoved(fromPosition, toPosition);
        Log.d("***PosseAdapter", "List item moved from " + fromPosition + " to " + toPosition);
    }

    //Custom ViewHolder inner class for recyclerview
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, ItemTouchHelperViewHolder {

        private TextView mName,mLocation;
        private ImageView mService;

        public ViewHolder(View itemView) {
            super(itemView);
            mName = (TextView) itemView.findViewById(R.id.tvName);
            mLocation = (TextView) itemView.findViewById(R.id.tvLocation);
            mService = (ImageView) itemView.findViewById(R.id.ivProgrammerService);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            //clicking on a programmer will launch their details
            Log.d("***PosseAdapter", "Is this a tablet? " + PosseSingleton.mTwoPane);
            if (PosseSingleton.mTwoPane) {
                Bundle arguments = new Bundle();
                arguments.putInt(ProgrammerDetailFragment.POSSE_IDENTIFIER, getAdapterPosition());
                ProgrammerDetailFragment fragment = new ProgrammerDetailFragment();
                fragment.setArguments(arguments);
                mContext.getSupportFragmentManager().beginTransaction()
                        .replace(R.id.programmer_detail_container, fragment).commit();
            } else {
                Context context = v.getContext();
                Intent intent = new Intent(context, ProgrammerDetailActivity.class);
                intent.putExtra(ProgrammerDetailFragment.POSSE_IDENTIFIER, getAdapterPosition());
                context.startActivity(intent);
            }
            Log.d("***PosseAdapter", "List item clicked: " + getAdapterPosition());
            Toast.makeText(mContext,
                    PosseSingleton.getProgrammer(getAdapterPosition()).getName() + mContext.getString(R.string.selection),
                    Toast.LENGTH_SHORT).show();
        }

        //Reduce list item size when touched to indicated its been selected for movement
        @Override
        public void onItemSelected() {
            itemView.setScaleX(.98f);
            itemView.setScaleY(.98f);
            Log.d("***PosseAdapter", "List item selected for movement");
        }

        //Restore list item size when released
        @Override
        public void onItemClear() {
            itemView.setScaleX(1f);
            itemView.setScaleY(1f);
        }
    }
}
