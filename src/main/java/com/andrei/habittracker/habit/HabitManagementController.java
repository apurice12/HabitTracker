package com.andrei.habittracker.habit;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HabitManagementController {

    private final HabitService habitService;

    HabitManagementController(HabitService habitService) {
        this.habitService = habitService;
    }


    @GetMapping("/habits")
    public String habitManagement(Model model) {
        model.addAttribute("habits", habitService.getAllHabits());
        return "/habits";
    }

}
