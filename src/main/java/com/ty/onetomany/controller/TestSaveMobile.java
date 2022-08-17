package com.ty.onetomany.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.onetomany.dto.Mobile;
import com.ty.onetomany.dto.Sim;

public class TestSaveMobile {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Mobile mobile = new Mobile();
		mobile.setName("redmi");
		mobile.setCost(10000);

		Sim sim = new Sim();
		sim.setImrc(1234);
		sim.setProvider("jio");
		sim.setMobile(mobile);

		Sim sim1 = new Sim();
		sim1.setImrc(5678);
		sim1.setProvider("bsnl");
		sim1.setMobile(mobile);

		entityTransaction.begin();
		entityManager.persist(mobile);
		entityManager.persist(sim);
		entityManager.persist(sim1);
		entityTransaction.commit();

		System.out.println("data stored");
	}

}
