package com.minimum.service;

import java.util.List;
import java.util.Optional;

import com.minimum.model.ChildTracker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.minimum.repo.ChildTrackerRepo;


@Service
public class ChildTrackerService {

	@Autowired
	private ChildTrackerRepo rfidEkombiKombiTrackerRepository;

	public List<ChildTracker> findAll() {
		return (List<ChildTracker>) rfidEkombiKombiTrackerRepository.findAll();
	}

	public Optional<ChildTracker> findOne(int id) {
		return rfidEkombiKombiTrackerRepository.findById(id);
	}

	public ChildTracker saveR(ChildTracker childTracker) {
		return rfidEkombiKombiTrackerRepository.save(childTracker);
	}

	public void save(ChildTracker b) {
		rfidEkombiKombiTrackerRepository.save(b);
	}

	public void delete(int id) {
		rfidEkombiKombiTrackerRepository.deleteById(id);
	}

}
