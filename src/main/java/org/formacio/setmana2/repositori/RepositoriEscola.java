package org.formacio.setmana2.repositori;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.formacio.setmana2.domini.Alumne;
import org.formacio.setmana2.domini.Curs;
import org.formacio.setmana2.domini.Matricula;
import org.springframework.stereotype.Repository;

/**
 * Modifica aquesta classe per tal que sigui un component Spring que realitza les 
 * operacions de persistencia tal com indiquen les firmes dels metodes
 */
@Repository
public class RepositoriEscola {

	@PersistenceContext
	private EntityManager em;
	
	public Curs carregaCurs(String nom) {
		Curs curs = em.find(Curs.class, nom);
		return curs;
	}
	
	
	public Matricula apunta (String alumne, String curs) throws EdatIncorrecteException {
	    Alumne alu = em.find(Alumne.class, alumne);
	    Curs cur = em.find(Curs.class, curs);
	    if(alu.getEdat() >= cur.getEdatMinima()) {
	    	Matricula mat = new Matricula();
	    	mat.setAlumne(alu);
	    	mat.setCurs(cur);
	    	em.persist(mat);
	    	return mat;
	    } else {
	    	throw new EdatIncorrecteException();
	    }
	}
	
	
}
