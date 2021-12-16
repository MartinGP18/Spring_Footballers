package com.qa.Spring_Footballers.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.qa.Spring_Footballers.domain.Footballer;
import com.qa.Spring_Footballers.repo.FootballerRepo;

@Service
public class FootballerService implements ServiceMethods<Footballer> {
	
	private FootballerRepo repo;
	
	public FootballerService(FootballerRepo repo) {
		this.repo = repo;
	}

	@Override
	public Footballer create(Footballer footballer) {
		return this.repo.save(footballer);
	}

	@Override
	public List<Footballer> getAll() {
		return this.repo.findAll();
	}

	@Override
	public Footballer getById(long id) {
		Optional<Footballer> optionalFootballer = this.repo.findById(id);
		if(optionalFootballer.isPresent()) {
			return optionalFootballer.get();
		}
		return null;
	}

	@Override
	public Footballer update(long id, Footballer footballer) {
		Optional<Footballer> existingFootballer = this.repo.findById(id);
		if(existingFootballer.isPresent()) {
			Footballer existing = existingFootballer.get();
			existing.setName(footballer.getName());
			existing.setClub(footballer.getClub());
			existing.setGoals(footballer.getGoals());
			
			return this.repo.saveAndFlush(existing);
		}
		return null;
	}

	@Override
	public boolean delete(long id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}

}
