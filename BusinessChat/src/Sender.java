import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;


public class Sender {

	public static Document toXml(String username, String password) throws IOException, TransformerException {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.newDocument();
			
			Element name = doc.createElement("username");
			name.appendChild(doc.createTextNode(username));
			
			Element pass = doc.createElement("password");
			pass.appendChild(doc.createTextNode(password));
			
			Element root = doc.createElement("login");
			root.appendChild(pass);
			root.appendChild(name);
			
			doc.appendChild(root);
			
//			NodeList list = root.getChildNodes();
//			for(int i = 0; i < list.getLength(); i++) {
//				System.out.println(list.item(i).getNodeName() + ":" + list.item(i).getTextContent());
//			}
			TransformerFactory tff = TransformerFactory.newInstance();
			Transformer tf = tff.newTransformer();
			tf.transform(new DOMSource(doc), new StreamResult(new File("login.xml")));
			return doc;
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static void sendTo() throws IOException {
		try {
			URL url = new URL("http://139.199.77.144:8080");
			URLConnection con = url.openConnection();
			con.setDoOutput(true);
			con.setRequestProperty("Pragma", "no-cache");
			con.setRequestProperty("Cache-control", "no-cache");
			con.setRequestProperty("Content-Type", "text/html");
			OutputStreamWriter osw = new OutputStreamWriter(con.getOutputStream());
			FileReader fr = new FileReader(new File("login.xml"));
			BufferedReader br = new BufferedReader(fr);
			StringBuilder sb = new StringBuilder();
			String ch = "";
			while((ch = br.readLine()) != null) {
				sb.append(ch);
				
			}
			System.out.println(sb.toString());
			fr.close();
			br.close();
			osw.write(new String(sb));
			osw.flush();
			osw.close();
			BufferedReader br1 = new BufferedReader(new InputStreamReader(con.getInputStream()));
			while((ch = br1.readLine()) != null) {
				System.out.println(ch);
			}
			br1.close();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
<<<<<<< HEAD
	
	public static void sendTo2() throws UnknownHostException, IOException {
		Socket s = new Socket("139.199.77.144", 5542);
		PrintStream ps = new PrintStream(s.getOutputStream(), true);
		FileReader fr = new FileReader(new File("login.xml"));
		BufferedReader br = new BufferedReader(fr);
		
		int len;
		String ch;
		ps.println("Pragma: no-cache");
		while((len = br.read()) != -1) {
			ps.println(len);
		}
		
		BufferedReader br1 = new BufferedReader(new InputStreamReader(s.getInputStream()));
		while((ch = br1.readLine()) != null) {
			System.out.println(ch);
		}
		
		s.close();
	}
=======
>>>>>>> parent of bb7e3be... 20181116
}
