package com.maoyingjie.newapps.model.NetWorkManager.bean;


import com.chad.library.adapter.base.entity.MultiItemEntity;

public class TouTiaoBean implements MultiItemEntity {
  public int code;

  @Override
  public int getItemType() {
    return code;
  }
}
