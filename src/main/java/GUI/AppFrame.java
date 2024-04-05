/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import comp_decomp.compressor;
import comp_decomp.decompressor;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author yasha
 */
public class AppFrame extends JFrame implements ActionListener
{
    JButton compressButton;
    JButton decompressButton;
    
    public AppFrame() 
    {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Create a panel with GridBagLayout
        JPanel buttonPanel = new JPanel(new GridBagLayout());
        // Create GridBagConstraints to center the buttons
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10); // Padding
        
        // Add compress button
        compressButton = new JButton("Select file to Compress");
        buttonPanel.add(compressButton, gbc);
        compressButton.addActionListener(this);
        compressButton.setFont(new Font("Arial", Font.PLAIN, 16)); // Set font size to 16
        compressButton.setPreferredSize(new Dimension(250, 35)); // Set preferred size
        // Update GridBagConstraints for decompress button
        gbc.gridy = 0; // Ensure both buttons are in the same row
        gbc.gridx = 1; // Place decompress button in the next column
        
        // Add decompress button
        decompressButton = new JButton("Select file to Decompress");
        buttonPanel.add(decompressButton, gbc);
        decompressButton.addActionListener(this);
        decompressButton.setFont(new Font("Arial", Font.PLAIN, 16)); // Set font size to 16
        decompressButton.setPreferredSize(new Dimension(250, 35)); // Set preferred size
        // Set background color of the panel
        buttonPanel.setBackground(Color.LIGHT_GRAY);
        // Add button panel to frame
        this.add(buttonPanel, BorderLayout.CENTER);
        this.setSize(800, 400); // Setting initial size for demonstration
        this.setLocationRelativeTo(null); // Center the frame on screen
        this.setVisible(true);
    } 

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==compressButton)
        {
            JFileChooser filechooser=new JFileChooser();
            int response=filechooser.showSaveDialog(null);
            if(response==JFileChooser.APPROVE_OPTION)
            {
                File file=new File(filechooser.getSelectedFile().getAbsolutePath());
                System.out.println(file);
                try
                {
                    compressor.method(file);
                    JOptionPane.showMessageDialog(null, "File compressed successfully!", "Message", JOptionPane.INFORMATION_MESSAGE);
                }
                catch(IOException ex)
                {
                    JOptionPane.showConfirmDialog(null, ex.toString());
                }
            }
        }
        
        else if(e.getSource()==decompressButton)
        {
            JFileChooser filechooser=new JFileChooser();
            int response=filechooser.showSaveDialog(null);
            if(response==JFileChooser.APPROVE_OPTION)
            {
                File file=new File(filechooser.getSelectedFile().getAbsolutePath());
                System.out.println(file);
                try{
                    decompressor.method(file);
                    JOptionPane.showMessageDialog(null, "File decompressed successfully!", "Message", JOptionPane.INFORMATION_MESSAGE);
                }
                catch(IOException ex)
                {
                    JOptionPane.showConfirmDialog(null, ex.toString());
                }
            }
        }
    }
}

//old code
//    AppFrame() 
//    {
//    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//    
//    // Calculate the X position for the buttons to center them horizontally
//    int buttonWidth = 200;
//    int frameWidth = 1000;
//    int compressButtonX = (frameWidth - buttonWidth) / 2;
//    int decompressButtonX = (frameWidth - buttonWidth) / 2;
//    
//    compressButton = new JButton("Select file to Compress");
//    compressButton.setBounds(compressButtonX, 100, 200, 30);
//    compressButton.addActionListener(this);
//
//    decompressButton = new JButton("Select file to Decompress");
//    decompressButton.setBounds(decompressButtonX, 150, 200, 30);
//    decompressButton.addActionListener(this);
//    
//    this.setLayout(null); // Setting layout to null for absolute positioning
//    this.add(compressButton);
//    this.add(decompressButton);
//    
//    this.setSize(1000, 500);
//    this.getContentPane().setBackground(Color.green);
//    this.setVisible(true);
//}
