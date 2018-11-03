package com.edu.cn.ts;

/*
 * 背景音乐类
 */
import javax.sound.sampled.*;
import java.io.*;

public class BgMusic {

	private AudioFormat format;
	private byte[] samples;

	public BgMusic(String filename) {
		try {
//           打开音频输入流
//			从文件对象构建AudioInputStream   stream,这个stream对象包含文件的格式数据和音频数据
			AudioInputStream stream = AudioSystem.getAudioInputStream(new File(filename));
			format = stream.getFormat();
//            获得音频样本
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
		// 获取要读取的字节数
		int length = (int) (audioStream.getFrameLength() * format.getFrameSize());
		// 阅读整个流
		byte[] samples = new byte[length];
		DataInputStream is = new DataInputStream(audioStream);
		try {
			is.readFully(samples);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		// 返回样品
		return samples;
	}

	public void play(InputStream source) {
// 使用一个短的100ms(1/10秒)的缓冲区进行实时处理
// 切换到音频流
		int bufferSize = format.getFrameSize() * Math.round(format.getSampleRate() / 10);
		byte[] buffer = new byte[bufferSize];
//      create a line to play to(创建播放线)
//		SourceDataLine意思是"源数据流",是指AudioSystem的输入流,把音频文件写入到AudioSystem中,AudioSystem就会播放音频文件.
//		TargetDataLine意思是"目标数据流",是指AudioSystem的输出流,是AudioSystem的target.
		SourceDataLine line;
		try {
			DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);
			line = (SourceDataLine) AudioSystem.getLine(info);
//     打开管道入口端
			line.open(format, bufferSize);

		} catch (LineUnavailableException ex) {
			ex.printStackTrace();
			return;
		}
		// 启动线 line.start()打开管道的出口端
		line.start();
		// 将数据复制到线中
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
//     等待所有数据播放，然后关闭线
//		line.drain()将管道的出口端导入另一个地方将管道中剩余的数据流放空
		line.drain();
//		line.close()关住了管道的出口端.
		line.close();
	}
}
