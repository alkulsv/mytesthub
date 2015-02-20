package HttpServer3;
//API5 Handler
//Parameter /api?file1=filewithpath
//Make file1 copy in the Temp/ Dirrectory and return temp file name.

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;

import org.apache.commons.io.FileUtils;

public class MyHandlerApi5 extends MyHandlerApi {
	public int handler(File file) throws IOException {
			if (file.isFile()){
			File tmpfile = File.createTempFile("testserver", ".tmp", new File("Temp/"));
			FileUtils.copyFile(file, tmpfile);
			stringbuffer.append(tmpfile.toString());
			return HttpURLConnection.HTTP_OK;
			}
			System.out.println("It is not the file");
			return HttpURLConnection.HTTP_BAD_REQUEST;
	    }
}
