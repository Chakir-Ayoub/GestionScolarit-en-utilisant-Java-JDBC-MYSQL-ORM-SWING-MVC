package Métier;

import java.util.List;

public class Test {

	public static void main(String[] args) {
EnseignantImpl en=new EnseignantImpl();
Enseignant enseignant=new Enseignant("Ayoub",1);
//en.AddEnseignant(enseignant);
//en.DeleteEnseignant(2);
//en.UpdateEnseignant(7, enseignant);
//List<Enseignant> en1=en.GetEnseignant();
//for (Enseignant enseignant2 : en1) {
//	System.out.println(enseignant2.getIden());
//	System.out.println(enseignant2.getNom());
//	System.out.println(enseignant2.getIdMat());}
	

	MatiereImpl mat=new MatiereImpl();
	Matier matier=new Matier(2,"DOT_NET");
	//mat.AddMatiere(matier)
	//mat.DeleteMatiere(2);
	//mat.UpdateMatiere(1, matier);

	
//	List<Matier> mat1=mat.GetMatiereParMc("do");
//	for (Matier matier2 : mat1) {
//	System.out.println(matier2.getNomMat());
//	System.out.println(matier2.getCoef_mat());
 //  }
	
	
	
	EtudiantImpl etu=new EtudiantImpl();
	Etudiant etudiant=new Etudiant(25,"Chakirr","IIR4");
	
	etu.AddEtudiant(etudiant);
	//etu.DeleteEtudiant(2);
	//etu.UpdateEtudiant(1, etudiant);
	/*List<Etudiant> etu1=etu.GetEtudiantParMc("Ch");
	for (Etudiant etudiantt : etu1) {
	System.out.println(etudiantt.getNom());
	System.out.println(etudiantt.getAge());
	System.out.println(etudiantt.getClasse());*/
  // }
	}
	
	}

