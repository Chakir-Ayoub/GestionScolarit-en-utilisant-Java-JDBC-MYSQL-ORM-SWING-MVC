package présentation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Label;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListCellRenderer;

import Métier.Etudiant;
import Métier.EtudiantImpl;
import Métier.Matier;

import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;

public class Etudiantd  {

	private JFrame frmEtudiant=new JFrame();
	private JTextField NomText;
	private JTextField AgeText;
	private JTextField ClasseText;
	private EtudiantImpl etudiantImpl=new EtudiantImpl();
    private JTable jTable;
    private EtudiantModel etudiantModel=new EtudiantModel();
    private JTable table;
    private JTable table_1;
    private JTextField idEtuText;
   

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Etudiantd window = new Etudiantd();
					window.frmEtudiant.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Etudiantd() {

		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEtudiant = new JFrame();
		frmEtudiant.setTitle("Etudiant");
		frmEtudiant.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nom :");
		lblNewLabel.setBounds(10, 63, 45, 13);
		frmEtudiant.getContentPane().add(lblNewLabel);
		
		NomText = new JTextField();
		NomText.setBounds(76, 60, 96, 19);
		frmEtudiant.getContentPane().add(NomText);
		NomText.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Age :");
		lblNewLabel_1.setBounds(10, 103, 45, 13);
		frmEtudiant.getContentPane().add(lblNewLabel_1);
		
		AgeText = new JTextField();
		AgeText.setBounds(76, 100, 96, 19);
		frmEtudiant.getContentPane().add(AgeText);
		AgeText.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Classe");
		lblNewLabel_2.setBounds(10, 147, 45, 13);
		frmEtudiant.getContentPane().add(lblNewLabel_2);
		
		ClasseText = new JTextField();
		ClasseText.setBounds(76, 144, 96, 19);
		frmEtudiant.getContentPane().add(ClasseText);
		ClasseText.setColumns(10);
		
	
   

		
		JButton btnNewButton = new JButton("AJOUTER");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(NomText.getText().isEmpty()||AgeText.getText().isEmpty()||ClasseText.getText().isEmpty()) {
					 JOptionPane.showMessageDialog(null, "Merci de Vérifier les champs");
				}
				else {
				
				  try {
					  
						 String nom=NomText.getText(); 
						  int  Age=Integer.parseInt(AgeText.getText()); 
						  String Classe=ClasseText.getText();
						
						  Etudiant etu=new Etudiant(Age,nom,Classe);
					  etudiantImpl.AddEtudiant(etu);
					
						
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null,e2.getMessage());
				}
				}
				 
			}
		});
		btnNewButton.setBounds(182, 68, 85, 21);
		frmEtudiant.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("SUPPERIMER");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(idEtuText.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null,"Merci d'insérer  l'Id");
				}
				else {
					try {
						int id=Integer.parseInt(idEtuText.getText());
						etudiantImpl.DeleteEtudiant(id);
					    table_1.setVisible(true);
						List<Etudiant> mat=etudiantImpl.GetEtudiant();
						etudiantModel.loadData(mat);
				        table_1.setModel(etudiantModel);
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null,e2.getMessage());					}
				}
			}
		});
		btnNewButton_1.setBounds(277, 68, 149, 21);
		frmEtudiant.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("MODIFIER");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(idEtuText.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null,"Merci d'insérer  l'Id");
				}else {
					try {
						int id=Integer.parseInt(idEtuText.getText());
						 String nom=NomText.getText();
						 int age=Integer.parseInt(AgeText.getText());
						 String classe=ClasseText.getText();
						 etudiantImpl.UpdateEtudiant(id,new Etudiant(age,nom,classe));
						  table_1.setVisible(true);
							List<Etudiant> mat=etudiantImpl.GetEtudiant();
							etudiantModel.loadData(mat);
					        table_1.setModel(etudiantModel);
					
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null,e2.getMessage());					}
				}
			}
		});
		btnNewButton_2.setBounds(182, 108, 85, 21);
		frmEtudiant.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("RECHERCHER PAR ID");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id=Integer.parseInt(idEtuText.getText());
				 List<Etudiant> etu;
				 etu=etudiantImpl.GetEtudiantParId(id);
				 for (Etudiant etudiant : etu) {
					    NomText.setText(etudiant.getNom());
						AgeText.setText(String.valueOf(etudiant.getAge()));
						ClasseText.setText(etudiant.getClasse());
				}
				 String nom=NomText.getText();
				 int age=Integer.parseInt(AgeText.getText());
				 String classe=ClasseText.getText();
			}
		});
		btnNewButton_3.setBounds(277, 108, 149, 21);
		frmEtudiant.getContentPane().add(btnNewButton_3);
		
		table = new JTable();
		table.setBounds(90, 180, 1, 1);
		frmEtudiant.getContentPane().add(table);
		
		table_1 = new JTable();
         table_1.setVisible(true);
		List<Etudiant> mat=etudiantImpl.GetEtudiant();
		etudiantModel.loadData(mat);
        table_1.setModel(etudiantModel);
		
		table_1.setBounds(10, 180, 416, 73);
		frmEtudiant.getContentPane().add(table_1);
		
		JLabel Id_Etudiant = new JLabel("Id_Etu :");
		Id_Etudiant.setBounds(10, 29, 45, 13);
		frmEtudiant.getContentPane().add(Id_Etudiant);
		
		idEtuText = new JTextField();
		idEtuText.setBounds(76, 26, 96, 19);
		frmEtudiant.getContentPane().add(idEtuText);
		idEtuText.setColumns(10);
		
		frmEtudiant.setSize(525,410);
		frmEtudiant.setBounds(200,100,525,410);
		frmEtudiant.setLocation(200,100);
		frmEtudiant.setResizable(false);
		
		JButton btnNewButton_4 = new JButton("RECHERCHER PAR MOT CLE");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nom =NomText.getText();
				 List<Etudiant> etu;
				 etu=etudiantImpl.GetEtudiantParMc(nom);
				 for (Etudiant etudiant : etu) {
					    idEtuText.setText(String.valueOf(etudiant.getId_Etu()));
					    NomText.setText(etudiant.getNom());
						AgeText.setText(String.valueOf(etudiant.getAge()));
						ClasseText.setText(etudiant.getClasse());
				}
				 int id=Integer.parseInt(idEtuText.getText());
				 String nom1=NomText.getText();
				 int age=Integer.parseInt(AgeText.getText());
				 String classe=ClasseText.getText();
				 idEtuText.setText(String.valueOf(id));
				 NomText.setText(nom1);
				 AgeText.setText(String.valueOf(age));
				 ClasseText.setText(classe);
			}
		});
		btnNewButton_4.setBounds(182, 143, 244, 21);
		frmEtudiant.getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("VIDER LES CHAMPS");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				idEtuText.setText("");
				NomText.setText("");
				AgeText.setText("");
				ClasseText.setText("");
			}
		});
		btnNewButton_5.setBounds(182, 25, 244, 21);
		frmEtudiant.getContentPane().add(btnNewButton_5);
		
	}
}
