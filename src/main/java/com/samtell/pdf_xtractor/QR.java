/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samtell.pdf_xtractor;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author samtell
 */
public class QR {
    
    public static String decodeQRCode(String path) throws IOException{
        File qrCodeimage = new File(path);
        return decodeQRCode(qrCodeimage);
    }
    
    public static String decodeQRCode(File qrCodeimage) throws IOException{
	
        BufferedImage bufferedImage = ImageIO.read(qrCodeimage);
        return decodeQRCode(bufferedImage);
    }
    
    public static String decodeQRCode(BufferedImage bufferedImage){
	
        LuminanceSource source = new BufferedImageLuminanceSource(bufferedImage);
        BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

        try {
            Result result = new MultiFormatReader().decode(bitmap);
            return result.getText();
        } catch (NotFoundException e) {
            System.out.println("There is no QR code in the image");
            return null;
        }
	
    }
    
}
