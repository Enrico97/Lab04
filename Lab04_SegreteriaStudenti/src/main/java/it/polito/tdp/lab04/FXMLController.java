/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */

package it.polito.tdp.lab04;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Model;
import it.polito.tdp.lab04.model.Studente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	Model model;
	Corso corso;
	Studente studente;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="boxcorsi"
    private ComboBox<Corso> boxcorsi; // Value injected by FXMLLoader

    @FXML // fx:id="btncerca"
    private Button btncerca; // Value injected by FXMLLoader

    @FXML // fx:id="matricola"
    private TextField matricola; // Value injected by FXMLLoader

    @FXML // fx:id="completa"
    private RadioButton completa; // Value injected by FXMLLoader

    @FXML // fx:id="nome"
    private TextField nome; // Value injected by FXMLLoader

    @FXML // fx:id="cognome"
    private TextField cognome; // Value injected by FXMLLoader

    @FXML // fx:id="cercacorsi"
    private Button cercacorsi; // Value injected by FXMLLoader

    @FXML // fx:id="iscrivi"
    private Button iscrivi; // Value injected by FXMLLoader

    @FXML // fx:id="risultato"
    private TextArea risultato; // Value injected by FXMLLoader

    @FXML // fx:id="reset"
    private Button reset; // Value injected by FXMLLoader

    @FXML
    void btncercacorsi(ActionEvent event) {
    	String str = "";
    	studente = model.getStudente(matricola.getText());
    	if (matricola.getText().equals("")) {
			risultato.setText("Devi inserire una matricola");
			return;}
    	if (studente == null) {
    		risultato.setText("La matricola è errata");
    		return; }
    	for (Corso c : model.getCorsiStudente(studente)) {
    		str += c.getCodins()+" "+c.getCrediti()+" "+c.getNome()+" "+c.getPd()+"\n";
    	}
    	if (str.equals("")) {
    		risultato.setText("Lo studente non è iscritto a nessun corso");
    		return;}
    	risultato.setText(str);
    }

    @FXML
    void btncompleta(ActionEvent event) {
    	studente = model.getStudente(matricola.getText());
    	for (Studente s : model.getStudentiIscritti()) {
    		if (s.getMatricola().equals(matricola.getText())) {
    			cognome.setText(s.getCognome());
    			nome.setText(s.getNome());
    			risultato.clear();
    			return;
    		}}
    		if (matricola.getText().equals("")) {
    				risultato.setText("Devi inserire una matricola");
    				return;}
    		if (!matricola.getText().equals("") && studente == null)
    			risultato.setText("La matricola è errata");
    	}

    @FXML
    void btniscrivi(ActionEvent event) {
    	studente = model.getStudente(matricola.getText());
    	if (matricola.getText().equals("")) {
			risultato.setText("Devi inserire una matricola");
			return;}
    	if (!matricola.getText().equals("") && studente == null) {
		risultato.setText("La matricola è errata");
		return;
    	}
    	if (boxcorsi.getValue()==null) {
    		risultato.setText("Devi selezionare un corso");
    		return;
    	}
    	if (model.getStudentiIscrittiAlCorso(corso).contains(studente))
    		risultato.setText("Lo studente è già iscritto al corso");
    	else {
    		model.iscrivi(studente, corso);
    		risultato.setText("Studente iscritto al corso");
    		}
    }

    @FXML
    void btnreset(ActionEvent event) {
    	risultato.clear();
    	matricola.setText("");
    	cognome.setText("");
    	nome.setText("");
    	boxcorsi.setValue(null);
    }

    @FXML
    void cercaiscritti(ActionEvent event) {
    	if (boxcorsi.getValue()==null) {
    		risultato.setText("Devi selezionare un corso");
    		return;
    	}
    	if (matricola.getText().equals("")) {
    	String str = "";
    	for (Studente s : model.getStudentiIscrittiAlCorso(corso)) {
    		str += s.getMatricola()+" "+s.getCognome()+" "+s.getNome()+" "+s.getCDS()+"\n";
    	}
    	if (str.equals("")) {
    		risultato.setText("Nessuno studente iscritto");
    		return;}
    	risultato.setText(str);
    	return;}
    	if (!matricola.getText().equals("")) {
        	studente = model.getStudente(matricola.getText());
        	if (studente == null) {
    			risultato.setText("La matricola è errata");
    			return;
    	}
        	if (model.getStudentiIscrittiAlCorso(corso).contains(studente))
        		risultato.setText("Lo studente è iscritto al corso");
        	else {
        		risultato.setText("Lo studente non è iscritto al corso");

        	}
        		}
        	
    }

    @FXML
    void sceglicorso(ActionEvent event) {
    	corso = boxcorsi.getValue();
    }
    
    public void setModel (Model model) {
    	this.model = model;
    	boxcorsi.getItems().addAll(this.model.getElencoCorsi());
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert boxcorsi != null : "fx:id=\"boxcorsi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btncerca != null : "fx:id=\"btncerca\" was not injected: check your FXML file 'Scene.fxml'.";
        assert matricola != null : "fx:id=\"matricola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert completa != null : "fx:id=\"completa\" was not injected: check your FXML file 'Scene.fxml'.";
        assert nome != null : "fx:id=\"nome\" was not injected: check your FXML file 'Scene.fxml'.";
        assert cognome != null : "fx:id=\"cognome\" was not injected: check your FXML file 'Scene.fxml'.";
        assert cercacorsi != null : "fx:id=\"cercacorsi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert iscrivi != null : "fx:id=\"iscrivi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert risultato != null : "fx:id=\"risultato\" was not injected: check your FXML file 'Scene.fxml'.";
        assert reset != null : "fx:id=\"reset\" was not injected: check your FXML file 'Scene.fxml'.";

    }
}
