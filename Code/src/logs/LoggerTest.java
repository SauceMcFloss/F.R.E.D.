package logs;

import javafx.beans.property.SimpleStringProperty;
import org.junit.Test;

import static org.junit.Assert.*;

public class LoggerTest {

    @Test
    public void getInstance()
    {
        assertNotNull(Logger.getInstance());
    }



    @Test
    public void logMessage(String message)
    {
        assertNotNull(message);
    }

    @Test
    public void logErrorMessage(String message)
    {
        assertNotNull(message);
    }

    @Test
    public void getObservableMasterLog()
    {
        SimpleStringProperty prop = Logger.getInstance().getObservableMasterLog();

        assertNotNull(prop);

    }

    @Test
    public void clearMasterLog()
    {
        SimpleStringProperty prop = Logger.getInstance().getObservableMasterLog();

        assertNotNull(prop);

        assertTrue(prop.isEmpty().get());

    }
}