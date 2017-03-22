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
        id = "nl.hu.nikkybruijn.favoriteprograms.Foobar2kOpener"
)
@ActionRegistration(
        iconBase = "nl/hu/nikkybruijn/favoriteprograms/foobar.png",
        displayName = "#CTL_Foobar2kOpener"
)
@ActionReference(path = "Toolbars/Build", position = 500)
@Messages("CTL_Foobar2kOpener=Open Foobar2000")
public final class Foobar2kOpener implements ActionListener {
    ErrorLogger logger = new ErrorLogger();
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(new File("C:\\Program Files (x86)\\foobar2000\\foobar2000.exe").exists()) {
            try {
                Runtime.getRuntime().exec("cmd.exe /C start \"\" \"%ProgramFiles(x86)%\\foobar2000\\foobar2000.exe\"");
            } catch (IOException ex) {
                    logger.LogError("Eclipse", "eclipse.exe", "Program Files/eclipse/");}
        } else {
            logger.LogError("Foobar2000", "foobar2000.exe", "Program Files (x86)/foobar2000/");
        }
    }
}
