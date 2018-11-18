import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.xml.transform.TransformerException;

public class MyActionListener implements ActionListener {
	private String username;
	private char[] password;
	public MyActionListener(String name, char[] word) {
		this.username = name;
		this.password = word;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("111");
		if(this.username.equals("")) {
			JOptionPane.showMessageDialog(null, "请输入用户名!");
			return;
		}
		if(this.password.length == 0) {
			JOptionPane.showMessageDialog(null, "请输入密码");
			return;
		}
		try {
			Sender.toXml(this.username,this.password.toString());
			Sender.login();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
			catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
