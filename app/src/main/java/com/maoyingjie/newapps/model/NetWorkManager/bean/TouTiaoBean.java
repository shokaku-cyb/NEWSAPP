package com.maoyingjie.newapps.model.NetWorkManager.bean;


import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.io.Serializable;
import java.util.List;


public class TouTiaoBean {

    public DocsDTO docs;
    public List<ChannelsDTO> channels;


    public static class DocsDTO {

        public PagerDTO pager;
        public List<FocusesDTO> focuses;
        public List<ListDTO> list;

        public static class PagerDTO {
            public Integer pageIndex;
            public Integer pageSize;
            public Integer pageCount;
            public Integer total;
        }

        public static class FocusesDTO {
            public String docId;
            public String docType;
            public String docUrl;
            public String focusImageTitle;
            public String focusImageUrl;
            public String pubTime;
            public String label;
            public String linkUrl;
            public String h5Url;
            public String shareUrl;
            public String commentSet;
            public String likeSet;
        }


        public static class ListDTO implements MultiItemEntity {
            public String docId;
            public String docType;
            public String docUrl;
            public String docTitle;
            public String source;
            public String label;
            public String listStyle;
            public String listTitle;
            public String cardImageUrl;
            public String pubTime;
            public String author;
            public String commentSet;
            public String likeSet;
            public LiveDTO live;
            public VideoDTO video;
            public AudioDTO audio;
            public ChannelDTO channel;
            public String linkUrl;
            public String h5Url;
            public String hasChildren;
            public String channelCode;
            public String shareUrl;
            public List<String> imgUrls;

            @Override
            public int getItemType() {
                if (listStyle == "" || listStyle == null)
                    return 0;
                else
                    return Integer.parseInt(listStyle);
            }

            public static class LiveDTO {
                public LiveDurationDTO liveDuration;
                public String url;

                public static class LiveDurationDTO {
                    public String startTime;
                    public String endTime;
                }
            }


            public static class VideoDTO {
            }


            public static class AudioDTO {
            }


            public static class ChannelDTO {
                public String channelId;
                public String channelTitle;
                public String channelNav;
            }
        }
    }


    public static class ChannelsDTO {
        public String channelId;
        public String channelUrl;
        public String appChannelDesc;
        public String channelCode;
        public String firstScreen;
        public String isFixed;
        public String channelType;
        public String linkUrl;
        public String hasChildren;
        public String channelComment;
        public List<String> channelLogo;
    }
}
