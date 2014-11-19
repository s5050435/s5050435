import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

import javax.swing.JEditorPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class MyThread implements Runnable {
	private JEditorPane editorPane;
	private JTextField txtUrl;
	private JTextArea txtHeader;
	private Thread thread;
	private String threadName;
	private JTextArea to;
	
	public MyThread(String threadName,JEditorPane editorPane,JTextField txtUrl,JTextArea txtrHeader,JTextArea to){
		this.threadName = threadName;
		this.editorPane = editorPane;
		this.txtUrl = txtUrl;
		this.txtHeader = txtrHeader;
		this.to = to;
	}
	
	public void run() {
		getLink();
		getHeader();
	}
	
	public void start ()
	   {
		  to.append(threadName+" Creating Thread" +  "\n" );
	      if (thread == null)
	      {
	         thread = new Thread (this, threadName);
	         thread.start ();
	         to.append(thread.getName()+" Starting Thread" +  "\n" );
	      }
	   }
	public void getLink(){
		try{
 		 	thread.sleep(1000);
 		 }
 		 catch(InterruptedException e){}
		 to.append(thread.getName()+"Get Web" +"\n" );
		 try {
			 editorPane.setPage(txtUrl.getText());
		 }
		 catch (IOException e) {
			 editorPane.setContentType("text/html");
		   	 editorPane.setText("<html>Could not load "+txtUrl.getText()+" </html>");
		 }
		 
		
	}
	public void getHeader(){
		to.append(thread.getName()+" Getting Header" +"\n" );
		try{
 		 	thread.sleep(1000);
 		 }
 		 catch(InterruptedException e){}
		 try {
	            URLConnection conn = new URL(txtUrl.getText()).openConnection();
	            Map<String, List<String>> map = conn.getHeaderFields();
	            txtHeader.append("Header URL: "+txtUrl.getText()+ "\n");

	            for (Map.Entry<String, List<String>> entry : map.entrySet()) {
	            	txtHeader.append(entry.getKey() + " : " + entry.getValue()+"\n");
	            }
	            List<String> contentLength = map.get("Content-Length");
	 
	            if (contentLength == null) {
	            	txtHeader.append("'Content-Length' doesn't present in Header!");
	            } else {
	                for (String header : contentLength) {
	                	txtHeader.append("Content-Lenght: " + header);
	                }
	            }
	 
	        } catch (Exception e) {
	        	txtHeader.append("Could not load header "+txtUrl.getText());
	        }	
	}
}
