package com.scsc3402.groupProject.ParcelManagementSystem.model;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
public class Parcel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "parcel_id")
    private Integer parcelId;

    @Column(name="tracking_num")
    private String trackingNum;

    @Column(name = "date_in")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateIn;

    @Column(name = "date_out")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateOut;

    @Column(name = "colour")
    private String colour;

    @ManyToOne
    @JoinColumn(name="student_id", nullable = false)
    private Student student;

    public Parcel() {
    }

    public Integer getParcelId() {
        return parcelId;
    }

    public void setParcelId(Integer parcelId) {
        this.parcelId = parcelId;
    }

    public String getTrackingNum() {
        return trackingNum;
    }

    public void setTrackingNum(String trackingNum) {
        this.trackingNum = trackingNum;
    }

    public Date getDateIn() {
        return dateIn;
    }

    public void setDateIn(Date dateIn) {
        this.dateIn = dateIn;
    }

    public Date getDateOut() {
        return dateOut;
    }

    public void setDateOut(Date dateOut) {
        this.dateOut = dateOut;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public Student getStudent(){
        return  student;
    }

    public void setStudent(Student student){
        this.student = student;
    }

    @Override
    public String toString() {
        return "Parcel{" +
                "parcelId=" + parcelId +
                ", trackingNum='" + trackingNum + '\'' +
                ", dateIn=" + dateIn +
                ", dateOut=" + dateOut +
                ", colour='" + colour + '\'' +
                '}';
    }
}
