package application;


import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.GridLayout;



public class HouseSummaryDialog extends JFrame {
	
	JPanel mainPanel = new JPanel();
	JLabel houseId = new JLabel ("ID");
    JLabel AddressLine1 = new JLabel ("Address Line1");
    JLabel AddressLine2 = new JLabel ("Address Line2");
    JLabel NumberBedrooms = new JLabel ("Number of Bedrooms");
    JLabel NumberBathrooms = new JLabel ("Number of Bathrooms");
    JLabel price = new JLabel ("Price");
    JLabel contactNumber = new JLabel ("Contact Number");
    
    private static ArrayList<House> houseList;
    
    public HouseSummaryDialog(ArrayList<House> houseList) {
    	
    mainPanel.add(houseId);
    mainPanel.add(AddressLine1);	
    mainPanel.add(AddressLine2);
    mainPanel.add(NumberBedrooms);
    mainPanel.add(NumberBathrooms);
    mainPanel.add(price);
    mainPanel.add(contactNumber);
    
    int count = 1;
    double aveargePrice = 0;
    
    for(House a : houseList){
		  
    	
    	double price = a.getPrice();
    	aveargePrice =aveargePrice + price;
    	JLabel houseId1 = new JLabel (Integer.toString(a.getId()));
        JLabel AddressLine11 = new JLabel (a.getStreet());
        JLabel AddressLine21 = new JLabel (a.getCity());
        JLabel NumberBedrooms1 = new JLabel (Integer.toString(a.getBedrooms()));
        JLabel NumberBathrooms1 = new JLabel (Integer.toString(a.getBathrooms()));
        JLabel price1 = new JLabel (Double.toString(a.getPrice()));
        JLabel contactNumber1 = new JLabel (a.getContactNo());
        
        
        mainPanel.add(houseId1);
        mainPanel.add(AddressLine11);	
        mainPanel.add(AddressLine21);
        mainPanel.add(NumberBedrooms1);
        mainPanel.add(NumberBathrooms1);
        mainPanel.add(price1);
        mainPanel.add(contactNumber1);
    	
    	count++;
	  }
      
       double num = count-1;
       aveargePrice = aveargePrice/num;
       
       
      
       JLabel avrage = new JLabel ("Average Price:");
       JLabel space1 = new JLabel ("");
       JLabel space2 = new JLabel ("");
       JLabel space3 = new JLabel ("");
       JLabel space4 = new JLabel ("");
       JLabel priceAvrage = new JLabel (Double.toString(aveargePrice));
       JLabel contactNumber1 = new JLabel ("");
       
       
       mainPanel.add(avrage);
       mainPanel.add(space1);	
       mainPanel.add(space2);
       mainPanel.add(space3);
       mainPanel.add(space4);
       mainPanel.add(priceAvrage);
       mainPanel.add(contactNumber1);
   	
   	count++;
       
    
    
    add(mainPanel);
    mainPanel.setLayout(new GridLayout(count,6,25,4));
    
    
    JOptionPane.showOptionDialog(null, mainPanel,"Summary",JOptionPane.PLAIN_MESSAGE,JOptionPane.PLAIN_MESSAGE, null, new Object[]{}, null);

    
    }
    
    public static void main(String[] args) {
    	HouseSummaryDialog ha = new HouseSummaryDialog(houseList);
	
}
   }
