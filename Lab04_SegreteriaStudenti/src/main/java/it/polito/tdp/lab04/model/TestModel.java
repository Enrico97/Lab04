package it.polito.tdp.lab04.model;

public class TestModel {

	public static void main(String[] args) {

		Model model = new Model();
		Corso c = model.getCorso("01KSUPG");
		Studente s = model.getStudente("161245");
		
		/*
		 * 	Write here your test model
		 */
		System.out.println(model.getElencoCorsi());
		System.out.println("----------");
		System.out.println(model.getStudentiIscritti());
		System.out.println("----------");
		System.out.println(model.getStudentiIscrittiAlCorso(c));
		System.out.println("----------");
		System.out.println(model.getCorsiStudente(s));
		System.out.println("----------");
		System.out.println(model.iscrivi(s, c));
	}

}
