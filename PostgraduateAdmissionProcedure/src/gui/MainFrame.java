package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.AncestorListener;

import Util.FrameUtil;
import dao.DataKit;
import entity.Student;
import entity.Teacher;
import util.DataManipulation;

public class MainFrame {
	
	JFrame frame ;
	JPanel panle ;
	JLabel usernamelab ;
	JLabel usersexlab;
	JTextField usernametext;
	JTextField usersextext;
	String stype;
	static Properties pros = null;
	 Set<Student> stuset = null;
	static {
		pros = new Properties();
		try {
			pros.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("scoreline_cofg.properties"));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public MainFrame(int index,ArrayList<Teacher> tea,ArrayList<Student> stu) {
				
		JTextArea stuinfoarea = new JTextArea(17, 60);
		stuinfoarea.setEditable(false);
//		stuinfoarea.setBackground(Color.gray);
		/** 	设置滚动条              */
		JScrollPane js=new JScrollPane(stuinfoarea);
		js.setHorizontalScrollBarPolicy(
		JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		js.setVerticalScrollBarPolicy(
		JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		
		frame = new JFrame("研究生初试录取程序");
		panle = new JPanel();
		usernamelab = new JLabel("用户名");
		usernametext = new JTextField(5);
		usernametext.setText(tea.get(index).getName());
		usernametext.setEditable(false);
		panle.add(usernamelab);
		panle.add(usernametext);
		
		usersexlab = new JLabel("性别");
		usersextext = new JTextField(tea.get(index).getSex(), 3);
		usersextext.setEditable(false);
		panle.add(usersexlab);
		panle.add(usersextext);
		
		JLabel researchdirectionlab = new JLabel("研究方向");
		JTextField researchdirectiontext = new JTextField(35);
		researchdirectiontext.setText(tea.get(index).getCourse());
		researchdirectiontext.setEditable(false);
		panle.add(researchdirectionlab);
		panle.add(researchdirectiontext);
		
		JLabel scorseline = new JLabel("分数线");
		JLabel mathlab = new JLabel("数学");
		JTextField mathtext = new JTextField(3);
		JLabel politlab = new JLabel("政治");
		JTextField polittext = new JTextField(3);
		JLabel foreilab = new JLabel("外语");
		JTextField foreitext = new JTextField(3);
		JLabel profelab = new JLabel("专业基础课");
		JTextField profetext = new JTextField(3);
		JLabel totallab = new JLabel("总分");
		JTextField totaltext = new JTextField(3);
		
		mathtext.setText(pros.getProperty("mathscoresline"));
		polittext.setText(pros.getProperty("politicsscoresline"));
		foreitext.setText(pros.getProperty("foreignlanguagescoresline"));
		profetext.setText(pros.getProperty("professionalbasiccoursescoresline"));
		totaltext.setText(pros.getProperty("totalscoresline"));
		
		mathtext.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(DataManipulation.isLeagleScore(mathtext.getText())) {
					DataKit.changescoreline(Integer.parseInt(mathtext.getText()), Integer.parseInt(polittext.getText()), 
							Integer.parseInt(foreitext.getText()),
							Integer.parseInt(profetext.getText()), Integer.parseInt(totaltext.getText()));
					stuset = DataKit.selectstu(stu,stype);
					stuinfoarea.setText(settostring(stuset));	
				}else {
					JOptionPane.showMessageDialog(frame, "请输入合法数字！", "错误提示",JOptionPane.ERROR_MESSAGE);
					mathtext.setText(pros.getProperty("mathscoresline"));
				}
			}
		});
		polittext.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(DataManipulation.isLeagleScore(polittext.getText())) {
					DataKit.changescoreline(Integer.parseInt(mathtext.getText()), Integer.parseInt(polittext.getText()), 
							Integer.parseInt(foreitext.getText()),
							Integer.parseInt(profetext.getText()), Integer.parseInt(totaltext.getText()));
					stuset = DataKit.selectstu(stu,stype);
					stuinfoarea.setText(settostring(stuset));	
				}else {
					JOptionPane.showMessageDialog(frame, "请输入合法数字！", "错误提示",JOptionPane.ERROR_MESSAGE);
					polittext.setText(pros.getProperty("politicsscoresline"));
				}

			}
		});
		foreitext.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(DataManipulation.isLeagleScore(foreitext.getText())) {
					DataKit.changescoreline(Integer.parseInt(mathtext.getText()), Integer.parseInt(polittext.getText()), 
							Integer.parseInt(foreitext.getText()),
							Integer.parseInt(profetext.getText()), Integer.parseInt(totaltext.getText()));
					stuset = DataKit.selectstu(stu,stype);
					stuinfoarea.setText(settostring(stuset));	
				}else {
					JOptionPane.showMessageDialog(frame, "请输入合法数字！", "错误提示",JOptionPane.ERROR_MESSAGE);
					foreitext.setText(pros.getProperty("foreignlanguagescoresline"));
				}
			}
		});
		profetext.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(DataManipulation.isLeagleScore(profetext.getText())) {
					DataKit.changescoreline(Integer.parseInt(mathtext.getText()), Integer.parseInt(polittext.getText()), 
							Integer.parseInt(foreitext.getText()),
							Integer.parseInt(profetext.getText()), Integer.parseInt(totaltext.getText()));
					stuset = DataKit.selectstu(stu,stype);
					stuinfoarea.setText(settostring(stuset));	
				}else {
					JOptionPane.showMessageDialog(frame, "请输入合法数字！", "错误提示",JOptionPane.ERROR_MESSAGE);
					profetext.setText(pros.getProperty("professionalbasiccoursescoresline"));
				}
			}
		});
		totaltext.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(DataManipulation.isLeagleScore(totaltext.getText())) {
					DataKit.changescoreline(Integer.parseInt(mathtext.getText()), Integer.parseInt(polittext.getText()), 
							Integer.parseInt(foreitext.getText()),
							Integer.parseInt(profetext.getText()), Integer.parseInt(totaltext.getText()));
					stuset = DataKit.selectstu(stu,stype);
					stuinfoarea.setText(settostring(stuset));	
				}else {
					JOptionPane.showMessageDialog(frame, "请输入合法数字！", "错误提示",JOptionPane.ERROR_MESSAGE);
					totaltext.setText(pros.getProperty("totalscoresline"));
				}
			}
		});	
		
		panle.add(scorseline);
		panle.add(mathlab);
		panle.add(mathtext);
		panle.add(politlab);
		panle.add(polittext);
		panle.add(foreilab);
		panle.add(foreitext);
		panle.add(profelab);
		panle.add(profetext);
		panle.add(totallab);
		panle.add(totaltext);
		
		JLabel sortlab = new JLabel("排序方式");
		Object [] sorttype = {
				"数学","政治","外语","专业基础","总分"
		};
		JComboBox<Object> sortbox = new JComboBox<Object>(sorttype);
		sortbox.setSelectedIndex(4);
		sortbox.addItemListener(new ItemListener() {	
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(((String)e.getItem()).equals("数学")) {
					stuset = DataKit.selectstu(stu, "math");stype = "math";
				}else if(((String)e.getItem()).equals("政治")) {
					stuset = DataKit.selectstu(stu, "politics");stype = "politics";
				}else if(((String)e.getItem()).equals("外语")) {
					stuset = DataKit.selectstu(stu, "foreignlanguage");stype = "foreignlanguage";
				}else if(((String)e.getItem()).equals("专业基础")) {
					stuset = DataKit.selectstu(stu, "professionalbasiccourses");stype = "professionalbasiccourses";
				}else if(((String)e.getItem()).equals("总分")) {
					stuset = DataKit.selectstu(stu, "");stype = "total";
				}
				stuinfoarea.setText(settostring(stuset));
				
			}
		});
		
		panle.add(sortlab);
		panle.add(sortbox);	
		
		JButton showallbut = new JButton("显示全部同学");
		showallbut.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				stuset = DataKit.selectallstu(stu);
				stuinfoarea.setText(settostring(stuset));
			}
		});
		panle.add(showallbut);
		JButton changebut = new JButton("修改信息");
		changebut.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				 new ChangeStuInfo(stu);	
				
			}
		});
		panle.add(changebut);
		
		JButton savebut = new JButton("保存");
		savebut.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(DataManipulation.stuinfotofile(stuset)) {
					JOptionPane.showMessageDialog(frame, "保存成功！");
				}
				
			}
		});
		panle.add(savebut);
		
		panle.add(js);
		
		
		frame.add(panle);
		FrameUtil.initFrame(frame, 630, 450);
	}
	
	public String settostring(Set<Student> stuset) {
		String str = "姓名" + "\t" + "学号" + "\t\t" + "是否应届" + "\t" + "数学" + "\t" + "政治" + "\t" + "外语" + "\t" 
				+ "专业基础" + "\t" + "总分" + "\t" + "报考专业" + "\n";
		for(Student stu :stuset) {
			str += stu.toString() + "\n";
		}
		return str;
	}

}
