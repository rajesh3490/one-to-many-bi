package com.ty.onetomany.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.onetomany.dto.Brand;
import com.ty.onetomany.dto.Product;

public class TestSaveBrand {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Brand brand = new Brand();
		brand.setName("LG");
		brand.setType("electronics");

		Product product1 = new Product();
		product1.setName("TV");
		product1.setCost(20000);
		product1.setBrand(brand);

		Product product2 = new Product();
		product2.setName("Washing Machine");
		product2.setCost(15000);
		product2.setBrand(brand);

		entityTransaction.begin();
		entityManager.persist(brand);
		entityManager.persist(product1);
		entityManager.persist(product2);
		entityTransaction.commit();
		System.out.println("data stored");
	}

}
