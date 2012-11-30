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
@Table(name = "POLICE_DIVISION", catalog = "", schema = "APP")
@NamedQueries({
    @NamedQuery(name = "PoliceDivision.findAll", query = "SELECT p FROM PoliceDivision p"),
    @NamedQuery(name = "PoliceDivision.findByStationNumber", query = "SELECT p FROM PoliceDivision p WHERE p.stationNumber = :stationNumber"),
    @NamedQuery(name = "PoliceDivision.findByAddress1", query = "SELECT p FROM PoliceDivision p WHERE p.address1 = :address1"),
    @NamedQuery(name = "PoliceDivision.findByAddress2", query = "SELECT p FROM PoliceDivision p WHERE p.address2 = :address2"),
    @NamedQuery(name = "PoliceDivision.findByTelephone", query = "SELECT p FROM PoliceDivision p WHERE p.telephone = :telephone"),
    @NamedQuery(name = "PoliceDivision.findByStationName", query = "SELECT p FROM PoliceDivision p WHERE p.stationName = :stationName")})
public class PoliceDivision implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "STATION_NUMBER")
    private Integer stationNumber;
    @Column(name = "ADDRESS1")
    private String address1;
    @Column(name = "ADDRESS2")
    private String address2;
    @Column(name = "TELEPHONE")
    private Integer telephone;
    @Column(name = "STATION_NAME")
    private String stationName;

    public PoliceDivision() {
    }

    public PoliceDivision(Integer stationNumber) {
        this.stationNumber = stationNumber;
    }

    public Integer getStationNumber() {
        return stationNumber;
    }

    public void setStationNumber(Integer stationNumber) {
        Integer oldStationNumber = this.stationNumber;
        this.stationNumber = stationNumber;
        changeSupport.firePropertyChange("stationNumber", oldStationNumber, stationNumber);
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

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        String oldStationName = this.stationName;
        this.stationName = stationName;
        changeSupport.firePropertyChange("stationName", oldStationName, stationName);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stationNumber != null ? stationNumber.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PoliceDivision)) {
            return false;
        }
        PoliceDivision other = (PoliceDivision) object;
        if ((this.stationNumber == null && other.stationNumber != null) || (this.stationNumber != null && !this.stationNumber.equals(other.stationNumber))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaproject.PoliceDivision[ stationNumber=" + stationNumber + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
