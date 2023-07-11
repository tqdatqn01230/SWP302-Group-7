/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.timetable;

import java.sql.Date;

/**
 *
 * @author Dell
 */
public class TimetableDTO {
    private int timatableID,eventID,locationID;
    private String EventName,LocationName;
    String starttime,endtime;

    public TimetableDTO(int eventID, int locationID, String starttime, String endtime) {
        this.timatableID = timatableID;
        this.eventID = eventID;
        this.locationID = locationID;
        this.starttime = starttime;
        this.endtime = endtime;
    }

    public String getLocationName() {
        return LocationName;
    }
    public String getEventName() {
        return EventName;
    }

    public TimetableDTO(int timatableID, int eventID, int locationID, String EventName, String LocationName, String starttime, String endtime) {
        this.timatableID = timatableID;
        this.eventID = eventID;
        this.locationID = locationID;
        this.EventName = EventName;
        this.LocationName = LocationName;
        this.starttime = starttime;
        this.endtime = endtime;
    }

    
    public TimetableDTO(int timatableID, int eventID, int locationID, String starttime, String endtime) {
        this.timatableID = timatableID;
        this.eventID = eventID;
        this.locationID = locationID;
        this.starttime = starttime;
        this.endtime = endtime;
    }
    
    public void setTimatableID(int timatableID) {
        this.timatableID = timatableID;
    }

    public void setEventID(int eventID) {
        this.eventID = eventID;
    }

    public void setLocationID(int locationID) {
        this.locationID = locationID;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public int getTimatableID() {
        return timatableID;
    }

    public int getEventID() {
        return eventID;
    }

    public int getLocationID() {
        return locationID;
    }

    public String getStarttime() {
        return starttime;
    }

    public String getEndtime() {
        return endtime;
    }
    
}
