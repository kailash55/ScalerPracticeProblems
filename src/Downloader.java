import java.lang.Thread.State;

public class Downloader {

	private static Downloader downloader;
	private ThreadDemo td;
	
	private Downloader()
	{
		td = new ThreadDemo();
		//td.
	}
	
	public static Downloader getInstance()
	{
		if(downloader == null)
			downloader = new Downloader();
		
		return downloader;
	}
	
	public void startThread()
	{
		if(td.getState() == State.NEW)
		{
			td.start();
			System.out.println("Thread Started");
		}
		else {
			System.out.println(td.getState());
		}
	}
	
}
