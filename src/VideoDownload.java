import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;



public class VideoDownload {

	public static void main(String[] args) throws IOException {
		String destinationToSave = "C:\\Users\\kaila\\Desktop\\Stream\\Video\\parts\\out_"+1+".mp4";
		File destFile = new File(destinationToSave);
		System.out.println(destFile.length());
    	String str_url = "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4";
		// TODO Auto-generated method stub
		URL url = new URL(str_url);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		long len = destFile.length();
		long fullLen = 158008373;
		conn.setRequestProperty(
			      "Range", 
			      "bytes=" + len + "-" + fullLen
			    );
		
		if(!destFile.exists())
			destFile.createNewFile();
		
		try (BufferedInputStream inputStream = new BufferedInputStream(conn.getInputStream());
				  FileOutputStream fileOS = new FileOutputStream(destinationToSave, true)) {
				    byte data[] = new byte[1024];
				    int byteContent;
				    while ((byteContent = inputStream.read()) != -1) {
				        fileOS.write(byteContent);
				    }
				} catch (IOException e) {
				    // handles IO exceptions
					throw e;
				}
	}

}
