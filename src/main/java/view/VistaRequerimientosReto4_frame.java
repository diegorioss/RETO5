package view;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.ControladorRequerimientosReto4;
import model.vo.LideresMayorSalario;
import model.vo.LideresProyectosEmblematicos;
import model.vo.MaterialRankeadoImportado;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class VistaRequerimientosReto4_frame extends JFrame {

	public static final ControladorRequerimientosReto4 controlador = new ControladorRequerimientosReto4();
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextArea textArea;
	private String resultado = "";
	


	public VistaRequerimientosReto4_frame() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 200, 600, 600);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Reto 5 - Ciclo 2");
		lblNewLabel.setBounds(24, 18, 125, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Diego Rios - Grupo 72");
		lblNewLabel_1.setBounds(24, 37, 256, 16);
		contentPane.add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 65, 557, 387);
		contentPane.add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JButton btnNewButton = new JButton("Consultas");					// boton - Consulta
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				requerimiento1();
				requerimiento3();
				requerimiento4();
				
				
				
			}
		});
		btnNewButton.setBounds(24, 471, 117, 29);
		contentPane.add(btnNewButton);
		
		
	}
	
public void requerimiento1(){
		
		

        resultado += "*** Lideres con mayor salario ***\n\n";       

        try{

            ArrayList<LideresMayorSalario> rankingLideresMayorSalario = controlador.consultarLideresMayorSalarios();

            //Encabezado del resultado
            resultado += "ID_Lider	Nombre	Primer_Apellido\n";
            
            //Cada VO cargado, mostrarlo en la vista
            for (LideresMayorSalario lideresMayors : rankingLideresMayorSalario) {
                
                   resultado +=  lideresMayors.getIdLider();
                   resultado += "	";
                   resultado +=  lideresMayors.getNombre();
                   resultado += "	";
                   resultado +=  lideresMayors.getPrimerApellido();
                   resultado += "\n";
                
            }

        }catch(SQLException e){
            System.err.println("Ha ocurrido un error!"+e.getMessage());
        }
        
        textArea.setText(resultado);

    }

public void requerimiento3(){
	
	

    resultado += "\n\n*** Lideres proyectos emblemáticos ***\n\n";       

    try{

        ArrayList<LideresProyectosEmblematicos> rankingProyectosEmblematicos = controlador.consultarLideresProyectosEmblematicos();

        //Encabezado del resultado
        resultado += "Id_Lider	Id_Proyecto	Id_Tipo\n";
        
        //Cada VO cargado, mostrarlo en la vista
        for (LideresProyectosEmblematicos lideresProyectosE : rankingProyectosEmblematicos) {
            
        	resultado +=  lideresProyectosE.getIdLider();
        	resultado += "	";
        	resultado +=  lideresProyectosE.getIdProyecto();
        	resultado += "	";
        	resultado +=  lideresProyectosE.getIdTipo();
        	resultado += "\n";
              
        }

    }catch(SQLException e){
        System.err.println("Ha ocurrido un error!"+e.getMessage());
    }
    
    textArea.setText(resultado);

}
public void requerimiento4(){

	resultado += "\n\n*** Productos importados ***\n\n";       

    try{
        
        ArrayList<MaterialRankeadoImportado> rankingMaterialesImportados = controlador.consultarMaterialesRankeadosImportados();

        //Cada VO cargado, mostrarlo en la vista
        for (MaterialRankeadoImportado materialImportado : rankingMaterialesImportados) {
            
            resultado +=  "El producto de ID " + materialImportado.getIdMaterial() + " de descripción: " + materialImportado.getNombreMaterial() + 
            " tiene un precio de " + materialImportado.getPrecioUnidad() + "\n";
            
                
                
              
        }

    }catch(SQLException e){
        System.err.println("Ha ocurrido un error!"+e.getMessage());
    }
    
    textArea.setText(resultado);
}
	
}
