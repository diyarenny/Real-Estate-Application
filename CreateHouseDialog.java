package application;


import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;


public class CreateHouseDialog extends JFrame {

	
	JPanel mainPanel = new JPanel();
	JPanel topPanel = new JPanel();
    JPanel panelButtons = new JPanel();
	
    JLabel photo = new JLabel ("Photograph file name:");
    JLabel AddressLine1 = new JLabel ("Address Line 1:");
    JLabel AddressLine2 = new JLabel ("Address Line 2:");
    JLabel NumberBedrooms = new JLabel ("Number of bedrooms:");
    JLabel NumberBathrooms = new JLabel ("Number of bathrooms:");
    JLabel price = new JLabel ("Price:");
    JLabel contactNumber = new JLabel ("Contact Number:");
    
    JTextField photoName = new JTextField (20);
    JTextField AddLine1TextField = new JTextField (20);
    JTextField AddLine2TextField = new JTextField (20);
    String bedrooms = null;
    JTextField NumBedroomsTextField = new JTextField (20);
    String bathrooms = null;
    JTextField NumBathroomsTextField = new JTextField (20);
    JFormattedTextField priceTextField =  new JFormattedTextField("€###,###.00"); 
    JTextField contactNumTextField = new JTextField (20);
    
    JButton Add = new JButton ("Add");
    JButton Cancel = new JButton ("Cancel");
   
    private static ArrayList<House> houseList;
    //private static ArrayList<House> houseList = new ArrayList<House>();
   
    public CreateHouseDialog(ArrayList<House> houseList) {
    	
    	mainPanel.setLayout(new BorderLayout()); 
    	topPanel.setLayout(new MigLayout());
    	panelButtons.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
 	    topPanel.add(photo,"growX");
 	    topPanel.add(photoName, "growX,wrap");
 	    topPanel.add(AddressLine1, "growX");
 	    topPanel.add(AddLine1TextField,"growX,wrap");
 	    topPanel.add(AddressLine2, "growX");
 	    topPanel.add(AddLine2TextField,"growX,wrap");
 	    topPanel.add(NumberBedrooms, "growX");
 	    topPanel.add(NumBedroomsTextField,"growX,wrap");
 	    topPanel.add(NumberBathrooms, "growX");
 	    topPanel.add(NumBathroomsTextField,"growX,wrap");
 	    topPanel.add(price, "growX");
 	    topPanel.add(priceTextField,"growX,wrap");	    
 	    topPanel.add(contactNumber,"growX");
 	    topPanel.add(contactNumTextField,"growX,wrap");
 	    topPanel.add(panelButtons,"growX");
 	    
 	    panelButtons.add(Add);
	    panelButtons.add(Cancel);	
 	    
	    Cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	 JOptionPane.getRootFrame().dispose();   ;
            }
        });
	    
	    Add.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand().equalsIgnoreCase("Add")) {
					 String imageLocation = photoName.getText();
					 String street = AddLine1TextField.getText();
					 String city = AddLine2TextField.getText();
					 int bedrooms = Integer.parseInt(NumBedroomsTextField.getText());
					 int bathrooms = Integer.parseInt(NumBathroomsTextField.getText());
					 double price = Double.parseDouble((priceTextField.getText()));
					 String contactNo = contactNumTextField.getText();
				     House newHouse = new House(street, city, bedrooms,bathrooms,price,imageLocation,contactNo);
				     houseList.add(newHouse); 
				     JOptionPane.getRootFrame().dispose();   
				
			}	 
				     }
			        });
	    
	    mainPanel.add(topPanel, BorderLayout.CENTER);
	    mainPanel.add(panelButtons, BorderLayout.SOUTH);
	    JOptionPane.showOptionDialog(null, mainPanel,"Add House Details",JOptionPane.PLAIN_MESSAGE,JOptionPane.PLAIN_MESSAGE, null, new Object[]{}, null);
	    //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    

        public static void main(String[] args) {
	    CreateHouseDialog ha = new CreateHouseDialog(houseList);
	
}}

