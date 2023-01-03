package Métier;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Matier implements Serializable {
	private int Id_mat;
	private int Coef_mat;
	private String NomMat;
	
	public Matier() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Matier(int coef_mat, String nomMat) {
		super();
		Coef_mat = coef_mat;
		NomMat = nomMat;
	}

	public int getId_mat() {
		return Id_mat;
	}

	public int getCoef_mat() {
		return Coef_mat;
	}
	public void setCoef_mat(int coef_mat) {
		Coef_mat = coef_mat;
	}
	public String getNomMat() {
		return NomMat;
	}
	public void setNomMat(String nomMat) {
		NomMat = nomMat;
	}
	
}
