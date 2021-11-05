
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
import static javax.swing.GroupLayout.Alignment.BASELINE;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.filechooser.FileNameExtensionFilter;

public class NewClass extends JFrame{
    
    File selectedFile;
    BufferedImage orgImage;
    private String[] widthCut;
    private String[] heightCut;
    private JLabel display1;
    private JComboBox<String> box1;
    private JLabel display2;
    private JComboBox<String> box2;
    
    public NewClass() {

        initUI();
    }

    private void initUI() {
        var fileChooserButton = new JButton("Wybierz plik");
        var pane = getContentPane();
        var gl = new GroupLayout(pane);
        var g2 = new GroupLayout(pane);
        pane.setLayout(gl);
         pane.setLayout(g2);
        
        widthCut = new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
        box1 = new JComboBox<>(widthCut);
        display1 = new JLabel("Dzielenie zdjęcia w poziomie:");
        
        gl.setAutoCreateContainerGaps(true);
        gl.setAutoCreateGaps(true);

        gl.setHorizontalGroup(gl.createSequentialGroup()
                .addComponent(display1)
                .addComponent(box1,
                        GroupLayout.DEFAULT_SIZE,
                        GroupLayout.DEFAULT_SIZE,
                        GroupLayout.PREFERRED_SIZE)
        );
        gl.setVerticalGroup(gl.createParallelGroup(BASELINE)
                .addComponent(box1, GroupLayout.DEFAULT_SIZE,
                        GroupLayout.DEFAULT_SIZE,
                        GroupLayout.PREFERRED_SIZE)
                .addComponent(display1)
        );
        
        heightCut = new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
        box2 = new JComboBox<>(heightCut);
        display2 = new JLabel("Dzielenie zdjęcia w pionie:");
        
        g2.setAutoCreateContainerGaps(true);
        g2.setAutoCreateGaps(true);

        g2.setHorizontalGroup(g2.createSequentialGroup()
                .addComponent(display2)
                .addComponent(box2,
                        GroupLayout.DEFAULT_SIZE,
                        GroupLayout.DEFAULT_SIZE,
                        GroupLayout.PREFERRED_SIZE)
        );
        g2.setVerticalGroup(g2.createParallelGroup(BASELINE)
                .addComponent(box2, GroupLayout.DEFAULT_SIZE,
                        GroupLayout.DEFAULT_SIZE,
                        GroupLayout.PREFERRED_SIZE)
                .addComponent(display2)
        );

    
        
        
        pack();

        fileChooserButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                 JFileChooser fc = new JFileChooser();
                fc.setDialogTitle("Please choose an image...");
FileNameExtensionFilter filter = new FileNameExtensionFilter("JPEG", "jpeg", "jpg", "png", "bmp", "gif");
fc.addChoosableFileFilter(filter);

if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
    selectedFile = fc.getSelectedFile();
  
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

            var ex = new NewClass();
            ex.setVisible(true);
        });
    }
} 

