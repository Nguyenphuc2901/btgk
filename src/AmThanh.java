import javax.sound.sampled.*;
import java.io.File;

public class AmThanh {
    private static Clip nhacNen;

    public static void batNhacNen() {
        try {
            if(nhacNen != null && nhacNen.isOpen()) {
                nhacNen.stop();
                nhacNen.close();
            }

            AudioInputStream audio =
                AudioSystem.getAudioInputStream(new File("sound/nen.wav"));

            nhacNen = AudioSystem.getClip();
            nhacNen.open(audio);
            nhacNen.loop(Clip.LOOP_CONTINUOUSLY);
        }
        catch(Exception e) {
            System.out.println("Khong the phat nhac nen!");
        }
    }

    public static void tatNhacNen() {
        if(nhacNen != null) {
            nhacNen.stop();
            nhacNen.close();
            nhacNen = null;
        }
    }
}
