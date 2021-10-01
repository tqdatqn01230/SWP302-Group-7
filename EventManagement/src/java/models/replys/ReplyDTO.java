/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.replys;

/**
 *
 * @author Dell
 */
public class ReplyDTO {
    private int replyID,CommentID,userID;
    String Reply;

    public ReplyDTO(int replyID, int CommentID, int userID, String Reply) {
        this.replyID = replyID;
        this.CommentID = CommentID;
        this.userID = userID;
        this.Reply = Reply;
    }

    public ReplyDTO(int CommentID, int userID, String Reply) {
        this.CommentID = CommentID;
        this.userID = userID;
        this.Reply = Reply;
    }

    public void setReplyID(int replyID) {
        this.replyID = replyID;
    }

    public void setCommentID(int CommentID) {
        this.CommentID = CommentID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public void setReply(String Reply) {
        this.Reply = Reply;
    }

    public int getReplyID() {
        return replyID;
    }

    public int getCommentID() {
        return CommentID;
    }

    public int getUserID() {
        return userID;
    }

    public String getReply() {
        return Reply;
    }
    
}
