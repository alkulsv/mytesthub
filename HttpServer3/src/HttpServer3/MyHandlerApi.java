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

public abstract class MyHandlerApi implements HttpHandler {
    public Map<String, String> map;
	protected StringBuffer  stringbuffer = new StringBuffer("");
	public static Map <String, Integer> apicalls = new HashMap <String, Integer>();
	 public void handle(HttpExchange t) throws IOException {
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
	    }

	 /* take the filepath from  map and check for existing */
	 public File takefile(String filepath) throws IOException {
		 if ( map.get(filepath)!= null) {
     		File file = new File((String) map.get(filepath));
			if (file.exists()){
				return file;
			}
		 }
		return null;
 }
		 
	 public int handler()  throws IOException  {
		System.out.println("incorrect request");
		 return HttpURLConnection.HTTP_BAD_REQUEST;
	 }
	
	 /* count into apicalls count of calls api */
	   public void apicallscounter(String apiname) {
   if(apicalls != null & !apicalls.containsKey(apiname)) {
			   apicalls.put(apiname, 1);
		   }
			   else {		   
	    	apicalls.put(apiname, apicalls.get(apiname) + 1);
		   }
	   }

   public void logWrite(String message) throws IOException {
			   FileOutputStream logfile = new FileOutputStream(LOGFILEPATH, true);
		   		logfile.write(message.getBytes());
		   		logfile.close();
	   }

	   
	 //  parse query
	 public static Map<String, String> splitQuery(URI uri) throws UnsupportedEncodingException {
		    Map<String, String> query_pairs = new LinkedHashMap<String, String>();
		    String query = uri.getQuery();
		    String[] pairs = query.split("&");
		    for (String pair : pairs) {
		        int idx = pair.indexOf("=");
		        if (idx > 0) query_pairs.put(URLDecoder.decode(pair.substring(0, idx), "UTF-8"), URLDecoder.decode(pair.substring(idx + 1), "UTF-8"));
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