package HttpServer3;
//API8 Handler
//Parameter /api8
//return total couner of requests  

import java.net.HttpURLConnection;
import java.util.Set;

public class MyHandlerApi8 extends MyHandlerApi {
    public int handler() {
    	Integer counter = 0;
		apicallscounter("API8");
		Set<String> keySet = apicalls.keySet();
		 for (String key : keySet) {
			 counter += apicalls.get(key);
		 }
    stringbuffer.append(counter);
	return HttpURLConnection.HTTP_OK;
    }
}
