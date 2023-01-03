package présentation;

import java.util.List;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import Métier.Etudiant;
import Métier.Matier;

public class EtudiantModel extends AbstractTableModel {
	 private String[] nomColonnes=new String[] {"IdEtu","Nom","Age","Classe"};
	 private Vector<String[]> rows=new Vector<String[]>();
	@Override
	public int getRowCount() {
		return rows.size();
	}

	@Override
	public int getColumnCount() {
		return nomColonnes.length;
	}
	
	@Override
	public String getColumnName(int column) {
		return nomColonnes[column];
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return rows.get(rowIndex)[columnIndex];
	}
	
	public void loadData(List<Etudiant> etu) {
		rows=new Vector<String[]>();
		for(Etudiant e:etu) {
			rows.add(new String[] {String.valueOf(e.getId_Etu()),e.getNom(),String.valueOf(e.getAge()),e.getClasse()});
		}
		fireTableChanged(null);
		
	}

}
