package HttpServer3;
/*
 * Http TestServer
 * 
 *localhost:9998/api1?file=filewithpath
 *return file1 size.
 *
 *localhost:9998/api2?file=filewithpath
 *return file MD5 code.
 *
 *localhost:9998/api3?file=filewithpath
 *return file list of directory.
 *
 *localhost:9998/api4?file=filewithpath
 *return file body.
 *
 *localhost:9998/api5?file=filewithpath
 *Make file1 copy in the C:/Temp Dirrectory and return temp file name.
		 
 *localhost:9998/api?file1=filewithpath&file2=filewithpath
 *Compare file1&file2 and return results;   
 */
import java.io.IOException;
import java.net.InetSocketAddress;
import com.sun.net.httpserver.HttpServer;


public class HttpServer3 {
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
	   server.setExecutor(null); // creates a default executor
	   server.start();
	   System.out.println("NEW Server is listening on port  " + port);
	   
    }

	 
	private static final int DEFAULT_PORT = 8095;
    }