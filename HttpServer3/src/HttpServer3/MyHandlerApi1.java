package HttpServer3;
// API1 Handler
// Parameter /api?file1=filewithpath
// return file1 size.
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;

public class MyHandlerApi1 extends MyHandlerApi {
	private File file1;
    public int handler() throws IOException {
    		file1 = takefile("file1");
    		apicallscounter("API1");
    		if(file1 != null) {
        		stringbuffer.append(file1.length());
   			return HttpURLConnection.HTTP_OK;
        	}
		return HttpURLConnection.HTTP_BAD_REQUEST;
	}
}