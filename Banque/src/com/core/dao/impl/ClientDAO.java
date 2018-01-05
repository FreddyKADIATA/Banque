package com.core.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.core.dao.DAO;
import com.core.entite.Client;
import com.core.exception.ClientException;

public class ClientDAO extends DAO<Client> {

	public ClientDAO(Connection connexion) {
		super(connexion);

	}

	@Override
	public boolean create(Client obj) {

		boolean status=false;
		if (obj.isNew() && obj.isValid())
		{
			try {
				PreparedStatement prepare= this.connexion.prepareStatement("INSERT INTO client SET "
						+ "nom=?, postNom=?, prenom=?, telephone=?, adresse=?");

				prepare.setString(1, obj.getNom());
				prepare.setString(2, obj.getPostNom());
				prepare.setString(3, obj.getPrenom());
				prepare.setString(4, obj.getTelephone());
				prepare.setString(5, obj.getAdresse());

				int etat= prepare.executeUpdate();

				status= (etat> 0)? true:false;

			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		else
		{
			System.out.println("Objet invalid");
		}
		return status;
	}

	@Override
	public boolean update(Client obj) {

		boolean status=false;
		if (obj.isValid())
		{
			try {
				PreparedStatement prepare= this.connexion.prepareStatement("UPDATE client SET nom=?, postNom=?, prenom=?, telephone=? adresse=? WHERE id=?");

				prepare.setString(1, obj.getNom());
				prepare.setString(2, obj.getPostNom());
				prepare.setString(3, obj.getPrenom());
				prepare.setString(4, obj.getTelephone());
				prepare.setString(5, obj.getAdresse());
				prepare.setInt(6, obj.getId());

				int etat= prepare.executeUpdate();

				status= (etat>0)? true:false;
				prepare.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return status;
	}

	public Client find(Object obj) {
		Client client = new Client();
		ResultSet resultSet;
		try{
			PreparedStatement prepare= this.connexion.prepareStatement("Select * FROM client where id=?");

			prepare.setInt(1, Integer.parseInt(obj.toString()));

			resultSet= prepare.executeQuery();

			while (resultSet.next())
			{
				try {
					client= new Client(resultSet.getInt("id"),resultSet.getString("nom"), resultSet.getString("postNom"), resultSet.getString("prenom"),resultSet.getString("adresse"),resultSet.getString("telephone"));

				} catch (ClientException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return client;
	}

	@Override
	public boolean delete(Client obj) {

		boolean status= false;

			try {
				PreparedStatement prepare= this.connexion.prepareStatement("DELETE FROM client WHERE id=?");

				prepare.setInt(1, obj.getId());

				int etat= prepare.executeUpdate();
				status= (etat>0)? true:false;

				prepare.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return status;
	}

	@Override
	public List<Client> findList() {

		List<Client> liste= new ArrayList<Client>();
		ResultSet result;

		try {
			PreparedStatement prepare= this.connexion.prepareStatement("select * FROM client");

			result= prepare.executeQuery();

			while (result.next())
			{
				liste.add(this.find(result.getObject("id")));
			}
			result.close();
			prepare.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return liste;
	}
}
