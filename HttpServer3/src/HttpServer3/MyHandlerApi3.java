package HttpServer3;
//API3 Handler
//Parameter /api3?file1=path
//return file list of directory.

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;

public class MyHandlerApi3 extends MyHandlerApi {
	private File file1;
public int handler() throws IOException {
		file1 = takefile("file1");
		apicallscounter("API3");
		if(file1 != null)
		{
			if(file1.isDirectory()) {
				File directorylist[] = file1.listFiles();
				for(int i = 0; i < directorylist.length; i++) {
					stringbuffer.append(directorylist[i].getName());
					stringbuffer.append("\n");
					}					
			}
		else { 
			System.out.println("Parameter must be Directory.\n");
			return HttpURLConnection.HTTP_BAD_REQUEST;
		}
		}
		return HttpURLConnection.HTTP_OK;
	}
}
