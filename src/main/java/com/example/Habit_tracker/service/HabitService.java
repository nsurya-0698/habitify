package com.example.Habit_tracker.service;

import java.util.List;

import com.example.Habit_tracker.model.Habit;

public interface HabitService {
	
	List<Habit> getAllHabits();
    Habit getHabitById(Long id);
    Habit createHabit(Habit habit);
    Habit updateHabit(Long id, Habit habit);
    void deleteHabit(Long id);
}