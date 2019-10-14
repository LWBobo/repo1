package Entity;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Util.FrameUtil;

public class Experiment4_1 {

	public static void main(String[] args) {
		init();
		
	}
	
	public static void init() {
		JFrame frame = new JFrame("สตั้าป");
		JPanel panle = new JPanel();
		JTextField txt1 = new JTextField("123456", 10);
		JTextField txt2 = new JTextField("654321",10);
		JButton but = new JButton("exchange");
		panle.add(txt1);
		panle.add(txt2);
		panle.add(but);
		but.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String temp = txt1.getText();
				txt1.setText(txt2.getText());
				txt2.setText(temp);
				
			}
		});
		frame.add(panle);
		FrameUtil.initFrame(frame, 400, 70);
	}

}
