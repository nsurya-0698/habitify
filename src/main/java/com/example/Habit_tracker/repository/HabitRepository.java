package com.example.Habit_tracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Habit_tracker.model.Habit;

@Repository
public interface HabitRepository extends JpaRepository<Habit, Long>{

}
