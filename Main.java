import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main implements Runnable, ActionListener{

  // Class Variables  
  JPanel mainPanel;

  JLabel firstLabel;
  JLabel secondLabel;
  JLabel thirdLabel;

  JTextField firstInput;
  JTextField secondInput;
  JTextField thirdInput;

  JButton validateButton;
  JButton resetButton;
  
  JTextArea outputArea;
  JTextArea instructionArea;

  Font biggerText;


  // Method to assemble our GUI
  public void run(){
    // Creats a JFrame that is 800 pixels by 600 pixels, and closes when you click on the X
    JFrame frame = new JFrame("Title");
    // Makes the X button close the program
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // makes the windows 800 pixel wide by 600 pixels tall
    frame.setSize(800,600);
    // shows the window
    frame.setVisible(true);

    // initialize the main JPanel
    mainPanel = new JPanel();
    // disable any layout helpers
    mainPanel.setLayout(null);

    // create the side labels
    firstLabel = new JLabel("Enter the first side:");
    secondLabel = new JLabel("Enter the second side:");
    thirdLabel = new JLabel("Enter the third side:");

    // layout the labels by setting the corrdinate and size
    firstLabel.setBounds(10,10,200,20);
    secondLabel.setBounds(10,40,200,20);
    thirdLabel.setBounds(10,70,200,20);

    // add the labels to the main mainPanel
    mainPanel.add(firstLabel);
    mainPanel.add(secondLabel);
    mainPanel.add(thirdLabel);

    // initialize the input text fields
    firstInput = new JTextField();
    secondInput = new JTextField();
    thirdInput = new JTextField();

    // set the locate and size
    firstInput.setBounds(220,10,100,20);
    secondInput.setBounds(220,40,100,20);
    thirdInput.setBounds(220,70,100,20);

    // add the text fields to the main panel
    mainPanel.add(firstInput);
    mainPanel.add(secondInput);
    mainPanel.add(thirdInput);

    // initialize the input JButtons
    validateButton = new JButton("Validate");
    resetButton = new JButton("Reset");

    // set the location and size
    validateButton.setBounds(330, 10, 100, 35);
    resetButton.setBounds(330, 55, 100, 35);

    // add an action listener to the buttons
    validateButton.addActionListener(this);
    resetButton.addActionListener(this);

    // set the action command on the buttons
    validateButton.setActionCommand("validate");
    resetButton.setActionCommand("reset");

    // add the JButtons to the main panel
    mainPanel.add(validateButton);
    mainPanel.add(resetButton);

    // initialize the text areas
    outputArea = new JTextArea();
    instructionArea = new JTextArea();

    // create a string the holds the instructions
    String instructions = "This is a simple triangle dectector. \nEnter an integer in each of the text fields above.\nPress the \"Validate Button\" to find out whether you have made a validate triangle or not.\n You can press Reset to clear everything out.";

    // set the text in the instruction area
    instructionArea.setText(instructions);

    // set the location and size
    outputArea.setBounds(10, 100, 780, 240);
    instructionArea.setBounds(10, 350, 780, 240);

    // disable the text areas so the user can not type in them
    outputArea.setEnabled(false);
    instructionArea.setEnabled(false);

    // create a bigger font to use
    biggerText = new Font("arial",Font.PLAIN, 20);

    // set the font on the area I want to use it
    instructionArea.setFont(biggerText);

    // add the text areas to the main panel
    mainPanel.add(outputArea);
    mainPanel.add(instructionArea);

    // add the main panel to the window
    frame.add(mainPanel);
 
    

  }

  // checks to see if a triangle is validate given the length of side a, b and c
  public boolean isValidTriangle(int a, int b, int c){
    // checks using the triangle inequality
    if(a+b > c && a+c > b && b+c > a){
      // valid triangle
      return true;
    }else{
      // invalid triaangle
      return false;
    }

  }

  // method called when a button is pressed
  public void actionPerformed(ActionEvent e){
    // get the command from the action
    String command = e.getActionCommand();

    if(command.equals("validate")){
      // get the text from each text box
      String firstText = firstInput.getText();
      String secondText = secondInput.getText();
      String thirdText = thirdInput.getText();

      // change the string into an integer
      int sideA = Integer.parseInt(firstText);
      int sideB = Integer.parseInt(secondText);
      int sideC = Integer.parseInt(thirdText);

      // using a method to check if the traingle is valid
      boolean isValid = isValidTriangle(sideA, sideB, sideC);
      // ouput the answer to the user
      if(isValid){
        outputArea.setText("This is a valid traingle");
      }else{
        outputArea.setText("This is an invalid traingle");
      }
    

    }else if(command.equals("reset")){
      // clear all of the etxt in the text boxes
      firstInput.setText("");
      secondInput.setText("");
      thirdInput.setText("");
      outputArea.setText("");
    }

  }

  // Main method to start our program
  public static void main(String[] args){
    // Creates an instance of our program
    Main gui = new Main();
    // Lets the computer know to start it in the event thread
    SwingUtilities.invokeLater(gui);
  }
}
