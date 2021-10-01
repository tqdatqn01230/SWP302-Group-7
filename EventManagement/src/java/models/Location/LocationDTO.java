/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.Location;

/**
 *
 * @author Dell
 */
public class LocationDTO {
    private int locationID;
    String locationName;

    public LocationDTO (String locationName) {    
        this.locationName = locationName;
    }

    public LocationDTO(int locationID, String locationName) {
        this.locationID = locationID;
        this.locationName = locationName;
    }

    public void setLocationID(int locationID) {
        this.locationID = locationID;
    }


    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public int getLocationID() {
        return locationID;
    }

 
    public String getLocationName() {
        return locationName;
    }
    
}
