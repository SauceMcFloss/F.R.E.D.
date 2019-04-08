package logs;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class LogTest {

    Log log = new Log("Path");

    @Test
    public void writeMessageToFile(String message)
    {
        assertNotNull(log);

        assertNotNull(message);
    }

    @Test
    public void closeLogFile()
    {
        assertNotNull(log);
    }

    @Test
    public void logMessage()
    {
        assertNotNull(log);
    }

    @Test
    public void clearObservableLog()
    {
        assertNotNull(log);
    }

    @Test
    public void getLogMessage()
    {
        assertNotNull(log);

        ArrayList<String> list = log.getAllLogMessages();

        for(int i=0; i<list.size(); i++)
        {
            assertNotNull(list.get(i));
        }
    }

    @Test
    public void getAllLogMessages()
    {
        assertNotNull(log);

        ArrayList<String> list = log.getAllLogMessages();

        assertNotNull(list);
    }
}