package Entity;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Util.FrameUtil;

public class Experiment4_2 {

	public static void main(String[] args) {
		init();

	}
	
	public static void init() {
		JFrame frame = new JFrame("实验二");
		JPanel panle = new JPanel();
		JLabel lable = new JLabel("欢迎过来点击我！");
		JButton but = new JButton("点击");
		panle.add(lable);
		panle.add(but);
		frame.add(panle);
		but.addActionListener(new ActionListener() {
			int count = 0;
			@Override
			public void actionPerformed(ActionEvent e) {
				lable.setText("您点击了" + ++count + "次");
				
			}
		});
		FrameUtil.initFrame(frame, 300, 70);
	}

}
