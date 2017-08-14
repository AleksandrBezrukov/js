import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
//import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
//import java.awt.event.MouseWheelListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class DrawPanelRastr extends JPanel
implements MouseListener,MouseMotionListener
{
	private static final long serialVersionUID = 1L;
//	JPanel drawPanel=new JPanel();
//	drawPanel.setLayout(null);
//	drawPanel.setBounds(0, 50, 600, 400);
//	drawPanel.setBackground(Color.blue);
//	add(drawPanel);
	Graphics g;
	//private int x1,y1,x2,y2;
	DataClass dataClass;
	BufferedImage bi=new BufferedImage(800, 800, BufferedImage.TYPE_INT_ARGB);
	
	DrawPanelRastr(DataClass dataClass)
	{
		Graphics2D gg=(Graphics2D)bi.getGraphics();
		gg.setColor(Color.WHITE);
		gg.fillRect(0, 0, 800, 800);
		
		setLayout(null);
		setBounds(0, 50, 600, 400);
		this.dataClass=dataClass;
		setBackground(Color.white);
	    this.addMouseListener(this);
	    this.addMouseMotionListener(this);
	}
	
//	@Override
//	public void mouseDragged(MouseEvent arg0)
//	{
//
//		
//	}
	
	
	@Override
	public void mouseDragged(MouseEvent arg0)
	{
		if(dataClass.shape==0)
		{
			//dataClass.x1 = arg0.getX();
			//dataClass.y1 = arg0.getY();
			
			dataClass.x1 = arg0.getX();
			dataClass.y1 = arg0.getY();
			
		    //dataClass.x2 = dataClass.x1;
		    //dataClass.y2 = dataClass.y1;
	
		    //Graphics2D g2=(Graphics2D)g;
			Graphics2D g2=(Graphics2D)bi.getGraphics();
					//getGraphics();

	
		    g2.setColor(dataClass.curColor);
		    g2.setStroke(new BasicStroke(dataClass.brushSize));
		    //g2.set
		    //g2.drawLine(dataClass.x1, dataClass.y1, dataClass.x2, dataClass.y2);
		    g2.drawLine(dataClass.x1, dataClass.y1, dataClass.x2, dataClass.y2);
		    //g2.drawRect(dataClass.x1, dataClass.y1, dataClass.x2-dataClass.x1, dataClass.y2-dataClass.y1);//x, y, width, height);
		    //g2.drawRect(10, 10, 100, 100);//x, y, width, height);
	
		    dataClass.x2 = dataClass.x1;
		    dataClass.y2 = dataClass.y1;
		}
		repaint();
	}
	
	@Override
	public void mousePressed(MouseEvent arg0)
	{
		dataClass.x1=arg0.getX();
		dataClass.y1=arg0.getY();
		//g=getGraphics();
		dataClass.x2 = dataClass.x1;
		dataClass.y2 = dataClass.y1;
		repaint();
		
	}
	
	@Override
	public void mouseReleased(MouseEvent arg0)
	{
		if(dataClass.shape!=0)
		{
			dataClass.x2 = arg0.getX();
			dataClass.y2 = arg0.getY();
			
		    //dataClass.x2 = dataClass.x1;
		    //dataClass.y2 = dataClass.y1;
	
		    //Graphics2D g2=(Graphics2D)g;
			Graphics2D g2=(Graphics2D)bi.getGraphics();
					//getGraphics();
	
		    g2.setColor(dataClass.curColor);
		    g2.setStroke(new BasicStroke(dataClass.brushSize));
		    switch(dataClass.shape)
		    {
		    case 1: g2.drawOval(dataClass.x1, dataClass.y1, dataClass.x2-dataClass.x1, dataClass.y2-dataClass.y1);break;
		    case 2: g2.drawRect(dataClass.x1, dataClass.y1, dataClass.x2-dataClass.x1, dataClass.y2-dataClass.y1);
		    break;
		    case 3: g2.drawRoundRect(dataClass.x1, dataClass.y1, dataClass.x2-dataClass.x1, dataClass.y2-dataClass.y1,5,5);
		    break;
		    case 4: g2.drawLine(dataClass.x1, dataClass.y1, dataClass.x2, dataClass.y2);
		    break;//.drawOval(x, y, width, height);break;
		    }
		    repaint();
		}
	}
	
	@Override
	public void paint(Graphics g)
	{
		super.paint(g);
		Graphics2D g2=(Graphics2D)g;
		g2.drawImage(bi, 0,0,null);
	}
	
	@Override
	public void mouseMoved(MouseEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseClicked(MouseEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}
/*
	@Override
	public void mouseReleased(MouseEvent arg0)
	{
		dataClass.x2 = arg0.getX();
		dataClass.y2 = arg0.getY();
		
	    //dataClass.x2 = dataClass.x1;
	    //dataClass.y2 = dataClass.y1;

	    //Graphics2D g2=(Graphics2D)g;
		Graphics2D g2=(Graphics2D)getGraphics();

	    g2.setColor(dataClass.curColor);
	    g2.setStroke(new BasicStroke(dataClass.brushSize));
	    //g2.set
	    //g2.drawLine(dataClass.x1, dataClass.y1, dataClass.x2, dataClass.y2);
	    //g2.drawLine(dataClass.x1, dataClass.y1, dataClass.x2, dataClass.y2);
	    g2.drawRect(dataClass.x1, dataClass.y1, dataClass.x2-dataClass.x1, dataClass.y2-dataClass.y1);//x, y, width, height);

		
	}*/
}
