package Métier;

import java.sql.ResultSet;
import java.util.List;

public interface IntEnseignant {
public void AddEnseignant(Enseignant e);
public void DeleteEnseignant(int id);
public void UpdateEnseignant(int id,Enseignant e);
public List<Enseignant>  GetEnseignantParMc(String mc);
public List<Enseignant> GetEnseignantParId(int id);
public  List<Enseignant> GetEnseignant();

}
