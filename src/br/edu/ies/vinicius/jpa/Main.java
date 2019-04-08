package br.edu.ies.vinicius.jpa;

import br.edu.ies.vinicius.jpa.controller.PersonController;
import br.edu.ies.vinicius.jpa.model.Person;

public class Main {

	public static void main(String[] args) {

		Person person = new Person("Vinicius", "Minha casa");
		PersonController personController = new PersonController();

		personController.save(person);
		System.out.println(personController.contains(person));
	}
}
