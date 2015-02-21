package HttpServer3;
//API5 Handler
//Parameter /api?file1=filewithpath
//Make file1 copy in the Temp/ Dirrectory and return temp file name.

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;

import org.apache.commons.io.FileUtils;

public class MyHandlerApi5 extends MyHandlerApi {
	private File file1;
public int handler() throws IOException {
		file1 = takefile("file1");
		apicallscounter("API5");
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
