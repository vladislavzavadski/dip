
import java.io.IOException;
import java.io.File;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.awt.Color;

public class BrightOperation{

	public static void addConstant(BufferedImage image, int constant) throws IOException{

		BufferedImage bufferedImage = new BufferedImage(image.getWidth(), image.getHeight(), image.getType());

		for(int i=0; i<image.getHeight(); i++){
			for (int j=0; j<image.getWidth(); j++) {
				
				Color color = new Color(image.getRGB(j, i));

				int red = color.getRed()+constant;

				red = (red<0)?0:red;
				red = (red>255)?255:red;

				int green = color.getGreen()+constant;

				green = (green<0)?0:green;
				green = (green>255)?255:green;

				int blue = color.getBlue()+constant;

				blue = (blue<0)?0:blue;
				blue = (blue>255)?255:blue;

				Color result = new Color(red, green, blue);

				bufferedImage.setRGB(j, i, result.getRGB());

			}
		}

		ImageIO.write(bufferedImage, "jpg", new File("result_add.jpg"));
	}

	public static void main(String[] args) throws IOException {

		int constant = Integer.parseInt(args[0]);
		
		File file = new File("image.jpg");

		BufferedImage bufferedImage = ImageIO.read(file);

		addConstant(bufferedImage, constant);

	}
}