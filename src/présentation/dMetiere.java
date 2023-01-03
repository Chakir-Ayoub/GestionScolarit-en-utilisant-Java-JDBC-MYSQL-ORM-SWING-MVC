package présentation;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import Métier.Matier;
import Métier.MatiereImpl;

public class dMetiere extends JFrame {
    private JLabel jLabelMC=new JLabel("MOt Clé : ");
    private JTextField jTextFieldMc=new JTextField(12);
    private JButton jButtonOK=new JButton("OK");
    private JButton jButtonADD=new JButton("AJOUTER");
    private JTable jTable;
    private Model MatierModel;
    private MatiereImpl matiereImpl=new MatiereImpl();
    public dMetiere() {
    	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    	this.setLayout(new BorderLayout());
    	JPanel jpaPanelN=new JPanel();
    	jpaPanelN.setLayout(new FlowLayout());
    	jpaPanelN.add(jLabelMC);jpaPanelN.add(jTextFieldMc);
    	jpaPanelN.add(jButtonOK);
    	jpaPanelN.add(jButtonADD);
    	this.add(jpaPanelN,BorderLayout.NORTH);
    	
    	
    	
    	MatierModel=new Model();
    	jTable=new JTable(MatierModel);
    	JScrollPane jScrollPane=new JScrollPane(jTable);
    	this.add(jScrollPane,BorderLayout.CENTER);
    	
    	this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
    	this.setVisible(true);
    	
    	jButtonADD.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				/*
				 * dEtudiant etu=new dEtudiant(); etu.setVisible(true);
				 */
				
			}
		});
    	
    	jButtonOK.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String mc=jTextFieldMc.getText();
				List<Matier> mat=matiereImpl.GetMatiereParMc(mc);
				MatierModel.loadData(mat);
				
			}
			
			
		});
    }
    
	public static void main(String[] args) {
		new dMetiere();

	}

}
