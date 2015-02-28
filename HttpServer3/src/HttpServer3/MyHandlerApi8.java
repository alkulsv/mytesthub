package HttpServer3;
//API8 Handler
//Parameter /api8
//return total couner of requests  

import java.net.HttpURLConnection;
import java.util.Set;

/**
 *  Check the total API calls and total time spend. API8 Handler for /api8 context.<br>
 *  Sample request: localhost:8082/api7
 */
public class MyHandlerApi8 extends MyHandlerApi {

	/**
	 * This is main method. It  send total API calls counter and time spend to the stream.
	 * @return HTTP_OK.
	 */
	public int handler() {
    	long counter = 0;
		Set<String> keySet = apicalls.keySet();
		 for (String key : keySet) {
			 counter += apicalls.get(key)[0];
		 }
    stringbuffer.append(counter);
    stringbuffer.append(",");
    stringbuffer.append(timespendtotal);
	return HttpURLConnection.HTTP_OK;
    }
}
