package test;

import java.sql.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import model.Empleat;

public class Principal {

	public static void main(String[] args) {
		//ORMManager myORM = new ORMManager("ORMMike"); dins dun bloc try with resources
	  EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "ORMEmployee" );
	  
	  EntityManager entitymanager = emfactory.createEntityManager( );
	  EntityTransaction t = null;
	  t = entitymanager.getTransaction();
	  t.begin();
	
	  Empleat e = new Empleat( ); 
	  e.setId( 5654387 );
	  e.setCognom( "Cuesta" );
	  e.setNom( "Mike" );
	  e.setSalari( 40000D );
	  e.setDataNaixement(Date.valueOf("2000-09-24"));
	  
	  entitymanager.persist( e );
	  entitymanager.getTransaction( ).commit( );
	
	  entitymanager.close( );
	  emfactory.close( );
	  
	}

}
