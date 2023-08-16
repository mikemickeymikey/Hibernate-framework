package cat.mike.hibernate.orm;

import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;

import org.hibernate.Session;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.hibernate.criterion.CriteriaQuery;
import org.hibernate.query.Query;

import cat.mike.hibernate.model.Canco;
import cat.mike.hibernate.model.Discografica;
import cat.mike.hibernate.model.Lletra;

public class ORMManager implements AutoCloseable{
	private EntityManager manager;
	private EntityManagerFactory factory;
	public ORMManager(String persistenceUnitName) {
		factory = Persistence.createEntityManagerFactory( persistenceUnitName );
		manager = factory.createEntityManager( );
	}
	
	@Override
	public void close() throws Exception {
		manager.close( );
		factory.close( );
	}
	
	public boolean AddCanco( Canco objecte) {
		boolean fet = false;
		EntityTransaction transaccio = null;
		try {
			transaccio = manager.getTransaction();
			transaccio.begin();
			manager.merge(objecte);
			manager.persist(objecte);
			transaccio.commit();
			fet=true;
		}
			catch(Exception ex)
		{
			ex.printStackTrace();
			transaccio.rollback();
		}
		return fet;
	}
	
	public boolean AddDiscografica( Discografica objecte) {
		boolean fet = false;
		EntityTransaction transaccio = null;
		try {
			transaccio = manager.getTransaction();
			transaccio.begin();
			manager.merge(objecte);
			manager.persist(objecte);
			transaccio.commit();
			fet=true;
		}
			catch(Exception ex)
		{
			ex.printStackTrace();
			transaccio.rollback();
		}
		return fet;
	}
	
	public boolean AddLletra( Lletra objecte) {
		boolean fet = false;
		EntityTransaction transaccio = null;
		try {
			transaccio = manager.getTransaction();
			transaccio.begin();
			manager.merge(objecte);
			manager.persist(objecte);
			transaccio.commit();
			fet=true;
		}
			catch(Exception ex)
		{
			ex.printStackTrace();
			transaccio.rollback();
		}
		return fet;
	}
	
	public boolean UpdateCanco( Long id, String nom, String artista, String album, Date dataPublicacio) {
		boolean fet = false;
		EntityTransaction transaccio = null;
		Canco a;
		try {
			transaccio = manager.getTransaction();
			transaccio.begin();
			a = manager.find(Canco.class, id);
			if(nom != null) a.setNom(nom);
			if(artista != null) a.setArtista(artista);
			if(album != null) a.setAlbum(album);
			if(dataPublicacio != null) a.setDataPublicacio(dataPublicacio);
			transaccio.commit();
			fet = true;
		}
			catch(Exception ex)
		{
			if (ex != null) {
				transaccio.rollback();
				System.out.println("No s'ha pogut actualitzar la cançó.");
			}
		}
		return fet;
	}
	
	public boolean DeleteCanco( Long id ) {
		boolean fet = false;
		EntityTransaction transaccio = null;
		Canco a;
		try {
			transaccio = manager.getTransaction();
			transaccio.begin();
			a = manager.find(Canco.class, id);
			if(a != null) manager.remove(a);
			transaccio.commit();
			fet = true;
		}
			catch(Exception ex)
		{
			if (ex != null) {
				transaccio.rollback();
				System.out.println("No s'ha pogut eliminar la cançó.");
			}
		}
		return fet;
	}
	
	public Canco GetCanco( Long id ) {
		EntityTransaction transaccio = null;
		Canco a = null;
		try {
			transaccio = manager.getTransaction();
			transaccio.begin();
			a = manager.find(Canco.class, id);
			transaccio.commit();
		}
			catch(Exception ex)
		{
			if (ex != null) System.out.println("No s'ha pogut obtenir la cançó amb id: " + id);
		}
		return a;
	}
	
	@SuppressWarnings("unchecked")
	public Set<Canco> GetAllCanco(){
		EntityTransaction transaccio = null;
		List<Canco> listCanco = null;
		Set<Canco> setCanco = null;
		try {
			transaccio = manager.getTransaction();
			transaccio.begin();
			Query query = (Query) manager.createQuery("from canco");
			listCanco = query.getResultList();
			setCanco = new HashSet<Canco>(listCanco);
		}
			catch(Exception ex)
		{
			if (ex != null) System.out.println("No s'ha pogut obtenir la llista de Cançons");
		}
		return setCanco;
	}
}
