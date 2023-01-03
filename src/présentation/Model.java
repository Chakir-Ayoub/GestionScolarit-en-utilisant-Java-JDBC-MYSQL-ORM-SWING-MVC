package présentation;

import java.util.List;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import Métier.Matier;

public class Model extends AbstractTableModel  {
 private String[] nomColonnes=new String[] {"Iden","Nom","Matier"};
 private Vector<String[]> rows=new Vector<String[]>();
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return rows.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return nomColonnes.length;
	}

	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return nomColonnes[column];
	}
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return rows.get(rowIndex)[columnIndex];
	}
	
	public void loadData(List<Matier> mat) {
		rows=new Vector<String[]>();
		for(Matier m:mat) {
			rows.add(new String[] {String.valueOf(m.getId_mat()),m.getNomMat(),String.valueOf(m.getCoef_mat())});
		}
		fireTableChanged(null);
		
	}

}
