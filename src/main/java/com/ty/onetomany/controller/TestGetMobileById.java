package com.ty.onetomany.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.ty.onetomany.dto.Mobile;
import com.ty.onetomany.dto.Sim;

public class TestGetMobileById {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Mobile mobile = entityManager.find(Mobile.class, 1);

		List<Sim> ls = mobile.getSim();

		System.out.println("mobile id is " + mobile.getId());
		System.out.println("mobile name is " + mobile.getName());
		System.out.println("mobile cost is " + mobile.getCost());

		if (ls != null) {
			for (Sim sim : ls) {
				System.out.println("sim id is " + sim.getId());
				System.out.println("sim imrc is " + sim.getImrc());
				System.out.println("sim provider is " + sim.getProvider());
			}
		}

	}

}
