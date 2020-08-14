/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samtell.pdf_xtractor;

import org.apache.pdfbox.pdmodel.*;
import java.io.File;
import java.io.IOException;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author samtell
 */
public abstract class MainGuiAbstract extends javax.swing.JFrame {

    /**
     * Creates new form MainGui
     */
    public MainGuiAbstract() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fc = new javax.swing.JFileChooser();
        input = new javax.swing.JTextField();
        inputLabel = new javax.swing.JLabel();
        inputChoose = new javax.swing.JButton();
        output = new javax.swing.JTextField();
        outputLabel = new javax.swing.JLabel();
        outputChoose = new javax.swing.JButton();
        okButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        input.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputActionPerformed(evt);
            }
        });

        inputLabel.setText("Input File");

        inputChoose.setText("File Chooser");
        inputChoose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputChooseActionPerformed(evt);
            }
        });

        output.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                outputActionPerformed(evt);
            }
        });

        outputLabel.setText("Output Dir");

        outputChoose.setText("File Chooser");
        outputChoose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                outputChooseActionPerformed(evt);
            }
        });

        okButton.setText("OK");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("TEST");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(outputLabel)
                            .addComponent(inputLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(input)
                            .addComponent(output, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(outputChoose, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(inputChoose, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(119, 119, 119)
                        .addComponent(okButton)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputLabel)
                    .addComponent(input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputChoose))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(outputLabel)
                    .addComponent(output, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(outputChoose))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(okButton)
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void inputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputActionPerformed

    private void outputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_outputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_outputActionPerformed

    private void inputChooseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputChooseActionPerformed
	
	fc.setSelectedFile(null);
        fc.setFileSelectionMode(javax.swing.JFileChooser.FILES_AND_DIRECTORIES);
	fc.addChoosableFileFilter(filter);
	fc.setFileFilter(filter);
        fc.showOpenDialog(this);
	if(fc.getSelectedFile() != null){
        	input.setText(fc.getSelectedFile().getAbsolutePath());
	}
    }//GEN-LAST:event_inputChooseActionPerformed

    private void outputChooseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_outputChooseActionPerformed
	fc.removeChoosableFileFilter(filter);
	fc.setSelectedFile(null);
        fc.setFileSelectionMode(javax.swing.JFileChooser.DIRECTORIES_ONLY);
        fc.showOpenDialog(this);
	if(fc.getSelectedFile() != null){
        	output.setText(fc.getSelectedFile().getAbsolutePath());
	}
    }//GEN-LAST:event_outputChooseActionPerformed

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        try{
            xtract(input.getText(), output.getText());
        } catch(Exception e){
            javax.swing.JOptionPane.showMessageDialog(rootPane, e+"\nexiting...");
            System.exit(1);
        }
        javax.swing.JOptionPane.showMessageDialog(rootPane, "Success");
        System.exit(0);
    }//GEN-LAST:event_okButtonActionPerformed


    
    
    public abstract void xtract(String file, String outputdir);
    
    FileFilter filter = new FileFilter(){
	final String pdf = "pdf";
	@Override
	public String getDescription(){
	    return pdf;
	}	
	@Override
	public boolean accept(File f){
	    String ext = null;
	    String s = f.getName();
	    int i = s.lastIndexOf('.');
	    if(i>0 && i< s.length() -1){
		ext = s.substring(i+1).toLowerCase();
	    }
	    return ext==null || ext.equals(pdf);
	}
    };	

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFileChooser fc;
    private javax.swing.JTextField input;
    private javax.swing.JButton inputChoose;
    private javax.swing.JLabel inputLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton okButton;
    private javax.swing.JTextField output;
    private javax.swing.JButton outputChoose;
    private javax.swing.JLabel outputLabel;
    // End of variables declaration//GEN-END:variables
}