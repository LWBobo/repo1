package Entity;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;


import Util.FrameUtil;
import Util.ObjFileRW;

public class Experiment4_3 {
	static ArrayList<String> logonmessage = new ArrayList<String>() {
		@Override
		public String toString() {
			Iterator<String> it = this.iterator();
			StringBuffer str = new StringBuffer();
			while(it.hasNext()) {
				str.append(it.next()+"\n");
			}
		return str.toString();
		}
		
	};
	static String password = "";
	public static void main(String[] args) {
		init();

	}
	
	public static void init() {
		logonmessage.add("用户名：");
		logonmessage.add("密码：");
		logonmessage.add("性别：");
		logonmessage.add("所在地：");
		logonmessage.add("兴趣爱好：");
		logonmessage.add("个人简介：");
		JFrame frame = new JFrame("用户注册");
		JTextArea info = new JTextArea(logonmessage.toString(),18, 60);
		info.setEditable(false);
		info.setLineWrap(true);
		
		JPanel panle = new JPanel();
		frame.add(panle);
		
		JLabel namelable = new JLabel("用户名:");
		JLabel passwordlable = new JLabel("密码:");
		
		JTextField namefile = new JTextField(10);
		JPasswordField passwordfile = new JPasswordField(10);
		namefile.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				logonmessage.set(0, namelable.getText() + namefile.getText());
				info.setText(logonmessage.toString());
				
			}
		});
		passwordfile.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String realpassword = new String(passwordfile.getPassword());
				password = realpassword;
				String showpass = "";
				for (int i = 0; i < password.length(); i++) {
					showpass += "*";
				}
				logonmessage.set(1, passwordlable.getText() + showpass);
				info.setText(logonmessage.toString());
			}
		});
		panle.add(namelable);
		panle.add(namefile);
		panle.add(passwordlable);
		panle.add(passwordfile);
		
		JLabel sexlable = new JLabel("性别:");
		JRadioButton man = new JRadioButton("男",true);
		JRadioButton woman = new JRadioButton("女");
		ButtonGroup group = new ButtonGroup();
		group.add(man);
		group.add(woman);
		man.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(man.isSelected()) {
					logonmessage.set(2,sexlable.getText() + man.getText());
					info.setText(logonmessage.toString());
				}
				
			}
		});
		woman.addItemListener(new ItemListener() {
					
					@Override
					public void itemStateChanged(ItemEvent e) {
						if(woman.isSelected()) {
							logonmessage.set(2,sexlable.getText() + woman.getText());
							info.setText(logonmessage.toString());
						}
						
					}
				});

		panle.add(sexlable);
		panle.add(man);
		panle.add(woman);
		
		/**
		 * 北京市、天津市、上海市、重庆市
		 * 河北省、山西省、辽宁省、吉林省、黑龙江省、江苏省、浙江省、安徽省、
		 * 福建省 、江西省、山东省、河南省、湖北省、湖南省、广东省、海南省、四川省、
		 * 贵州省、云南省、陕西省、甘肃省、青海省、台湾省
		 * 广西壮族自治区、内蒙古自治区、西藏自治区、宁夏回族自治区、新疆维吾尔自治区
		 */
		Object [] city = {"北京市","天津市","上海市","重庆市",
						 "河北省","山西省","辽宁省","吉林省","黑龙江省","江苏省","浙江省","安徽省",
						  "福建省 ","江西省","山东省","河南省","湖北省","湖南省","广东省","海南省","四川省",
						  "贵州省","云南省","陕西省","甘肃省","青海省","台湾省",
						  "广西壮族自治区","内蒙古自治区","西藏自治区","宁夏回族自治区","新疆维吾尔自治区"};
		JLabel citylable = new JLabel("所在城市");
		JComboBox<Object> cities = new JComboBox<Object>(city);
		panle.add(citylable);
		panle.add(cities);
		cities.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				logonmessage.set(3,"所在城市：" + (String)e.getItem());				
				info.setText(logonmessage.toString());
				
			}
		});
		
		
		JLabel hobitlable = new JLabel("兴趣爱好:");
		JCheckBox hobitbox1 = new JCheckBox("学习");
		JCheckBox hobitbox2 = new JCheckBox("JAVA");
		JCheckBox hobitbox3 = new JCheckBox("PYTHON");
		JCheckBox hobitbox4 = new JCheckBox("C/C++");
		JCheckBox hobitbox5 = new JCheckBox("唱");
		JCheckBox hobitbox6 = new JCheckBox("跳");
		JCheckBox hobitbox7 = new JCheckBox("RAP");
		JCheckBox hobitbox8 = new JCheckBox("篮球");
		panle.add(hobitlable);
		panle.add(hobitbox1);
		panle.add(hobitbox2);
		panle.add(hobitbox3);
		panle.add(hobitbox4);
		panle.add(hobitbox5);
		panle.add(hobitbox6);
		panle.add(hobitbox7);
		panle.add(hobitbox8);	
		hobitbox1.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(!hobitbox1.isSelected()) {
					if(logonmessage.get(4).contains(hobitbox1.getText())) {
					logonmessage.set(4,logonmessage.get(4).replace(hobitbox1.getText()+" ", ""));
					info.setText(logonmessage.toString());
					}

				}
				else if(hobitbox1.isSelected()) {
					logonmessage.set(4,logonmessage.get(4) + hobitbox1.getText() + " ");
					info.setText(logonmessage.toString());
				}
				
			}
		});
		hobitbox2.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(!hobitbox2.isSelected()) {
					if(logonmessage.get(4).contains(hobitbox2.getText())) {
					logonmessage.set(4,logonmessage.get(4).replace(hobitbox2.getText() + " ", ""));
					info.setText(logonmessage.toString());
					}

				}
				else if(hobitbox2.isSelected()) {
					logonmessage.set(4,logonmessage.get(4) + hobitbox2.getText() + " ");
					info.setText(logonmessage.toString());
				}
				
			}
		});
		hobitbox3.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(!hobitbox3.isSelected()) {
					if(logonmessage.get(4).contains(hobitbox3.getText())) {
					logonmessage.set(4,logonmessage.get(4).replace(hobitbox3.getText() + " ", ""));
					info.setText(logonmessage.toString());
					}

				}
				else if(hobitbox3.isSelected()) {
					logonmessage.set(4,logonmessage.get(4) + hobitbox3.getText() + " ");
					info.setText(logonmessage.toString());
				}
				
			}
		});
		hobitbox4.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(!hobitbox4.isSelected()) {
					if(logonmessage.get(4).contains(hobitbox4.getText())) {
					logonmessage.set(4,logonmessage.get(4).replace(hobitbox4.getText() + " ", ""));
					info.setText(logonmessage.toString());
					}

				}
				else if(hobitbox4.isSelected()) {
					logonmessage.set(4,logonmessage.get(4) + hobitbox4.getText() + " ");
					info.setText(logonmessage.toString());
				}
				
			}
		});
		hobitbox5.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(!hobitbox5.isSelected()) {
					if(logonmessage.get(4).contains(hobitbox5.getText())) {
					logonmessage.set(4,logonmessage.get(4).replace(hobitbox5.getText() + " ", ""));
					info.setText(logonmessage.toString());
					}

				}
				else if(hobitbox5.isSelected()) {
					logonmessage.set(4,logonmessage.get(4) + hobitbox5.getText() + " ");
					info.setText(logonmessage.toString());
				}
				
			}
		});
		hobitbox6.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(!hobitbox6.isSelected()) {
					if(logonmessage.get(4).contains(hobitbox6.getText())) {
					logonmessage.set(4,logonmessage.get(4).replace(hobitbox6.getText() + " ", ""));
					info.setText(logonmessage.toString());
					}

				}
				else if(hobitbox6.isSelected()) {
					logonmessage.set(4,logonmessage.get(4) + hobitbox6.getText() + " ");
					info.setText(logonmessage.toString());
				}
				
			}
		});
		hobitbox7.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(!hobitbox7.isSelected()) {
					if(logonmessage.get(4).contains(hobitbox7.getText())) {
					logonmessage.set(4,logonmessage.get(4).replace(hobitbox7.getText() + " ", ""));
					info.setText(logonmessage.toString());
					}

				}
				else if(hobitbox7.isSelected()) {
					logonmessage.set(4,logonmessage.get(4) + hobitbox7.getText() + " ");
					info.setText(logonmessage.toString());
				}
				
			}
		});
		hobitbox8.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(!hobitbox8.isSelected()) {
					if(logonmessage.get(4).contains(hobitbox8.getText())) {
					logonmessage.set(4,logonmessage.get(4).replace(hobitbox8.getText() + " ", ""));
					info.setText(logonmessage.toString());
					}

				}
				else if(hobitbox8.isSelected()) {
					logonmessage.set(4,logonmessage.get(4) + hobitbox8.getText() + " ");
					info.setText(logonmessage.toString());
				}
				
			}
		});
		
		JLabel infolabe1 = new JLabel("             ");
		JLabel infolabe2 = new JLabel("个人简介：");
		JTextArea infoarea = new JTextArea(5,53);
		infoarea.setLineWrap(true);
		infoarea.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				logonmessage.set(5,infolabe2.getText() + infoarea.getText());
				info.setText(logonmessage.toString());
				
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				logonmessage.set(5,infolabe2.getText() + infoarea.getText());
				info.setText(logonmessage.toString());
				
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				logonmessage.set(5,infolabe2.getText() + infoarea.getText());
				info.setText(logonmessage.toString());
				
			}
		});
		panle.add(infolabe1);
		panle.add(infolabe2);
		panle.add(infoarea);
		
		JButton	okbut = new JButton("提交");
		panle.add(okbut);
		okbut.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(logonmessage.get(0).length() == 4) {
				JOptionPane.showMessageDialog(null, "请输入用户名", "警告",JOptionPane.ERROR_MESSAGE);
				}
				else if(logonmessage.get(1).length() == 3) {
					JOptionPane.showMessageDialog(null, "请输入密码", "警告",JOptionPane.ERROR_MESSAGE);
				}
				else if(logonmessage.get(2).length() == 3) {
					JOptionPane.showMessageDialog(null, "请选择性别", "警告",JOptionPane.ERROR_MESSAGE);
				}
				else if(logonmessage.get(3).length() == 4) {
					JOptionPane.showMessageDialog(null, "请选择城市", "警告",JOptionPane.ERROR_MESSAGE);
				}
				else if(logonmessage.get(4).length() == 5) {
					JOptionPane.showMessageDialog(null, "请选择兴趣爱好", "警告",JOptionPane.ERROR_MESSAGE);
				}
				else if(logonmessage.get(5).length() == 5) {
					JOptionPane.showMessageDialog(null, "请输入个人简介", "警告",JOptionPane.ERROR_MESSAGE);
				}
				if(logonmessage.get(0).length() != 4 && logonmessage.get(1).length() != 3 && logonmessage.get(2).length() != 3
						&& logonmessage.get(3).length() != 4 && logonmessage.get(4).length() != 5 && logonmessage.get(5).length() != 5
						  ) {
						if(logonmessage.get(4).length() == 16 && logonmessage.get(4).contains("唱")&& logonmessage.get(4).contains("跳")
								&& logonmessage.get(4).contains("RAP") && logonmessage.get(4).contains("篮球")) {
							JOptionPane.showMessageDialog(null, "鉴定完毕，你是蔡徐坤！！", "恭喜恭喜",JOptionPane.WARNING_MESSAGE);
						}
					
							User user = new User(logonmessage.get(0).substring(4),password ,logonmessage.get(2).substring(3)
								,logonmessage.get(3).substring(4) ,logonmessage.get(4).substring(5) ,logonmessage.get(5).substring(5));
							/**
							 * 进行存档（对象的读写）	
							 */
							File file = new File("G:/JAVASpace/GUIDemo/src/data/userData.dat");
							ObjFileRW of = new ObjFileRW(file);
							 of.write(user);
							 User user1 = (User)of.read();
							 System.out.println(user1.toString());
						}
				
				
			}
		});
		
		
		panle.add(info);
		FrameUtil.initFrame(frame, 650, 600);
	}



}
