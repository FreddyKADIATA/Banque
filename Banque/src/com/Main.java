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


	/*les codes que vous trouverez dans cette classe ne sont que du code de test pour 
	verifier que notre couche d'accès aux donnees fonctionne correctement*/
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Connection con= Connexion_db.getInstance("banque");

		boolean etat=false;
		Client client=new Client();
		ClientDAO clientDAO= new ClientDAO(con);
		CompteDAO compteDAO= new CompteDAO(con);
		client= clientDAO.find(6);
		CompteEpargne compteEpargne= new CompteEpargne("cp1", new Date(), 4000L, client, "CE", 1000L);
		CompteCourant compteCourant= new CompteCourant("cp2", new Date(), 5000L, client, "CC", 500L);

		Compte cp= compteDAO.find("cp2");
		BanqueMetierImpl ib = new BanqueMetierImpl();
		Compte myCompte= ib.consulterCompte("cp1");
		  ib.verser("cp2", 690);
		 ib.retrait("cp2", 100);
		 ib.virement("cp1", "cp2", 50);
		
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
