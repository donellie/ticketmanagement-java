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
@Table(name = "POLICE_TABLE", catalog = "", schema = "APP")
@NamedQueries({
    @NamedQuery(name = "PoliceTable.findAll", query = "SELECT p FROM PoliceTable p"),
    @NamedQuery(name = "PoliceTable.findByBadgeNumber", query = "SELECT p FROM PoliceTable p WHERE p.badgeNumber = :badgeNumber"),
    @NamedQuery(name = "PoliceTable.findByStationNumber", query = "SELECT p FROM PoliceTable p WHERE p.stationNumber = :stationNumber"),
    @NamedQuery(name = "PoliceTable.findByTitle", query = "SELECT p FROM PoliceTable p WHERE p.title = :title"),
    @NamedQuery(name = "PoliceTable.findByFirstName", query = "SELECT p FROM PoliceTable p WHERE p.firstName = :firstName"),
    @NamedQuery(name = "PoliceTable.findByMiddleInitial", query = "SELECT p FROM PoliceTable p WHERE p.middleInitial = :middleInitial"),
    @NamedQuery(name = "PoliceTable.findByLastName", query = "SELECT p FROM PoliceTable p WHERE p.lastName = :lastName"),
    @NamedQuery(name = "PoliceTable.findByDateOfBirth", query = "SELECT p FROM PoliceTable p WHERE p.dateOfBirth = :dateOfBirth"),
    @NamedQuery(name = "PoliceTable.findByAddress1", query = "SELECT p FROM PoliceTable p WHERE p.address1 = :address1"),
    @NamedQuery(name = "PoliceTable.findByAddress2", query = "SELECT p FROM PoliceTable p WHERE p.address2 = :address2"),
    @NamedQuery(name = "PoliceTable.findByTelephone", query = "SELECT p FROM PoliceTable p WHERE p.telephone = :telephone")})
public class PoliceTable implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "BADGE_NUMBER")
    private Integer badgeNumber;
    @Basic(optional = false)
    @Column(name = "STATION_NUMBER")
    private int stationNumber;
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

    public PoliceTable() {
    }

    public PoliceTable(Integer badgeNumber) {
        this.badgeNumber = badgeNumber;
    }

    public PoliceTable(Integer badgeNumber, int stationNumber, String firstName, String lastName, String dateOfBirth, String address1, String address2) {
        this.badgeNumber = badgeNumber;
        this.stationNumber = stationNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.address1 = address1;
        this.address2 = address2;
    }

    public Integer getBadgeNumber() {
        return badgeNumber;
    }

    public void setBadgeNumber(Integer badgeNumber) {
        Integer oldBadgeNumber = this.badgeNumber;
        this.badgeNumber = badgeNumber;
        changeSupport.firePropertyChange("badgeNumber", oldBadgeNumber, badgeNumber);
    }

    public int getStationNumber() {
        return stationNumber;
    }

    public void setStationNumber(int stationNumber) {
        int oldStationNumber = this.stationNumber;
        this.stationNumber = stationNumber;
        changeSupport.firePropertyChange("stationNumber", oldStationNumber, stationNumber);
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (badgeNumber != null ? badgeNumber.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PoliceTable)) {
            return false;
        }
        PoliceTable other = (PoliceTable) object;
        if ((this.badgeNumber == null && other.badgeNumber != null) || (this.badgeNumber != null && !this.badgeNumber.equals(other.badgeNumber))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaproject.PoliceTable[ badgeNumber=" + badgeNumber + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
