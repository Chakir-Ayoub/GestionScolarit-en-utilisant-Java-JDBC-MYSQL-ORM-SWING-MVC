package Métier;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MatiereImpl implements IntMatiere {

	@Override
	public void AddMatiere(Matier m) {
		Connection conn=SingletonConnection.getConnection();
		try {
			java.sql.PreparedStatement ps=conn.prepareStatement("INSERT INTO `matiere` (`NomMat`, `CoefMat`) VALUES (?,?);");
		ps.setString(1, m.getNomMat());
		ps.setInt(2, m.getCoef_mat());
		ps.executeUpdate();
		}catch (SQLException e1) {
			e1.printStackTrace();
		}
		
	}

	@Override
	public void DeleteMatiere(int id) {
		Connection conn=SingletonConnection.getConnection();
		try {
			java.sql.PreparedStatement ps=conn.prepareStatement("DELETE FROM `matiere` WHERE Idmat=? ");
		ps.setInt(1, id);
		ps.executeUpdate();
		}catch (SQLException e1) {
			e1.printStackTrace();
		}
		
	}

	@Override
	public void UpdateMatiere(int id, Matier m) {
		Connection conn=SingletonConnection.getConnection();
		try {
			java.sql.PreparedStatement ps=conn.prepareStatement("UPDATE `matiere` SET `NomMat` = ?, `CoefMat`=? WHERE `matiere`.`Idmat`=?;");
			ps.setString(1, m.getNomMat());
			ps.setInt(2, m.getCoef_mat());
		ps.setInt(3, id);
		ps.executeUpdate();
		ps.close();
		}catch (SQLException e1) {
			e1.printStackTrace();
		}	
		
	}

	@Override
	public List<Matier> GetMatiereParMc(String mc) {
		Connection conn=SingletonConnection.getConnection();
		List<Matier> mat=new ArrayList<>();
		try {
			java.sql.PreparedStatement ps=conn.prepareStatement("SELECT * FROM `matiere` WHERE `matiere`.`NomMat` like ?;");
		ps.setString(1, "%"+mc+"%");
		ResultSet rs=ps.executeQuery();
		while (rs.next()) {
			Matier matier=new Matier();
			matier.setNomMat(rs.getString("NomMat"));
			matier.setCoef_mat(rs.getInt("CoefMat"));
			mat.add(matier);	
		}
		ps.close();
		}catch (SQLException e1) {  
			e1.printStackTrace();
		}	
		return mat;
	}

	@Override
	public List<Matier> GetMatiereParId(int id) {
		Connection conn=SingletonConnection.getConnection();
		List<Matier> mat=new ArrayList<>();
		try {
			java.sql.PreparedStatement ps=conn.prepareStatement("SELECT * FROM `matiere` WHERE `matiere`.`Idmat`=?;");
		ps.setInt(1, id);
		ResultSet rs=ps.executeQuery();
		while (rs.next()) {
			Matier matier=new Matier();
			matier.setNomMat(rs.getString("NomMat"));
			matier.setCoef_mat(rs.getInt("CoefMat"));
			mat.add(matier);
 
			
		}
		ps.close();
		}catch (SQLException e1) {  
			e1.printStackTrace();
		}	
		return mat;
	}

	@Override
	public List<Matier> GetMatiere() {
		Connection conn=SingletonConnection.getConnection();
		List<Matier> mat=new ArrayList<>();
		try {
			java.sql.PreparedStatement ps=conn.prepareStatement("SELECT * FROM `matiere`;");
		ResultSet rs=ps.executeQuery();
		while (rs.next()) {
			Matier matier=new Matier();
			matier.setNomMat(rs.getString("NomMat"));
			matier.setCoef_mat(rs.getInt("CoefMat"));
			mat.add(matier);
 
			
		}
		ps.close();
		}catch (SQLException e1) {  
			e1.printStackTrace();
		}	
		return mat;
	}


}
