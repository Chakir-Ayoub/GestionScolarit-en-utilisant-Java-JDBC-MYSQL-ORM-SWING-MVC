package Métier;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Enseignant implements Serializable {
	private int iden;
	private String Nom;
	private int idMat;
	private Matier matier;
	
	public Matier getMatier() {
		return matier;
	}
	public void setMatier(Matier matier) {
		this.matier = matier;
	}
	public Enseignant() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Enseignant(String nom,int Idmat) {
		super();
        this.idMat=Idmat;
		Nom = nom;
	}
	public int getIden() {
		return iden;
	}
	public int getIdMat() {
		return idMat;
	}
	public void setIdMat(int idMat) {
		this.idMat = idMat;
	}
	public String getNom() {
		return Nom;
	}
	public void setNom(String nom) {
		Nom = nom;
	}
	
}
