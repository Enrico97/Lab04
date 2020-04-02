package it.polito.tdp.lab04.model;

import java.util.*;

import it.polito.tdp.lab04.DAO.CorsoDAO;
import it.polito.tdp.lab04.DAO.StudenteDAO;

public class Model {
	
	CorsoDAO corso = new CorsoDAO();
	StudenteDAO studente = new StudenteDAO();

	public List<Corso> getElencoCorsi() {
		return corso.getTuttiICorsi();
	}
	public List<Studente> getStudentiIscritti() {
		return studente.getTuttiGliStudenti();
	}
	public List<Studente> getStudentiIscrittiAlCorso(Corso corso) {
		return this.corso.getStudentiIscrittiAlCorso(corso);
	}
	public Corso getCorso (String codins) {
		return corso.getCorso(codins);
	}
	public List<Corso> getCorsiStudente(Studente studente) {
		return this.studente.getCorsiStudente(studente);
	}
	public Studente getStudente(String matricola) {
		return studente.getStudente(matricola);
	}
	public boolean iscrivi(Studente studente2, Corso corso2) {
		return corso.inscriviStudenteACorso(studente2, corso2);
	}
}
