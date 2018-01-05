/**
 *
 */
package com.core.entite;

import java.util.Date;

/**
 * @author KADIATA
 *
 */
public class CompteCourant extends Compte {

	private double decouvert;

	public CompteCourant() {
		// TODO Auto-generated constructor stub
	}

	public CompteCourant(double decouvert) {
		super();
		this.decouvert = decouvert;
	}

	public CompteCourant(String code, Date dateCreation, double solde, Client client,String typeCpte, double decouvert) {

		super(code, dateCreation, solde, client,"CC");

		this.decouvert = decouvert;
	}

	public double getDecouvert() {
		return decouvert;
	}

	public void setDecouvert(double decouvert) {
		this.decouvert = decouvert;
	}
}
