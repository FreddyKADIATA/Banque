/**
 *
 */
package com;

import java.sql.Connection;
import java.util.Date;

import com.core.banqueMetier.BanqueMetierImpl;
import com.core.banqueMetier.IBanqueMetier;
import com.core.dao.impl.ClientDAO;
import com.core.dao.impl.CompteDAO;
import com.core.dao.impl.OperationDAO;
import com.core.entite.Client;
import com.core.entite.Compte;
import com.core.entite.CompteCourant;
import com.core.entite.CompteEpargne;
import com.core.entite.Operation;
import com.core.entite.Retrait;
import com.core.entite.Versement;
import com.core.exception.ClientException;
import com.coul.connection.Connexion_db;


/**
 * @author KADIATA
 *
 */
public class Main {


	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Connection con= Connexion_db.getInstance("banque");

		boolean etat=false;
		Client client=new Client();
		ClientDAO clientDAO= new ClientDAO(con);
		//CompteEpargneDAO compteDAO= new CompteEpargneDAO(con);
		CompteDAO compteDAO= new CompteDAO(con);
		client= clientDAO.find(6);
		CompteEpargne compteEpargne= new CompteEpargne("cp1", new Date(), 4000L, client, "CE", 1000L);
		CompteCourant compteCourant= new CompteCourant("cp2", new Date(), 5000L, client, "CC", 500L);
		//compteDAO.create(compteCourant);
		//compteDAO.create(compteEpargne);
		/*Compte cp=(Compte) compteDAO.findObject("cp1");
		System.out.println(compteDAO.findObject("cp1").toString());
		if(cp instanceof CompteEpargne)
			System.out.println("taux: "+((CompteEpargne)cp).getTaux());
		else if (cp instanceof CompteCourant)
			System.out.println("decouvert: "+((CompteCourant)cp).getDecouvert());*/
		//clientDAO.delete(client);
		try {
			   client = new Client("KADIATA","ILUNGA","Freddy","av. Idiofa, Q/Maluku, 900", "0992342110");
			//client = new Client("NGAY TIN","LUKERA","DHOM","av. lulia, Q/Maluku, 240", "0992342120");
			//etat=clientDAO.create(client);
			if (etat== true)
				System.out.println("succes");
			else{
				System.out.println("faild");
			}
		} catch (ClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		 * Creer Compte Epargne
		 * client= clientDAO.find(6);
		compteEpargne= new CompteEpargne("2-13504", new Date(), 25000000L, client, 3000000L);
		compteDAO.create(compteEpargne);
		*/

		/*
		 * Creer Compte Courant
		 * client= clientDAO.find(5);
		compteCourant=new CompteCourant("2-13508", new Date(), 56000000L, client, 400000L);
		compteCourantDAO.create(compteCourant);*/
/*
		compteCourant= compteCourantDAO.find("cpt230");

		VersementDAO versementDAO= new VersementDAO(con);
		RetraitDAO retraitDAO= new RetraitDAO(con);

		versementDAO.create(new Versement(new Date(), 5000L, compteCourant));
		retraitDAO.create(new Retrait(new Date(), 4000L, compteCourant));



		System.out.println(compteCourant.getSolde());
		for (Client client2: clientDAO.findList())
		{
			System.out.println("Nom: "+client2.getNom());
		}
		for(CompteCourant cc: compteCourantDAO.findList())
		{
			System.out.println("Solde"+cc.getSolde());
		}*/

		Compte cp= compteDAO.find("cp2");
		BanqueMetierImpl ib = new BanqueMetierImpl();
		//Compte myCompte= ib.consulterCompte("cp1");
		  //ib.verser("cp2", 690);
		 //ib.retrait("cp2", 100);
		 ib.virement("cp1", "cp2", 50);
		//if(cp instanceof CompteEpargne)
		//System.out.println("Solde"+((CompteEpargne)myCompte).getSolde());
		 OperationDAO operationDAO= new OperationDAO(con);
		 for(Operation op:operationDAO.findListOperation(cp))
		 {
			 if(op instanceof Versement)
			 System.out.println(((Versement)op).getTypeOp()+" : "+((Versement)op).getMontant());
			 if (op instanceof Retrait)
			 System.out.println(((Retrait)op).getTypeOp()+" : "+((Retrait)op).getMontant());

		 }

	}

}
