strUrlCounter = "http://localhost:8082/api8?"
rem strUrl = "http://localhost:8082/api2?file1=testfiles/test.txt"
strUrl = "http://localhost:8082/api6?file1=testfiles/test.txt&file2=testfiles/test1.txt"

Set Http = WScript.CreateObject("MSXML2.ServerXMLHTTP") 
Http.open "GET", strUrlCounter, False
Http.send
counterStart = Http.ResponseText

rem Check for Server is working
If http.Status <> 200 Then
    WScript.Echo("Server not found")
    Stop
End If

Set WshShell = WScript.CreateObject("WScript.shell")
WshShell.run "ab -c20 -n 2000 " + strUrl,,True

Http.open "GET", strUrlCounter, False
http.send
counterEnd = Http.ResponseText

WScript.Echo("Total Requests is:" + Cstr(Cint(counterEnd) - Cint(counterStart) - 1))
