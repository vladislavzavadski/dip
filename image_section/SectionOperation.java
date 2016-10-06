
import java.io.IOException;
import java.io.File;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.awt.Color;
import java.util.Random;

public class SectionOperation{

	public static void sectionImage(BufferedImage image, int sectionFreqгency)throws IOException{

		BufferedImage bufferedImage = new BufferedImage(image.getWidth(), image.getHeight(), image.getType());

		int[] array = getArray(sectionFreqгency);

		for (int i=0; i<image.getHeight(); i++) {
			
			for (int j=0; j<image.getWidth(); j++) {
				
				Color color = new Color(image.getRGB(j, i));

				int red = array[color.getRed()];
				int green = array[color.getGreen()];
				int blue = array[color.getBlue()];

				Color result = new Color(red, green, blue);

				bufferedImage.setRGB(j, i, result.getRGB());
			}
		}

		ImageIO.write(bufferedImage, "jpg", new File("result.jpg"));
	}

	public static int[] getArray(int sectionFreqгency){
		int levels = 256;
		int[] array = new int[256];
		int x=0;

		for (int i=0; i<255; i++) {
			array[i] = x;	
			x+=sectionFreqгency;
			x %= levels;
		}

		return array;
	}

	public static void main(String[] args) throws IOException {

		int sectionFreqгency = Integer.parseInt(args[0]);
		
		File file = new File("image.jpg");

		BufferedImage bufferedImage = ImageIO.read(file);

		sectionImage(bufferedImage, sectionFreqгency);

	}
}