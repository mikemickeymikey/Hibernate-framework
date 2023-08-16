package cat.mike.hibernate.test;

import java.sql.Date;
import java.util.List;
import java.util.Set;

import cat.mike.hibernate.model.Canco;
import cat.mike.hibernate.model.Discografica;
import cat.mike.hibernate.model.Lletra;
import cat.mike.hibernate.orm.ORMManager;

public class Main {

	public static void main(String[] args) {
		try(ORMManager ormManager = new ORMManager("ORMMike");){
			Canco c1 = new Canco();
			c1.setId(1L);
			c1.setNom("When the Levee Breaks");
			c1.setArtista("Led Zeppelin");
			c1.setAlbum("Led Zeppelin IV");
			c1.setDataPublicacio(Date.valueOf("1971-11-08"));
			Discografica d1 = new Discografica();
			//d1.setId(1);
			d1.setNom("Discografica 1");
			d1.setDatafundacio(Date.valueOf("1971-11-08"));
			d1.setCancons(List.of(c1));
			Lletra ll1 = new Lletra();
			ll1.setId(1);
			ll1.setText("asdf");
			ll1.setIdioma("English");
			ll1.setCanco(c1);
			/*Canco c1 = new Canco(1L, "When the Levee Breaks", "Led Zeppelin", "Led Zeppelin IV", Date.valueOf("1971-11-08"), d1);
			Canco c2 = new Canco(2L, "The Chain", "Fleetwood Mac", "Rumours", Date.valueOf("1977-02-04"), d1);
			Canco c3 = new Canco(3L, "Hey Joe", "Jimi Hendrix", "Are You Experienced", Date.valueOf("1967-05-12"), d1);
			Canco c4 = new Canco(4L, "Oh! Sweet Nuthin'", "The Velvet Underground", "Loaded", Date.valueOf("1970-01-01"), d1);
			Canco c5 = new Canco(5L, "Hey", "Pixies", "Doolittle", Date.valueOf("1989-05-17"), d1);*/
			/*ormManager.AddDiscografica(d1);
			*/ormManager.AddCanco(c1);/*
			ormManager.AddLletra(ll1);
			ormManager.AddCanco(c2);
			ormManager.AddCanco(c3);
			ormManager.AddCanco(c4);
			ormManager.AddCanco(c5);*/
			
			System.out.println("Cançó que es pot trobar:");
			System.out.println(ormManager.GetCanco(1L) + "\n");
			System.out.println("Cançó que no es pot trobar:");
			System.out.println(ormManager.GetCanco(6L) + "\n");
			
			System.out.println("Cançó per actualitzar:");
			System.out.println(ormManager.GetCanco(1L) + "\n");
			Boolean actualitzat = ormManager.UpdateCanco(1L, "Oh!! Sweet Nuthin'", null, null, null);
			if(actualitzat) {
				System.out.println("Cançó actualitzada:");
				System.out.println(ormManager.GetCanco(1L) + "\n");
			}
			else System.out.println("No s'ha pogut actualitzar la cançó");
			Set<Canco> set = ormManager.GetAllCanco();
			System.out.println(set);
			Boolean eliminatBoolean = ormManager.DeleteCanco(1L);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
