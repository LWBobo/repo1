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
	static int font = 12; //字体大小
	static String copystr = null; //复制
	public int mark = 0; //粘贴
	JFrame frame = new JFrame("记事本");
	JMenuBar bar = new JMenuBar();
	JMenu filemenu = new JMenu("文件");
	JMenu editMenu = new JMenu("编辑");
	JMenu formatMenu = new JMenu("格式");
	JMenu seeMenu = new JMenu("查看");
	JMenu helpMenu = new JMenu("帮助");
	
	JTextArea area = new JTextArea(20,30);
	
	/** 文件栏 */
	JMenuItem openmenu = new JMenuItem("打开");
	JMenuItem savemenu = new JMenuItem("保存");
	JMenuItem closemenu = new JMenuItem("关闭");
	/** 编辑栏 */
	JMenuItem copymenu = new JMenuItem("复制");
	JMenuItem pastemenu = new JMenuItem("粘贴");
	/** 格式栏 */
	JMenu  typefacemenu = new JMenu("字体");
	JMenuItem overstrikingmenu = new JMenuItem("加粗");
	JMenuItem underlinemenu = new JMenuItem("模糊");
	JMenuItem italicmenu = new JMenuItem("斜体");
	JMenuItem backmenu = new JMenuItem("还原");
	JMenu  wordsizemenu = new JMenu("字号");
	JMenuItem wordsize11 = new JMenuItem("11");
	JMenuItem wordsize12 = new JMenuItem("12");
	JMenuItem wordsize13 = new JMenuItem("13");
	JMenuItem wordsize14 = new JMenuItem("14");
	JMenuItem wordsize15 = new JMenuItem("15");
	
	
	
	
	JMenuItem aboutmenu = new JMenuItem("关于记事本");

	public  void init() {
		/** 文件栏 */
		filemenu.add(openmenu);
		filemenu.add(savemenu);
		filemenu.add(closemenu);
		
		/** 编辑栏 */
		editMenu.add(copymenu);
		editMenu.add(pastemenu);
		
		/** 格式栏 */ 
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
		
		/** 帮助栏 */
		helpMenu.add(aboutmenu);
		
		
		
		bar.add(filemenu);
		bar.add(editMenu);
		bar.add(formatMenu);
		bar.add(seeMenu);
		bar.add(helpMenu);
			
		frame.add(bar,BorderLayout.NORTH);
		frame.add(area);	
		
		FrameUtil.initFrame(frame, 650, 600);
		
		/** 打开文件 */
		openmenu.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				FileDialog d = new FileDialog(new Frame(), "请选择文件", FileDialog.LOAD);
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
					System.err.println("未选择文件！！");
				} catch (IOException e2) {
				}								
			}
		});
		/** 保存文件 */
		savemenu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String path = null;
				FileDialog filedialog = new FileDialog(frame, "请选择要保存的文件夹", FileDialog.SAVE);
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
		/**  关闭 */
		closemenu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		/** 字体加粗  */
		overstrikingmenu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				area.setFont(new Font("加粗",Font.BOLD, font));	
			}
		});
		/** 字体变轻  */
		underlinemenu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				area.setFont(new Font("变细", Font.HANGING_BASELINE, font));			
			}
		});
		/**  倾斜  */
		italicmenu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				area.setFont(new Font("斜体", Font.ITALIC, font-1));	
				
			}
		});
		/**  还原  */ 
		backmenu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				area.setFont(new Font(null));	
			}
		});
		/**  字号 */
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
		
		/** 复制 */
		copymenu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				copystr = area.getSelectedText();			
			}
		});
		/**  粘贴 */
		pastemenu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				StringBuffer str = new StringBuffer(area.getText());
				str.insert(mark, copystr);
				area.setText(str.toString());
				return ;
			}
		});
		/** 获取光标位置 */
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
