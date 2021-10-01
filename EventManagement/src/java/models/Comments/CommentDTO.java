/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.Comments;

import java.util.logging.Logger;

/**
 *
 * @author Dell
 */
public class CommentDTO {
    private int CommentID,PostID,userID;
    private String Comment;

    public CommentDTO(int CommentID, int EventID, int userID, String Comment) {
        this.CommentID = CommentID;
        this.PostID = EventID;
        this.userID = userID;
        this.Comment = Comment;
    }

    public CommentDTO(int EventID, int userID, String Comment) {
        this.PostID = EventID;
        this.userID = userID;
        this.Comment = Comment;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
    public int getUserID() {
        return userID;
    }

    
    public void setCommentID(int CommentID) {
        this.CommentID = CommentID;
    }

    public void setPostID(int EventID) {
        this.PostID = EventID;
    }



    public void setComment(String Comment) {
        this.Comment = Comment;
    }

    public int getCommentID() {
        return CommentID;
    }

    public int getPostID() {
        return PostID;
    }

 
    public String getComment() {
        return Comment;
    }
    
}
