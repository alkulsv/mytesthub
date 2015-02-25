package HttpServer3;
//API4 Handler
//Parameter /api4?file1=filewithpath
//return file body.

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;

import org.apache.commons.io.FileUtils;

public class MyHandlerApi4 extends MyHandlerApi {
	private File file1;
public int handler() throws IOException {
		file1 = takefile("file1");
		apicallscounter("API4");
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