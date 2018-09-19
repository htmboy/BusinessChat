
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Login {
	private Frame f;
	private Button but;
	public Login() {
		init();
	}
	private void init() {
		f = new Frame("ÉÌÎñÍ¨");
	//	f.setSize(500, 400);
	//	f.setLocation(400, 200);
		f.setBounds(400, 200, 500, 400);
		f.setLayout(new FlowLayout());
		Button but = new Button("µÇÂ¼");
		f.add(but);
		f.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent arg0) {
				// TODO Auto-generated method stub
//				super.windowClosing(arg0);
				System.exit(0);
			}
			
		});
		f.setVisible(true);
	}
	
}
