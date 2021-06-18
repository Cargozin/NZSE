package com.example.cwspace.Adapter;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.cwspace.Datenklassen.Room;
import com.example.cwspace.Datenklassen.RoomsArray;
import com.example.cwspace.R;

import java.util.ArrayList;

public class RecyclerviewRoomsAdapter extends RecyclerView.Adapter<RecyclerviewRoomsAdapter.RoomsViewHolder> {

    public class RoomsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView image;
        TextView itemname, itemnumseats;

        RoomsViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            image = (ImageView) itemView.findViewById(R.id.itemimage);
            itemname = (TextView) itemView.findViewById(R.id.itemname);
            itemnumseats = (TextView) itemView.findViewById(R.id.itemnumseats);
        }

        @Override
        public void onClick(View v) {
            // The user may not set a click listener for list items, in which case our listener
            // will be null, so we need to check for this
            if (mOnEntryClickListener != null) {
                mOnEntryClickListener.onEntryClick(v, getLayoutPosition());
            }
        }
    }

    private Context mContext;
    private ArrayList<Room> mArrayRooms= RoomsArray.getInstance();

    public RecyclerviewRoomsAdapter(Context context, ArrayList<Room> arrayRooms) {
        mContext = context;
        mArrayRooms = arrayRooms;
    }

    @Override
    public int getItemCount() {
        return mArrayRooms.size();
    }

    @Override
    public RoomsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_view, parent, false);
        return new RoomsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RoomsViewHolder holder, int position) {
        Room room = mArrayRooms.get(position);

        //holder.image.setImageDrawable(room.getImage());
        holder.itemname.setText(room.getName());
        holder.itemnumseats.setText(room.getNumSeats());


        //mit intent arbeiten für suche?

    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }


    private OnEntryClickListener mOnEntryClickListener;

    public interface OnEntryClickListener {
        void onEntryClick(View view, int position);
    }

    public void setOnEntryClickListener(OnEntryClickListener onEntryClickListener) {
        mOnEntryClickListener = onEntryClickListener;
    }

}
