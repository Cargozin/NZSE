package com.example.cwspace.ui.cw_search;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CWSearchViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public CWSearchViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is cw_search fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}