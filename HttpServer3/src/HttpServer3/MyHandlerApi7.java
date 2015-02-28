package HttpServer3;

import java.net.HttpURLConnection;
import java.util.Set;

/**
 *  Check the API calls counters and time spend. API7 Handler for /api7 context.<br>
 *  Sample request: localhost:8082/api7
 */
public class MyHandlerApi7 extends MyHandlerApi {
  
	/**
	 * This is main method. It make list of all called API with counters of calls and total time spend.
	 * @return HTTP_OK.
	 */
public int handler() {
		Set<String> keySet = apicalls.keySet();
		 for (String key : keySet) {
			 stringbuffer.append(key + " : " + apicalls.get(key)[0] + "requests, totall time is " + apicalls.get(key)[1] + "\n");
		 }
	return HttpURLConnection.HTTP_OK;
    }
}
