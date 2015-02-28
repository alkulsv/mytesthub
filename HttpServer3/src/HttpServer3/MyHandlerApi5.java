package HttpServer3;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;

import org.apache.commons.io.FileUtils;

/**
 *  Make the temporary copy of the file if Temp/ directory and return filepath of tmp-file. API5 Handler for /api5 context.<br>
 *  Sample request: localhost:8082/api5?file1=filewithpath
 */
public class MyHandlerApi5 extends MyHandlerApi {
	private File file1;

	/**
	 * This is main method. Make the copy of file from query (parameter "file1=filewithpath") in the Temp/ dirrecrory. Send the tmp-file filepath to the stream.
	 * @return HTTP_OK if file found, and HTTP_BAD_REQUEST if fail.
	 */
public int handler() throws IOException {
		file1 = takefile("file1");
		if(file1 != null) {			
			if (file1.isFile()){
			File tmpfile = File.createTempFile("testserver", ".tmp", new File("Temp/"));
			FileUtils.copyFile(file1, tmpfile);
			stringbuffer.append(tmpfile.toString());
			return HttpURLConnection.HTTP_OK;
			}
		}
		System.out.println("It is not the file");
		return HttpURLConnection.HTTP_BAD_REQUEST;
	    }
}
