package com.example.cwspace.Adapter;

import android.content.Context;

import android.content.Intent;
import android.graphics.Color;
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
import com.example.cwspace.R;
import com.example.cwspace.ui.MaklerPackage.MaInfoRoom;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class RecyclerviewMaRoomsAdapter extends RecyclerView.Adapter<RecyclerviewMaRoomsAdapter.RoomsViewHolder> implements Filterable {

    public class RoomsViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView itemname, itemnumseats;
        ImageButton favimage;
        ImageView bookedImage;

        RoomsViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.itemImage);
            itemname = itemView.findViewById(R.id.itemname);
            itemnumseats = itemView.findViewById(R.id.itemnumseats);
            favimage = itemView.findViewById(R.id.favButton);
            bookedImage = itemView.findViewById(R.id.isBooked);

            itemView.findViewById(R.id.details).setOnClickListener(view -> {

                Log.d("demo","onClick: detail for " + mArrayRooms.get(getAdapterPosition()).getName());

                Intent intent = new Intent(itemView.getContext(), MaInfoRoom.class);
                intent.putExtra("Position",getAdapterPosition());
                itemView.getContext().startActivity(intent);

            });
        }
    }

    private final ArrayList<Room> mArrayRooms;
    private final ArrayList<Room> mArrayRoomsAll;   //List for searchbar

    public RecyclerviewMaRoomsAdapter(Context context, ArrayList<Room> arrayRooms) {
        mArrayRooms = arrayRooms;
        mArrayRoomsAll = new ArrayList<>(mArrayRooms);  //copy roomlist
    }

    @Override
    public int getItemCount() {
        return mArrayRooms.size();
    }

    @NotNull
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
        holder.itemView.findViewById(R.id.favButton).setVisibility(View.INVISIBLE);
        if(room.getImageFile()==1){
            holder.image.setImageResource(R.drawable.roomsimage01);
        }else  if(room.getImageFile()==2){
            holder.image.setImageResource(R.drawable.roomsimage02);
        }else if(room.getImageFile()==3){
            holder.image.setImageResource(R.drawable.roomsimage03);
        }
        if (room.getOccupied()){
            holder.bookedImage.setImageResource(R.drawable.ic_baseline_bookmark_24);
            holder.bookedImage.setColorFilter(Color.RED);
        }else{
            holder.bookedImage.setImageResource(R.drawable.ic_baseline_bookmark_border_24);
            holder.bookedImage.setColorFilter(Color.GREEN);
        }
    }

    @Override
    public void onAttachedToRecyclerView(@NotNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public Filter getFilter() {
        return roomFilter;
    }

    private final Filter roomFilter = new Filter() {
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
