package cat.mike.hibernate.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="canco")
public class Canco implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", unique = true)
	private Long id;
	@Column(name="NOM")
	private String nom;
	@Column(name="ARTISTA")
	private String artista;
	@Column(name="ALBUM")
	private String album;
	@Column(name="DATAPUBLICACIO")
	private Date dataPublicacio;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "discograficaid")
	private Discografica discografica;
	
	@OneToOne(mappedBy = "canco", orphanRemoval = true, fetch = FetchType.LAZY)
    private Lletra lletra;
	
	public Canco() {}
	
	/*public Canco(Long id, String nom, String artista, String album, Date dataPublicacio, Discografica discografica) {
		this.id = id;
		this.nom = nom;
		this.artista = artista;
		this.album = album;
		this.dataPublicacio = dataPublicacio;
		this.discografica = discografica;
	}*/
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getArtista() {
		return artista;
	}
	public void setArtista(String artista) {
		this.artista = artista;
	}
	public String getAlbum() {
		return album;
	}
	public void setAlbum(String album) {
		this.album = album;
	}
	public Date getDataPublicacio() {
		return dataPublicacio;
	}
	public void setDataPublicacio(Date dataPublicacio) {
		this.dataPublicacio = dataPublicacio;
	}
	public Discografica getDiscografica() {
		return discografica;
	}
	public void setDiscografica(Discografica discografica) {
		this.discografica = discografica;
	}
	public Lletra getLletra() {
		return lletra;
	}
	public void setLletra(Lletra lletra) {
		this.lletra = lletra;
	}

	@Override
	public String toString() {
		return "Canco [id=" + id + ", nom=" + nom + ", artista=" + artista + ", album=" + album + ", dataPublicacio="
				+ dataPublicacio + "]";
	}
}
