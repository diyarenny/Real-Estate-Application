package application;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.AbstractButton;
import javax.swing.ComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.text.MaskFormatter;


import net.miginfocom.swing.MigLayout;



public class HouseApplication extends JFrame {
	
	ArrayList<House> houseList = new ArrayList<House>();
	int count = 4; //To keep track of the number of houses in the list 
    int currentItem = 0;
    static String password = "3175";
	String[][] records = { {"113 The Maltings", "Dublin 8", "2", "1", "155500.00", "House1.jpg", "(087) 9011135"},
			   {"78 Newington Lodge", "Dublin 14", "3", "2", "310000.00", "House2.jpg", "(087) 9010580"},
			   {"62 Bohernabreena Road", "Dublin 24", "3", "1", "220000.00", "House3.jpg", "(087) 6023159"},
			   {"18 Castledevitt Park", "Dublin 15", "3", "3", "325000.00", "House4.jpg", "(087) 9010580"},
			   {"40 Dunsawny Road", "Swords", "3", "19", "245000.00", "House5.jpg", "(087) 9011135"}};
	
	private Object user;
	
	//TextFields
	JLabel imgLabel = new JLabel();
    String id = null;
    JTextField houseIdTextField = new JTextField (50);
    JTextField AddLine1TextField = new JTextField (50);
    JTextField AddLine2TextField = new JTextField (50);
    String bedrooms = null;
    JTextField NumBedroomsTextField = new JTextField (50);
    String bathrooms = null;
    JTextField NumBathroomsTextField = new JTextField (50);
    JFormattedTextField priceTextField =  new JFormattedTextField(new DecimalFormat("€###,###,###.00")); 
    JFormattedTextField priceChangeTextField =  new JFormattedTextField(new DecimalFormat("€###,###,###.00"));
    JTextField contactNumTextField = new JTextField (50);
	
	
	public HouseApplication() {
		super("Estate Agent Application");
	    //Transform the array of data into Houses on the ArrayList 
		for (int i = 0; i < records.length; i++) {
			houseList.add(new House(records[i][0], records[i][1], Integer.parseInt(records[i][2]), 
		    Integer.parseInt(records[i][3]), Double.parseDouble(records[i][4]), records[i][5], records[i][6]));
		}
		
		 priceTextField.setValue(( new Double(houseList.get(0).getPrice())));	
		 priceChangeTextField.setValue((new Double(houseList.get(0).getChange())));
		 initComponents();
	}

	public void initComponents() {
		
		/* Set up your menus and menu items here */
		setLayout(new BorderLayout()); 
		
		//Panels
		JPanel imgPanel = new JPanel();
	    JPanel topPanel = new JPanel();
	    JPanel panelButtons = new JPanel();
	    JPanel bottomPanel = new JPanel();
	   	   
	    
	    //Labels
	    JLabel houseId = new JLabel ("House ID:");
	    JLabel AddressLine1 = new JLabel ("Address Line 1:");
	    JLabel AddressLine2 = new JLabel ("Address Line 2:");
	    JLabel NumberBedrooms = new JLabel ("Number of bedrooms:");
	    JLabel NumberBathrooms = new JLabel ("Number of bathrooms:");
	    JLabel price = new JLabel ("Price:");
	    JLabel priceChange = new JLabel ("Price Change:");
	    JLabel contactNumber = new JLabel ("Contact Number:");
	    JLabel space = new JLabel ();
	   
	    
	     //TextFields
	     imgLabel = new JLabel(new ImageIcon(houseList.get(0).getImageLocation()));
	     id = Integer.toString(houseList.get(0).getId());
	     houseIdTextField = new JTextField (id);
	     AddLine1TextField = new JTextField (houseList.get(0).getStreet());
	     AddLine2TextField = new JTextField (houseList.get(0).getCity());
	     bedrooms = Integer.toString(houseList.get(0).getBedrooms());
	     NumBedroomsTextField = new JTextField (bedrooms);
	     bathrooms = Integer.toString(houseList.get(0).getBathrooms());
	     NumBathroomsTextField = new JTextField (bathrooms); 
	     priceTextField.setValue(( new Double(houseList.get(0).getPrice())));
	     priceChangeTextField.setValue((new Double(houseList.get(0).getChange())));
	     contactNumTextField = new JTextField (houseList.get(0).getContactNo());
	    
	     
	    //Buttons
	    JButton first = new JButton (new ImageIcon("first.png"));
	    JButton previous = new JButton (new ImageIcon("prev.png"));
	    JButton edit = new JButton ("Edit");
	    JButton next = new JButton (new ImageIcon("next.png"));
	    JButton last = new JButton (new ImageIcon("last.png"));	
	    
	    //Menus
	    JMenuBar bar = new JMenuBar();
	 	JMenu modify = new JMenu("Modify");
	 	JMenu report = new JMenu("Report");
	 	JMenu close = new JMenu("Close");
	 	     
	 	JMenuItem create = new JMenuItem("Create");
	 	JMenuItem delete = new JMenuItem("Delete");	
	 	
	 	JMenuItem searchRecords = new JMenuItem("Search records");
	 	JMenuItem summaryReport = new JMenuItem("Summary report");
	   
	    //layout
	    topPanel.setLayout(new MigLayout("", "[grow,Fill]", "[grow,Fill]"));
	    

	    
		

		topPanel.add(bar);
		bar.add(modify);
		bar.add(report);
		bar.add(close);
		setJMenuBar(bar);
		modify.add(create);
	    modify.add(delete);
	    report.add(searchRecords);
	    report.add(summaryReport);
	    
	    imgPanel.add(imgLabel,"span, center, pushX, growX, wrap");
	    
	    topPanel.add(houseId, "growX");
	    topPanel.add(houseIdTextField,"growX, wrap");
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
	    topPanel.add(priceChange,"growX");
	    topPanel.add(priceChangeTextField,"growX,wrap");
	    topPanel.add(contactNumber,"growX");
	    topPanel.add(contactNumTextField,"growX,wrap");
	    topPanel.add(bottomPanel,"growX");
	    
	    houseIdTextField.setEditable(false);
	    AddLine1TextField.setEditable(false);
	    AddLine2TextField.setEditable(false);
	    houseIdTextField.setEditable(false);
	    NumBedroomsTextField.setEditable(false);
	    NumBathroomsTextField.setEditable(false);
	    priceTextField.setEditable(false);
	    priceChangeTextField.setEditable(false);
	    contactNumTextField.setEditable(false);  
	    
	    panelButtons.add(first);
	    panelButtons.add(previous);	
	    panelButtons.add(edit);
	    panelButtons.add(next);
	    panelButtons.add(last);
	    panelButtons.setLayout(new GridLayout(1,5));
	    bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
	    bottomPanel.add(panelButtons);
	    add(imgPanel, BorderLayout.NORTH);
	    add(topPanel, BorderLayout.CENTER);
	    add(bottomPanel, BorderLayout.SOUTH);   
		setSize(450, 600);
		setVisible(true);
		
		close.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
			
		});
		

		delete.addActionListener(new ActionListener() {	
		    public void actionPerformed(ActionEvent e) {
		    	String buttonString = e.getActionCommand();
		    	if(buttonString.equals("Delete")) {
					boolean valid = getPassword();
					if (valid == true) {
						String[] options = {"Cancel", "OK"};
						JOptionPane.showOptionDialog(null, "This will delete the record. Are you sure you want to continue?", "Warning",JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
						houseList.remove(currentItem);
						count--;		
						if (currentItem >= count) {
							currentItem = count;	
						}
						 if(currentItem <= 0) {
							currentItem = 0;
						}
						getHouse(currentItem);
					}
					else if (valid == false) {
						JOptionPane.showMessageDialog(null, "The Password You Entered Is Incorrect","Error Message",JOptionPane.ERROR_MESSAGE);			
					}
				}		    	   	
			     }
		        });
		
		create.addActionListener(new ActionListener() {			
		    public void actionPerformed(ActionEvent e) {
		    	String buttonString = e.getActionCommand();
		    	if(buttonString.equals("Create")) {
		    		boolean valid = getPassword();
		    		if (valid == true) {
		    			 new CreateHouseDialog(houseList);
		    			 int count2 = count+1;
		    			 if (count2 <  houseList.size()) {		    				 
		    				 count++;		    			 
		    			 }}}}
		        });

		summaryReport.addActionListener(new ActionListener() {			
		    public void actionPerformed(ActionEvent e) {
		    	String buttonString = e.getActionCommand();
		    	
		    	new HouseSummaryDialog(houseList);								 
						    	   	
			     }
		        });
		
		searchRecords.addActionListener(new ActionListener() {			
		    public void actionPerformed(ActionEvent e) {
		    	String buttonString = e.getActionCommand();
		    	
		    	JComboBox<String> comboBox = new JComboBox();
		    	String[] strings;
		    	if(buttonString.equals("Search records")) {
		    	
		      	  
		    		strings = new String[houseList.size()];
			        int i = 0;
			    	for(House a : houseList){
			    		  strings[i] = new Integer(a.getId()).toString();
			    		  i++;
			    	  }
			    	  
			    	  comboBox = new JComboBox<String>(strings);
			    	  String[] options = {"OK", "Cancel"};
			    	  Object[] options2 = {"Choose House ID", comboBox};
			    	  int result = JOptionPane.showOptionDialog(null, options2, "Add House Details",JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
				      int pos = 0;	
			    	  for(House a : houseList){
			           
			    	   String j = new Integer(a.getId()).toString();
			           if (j.equalsIgnoreCase(comboBox.getSelectedItem().toString())) {
			    	 		 
			    	  getHouse(pos);		 
			    			 
			    	  } 
			          pos++;
			          } 
				      }
				    	    	   	
			     }
		        });
	
	
		
		edit.addActionListener(new ActionListener() {			
	    public void actionPerformed(ActionEvent e) {
	    	 double num3 = houseList.get(currentItem).getPrice();
	    	
		      if(e.getActionCommand().equalsIgnoreCase("Edit")){	
		              edit.setText("Save");	
		              priceTextField.setEditable(true);
	   	}

	   	 if(e.getActionCommand().equalsIgnoreCase("Save")){
	   		String num = priceTextField.getText();
	   		double num1 = 0;
	   		double num2 = 0;
	   	if (num != null && num.length() > 0) {
	   		
	   		try{
	   			num1 = ((Number)priceTextField.getValue()).doubleValue();
	   		}catch(NumberFormatException ex){
	   		 //The user entered an invalid number, report the error
	   		}
	   	    
	   		try{
	   			num2 = Double.parseDouble(priceChangeTextField.getText());
	   		}catch(NumberFormatException ex){
	   		 //The user entered an invalid number, report the error
	   		}
	   		
	   		System.out.println(num1);
	   		System.out.println(num2);
	   		System.out.println(num3);
	   		
	   		num2 = num3 - num1;
	   		priceTextField.setValue((new Double(num1)));
	     	priceChangeTextField.setValue((new Double(num2)));
	     	houseList.get(currentItem).setChange(num2);
	     	houseList.get(currentItem).setPrice(num1);
	     	 
		   	 if (houseList.get(currentItem).getChange() < 0) {
		   		 
		   		priceChangeTextField.setForeground (Color.red);
		   		 
		   	 }
			edit.setText("Edit");	
			priceTextField.setEditable(false);
			 	 
	        	}
		      }
	   	
		     }
	        });
		

	     	first.addActionListener(new ActionListener() {
		     public void actionPerformed(ActionEvent e) {
		    	currentItem = 0;
		    	getHouse(0);
		     }
	        });
		
		       last.addActionListener(new ActionListener() {
		       public void actionPerformed(ActionEvent e) {
		       currentItem = count;	
		       getHouse(count);		 	  
		     }
	        });
		
		    next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			       
				currentItem++;
				   if (currentItem >= count) {
					   currentItem = count;
				   }
				   getHouse(currentItem);			 	 
			     }
		        });
		
	     	previous.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			       
				currentItem--;
				   if (currentItem < 0) {
					   currentItem= 0; 
				   }
				   getHouse(currentItem);
			 }
        });		

	     	 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
	}

	
	private void getHouse(int currentItem) {
	    
		   imgLabel.setIcon(new ImageIcon(houseList.get(currentItem).getImageLocation()));
	 	   String id = Integer.toString(houseList.get(currentItem).getId());
	 	   houseIdTextField.setText(id);
	 	   AddLine1TextField.setText(houseList.get(currentItem).getStreet());
	 	   AddLine2TextField.setText(houseList.get(currentItem).getCity());
	 	   String bedrooms = Integer.toString(houseList.get(currentItem).getBedrooms());
	 	   NumBedroomsTextField.setText(bedrooms);
	 	   String bathrooms = Integer.toString(houseList.get(currentItem).getBathrooms());
	 	   NumBathroomsTextField.setText(bathrooms);			 	    
	 	   priceTextField.setValue(( new Double(houseList.get(currentItem).getPrice())));
	 	   priceChangeTextField.setValue((new Double(houseList.get(currentItem).getChange())));			 	   
	  	   contactNumTextField.setText(houseList.get(currentItem).getContactNo());	  
	  	   
	         }
			
	
	
	
	private boolean getPassword() {
		String password1 = JOptionPane.showInputDialog(null, null,"Enter Password", JOptionPane.PLAIN_MESSAGE);
		if ( password.equals(password1)) {		
			return true;
		    } 
		else {		
			return false;	
		      }	
	}

	public static void main(String[] args) {
	  HouseApplication ha = new HouseApplication();
		
	}

}

