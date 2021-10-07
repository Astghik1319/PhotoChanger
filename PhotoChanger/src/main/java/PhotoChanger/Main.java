package PhotoChanger;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.util.Random;


public class Main {
    public static void main(String [] args) throws IOException {

        
        
          BufferedImage img = null;
            img = ImageIO.read(new File("C:/Users/astgh/OneDrive/Desktop/photo.jpg"));
            
            int imgWidth = img.getWidth();
            int imgHeight = img.getHeight();
            
            
            int opti = optionChooser();
          
        
            Random random = new Random();
           if(opti==9){
                 int partH = imgSliceHorizontal();
                 int partW = imgSliceWertical();
                 
                for(int i=0; i<partW; i++){
                    for(int j=0; j<partH; j++){

                        int a = (imgWidth/partH)*j;
                        int b = (imgHeight/partW)*i;
                        int c = (imgWidth/partH)*(j+1);
                        int d = (imgHeight/partW)*(i+1);
                        int x = random.nextInt(7);
                        
                        changerImg(img, a, b, c, d, x);

                    }
              } 
               
                
                 JFrame frame = new JFrame();
       frame.getContentPane().add(new JLabel(new ImageIcon(img)));
          frame.pack();
           frame.setVisible(true); 
            } else {
                changerImg(img, 0, 0, imgWidth, imgHeight, opti);
                
                
                JFrame frame = new JFrame();
       frame.getContentPane().add(new JLabel(new ImageIcon(img)));
          frame.pack();
           frame.setVisible(true); 
            }
          
         

    }
    
    public static int imgSliceHorizontal() {
        System.out.println("Na ile części podzielić zdjęcie w poziomie? ");
        
         Scanner scan = new Scanner(System.in);
        int partHor = scan.nextInt();
        
        return partHor;
        
    }
    
        public static int imgSliceWertical() {
        System.out.println("Na ile części podzielić zdjęcie w pionie? ");
        
         Scanner scan = new Scanner(System.in);
        int partWer = scan.nextInt();
        
        return partWer;
        
    }
    
    
    
    public static int optionChooser() {
        System.out.println("Wybierz opcję:");
            System.out.println("1 - Zmień całe zdjęcie według wybranej opcji");
            System.out.println("2 - Zmień losowo");
            
            Scanner scan = new Scanner(System.in);
            int choose = scan.nextInt();
            int option;
            
        if(choose==1){
            
        
            System.out.println("Wybierz opcję, jak zmienić zdjęcie: ");
            System.out.println("1 - czarno-białe ");
            System.out.println("2 - sepia");
            System.out.println("3 - negatyw");
            System.out.println("4 - w odcieniach czerwonego");
            System.out.println("5 - w odcieniach zielonego");
            System.out.println("6 - w odcieniach niebieskiego");
            System.out.println("7 - zwiększenie kontrastu");
            

            int opti = scan.nextInt();
            return opti;

        }
             else{

              int opti=9;
             return opti;
                
        }
        
 
    }
    
    
    public static void changerImg(BufferedImage img, int startXx, int startYy, int endXx, int endYy, int option) throws IOException{
        Operations opt = new Operations();
        switch(option){
                    case 1:
                        opt.greyScale(img, startXx, startYy, endXx, endYy);
                        break;
                    case 2:
                     opt.sepia(img, startXx, startYy, endXx, endYy);
                     break;
                    case 3:
                        opt.negative(img,startXx,startYy, endXx, endYy);
                         break;
                    case 4:
                        opt.toRed(img,startXx,startYy, endXx, endYy);
                         break;
                    case 5:
                        opt.toGreen(img,startXx,startYy, endXx, endYy);
                         break;
                          case 6:
                        opt.toBlue(img,startXx,startYy, endXx, endYy);
                         break;
                    case 7:
                        opt.contrast(img,startXx,startYy, endXx, endYy);
                         break;

                    }
        
    }
    
    

    
}