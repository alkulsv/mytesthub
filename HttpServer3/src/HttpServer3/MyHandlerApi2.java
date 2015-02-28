package HttpServer3;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.security.NoSuchAlgorithmException;

/**
 *  Return MD5 code for the file. API2 Handler for /api2 context.<br>
 *  Sample request: localhost:8082/api2?file1=filewithpath
 */
public class MyHandlerApi2 extends MyHandlerApi {
	private File file1;

	/**
	 * This is main method. Get the MD5 code for "file" from query (parameter "file1=file") and send it to the stream.
	 * @return HTTP_OK if MD5 code generation is OK, and HTTP_BAD_REQUEST if fail.
	 */
public int handler() throws IOException {
		file1 = takefile("file1");
		if(file1 != null) {
			if (file1.isFile()) {
			MessageDigestForFile digest = new MessageDigestForFile();
			String md5code = "";
			try {
				md5code = digest.getDigestForFile(file1.getPath());
		    	}    catch (NoSuchAlgorithmException e) {
		    		System.err.println("I'm sorry, but MD5 is not a valid message digest algorithm");
		    	}
				System.out.println("MD5 code: " + md5code);
				stringbuffer.append(md5code);
 				return HttpURLConnection.HTTP_OK;
	    	}
		}
		System.out.println("it is not the file");
		return HttpURLConnection.HTTP_BAD_REQUEST;
	}
}
