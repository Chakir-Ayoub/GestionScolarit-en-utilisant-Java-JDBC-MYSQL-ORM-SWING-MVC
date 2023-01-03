package Métier;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class EnseignantImpl implements IntEnseignant {

	@Override
	public void AddEnseignant(Enseignant e)  {
		Connection conn=SingletonConnection.getConnection();
		try {
			java.sql.PreparedStatement ps=conn.prepareStatement("INSERT INTO `enseignant` (`Nom`, `Matier`) VALUES (?, ?);");
		ps.setString(1, e.getNom());
		ps.setInt(2, e.getIdMat());
		ps.executeUpdate();
		}catch (SQLException e1) {
			e1.printStackTrace();
		}
		
	}

	@Override
	public void DeleteEnseignant(int id) {
		Connection conn=SingletonConnection.getConnection();
		try {
			java.sql.PreparedStatement ps=conn.prepareStatement("DELETE FROM `enseignant` WHERE Iden=? ");
		ps.setInt(1, id);
		ps.executeUpdate();
		}catch (SQLException e1) {
			e1.printStackTrace();
		}		
	}

	@Override
	public void UpdateEnseignant(int id, Enseignant e) {
		Connection conn=SingletonConnection.getConnection();
		try {
			java.sql.PreparedStatement ps=conn.prepareStatement("UPDATE `enseignant` SET `Nom` = ?, `Matier`=? WHERE `enseignant`.`Iden` = ?;");
		ps.setString(1, e.getNom());
		ps.setInt(2, e.getIdMat());
		ps.setInt(3, id);
		ps.executeUpdate();
		ps.close();
		}catch (SQLException e1) {
			e1.printStackTrace();
		}				
	}

	@Override
	public List<Enseignant> GetEnseignantParMc(String mc) {
		Connection conn=SingletonConnection.getConnection();
		List<Enseignant> ens=new ArrayList<>();
		try {
			java.sql.PreparedStatement ps=conn.prepareStatement("SELECT * FROM `enseignant` WHERE `enseignant`.`Nom` like ?;");
		ps.setString(1, "%"+mc+"%");
		ResultSet rs=ps.executeQuery();
		while (rs.next()) {
			Enseignant enseignant=new Enseignant();
			enseignant.setIdMat(rs.getInt("Iden"));
			enseignant.setNom(rs.getString("Nom"));
			ens.add(enseignant);
		//Traitement pour récupérer Matier 	
//			int idMat=rs.getInt("Matier");
//			java.sql.PreparedStatement ps2=conn.prepareStatement("select *from matiere where idmat=?");
//			ps2.setInt(1, idMat);
//			ResultSet rs2=ps2.executeQuery();
//			rs2.next();
//			Matier matier=new Matier();
//			matier.setCoef_mat(rs2.getInt("CoefMat"));
//			matier.setNomMat(rs2.getString("NomMat"));
//			enseignant.setMatier(matier);
//			ps2.close();
			
		}
		ps.close();
		}catch (SQLException e1) {  
			e1.printStackTrace();
		}	
		return ens;
	}
	

	@Override
	public List<Enseignant> GetEnseignantParId(int id) {
		Connection conn=SingletonConnection.getConnection();
		List<Enseignant> ens=new ArrayList<>();
		try {
			java.sql.PreparedStatement ps=conn.prepareStatement("SELECT * FROM `enseignant` WHERE `enseignant`.`iden`=?;");
		ps.setInt(1, id);
		ResultSet rs=ps.executeQuery();
		while (rs.next()) {
			Enseignant enseignant=new Enseignant();
			enseignant.setIdMat(rs.getInt("Iden"));
			enseignant.setNom(rs.getString("Nom"));
			ens.add(enseignant);
		//Traitement pour récupérer Matier 	
//			int idMat=rs.getInt("Matier");
//			java.sql.PreparedStatement ps2=conn.prepareStatement("select *from matiere where idmat=?");
//			ps2.setInt(1, idMat);
//			ResultSet rs2=ps2.executeQuery();
//			rs2.next();
//			Matier matier=new Matier();
//			matier.setCoef_mat(rs2.getInt("CoefMat"));
//			matier.setNomMat(rs2.getString("NomMat"));
//			enseignant.setMatier(matier);
//			ps2.close();
			
		}
		ps.close();
		}catch (SQLException e1) {  
			e1.printStackTrace();
		}	
		return ens;
	}

	@Override
	public List<Enseignant> GetEnseignant() {
		Connection conn=SingletonConnection.getConnection();
		List<Enseignant> ens=new ArrayList<>();
		try {
			java.sql.PreparedStatement ps=conn.prepareStatement("SELECT * FROM `enseignant`;");
		ResultSet rs=ps.executeQuery();
		if (rs.next()) {
			Enseignant enseignant=new Enseignant();
			enseignant.setIdMat(rs.getInt("Iden"));
			enseignant.setNom(rs.getString("Nom"));
			ens.add(enseignant);
		//Traitement pour récupérer Matier 	
//			int idMat=rs.getInt("Matier");
//			java.sql.PreparedStatement ps2=conn.prepareStatement("select *from matiere where idmat=?");
//			ps2.setInt(1, idMat);
//			ResultSet rs2=ps2.executeQuery();
//			rs2.next();
//			Matier matier=new Matier();
//			matier.setCoef_mat(rs2.getInt("CoefMat"));
//			matier.setNomMat(rs2.getString("NomMat"));
//			enseignant.setMatier(matier);
//			ps2.close();
			
		}
		ps.close();
		}catch (SQLException e1) {  
			e1.printStackTrace();
		}	
		return ens;
	}

}
