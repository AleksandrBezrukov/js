import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class JavaPanelRastr extends JPanel 
implements ActionListener
//,MouseListener,MouseMotionListener
{

	private static final long serialVersionUID = 1L;
	Graphics g;
	//private int x1,y1,x2,y2;
	DataClass dataClass;

	JavaPanelRastr(DataClass dataClass)
	{
		setLayout(null);
		setBounds(0,0,JavaFrameRastr.frameWidth,JavaFrameRastr.frameHeight);
		this.dataClass=dataClass;
		JPanel colorsPanel=new JPanel();
		colorsPanel.setLayout(null);
		colorsPanel.setBounds(670, 50, 100, 500);
		colorsPanel.setBackground(Color.red);
		colorsPanel.setLayout(new GridLayout(7,1,10,10));
		String[] colorList={"Black","White","Red","Blue","Yellow","Green","Orange"};
		
		for(String i:colorList)
		{
			JButton javaButton=new JButton(i);
			javaButton.addActionListener(this);
			colorsPanel.add(javaButton);
		}
		add(colorsPanel);
		
		DrawPanelRastr drawPanelRastr= new DrawPanelRastr(dataClass);
		/*JPanel drawPanel=new JPanel();
		drawPanel.setLayout(null);
		drawPanel.setBounds(0, 50, 600, 400);
		drawPanel.setBackground(Color.blue);
		add(drawPanel);*/
		add(drawPanelRastr);
		
		JPanel shapesPanel=new JPanel();
		shapesPanel.setLayout(null);
		shapesPanel.setBounds(0, 530, 650, 30);
		shapesPanel.setBackground(Color.green);
		shapesPanel.setLayout(new GridLayout(1,5,10,10));
		String[] shapesList={"Circle","Rectangle","RoundRectangle","Line","FreeStyle"};//,"Yellow","Green","Orange"};
		
		for(String i:shapesList)
		{
			JButton javaButton=new JButton(i);
			javaButton.addActionListener(this);
			shapesPanel.add(javaButton);
		}
		add(shapesPanel);
		
		JPanel thicknessPanel=new JPanel();
		thicknessPanel.setLayout(null);
		thicknessPanel.setBounds(0, 0, 650, 30);
		thicknessPanel.setBackground(Color.yellow);
		thicknessPanel.setLayout(new GridLayout(1,4,10,10));
		String[] thicknessList={"1","10","20","30"};//,"Yellow","Green","Orange"};
		
		for(String i:thicknessList)
		{
			JButton javaButton=new JButton(i);
			javaButton.addActionListener(this);
			thicknessPanel.add(javaButton);
		}
		add(thicknessPanel);
		setVisible(true);
	}
	
	

	@Override
	public void actionPerformed(ActionEvent arg0)
	{		
		String action=arg0.getActionCommand();
		switch(action)
		{
			case "Black":dataClass.curColor=Color.black;break;
			case "White":dataClass.curColor=Color.white;break;
			case "Red":dataClass.curColor=Color.red;break;
			case "Blue":dataClass.curColor=Color.blue;break;
			case "Yellow":dataClass.curColor=Color.yellow;break;
			case "Green":dataClass.curColor=Color.green;break;
			case "Orange":dataClass.curColor=Color.orange;break;
			
			case "1":dataClass.brushSize=1.0f;break;
			case "10":dataClass.brushSize=10.0f;break;
			case "20":dataClass.brushSize=20.0f;break;
			case "30":dataClass.brushSize=30.0f;break;
			
			case "Circle":dataClass.shape=1;break;
			case "Rectangle":dataClass.shape=2;break;
			case "RoundRectangle":dataClass.shape=3;break;
			case "Line":dataClass.shape=4;break;
			case "FreeStyle":dataClass.shape=0;break;
		}
	}
/*	@Override
	public void mouseDragged(MouseEvent arg0)
	{
	    int x1 = arg0.getX();
	    int y1 = arg0.getY();

	    Graphics2D g2=(Graphics2D)g;

	    g2.setColor(dataClass.curColor);
	    g2.setStroke(new BasicStroke(dataClass.brushSize));
	    //g2.set
	    g2.drawLine(x1, y1, x2, y2);

	    x2 = x1;
	    y2 = y1;
		
	}
	
	@Override
	public void mousePressed(MouseEvent arg0)
	{
		x1=arg0.getX();
		y1=arg0.getY();
		g=getGraphics();
        x2 = x1;
        y2 = y1;
		
	}

	@Override
	public void mouseMoved(MouseEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
		// TODO Auto-generated method stub
		
	}
	*/
}
