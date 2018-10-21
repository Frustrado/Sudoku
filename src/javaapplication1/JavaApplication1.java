package javaapplication1;


import java.io.IOException;
import javax.swing.JFrame;
/**
* class is main class of application thanks to which our application works,
*create new Controller, View and Model
* @author Max
*/
public class JavaApplication1 {

   
	/**
	 * Main function, by controller we communicate with view and model
	 * @param args such construction of java :)
	 * @throws IOException if IOException is detected
	 */
    public static void main(String[] args) throws IOException 
    {
        Controller controller = new Controller(new Model());        
        NewJFrame f = new NewJFrame(controller);      
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanelCanvas canvas = new JPanelCanvas(controller);
        f.getContentPane().add(canvas,java.awt.BorderLayout.WEST);
        canvas.addMouseListener(canvas);        
        f.setSize(810, 540);
        f.setVisible(true);
    }

}
