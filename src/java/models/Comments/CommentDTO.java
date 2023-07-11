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
    private String Comment,Name;

    public String getName() {
        return Name;
    }

    public CommentDTO(int CommentID, int PostID, int userID, String Comment, String Name) {
        this.CommentID = CommentID;
        this.PostID = PostID;
        this.userID = userID;
        this.Comment = Comment;
        this.Name = Name;
    }

    public CommentDTO(int CommentID, int postID, int userID, String Comment) {
        this.CommentID = CommentID;
        this.PostID = postID;
        this.userID = userID;
        this.Comment = Comment;
    }

    public CommentDTO(int postID, int userID, String Comment) {
        this.PostID = postID;
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

    public void setPostID(int postID) {
        this.PostID = postID;
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
