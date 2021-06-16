import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

import org.apache.commons.io.IOUtils;



public class MergeFiles {

	public static void main(String[] args) throws IOException, InterruptedException {
		
//		Downloader.getInstance().startThread();
//		Thread.sleep(2 * 1000);
//		
//		Downloader.getInstance().startThread();
//		Thread.sleep(2 * 1000);
//		
//		Downloader.getInstance().startThread();
//		Thread.sleep(2 * 1000);
//		
//		Downloader.getInstance().startThread();
//		Thread.sleep(2 * 1000);
//		
//		Downloader.getInstance().startThread();
//		Thread.sleep(2 * 1000);
//		
//		Downloader.getInstance().startThread();
//		Thread.sleep(2 * 1000);
//		
//		Downloader.getInstance().startThread();
//		Thread.sleep(2 * 1000);
//		
//		Downloader.getInstance().startThread();
//		Thread.sleep(2 * 1000);
		IOCopier.joinFiles(new File("C:\\Users\\kaila\\Desktop\\Stream\\out.png"), new File[] {
                new File("C:\\Users\\kaila\\Desktop\\Stream\\img1.txt"), new File("C:\\Users\\kaila\\Desktop\\Stream\\img2.txt") });
		
	}

}

class IOCopier {
    public static void joinFiles(File destination, File[] sources)
            throws IOException {
        OutputStream output = null;
        try {
            output = createAppendableStream(destination);
            for (File source : sources) {
                appendFile(output, source);
            }
        } finally {
            IOUtils.closeQuietly(output);
        }
    }

    private static BufferedOutputStream createAppendableStream(File destination)
            throws FileNotFoundException {
        return new BufferedOutputStream(new FileOutputStream(destination, true));
    }

    private static void appendFile(OutputStream output, File source)
            throws IOException {
        InputStream input = null;
        try {
            input = new BufferedInputStream(new FileInputStream(source));
            IOUtils.copy(input, output);
        } finally {
            IOUtils.closeQuietly(input);
        }
    }
}
