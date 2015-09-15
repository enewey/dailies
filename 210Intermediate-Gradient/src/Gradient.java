import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Gradient {

	public static void main(String[] args) 
	{
		if (args.length != 8) return;
		
		int width = Integer.parseInt(args[0]);	//Begin parsing arguments
		int height = Integer.parseInt(args[1]);
		
		int colorAr = Integer.parseInt(args[2]);
		int colorAg = Integer.parseInt(args[3]);
		int colorAb = Integer.parseInt(args[4]);
		
		int colorBr = Integer.parseInt(args[5]);
		int colorBg = Integer.parseInt(args[6]);
		int colorBb = Integer.parseInt(args[7]); //End parsing
		
		double rDiff = (double)(colorBr - colorAr) / width;
		double gDiff = (double)(colorBg - colorAg) / width;
		double bDiff = (double)(colorBb - colorAb) / width;
		
		double rCumulative, bCumulative, gCumulative;
		rCumulative = bCumulative = gCumulative = 0.0;
		
		int startColor = (colorAr<<16) | (colorAg<<8) | colorAb;
		
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		
		int rgbColor = startColor;
		for (int i=0; i<width; i++)
		{
			for (int j=0; j<height; j++)
				image.setRGB(i, j, rgbColor);

			//Mask and differentiate colors
			int r = (startColor & 0xFF0000)>>16;
			int g = (startColor & 0x00FF00)>>8;
			int b = startColor & 0x0000FF;
			
			r += (int)(rCumulative += rDiff);
			g += (int)(gCumulative += gDiff);
			b += (int)(bCumulative += bDiff);
			
			rgbColor = (r<<16)|(g<<8)|b;
		}
		//Write image to file
		try { ImageIO.write(image, "png", new File("gradient.png")); } catch (IOException e) {}
	}

}
