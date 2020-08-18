/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samtell.pdf_xtractor;


import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;

import org.apache.pdfbox.pdmodel.PDDocument;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import java.awt.FlowLayout;

import java.util.Scanner;

  
public class QRTests { 
    private static void view(BufferedImage bufferedImage) throws IOException {
	
        bufferedImage = Utils.rotate180(bufferedImage);

        bufferedImage=com.samtell.pdf_xtractor.Utils.rotate180(bufferedImage);

        Scanner k = new Scanner(System.in);
        System.out.print("start x: ");
        int sx = k.nextInt();
        System.out.print("start y: ");
        int sy = k.nextInt();
        System.out.print("crop x: ");
        int cx = k.nextInt();
        System.out.print("crop y: ");
        int cy = k.nextInt();
        System.out.println(sx+" "+sy+" "+cx+" "+cy);
        bufferedImage = bufferedImage.getSubimage(sx,sy,cx,cy);

        
	
	
        JFrame f = new JFrame();
        JLabel l = new JLabel();
        ImageIcon i = new ImageIcon(bufferedImage);
        l.setIcon(i);
        f.getContentPane().setLayout(new FlowLayout());
        f.getContentPane().add(l);
        f.pack();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        //ImageIO.write(bufferedImage, "PNG", new File("img.png"));

        System.out.println(QR.decodeQRCode("img.png"));
	
	
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
            
	    
            //File file = new File("../../multipage-codes.pdf");
            //try(PDDocument doc = PDDocument.load(file)){
            //    ImageGrabber ig = new ImageGrabber();
            //    ig.processDoc(doc);
            //    BufferedImage bi = ig.getImages().get(1);
            //    view(bi);


            //}

            System.out.println(test());
           
        } catch (IOException e) {
            System.out.println("Could not decode QR Code, IOException :: " + e.getMessage());
        }


	

    }


    public static String test() throws IOException {
        return QR.decodeQRCode("img.png");
    }
}
