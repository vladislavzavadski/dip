
import java.io.IOException;
import java.io.File;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.awt.Color;
import java.util.Random;

public class LogicalOperation{

	public static void andOperation(BufferedImage image, BufferedImage image1)throws IOException{

		int height = image.getHeight()<image1.getHeight()?image.getHeight():image1.getHeight();
		int width = image.getWidth()<image1.getWidth()?image.getWidth():image1.getWidth();

		BufferedImage bufferedImage = new BufferedImage(width, height, image.getType());

		for(int i=0; i<height; i++){
			for (int j=0; j<width; j++) {

				Color color = new Color(image.getRGB(j, i));
				Color color1 = new Color(image1.getRGB(j, i));

				int red = color.getRed() & color1.getRed();
				int green = color.getGreen() & color1.getGreen();
				int blue = color.getBlue() & color1.getBlue();

				Color result = new Color(red, green, blue);

				bufferedImage.setRGB(j, i, result.getRGB());
			}
		}

		ImageIO.write(bufferedImage, "png", new File("and_image.jpg"));

	}


	public static void orOperation(BufferedImage image, BufferedImage image1)throws IOException{

		int height = image.getHeight()<image1.getHeight()?image.getHeight():image1.getHeight();
		int width = image.getWidth()<image1.getWidth()?image.getWidth():image1.getWidth();

		BufferedImage bufferedImage = new BufferedImage(width, height, image.getType());

		for(int i=0; i<height; i++){
			for (int j=0; j<width; j++) {

				Color color = new Color(image.getRGB(j, i));
				Color color1 = new Color(image1.getRGB(j, i));

				int red = color.getRed() | color1.getRed();
				int green = color.getGreen() | color1.getGreen();
				int blue = color.getBlue() | color1.getBlue();

				Color result = new Color(red, green, blue);

				bufferedImage.setRGB(j, i, result.getRGB());
			}
		}

		ImageIO.write(bufferedImage, "png", new File("or_image.jpg"));

	}

	public static void xorOperation(BufferedImage image, BufferedImage image1)throws IOException{

		int height = image.getHeight()<image1.getHeight()?image.getHeight():image1.getHeight();
		int width = image.getWidth()<image1.getWidth()?image.getWidth():image1.getWidth();

		BufferedImage bufferedImage = new BufferedImage(width, height, image.getType());

		for(int i=0; i<height; i++){
			for (int j=0; j<width; j++) {

				Color color = new Color(image.getRGB(j, i));
				Color color1 = new Color(image1.getRGB(j, i));

				int red = color.getRed() ^ color1.getRed();
				int green = color.getGreen() ^ color1.getGreen();
				int blue = color.getBlue() ^ color1.getBlue();

				Color result = new Color(red, green, blue);

				bufferedImage.setRGB(j, i, result.getRGB());
			}
		}

		ImageIO.write(bufferedImage, "png", new File("xor_image.jpg"));

	}

	public static void notOperation(BufferedImage image)throws IOException{

		BufferedImage bufferedImage = new BufferedImage(image.getWidth(), image.getHeight(), image.getType());

		for(int i=0; i<image.getHeight(); i++){
			for (int j=0; j<image.getWidth(); j++) {

				Color color = new Color(image.getRGB(j, i));

				int red = 255-color.getRed();
				int green = 255-color.getGreen();
				int blue = 255-color.getBlue() ;

				Color result = new Color(red, green, blue);

				bufferedImage.setRGB(j, i, result.getRGB());
			}
		}

		ImageIO.write(bufferedImage, "png", new File("not_image.jpg"));

	}



	public static void main(String[] args) throws IOException {
		
		File file = new File("1.jpg");
		File file2 = new File("2.jpg");

		BufferedImage bufferedImage = ImageIO.read(file);
		BufferedImage bufferedImage1 = ImageIO.read(file2);

		andOperation(bufferedImage, bufferedImage1);
		orOperation(bufferedImage, bufferedImage1);
		xorOperation(bufferedImage, bufferedImage1);
		notOperation(bufferedImage);

	}
}