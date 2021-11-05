
package PhotoChanger;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class GUI extends JFrame{
    public GUI() {

        initUI();
    }

    private void initUI() {
        var fileChooserButton = new JButton("Wybierz plik");
        JPanel imgPanel = new JPanel();

        fileChooserButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                 JFileChooser fc = new JFileChooser();
                fc.setDialogTitle("Please choose an image...");
FileNameExtensionFilter filter = new FileNameExtensionFilter("JPEG", "jpeg", "jpg", "png", "bmp", "gif");
fc.addChoosableFileFilter(filter);

BufferedImage origImage = null;
// You should use the parent component instead of null
// but it was impossible to tell from the code snippet what that was.
if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
    File selectedFile = fc.getSelectedFile();
    try {
        origImage = ImageIO.read(selectedFile);
        JFrame frame = new JFrame();
       frame.getContentPane().add(new JLabel(new ImageIcon(origImage)));
          frame.pack();
           frame.setVisible(true); 
       // imgPanel.add(selectedFile);
        
       
    } catch (IOException ex) {
        ex.printStackTrace();
        
    }
}
         //       JFileChooser photoChooser = new JFileChooser();
        //       FileNameExtensionFilter filter = new FileNameExtensionFilter("jpg", "jpeg", "img", "png");
        //      photoChooser.setFileFilter(filter);
         //      File loadedImg = photoChooser.getSelectedFile();
            }
        });
    

     

        createLayout(fileChooserButton);
        
        setTitle("Photo Changer");
        setSize(900, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
      private void createLayout(JComponent... arg) {

        var pane = getContentPane();
        var gl = new GroupLayout(pane);
        pane.setLayout(gl);

        gl.setAutoCreateContainerGaps(true);

        gl.setHorizontalGroup(gl.createSequentialGroup()
                .addComponent(arg[0])
        );

        gl.setVerticalGroup(gl.createSequentialGroup()
                .addComponent(arg[0])
        );
    }
    

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {

            var ex = new GUI();
            ex.setVisible(true);
        });
    }
} 

