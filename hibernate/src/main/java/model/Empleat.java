package model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Empleat implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id")
	private Integer id;
	@Column(name="lastname")
	private String cognom;
	@Column(name="firstname")
	private String nom;
	@Column(name="birthdate")
	private Date dataNaixement;
	@Column(name="salary")
	private Double salari;
	
	public Empleat() {
		
	}

	public Empleat(Integer id, String cognom, String nom, Date dataNaixement, Double salari) {
		super();
		this.id = id;
		this.cognom = cognom;
		this.nom = nom;
		this.dataNaixement = dataNaixement;
		this.salari = salari;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCognom() {
		return cognom;
	}

	public void setCognom(String cognom) {
		this.cognom = cognom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Date getDataNaixement() {
		return dataNaixement;
	}

	public void setDataNaixement(Date dataNaixement) {
		this.dataNaixement = dataNaixement;
	}

	public Double getSalari() {
		return salari;
	}

	public void setSalari(Double salari) {
		this.salari = salari;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Empleat [id=" + id + ", cognom=" + cognom + ", nom=" + nom + ", dataNaixement=" + dataNaixement
				+ ", salari=" + salari + "]";
	}
}
