package HttpServer3;
//API4 Handler
//Parameter /api?file1=filewithpath
//return file body.

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;

import org.apache.commons.io.FileUtils;

public class MyHandlerApi4 extends MyHandlerApi {
	public int handler(File file) throws IOException {
		if(file.isFile()){
			stringbuffer.append(FileUtils.readFileToString(file));
			return HttpURLConnection.HTTP_OK;
			}
		System.out.println("it is not the file");
		return HttpURLConnection.HTTP_BAD_REQUEST;
	    }
}