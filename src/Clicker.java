import java.awt.Robot;
import java.awt.event.InputEvent;

import javax.swing.SwingWorker;

public class Clicker extends SwingWorker<Integer, Void> {
	
	public void done() {
		
		System.out.println("Stop clicking");
	}

	@Override
	protected Integer doInBackground() throws Exception {

		System.out.println("Start clicking");		
		
		try {
			
			Robot robot = new Robot();
			
			try {
				
				while(true) {		

					System.out.println("Click");
//					System.out.println("Clicking");
					robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);	
					
//					System.out.println("releasing");
					
					robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
//					System.out.println("released");
					
					Thread.sleep(200);
				}
				
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt(); // restore interrupted status
                
				System.err.println(e);
				
			}
			
		} catch (Exception e) {
			System.err.println(e);
			
		}
		
		return null;				
	}	
}
