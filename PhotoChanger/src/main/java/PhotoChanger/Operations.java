
package PhotoChanger;

import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Operations {
    
       // funkcja zmieniajÄ…ca grafikÄ™ na czarno-biaĹ‚Ä…
  public void greyScale(BufferedImage img, int startX, int startY, int imgWidth, int imgHeight) throws IOException{
  // BufferedImage tmp = img;
    int pixels[] = new int[3];
    double ww[]=new double[3];
    WritableRaster raster = img.getRaster();
    
      for(int i=startX;i<imgWidth;i++) {
   
        for(int j=startY;j<imgHeight;j++){
 
            raster.getPixel(i, j, pixels);
           
            ww[0] = 0.299*pixels[0]+0.587*pixels[1]+0.114*pixels[2];
            ww[1] = 0.299*pixels[0]+0.587*pixels[1]+0.114*pixels[2];
            ww[2] = 0.299*pixels[0]+0.587*pixels[1]+0.114*pixels[2];
           
           raster.setPixel(i, j, ww);
           
        }
   
   }
 // JFrame frame = new JFrame();
 //       frame.getContentPane().add(new JLabel(new ImageIcon(img)));
 //         frame.pack();
 //          frame.setVisible(true); 
 
  }
  
  
  // funcja zmieniajÄ…ca obraz w sepie
  public void sepia(BufferedImage img, int startX, int startY, int imgWidth, int imgHeight) throws IOException{
  // BufferedImage tmp = img;
    int pixels[] = new int[3];
    double ww[]=new double[3];
    WritableRaster raster = img.getRaster();
    
     for(int i=startX;i<imgWidth;i++) {
   
        for(int j=startY;j<imgHeight;j++){
 
            raster.getPixel(i, j, pixels);
           
            ww[0]=(0.393*pixels[0]+0.769*pixels[1]+0.189*pixels[2])/1.351;
            ww[1]=(0.349*pixels[0]+0.686*pixels[1]+0.186*pixels[2])/1.203;
            ww[2]=(0.272*pixels[0]+0.534*pixels[1]+0.131*pixels[2])/2.140;
           
           raster.setPixel(i, j, ww);
           
        }
   
   }
 // JFrame frame = new JFrame();
 //       frame.getContentPane().add(new JLabel(new ImageIcon(img)));
 //         frame.pack();
 //          frame.setVisible(true); 
 

  }
    
  // funkcja przetwarzajÄ…ca obraz na negatyw
   public void negative(BufferedImage img, int startX, int startY, int imgWidth, int imgHeight) throws IOException{
    int pixels[] = new int[3];
    double ww[]=new double[3];
    WritableRaster raster = img.getRaster();
    
    for(int i=startX;i<imgWidth;i++) {
   
        for(int j=startY;j<imgHeight;j++){
 
            raster.getPixel(i, j, pixels);
           
            ww[0] = 255-pixels[0];
            ww[1] = 255-pixels[1];
            ww[2] = 255-pixels[2];
           
           raster.setPixel(i, j, ww);
           
        }
   
   }
  //JFrame frame = new JFrame();
  //      frame.getContentPane().add(new JLabel(new ImageIcon(img)));
  //        frame.pack();
  //         frame.setVisible(true); 
 

  }
   
   // funkcja zmieniajÄ…ca obraz na zawierajÄ…cy tylko odcienie czerwonego
   public void toRed(BufferedImage img, int startX, int startY, int imgWidth, int imgHeight) throws IOException{
    int pixels[] = new int[3];
    double ww[]=new double[3];
    WritableRaster raster = img.getRaster();
    
     for(int i=startX;i<imgWidth;i++) {
   
        for(int j=startY;j<imgHeight;j++){
 
            raster.getPixel(i, j, pixels);
           
            ww[0] = pixels[0];
            ww[1] = 0*pixels[1];
            ww[2] = 0*pixels[2];
           
           raster.setPixel(i, j, ww);
           
        }
   
   }
 // JFrame frame = new JFrame();
    //    frame.getContentPane().add(new JLabel(new ImageIcon(img)));
    //      frame.pack();
    //       frame.setVisible(true); 
 

  }
    
   // funkcja zmieniajÄ…ca obraz na zawierajÄ…cy tylko odcienie zielonego
   public void toGreen(BufferedImage img, int startX, int startY, int imgWidth, int imgHeight) throws IOException{
    int pixels[] = new int[3];
    double ww[]=new double[3];
    WritableRaster raster = img.getRaster();
    
    for(int i=startX;i<imgWidth;i++) {
   
        for(int j=startY;j<imgHeight;j++){
 
            raster.getPixel(i, j, pixels);
           
            ww[0] = 0*pixels[0];
            ww[1] = pixels[1];
            ww[2] = 0*pixels[2];
           
           raster.setPixel(i, j, ww);
           
        }
   
   }
 // JFrame frame = new JFrame();
//        frame.getContentPane().add(new JLabel(new ImageIcon(img)));
//          frame.pack();
//           frame.setVisible(true); 
 

  }
     // funkcja zmieniajÄ…ca obraz na zawierajÄ…cy tylko odcienie niebieskiego
   public void toBlue(BufferedImage img, int startX, int startY, int imgWidth, int imgHeight) throws IOException{
    int pixels[] = new int[3];
    double ww[]=new double[3];
    WritableRaster raster = img.getRaster();
    
    for(int i=startX;i<imgWidth;i++) {
   
        for(int j=startY;j<imgHeight;j++){
 
            raster.getPixel(i, j, pixels);
           
            ww[0] = 0*pixels[0];
            ww[1] = 0*pixels[1];
            ww[2] = pixels[2];
           
           raster.setPixel(i, j, ww);
           
        }
   
   }
 // JFrame frame = new JFrame();
 //       frame.getContentPane().add(new JLabel(new ImageIcon(img)));
 //         frame.pack();
  //         frame.setVisible(true); 
 

  }
      
   
   /* 
   funkcja contrast do poprawy - jasne barwy sÄ… jaĹ›niejsze, ciemne ciemniejsze, problemem sÄ… bawry, ktĂłre na poczÄ…tku byĹ‚y bardzo ciemne lub bardzo jasne
   */
   public void contrast(BufferedImage img, int startX, int startY, int imgWidth, int imgHeight) throws IOException{
    int pixels[] = new int[3];
    double ww[]=new double[3];
    WritableRaster raster = img.getRaster();
    double c = 1.1;
    
      for(int i=startX;i<imgWidth;i++) {
   
        for(int j=startY;j<imgHeight;j++){
 
            raster.getPixel(i, j, pixels);
           
            ww[0]=pixels[0];
            ww[1]=pixels[1];
            ww[2]=pixels[2];
            
            ww[0]=ww[0]-128;
            ww[1]=ww[1]-128;
            ww[2]=ww[2]-128;
            
            ww[0]=ww[0]*c;
            ww[1]=ww[1]*c;
            ww[2]=ww[2]*c;
            
        
           
           
           raster.setPixel(i, j, ww);
           
        }
   
   }
 // JFrame frame = new JFrame();
  //      frame.getContentPane().add(new JLabel(new ImageIcon(img)));
  //        frame.pack();
   //        frame.setVisible(true); 
 

  }
}
