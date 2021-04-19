package me.boukadi.springdatatp.demo.web;

import me.boukadi.springdatatp.demo.dao.PatientRepository;
import me.boukadi.springdatatp.demo.entity.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String GetPatients(Model model,
                              @RequestParam(name = "page", defaultValue = "0") int page,
                              @RequestParam(name = "size", defaultValue = "5") int size,
                              @RequestParam(name = "keyword", defaultValue = "") String patientName) {
        Page<Patient> pagePatients = patientRepository.findByNomContains(patientName, PageRequest.of(page, size));
        model.addAttribute("patients", pagePatients);
        model.addAttribute("pages", new int[pagePatients.getTotalPages()]);
        model.addAttribute("currentPage", page);
        model.addAttribute("keyword", patientName);
        return "patients";
    }
}
