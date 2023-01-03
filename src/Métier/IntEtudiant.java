package Métier;

import java.util.List;

public interface IntEtudiant {
	public void AddEtudiant(Etudiant e);
	public void DeleteEtudiant(int id);
	public void UpdateEtudiant(int id,Etudiant e);
	public List<Etudiant> GetEtudiantParMc(String mc);
	public List<Etudiant> GetEtudiantParId(int id);
	public List<Etudiant> GetEtudiant();
}
