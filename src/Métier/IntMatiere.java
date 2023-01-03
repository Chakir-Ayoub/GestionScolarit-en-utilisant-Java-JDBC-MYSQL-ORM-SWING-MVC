package Métier;

import java.util.List;

public interface IntMatiere {
	public void AddMatiere(Matier m);
	public void DeleteMatiere(int id);
	public void UpdateMatiere(int id,Matier m);
	public List<Matier> GetMatiereParMc(String mc);
	public List<Matier> GetMatiereParId(int id);
	public List<Matier> GetMatiere();
}
