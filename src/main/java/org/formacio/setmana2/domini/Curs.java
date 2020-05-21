package org.formacio.setmana2.domini;

import javax.persistence.*;

@Entity
@Table(name = "t_cursos")
public class Curs {

	@Id
	@Column(name = "cur_nom", nullable = false)
	private String nom;
    
	@Column(name = "cur_edatminima")
	private int edatMinima;
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getEdatMinima() {
		return edatMinima;
	}
	public void setEdatMinima(int edatMinima) {
		this.edatMinima = edatMinima;
	}
	
	
}
