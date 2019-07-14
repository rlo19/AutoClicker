import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Body extends Clicker implements KeyListener {
	
	private boolean started = false;
	
	JButton start, stop;
	
	Clicker clicker = new Clicker();
	
	JFrame frame;
	
	public void frame() {

		frame = new JFrame("Auto Clicker");
		
		start = new JButton("Start (F6)");	
		start.setBounds(50, 50, 150, 20);	
		start.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

					startClick();					
				}
			}
		);
		
		stop = new JButton("Stop (F6)");
		stop.setBounds(50, 100, 150, 20);
		stop.setEnabled(false);
		
		stop.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

					stopClick();					
				}
			}
		);	
		
		frame.addKeyListener(this);		
		frame.add(start);
		frame.add(stop);
		
		frame.setFocusable(true);
		frame.setSize(250, 250);
		frame.setResizable(false);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}	
	
	public void startClick() {
		
		clicker.execute(); 
		
		System.out.println("Started");		
		start.setEnabled(false);
		stop.setEnabled(true);		
        
        frame.requestFocus();
	}
	
	public void stopClick() {
		
		clicker.cancel(true);
		
		System.out.println("Stopped");
		start.setEnabled(true);
		stop.setEnabled(false);
		
		frame.requestFocus();		
		clicker = new Clicker();		
	}	
	
	@Override
	public void keyPressed(KeyEvent e) {
		
		if(e.getKeyCode() == 117) {
			
			if(!isStarted()) {
				
				start.doClick();
				
				setStarted(true);
			} else {
				
				stop.doClick();
				
				setStarted(false);
			}
		}
	}
	
	public boolean isStarted() {
		return this.started;
	}

	public void setStarted(boolean started) {
		this.started = started;
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
	}

	
	@Override
	public void keyReleased(KeyEvent e) {
	}
}
