package com.example.cwspace.ui.MaklerPackage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.cwspace.Datenklassen.Room;
import com.example.cwspace.Datenklassen.RoomsArray;
import com.example.cwspace.R;

public class MaAddFragment extends Fragment {
    EditText nameEdit,numSeatsEdit;
    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,@Nullable ViewGroup container,@Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_ma_add,container,false);
    }
    public void maSaveClicked(View view){
        nameEdit = view.findViewById(R.id.new_room_name);
        String name = nameEdit.getText().toString();

        numSeatsEdit=view.findViewById(R.id.editTextNumberSeats);
        String integer = numSeatsEdit.getText().toString();
        int numSeats = Integer.parseInt(integer);

        RoomsArray.getInstance().add(new Room("test",23));

        Toast toast = Toast.makeText(getContext(), "Saved", Toast.LENGTH_SHORT);
        toast.show();
    }
}