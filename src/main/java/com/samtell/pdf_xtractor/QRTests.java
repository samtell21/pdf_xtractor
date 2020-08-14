/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samtell.pdf_xtractor;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.FlowLayout;
  

  
public class QRTests { 
    private static String decodeQRCode(File qrCodeimage) throws IOException {
        BufferedImage bufferedImage = ImageIO.read(qrCodeimage);
	
	bufferedImage = Utils.rotate180(bufferedImage);
	
	bufferedImage = bufferedImage.getSubimage(1000,700, 500, 800);
	
	
	
	JFrame f = new JFrame();
	JLabel l = new JLabel();
	ImageIcon i = new ImageIcon(bufferedImage);
	l.setIcon(i);
	f.getContentPane().setLayout(new FlowLayout());
	f.getContentPane().add(l);
	f.pack();
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	f.setVisible(true);
	
	
        return QR.decodeQRCode(bufferedImage);
    }
    

    
   
    

    public static void main(String[] args) {
        try {
	    //JFileChooser jf = new JFileChooser();
	    //JFrame frame = new JFrame();
	    //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    //frame.setVisible(true);
	    //jf.showOpenDialog(frame);
	    //
	    //String path = jf.getSelectedFile().getAbsolutePath();
	    
            File file = new File("../tests/img.png");
            String decodedText = decodeQRCode(file);
            if(decodedText == null) {
                System.out.println("No QR Code found in the image");
            } else {
                System.out.println("Decoded text = " + decodedText);
            }
        } catch (IOException e) {
            System.out.println("Could not decode QR Code, IOException :: " + e.getMessage());
        }
	

    }
  
    
} 
