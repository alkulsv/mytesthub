# HTTPServer3

   This is simple HTTP Server test program. After the start it will use port DEFAULT_PORT at the local host
   for the listening requests and send some answers, depend API number.
  
  /Api1  Return file size. Parameter: file1=filepath
  /Api2  Return MD5 code for the file. Parameter: file1=filepath
  /Api3  Return list of directory. Parameter: file=path
  /Api4  Return file body. Parameter: file1=filepath
  /Api5  Make the temporary copy of the file if Temp/ directory and return filepath of tmp-file. Parameter: file1=filepath
  /Api6  Compare two files for equals. Parameter: file1=filepath&amp;file2=filepath
  /Api7  Check the API calls counters and time spend.
  /Api8  Check the total API calls and total time spend.
   
   Sample request: http://localhost:8082/api1?file1=testfiles/test.txt
   
  @author Alexander Kulentsov
  @version 1.1
