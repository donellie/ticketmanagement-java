/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaproject;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Painmachine
 */
@Entity
@Table(name = "OFFENDER", catalog = "", schema = "APP")
@NamedQueries({
    @NamedQuery(name = "Offender.findAll", query = "SELECT o FROM Offender o"),
    @NamedQuery(name = "Offender.findByTrnNumber", query = "SELECT o FROM Offender o WHERE o.trnNumber = :trnNumber"),
    @NamedQuery(name = "Offender.findByTitle", query = "SELECT o FROM Offender o WHERE o.title = :title"),
    @NamedQuery(name = "Offender.findByFirstName", query = "SELECT o FROM Offender o WHERE o.firstName = :firstName"),
    @NamedQuery(name = "Offender.findByMiddleInitial", query = "SELECT o FROM Offender o WHERE o.middleInitial = :middleInitial"),
    @NamedQuery(name = "Offender.findByLastName", query = "SELECT o FROM Offender o WHERE o.lastName = :lastName"),
    @NamedQuery(name = "Offender.findByDateOfBirth", query = "SELECT o FROM Offender o WHERE o.dateOfBirth = :dateOfBirth"),
    @NamedQuery(name = "Offender.findByAddress1", query = "SELECT o FROM Offender o WHERE o.address1 = :address1"),
    @NamedQuery(name = "Offender.findByAddress2", query = "SELECT o FROM Offender o WHERE o.address2 = :address2"),
    @NamedQuery(name = "Offender.findByTelephone", query = "SELECT o FROM Offender o WHERE o.telephone = :telephone"),
    @NamedQuery(name = "Offender.findByLicenseType", query = "SELECT o FROM Offender o WHERE o.licenseType = :licenseType"),
    @NamedQuery(name = "Offender.findByLicensePoints", query = "SELECT o FROM Offender o WHERE o.licensePoints = :licensePoints"),
    @NamedQuery(name = "Offender.findByLicenseExpirydate", query = "SELECT o FROM Offender o WHERE o.licenseExpirydate = :licenseExpirydate")})
public class Offender implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "TRN_NUMBER")
    private Integer trnNumber;
    @Column(name = "TITLE")
    private String title;
    @Basic(optional = false)
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "MIDDLE_INITIAL")
    private String middleInitial;
    @Basic(optional = false)
    @Column(name = "LAST_NAME")
    private String lastName;
    @Basic(optional = false)
    @Column(name = "DATE_OF_BIRTH")
    private String dateOfBirth;
    @Basic(optional = false)
    @Column(name = "ADDRESS1")
    private String address1;
    @Basic(optional = false)
    @Column(name = "ADDRESS2")
    private String address2;
    @Column(name = "TELEPHONE")
    private Integer telephone;
    @Column(name = "LICENSE_TYPE")
    private String licenseType;
    @Column(name = "LICENSE_POINTS")
    private Integer licensePoints;
    @Column(name = "LICENSE_EXPIRYDATE")
    private String licenseExpirydate;

    public Offender() {
    }

    public Offender(Integer trnNumber) {
        this.trnNumber = trnNumber;
    }

    public Offender(Integer trnNumber, String firstName, String lastName, String dateOfBirth, String address1, String address2) {
        this.trnNumber = trnNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.address1 = address1;
        this.address2 = address2;
    }

    public Integer getTrnNumber() {
        return trnNumber;
    }

    public void setTrnNumber(Integer trnNumber) {
        Integer oldTrnNumber = this.trnNumber;
        this.trnNumber = trnNumber;
        changeSupport.firePropertyChange("trnNumber", oldTrnNumber, trnNumber);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        String oldTitle = this.title;
        this.title = title;
        changeSupport.firePropertyChange("title", oldTitle, title);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        String oldFirstName = this.firstName;
        this.firstName = firstName;
        changeSupport.firePropertyChange("firstName", oldFirstName, firstName);
    }

    public String getMiddleInitial() {
        return middleInitial;
    }

    public void setMiddleInitial(String middleInitial) {
        String oldMiddleInitial = this.middleInitial;
        this.middleInitial = middleInitial;
        changeSupport.firePropertyChange("middleInitial", oldMiddleInitial, middleInitial);
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        String oldLastName = this.lastName;
        this.lastName = lastName;
        changeSupport.firePropertyChange("lastName", oldLastName, lastName);
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        String oldDateOfBirth = this.dateOfBirth;
        this.dateOfBirth = dateOfBirth;
        changeSupport.firePropertyChange("dateOfBirth", oldDateOfBirth, dateOfBirth);
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        String oldAddress1 = this.address1;
        this.address1 = address1;
        changeSupport.firePropertyChange("address1", oldAddress1, address1);
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        String oldAddress2 = this.address2;
        this.address2 = address2;
        changeSupport.firePropertyChange("address2", oldAddress2, address2);
    }

    public Integer getTelephone() {
        return telephone;
    }

    public void setTelephone(Integer telephone) {
        Integer oldTelephone = this.telephone;
        this.telephone = telephone;
        changeSupport.firePropertyChange("telephone", oldTelephone, telephone);
    }

    public String getLicenseType() {
        return licenseType;
    }

    public void setLicenseType(String licenseType) {
        String oldLicenseType = this.licenseType;
        this.licenseType = licenseType;
        changeSupport.firePropertyChange("licenseType", oldLicenseType, licenseType);
    }

    public Integer getLicensePoints() {
        return licensePoints;
    }

    public void setLicensePoints(Integer licensePoints) {
        Integer oldLicensePoints = this.licensePoints;
        this.licensePoints = licensePoints;
        changeSupport.firePropertyChange("licensePoints", oldLicensePoints, licensePoints);
    }

    public String getLicenseExpirydate() {
        return licenseExpirydate;
    }

    public void setLicenseExpirydate(String licenseExpirydate) {
        String oldLicenseExpirydate = this.licenseExpirydate;
        this.licenseExpirydate = licenseExpirydate;
        changeSupport.firePropertyChange("licenseExpirydate", oldLicenseExpirydate, licenseExpirydate);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (trnNumber != null ? trnNumber.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Offender)) {
            return false;
        }
        Offender other = (Offender) object;
        if ((this.trnNumber == null && other.trnNumber != null) || (this.trnNumber != null && !this.trnNumber.equals(other.trnNumber))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaproject.Offender[ trnNumber=" + trnNumber + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
