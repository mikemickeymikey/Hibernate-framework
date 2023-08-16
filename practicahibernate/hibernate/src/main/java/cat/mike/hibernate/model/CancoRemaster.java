package cat.mike.hibernate.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "cancoremaster")
@IdClass(CancoRemasterId.class)
public class CancoRemaster implements Serializable {
	private static final long serialVersionUID = 1L;
	  
    @Id
    @Column(name = "cancoid")
    private int cancoid;

    @Id
    @Column(name = "remasterid")
    private int remasterid;
}
