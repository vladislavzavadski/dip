
import java.io.IOException;
import java.io.File;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.awt.Color;

public class ArithmeticOperation{

	public static void sumImages(BufferedImage image, BufferedImage image1, float A) throws IOException{

		BufferedImage bufferedImage = new BufferedImage(image.getWidth(), image.getHeight(), image.getType());

		for(int i=0; i<image.getHeight(); i++){
			for (int j=0; j<image.getWidth(); j++) {
				
				Color color = new Color(image.getRGB(j, i));

				Color color1 = new Color(image1.getRGB(j, i));

				int red = (int)(color.getRed()*A + color1.getRed()*(1-A));
				int green = (int)(color.getGreen()*A + color1.getRed()*(1-A));
				int blue = (int)(color.getBlue()*A + color1.getBlue()*(1-A));

				Color result = new Color(red, green, blue);

				bufferedImage.setRGB(j, i, result.getRGB());
			}
		}

		
		ImageIO.write(bufferedImage, "jpg", new File("add_result.jpg"));
	} 

	public static void subImages(BufferedImage image, BufferedImage image1, float A) throws IOException{
		
		BufferedImage bufferedImage = new BufferedImage(image.getWidth(), image.getHeight(), image.getType());

		for(int i=0; i<image.getHeight(); i++){
			for (int j=0; j<image.getWidth(); j++) {
				
				Color color = new Color(image.getRGB(j, i));

				Color color1 = new Color(image1.getRGB(j, i));

				int red = (int)(color.getRed()*A - color1.getRed()*(1-A));

				red = (red < 0)?0:red;

				int green = (int)(color.getGreen()*A - color1.getRed()*(1-A));

				green = (green < 0)?0:green;

				int blue = (int)(color.getBlue()*A - color1.getBlue()*(1-A));

				blue = (blue < 0)?0:blue;

				Color result = new Color(red, green, blue);

				bufferedImage.setRGB(j, i, result.getRGB());
			}
		}

		
		ImageIO.write(bufferedImage, "jpg", new File("sub_result.jpg"));
	}

	public static void main(String[] args) throws IOException {

		float A = Float.parseFloat(args[0]);
		
		File file = new File("simpsons.jpg");
		File file2 = new File("logo.jpg");

		BufferedImage image = ImageIO.read(file);

		BufferedImage image1 = ImageIO.read(file2);

		sumImages(image, image1, A);

		subImages(image, image1, A);

	}
}