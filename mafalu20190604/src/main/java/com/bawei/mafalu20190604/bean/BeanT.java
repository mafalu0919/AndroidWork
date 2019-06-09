package com.bawei.mafalu20190604.bean;

/*
 *@Auther:mfl
 *@Date: 2019/6/4
 *@Time:9:26
 *@Description:
 * */public class BeanT {
    private String id;
     private String imageUrl;
     private String summary;

    public BeanT() {
    }

    public BeanT(String id, String imageUrl, String summary) {
        this.id = id;
        this.imageUrl = imageUrl;
        this.summary = summary;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}
