import java.awt.*;
import java.util.*;
import java.applet.*;
public class TriangleFractals extends Applet{
	private static final int Pixel_Limit = 4;
	private Image display;
	private Graphics drawingArea;
	public void init(){
		int height = getSize().height;
		int width = getSize().width;
		
		display = createImage(width, height);
		drawingArea = display.getGraphics();
		
		drawFirstTwo(100,0,0,200,200,200,drawingArea);
	}
	public void paint(Graphics g){
		g.drawImage(display, 0, 0, null);
	}
	public void drawFirstTwo(int x1, int y1, int x2, int y2, int x3, int y3,Graphics g){
		int px[] = {x1,x2,x3};
		int py[] = {y1,y2,y3};
		g.fillPolygon(px, py, 3);
		
		g.setColor(Color.GRAY);
		drawTriangle(
				(x1 + x2) / 2,(y1 + y2) / 2,(x1 + x3) / 2,
				(y1 + y3) / 2,(x2 + x3) / 2,(y2 + y3) / 2,1,g);
	}
	public static void drawTriangle(int x1, int y1,int x2,int y2,int x3, int y3, int level, Graphics g){
		int px[] = {x1,x2,x3};
		int py[] = {y1,y2,y3};
		g.fillPolygon(px, py, 3);
		if(level <= Pixel_Limit){ // Sets the limit of levels/pixels
			drawTriangle( // This draws the left corner triangle
					(x1 + x2) / 2 + (x2 - x3) / 2,
					(y1 + y2) / 2 + (y2 - y3) / 2,
					(x1 + x2) / 2 + (x1 - x3) / 2, 
					(y1 + y2) / 2 + (y1 - y3) / 2,
					(x1 + x2) / 2, (y1 + y2) / 2,
					level + 1,g);
			drawTriangle( // This draws the right corner triangle
					(x1 + x3) / 2 + (x3 - x2) / 2,
					(y1 + y3) / 2 + (y3 - y2) / 2,
					(x1 + x3) / 2 + (x1 - x2) / 2,
					(y1 + y3) / 2 + (y1 - y2) / 2,
					(x1 + x3) / 2,(y1 + y3)/ 2,
					level + 1, g);
			drawTriangle( // This draws the top triangle
					(x3 + x2) / 2 + (x2 -x1) / 2,
					(y3 + y2) / 2 + (y2 - y1) / 2,
					(x3 + x2) / 2 + (x3 - x1) / 2, 
					(y3 + y2) / 2 + (y3 - y1) / 2,
					(x3 + x2) / 2, (y3 + y2) / 2,
					level + 1,g);
		}
	}
}
