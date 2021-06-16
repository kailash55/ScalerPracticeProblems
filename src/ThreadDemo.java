import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

public class ThreadDemo extends Thread {
	//http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4
    public void run()
    {
        try {
        	Thread.sleep(10 * 1000);
            // Displaying the thread that is running
            System.out.println(
                "Thread " + Thread.currentThread().getId()
                + " is running");
            
        }
        catch (Exception e) {
            // Throwing an exception
            System.out.println("Exception is caught");
        }
    }
    
    public void downloadVideo(int part) throws IOException
    {
    	String destinationToSave = "C:\\\\Users\\\\kaila\\\\Desktop\\\\Stream\\\\parts\\\\out_"+part+".png";
    	String url = "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4";
    	
    	try (BufferedInputStream inputStream = new BufferedInputStream(new URL(url).openStream());
		  FileOutputStream fileOS = new FileOutputStream(destinationToSave)) {
		    byte data[] = new byte[1024];
		    int byteContent;
		    while ((byteContent = inputStream.read(data, 0, 1024)) != -1) {
		        fileOS.write(data, 0, byteContent);
		    }
		} catch (IOException e) {
		    // handles IO exceptions
			throw e;
		}
    }
}
