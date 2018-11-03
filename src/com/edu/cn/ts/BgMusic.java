package com.edu.cn.ts;

/*
 * ����������
 */
import javax.sound.sampled.*;
import java.io.*;

public class BgMusic {

	private AudioFormat format;
	private byte[] samples;

	public BgMusic(String filename) {
		try {
//           ����Ƶ������
//			���ļ����󹹽�AudioInputStream   stream,���stream��������ļ��ĸ�ʽ���ݺ���Ƶ����
			AudioInputStream stream = AudioSystem.getAudioInputStream(new File(filename));
			format = stream.getFormat();
//            �����Ƶ����
			samples = getSamples(stream);
		} catch (UnsupportedAudioFileException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public byte[] getSamples() {
		return samples;
	}

	private byte[] getSamples(AudioInputStream audioStream) {
		// ��ȡҪ��ȡ���ֽ���
		int length = (int) (audioStream.getFrameLength() * format.getFrameSize());
		// �Ķ�������
		byte[] samples = new byte[length];
		DataInputStream is = new DataInputStream(audioStream);
		try {
			is.readFully(samples);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		// ������Ʒ
		return samples;
	}

	public void play(InputStream source) {
// ʹ��һ���̵�100ms(1/10��)�Ļ���������ʵʱ����
// �л�����Ƶ��
		int bufferSize = format.getFrameSize() * Math.round(format.getSampleRate() / 10);
		byte[] buffer = new byte[bufferSize];
//      create a line to play to(����������)
//		SourceDataLine��˼��"Դ������",��ָAudioSystem��������,����Ƶ�ļ�д�뵽AudioSystem��,AudioSystem�ͻᲥ����Ƶ�ļ�.
//		TargetDataLine��˼��"Ŀ��������",��ָAudioSystem�������,��AudioSystem��target.
		SourceDataLine line;
		try {
			DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);
			line = (SourceDataLine) AudioSystem.getLine(info);
//     �򿪹ܵ���ڶ�
			line.open(format, bufferSize);

		} catch (LineUnavailableException ex) {
			ex.printStackTrace();
			return;
		}
		// ������ line.start()�򿪹ܵ��ĳ��ڶ�
		line.start();
		// �����ݸ��Ƶ�����
		try {
			int numBytesRead = 0;
			while (numBytesRead != -1) {
				numBytesRead = source.read(buffer, 0, buffer.length);
				if (numBytesRead != -1) {
					line.write(buffer, 0, numBytesRead);
				}
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
//     �ȴ��������ݲ��ţ�Ȼ��ر���
//		line.drain()���ܵ��ĳ��ڶ˵�����һ���ط����ܵ���ʣ����������ſ�
		line.drain();
//		line.close()��ס�˹ܵ��ĳ��ڶ�.
		line.close();
	}
}
