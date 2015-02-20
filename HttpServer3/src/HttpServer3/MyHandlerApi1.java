package HttpServer3;
// API1 Handler
// Parameter /api?file1=filewithpath
// return file1 size.
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;

public class MyHandlerApi1 extends MyHandlerApi {
    public int handler(File file) throws IOException {
    		stringbuffer.append(file.length()); 
   			return HttpURLConnection.HTTP_OK;
        	}
}