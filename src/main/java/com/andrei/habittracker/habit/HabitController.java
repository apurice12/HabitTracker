package com.andrei.habittracker.habit;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HabitController {

    private final HabitService habitService;

    HabitController(HabitService habitService) {
        this.habitService = habitService;
    }

    @GetMapping("/api/habits")
    public List<HabitDTO> getHabits() {
        return habitService.getAllHabits();
    }

    @GetMapping("/api/habit/{id}")
    public HabitDTO getHabit(@PathVariable Long id) {
        return habitService.getHabit(id);
    }

    @PostMapping("/api/habit/create")
    public HabitDTO createHabit(@RequestBody HabitDTO habitDTO) {
        return habitService.createHabit(habitDTO);
    }

    @PutMapping("/api/habit/edit/{id}")
    public HabitDTO editHabit(@RequestBody HabitDTO habitDTO, @PathVariable Long id) {
        habitDTO.setId(id);
        return habitService.editHabit(habitDTO);
    }

    @DeleteMapping("/api/habit/{id}")
    public void deleteHabit(@PathVariable Long id) {
        habitService.deleteHabit(id);
    }

}
