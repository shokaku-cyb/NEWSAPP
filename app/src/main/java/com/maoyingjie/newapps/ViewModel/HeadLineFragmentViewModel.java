package com.maoyingjie.newapps.ViewModel;

import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

public class HeadLineFragmentViewModel extends BaseViewModel {
    private MutableLiveData<List<String>> titleItem = new MutableLiveData<>();
    public String[] title = new String[]{"头条", "要闻", "评论", "基教", "高教", "职教"};

    public HeadLineFragmentViewModel() {
    }

}
