
import java.awt.Button;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
import javax.swing.JTextField;
import javax.xml.transform.TransformerException;
=======
>>>>>>> parent of 6b5a536... 201811131
=======
>>>>>>> parent of 6b5a536... 201811131
=======
>>>>>>> parent of 6b5a536... 201811131
=======
>>>>>>> parent of 6b5a536... 201811131

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
		
		jl_username = new JLabel("用户名");
		addComponent(jl_username,0,0,1,1,10,100,GridBagConstraints.NONE, GridBagConstraints.CENTER);
		Button but = new Button("登录");
		jf = new JFrame("登陆");
		jf.setBounds(0, 0, 1000, 300);
		jf.setContentPane(this);
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setResizable(false);
//		jf.setDefaultLookAndFeelDecorated(true);
=======
>>>>>>> parent of 6b5a536... 201811131
=======
>>>>>>> parent of 6b5a536... 201811131
=======
>>>>>>> parent of 6b5a536... 201811131
=======
>>>>>>> parent of 6b5a536... 201811131
		jf.setVisible(true);
		jb_submit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(jtf_username.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "请输入用户名!");
					return;
				}
				if(jpf_password.getPassword().length == 0) {
					JOptionPane.showMessageDialog(null, "请输入密码");
					return;
				}
				try {
					Sender.toXml(jtf_username.getText(),jpf_password.getPassword().toString());
					Sender.sendTo();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
					catch (TransformerException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				System.out.println(jpf_password.getPassword());
					
			}
		});
	}

	private void addComponent(Component component, int gridx, int gridy, int gridwidth, int gridheight, int weightx, int heighty, int fill, int anchor) {
		GridBagConstraints constraints = new GridBagConstraints();
		
		constraints.gridx = gridx;
		constraints.gridy = gridy;
		constraints.gridwidth = gridwidth;
		constraints.gridheight = gridheight;
		constraints.weightx = weightx;
		constraints.weighty = heighty;
		constraints.fill = fill;
		constraints.anchor = anchor;
		gbl.setConstraints(component, constraints);
		add(component);
	}
	
}
