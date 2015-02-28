package HttpServer3;
import java.io.IOException;
import java.net.InetSocketAddress;
import com.sun.net.httpserver.HttpServer;

/**
 * This is simple HTTP Server test program. After the start it will use port DEFAULT_PORT at the local host
 * for the listening requests and send some answers, depend API number. <br>
 * /Api1  Return file size. Parameter: file1=filepath <br>
 * /Api2  Return MD5 code for the file. Parameter: file1=filepath <br>
 * /Api3  Return list of directory. Parameter: file=path <br>
 * /Api4  Return file body. Parameter: file1=filepath <br>
 * /Api5  Make the temporary copy of the file if Temp/ directory and return filepath of tmp-file. Parameter: file1=filepath <br>
 * /Api6  Compare two files for equals. Parameter: file1=filepath&amp;file2=filepath <br>
 * /Api7  Check the API calls counters and time spend. <br>
 * /Api8  Check the total API calls and total time spend. <br>
 *  <br>
 *  Sample request: http://localhost:8082/api1?file1=testfiles/test.txt <br>
 *  <br>
 * @author Alexander Kulentsov
 * @version 1.1
 *
 */

public class HttpServer3 {
	
	/**
	 *  This is main method.
	 *  
	 * @param args parameters.
	 * @throws IOException IO-error exception.
	 */
	public static void main(String[] args)
	  throws IOException {
		int port = DEFAULT_PORT; if (args.length > 0)
		{ port = Integer.parseInt(args[0]); }	
		InetSocketAddress addr = new InetSocketAddress(port); 
	   HttpServer server = HttpServer.create(addr, 0);
	   server.createContext("/api1", new MyHandlerApi1());
	   server.createContext("/api2", new MyHandlerApi2());
	   server.createContext("/api3", new MyHandlerApi3());
	   server.createContext("/api4", new MyHandlerApi4());
	   server.createContext("/api5", new MyHandlerApi5());
	   server.createContext("/api6", new MyHandlerApi6());
	   server.createContext("/api7", new MyHandlerApi7());
	   server.createContext("/api8", new MyHandlerApi8());
	   server.setExecutor(null); // creates a default executor
	   server.start();
	   System.out.println("NEW Server is listening on port  " + port);
       }
 
	/**
	 * is define default port.
	 */
	private static final int DEFAULT_PORT = 8082;
    }
