import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class BallsPanel extends JPanel implements MouseListener,MouseMotionListener
{
	private static final long serialVersionUID = 1L;
	ArrayList<Ball> ballsList=new ArrayList<Ball>();
	Ball ball=null;
	
	BallsPanel()
	{
		addMouseListener(this);
		addMouseMotionListener(this);
		Timer tm=
				new Timer(50,
				new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e)
					{
						repaint();
					}
				}
		);
		tm.start();
	}
	
	@Override
	public void paint(Graphics g)
	{
		super.paint(g);
		for(Ball b:ballsList)
		{
			b.move(BallsPanel.this.getWidth(),BallsPanel.this.getHeight());
			b.draw((Graphics2D)g);
		}
	}

	@Override
	public void mousePressed(MouseEvent arg0)
	{
		if(SwingUtilities.isLeftMouseButton(arg0))
		{
			int x1=arg0.getX();
			int y1=arg0.getY();
			boolean flg=true;
			//Ball ball=null;
		//SwingUtilities.isRightMouseButton(arg0)
			//System.out.println("left pressed");
			for(int i=0;i<ballsList.size();i++)
			{
				/*System.out.print("ballsList.get(i).p.x-ballsList.get(i).radius="+(ballsList.get(i).p.x-ballsList.get(i).radius));
				
				System.out.print(" ballsList.get(i).p.x+ballsList.get(i).radius="+(ballsList.get(i).p.x+ballsList.get(i).radius));
				System.out.println(" x1="+x1);
				
				System.out.print("ballsList.get(i).p.y-ballsList.get(i).radius="+(ballsList.get(i).p.y-ballsList.get(i).radius));

				System.out.print(" ballsList.get(i).p.y-ballsList.get(i).radius="+(ballsList.get(i).p.y-ballsList.get(i).radius));
				System.out.println(" y1="+y1);*/
				if(
						(ballsList.get(i).p.x-ballsList.get(i).radius<=x1)&&(ballsList.get(i).p.x+ballsList.get(i).radius>=x1)
						&&
						(ballsList.get(i).p.y-ballsList.get(i).radius<=y1)&&(ballsList.get(i).p.y+ballsList.get(i).radius>=y1)
						){
					ball=ballsList.get(i);
				ball.isDragged=true;flg=false;}
					//ballsList.remove(i);
				
				break;
			}
			//if(ballsList.size()>0)
			//System.out.println("x1="+x1+" y1="+y1+" p.x="+ballsList.get(0).p.x+" p.y="+ballsList.get(0).p.y+" radius="+ballsList.get(0).radius);
			//System.out.println("flg="+flg+" ballsList.size()="+ballsList.size());
			if(flg||ballsList.size()==0){ballsList.add(new Ball(arg0.getPoint()));flg=true;ball=null;}
		}
		if(SwingUtilities.isRightMouseButton(arg0))
		{System.out.println("right pressed");}
		
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

	@Override
	public void mouseReleased(MouseEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent arg0)
	{
		//System.out.println("x="+arg0.getX()+" y="+arg0.getY());
		if(ball!=null)ball.p=arg0.getPoint();
		//System.out.println("x="+arg0.getX()+" y="+arg0.getY());
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0)
	{
		//System.out.println("x="+arg0.getX()+" y="+arg0.getY());
		
	}

}
