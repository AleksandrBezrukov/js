import javax.swing.SwingUtilities;

public class BallsMain
{

	public static void main(String[] args)
	{
		SwingUtilities.invokeLater(new Runnable()
		{	
			public void run()
			{
				new BallsFrame();
			}
		}
		);
	}

}
