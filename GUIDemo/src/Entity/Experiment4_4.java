package Entity;

import java.awt.BorderLayout;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import Util.FrameUtil;

public class Experiment4_4{
	static int font = 12; //�����С
	static String copystr = null; //����
	public int mark = 0; //ճ��
	JFrame frame = new JFrame("���±�");
	JMenuBar bar = new JMenuBar();
	JMenu filemenu = new JMenu("�ļ�");
	JMenu editMenu = new JMenu("�༭");
	JMenu formatMenu = new JMenu("��ʽ");
	JMenu seeMenu = new JMenu("�鿴");
	JMenu helpMenu = new JMenu("����");
	
	JTextArea area = new JTextArea(20,30);
	
	/** �ļ��� */
	JMenuItem openmenu = new JMenuItem("��");
	JMenuItem savemenu = new JMenuItem("����");
	JMenuItem closemenu = new JMenuItem("�ر�");
	/** �༭�� */
	JMenuItem copymenu = new JMenuItem("����");
	JMenuItem pastemenu = new JMenuItem("ճ��");
	/** ��ʽ�� */
	JMenu  typefacemenu = new JMenu("����");
	JMenuItem overstrikingmenu = new JMenuItem("�Ӵ�");
	JMenuItem underlinemenu = new JMenuItem("ģ��");
	JMenuItem italicmenu = new JMenuItem("б��");
	JMenuItem backmenu = new JMenuItem("��ԭ");
	JMenu  wordsizemenu = new JMenu("�ֺ�");
	JMenuItem wordsize11 = new JMenuItem("11");
	JMenuItem wordsize12 = new JMenuItem("12");
	JMenuItem wordsize13 = new JMenuItem("13");
	JMenuItem wordsize14 = new JMenuItem("14");
	JMenuItem wordsize15 = new JMenuItem("15");
	
	
	
	
	JMenuItem aboutmenu = new JMenuItem("���ڼ��±�");

	public  void init() {
		/** �ļ��� */
		filemenu.add(openmenu);
		filemenu.add(savemenu);
		filemenu.add(closemenu);
		
		/** �༭�� */
		editMenu.add(copymenu);
		editMenu.add(pastemenu);
		
		/** ��ʽ�� */ 
		typefacemenu.add(overstrikingmenu);
		typefacemenu.add(underlinemenu);
		typefacemenu.add(italicmenu);
		typefacemenu.add(backmenu);
		formatMenu.add(typefacemenu);
		wordsizemenu.add(wordsize11);
		wordsizemenu.add(wordsize12);
		wordsizemenu.add(wordsize13);
		wordsizemenu.add(wordsize14);
		wordsizemenu.add(wordsize15);
		formatMenu.add(wordsizemenu);
		
		/** ������ */
		helpMenu.add(aboutmenu);
		
		
		
		bar.add(filemenu);
		bar.add(editMenu);
		bar.add(formatMenu);
		bar.add(seeMenu);
		bar.add(helpMenu);
			
		frame.add(bar,BorderLayout.NORTH);
		frame.add(area);	
		
		FrameUtil.initFrame(frame, 650, 600);
		
		/** ���ļ� */
		openmenu.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				FileDialog d = new FileDialog(new Frame(), "��ѡ���ļ�", FileDialog.LOAD);
				d.setVisible(true);
				File file = null;
				try {
					file = new File(d.getDirectory() + d.getFile());
				} catch (Exception e3) {
				}
				String str = "";
				String num = null;
				try (FileReader fread = new FileReader(file);
						BufferedReader bfreead = new BufferedReader(fread)){
					while ((num = bfreead.readLine()) !=null) {
						str += num + "\n";	
					}
					area.setText(str);
					
				} catch (FileNotFoundException e1) {
					System.err.println("δѡ���ļ�����");
				} catch (IOException e2) {
				}								
			}
		});
		/** �����ļ� */
		savemenu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String path = null;
				FileDialog filedialog = new FileDialog(frame, "��ѡ��Ҫ������ļ���", FileDialog.SAVE);
				filedialog.setVisible(true);
				path = filedialog.getDirectory();
				System.out.println(path);
				String name = null;
				if(path != null) {
					name = filedialog.getFile();
				}	
				try(FileWriter fw = new FileWriter(new File(path + "/" + name));
					BufferedWriter bfw = new BufferedWriter(fw)
						){
					bfw.write(area.getText().replaceAll("\n", "\r\n"));
					
				} catch (Exception e2) {
					// TODO: handle exception
				}			
			}
		});
		/**  �ر� */
		closemenu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		/** ����Ӵ�  */
		overstrikingmenu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				area.setFont(new Font("�Ӵ�",Font.BOLD, font));	
			}
		});
		/** �������  */
		underlinemenu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				area.setFont(new Font("��ϸ", Font.HANGING_BASELINE, font));			
			}
		});
		/**  ��б  */
		italicmenu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				area.setFont(new Font("б��", Font.ITALIC, font-1));	
				
			}
		});
		/**  ��ԭ  */ 
		backmenu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				area.setFont(new Font(null));	
			}
		});
		/**  �ֺ� */
		wordsize11.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				font = 11;
				area.setFont(new Font("", 0, font));	
				
			}
		});
		wordsize12.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						font = 12;
						area.setFont(new Font("", 0, font));	
						
					}
				});
		wordsize13.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				font = 13;
				area.setFont(new Font("", 0, font));	
				
			}
		});
		wordsize14.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				font = 14;
				area.setFont(new Font("", 0, font));	
				
			}
		});
		wordsize15.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				font = 15;
				area.setFont(new Font("", 0, font));
				
			}
		});
		
		/** ���� */
		copymenu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				copystr = area.getSelectedText();			
			}
		});
		/**  ճ�� */
		pastemenu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				StringBuffer str = new StringBuffer(area.getText());
				str.insert(mark, copystr);
				area.setText(str.toString());
				return ;
			}
		});
		/** ��ȡ���λ�� */
		area.addCaretListener(new CaretListener() {
			
			@Override
			public void caretUpdate(CaretEvent e) {
				mark = e.getMark();				
			}
		});
	
		
		
	}
	public static void main(String[] args) {
		new Experiment4_4().init();

	}

}
