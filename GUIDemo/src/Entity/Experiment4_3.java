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
		logonmessage.add("�û�����");
		logonmessage.add("���룺");
		logonmessage.add("�Ա�");
		logonmessage.add("���ڵأ�");
		logonmessage.add("��Ȥ���ã�");
		logonmessage.add("���˼�飺");
		JFrame frame = new JFrame("�û�ע��");
		JTextArea info = new JTextArea(logonmessage.toString(),18, 60);
		info.setEditable(false);
		info.setLineWrap(true);
		
		JPanel panle = new JPanel();
		frame.add(panle);
		
		JLabel namelable = new JLabel("�û���:");
		JLabel passwordlable = new JLabel("����:");
		
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
		
		JLabel sexlable = new JLabel("�Ա�:");
		JRadioButton man = new JRadioButton("��",true);
		JRadioButton woman = new JRadioButton("Ů");
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
		 * �����С�����С��Ϻ��С�������
		 * �ӱ�ʡ��ɽ��ʡ������ʡ������ʡ��������ʡ������ʡ���㽭ʡ������ʡ��
		 * ����ʡ ������ʡ��ɽ��ʡ������ʡ������ʡ������ʡ���㶫ʡ������ʡ���Ĵ�ʡ��
		 * ����ʡ������ʡ������ʡ������ʡ���ຣʡ��̨��ʡ
		 * ����׳�������������ɹ������������������������Ļ������������½�ά���������
		 */
		Object [] city = {"������","�����","�Ϻ���","������",
						 "�ӱ�ʡ","ɽ��ʡ","����ʡ","����ʡ","������ʡ","����ʡ","�㽭ʡ","����ʡ",
						  "����ʡ ","����ʡ","ɽ��ʡ","����ʡ","����ʡ","����ʡ","�㶫ʡ","����ʡ","�Ĵ�ʡ",
						  "����ʡ","����ʡ","����ʡ","����ʡ","�ຣʡ","̨��ʡ",
						  "����׳��������","���ɹ�������","����������","���Ļ���������","�½�ά���������"};
		JLabel citylable = new JLabel("���ڳ���");
		JComboBox<Object> cities = new JComboBox<Object>(city);
		panle.add(citylable);
		panle.add(cities);
		cities.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				logonmessage.set(3,"���ڳ��У�" + (String)e.getItem());				
				info.setText(logonmessage.toString());
				
			}
		});
		
		
		JLabel hobitlable = new JLabel("��Ȥ����:");
		JCheckBox hobitbox1 = new JCheckBox("ѧϰ");
		JCheckBox hobitbox2 = new JCheckBox("JAVA");
		JCheckBox hobitbox3 = new JCheckBox("PYTHON");
		JCheckBox hobitbox4 = new JCheckBox("C/C++");
		JCheckBox hobitbox5 = new JCheckBox("��");
		JCheckBox hobitbox6 = new JCheckBox("��");
		JCheckBox hobitbox7 = new JCheckBox("RAP");
		JCheckBox hobitbox8 = new JCheckBox("����");
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
		JLabel infolabe2 = new JLabel("���˼�飺");
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
		
		JButton	okbut = new JButton("�ύ");
		panle.add(okbut);
		okbut.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(logonmessage.get(0).length() == 4) {
				JOptionPane.showMessageDialog(null, "�������û���", "����",JOptionPane.ERROR_MESSAGE);
				}
				else if(logonmessage.get(1).length() == 3) {
					JOptionPane.showMessageDialog(null, "����������", "����",JOptionPane.ERROR_MESSAGE);
				}
				else if(logonmessage.get(2).length() == 3) {
					JOptionPane.showMessageDialog(null, "��ѡ���Ա�", "����",JOptionPane.ERROR_MESSAGE);
				}
				else if(logonmessage.get(3).length() == 4) {
					JOptionPane.showMessageDialog(null, "��ѡ�����", "����",JOptionPane.ERROR_MESSAGE);
				}
				else if(logonmessage.get(4).length() == 5) {
					JOptionPane.showMessageDialog(null, "��ѡ����Ȥ����", "����",JOptionPane.ERROR_MESSAGE);
				}
				else if(logonmessage.get(5).length() == 5) {
					JOptionPane.showMessageDialog(null, "��������˼��", "����",JOptionPane.ERROR_MESSAGE);
				}
				if(logonmessage.get(0).length() != 4 && logonmessage.get(1).length() != 3 && logonmessage.get(2).length() != 3
						&& logonmessage.get(3).length() != 4 && logonmessage.get(4).length() != 5 && logonmessage.get(5).length() != 5
						  ) {
						if(logonmessage.get(4).length() == 16 && logonmessage.get(4).contains("��")&& logonmessage.get(4).contains("��")
								&& logonmessage.get(4).contains("RAP") && logonmessage.get(4).contains("����")) {
							JOptionPane.showMessageDialog(null, "������ϣ����ǲ���������", "��ϲ��ϲ",JOptionPane.WARNING_MESSAGE);
						}
					
							User user = new User(logonmessage.get(0).substring(4),password ,logonmessage.get(2).substring(3)
								,logonmessage.get(3).substring(4) ,logonmessage.get(4).substring(5) ,logonmessage.get(5).substring(5));
							/**
							 * ���д浵������Ķ�д��	
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
