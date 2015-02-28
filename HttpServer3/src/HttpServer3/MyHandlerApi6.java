package HttpServer3;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import org.apache.commons.io.FileUtils;

/**
 *  <p>Compare two files for equals. API6 Handler for /api6 context.<br>
 *  Sample request: localhost:8082/api6?file1=filewithpat&amp;hfile2=filewithpath"</p>
 */
public class MyHandlerApi6 extends MyHandlerApi {
	private File file1, file2;

	/**
	 * This is main method. It comare two files from query (parameters "file1=filewithpath" and "file2=filewithpath") and send answer to the stream.
	 *  If files equals, answer is True, another False. 
	 * @return HTTP_OK if files found, and HTTP_BAD_REQUEST if fail.
	 */
	public int handler() throws IOException {
		file1 = takefile("file1");
		file2 = takefile("file2");
		if(file1 != null & file2 != null) {			
    		if(file1.isFile() & file2.isFile()) {
    			Boolean results = FileUtils.contentEquals(file1, file2);
    	    	System.out.println(results ? "Files equal" : "Files is NOT equal");
    			stringbuffer.append(results);
    			return HttpURLConnection.HTTP_OK;
    		}
    		else {
    			System.out.println("File not found");
    		}
    	}
    	System.out.println("Incorrect request");
    	return HttpURLConnection.HTTP_BAD_REQUEST;
    }
}
