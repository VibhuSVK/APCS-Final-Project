import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.InputStream;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;


public class MusicTest {

private Clip c;
  	
	
 
public MusicTest()
	{
	
    //This gets the path to the project, but not into /src for eclipse
    String path = new File("").getAbsolutePath() + "\\AmbientSong.wav";
    //Make a File object with a path to the audio file.
    File sound = new File(path);
    
    try {
	        AudioInputStream ais = AudioSystem.getAudioInputStream(sound);
	        c = AudioSystem.getClip();
	        c.open(ais); //Clip opens AudioInputStream
	        //Thread.sleep((int)(c.getMicrosecondLength() * 0.001));
	        }
	        
	     catch (Exception e) {
	        System.out.println(e.getMessage());
	    }
	}
	
public void playMusic()
{
	c.start();
	c.loop(Clip.LOOP_CONTINUOUSLY);
}
public void pauseMusic()
{
	
	c.stop();
	
}
public void restartMusic()
{
	
	c.setMicrosecondPosition(0);
	
}
}

