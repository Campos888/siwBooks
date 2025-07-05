package merialdoProject.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
@PreAuthorize("hasAuthority('ADMIN')")
public class AdminController {

    @GetMapping
    public String adminHome() {
        return "admin/indexAdmin";
    }
    @GetMapping("/admin")
    public String adminDashboard(Model model) {
        return "indexAdmin";  // o il nome della tua view admin
    }

}
