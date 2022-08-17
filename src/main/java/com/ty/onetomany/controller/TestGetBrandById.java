package com.ty.onetomany.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.ty.onetomany.dto.Brand;
import com.ty.onetomany.dto.Product;

public class TestGetBrandById {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Brand brand = entityManager.find(Brand.class, 1);

		List<Product> product = brand.getProduct();

		System.out.println("brand name is " + brand.getName());
		System.out.println("brand id is " + brand.getId());
		System.out.println("brand type is " + brand.getType());

		if (product != null) {
			for (Product product2 : product) {
				System.out.println("product id is " + product2.getId());
				System.out.println("product name is " + product2.getName());
				System.out.println("product cost is " + product2.getCost());
			}
		}
	}

}
