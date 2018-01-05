/**
 *
 */
package com.core.entite;

import java.util.Date;

/**
 * @author ANNYMWAMINI
 *
 */
public class Versement extends Operation {

	public Versement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Versement(int id,Date dateOperation, double montant,Compte compte) {
		super(id,dateOperation, montant,"VER", compte);
	}
	public Versement(Date dateOperation, double montant,Compte compte) {
		super(dateOperation, montant,"VER", compte);
	}
}
