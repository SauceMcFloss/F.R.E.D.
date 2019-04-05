package logs;

//This is a singleton class to handle creating and managing logs
//that will be written to standard text files throughout the program.
//We also provide get methods so we can view the logs live if we need to.


import javafx.beans.property.SimpleStringProperty;


public class Logger
{
    private final String masterLogPath = "masterLog.txt";


    private static Logger logger = null;

    private Log masterLog;


    private Logger()
    {
        masterLog = new Log(masterLogPath);
    }

    public static Logger getInstance()
    {
        if(logger == null)
        {
            logger = new Logger();
        }

        return logger;
    }


    public void closeMasterLogFile()
    {
        masterLog.closeLogFile();
    }



    public void logMessage(String message)
    {
        masterLog.logMessage(message);
    }

    public void logErrorMessage(String message)
    {
        masterLog.logMessage("[Error] " + message);
    }


    public SimpleStringProperty getObservableMasterLog()
    {
        return masterLog.observableLog;
    }

    public void clearMasterLog()
    {
        masterLog.clearObservableLog();
    }







}
