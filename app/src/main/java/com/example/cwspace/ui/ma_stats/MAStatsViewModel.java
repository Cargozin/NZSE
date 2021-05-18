package com.example.cwspace.ui.ma_stats;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MAStatsViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public MAStatsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is notifications fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}