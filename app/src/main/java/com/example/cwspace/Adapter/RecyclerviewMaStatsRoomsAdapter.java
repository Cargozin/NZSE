package com.example.cwspace.Adapter;

import android.content.Context;

import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.cwspace.Datenklassen.Room;
import com.example.cwspace.R;
import com.example.cwspace.ui.MaklerPackage.MaInfoRoom;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class RecyclerviewMaStatsRoomsAdapter extends RecyclerView.Adapter<RecyclerviewMaStatsRoomsAdapter.RoomsViewHolder> {

    public class RoomsViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView itemName, itemNumSeats;
        ImageView bookedImage;
        TextView bookings;

        RoomsViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.itemimage);
            itemName = itemView.findViewById(R.id.itemname);
            itemNumSeats = itemView.findViewById(R.id.itemnumseats);
            bookedImage = itemView.findViewById(R.id.isBooked);
            bookings = itemView.findViewById(R.id.booking);

            itemView.findViewById(R.id.details).setOnClickListener(view -> {

                Log.d("demo","onClick: detail for " + mArrayRooms.get(getAdapterPosition()).getName());

                Intent intent = new Intent(itemView.getContext(), MaInfoRoom.class);
                intent.putExtra("Position",getAdapterPosition());
                itemView.getContext().startActivity(intent);

            });
        }
    }

    private final ArrayList<Room> mArrayRooms;

    public RecyclerviewMaStatsRoomsAdapter(Context context, ArrayList<Room> arrayRooms) {
        mArrayRooms = arrayRooms;
    }

    @Override
    public int getItemCount() {
        return mArrayRooms.size();
    }

    @NotNull
    @Override
    public RoomsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_view_stats, parent, false);
        return new RoomsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RoomsViewHolder holder, int position) {
        Room room = mArrayRooms.get(position);

        //holder.image.setImageDrawable(room.getImage());
        holder.itemName.setText(room.getName());
        holder.itemNumSeats.setText(room.getNumSeats());
        holder.bookings.setText(room.getBookings());
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
}
