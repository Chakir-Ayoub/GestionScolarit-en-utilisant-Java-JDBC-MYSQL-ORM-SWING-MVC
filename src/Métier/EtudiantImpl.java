package Métier;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EtudiantImpl implements IntEtudiant {

	@Override
	public void AddEtudiant(Etudiant e) {
		Connection conn=SingletonConnection.getConnection();
		try {
			java.sql.PreparedStatement ps=conn.prepareStatement("INSERT INTO `etudiant` (`Nom`, `Age`, `Classe`) VALUES (?,?,?);");
		ps.setString(1, e.getNom());
		ps.setInt(2, e.getAge());
		ps.setString(3, e.getClasse());
		ps.executeUpdate();
		}catch (SQLException e1) {
			e1.printStackTrace();
		}
		
	}

	@Override
	public void DeleteEtudiant(int id) {
		Connection conn=SingletonConnection.getConnection();
		try {
			java.sql.PreparedStatement ps=conn.prepareStatement("DELETE FROM `etudiant` WHERE IdEtu=? ");
		ps.setInt(1, id);
		ps.executeUpdate();
		}catch (SQLException e1) {
			e1.printStackTrace();
		}
		
	}

	@Override
	public void UpdateEtudiant(int id, Etudiant e) {
		Connection conn=SingletonConnection.getConnection();
		try {
			java.sql.PreparedStatement ps=conn.prepareStatement("UPDATE `etudiant` SET `Nom` = ?, `Age` = ?, `Classe` = ? WHERE `etudiant`.`IdEtu` = ?;");
			ps.setString(1, e.getNom());
			ps.setInt(2, e.getAge());
			ps.setString(3,e.getClasse());
		    ps.setInt(4, id);
		    ps.executeUpdate();
		ps.close();
		}catch (SQLException e1) {
			e1.printStackTrace();
		}	
		
	}

	@Override
	public List<Etudiant> GetEtudiantParMc(String mc) {
		Connection conn=SingletonConnection.getConnection();
		List<Etudiant> etu=new ArrayList<>();
		try {
			java.sql.PreparedStatement ps=conn.prepareStatement("SELECT * FROM `etudiant` WHERE `etudiant`.`Nom` like ?;");
		ps.setString(1, "%"+mc+"%");
		ResultSet rs=ps.executeQuery();
		while (rs.next()) {
			Etudiant etudiant=new Etudiant();
			etudiant.setNom(rs.getString("Nom"));
			etudiant.setAge(rs.getInt("Age"));
			etudiant.setClasse(rs.getString("Classe"));
			etu.add(etudiant);	
		}
		ps.close();
		}catch (SQLException e1) {  
			e1.printStackTrace();
		}	
		return etu;
	}

	@Override
	public List<Etudiant> GetEtudiantParId(int id) {
		Connection conn=SingletonConnection.getConnection();
		List<Etudiant> etu=new ArrayList<>();
		try {
			java.sql.PreparedStatement ps=conn.prepareStatement("SELECT * FROM `etudiant` WHERE `etudiant`.`IdEtu`=?;");
		ps.setInt(1,id);
		ResultSet rs=ps.executeQuery();
		while (rs.next()) {
			Etudiant etudiant=new Etudiant();
			etudiant.setNom(rs.getString("Nom"));
			etudiant.setAge(rs.getInt("Age"));
			etudiant.setClasse(rs.getString("Classe"));
			etu.add(etudiant);	
		}
		ps.close();
		}catch (SQLException e1) {  
			e1.printStackTrace();
		}	
		return etu;
	}

	@Override
	public List<Etudiant> GetEtudiant() {
		Connection conn=SingletonConnection.getConnection();
		List<Etudiant> etu=new ArrayList<>();
		try {
			java.sql.PreparedStatement ps=conn.prepareStatement("SELECT * FROM `etudiant`;");
		ResultSet rs=ps.executeQuery();
		while (rs.next()) {
			Etudiant etudiant=new Etudiant();
			etudiant.setId_Etu(rs.getInt("IdEtu"));
			etudiant.setNom(rs.getString("Nom"));
			etudiant.setAge(rs.getInt("Age"));
			etudiant.setClasse(rs.getString("Classe"));
			etu.add(etudiant);	
		}
		ps.close();
		}catch (SQLException e1) {  
			e1.printStackTrace();
		}	
		return etu;
	}

}
