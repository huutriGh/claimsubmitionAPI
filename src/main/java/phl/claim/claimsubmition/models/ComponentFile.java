package phl.claim.claimsubmition.models;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ComponentFile implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "Id")
    Integer id;

    @Column(name = "Component_Code")
    String componentCode;

    @Column(name = "Component_Name")
    String componentName;

    @Column(name = "Col_Num")
    Integer colNum;

    @Column(name = "Component_File_ID")
    String componentFileID;

    @Column(name = "Component_File_Name")
    String componentFilename;

    @Column(name = "Accident")
    String accident;

    @Column(name = "Pathological")
    String pathological;

    @Column(name = "Missing")
    String missing;

    @Column(name = "Fatal_Disease")
    String fatalDisease;

    public ComponentFile() {
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getComponentCode() {
        return this.componentCode;
    }

    public void setComponentCode(String componentCode) {
        this.componentCode = componentCode;
    }

    public String getComponentName() {
        return this.componentName;
    }

    public void setComponentName(String componentName) {
        this.componentName = componentName;
    }

    public Integer getColNum() {
        return this.colNum;
    }

    public void setColNum(Integer colNum) {
        this.colNum = colNum;
    }

    public String getComponentFileID() {
        return this.componentFileID;
    }

    public void setComponentFileID(String componentFileID) {
        this.componentFileID = componentFileID;
    }

    public String getComponentFilename() {
        return this.componentFilename;
    }

    public void setComponentFilename(String componentFilename) {
        this.componentFilename = componentFilename;
    }

    public String getAccident() {
        return this.accident;
    }

    public void setAccident(String accident) {
        this.accident = accident;
    }

    public String getPathological() {
        return this.pathological;
    }

    public void setPathological(String pathological) {
        this.pathological = pathological;
    }

    public String getMissing() {
        return this.missing;
    }

    public void setMissing(String missing) {
        this.missing = missing;
    }

    public String getFatalDisease() {
        return this.fatalDisease;
    }

    public void setFatalDisease(String fatalDisease) {
        this.fatalDisease = fatalDisease;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ComponentFile)) {
            return false;
        }
        ComponentFile componentFile = (ComponentFile) o;
        return Objects.equals(id, componentFile.id) && Objects.equals(componentCode, componentFile.componentCode)
                && Objects.equals(componentName, componentFile.componentName)
                && Objects.equals(colNum, componentFile.colNum)
                && Objects.equals(componentFileID, componentFile.componentFileID)
                && Objects.equals(componentFilename, componentFile.componentFilename)
                && Objects.equals(accident, componentFile.accident)
                && Objects.equals(pathological, componentFile.pathological)
                && Objects.equals(missing, componentFile.missing)
                && Objects.equals(fatalDisease, componentFile.fatalDisease);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, componentCode, componentName, colNum, componentFileID, componentFilename, accident,
                pathological, missing, fatalDisease);
    }

}