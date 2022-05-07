package ProcessingUtils.WindowMaker;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import ProcessingUtils.general.ClassAnalyser;
import processing.core.PApplet;

public class SwingConstructor {
	public static PApplet genericPapplet;
	public SwingConstructor() {
		// TODO Auto-generated constructor stub
	}
	public static void setPApplet(PApplet p) {genericPapplet=p;}
	public static int offset=15;
	public static ActionListener callMethodOnClick(String method) {
		final String parse=method;
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ClassAnalyser.call(genericPapplet,parse);
			}};
		
	}
	public static void callMethodOnClick(AbstractButton button,String method) {
		button.addActionListener(callMethodOnClick(method));
	}
	public static JPanel list_col(Container... c) {
  JPanel ret=new JPanel();
  //ret.setLayout(new BoxLayout(ret, BoxLayout.X_AXIS));
  int w=0;
  int h=0;
  for (Container i : c) {
    ret.add(i);
    Dimension d=i.getPreferredSize();
    w+=d.width+offset;
    h=Math.max(h, d.height);
  }
  h=offset;
  ret.setPreferredSize(new Dimension(w, h));
  return ret;
}
	public static JPanel list_row(Container... c) {
  JPanel ret=new JPanel();
  ret.setLayout(new BoxLayout(ret, BoxLayout.Y_AXIS));
  int w=0;
  int h=0;
  for (Container i : c) {
    ret.add(i);
    Dimension d=i.getPreferredSize();
    h+=d.height+offset;
    w=Math.max(h, d.width);
  }
  ret.setPreferredSize(new Dimension(w, h));
  return ret;
}
	public static JScrollPane scrollable(Container content) {

  return new JScrollPane(content);
}
	public static JScrollPane scrollable(Container content, int w, int h) {
  JScrollPane ret=new JScrollPane(content);
  ret.setPreferredSize(new Dimension(w, h));
  return ret;
}
	public static void resize(Container content,int w,int h) {
		content.setPreferredSize(new Dimension(w, h));
	}
	public static JFrame merge(Container content, String where) {
		PApplet programm=genericPapplet;
  //erstellen eines Fensters mit dem Inhalt
  JFrame window=new JFrame();
  window.add(content);

  //Übertragung vom Processingfenster auf das neue Fenster
  JFrame  mainFrame=(JFrame) ((processing.awt.PSurfaceAWT.SmoothCanvas)programm.getSurface().getNative()).getFrame();
  Container processing_content=mainFrame.getContentPane();
  processing_content.setPreferredSize(new Dimension(programm.width, programm.height));
  window.add(processing_content, where);

  //Spuren verwischen
  mainFrame.setVisible(false);
  window.setSize(new Dimension(programm.width+content.getPreferredSize().width, Math.max(programm.height, content.getPreferredSize().height)));
  window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

  return window;
}
}
