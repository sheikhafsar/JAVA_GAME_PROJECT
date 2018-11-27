package Audio;

import java.applet.Applet;
import java.applet.AudioClip;


public class Sound {
	public static final AudioClip BALL = Applet.newAudioClip(Sound.class.getResource("ball.wav"));
	public static final AudioClip GAMEOVER = Applet.newAudioClip(Sound.class.getResource("gameOver.wav"));
	public static final AudioClip BACK = Applet.newAudioClip(Sound.class.getResource("146_electro-hacked.aif"));
	public static final AudioClip KEYTONE = Applet.newAudioClip(Sound.class.getResource("WaterDrop.wav"));
}
