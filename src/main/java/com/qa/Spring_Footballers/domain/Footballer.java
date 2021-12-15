package com.qa.Spring_Footballers.domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Footballer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull(message = "Enter footballer's name")
	private String name;
	
	@Column
	private String club;
	
	@Column
	private int goals;
	
	//default
	public Footballer() {
		
	}
	
	//testing
	public Footballer(long id, @NotNull(message = "Enter footballer's name") String name, String club, int goals) {
		super();
		this.id = id;
		this.name = name;
		this.club = club;
		this.goals = goals;
	}

	//creating
	public Footballer(@NotNull(message = "Enter footballer's name") String name, String club, int goals) {
		super();
		this.name = name;
		this.club = club;
		this.goals = goals;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClub() {
		return club;
	}

	public void setClub(String club) {
		this.club = club;
	}

	public int getGoals() {
		return goals;
	}

	public void setGoals(int goals) {
		this.goals = goals;
	}

	@Override
	public int hashCode() {
		return Objects.hash(club, goals, id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Footballer other = (Footballer) obj;
		return Objects.equals(club, other.club) && goals == other.goals && id == other.id
				&& Objects.equals(name, other.name);
	}
	
}
