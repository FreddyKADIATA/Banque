/**
 *
 */
package com.core.entite;

import java.util.Date;

/**
 * @author KADIATA
 *
 */
public class CompteEpargne extends Compte {

	private double taux;
	public CompteEpargne() {
		// TODO Auto-generated constructor stub
	}
	public CompteEpargne(String code, Date dateCreation, double solde, Client client,String typeCpte, double taux) {
		super(code, dateCreation, solde, client,"CE");
		this.taux = taux;

	}

	public double getTaux() {
		return taux;
	}
	public void setTaux(double taux) {
		this.taux = taux;
	}

}
