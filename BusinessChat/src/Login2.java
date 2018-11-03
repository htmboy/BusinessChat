import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login2 extends JFrame{
	private JLabel jl_username = new JLabel("ÓÃ»§Ãû:");
	private JLabel jl_password = new JLabel("ÃÜ Âë:");
	private JTextField jta_username = new JTextField(16);
	private JPasswordField jpf_password  = new JPasswordField(16);
	private JButton jb_submit = new JButton("µÇÂ½");
	public Login2() {
		JPanel username = new JPanel();
		setLayout(new FlowLayout());
		username.add(jl_username);
		username.add(jta_username);
		JPanel password = new JPanel();
		password.add(jl_password);
		password.add(jpf_password);
		JPanel submit = new JPanel();
		submit.add(jb_submit);
		add(username);
		add(password);
		add(submit);
		setBounds(0,0,400,300);
		setVisible(true);
	}
}
