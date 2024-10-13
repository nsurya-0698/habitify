package com.example.Habit_tracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Habit_tracker.model.Habit;
import com.example.Habit_tracker.repository.HabitRepository;

@Service
public class HabitServiceImp implements HabitService {
	@Autowired
	private HabitRepository habitRepository;

	@Override
	public List<Habit> getAllHabits() {
		return habitRepository.findAll();
	}

	@Override
	public Habit getHabitById(Long id) {
		return habitRepository.findById(id).orElseThrow(() -> new RuntimeException("Habit not found"));
	}

	@Override
	public Habit createHabit(Habit habit) {
		return habitRepository.save(habit);
	}

	@Override
	public Habit updateHabit(Long id, Habit updatedHabit) {
		Habit existingHabit = getHabitById(id);
		existingHabit.setName(updatedHabit.getName());
		existingHabit.setDescription(updatedHabit.getDescription());
		existingHabit.setCompleted(updatedHabit.getCompleted());
		existingHabit.setRemarks(updatedHabit.getRemarks());
		return habitRepository.save(existingHabit);
	}

	@Override
	public void deleteHabit(Long id) {
		habitRepository.deleteById(id);
	}
}
