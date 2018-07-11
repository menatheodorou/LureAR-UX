package com.lurear.model;

/**
 * Created by security on 10/21/2017.
 */

public class LARAddGeoFenceModel {

    private String interestsItem;


    public LARAddGeoFenceModel(String interestsItem) {
        this.interestsItem = interestsItem;
    }

    public String getName() {
        return interestsItem;
    }


}
