package com.core.dao;

import java.sql.Connection;
import java.util.List;

public abstract class DAO <T> {


	protected Connection connexion;

	public DAO(Connection connexion)
	{
		this.connexion=connexion;
	}
	public abstract boolean create (T obj);
	public abstract boolean update(T obj);
	public abstract T find (Object obj);
	public abstract boolean delete (T obj);
	public abstract List<T> findList();
}
