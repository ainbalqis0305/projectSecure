package com.scsc3402.groupProject.ParcelManagementSystem.controller;

import com.scsc3402.groupProject.ParcelManagementSystem.model.Parcel;
import com.scsc3402.groupProject.ParcelManagementSystem.repository.ParcelRepository;
import com.scsc3402.groupProject.ParcelManagementSystem.repository.StudentRepository;
import com.scsc3402.groupProject.ParcelManagementSystem.service.ParcelService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("/parcels")
public class ParcelController {
    private final ParcelRepository parcelRepository;
    private final StudentRepository studentRepository;

    @Autowired
    ParcelService parcelService;

    public ParcelController(ParcelRepository parcelRepository, StudentRepository studentRepository){
        this.parcelRepository = parcelRepository;
        this.studentRepository = studentRepository;
    }

    @GetMapping("list")
    public String showUpdateForm(Model model, @Param("keyword")String keyword){
        List<Parcel> parcels = parcelService.listAll(keyword);
        model.addAttribute("parcels", parcels);
        model.addAttribute("keyword", keyword);
        model.addAttribute("students", studentRepository.findAll());
        return "list-parcel";
    }

    @GetMapping("signup")
    public String showSignUpForm(Parcel parcel){
        return "add-parcel";
    }

    @PostMapping("add")
    public String addParcel(@Valid Parcel parcel, BindingResult result, Model model){
        if (result.hasErrors()){
            return "add-parcel";
        }

        parcelRepository.save(parcel);
        return "redirect:list";
    }


    @GetMapping("update")
    public String showUpdateMainForm(Model model){
        model.addAttribute("parcels", parcelRepository.findAll());
        return "choose-parcel-to-update";
    }

    @GetMapping("edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model){
        Parcel parcel = parcelRepository.findById((int) id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid parcel Id:" + id ));
        model.addAttribute("parcel", parcel);
        return "update-parcel";
    }

    @GetMapping("update/{id}")
    public String showUpdateMainForm(@PathVariable("id") long id, Model model) {
        Parcel parcel = parcelRepository.findById((int) id)
                .orElseThrow(()-> new IllegalArgumentException("Invalid parcel Id:" + id));

        model.addAttribute("parcel", parcel);
        model.addAttribute("student", studentRepository.findAll());
        return "update-parcel";
    }

    @PostMapping("update/{id}")
    public String updateStaff(@PathVariable("id") long id, @Valid Parcel updatedParcel, BindingResult result, Model model) {
        if (result.hasErrors()) {
            // If there are validation errors, return to the update form with error messages
            model.addAttribute("parcel", updatedParcel);
            model.addAttribute("students", studentRepository.findAll());
            return "update-parcel";
        }

        // Find the existing parcel by ID
        Parcel existingParcel = parcelRepository.findById((int) id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid parcel Id:" + id));

        // Update the existing parcel with the new information
        existingParcel.setTrackingNum(updatedParcel.getTrackingNum());
        existingParcel.setDateIn(updatedParcel.getDateIn());
        existingParcel.setDateOut(updatedParcel.getDateOut());
        existingParcel.setColour(updatedParcel.getColour());
        existingParcel.setStudent(updatedParcel.getStudent());

        // Save the updated parcel
        parcelRepository.save(existingParcel);

        // Redirect to the list page after successful update
        return "redirect:/parcels/list";
    }



    @GetMapping("delete")
    public String showDeleteMainForm(Model model) {
        model.addAttribute("parcels", parcelRepository.findAll());
        return "choose-parcel-to-delete";
    }

    @GetMapping("delete/{id}")
    public String deleteParcel(@PathVariable("id") long id, Model model){
        Parcel parcel = parcelRepository.findById((int) id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid parcel Id:" + id));
        parcelRepository.delete(parcel);
        model.addAttribute("parcels", parcelRepository.findAll());
        return "list-parcel";
    }
}
