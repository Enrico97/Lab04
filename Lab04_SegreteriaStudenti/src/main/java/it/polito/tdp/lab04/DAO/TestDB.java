package it.polito.tdp.lab04.DAO;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Studente;

public class TestDB {

	public static void main(String[] args) {

		/*
		 * 	This is a main to check the DB connection
		 */
		
		CorsoDAO cdao = new CorsoDAO();
		
		cdao.getTuttiICorsi();
		System.out.println(cdao.getTuttiICorsi());
		System.out.println("----------");
		
		StudenteDAO sdao = new StudenteDAO();
		
		System.out.println(sdao.getTuttiGliStudenti());
		System.out.println("----------");
		
		Corso c = cdao.getCorso("09AQGPG");
		System.out.println(cdao.getStudentiIscrittiAlCorso(c));
		System.out.println("----------");
		
		Studente s = sdao.getStudente("161245");
		System.out.println(sdao.getCorsiStudente(s));
		System.out.println("----------");
		
		System.out.println(cdao.inscriviStudenteACorso(s, c));
		System.out.println("----------");

	}

}
