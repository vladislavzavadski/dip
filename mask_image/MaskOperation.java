
import java.io.IOException;
import java.io.File;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.awt.Color;
import java.util.Random;

public class MaskOperation{

	public static void maskImage(BufferedImage image) throws IOException{

		BufferedImage bufferedImage = new BufferedImage(image.getWidth(), image.getHeight(), image.getType());

		int[][] matrix = getRandomMatrix(image.getHeight(), image.getWidth());

		for (int i=0; i<image.getHeight(); i++) {
			for (int j=0; j<image.getWidth(); j++) {
				
				if(matrix[i][j]==0){
					bufferedImage.setRGB(j, i, image.getRGB(j, i) & 0xff000000);
				}

				else{
					bufferedImage.setRGB(j, i, image.getRGB(j, i));
				}
			}
		}

		ImageIO.write(bufferedImage, "jpg", new File("mask_image.jpg"));

	}

	public static int[][] getRandomMatrix(int height, int width){
		int[][] matrix = new int[height][width];

		Random random = new Random();

		for(int i=0; i<height; i++){
			for(int j=0; j<width; j++){
				matrix[i][j] = random.nextInt(2);
			}
		}

		return matrix;
	}

	public static void main(String[] args) throws IOException {

		//int constant = Integer.parseInt(args[0]);
		
		File file = new File("image.jpg");

		BufferedImage bufferedImage = ImageIO.read(file);

		maskImage(bufferedImage);
	}
}