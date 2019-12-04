package phl.claim.claimsubmition.models;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PaymentMethod implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "ID")
    Integer id;
    @Id
    @Column(name = "DESCRIPTION")
    String title;

    @Column(name = "Checked")
    boolean checked;

    public PaymentMethod() {
    }

    public PaymentMethod(Integer id, String title, boolean checked) {
        this.id = id;
        this.title = title;
        this.checked = checked;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean getChecked() {
        return this.checked;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }

    public PaymentMethod id(Integer id) {
        this.id = id;
        return this;
    }

    public PaymentMethod title(String title) {
        this.title = title;
        return this;
    }

    public PaymentMethod checked(Boolean checked) {
        this.checked = checked;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof PaymentMethod)) {
            return false;
        }
        PaymentMethod paymentMethod = (PaymentMethod) o;
        return Objects.equals(id, paymentMethod.id) && Objects.equals(title, paymentMethod.title)
                && Objects.equals(checked, paymentMethod.checked);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, checked);
    }

    @Override
    public String toString() {
        return "{" + " id='" + getId() + "'" + ", title='" + getTitle() + "'" + ", checked='" + getChecked() + "'"
                + "}";
    }

}