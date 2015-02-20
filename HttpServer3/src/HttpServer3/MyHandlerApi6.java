package HttpServer3;
//API6 Handler
//Parameter /api?file1=filewithpath&file2=filewithpath
//Compare file1&file2 and return results;  

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;

import org.apache.commons.io.FileUtils;

public class MyHandlerApi6 extends MyHandlerApi {
    public int handler(File file) throws IOException {
    	if(map.get("file2")!= null) {
    		File file2 = new File((String) map.get("file2"));
    		if(file2.exists() & file.isFile() & file2.isFile()) {
    			stringbuffer.append(FileUtils.contentEquals(file, file2) ? "Files equal":"Files is NOT equal");
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
