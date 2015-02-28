package HttpServer3;
// API1 Handler
// Parameter /api?file1=filewithpath
// return file1 size.
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

/**
 *  This is main API handler.
 */

public abstract class MyHandlerApi implements HttpHandler {
    public Map<String, String> map;
	protected StringBuffer  stringbuffer = new StringBuffer("");
	protected static Long timespendtotal = (long) 0;
	public static Map <String, long[]> apicalls = new HashMap <String, long[]>();

	/**
	 *  This is main method of API handler. It is provide logging information and time spend for all API calls. 
	 */
	public void handle(HttpExchange t) throws IOException {
		    Long timestart = System.currentTimeMillis();
		    stringbuffer.setLength(0);
		    int code = HttpURLConnection.HTTP_BAD_REQUEST;
	        URI uri = t.getRequestURI();
	        OutputStream os = t.getResponseBody();
	        System.out.println("Request: " + uri.getQuery());
	        map = splitQuery(uri);
	        code = handler();
	        logWrite("Request: " + uri.toString() + ",   Answer code is " + code + "\n");
	        t.sendResponseHeaders(code, 0);
	        os.write(stringbuffer.toString().getBytes());
	        os.close();
		    Long timeend = System.currentTimeMillis();
		    Long timework = timeend - timestart;
		    timespendtotal += timework;
		    apicallscounter(uri.getPath(), timework);
	    }

	/**
	 *  This method try to found file for parameter filepath. If parameter founded and it is file, method return object File. Another return null.
	 *  @param paramnane Is the name of parameter.
	 *  @throws IOException IO-error exception.
	 *  @return file Object File, or null. 
	 */
	 public File takefile(String paramnane) throws IOException {
		 if ( map.get(paramnane)!= null) {
     		File file = new File((String) map.get(paramnane));
			if (file.exists()){
				return file;
			}
		 }
		return null;
 }
		 
		/**
		 *  This handler will run, if any correct API handlers not found.
		 *  @return HTTP_BAD_REQUEST 
     	 *  @throws IOException IO-error exception.
		 */
	 public int handler()  throws IOException  {
		System.out.println("incorrect request");
		 return HttpURLConnection.HTTP_BAD_REQUEST;
	 }
	
		/**
		 *  This method update API calls counters and API calls time spend.
		 *  @param apiname Name of current API.
		 *  @param timework spend of current API.
		 */
	   public void apicallscounter(String apiname, long timework) {
   if(apicalls != null & !apicalls.containsKey(apiname)) {
			   apicalls.put(apiname, new long[] {1, timework});
		   }
			   else {
	    	apicalls.put(apiname, new long[] {apicalls.get(apiname)[0] + 1, apicalls.get(apiname)[1] + timework});
		   }
	   }

		/**
		 *  This method logging all API requests in file LOGFILEPATH.
		 *  @param message Text for the logging.
		 *  @throws IOException IO-error exception.
		 */
   public void logWrite(String message) throws IOException {
			   FileOutputStream logfile = new FileOutputStream(LOGFILEPATH, true);
		   		logfile.write(message.getBytes());
		   		logfile.close();
	   }

	   
	/**
	 *  This method parse the query.
	 *  @param uri current URI.
	 *  @return  query_pairs
	 *  @throws UnsupportedEncodingException Encoding exception.
	 */
	 public static Map<String, String> splitQuery(URI uri) throws UnsupportedEncodingException {
		    Map<String, String> query_pairs = new LinkedHashMap<String, String>();
		    String query = uri.getQuery();
		    if(query != null) {
		    String[] pairs = query.split("&");
		    for (String pair : pairs) {
		        int idx = pair.indexOf("=");
		        if (idx > 0) query_pairs.put(URLDecoder.decode(pair.substring(0, idx), "UTF-8"), URLDecoder.decode(pair.substring(idx + 1), "UTF-8"));
		    }
		    }
		    return query_pairs;
		}	 
	 
	 /*	   parse query multi paremeters
	 public static Map<String, List<String>> splitQuery(URI uri) throws UnsupportedEncodingException {
		  final Map<String, List<String>> query_pairs = new LinkedHashMap<String, List<String>>();
		  final String[] pairs = uri.getQuery().split("&");
		  for (String pair : pairs) {
		    final int idx = pair.indexOf("=");
		    final String key = idx > 0 ? URLDecoder.decode(pair.substring(0, idx), "UTF-8") : pair;
		    if (!query_pairs.containsKey(key)) {
		      query_pairs.put(key, new LinkedList<String>());
		    }
		    final String value = idx > 0 && pair.length() > idx + 1 ? URLDecoder.decode(pair.substring(idx + 1), "UTF-8") : null;
		    query_pairs.get(key).add(value);
		  }
		  return query_pairs;
		}
*/
	 
		public static final String LOGFILEPATH = "Temp/httpserver3.log";

}