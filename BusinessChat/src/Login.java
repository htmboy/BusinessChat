
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;

public class Login extends JPanel{
	private JFrame jf;
	private GridBagLayout gbl = new GridBagLayout();
	private JButton but;
	private JLabel jl_username;
	private JLabel jl_password;
	private JTextArea jta;
	private JPasswordField jpf;
	
	public Login() {
		super();
		GridBagConstraints constraints;
		setLayout(gbl);
		jl_username = new JLabel("�û���");
		addComponent(jl_username,0,0,1,1,10,100,GridBagConstraints.NONE, GridBagConstraints.EAST);
		f.setBounds(400, 200, 500, 400);
		f.setLayout(new FlowLayout());
		Button but = new Button("��¼");
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

	private void addComponent(JLabel jl_username2, int gridx, int gridy, int gridwidth, int gridheight, int weightx, int heighty, int fill, int anchor) {
		GridBagConstraints constraints = new GridBagConstraints();
		
		constraints.gridx = gridx;
		constraints.gridy = gridy;
		constraints.gridwidth = gridwidth;
		constraints.gridheight = gridheight;
		constraints.weightx = weightx;
		constraints.weighty = heighty;
		constraints.fill = fill;
		constraints.anchor = anchor;
		gridbag.setConstraints(component, constraints);
	}
	
}
