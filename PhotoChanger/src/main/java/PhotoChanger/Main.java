package PhotoChanger;

import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Main {
    public static void main(String [] args) throws IOException {
            System.out.println("Wybierz opcję, jak zmienić zdjęcie: ");
            System.out.println("1 - czarno-białe ");
            System.out.println("2 - sepia");
            System.out.println("3 - negatyw");
            System.out.println("4 - w odcieniach czerwonego");
            System.out.println("5 - w odcieniach zielonego");
            System.out.println("6 - w odcieniach niebieskiego");
            System.out.println("7 - zwiększenie kontrastu");
            
            Scanner scan = new Scanner(System.in);
            int option = scan.nextInt();
            
            BufferedImage img = null;
            img = ImageIO.read(new File("C:/Users/astgh/OneDrive/Desktop/photo.jpg"));
            
            int imgWidth = img.getWidth();
            int imgHeight = img.getHeight();
            
            Operations opt = new Operations();
            
             switch(option){
                    case 1:
                        opt.greyScale(img, imgWidth, imgHeight);
                        break;
                    case 2:
                     opt.sepia(img, imgWidth, imgHeight);
                     break;
                    case 3:
                        opt.negative(img, imgWidth, imgHeight);
                         break;
                    case 4:
                        opt.toRed(img, imgWidth, imgHeight);
                         break;
                    case 5:
                        opt.toBlue(img, imgWidth, imgHeight);
                         break;
                    case 6:
                        opt.contrast(img, imgWidth, imgHeight);
                         break;

                    }
       }

    
}