package test;

import com.baufest.bat.core.enums.LogType;
import com.baufest.bat.core.logging.LogManager;

public class main {

    static LogManager logManager = new LogManager();


    public static void main (String [ ] args) {

        logManager.startTest("test1","descrip","category","miguel","message");

        logManager.logInfo("PASO 1");
        logManager.logInfo("PASO 2");
        logManager.logInfo("PASO 3");
        logManager.logInfo("PASO 4");
        logManager.logError("ERRORRRR");

        logManager.endTest();

    }
}
