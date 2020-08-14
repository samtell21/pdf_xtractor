/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samtell.pdf_xtractor;

import java.awt.image.BufferedImage;

/**
 *
 * @author samtell
 */
public class TestPDPage extends AbstractPDPage{
    @Override
    protected BufferedImage crop(BufferedImage bi){
	return bi;
    }
    
    
}
