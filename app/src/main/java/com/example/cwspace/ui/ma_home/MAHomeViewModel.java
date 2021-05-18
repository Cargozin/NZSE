package com.example.cwspace.ui.ma_home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MAHomeViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public MAHomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is mahome fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}