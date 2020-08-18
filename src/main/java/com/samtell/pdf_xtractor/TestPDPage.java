/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samtell.pdf_xtractor;

import java.awt.image.BufferedImage;
import org.apache.pdfbox.pdmodel.PDPage;
/**
 *
 * @author samtell
 */
public class TestPDPage extends AbstractPDPage{
    
    public TestPDPage(PDPage p){
        super(p);
    }
    
    @Override
    protected BufferedImage crop(BufferedImage bi){
        return bi.getSubimage(0,0,350,350);
    }
    
    
}
