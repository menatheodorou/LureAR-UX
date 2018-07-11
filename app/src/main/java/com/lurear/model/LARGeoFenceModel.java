package com.lurear.model;

/**
 * Created by security on 10/22/2017.
 */

public class LARGeoFenceModel {
    private String geoName;
    private String geoStreetName;
    private String geoMetre;

    public LARGeoFenceModel(String geoName, String geoStreetName, String geoMetre ) {
        this.geoName = geoName;
        this.geoStreetName = geoStreetName;
        this.geoMetre = geoMetre;
    }
    public String getName() {
        return geoName;
    }

    public String getDate() {
        return geoStreetName;
    }

    public String getTime() {
        return geoMetre;
    }
}
