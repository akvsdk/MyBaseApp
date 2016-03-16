package com.ep.joy.mybaseapp.entity;

import java.io.Serializable;
import java.util.List;

/**
 * author   Joy
 * Date:  2016/3/16.
 * version:  V1.0
 * Description:
 */
public class User implements Serializable {

    private List<ListEntity> list;

    public void setList(List<ListEntity> list) {
        this.list = list;
    }

    public List<ListEntity> getList() {
        return list;
    }

    public static class ListEntity {
        private int extension;
        private String signEndTime;
        private String macthImg;
        private int macthId;
        private String releaseName;
        private double money;
        private String macthName;
        private String extensionMoney;
        private int appType;

        public void setExtension(int extension) {
            this.extension = extension;
        }

        public void setSignEndTime(String signEndTime) {
            this.signEndTime = signEndTime;
        }

        public void setMacthImg(String macthImg) {
            this.macthImg = macthImg;
        }

        public void setMacthId(int macthId) {
            this.macthId = macthId;
        }

        public void setReleaseName(String releaseName) {
            this.releaseName = releaseName;
        }

        public void setMoney(double money) {
            this.money = money;
        }

        public void setMacthName(String macthName) {
            this.macthName = macthName;
        }

        public void setExtensionMoney(String extensionMoney) {
            this.extensionMoney = extensionMoney;
        }

        public void setAppType(int appType) {
            this.appType = appType;
        }

        public int getExtension() {
            return extension;
        }

        public String getSignEndTime() {
            return signEndTime;
        }

        public String getMacthImg() {
            return macthImg;
        }

        public int getMacthId() {
            return macthId;
        }

        public String getReleaseName() {
            return releaseName;
        }

        public double getMoney() {
            return money;
        }

        public String getMacthName() {
            return macthName;
        }

        public String getExtensionMoney() {
            return extensionMoney;
        }

        public int getAppType() {
            return appType;
        }
    }
}
