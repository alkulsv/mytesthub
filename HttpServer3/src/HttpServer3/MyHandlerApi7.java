package HttpServer3;
//API6 Handler
//Parameter /api?file1=filewithpath&file2=filewithpath
//Compare file1&file2 and return results;  

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.Set;

import org.apache.commons.io.FileUtils;

public class MyHandlerApi7 extends MyHandlerApi {
    public int handler() {
		apicallscounter("API7");
		Set<String> keySet = apicalls.keySet();
		 for (String key : keySet) {
			 stringbuffer.append(key + " : " + apicalls.get(key) + "\n");
		 }
	return HttpURLConnection.HTTP_OK;
    }
}
