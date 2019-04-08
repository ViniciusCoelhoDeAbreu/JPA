package br.edu.ies.vinicius.jpa.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.edu.ies.vinicius.jpa.model.Person;

public class PersonController {

	private static final String PERSISTENCE_UNIT_NAME = new String("pessoasPU");

	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;

	public PersonController() {
		this.entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		this.entityManager = entityManagerFactory.createEntityManager();
	}

	public void save(Person person) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(person);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			System.out.println("Cannot persist person.");
		}
	}

	public boolean contains(Person person) {
		Query query = entityManager.createNativeQuery("SELECT * FROM pessoas WHERE name='" + person.getName() + "'");
		return query.getResultList().size() > 0;
	}
}
