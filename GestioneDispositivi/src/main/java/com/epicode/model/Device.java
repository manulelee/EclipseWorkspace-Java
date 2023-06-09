package com.epicode.model;

import com.epicode.enumeration.DeviceStatus;
import com.epicode.enumeration.DeviceType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "devices")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Device {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column( nullable = false)
	private String description;
	
	@Column( nullable = false)
	@Enumerated(EnumType.STRING)
	private DeviceType type;
	
	@Column( nullable = false)
	@Enumerated(EnumType.STRING)
	private DeviceStatus status;

}
