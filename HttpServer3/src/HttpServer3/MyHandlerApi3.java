package HttpServer3;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;

/**
 *  Return list of directory. API3 Handler for /api3 context. <br>
 *  Sample request: localhost:8082/api3?file1=path
 */
public class MyHandlerApi3 extends MyHandlerApi {
	private File file1;

	/**
	 * This is main method. It send list of directory tj the stream. The path take from query parameter "file1=path".
	 * @return HTTP_OK if MD5 code generation is OK, and HTTP_BAD_REQUEST if fail.
	 */
	public int handler() throws IOException {
		file1 = takefile("file1");
		if(file1 != null)
		{
			if(file1.isDirectory()) {
				File directorylist[] = file1.listFiles();
				for(int i = 0; i < directorylist.length; i++) {
					stringbuffer.append(directorylist[i].getName());
					stringbuffer.append("\n");
					}					
			}
		else { 
			System.out.println("Parameter must be Directory.\n");
			return HttpURLConnection.HTTP_BAD_REQUEST;
		}
		}
		return HttpURLConnection.HTTP_OK;
	}
}
