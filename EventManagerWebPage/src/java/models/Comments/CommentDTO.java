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
    private int CommentID,EventID;
    private String UserName,Comment
           ;

    public CommentDTO(int CommentID, int EventID, String UserName, String Comment) {
        this.CommentID = CommentID;
        this.EventID = EventID;
        this.UserName = UserName;
        this.Comment = Comment;
    }

    public CommentDTO(int EventID, String UserName, String Comment) {
        this.EventID = EventID;
        this.UserName = UserName;
        this.Comment = Comment;
    }
    
    public void setCommentID(int CommentID) {
        this.CommentID = CommentID;
    }

    public void setEventID(int EventID) {
        this.EventID = EventID;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public void setComment(String Comment) {
        this.Comment = Comment;
    }

    public int getCommentID() {
        return CommentID;
    }

    public int getEventID() {
        return EventID;
    }

    public String getUserName() {
        return UserName;
    }

    public String getComment() {
        return Comment;
    }
    
}
