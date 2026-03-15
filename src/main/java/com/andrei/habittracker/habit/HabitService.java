package com.andrei.habittracker.habit;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HabitService {

    private final HabitRepository habitRepository;

    private HabitService(HabitRepository habitRepository) {
        this.habitRepository = habitRepository;
    }

    public HabitDTO getHabit(Long id) {
        return toDTO(habitRepository.findById(id).orElseThrow(() -> new RuntimeException("Habit not found with id: " + id)));
    }

    public List<HabitDTO> getAllHabits() {
        return habitRepository.findAll()
                .stream()
                .map(this::toDTO)
                .toList();
    }

    public HabitDTO createHabit(HabitDTO habitDTO) {

        Habit habit = new Habit();

        habit.setActivityType(habitDTO.getActivityType());
        habit.setDate(habitDTO.getDate());
        habit.setAmount(habitDTO.getAmount());
        return toDTO(habitRepository.save(habit));

    }

    public HabitDTO editHabit(HabitDTO habitDTO) {

        Habit habit = habitRepository.findById(habitDTO.getId())
                .orElseThrow(() -> new RuntimeException("Habit not found with id: " + habitDTO.getId()));

        habit.setActivityType(habitDTO.getActivityType());
        habit.setDate(habitDTO.getDate());
        habit.setAmount(habitDTO.getAmount());

        return toDTO(habitRepository.save(habit));
    }

    public void deleteHabit(Long id) {
        habitRepository.deleteById(id);
    }


    private HabitDTO toDTO(Habit habit) {
        HabitDTO dto = new HabitDTO();
        dto.setId(habit.getId());
        dto.setActivityType(habit.getActivityType());
        dto.setDate(habit.getDate());
        dto.setAmount(habit.getAmount());
        return dto;
    }

}
