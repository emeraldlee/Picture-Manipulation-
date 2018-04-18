import java.awt.Color;

public class Project3 
{
	public static void main(String[] args) 
	{
		ImageUtils img = new ImageUtils();
		Color[][] orig = img.loadImage("src/LennaCV.png");
		
		//Process image
		Color[][] grey = greyScale(orig);
		Color[][] invert = invert(orig);
		Color[][] random = random(orig);
		
		//Add images
		img.addImage(orig, "Original Image");
		img.addImage(grey, "Grey Scale");
		img.addImage(invert, "Inverted");
		img.addImage(random, "Random Colors");
		
		img.display();
	}
	
	public static Color[][]greyScale(Color[][] image)
	{
		Color[][] temp = ImageUtils.cloneArray(image);
		for(int i = 0;i<temp.length;i++)
		{
			for(int j=0; j<temp[i].length;j++)
			{
				Color pixel = temp[i][j];
				int r = pixel.getRed();
				int g = pixel.getGreen();
				int b = pixel.getBlue();
				
				int avg = (r+b+g)/3;
				temp[i][j] = new Color(avg,avg,avg);
			}
		}
		return temp;
	}
	
	public static Color[][]invert(Color[][] image)
	{
		Color[][] temp = ImageUtils.cloneArray(image);
		for(int i = 0;i<temp.length;i++)
		{
			for(int j=0; j<temp[i].length;j++)
			{
				Color pixel = temp[i][j];
				int r = pixel.getRed();
				int g = pixel.getGreen();
				int b = pixel.getBlue();
				
				temp[i][j] = new Color(255-r,255-g,255-b);
			}
		}
		return temp;
	}
	
	public static Color[][] blackRim(Color[][] image)
	{
		Color[][] temp = ImageUtils.cloneArray(image);
		for(int i = 0;i<temp.length;i++)
		{
			for(int j=0; j<temp[i].length;j++)
			{
				Color pixel = temp[i][j];
				int r = pixel.getRed();
				int g = pixel.getGreen();
				int b = pixel.getBlue();
				
			    if(i<temp.length/10 || j<temp[i].length/10 || i<(temp.length-10)/10)
			    {
			        temp[i][j] = new Color((int)(r*.5),(int)(g*.5),(int)(b*.5));
			    }
			}
		}
		return temp;
	}
	
	public static Color[][]random(Color[][] image)
	{
		Color[][] temp = ImageUtils.cloneArray(image);
		for(int i = 0;i<temp.length;i+=2)
		{
			for(int j=0; j<temp[i].length;j++)
			{
				Color pixel = temp[i][j];
				int r = (int)(Math.random()*255);
				int g = (int)(Math.random()*255);
				int b = (int)(Math.random()*255);
				
				temp[i][j] = new Color(r,g,b);
			}
		}
		return temp;
	}
}
