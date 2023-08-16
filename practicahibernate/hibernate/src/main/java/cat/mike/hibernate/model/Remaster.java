package cat.mike.hibernate.model;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "remaster")
public class Remaster {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cancoid")
    private int cancoid;
	@Column(name = "data")
	private Date data;
	@Column(name = "productora")
	private String productora;
}
