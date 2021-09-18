/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.imageandVideo;

/**
 *
 * @author Dell
 */
public class ImageAndVideoDTO {
    private int ImageID,eventID;
    private String Link;

    public ImageAndVideoDTO(int ImageID, int eventID, String Link) {
        this.ImageID = ImageID;
        this.eventID = eventID;
        this.Link = Link;
    }

    public ImageAndVideoDTO(int eventID, String Link) {
        this.eventID = eventID;
        this.Link = Link;
    }
    
    public void setImageID(int ImageID) {
        this.ImageID = ImageID;
    }

    public void setEventID(int eventID) {
        this.eventID = eventID;
    }

    public void setLink(String Link) {
        this.Link = Link;
    }

    public int getImageID() {
        return ImageID;
    }

    public int getEventID() {
        return eventID;
    }

    public String getLink() {
        return Link;
    }
    
}
