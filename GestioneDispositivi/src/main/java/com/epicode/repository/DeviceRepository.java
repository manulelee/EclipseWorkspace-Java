package com.epicode.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.epicode.enumeration.DeviceStatus;
import com.epicode.model.Device;
import java.util.List;


@Repository
public interface DeviceRepository extends JpaRepository<Device, Long> {

}
