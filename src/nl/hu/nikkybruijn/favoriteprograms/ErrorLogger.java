package nl.hu.nikkybruijn.favoriteprograms;

import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openide.DialogDisplayer;
import org.openide.NotifyDescriptor;

/**
 *
 * @author Nikky
 */
public class ErrorLogger {
  Handler ch = new ConsoleHandler();
  private static final Logger LOGGER = Logger.getLogger(ErrorLogger.class.getName());
  
    public void LogError(String programName, String executableName, String path) {
                LOGGER.getLogger("").addHandler(ch);
                LOGGER.log(Level.SEVERE, "Could not find " + executableName + " in " + path);
                String error = "ERROR: " + programName + " executable could not be found. \nDo you have " + programName + " installed?";
                int msgType = NotifyDescriptor.ERROR_MESSAGE;
                NotifyDescriptor d = new NotifyDescriptor.Message(error, msgType);
                DialogDisplayer.getDefault().notify(d);
    }
}
