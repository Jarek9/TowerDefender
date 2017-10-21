package DANE;

import org.lwjgl.opengl.Display;
import HELPERS.Clock;
import HELPERS.StateManager;
import static HELPERS.Artist.*;

public class Boot {
	
	public Boot() {
		
		
		//Wywo³anie metody statycznej w klasie Artists i zainincjowanie bibliotek OpenGL.
		BeginSession();
		
		//G³ówna pêtla programu
		while(!Display.isCloseRequested()) {
			Clock.update();			
			StateManager.update();
			Display.update();
			Display.sync(100);
			
		}
		
		Display.destroy();
	}
	
	public static void main(String[] args) {
		new Boot();
	}

}

