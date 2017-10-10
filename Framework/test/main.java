package test;

import com.baufest.bat.core.enums.LogType;
import com.baufest.bat.core.logging.LogManager;

public class main {

    static LogManager logManager = new LogManager();


    public static void main (String [ ] args) {

        logManager.logInfo("INFOOOO");
        logManager.logFatal("FATALLL");
        logManager.logError("ERRORRRR");
        logManager.logWarning("WARNINGGGG");

    }
}
