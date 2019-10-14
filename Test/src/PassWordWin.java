import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class PassWordWin extends JFrame{
	public static void main(String[] args) {
		PassWordWin frm = new PassWordWin();
		frm.setSize(300, 200);
		frm.setTitle("密码验证");
		// 设置颜色，这里使用RGB三颜色
		Container c = frm.getContentPane();
		c.setBackground(new Color(200, 200, 255)); // RGB色
		frm.setLayout(null);
		// 创建“用户名： ”标签 
		JLabel L1 = new JLabel("用户名: ");
		L1.setBounds(40, 50, 55, 20);
		frm.setResizable(false);
		// 创建文本框
		JTextField t1 = new JTextField(50);
		t1.setBounds(100, 50, 100, 20);
		// 创建“密码：”标签		
		JLabel L2 = new JLabel("密码: ");
		L2.setBounds(40, 80, 55, 20);
		//　 创建密码文本框,设置密码文本框的回显字符为"*"
		JPasswordField t2 = new JPasswordField(50);
		t2.setEchoChar('*');
		t2.setBounds(100, 80, 100, 20);
		// 创建“确定”按钮
		JButton btn = new JButton("确定");
		// “确定”按钮获取用户名和密码
		btn.addActionListener((ActionEvent e)->{
			System.out.println(t1.getText());
			System.out.println(t2.getPassword());
		});
		btn.setBounds(40, 110, 80, 30);
		// 创建“清除”按钮
		JButton btn2 = new JButton("清除");
		// “清除”按钮可情况用户名和密码中的文本
		btn2.addActionListener((ActionEvent e)->{
			t1.setText("");
			t2.setText(""); 
		});
		btn2.setBounds(130, 110, 80, 30);
		// 将组件添加到frm中
		frm.add(t1);
		frm.add(L1);
		frm.add(L2);
		frm.add(t2);
		frm.add(btn);
		frm.add(btn2);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.setVisible(true);
	}
}

