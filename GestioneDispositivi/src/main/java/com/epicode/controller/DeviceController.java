package com.epicode.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epicode.model.Device;
import com.epicode.service.DeviceService;



@RestController
@RequestMapping("/api/devices")
public class DeviceController {
	
	@Autowired private DeviceService deviceService;
	
	@GetMapping
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<?> getAll() {
		return ResponseEntity.ok(deviceService.getAllDevices());
	}
	
	@GetMapping("/{id}")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<?> getById(@PathVariable Long id) {
		return ResponseEntity.ok(deviceService.getDeviceByID(id));
	}
	
	@PostMapping
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> save(@RequestBody Device device) {
		return ResponseEntity.ok(deviceService.createDevice(device));
	}
	
	@PutMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Device device) {
		return ResponseEntity.ok(deviceService.updateDevice(id, device));
	}
	
	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> remove(@PathVariable Long id) {
		return ResponseEntity.ok(deviceService.removeDevice(id));
	}

}