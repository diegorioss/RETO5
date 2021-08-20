import java.awt.EventQueue;


import view.VistaRequerimientosReto4_frame;

public class App {
	
    public static void main( String[] args ){        

    	
    		EventQueue.invokeLater(new Runnable() {
    			public void run() {
    				try {
    					VistaRequerimientosReto4_frame frame = new VistaRequerimientosReto4_frame();
    					frame.setVisible(true);
    				} catch (Exception e) {
    					e.printStackTrace();
    				}
    			}
    		});
    	
    }
}
