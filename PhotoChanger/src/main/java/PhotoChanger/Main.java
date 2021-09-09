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
            
          //  Operations opt = new Operations();
            
            int opti = optionChooser();
            int part = imgSlice();
          /*  
            if(opti==9){
                for(int i=1; i<(part+1); i++){
                    for(int j=1;j>(part+1);j++){
                        Random rand = new Random();
                        int c = rand.nextInt(7);
                        changerImg(img,(imgWidth-imgWidth/i), (imgHeight-imgHeight/j),(imgWidth-imgWidth/(part-i)), (imgHeight-imgHeight/(part-j)), c);
                    }
                }
                
                JFrame frame = new JFrame();
                frame.getContentPane().add(new JLabel(new ImageIcon(img)));
                frame.pack();
                frame.setVisible(true); 
                
                
            } else{
                for(int i=1; i<(part+1); i++){
                    for(int j=1;j>(part+1);j++){
                       
                        changerImg(img,(imgWidth-imgWidth/i), (imgHeight-imgHeight/j),(imgWidth-imgWidth/(part-i)), (imgHeight-imgHeight/(part-j)), opti);
                    }
                }
                
                JFrame frame = new JFrame();
                frame.getContentPane().add(new JLabel(new ImageIcon(img)));
                frame.pack();
                frame.setVisible(true); 
                
            }
            
            */
            if(part==1){
                if(opti==9){
                    Random random = new Random();
               int c = random.nextInt(7);
                
               changerImg(img, 0, 0, imgWidth, imgHeight, c);
                }else{
                   changerImg(img, 0, 0, imgWidth, imgHeight, opti); 
                }
                
            } else if(part==2){
                int a = imgWidth/2;
                int b = imgHeight/2;
               
                if(opti==9){
                    Random random = new Random();
               int c1 = random.nextInt(7);
               int c2 = random.nextInt(7);
               int c3 = random.nextInt(7);
               int c4 = random.nextInt(7);
                 changerImg(img, 0, 0 ,imgWidth-a, imgHeight-b, c1);
                changerImg(img, a, 0, imgWidth, imgHeight-b, c2);
                changerImg(img, 0, b, imgWidth-a, imgHeight, c3);
                changerImg(img, a, b, imgWidth, imgHeight, c4);
               
                } else {
                changerImg(img, 0, 0 ,imgWidth-a, imgHeight-b, opti);
                changerImg(img, a, 0, imgWidth, imgHeight-b, opti);
                changerImg(img, 0, b, imgWidth-a, imgHeight, opti);
                changerImg(img, a, b, imgWidth, imgHeight, opti);
                }
                
                JFrame frame = new JFrame();
       frame.getContentPane().add(new JLabel(new ImageIcon(img)));
          frame.pack();
           frame.setVisible(true); 
                
            } else if(part==3) {
                int a = imgWidth/3;
                int b =imgHeight/3;
                
                 if(opti==9){
                    Random random = new Random();
               int c1 = random.nextInt(7);
               int c2 = random.nextInt(7);
               int c3 = random.nextInt(7);
               int c4 = random.nextInt(7);
               int c5 = random.nextInt(7);
               int c6 = random.nextInt(7);
               int c7 = random.nextInt(7);
               int c8 = random.nextInt(7);
               int c9 = random.nextInt(7);
               
                changerImg(img, 0, 0, imgWidth-2*a, imgHeight-2*b, c1);
                changerImg(img, a, 0, imgWidth-a, imgHeight-2*b, c2);
                changerImg(img, 2*a, 0, imgWidth, imgHeight-2*b, c3);
                
                changerImg(img, 0, b, imgWidth-2*a, imgHeight-b, c4);
                changerImg(img, a, b, imgWidth-a, imgHeight-b, c5);
                changerImg(img, 2*a, b, imgWidth, imgHeight-b, c6);
                
                changerImg(img, 0, 2*b, imgWidth-2*a, imgHeight, c7);
                changerImg(img, a, 2*b, imgWidth-a, imgHeight, c8);
                changerImg(img, 2*a, 2*b, imgWidth, imgHeight, c9);
               
                 }
                 else {
                changerImg(img, 0, 0, imgWidth-2*a, imgHeight-2*b, opti);
                changerImg(img, a, 0, imgWidth-a, imgHeight-2*b, opti);
                changerImg(img, 2*a, 0, imgWidth, imgHeight-2*b, opti);
                
                changerImg(img, 0, b, imgWidth-2*a, imgHeight-b, opti);
                changerImg(img, a, b, imgWidth-a, imgHeight-b, opti);
                changerImg(img, 2*a, b, imgWidth, imgHeight-b, opti);
                
                changerImg(img, 0, 2*b, imgWidth-2*a, imgHeight, opti);
                changerImg(img, a, 2*b, imgWidth-a, imgHeight, opti);
                changerImg(img, 2*a, 2*b, imgWidth, imgHeight, opti);
                 }
                 
                JFrame frame = new JFrame();
       frame.getContentPane().add(new JLabel(new ImageIcon(img)));
          frame.pack();
           frame.setVisible(true); 
            
            }
            
            //changerImg(img, 0, 0, imgWidth, imgHeight, opti);
            
        
            
     
             
    int halfWidth = (imgWidth/2);
    int halfHeight = (imgHeight/2);

            
    
    /*
    funckje Operations:
    funkcja(a, b, x, y)
    przerabia obszar od x do a w poziomie
    i od y do b w pionie
    
    jeśli dzielimy orbaz na 4
        1 część zaczyna się w punkcie 0,0 i idzie do połowy szerokości i połowy wysokości
        wiec funkcja(połowa szerokości, połowa wysokości, 0,0);
    2 część zaczyna się w punkcie połowa szerokości, 0 i idzie do końca szerokości i połowy wysokości
    więc funckja(szekorość obrazu, połowa wysokości, połowa szerokości, 0);
        3 część obrazu zaczyna się w punkcie 0, połowa wysokości i idzie do połowy szerokości i do końca wysokości
        więc funkcja(połowa szerokości, wysokość obrazu, 0, połowa wysokości)
    4 część zaczyna się w punkcie połowa szerokości i połowa wysokości i idzie do końa szerokości i wysokości obrazu
    więc funkcja(szerokość obrazu, wysokość obrazu, połowa szerokości, połowa wysokości)
    
    TODO::
   
    2 - dodać możliwość wybrania podzielenia obrazu na części
    3 - dodać możliwość przerobienia obrazu całego tak samo lub w różnych stylach
    4 - wielowątkowość
    5 - GUI
    
    
    */
    
    
  // opt.toRed(img, 0,0, halfWidth, halfHeight);
  // opt.greyScale(img, halfWidth, 0, imgWidth, halfHeight);
 //  opt.toBlue(img,0, halfHeight, halfWidth, imgHeight);
  //  opt.negative(img, halfWidth, halfHeight,imgWidth, imgHeight);

             
     //  JFrame frame = new JFrame();
    //   frame.getContentPane().add(new JLabel(new ImageIcon(img)));
      //    frame.pack();
      //     frame.setVisible(true); 
      

    }
    
    public static int imgSlice() {
        System.out.println("Na ile części podzielić zdjęcie?: ");
        System.out.println("1 - nie dziel zdjęcia");
        System.out.println("2 - na 4 części");
        System.out.println("3 - na 9 części");
        
         Scanner scan = new Scanner(System.in);
        int part = scan.nextInt();
        
        return part;
        
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
            
            //Scanner scan = new Scanner(System.in);
            int opti = scan.nextInt();
            return opti;

        }
             else{
               // Random random = new Random();
              //  int opti = random.nextInt(7);
              int opti=9;
             return opti;
                
        }
        
 
    }
    
    
    public static void changerImg(BufferedImage img, int startX, int startY, int imgWidth, int imgHeight, int option) throws IOException{
        Operations opt = new Operations();
        switch(option){
                    case 1:
                        opt.greyScale(img,0,0, imgWidth, imgHeight);
                        break;
                    case 2:
                     opt.sepia(img,0,0, imgWidth, imgHeight);
                     break;
                    case 3:
                        opt.negative(img,0,0, imgWidth, imgHeight);
                         break;
                    case 4:
                        opt.toRed(img,0,0, imgWidth, imgHeight);
                         break;
                    case 5:
                        opt.toBlue(img,0,0, imgWidth, imgHeight);
                         break;
                    case 6:
                        opt.contrast(img,0,0, imgWidth, imgHeight);
                         break;

                    }
        
    }
    
    
    
public static BufferedImage joinBufferedImage(BufferedImage img1,
      BufferedImage img2) {
    int offset = 2;
    int width = img1.getWidth() + img2.getWidth() + offset;
    int height = Math.max(img1.getHeight(), img2.getHeight()) + offset;
    BufferedImage newImage = new BufferedImage(width, height,
        BufferedImage.TYPE_INT_ARGB);
    Graphics2D g2 = newImage.createGraphics();
    Color oldColor = g2.getColor();
    g2.setPaint(Color.BLACK);
    g2.fillRect(0, 0, width, height);
    g2.setColor(oldColor);
    g2.drawImage(img1, null, 0, 0);
    g2.drawImage(img2, null, img1.getWidth() + offset, 0);
    g2.dispose();
    return newImage;
  }
    
}