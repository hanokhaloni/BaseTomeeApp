@echo off
IF [%1] == [] GOTO END
if not exist %1 GOTO END
echo cleaning folder: %1
cd "%1"
del /Q *.*
for /d %%i in (*) do rmdir /s /q "%%i" 
cd ..
:END