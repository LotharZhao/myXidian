/**
 * 播放音乐文件
 */
package com.zhao.v;

import java.io.*;
import javax.sound.sampled.*;

public class Demo4 {
	public static void main(String[] args) {
		AePlayWave apw = new AePlayWave("E:/文档/myCode/myJava/images/111.wav");
		apw.start();
		System.out.println("正在播放音乐...");
	}
}

// 播放声音的类
class AePlayWave extends Thread {
	private String filename;

	public AePlayWave(String wavfile) {
		filename = wavfile;
	}

	public void run() {
		File soundFile = new File(filename);

		AudioInputStream audioInputStream = null;
		try {
			audioInputStream = AudioSystem.getAudioInputStream(soundFile);
		} catch (Exception e1) {
			e1.printStackTrace();
			return;
		}

		AudioFormat format = audioInputStream.getFormat();
		SourceDataLine auline = null;
		DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);

		try {
			auline = (SourceDataLine) AudioSystem.getLine(info);
			auline.open(format);
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}

		auline.start();
		int nBytesRead = 0;
		byte[] abData = new byte[512];

		try {
			while (nBytesRead != -1) {
				nBytesRead = audioInputStream.read(abData, 0, abData.length);
				if (nBytesRead >= 0)
					auline.write(abData, 0, nBytesRead);
			}
		} catch (IOException e) {
			e.printStackTrace();
			return;
		} finally {
			auline.drain();
			auline.close();
		}
	}
}