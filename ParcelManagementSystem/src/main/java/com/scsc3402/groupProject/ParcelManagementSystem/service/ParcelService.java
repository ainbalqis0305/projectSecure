package com.scsc3402.groupProject.ParcelManagementSystem.service;


import com.scsc3402.groupProject.ParcelManagementSystem.model.Parcel;
import com.scsc3402.groupProject.ParcelManagementSystem.repository.ParcelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParcelService {
    @Autowired
    private ParcelRepository parcelRepository;

    public List<Parcel> listAll(String keyword) {
        if (keyword != null && !keyword.isEmpty()) {
            return parcelRepository.findByKeyword(keyword);
        } else {
            return (List<Parcel>) parcelRepository.findAll();
        }
    }
}
