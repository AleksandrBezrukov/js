import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.Random;

import javax.swing.JPanel;

public class BallPanel extends JPanel
{
	private static final long serialVersionUID = 1L;
	
	Point p;
	Color ballColor;
	int radius=50;
	int dx=0;
	int dy=0;
	boolean isDragged=false;
	
	public BallPanel(Point p)
	{
		this.p=p;
		
		Random ra = new Random();
		
		int r, g, b;
		r=ra.nextInt(255);
		g=ra.nextInt(255);
		b=ra.nextInt(255);
		ballColor= new Color(r,g,b);
		
		while(dx==0&&dy==0)
		{
			dx=ra.nextInt(6)-5;
			dy=ra.nextInt(6)-5;
		}
	}
	
	public void move(int w, int h)
	{
		if(p.x<=0||p.x>=w)dx=-dx;
		if(p.y<=0||p.y>=h)dy=-dy;
		p.translate(dx, dy);
	}
	
	public void draw(Graphics2D g2d)
	{
		//if(!isDragged){
		g2d.setColor(ballColor);
		g2d.fillOval(p.x, p.y, radius, radius);
	}
}
