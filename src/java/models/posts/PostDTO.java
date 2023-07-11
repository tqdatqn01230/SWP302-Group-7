/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.posts;

/**
 *
 * @author Dell
 */
public class PostDTO {
    private int postID,eventID;
    public String PostContent;

    public PostDTO(int eventID, String PostContent) {
        this.eventID = eventID;
        this.PostContent = PostContent;
    }

    public PostDTO(int postID, int eventID, String PostContent) {
        this.postID = postID;
        this.eventID = eventID;
        this.PostContent = PostContent;
    }

    public void setPostID(int postID) {
        this.postID = postID;
    }

    public void setEventID(int eventID) {
        this.eventID = eventID;
    }

    public void setPostContent(String PostContent) {
        this.PostContent = PostContent;
    }

    public int getPostID() {
        return postID;
    }

    public int getEventID() {
        return eventID;
    }

    public String getPostContent() {
        return PostContent;
    }
    
}
