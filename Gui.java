import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Gui extends JFrame {
	
	private JButton [] buttons_;
	private int rows_;
	private int cols_;
	
	public Gui() {
		init();
		addStuff();
		setVisible(true);
	}
	
	public Gui(int rows, int cols) {
		rows_ = rows;
		cols_ = cols;
		buildGrid();
		init();
		setVisible(true);
	}
	
	private void buildGrid() {
		JPanel aPanel = new JPanel();
		GridLayout grid = new GridLayout( rows_ , cols_);
		aPanel.setLayout(grid);
		buttons_ = new JButton[rows_*cols_];
		ActionListener listener = new ButtonA();
		for(int i = 0; i < buttons_.length ; i++) {
			String buttonLabel = Integer.toString(i+1); 
		   	buttons_[i] = new JButton(buttonLabel);
			buttons_[i].addActionListener(listener);
			aPanel.add(buttons_[i]);
		}
		add(aPanel);
	}
	
	private void init() {
		int width = 500, height = 500;
		setSize(width, height);
		setLocation(200,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void addStuff() {
	 	 JPanel aPanel = new JPanel();
		 JLabel aLabel = new JLabel("Input:");
		 JTextField text = new JTextField(12);
		 aPanel.add(aLabel);
		 aPanel.add(text);
		 add(aPanel);
	}
	

	class ButtonA implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();
			System.out.println("You pressed button " + cmd );
		}
	}
	
	public static void main(String [] args) {
		new Gui(5,5);
		new Gui();
		anchor n = new anchor("http://www.google.com", "_blank");
		n.setHTMLId("google_link");
		anchor c = new anchor();
		anchor h = new anchor();
		anchor o = new anchor();
		anchor r = new anchor("#bottom");
		r.setHTMLClass("page_nav");
		System.out.println(n.toString());
		System.out.println(r.toString());
		System.out.println(anchor.getCount());
	}

}
