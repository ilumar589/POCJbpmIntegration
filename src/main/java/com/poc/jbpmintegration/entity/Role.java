package com.poc.jbpmintegration.entity;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "role_id")
	private int id;
	@Enumerated(EnumType.STRING)
	@Column(name = "role")
	private UserCategory role;
}
