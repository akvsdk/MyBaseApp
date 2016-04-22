package com.ep.joy.mybaseapp.entity;

import java.util.List;

/**
 * author   Joy
 * Date:  2016/4/20.
 * version:  V1.0
 * Description:
 */
public class News {

    /**
     * id : 33
     * title : 重庆盛泰雪铁龙首礼贺岁
     * subtitle : 红旗河沟店
     * dianjishu : 181
     * img : http://222.177.210.200/mxqc/news/1454739216980.jpg
     * release_time : 1454739241000
     * releaseTime : 2016-02-06 14:14:01
     * cname : 导购
     * userName : 系统管理员
     * interval_str : 2016-02-06
     */

    private List<NewsListEntity> newsList;

    public List<NewsListEntity> getNewsList() {
        return newsList;
    }

    public void setNewsList(List<NewsListEntity> newsList) {
        this.newsList = newsList;
    }

    public static class NewsListEntity {
        private int id;
        private String title;
        private String subtitle;
        private int dianjishu;
        private String img;
        private long release_time;
        private String releaseTime;
        private String cname;
        private String userName;
        private String interval_str;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getSubtitle() {
            return subtitle;
        }

        public void setSubtitle(String subtitle) {
            this.subtitle = subtitle;
        }

        public int getDianjishu() {
            return dianjishu;
        }

        public void setDianjishu(int dianjishu) {
            this.dianjishu = dianjishu;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public long getRelease_time() {
            return release_time;
        }

        public void setRelease_time(long release_time) {
            this.release_time = release_time;
        }

        public String getReleaseTime() {
            return releaseTime;
        }

        public void setReleaseTime(String releaseTime) {
            this.releaseTime = releaseTime;
        }

        public String getCname() {
            return cname;
        }

        public void setCname(String cname) {
            this.cname = cname;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getInterval_str() {
            return interval_str;
        }

        public void setInterval_str(String interval_str) {
            this.interval_str = interval_str;
        }
    }
}
