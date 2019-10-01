package fr.formation.financings.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractEntity {

    @Id // id field is the primary key
    // The id is auto-incremented by database (identity):
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    protected AbstractEntity() {
    }
}
