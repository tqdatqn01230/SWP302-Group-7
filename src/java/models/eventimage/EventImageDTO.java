/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.eventimage;

/**
 *
 * @author Dell
 */
public class EventImageDTO {
    String link;
    int eventID;

    public void setLink(String link) {
        this.link = link;
    }

    public void setEventID(int eventID) {
        this.eventID = eventID;
    }

    public EventImageDTO(String link, int eventID) {
        this.link = link;
        this.eventID = eventID;
    }

    public String getLink() {
        return link;
    }

    public int getEventID() {
        return eventID;
    }
    
}
