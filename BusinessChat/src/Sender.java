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
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;

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
	
	public static boolean login() throws IOException {
			URL url = new URL("http://139.199.77.144:8080");
			URLConnection con = url.openConnection();
			
			// 设置头信息
			con.setDoOutput(true);
			con.setRequestProperty("Pragma", "no-cache");
			con.setRequestProperty("Cache-control", "no-cache");
			con.setRequestProperty("Content-Type", "text/html");
			
			// 得到输出流
			OutputStreamWriter osw = new OutputStreamWriter(con.getOutputStream());
			
			// 读取文件
			BufferedReader br = new BufferedReader(new FileReader("login.xml"));
			
			// 缓存
			StringBuilder sb = new StringBuilder();
			String str;
			while((str = br.readLine()) != null) {
				sb.append(str);
			}
			
			
//			System.out.println(sb.toString());
			br.close();
			osw.write(new String(sb));
			osw.close();
			
			// 接收反馈数据
			BufferedReader brin = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"));
//			while((str = brin.readLine()) != null) {
//				System.out.println(brin.readLine());
//			}
			if(brin.readLine().equals("1"))
				return true;
			else
				return false;
	}
	
	public static void sendTo() throws UnknownHostException, IOException {
		Socket s = new Socket("139.199.77.144", 1000);
		
		// 发送数据 
		PrintStream ps = new PrintStream(s.getOutputStream(), true);
		
		
		// 输入流
		BufferedReader brin = new BufferedReader(new InputStreamReader(System.in));
		
		// 接收数据
		BufferedReader bris = new BufferedReader(new InputStreamReader(s.getInputStream(), "utf-8"));
		
		String str;
		
		while((str = brin.readLine()) != null) {
			ps.println(new String(str.getBytes(),"utf-8"));
			System.out.println(bris.readLine());
			if(str.equals("886")) {
				s.close();
				System.exit(0);
			}
			
		}
		s.close();
	}
}
