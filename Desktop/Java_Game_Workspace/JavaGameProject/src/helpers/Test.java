package helpers;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;

import static org.lwjgl.opengl.GL11.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Test {

	public static Texture texture;
	
	public static void main(String[] args) {
		try {
			Display.setDisplayMode(new DisplayMode(900, 600));
			Display.setTitle("OpenGL");
			Display.create();
		
		try {
			texture = TextureLoader.getTexture("PNG", new FileInputStream(new File("res/textures/test.png")));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				Display.destroy();
				System.exit(1);
				} catch (IOException e) {
				e.printStackTrace();
				Display.destroy();
				System.exit(1);
			}
		
		while (!Display.isCloseRequested()) {
			Display.update();
			Display.sync(60);
			glMatrixMode(GL_PROJECTION);
			glLoadIdentity();
			glOrtho(0, 640, 480, 0, 1, -1);
			glMatrixMode(GL_MODELVIEW);
			
			glBegin(GL_TRIANGLES);
			glTexCoord2f(0, 64);
			glBindTexture(GL_TEXTURE_2D, 0);
			glEnable(GL_TEXTURE_2D);
			texture.getTextureID();
			
			glTexCoord2f(1, 0);
			glVertex2i(450, 10);
			glTexCoord2f(0, 0);
			glVertex2i(10, 10);
			glTexCoord2f(0, 1);
			glVertex2i(10, 450);
			
			glTexCoord2f(0, 1);
			glVertex2i(10, 450);
			glTexCoord2f(1, 1);
			glVertex2i(450, 450);
			glTexCoord2f(1, 0);
			glVertex2i(450, 10);
			
			glEnd();
			
			}
			texture.release();
			glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
			Display.destroy();
			System.out.println("The game has been destroyed");
			System.exit(0);
		
		} catch (LWJGLException e) {
			e.printStackTrace();
			Display.destroy();
			System.exit(1);
		}
		}
	}