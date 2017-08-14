import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
//import javax.swing.JPanel;

public class JavaFrameRastr extends JFrame
{
	public static final int frameWidth=800;
	public static final int frameHeight=600;
	JavaFrameRastr()
	{
		DataClass dataClass=new DataClass();
		JavaPanelRastr javaPanelRastr=new JavaPanelRastr(dataClass);
		//JFrame jframe=new JFrame();
		//jframe.setForeground(Color.BLACK);
		//JavaPanel javapanel=new JavaPanel();
		setTitle("Rastr");
		//jframe.
		//jframe.
		setLayout(null);
		//jframe.
		setBounds(50, 50, frameWidth, frameHeight);
		//JButton test=new JButton("Show");
		//test.setLayout(null);
		//test.setBounds(50, 50, 150, 30);
		add(javaPanelRastr);
		//jframe.
		//getContentPane().setBackground(Color.CYAN);
		//jframe.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//this.add(javapanel);
		//jframe.add(new JPanel());
		//jframe.
		setVisible(true);
	}
}
