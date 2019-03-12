package it.polito.tdp.parole;

import it.polito.tdp.parole.model.Parole;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ParoleController {

	Parole elenco = new Parole();

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private TextField txtParola;

	@FXML
	private Button btnInserisci;

	@FXML
	private TextArea txtResult;

	@FXML
	private Label txtExecTime;

	@FXML
	private Button btnReset;

	@FXML
	void doCancel(ActionEvent event) {
		long startTime = System.nanoTime();
		if (!elenco.delete(txtParola.getText())) {
			txtParola.setText("Non trovata");
		} else {
			txtResult.clear();
			txtParola.clear();
			for (String word : elenco.getElenco()) {
				txtResult.appendText(word + "\n");
			}
		}
		long estimatedTime = System.nanoTime() - startTime;
		txtExecTime.setText(Long.toString(estimatedTime) + " ms");
	}

	@FXML
	void doInsert(ActionEvent event) {
		// insert the new word into the list
		long startTime = System.nanoTime();
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
		long estimatedTime = System.nanoTime() - startTime;
		txtExecTime.setText(Long.toString(estimatedTime) + " ms");
	}

	@FXML
	void doReset(ActionEvent event) {
		long startTime = System.nanoTime();
		// call the remove method from parole
		elenco.reset();
		txtResult.clear();
		txtParola.clear();
		long estimatedTime = System.nanoTime() - startTime;
		txtExecTime.setText(Long.toString(estimatedTime) + " ms");
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
