package HttpServer3;
//API7 Handler
//Parameter /api7
//return counters of all API requests  

import java.net.HttpURLConnection;
import java.util.Set;

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
