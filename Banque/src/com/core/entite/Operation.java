/**
 *
 */
package com.core.entite;

import java.io.Serializable;
import java.util.Date;

/**
 * @author KADIATA
 *
 */
public abstract class Operation implements Serializable {


	private int id;
	private Date dateOperation;
	private double montant;
	private String compte;
	private String typeOp;

	public String getCompte() {
		return compte;
	}

	public void setCompte(String compte) {
		this.compte = compte;
	}

	public Operation() {
		// TODO Auto-generated constructor stub
	}

	public Operation(Date dateOperation, double montant,String typeOp, Compte compte) {
		super();

		this.dateOperation = dateOperation;
		this.montant = montant;
		this.compte = compte.getCode();
		this.typeOp=typeOp;
	}
	public Operation(int id,Date dateOperation, double montant,String typeOp, Compte compte) {
		super();

		this.id=id;
		this.dateOperation = dateOperation;
		this.montant = montant;
		this.compte = compte.getCode();
		this.typeOp=typeOp;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateOperation() {
		return dateOperation;
	}

	public void setDateOperation(Date dateOperation) {
		this.dateOperation = dateOperation;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public String getTypeOp() {
		return typeOp;
	}

	public void setType_Op(String typeOp) {
		this.typeOp = typeOp;
	}


}
