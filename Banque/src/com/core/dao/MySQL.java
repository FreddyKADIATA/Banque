package com.core.dao;

import com.mysql.jdbc.Connection;

public class MySQL extends Connexion_db {

	private MySQL(){ super();}

	public static Connection getConnexion()
	{
		hote   = "localhost" ;
		dbuser = "root" ;
		dbbase = "banque" ;
		dbpass = "" ;
		if (connection==null)
		{
			new MySQL();
		}

		return connection;
	}
}
