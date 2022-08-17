package com.ty.onetomany.controller;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.onetomany.dto.BioMetric;
import com.ty.onetomany.dto.Employees;

public class TestSaveEmployees {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		List<Employees> le = new ArrayList<Employees>();
		Employees employees = new Employees();
		employees.setEmpId("TCJJKJ788");
		employees.setName("rajesh");
		LocalTime loginTime = LocalTime.of(9, 30);
		employees.setLoginTime(loginTime);
		le.add(employees);

		Employees employee1 = new Employees();
		employee1.setEmpId("BKJJKJ788");
		employee1.setName("lokesh");
		LocalTime loginTime1 = LocalTime.of(9, 30);
		employee1.setLoginTime(loginTime1);
		le.add(employee1);

		BioMetric bioMetric1 = new BioMetric();
		bioMetric1.setStatus("active");
		bioMetric1.setEmployees(le);

		entityTransaction.begin();
		entityManager.persist(bioMetric1);
		entityManager.persist(employee1);
		entityManager.persist(employees);
		entityTransaction.commit();
		System.out.println("data is stored");

	}

}
