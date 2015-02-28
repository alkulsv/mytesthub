package HttpServer3;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;

import org.apache.commons.io.FileUtils;

/**
 *  Return file body. API4 Handler for /api4 context. <br>
 *  Sample request: localhost:8082/api4?file1=filewithpath
 */
public class MyHandlerApi4 extends MyHandlerApi {
	private File file1;

	/**
	 * This is main method. Get the file body from query (parameter "file1=file") and send it to the stream.
	 * @return HTTP_OK if file found, and HTTP_BAD_REQUEST if fail.
	 */
public int handler() throws IOException {
		file1 = takefile("file1");
		if(file1 != null) {
			if(file1.isFile()){
				stringbuffer.append(FileUtils.readFileToString(file1));
				return HttpURLConnection.HTTP_OK;
				}
		}
		System.out.println("it is not the file");
		return HttpURLConnection.HTTP_BAD_REQUEST;
	    }
}