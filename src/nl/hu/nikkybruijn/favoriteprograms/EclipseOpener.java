package nl.hu.nikkybruijn.favoriteprograms;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionRegistration;
import org.openide.util.NbBundle.Messages;

@ActionID(
        category = "Build",
        id = "nl.hu.nikkybruijn.favoriteprograms.EclipseOpener"
)
@ActionRegistration(
        iconBase = "nl/hu/nikkybruijn/favoriteprograms/eclipse.png",
        displayName = "#CTL_EclipseOpener"
)
@ActionReference(path = "Toolbars/Build", position = 450)
@Messages("CTL_EclipseOpener=Open Eclipse")
public final class EclipseOpener implements ActionListener {
    ErrorLogger logger = new ErrorLogger();
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(new File("C:\\Program Files\\Eclipse\\eclipse.exe").exists()) {
            try {
                Runtime.getRuntime().exec("cmd.exe /C start \"\" \"%ProgramFiles%\\Eclipse\\eclipse.exe\"");
            } catch (IOException ex) {
                    logger.LogError("Eclipse", "eclipse.exe", "Program Files/eclipse/");}
        } else {
            logger.LogError("Eclipse", "eclipse.exe", "Program Files/eclipse/");
        }
    }
}
