package test;

import com.baufest.bat.core.helpers.logging.LogManager;
import org.junit.Test;

public class LoggerTest {

        @Test
        public void LogManagerTest(){
                String p = "Prueba Unitaria para los logs";
                LogManager test1 = new LogManager();
                test1.startTest("Login Valido","descrip","category","miguel","Inicio del Caso de Prueba 'HOLA MUNDO'");
                test1.logInfo(p);
                test1.logPass(p);
                test1.logError(p);
                test1.logFatal(p);
                test1.logWarning(p);
                test1.endTest();
        }
}
