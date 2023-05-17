package com.jdbcProject;

import java.time.LocalDate;

public class Studente {

	
	private Integer id;
	private String nome;
	private String cognome;
	private String gender;
	private LocalDate birthdate;
	private double avg;
	private int min_vote;
	public int max_vote;
	
	public Studente(Integer id, String nome, String cognome, String gender, LocalDate birthdate, double avg, int min_vote, int max_vote) {
		super();
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.gender = gender;
		this.birthdate= birthdate;
		this.avg = avg;
		this.min_vote = min_vote;
		this.max_vote = max_vote;
	}

	public Studente(String nome, String cognome, String gender, LocalDate birthdate, double avg, int min_vote, int max_vote) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.gender = gender;
		this.avg = avg;
		this.birthdate= birthdate;
		this.min_vote = min_vote;
		this.max_vote = max_vote;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public LocalDate getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}

	public int getMin_vote() {
		return min_vote;
	}

	public void setMin_vote(int min_vote) {
		this.min_vote = min_vote;
	}

	public int getMax_vote() {
		return max_vote;
	}

	public void setMax_vote(int max_vote) {
		this.max_vote = max_vote;
	}
	
	
	
	
}
