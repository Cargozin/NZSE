package com.example.cwspace.ui.cw_stats;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CWStatsViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public CWStatsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is cwstats fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}