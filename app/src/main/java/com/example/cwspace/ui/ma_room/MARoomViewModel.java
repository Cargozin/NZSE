package com.example.cwspace.ui.ma_room;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MARoomViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public MARoomViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is ma_room fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}