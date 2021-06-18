package com.example.cwspace.Adapter;

import android.content.Context;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.cwspace.Datenklassen.Room;
import com.example.cwspace.Datenklassen.RoomsArray;
import com.example.cwspace.R;

import java.util.ArrayList;

public class RecyclerviewRoomsAdapter extends RecyclerView.Adapter<RecyclerviewRoomsAdapter.RoomsViewHolder> implements Filterable {

    public class RoomsViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView itemname, itemnumseats;

        RoomsViewHolder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.itemimage);
            itemname = (TextView) itemView.findViewById(R.id.itemname);
            itemnumseats = (TextView) itemView.findViewById(R.id.itemnumseats);

            itemView.findViewById(R.id.details).setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){
                    Room r = mArrayRooms.get(getAdapterPosition());

                    Log.d("demo","onClick: detail for " + mArrayRooms.get(getAdapterPosition()).getName());

                    Intent intent = new Intent();

                }
            });

            itemView.findViewById(R.id.favButton).setOnClickListener(new View.OnClickListener(){
                public void onClick(View view){
                    final ImageButton button = (ImageButton) itemView.findViewById(R.id.favButton);

                    Room r = mArrayRooms.get(getAdapterPosition());
                    r.toggleFav();

                    if(r.getFav()){ //Falls true
                        button.setImageResource(R.drawable.ic_fav);
                    }else{  //false
                        button.setImageResource(R.drawable.ic_notfav);
                    }

                    Log.d("Recyclerview.class","onClick: fav toggled for: " + mArrayRooms.get(getAdapterPosition()).getName());
                }
            });
        }



    }

    private Context mContext;
    private ArrayList<Room> mArrayRooms= RoomsArray.getInstance();
    private ArrayList<Room> mArrayRoomsAll;   //List for searchbar

    public RecyclerviewRoomsAdapter(Context context, ArrayList<Room> arrayRooms) {
        mContext = context;
        mArrayRooms = arrayRooms;
        mArrayRoomsAll = new ArrayList<>(mArrayRooms);  //copy roomlist
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


        //mit intent arbeiten für detail?

    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public Filter getFilter() {
        return roomFilter;
    }

    private Filter roomFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            ArrayList<Room> filteredList = new ArrayList<>();

            if(constraint == null || constraint.length() == 0){
                filteredList.addAll(mArrayRoomsAll);
            }else{
                String filterPattern = constraint.toString().toLowerCase().trim();

                for(Room item: mArrayRoomsAll){
                    if(item.getName().toLowerCase().contains(filterPattern)){
                        filteredList.add(item);
                    }
                }
            }

            FilterResults results = new FilterResults();
            results.values = filteredList;

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            mArrayRooms.clear();
            mArrayRooms.addAll((ArrayList)results.values);
            notifyDataSetChanged();
        }
    };
}
