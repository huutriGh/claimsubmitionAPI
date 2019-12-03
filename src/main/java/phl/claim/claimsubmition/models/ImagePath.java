package phl.claim.claimsubmition.models;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * This is class is required for creating a response containing the JWT to be
 * returned to the user.
 */
@Entity
public class ImagePath implements Serializable {
    private static final long serialVersionUID = -8091879091924046844L;

    @Id
    @Column(name = "path")
    private String path;
    @Column(name = "type")
    private String type;

    public ImagePath() {
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ImagePath(String path, String type) {
        this.path = path;
        this.type = type;
    }

    public String getPath() {
        return this.path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ImagePath)) {
            return false;
        }
        ImagePath imagePath = (ImagePath) o;
        return Objects.equals(path, imagePath.path) && Objects.equals(type, imagePath.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(path, type);
    }

    public ImagePath path(String path) {
        this.path = path;
        return this;
    }

}