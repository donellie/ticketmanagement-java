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
@Table(name = "TICKETS", catalog = "", schema = "APP")
@NamedQueries({
    @NamedQuery(name = "Tickets.findAll", query = "SELECT t FROM Tickets t"),
    @NamedQuery(name = "Tickets.findByTicketNumber", query = "SELECT t FROM Tickets t WHERE t.ticketNumber = :ticketNumber"),
    @NamedQuery(name = "Tickets.findByTrnNumber", query = "SELECT t FROM Tickets t WHERE t.trnNumber = :trnNumber"),
    @NamedQuery(name = "Tickets.findByBadgeNumber", query = "SELECT t FROM Tickets t WHERE t.badgeNumber = :badgeNumber"),
    @NamedQuery(name = "Tickets.findByOffenseNumber", query = "SELECT t FROM Tickets t WHERE t.offenseNumber = :offenseNumber"),
    @NamedQuery(name = "Tickets.findByOffenseName", query = "SELECT t FROM Tickets t WHERE t.offenseName = :offenseName"),
    @NamedQuery(name = "Tickets.findByDateOfOffense", query = "SELECT t FROM Tickets t WHERE t.dateOfOffense = :dateOfOffense"),
    @NamedQuery(name = "Tickets.findByPlaceOfOffense", query = "SELECT t FROM Tickets t WHERE t.placeOfOffense = :placeOfOffense"),
    @NamedQuery(name = "Tickets.findByDescription", query = "SELECT t FROM Tickets t WHERE t.description = :description"),
    @NamedQuery(name = "Tickets.findByFine", query = "SELECT t FROM Tickets t WHERE t.fine = :fine"),
    @NamedQuery(name = "Tickets.findByPoints", query = "SELECT t FROM Tickets t WHERE t.points = :points"),
    @NamedQuery(name = "Tickets.findByPaymentStatus", query = "SELECT t FROM Tickets t WHERE t.paymentStatus = :paymentStatus")})
public class Tickets implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "TICKET_NUMBER")
    private Integer ticketNumber;
    @Basic(optional = false)
    @Column(name = "TRN_NUMBER")
    private int trnNumber;
    @Basic(optional = false)
    @Column(name = "BADGE_NUMBER")
    private int badgeNumber;
    @Basic(optional = false)
    @Column(name = "OFFENSE_NUMBER")
    private int offenseNumber;
    @Basic(optional = false)
    @Column(name = "OFFENSE_NAME")
    private String offenseName;
    @Basic(optional = false)
    @Column(name = "DATE_OF_OFFENSE")
    private String dateOfOffense;
    @Basic(optional = false)
    @Column(name = "PLACE_OF_OFFENSE")
    private String placeOfOffense;
    @Basic(optional = false)
    @Column(name = "DESCRIPTION")
    private String description;
    @Basic(optional = false)
    @Column(name = "FINE")
    private int fine;
    @Basic(optional = false)
    @Column(name = "POINTS")
    private int points;
    @Basic(optional = false)
    @Column(name = "PAYMENT_STATUS")
    private String paymentStatus;

    public Tickets() {
    }

    public Tickets(Integer ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public Tickets(Integer ticketNumber, int trnNumber, int badgeNumber, int offenseNumber, String offenseName, String dateOfOffense, String placeOfOffense, String description, int fine, int points, String paymentStatus) {
        this.ticketNumber = ticketNumber;
        this.trnNumber = trnNumber;
        this.badgeNumber = badgeNumber;
        this.offenseNumber = offenseNumber;
        this.offenseName = offenseName;
        this.dateOfOffense = dateOfOffense;
        this.placeOfOffense = placeOfOffense;
        this.description = description;
        this.fine = fine;
        this.points = points;
        this.paymentStatus = paymentStatus;
    }

    public Integer getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(Integer ticketNumber) {
        Integer oldTicketNumber = this.ticketNumber;
        this.ticketNumber = ticketNumber;
        changeSupport.firePropertyChange("ticketNumber", oldTicketNumber, ticketNumber);
    }

    public int getTrnNumber() {
        return trnNumber;
    }

    public void setTrnNumber(int trnNumber) {
        int oldTrnNumber = this.trnNumber;
        this.trnNumber = trnNumber;
        changeSupport.firePropertyChange("trnNumber", oldTrnNumber, trnNumber);
    }

    public int getBadgeNumber() {
        return badgeNumber;
    }

    public void setBadgeNumber(int badgeNumber) {
        int oldBadgeNumber = this.badgeNumber;
        this.badgeNumber = badgeNumber;
        changeSupport.firePropertyChange("badgeNumber", oldBadgeNumber, badgeNumber);
    }

    public int getOffenseNumber() {
        return offenseNumber;
    }

    public void setOffenseNumber(int offenseNumber) {
        int oldOffenseNumber = this.offenseNumber;
        this.offenseNumber = offenseNumber;
        changeSupport.firePropertyChange("offenseNumber", oldOffenseNumber, offenseNumber);
    }

    public String getOffenseName() {
        return offenseName;
    }

    public void setOffenseName(String offenseName) {
        String oldOffenseName = this.offenseName;
        this.offenseName = offenseName;
        changeSupport.firePropertyChange("offenseName", oldOffenseName, offenseName);
    }

    public String getDateOfOffense() {
        return dateOfOffense;
    }

    public void setDateOfOffense(String dateOfOffense) {
        String oldDateOfOffense = this.dateOfOffense;
        this.dateOfOffense = dateOfOffense;
        changeSupport.firePropertyChange("dateOfOffense", oldDateOfOffense, dateOfOffense);
    }

    public String getPlaceOfOffense() {
        return placeOfOffense;
    }

    public void setPlaceOfOffense(String placeOfOffense) {
        String oldPlaceOfOffense = this.placeOfOffense;
        this.placeOfOffense = placeOfOffense;
        changeSupport.firePropertyChange("placeOfOffense", oldPlaceOfOffense, placeOfOffense);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        String oldDescription = this.description;
        this.description = description;
        changeSupport.firePropertyChange("description", oldDescription, description);
    }

    public int getFine() {
        return fine;
    }

    public void setFine(int fine) {
        int oldFine = this.fine;
        this.fine = fine;
        changeSupport.firePropertyChange("fine", oldFine, fine);
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        int oldPoints = this.points;
        this.points = points;
        changeSupport.firePropertyChange("points", oldPoints, points);
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        String oldPaymentStatus = this.paymentStatus;
        this.paymentStatus = paymentStatus;
        changeSupport.firePropertyChange("paymentStatus", oldPaymentStatus, paymentStatus);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ticketNumber != null ? ticketNumber.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tickets)) {
            return false;
        }
        Tickets other = (Tickets) object;
        if ((this.ticketNumber == null && other.ticketNumber != null) || (this.ticketNumber != null && !this.ticketNumber.equals(other.ticketNumber))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaproject.Tickets[ ticketNumber=" + ticketNumber + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
