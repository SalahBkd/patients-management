package me.boukadi.springdatatp.demo.web;

import me.boukadi.springdatatp.demo.dao.PatientRepository;
import me.boukadi.springdatatp.demo.entity.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class PatientController {

    @Autowired
    PatientRepository patientRepository;

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/patients")
    public String GetPatients(Model model) {
        List<Patient> patients = patientRepository.findAll();
        model.addAttribute("patients", patients);
        return "patients";
    }
}
