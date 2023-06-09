package com.epicode.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epicode.enumeration.DeviceStatus;
import com.epicode.model.Device;
import com.epicode.repository.DeviceRepository;

import jakarta.persistence.EntityExistsException;

@Service
public class DeviceService {
	
	@Autowired private DeviceRepository repository;
	
	public List<Device> getAllDevices() {
		return repository.findAll();
	}

	public Device getDeviceByID(Long id) {
		if(!repository.existsById(id)) {
			throw new EntityExistsException("Device " + id + " does not exists");
		}
		return repository.findById(id).get();
	}

	public Device createDevice(Device device) {
		return repository.save(device);
	}

	public Device updateDevice(Long id, Device device) {
		if(!repository.existsById(id)) {
			throw new EntityExistsException("Device " + id + " does not exists");
		}
		return repository.save(device);
	}

	public String removeDevice(Long id) {
		if(!repository.existsById(id)) {
			throw new EntityExistsException("Device " + id + " does not exists");
		}
		repository.deleteById(id);
		return "device " + id + " has been deleted!";
	}

}
