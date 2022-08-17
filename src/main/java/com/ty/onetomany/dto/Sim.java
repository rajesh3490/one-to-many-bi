package com.ty.onetomany.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Sim {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int id;
	private long imrc;
	private String provider;

	@JoinColumn
	@ManyToOne
	private Mobile mobile;

	public Sim() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getImrc() {
		return imrc;
	}

	public void setImrc(long imrc) {
		this.imrc = imrc;
	}

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public Mobile getMobile() {
		return mobile;
	}

	public void setMobile(Mobile mobile) {
		this.mobile = mobile;
	}
}
