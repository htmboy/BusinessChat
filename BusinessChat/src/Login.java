
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
import javax.swing.JTextField;
import javax.xml.transform.TransformerException;

public class Login extends JPanel{
	private JFrame jf = new JFrame("µ«¬Ω");
	private GridBagLayout gbl = new GridBagLayout();
	private JButton jb_submit = new JButton("µ«¬Ω");
	private JLabel jl_username = new JLabel("”√ªß√˚:");
	private JLabel jl_password = new JLabel("√‹ ¬Î:");
	private JTextField jtf_username = new JTextField(16);
	private JPasswordField jpf_password = new JPasswordField(16);
	
	public Login() {
		super();
		GridBagConstraints constraints;
		setLayout(gbl);

		addComponent(jl_username,0,0,1,1,10,100,GridBagConstraints.NONE, GridBagConstraints.EAST);
		addComponent(jtf_username,1,0,1,1,10,100,GridBagConstraints.NONE, GridBagConstraints.WEST);
		addComponent(jl_password,0,1,1,1,10,100,GridBagConstraints.NONE, GridBagConstraints.EAST);
		addComponent(jpf_password,1,1,1,1,10,100,GridBagConstraints.NONE, GridBagConstraints.WEST);
		addComponent(jb_submit,1,2,1,1,10,100,GridBagConstraints.NONE, GridBagConstraints.WEST);
		Button but = new Button("µ«¬º");
		jf.setBounds(0, 0, 320, 120);
		jf.setContentPane(this);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setResizable(false);
//		jf.setDefaultLookAndFeelDecorated(true);
		jf.setVisible(true);
		jb_submit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(jtf_username.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "«Î ‰»Î”√ªß√˚!");
					return;
				}
				if(jpf_password.getPassword().length == 0) {
					JOptionPane.showMessageDialog(null, "«Î ‰»Î√‹¬Î");
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
