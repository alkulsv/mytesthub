strUrlCounter = "http://localhost:8082/api8?"
Dim strUrl
strUrl = Array("http://localhost:8082/api1?file1=testfiles/test.txt", _
               "http://localhost:8082/api2?file1=testfiles/test.txt", _
               "http://localhost:8082/api3?file1=testfiles/", _
               "http://localhost:8082/api4?file1=testfiles/test.txt", _
               "http://localhost:8082/api4?file1=testfiles/test1.txt", _
               "http://localhost:8082/api6?file1=testfiles/test.txt&file2=testfiles/test1.txt", _
               "http://localhost:8082/api7?", _
               "http://localhost:8082/api8?")

Set Http = WScript.CreateObject("MSXML2.ServerXMLHTTP") 
Http.open "GET", strUrlCounter, False
Http.send
counterStart = Left(Http.ResponseText, Cint(InStr(Http.ResponseText, ",")) - 1)
counterTimeStart = Right(Http.ResponseText, len(Http.ResponseText) - Cint(InStr(Http.ResponseText, ",")))

rem Check for Server is working
If http.Status <> 200 Then
    WScript.Echo("Server not found")
    Stop
End If

Set WshShell = WScript.CreateObject("WScript.shell")
For I = 1 To 5
WshShell.run "ab -c20 -n 400 " + strUrl(Int(Rnd * 7)),,False
Next

WScript.Sleep 10000

Http.open "GET", strUrlCounter, False
http.send
counterEnd = Mid(Http.ResponseText, 1, Cint(InStr(Http.ResponseText, ",")) - 1)
counterTimeEnd = Right(Http.ResponseText, len(Http.ResponseText) - Cint(InStr(Http.ResponseText, ",")))

WScript.Echo("Total Requests is " + Cstr(counterEnd - CounterStart - 1) _
              + "pcs, Total Time is " + Cstr(counterTimeEnd - CounterTimeStart - 1) + "ms.")
