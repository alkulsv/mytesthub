package HttpServer3;
//API6 Handler
//Parameter /api6?file1=filewithpath&file2=filewithpath
//Compare file1&file2 and return results;  

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;

import org.apache.commons.io.FileUtils;

public class MyHandlerApi6 extends MyHandlerApi {
	private File file1, file2;
public int handler() throws IOException {
		file1 = takefile("file1");
		file2 = takefile("file2");
		apicallscounter("API6");
		if(file1 != null & file2 != null) {			
    		if(file1.isFile() & file2.isFile()) {
    			stringbuffer.append(FileUtils.contentEquals(file1, file2) ? "Files equal":"Files is NOT equal");
    			return HttpURLConnection.HTTP_OK;
    		}
    		else {
    			System.out.println("File not found");
    		}
    	}
    	System.out.println("Incorrect request");
    	return HttpURLConnection.HTTP_BAD_REQUEST;
    }
}
