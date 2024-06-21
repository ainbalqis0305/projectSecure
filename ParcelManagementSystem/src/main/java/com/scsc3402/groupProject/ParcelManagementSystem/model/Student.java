package com.scsc3402.groupProject.ParcelManagementSystem.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Long studentId;
    @Column(name = "matric_num")
    private String matricNum;
    @Column(name = "student_name")
    private String studentName;
    @Column(name = "phone_num")
    private String phoneNum;

    public Student() {
    }

    public Student(Long studentId, String matricNum, String studentName, String phoneNum) {
        this.studentId = studentId;
        this.matricNum = matricNum;
        this.studentName = studentName;
        this.phoneNum = phoneNum;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getMatricNum() {
        return matricNum;
    }

    public void setMatricNum(String matricNum) {
        this.matricNum = matricNum;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private Set<Parcel> parcels;

    public Set<Parcel> getParcels(){
        return  parcels;
    }

    public void setParcels(Set<Parcel> parcels){
        this.parcels = parcels;

    }


}
