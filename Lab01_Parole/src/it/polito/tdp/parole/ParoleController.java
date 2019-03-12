package it.polito.tdp.parole;

import it.polito.tdp.parole.model.Parole;

import javafx.scene.control.Label;
import java.net.URL;
//import java.sql.Time;
//import java.util.Collection;
//import java.util.List;
import java.util.ResourceBundle;
//import java.util.Timer;
//import java.util.Collections;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


public class ParoleController {

	Parole elenco;

	@FXML // ResourceBundle that was given to the FXMLLoader
	private ResourceBundle resources;

	@FXML // URL location of the FXML file that was given to the FXMLLoader
	private URL location;

	@FXML // fx:id="txtParola"
	private TextField txtParola; // Value injected by FXMLLoader

	@FXML // fx:id="txtResult"
	private TextArea txtResult; // Value injected by FXMLLoader

	@FXML
	private Button btnReset;

	@FXML
	private Label txtExecTime;

	@FXML // fx:id="btnInserisci"
	private Button btnInserisci; // Value injected by FXMLLoader

	@FXML
	void doInsert(ActionEvent event) {
		// insert the new word into the list
		if (txtParola.getText().trim().isEmpty()) {
			txtParola.clear();
			return;
		}
		elenco.addParola(txtParola.getText());
		txtResult.clear();
		txtParola.clear();
		for (String word : elenco.getElenco()) {
			txtResult.appendText(word + "\n");
		}
//		txtExecTime.setText(Long.toString(System.nanoTime()));
	}

	@FXML
	void doReset(ActionEvent event) {
		// call the remove method from parole
		elenco.reset();
		txtResult.clear();
		txtParola.clear();
//		txtExecTime.setText(Long.toString(System.nanoTime()));
	}

	@FXML
	void doCancel(ActionEvent event) throws InterruptedException {
		if (!elenco.delete(txtParola.getText())) {
		} else {
			txtResult.clear();
			txtParola.clear();
			for (String word : elenco.getElenco()) {
				txtResult.appendText(word + "\n");
			}
		}
//		txtExecTime.setText(Long.toString(System.nanoTime()));
	}

	@FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Parole.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Parole.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Parole.fxml'.";
        assert txtExecTime != null : "fx:id=\"txtExecTime\" was not injected: check your FXML file 'Parole.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Parole.fxml'.";

    }
}
