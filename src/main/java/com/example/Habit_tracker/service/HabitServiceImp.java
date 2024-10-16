package com.example.Habit_tracker.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.Habit_tracker.model.Habit;

@Service
public class HabitServiceImp {
    private final List<Habit> habitList = new ArrayList<>();

    public List<Habit> getAllHabits() {
        return habitList;
    }
    
    // Get habits by date
    public List<Habit> getHabitsByDate(LocalDate date) {
        return habitList.stream()
                .filter(habit -> habit.getDate().isEqual(date))
                .collect(Collectors.toList());
    }

    public Habit createHabit(Habit habit) {
        habitList.add(habit);
        return habit;
    }

    public Habit updateHabit(Long id, Habit updatedHabit) {
        Habit habit = habitList.stream().filter(h -> h.getId().equals(id)).findFirst().orElse(null);
        if (habit != null) {
            habit.setName(updatedHabit.getName());
            habit.setDescription(updatedHabit.getDescription());
            habit.setCompleted(updatedHabit.isCompleted());
            habit.setRemarks(updatedHabit.getRemarks());
        }
        return habit;
    }

    public void deleteHabit(Long id) {
        habitList.removeIf(habit -> habit.getId().equals(id));
    }
}