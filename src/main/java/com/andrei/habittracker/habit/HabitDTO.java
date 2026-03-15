package com.andrei.habittracker.habit;

import java.time.LocalDate;

public class HabitDTO {

    private Long id;
    private String activityType;
    private LocalDate date;
    private double amount;

    public HabitDTO() {
    }

    public HabitDTO(Long id, String activityType, LocalDate date, double amount) {
        this.id = id;
        this.activityType = activityType;
        this.date = date;
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getActivityType() {
        return activityType;
    }

    public void setActivityType(String activityType) {
        this.activityType = activityType;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
