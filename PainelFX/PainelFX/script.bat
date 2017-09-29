net stop WinVNC4
net start WinVNC4
net stop wuauserv
sc stop wuauserv
sc config wuauserv start= disabled
