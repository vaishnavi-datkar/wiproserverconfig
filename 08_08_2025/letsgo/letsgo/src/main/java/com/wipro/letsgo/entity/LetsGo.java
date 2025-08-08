package com.wipro.letsgo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
@Entity
@Table(name = "vehicle_movements")
@Data
public class LetsGo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="move_id")
	long id;
	@Column(name = "vehicle_id")
    int vehId;

    @Column(name = "latitude")
     double lat;

    @Column(name = "longitude")
	
	double longitude;
	

}
