package com.ty.onetomany.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.ty.onetomany.dto.Brand;
import com.ty.onetomany.dto.Product;

public class TestGetProductById {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Product product = entityManager.find(Product.class, 1);

		Brand brand = product.getBrand();
		System.out.println("product id is " + product.getId());
		System.out.println("product name is " + product.getName());
		System.out.println("product cost is " + product.getCost());

		if (brand != null) {
			System.out.println("brand id is " + brand.getId());
			System.out.println("brand name is " + brand.getName());
			System.out.println("brand type is " + brand.getType());
		}
	}

}
