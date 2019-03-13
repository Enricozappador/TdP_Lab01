package it.polito.tdp.parole.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
//import java.util.TreeSet;

@SuppressWarnings("unused")
public class Parole {

	private List<String> wordsList;

	public Parole() {
		// data struct
//		wordsList = new LinkedList<String>();
		wordsList = new ArrayList<String>();
	}

	public void addParola(String p) {
		// consente di inserire una parola nella struttura dati
		wordsList.add(p);
		Collections.sort(this.wordsList);

	}

	public List<String> getElenco() {
		// ritorna l’elenco di parole correnti inserite ordinate alfabeticamente
		return wordsList;
	}

	public void reset() {
		// elimina tutte le parole dalla struttura dati.
		wordsList.clear();
	}

	public boolean delete(String p) {
		// delete the word p from the list
		return wordsList.remove((String) p);
	}

}
