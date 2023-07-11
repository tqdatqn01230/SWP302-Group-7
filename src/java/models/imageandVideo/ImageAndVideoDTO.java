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
    private int ImageID,postID;
    private String Link;

    public ImageAndVideoDTO(int ImageID, int PostID, String Link) {
        this.ImageID = ImageID;
        this.postID = PostID;
        this.Link = Link;
    }

    public ImageAndVideoDTO(int postID, String Link) {
        this.postID = postID;
        this.Link = Link;
    }
    
    public void setImageID(int ImageID) {
        this.ImageID = ImageID;
    }

    public void setPostID(int postID) {
        this.postID = postID;
    }

    public int getPostID() {
        return postID;
    }


    public void setLink(String Link) {
        this.Link = Link;
    }

    public int getImageID() {
        return ImageID;
    }


    public String getLink() {
        return Link;
    }
    
}
