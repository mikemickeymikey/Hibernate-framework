package cat.mike.hibernate.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "discografica")
public class Discografica {
	@GeneratedValue( strategy=GenerationType.AUTO)
	@Id 
	@Column(name = "id")
	private int id;
	@Column(name="nom")
	private String nom;
	@Column(name="datafundacio")
	private Date datafundacio;
	
	@OneToMany(mappedBy = "discografica", orphanRemoval = true)
	private List<Canco> cancons;
	
	public Discografica() {}
	
	/*public Discografica(int id, String nom, Date datafundacio) {
		super();
		this.id = id;
		this.nom = nom;
		this.datafundacio = datafundacio;
	}*/
	
	public List<Canco> getCancons() {
		return cancons;
	}

	public void setCancons(List<Canco> cancons) {
		this.cancons = cancons;
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
		this.nom = nom;
	}
	public Date getDatafundacio() {
		return datafundacio;
	}
	public void setDatafundacio(Date datafundacio) {
		this.datafundacio = datafundacio;
	}
}
