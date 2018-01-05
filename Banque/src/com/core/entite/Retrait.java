/**
 *
 */
package com.core.entite;

import java.util.Date;

/**
 * @author KADIATA
 *
 */
public class Retrait extends Operation {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public Retrait() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Retrait(Date dateOperation, double montant,Compte compte) {
		super(dateOperation, montant,"RET", compte);
	}
	public Retrait(int id,Date dateOperation, double montant,Compte compte) {
		super(id,dateOperation, montant,"RET", compte);
	}
}
