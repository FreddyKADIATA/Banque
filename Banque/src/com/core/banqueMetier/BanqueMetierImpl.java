package com.core.banqueMetier;

import java.sql.Connection;
import java.util.Date;
import java.util.List;

import com.core.dao.impl.CompteDAO;
import com.core.dao.impl.OperationDAO;
import com.core.entite.Compte;
import com.core.entite.CompteCourant;
import com.core.entite.CompteEpargne;
import com.core.entite.Operation;
import com.core.entite.Retrait;
import com.core.entite.Versement;
import com.coul.connection.Connexion_db;

public class BanqueMetierImpl implements IBanqueMetier {

	private Connection con= Connexion_db.getInstance("banque");
	private CompteDAO compteDAO=new CompteDAO(con);
	private OperationDAO operationDAO= new OperationDAO(con);
	@Override
	public Compte consulterCompte(String codeCpte) {

		Compte cp =compteDAO.find(codeCpte);
		if (cp==null)
			throw new RuntimeException("Compte introuvable");
		return cp;
	}

	@Override
	public void verser(String codeCpte, double montant) {
		Compte cp= consulterCompte(codeCpte);
		Versement v= new Versement(new Date(), montant, cp);
		operationDAO.create(v);
			cp.setSolde(cp.getSolde()+montant);
			compteDAO.update(cp);
	}

	@Override
	public void retrait(String codeCpte, double montant) {
		Compte cp= consulterCompte(codeCpte);
		double facilteCaisse=0;
		if (cp instanceof CompteCourant)
			facilteCaisse= ((CompteCourant)cp).getDecouvert();
		if (cp.getSolde()+facilteCaisse< montant)
			throw new RuntimeException("Solde inssufisante");
		else
		{
			Retrait r= new Retrait(new Date(), montant, cp);
			operationDAO.create(r);
				cp.setSolde(cp.getSolde()-montant);
				compteDAO.update(cp);
		}

	}

	@Override
	public void virement(String codeCpt1, String codeCtp2, double montant) {
		this.retrait(codeCpt1, montant);
		this.verser(codeCtp2, montant);
	}

	@Override
	public List<Operation> listOperation(String codeCpte) {

		return null;
	}

}
