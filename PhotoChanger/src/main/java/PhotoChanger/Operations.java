
package PhotoChanger;

import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.IOException;



public class Operations {
    
       // funkcja zmieniajaca obraz w czarno-bialy
  public void greyScale(BufferedImage img, int startX, int startY, int endX, int endY) throws IOException{

    int pixels[] = new int[3];
    double ww[]=new double[3];
    WritableRaster raster = img.getRaster();
     
         
      for(int i=startX;i<endX;i++) {
        for(int j=startY;j<endY;j++){
       
 
            raster.getPixel(i, j, pixels);
           
            ww[0] = 0.299*pixels[0]+0.587*pixels[1]+0.114*pixels[2];
            ww[1] = 0.299*pixels[0]+0.587*pixels[1]+0.114*pixels[2];
            ww[2] = 0.299*pixels[0]+0.587*pixels[1]+0.114*pixels[2];
           
           raster.setPixel(i, j, ww);
           
        }
   
   }

 
  }
  
  
  // funcja zmieniajaca obraz w sepie
  public void sepia(BufferedImage img, int startX, int startY, int endX, int endY) throws IOException{

    int pixels[] = new int[3];
    double ww[]=new double[3];
    WritableRaster raster = img.getRaster();
    
   for(int i=startX;i<endX;i++) {
   
        for(int j=startY;j<endY;j++){
 
            raster.getPixel(i, j, pixels);
           
            ww[0]=(0.393*pixels[0]+0.769*pixels[1]+0.189*pixels[2])/1.351;
            ww[1]=(0.349*pixels[0]+0.686*pixels[1]+0.186*pixels[2])/1.203;
            ww[2]=(0.272*pixels[0]+0.534*pixels[1]+0.131*pixels[2])/2.140;
           
           raster.setPixel(i, j, ww);
           
        }
   
   }


  }
    
  // funkcja zmieniajaca obraz w jego negatyw
   public void negative(BufferedImage img, int startX, int startY, int endX, int endY) throws IOException{
    int pixels[] = new int[3];
    double ww[]=new double[3];
    WritableRaster raster = img.getRaster();
     
 for(int i=startX;i<endX;i++) {
    for(int j=startY;j<endY;j++){
       
 
            raster.getPixel(i, j, pixels);
           
            ww[0] = 255-pixels[0];
            ww[1] = 255-pixels[1];
            ww[2] = 255-pixels[2];
           
           raster.setPixel(i, j, ww);
           
        }
   
   }

 

  }
   
   // funkcja zmieniajaca obraz w odcienie czerwonego
   public void toRed(BufferedImage img, int startX, int startY, int endX, int endY) throws IOException{
    int pixels[] = new int[3];
    double ww[]=new double[3];
    WritableRaster raster = img.getRaster();
     
     for(int i=startX;i<endX;i++) {
         for(int j=startY;j<endY;j++){
       
 
            raster.getPixel(i, j, pixels);
           
            ww[0] = pixels[0];
            ww[1] = 0*pixels[1];
            ww[2] = 0*pixels[2];
           
           raster.setPixel(i, j, ww);
           
        }
   
   }

 

  }
    
   // funkcja  zmieniajaca obraz w odcienie zielonego
   public void toGreen(BufferedImage img, int startX, int startY, int endX, int endY) throws IOException{
    int pixels[] = new int[3];
    double ww[]=new double[3];
    WritableRaster raster = img.getRaster();
    
  for(int i=startX;i<endX;i++) {
   
        for(int j=startY;j<endY;j++){
 
            raster.getPixel(i, j, pixels);
           
            ww[0] = 0*pixels[0];
            ww[1] = pixels[1];
            ww[2] = 0*pixels[2];
           
           raster.setPixel(i, j, ww);
           
        }
   
   }

 

  }
     // funkcja zmieniajaca obraz w odcienie niebieskiego
   public void toBlue(BufferedImage img, int startX, int startY, int endX, int endY) throws IOException{
    int pixels[] = new int[3];
    double ww[]=new double[3];
    WritableRaster raster = img.getRaster();
    
    for(int i=startX;i<endX;i++) {
   
        for(int j=startY;j<endY;j++){
 
            raster.getPixel(i, j, pixels);
           
            ww[0] = 0*pixels[0];
            ww[1] = 0*pixels[1];
            ww[2] = pixels[2];
           
           raster.setPixel(i, j, ww);
           
        }
   
   }

 

  }
      
   
  // funkcja zwiekszajaca kontrast obrazu
   public void contrast(BufferedImage img, int startX, int startY, int endX, int endY) throws IOException{
    int pixels[] = new int[3];
    double ww[]=new double[3];
    WritableRaster raster = img.getRaster();
    double c = 1.1;
    
      for(int i=startX;i<endX;i++) {
   
        for(int j=startY;j<endY;j++){
 
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

  }
}
