/**
 *
 */
package com.core.entite;

import java.io.Serializable;

import com.core.exception.ClientException;
import com.core.interfaces.IControl;

/**
 * @author KADIATA
 *
 */
public class Client implements Serializable, IControl {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private int id;
	private String nom;
	private String postNom;
	private String prenom;
	private String adresse;
	private String telephone;
	public Client(String nom, String postNom, String prenom, String adresse, String telephone) throws ClientException {
		super();
		if (nom.isEmpty())
			throw new ClientException();
			else
			{

			this.setNom(nom);
			this.setPostNom(postNom);
			this.setPrenom(prenom);
			this.setTelephone(telephone);
			this.setAdresse(adresse);
			}
	}
	public Client(int id,String nom, String postNom, String prenom, String adresse, String telephone) throws ClientException {
		super();
		if (nom.isEmpty())
			throw new ClientException();
			else
			{
			this.setId(id);
			this.setNom(nom);
			this.setPostNom(postNom);
			this.setPrenom(prenom);
			this.setTelephone(telephone);
			this.setAdresse(adresse);
			}
	}
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		if (!(nom.isEmpty()) & nom.length()> 5)
			{
			nom.toUpperCase();
			this.nom = nom;
			}
	}
	public String getPostNom() {
		return postNom;
	}
	public void setPostNom(String postNom) {
		if (!(postNom.isEmpty()) & postNom.length()> 5)
		{
			postNom.toUpperCase();
			this.postNom = postNom;
		}

	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		if (!(prenom.isEmpty()) & prenom.length()> 3)
		this.prenom = prenom;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		if (!(adresse.isEmpty()) & adresse.length()> 10)
		this.adresse = adresse;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		if (telephone.length()== 10)
		this.telephone = telephone;
	}
	@Override
	public boolean isValid() {

		//return true;
		return (this.postNom !=null && this.nom !=null && this.prenom!=null && this.adresse!=null && this.telephone!=null)? true:false;
	}
	@Override
	public boolean isNew() {

		return true;
	}
}
