package it.polito.tdp.lab04.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Studente;

public class StudenteDAO {
	
	public List<Studente> getTuttiGliStudenti() {

		final String sql = "SELECT * FROM studente";

		List<Studente> studenti = new LinkedList<>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				String matricola = rs.getString("matricola");
				String cognome = rs.getString("cognome");
				String nome = rs.getString("nome");
				String CDS = rs.getString("CDS");

				System.out.println(matricola + " " + cognome + " " + nome + " " + CDS);

				// Crea un nuovo JAVA Bean Studente
				Studente studente = new Studente (matricola, cognome, nome, CDS);
				// Aggiungi il nuovo oggetto Studente alla lista studenti
				studenti.add(studente);
				
			}

			conn.close();
			
			return studenti;
			

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db", e);
		}
	}
	public List<Corso> getCorsiStudente (Studente studente) {
		
		final String sql = "SELECT * FROM corso WHERE codins in (select codins from iscrizione where matricola = ? )"; 
		List<Corso> corsistudente = new LinkedList<>();
		
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, studente.getMatricola());
			ResultSet rs = st.executeQuery();
			
			while (rs.next()) {
				Corso c = new Corso (rs.getString("codins"), rs.getInt("crediti"), rs.getString("nome"), rs.getInt("pd"));
				corsistudente.add(c);
			}
			conn.close();
			
			return corsistudente;
			

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db", e);
		}
	}
	public Studente getStudente(String matricola) {
		final String sql = "SELECT * FROM studente WHERE matricola = ?";
		
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, matricola);
			ResultSet rs = st.executeQuery();
			
			while (rs.next()) {
				Studente s = new Studente (rs.getString("matricola"), rs.getString("cognome"), rs.getString("nome"), rs.getString("CDS"));
				return s;
			}
			conn.close();
			
			return null;
			

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db", e);
		}
	}


}
