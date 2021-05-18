package com.example.cwspace.ui.cw_home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CWHomeViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public CWHomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is cwhome fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}