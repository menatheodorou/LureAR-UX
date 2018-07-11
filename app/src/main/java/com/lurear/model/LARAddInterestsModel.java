package com.lurear.model;

/**
 * Created by security on 10/21/2017.
 */

public class LARAddInterestsModel {

    private String interestsItem;
    private boolean isChecked;
    private int clickId;


    public LARAddInterestsModel(String interestsItem, boolean isChecked, int clickId) {
        this.interestsItem = interestsItem;
        this.isChecked = isChecked;
    }

    public String getName() {
        return interestsItem;
    }

    public void setName(String name) {
        this.interestsItem = name;
    }

    public boolean getIsChecked() {
        return isChecked;
    }

    public void setIsChecked(boolean isChecked) {
        this.isChecked = isChecked;
    }

    public int getClickId() {
        return clickId;
    }

    public void setClickId(int clickId) {
        this.clickId = clickId;
    }
}
