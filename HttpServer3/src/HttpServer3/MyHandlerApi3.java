package HttpServer3;
//API3 Handler
//Parameter /api?file1=path
//return file list of directory.

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;

public class MyHandlerApi3 extends MyHandlerApi {
	public int handler(File file) throws IOException {
			if(file.isDirectory()) {
				File directorylist[] = file.listFiles();
				for(int i = 0; i < directorylist.length; i++) {
					stringbuffer.append(directorylist[i].getName());
					stringbuffer.append("\n");
					}					
			}
		else { 
			System.out.println("Parameter must be Directory.\n");
			return HttpURLConnection.HTTP_BAD_REQUEST;
		}
		return HttpURLConnection.HTTP_OK;
	    }
}
