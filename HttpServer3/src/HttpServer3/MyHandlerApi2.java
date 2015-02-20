package HttpServer3;
//API2 Handler
//Parameter /api?file1=filewithpath
//return file MD5 code.

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.security.NoSuchAlgorithmException;


public class MyHandlerApi2 extends MyHandlerApi {
	public int handler(File file) throws IOException {
		if (file.isFile()){
			MessageDigestForFile digest = new MessageDigestForFile();
			String md5code = "";
			try {
				md5code = digest.getDigestForFile(file.getPath());
		    	}    catch (NoSuchAlgorithmException e) {
		    		System.err.println("I'm sorry, but MD5 is not a valid message digest algorithm");
		    	}
				System.out.println("MD5 code: " + md5code);
				stringbuffer.append(md5code);
 				return HttpURLConnection.HTTP_OK;
	    	}
		System.out.println("it is not the file");
		return HttpURLConnection.HTTP_BAD_REQUEST;
	}
}