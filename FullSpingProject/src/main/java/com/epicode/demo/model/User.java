package com.epicode.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity //Entiotà del database
@Table (name="users") //nome della tabella che andra a mappre nel db
@NoArgsConstructor //Costruttore senza parametri
@AllArgsConstructor // Costruttore con tutti i parametri
@Data //Getter, Setter, to String e HashCode

public class User {
	
	@Id //primary key della tabella
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false) //campo not null
	private String name;
	@Column(nullable = false) //campo not null
	private String lastname;
	private String city;
	private Integer age;
	@Column(nullable = false, unique = true) //campo not null e unique
	private String email;
	@Column(nullable = false, length = 6) //campo not null con lunghezza minima
	private String password;
}
