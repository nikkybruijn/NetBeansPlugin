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
        id = "nl.hu.nikkybruijn.favoriteprograms.SpotifyOpener"
)
@ActionRegistration(
        iconBase = "nl/hu/nikkybruijn/favoriteprograms/spotify.png",
        displayName = "#CTL_SpotifyOpener"
)
@ActionReference(path = "Toolbars/Build", position = 500)
@Messages("CTL_SpotifyOpener=Open Spotify")
public final class SpotifyOpener implements ActionListener {
    ErrorLogger logger = new ErrorLogger();
    
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            Runtime.getRuntime().exec("cmd.exe /C start %appdata%\\Spotify\\Spotify2.exe");
        } catch (IOException ex) {
            logger.LogError("Spotify", "Spotify.exe", "AppData/Roaming/Spotify");
        }
    }
}
