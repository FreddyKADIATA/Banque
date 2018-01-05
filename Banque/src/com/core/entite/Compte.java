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
public abstract class Compte implements Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private String code;
	private Date dateCreation;
	private double solde;
	private int codeClient;
	private String typeCpte;
	public Compte() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Compte(String code, Date dateCreation, double solde, Client client, String typeCpte) {
		super();
		this.setCode(code);
		this.setDateCreation(dateCreation);
		this.setSolde(solde);
		this.setClient(client.getId());
		this.setTypeCpte(typeCpte);
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	public double getSolde() {
		return solde;
	}
	public void setSolde(double solde) {
		this.solde = solde;
	}
	public int getClient() {
		return codeClient;
	}
	public void setClient(int codeClient) {
		this.codeClient = codeClient;
	}
	public String getTypeCpte() {
		return typeCpte;
	}
	public void setTypeCpte(String typeCpte) {
		this.typeCpte = typeCpte;
	}

}
