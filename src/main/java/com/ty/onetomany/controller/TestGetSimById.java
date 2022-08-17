package com.ty.onetomany.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.ty.onetomany.dto.Mobile;
import com.ty.onetomany.dto.Sim;

public class TestGetSimById {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Sim sim = entityManager.find(Sim.class, 1);

		Mobile mobile = sim.getMobile();

		System.out.println("sim id is " + sim.getId());
		System.out.println("sim imrc is " + sim.getImrc());
		System.out.println("sim provider is " + sim.getProvider());

		if (mobile != null) {
			System.out.println("mobile id is " + mobile.getId());
			System.out.println("mobile name is " + mobile.getName());
			System.out.println("mobile cost is " + mobile.getCost());
		}
	}

}
