package com.wqf.tank;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

/**
 * @author 小白学java
 * @version 1.0
 */
//播放音乐的类,以后完善
public class AePlayWave extends Thread {
    private String fileName;

    public AePlayWave(String waveFile) {
        fileName = waveFile;
    }

    public void run() {
        File soundFile = new File(fileName);
        AudioInputStream audioInputStream = null;
        try {
            audioInputStream = AudioSystem.getAudioInputStream(soundFile);
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        AudioFormat format = audioInputStream.getFormat();
        SourceDataLine sourceDataLine = null;
        DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);
        try {
            sourceDataLine = (SourceDataLine) AudioSystem.getLine(info);
            sourceDataLine.open(format);
        } catch (LineUnavailableException e) {
            e.printStackTrace();
            return;
        }
    }
}
