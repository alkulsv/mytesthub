package HttpServer3;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;

/**
 *  Return file size. API1 Handler for /api1 context.<br>
 *  Sample request: localhost:8082/api1?file1=filewithpath
 */
public class MyHandlerApi1 extends MyHandlerApi {
	private File file1;
	
	/**
	 * This is main method. Get the file size for "file" from query (parameter "file1=file") and send it to the stream.
	 * @return HTTP_OK if file found, and HTTP_BAD_REQUEST if file not founded.
	 */
    public int handler() throws IOException {
    		file1 = takefile("file1");
    		if(file1 != null) {
        		stringbuffer.append(file1.length());
   			return HttpURLConnection.HTTP_OK;
        	}
		return HttpURLConnection.HTTP_BAD_REQUEST;
	}
}