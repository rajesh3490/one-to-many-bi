package com.ty.onetomany.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.onetomany.dto.Brand;
import com.ty.onetomany.dto.Product;

public class TestSaveMultipleProducts {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Brand brand = entityManager.find(Brand.class, 1);
		List<Product> lp = brand.getProduct();

		Product product1 = new Product();
		product1.setCost(12000);
		product1.setName("AC");
		product1.setBrand(brand);
		lp.add(product1);

		Product product2 = new Product();
		product2.setCost(18000);
		product2.setName("aqua");
		product2.setBrand(brand);
		lp.add(product2);

		brand.setProduct(lp);

		entityTransaction.begin();
		entityManager.persist(product1);
		entityManager.persist(product2);
		entityTransaction.commit();
		System.out.println("data stored");

	}

}
