import java.io.IOException;
import java.awt.EventQueue;
import java.net.URLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JEditorPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;


public class wwww implements HyperlinkListener, ActionListener {

	private JFrame fm;
	private JTextField tf1;
        private JTextField tf2;
	private JEditorPane editor1;
        private JEditorPane editor2;
	private JTextArea txtrHeader1;
	private JTextArea txtrHeader2;
	private JScrollPane scPane1;
        private JScrollPane scPane2;
	
	public wwww()
        {
            try
            {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } 
            catch(ClassNotFoundException e) {}                                
            catch(IllegalAccessException e) {}                                  
            catch(UnsupportedLookAndFeelException e) {}                         
            catch(InstantiationException e) {}    
		fm = new JFrame();
		fm.setTitle("Rueangurai Ekwatpanich s5050435@kmitl.ac.th - Java Web Browser (Network Programming Class Assignment)");
		fm.setBounds(10, 10, 1350, 720);
		fm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fm.getContentPane().setLayout(null);
		
                
		JButton btnNewButton = new JButton("OK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtrHeader1.setText("");
				txtrHeader2.setText("");
				MyThread a = new MyThread("Thread1"+" "+":",editor1,tf1,txtrHeader2,txtrHeader2);
				MyThread b = new MyThread("Thread2"+" "+":",editor2,tf2,txtrHeader1,txtrHeader2);
				a.start();
				b.start();
			}
		});
		btnNewButton.setBounds(600, 11, 50, 27);
		fm.getContentPane().add(btnNewButton);
		
		tf1 = new JTextField();
		tf1.setBounds(10, 12, 550, 25);
		fm.getContentPane().add(tf1);
		tf1.setColumns(10);
                tf1.setText("http://");
                
		editor1 = new JEditorPane();
		editor1.setEditable(false);
		
		JScrollPane scrollPane = new JScrollPane(editor1);
		scrollPane.setBounds(20, 80, 520, 350);
		fm.getContentPane().add(scrollPane);
		
		editor2 = new JEditorPane();
		editor2.setEditable(false);
		
		JScrollPane scrollPane_2 = new JScrollPane(editor2);
		scrollPane_2.setBounds(720, 80, 570, 350);
		fm.getContentPane().add(scrollPane_2);
		
		tf2 = new JTextField();
		tf2.setBounds(690, 12, 617, 25);
		fm.getContentPane().add(tf2);
		tf2.setColumns(10);
                tf2.setText("http://");

		txtrHeader2 = new JTextArea();
		txtrHeader2.setEditable(false);
		
		
		scPane2 = new JScrollPane(txtrHeader2);
		scPane2.setBounds(10, 510, 550, 162);
		fm.getContentPane().add(scPane2);
		
		txtrHeader1 = new JTextArea();
		txtrHeader1.setEditable(false);
		
		
		scPane1 = new JScrollPane(txtrHeader1);
		scPane1.setBounds(700, 510, 617, 162);
		fm.getContentPane().add(scPane1);
            
	}
           
        public static void main(String[] args) 
        {
		EventQueue.invokeLater(new Runnable() 
                {
			public void run() 
                        {
				try 
                                {
					wwww window = new wwww();
					window.fm.setVisible(true);
				} catch (Exception e) 
                                {
					e.printStackTrace();
				}
			}
		});
	}

    @Override
    public void hyperlinkUpdate(HyperlinkEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
