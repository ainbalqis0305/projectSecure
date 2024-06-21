package com.scsc3402.groupProject.ParcelManagementSystem.repository;

import com.scsc3402.groupProject.ParcelManagementSystem.model.Parcel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParcelRepository extends JpaRepository<Parcel, Integer> {
    @Query("SELECT parcel FROM Parcel parcel WHERE CONCAT(parcel.parcelId,'',parcel.trackingNum,'',parcel.dateIn,'',parcel.dateOut,'',parcel.colour)LIKE %?1%")
    public List<Parcel> findByKeyword(String keyword);
}
