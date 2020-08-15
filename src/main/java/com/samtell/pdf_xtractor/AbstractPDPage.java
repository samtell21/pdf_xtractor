/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samtell.pdf_xtractor;

import java.awt.image.BufferedImage;
import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDPage;

/**
 *
 * @author samtell
 */
public abstract class AbstractPDPage{
    
    private PDPage internalPDPage;
    
    public PDPage getThis(){
	return internalPDPage;
    }
    
    public AbstractPDPage(PDPage p){
	internalPDPage = p;
    }
    
    public String scan() throws IOException{
	ImageGrabber ig = new ImageGrabber();
	ig.processPage(internalPDPage);
	BufferedImage bi = crop(ig.getImages().get(0));
	return QR.decodeQRCode(bi);
    }
    
    protected abstract BufferedImage crop(BufferedImage bi);
    
}
