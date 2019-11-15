package phl.claim.claimsubmition.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Note implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "Note_ID")
    Integer noteID;
    @Id
    @Column(name = "Note_Detail_Id")
    Integer noteDetailId;

    @Column(name = "Note_Header")
    String noteHeader;

    @Column(name = "Note_Detail_Desc")
    String noteDetailDesc;

    @Column(name = "Note_Order")
    Integer noteOrder;

    public Note() {
    }

    public Integer getNoteID() {
        return this.noteID;
    }

    public void setNoteID(Integer noteID) {
        this.noteID = noteID;
    }

    public Integer getNoteDetailId() {
        return this.noteDetailId;
    }

    public void setNoteDetailId(Integer noteDetailId) {
        this.noteDetailId = noteDetailId;
    }

    public String getNoteHeader() {
        return this.noteHeader;
    }

    public void setNoteHeader(String noteHeader) {
        this.noteHeader = noteHeader;
    }

    public String getNoteDetailDesc() {
        return this.noteDetailDesc;
    }

    public void setNoteDetailDesc(String noteDetailDesc) {
        this.noteDetailDesc = noteDetailDesc;
    }

    public Integer getNoteOrder() {
        return this.noteOrder;
    }

    public void setNoteOrder(Integer noteOrder) {
        this.noteOrder = noteOrder;
    }

}