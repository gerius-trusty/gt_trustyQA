Sleep(2000)
If WinActivate("Open","") Then
	Sleep(2000)
	ControlSend("Open","","Edit1",$CmdLine[1])

	Sleep(2000)
	;ControlClick("Open","","1]")
	Send("{ENTER}")
Else
	MsgBox ("","","s")
EndIf
