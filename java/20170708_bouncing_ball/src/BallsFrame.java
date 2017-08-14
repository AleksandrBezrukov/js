import javax.swing.JFrame;


public class BallsFrame extends JFrame
{
	
	
	//this.add(ballsPanel);
	BallsFrame()
	{
		BallsPanel ballsPanel=new BallsPanel();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(ballsPanel);
		setSize(800,600);
		setVisible(true);
	}
}
