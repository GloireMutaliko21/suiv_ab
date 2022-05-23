

package monprojet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;
import javax.swing.JOptionPane;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class SonAlerte {
    
    public void son(){
        
        ShortMessage m[]; int i; int N=30;
        m = new ShortMessage[N];
        
        for (i = 0; i < N; i++){
            m[i] = new ShortMessage();
        }
        
        try{
            for (i=0;i<N;i++){
                m[i].setMessage(128+16, (40+i/2)*(i%2+1), 140);
            }
        }catch(InvalidMidiDataException e){}
        
        MidiEvent eve[];
        eve = new MidiEvent[N];
        for (i=0; i<N; i++){
            eve[i] = new MidiEvent(m[i],i/ 2+1);
        }
        Track t;
        Sequencer pi = null;
        try{
            pi = MidiSystem.getSequencer();
            pi.open();
        }catch(MidiUnavailableException e)
        {System.out.println("erreur");}
        Sequence s = null;
        
        try{
            s=new Sequence(Sequence.PPQ, 1);
        }
        catch(InvalidMidiDataException e){System.out.println("Erreur1");}
        
        t=s.createTrack();
        for(i=0;i<N;i++){t.add(eve[i]);}
        
        try{
            pi.setSequence(s); pi.start();
        }
        catch(InvalidMidiDataException e){System.out.println("Erreur3");}
    }
    public void sonBienvenu(){
        try {
            
            InputStream in = new FileInputStream("test/727.wav");
            AudioStream as = new AudioStream(in);
            AudioPlayer.player.start(as);
            
        }catch(IOException e){
            JOptionPane.showMessageDialog(null, "Erreur inattendu "+e);
        }
    
}
    public void incorrect(){
        try {
            
            InputStream in = new FileInputStream("test/Incorrect.wav");
            AudioStream as = new AudioStream(in);
            AudioPlayer.player.start(as);
            
        }catch(IOException e){
            JOptionPane.showMessageDialog(null, "Erreur inattendu "+e);
        }
    
}
    
}
