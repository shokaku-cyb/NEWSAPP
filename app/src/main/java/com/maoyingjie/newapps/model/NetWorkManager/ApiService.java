package com.maoyingjie.newapps.model.NetWorkManager;

import com.maoyingjie.newapps.model.NetWorkManager.bean.TouTiaoBean;

import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.http.GET;

public interface ApiService {

    @GET("/app_pub/zixun/toutiao/")
    Single<TouTiaoBean> getHeadline();

}
