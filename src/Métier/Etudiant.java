package Métier;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Etudiant implements Serializable {
private int Id_Etu;
private int Age;
private String Nom;
private String classe;
public Etudiant(int age, String nom, String classe) {
	super();
	Age = age;
	Nom = nom;
	this.classe = classe;
}
public Etudiant() {
	super();
	// TODO Auto-generated constructor stub
}
public int getId_Etu() {
	return Id_Etu;
}
public void setId_Etu(int Id_Etu) {
	this.Id_Etu = Id_Etu;
}

public int getAge() {
	return Age;
}
public void setAge(int age) {
	Age = age;
}
public String getNom() {
	return Nom;
}
public void setNom(String nom) {
	Nom = nom;
}
public String getClasse() {
	return classe;
}
public void setClasse(String classe) {
	this.classe = classe;
}


}
