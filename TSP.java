import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*; 
public class TSP{
	//Call the my Frame class in the main method to run it
	public static void main(String []args) {
		new MyFrame();
	}
}
/*
 * Implement input for the size of the array for the amount of input for the array.
 */
class MyFrame extends JFrame implements ActionListener{
	
	/*
	 * Method to get the output randomly generated.
	 * 
	 * Populates the given size array with the numbers from 1 to the length
	 * The given size is the text input into the delivery size 
	 * 
	 */
	public static String randomGuess(int in) {
		int N = 0;
		N=in;
		int[] nums = new int[N];
        for (int i = 0; i < nums.length; i++)
        	nums[i] = i+1;
        Random randomGenerator = new Random();
        int randomIndex; 
        int randomValue; 
        for(int i = 0; i < nums.length; i++){
             randomIndex = randomGenerator.nextInt(nums.length);
             randomValue = nums[randomIndex];
             nums[randomIndex] = nums[i];
             nums[i] = randomValue;
        }
        String out="";
        for(int i = 0;i<nums.length-1;i++)
        	out = out+ nums[i] + ",";
		return out+nums[N-1];
	}
	/*
	 * making accessible text areas and buttons outside the main constructor in case
	 * access is needed
	 */
	static JTextArea outText;
	JTextArea text;
	static JTextArea amountDel;
	JButton mapIcon;
	JButton submit;
	ImageIcon map;
	MyFrame(){
		/*
		 * Constructors for all labels, panels buttons etc
		 * 5 panels used to display 5 different items.
		 */
		JLabel inText = new JLabel();
		outText = new JTextArea();
		JLabel out = new JLabel();
		JLabel amount = new JLabel();
		mapIcon = new JButton();
		map = new ImageIcon("map.png");
		JLabel label = new JLabel(map);
		text = new JTextArea("text");
		amountDel = new JTextArea("num");
		submit = new JButton();
		JPanel numPanel = new JPanel();
		JPanel inPanel = new JPanel();
		JPanel outPanel = new JPanel();
		JPanel subPanel = new JPanel();
		JPanel mapPanel = new JPanel();
		JScrollPane scroll = new JScrollPane(text);
		JScrollPane scroll1 = new JScrollPane(outText);
		
		inText.setText("Input All Deliveries Here :");
		inText.setFont(new Font("Comic Sans",Font.BOLD,15));
		out.setText("Best Route :");
		out.setFont(new Font("Comic Sans",Font.BOLD,15));
		inPanel.setBackground(new Color(255,255,150));
		inPanel.setBounds(0,866,1071,150);
		inPanel.add(inText);
		
		outPanel.setBackground(new Color(255,255,150));
		outPanel.setBounds(1071, 0, 220, 650);
		
		subPanel.setBackground(new Color(255,255,150));
		subPanel.setBounds(1071, 800, 220, 200);
		
		numPanel.setBackground(new Color(255,255,150));
		numPanel.setBounds(1071,650,220,150);
		amount.setText("Deliveries for input (1-100)");
		amount.setFont(new Font("Comic sans",Font.BOLD,12));
		numPanel.add(amount);
		
		mapPanel.setBackground(new Color(255,255,150));
		mapPanel.setBounds(0, 0, 1071, 866);
		mapPanel.add(label);
		
		submit.setText("Submit");
		submit.setPreferredSize(new Dimension(150,150));
		submit.addActionListener(this);
		submit.setBackground(new Color(255,150,50));
		submit.setForeground(Color.yellow);
		submit.setFont(new Font("Comic Sans",Font.BOLD,25));
		submit.setFocusable(false);
		subPanel.add(submit);
		
		outText.setText("");
		outText.setLineWrap(true);
		outText.setWrapStyleWord(true);
		outText.setBackground(Color.white);
		outText.setEditable(false);
		outText.setBorder(BorderFactory.createLineBorder(new Color(255,0,0)));
		outText.setPreferredSize(new Dimension(150,500));
		
		amountDel.setText("");
		amountDel.setLineWrap(true);
		amountDel.setWrapStyleWord(true);
		amountDel.setBackground(Color.white);
		amountDel.setBorder(BorderFactory.createLineBorder(new Color(255,0,0)));
		amountDel.setPreferredSize(new Dimension(150,50));
		
		text.setText("");
		text.setLineWrap(true);
		text.setWrapStyleWord(true);
		text.setBackground(Color.white);
		text.setBorder(BorderFactory.createLineBorder(Color.red));
		
		scroll.setPreferredSize(new Dimension(500,80));
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		numPanel.add(amountDel);
		inPanel.add(scroll);
		outPanel.add(out);
		outPanel.add(scroll1);
		this.setTitle("Pizza Delivery Service.");
		this.add(numPanel);
		this.add(inPanel);
		this.add(outPanel);
		this.add(mapPanel);
		this.add(subPanel);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		
		this.setSize(1300,1000);
		this.setVisible(true);
	}
	/*
	 * once the "submit" button is pressed it waits for 10 seconds
	 * then it prints out a random array for the output.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		if(e.getSource()==submit) {
			if(outText.getText().isBlank()) 
				outText.setText("Please Input Amount of orders below");
			else
				outText.setText(randomGuess(Integer.parseInt(amountDel.getText())));
		}
		
	}
	
}
