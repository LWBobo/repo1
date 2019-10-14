package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Util.FrameUtil;
import entity.Score;
import entity.Student;
import util.DataManipulation;

public class ChangeStuInfo {
	public int index = -1;
	int textfilen = 5;
	public ChangeStuInfo(ArrayList<Student> stuarr) {
		JFrame frame = new JFrame("学生信息修改");
		JPanel panle = new JPanel();
		JLabel oldidlab = new JLabel("旧学号");
		JLabel newidlab = new JLabel("新学号");
		JLabel namelab = new JLabel("姓名");
		JLabel sexlab = new JLabel("性别");
		JLabel agelab = new JLabel("年龄");
		JLabel currentlab = new JLabel("是否应届");
		JLabel mathlab = new JLabel("数学");
		JLabel politlab = new JLabel("外语");
		JLabel foreilab = new JLabel("政治");
		JLabel profelab = new JLabel("基础专业");
		JLabel totallab = new JLabel("总分");
		JLabel applyinglab = new JLabel("报考专业");
		
		JTextField oldidtext = new JTextField(textfilen+5);
		
		JTextField newidtext = new JTextField(textfilen+5);
		JTextField nametext = new JTextField(textfilen);
//		nametext.setText(stuarr.get(index).getName());
		JTextField sextext = new JTextField(textfilen);
//		sextext.setText(stuarr.get(index).getSex());
		JTextField agetext = new JTextField(textfilen);
//		agetext.setText(stuarr.get(index).getAge()+"");
		JTextField currenttext = new JTextField(textfilen);
//		currenttext.setText(stuarr.get(index).getCurrent());
		JTextField totaltext = new JTextField(textfilen);
//		totaltext.setText(stuarr.get(index).getScore().getTotalscores()+"");
		JTextField mathtext = new JTextField(textfilen);
//		mathtext.setText(stuarr.get(index).getScore().getMathscores()+"");
		JTextField polittext = new JTextField(textfilen);
//		polittext.setText(stuarr.get(index).getScore().getPoliticsscores()+"");
		JTextField foreitext = new JTextField(textfilen);
//		foreitext.setText(stuarr.get(index).getScore().getForeignlanguagescores()+"");
		JTextField pofetext = new JTextField(textfilen);
//		pofetext.setText(stuarr.get(index).getScore().getProfessionalbasiccoursescores()+"");
		currenttext.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(currenttext.getText().equals("是") || currenttext.getText().equals("否")) {
					
				}else {
					JOptionPane.showMessageDialog(frame, "请输入‘是’或者‘否’！", "错误提示",JOptionPane.ERROR_MESSAGE);
					currenttext.setText(stuarr.get(index).getCurrent());
				}
				
			}
		});
		mathtext.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(DataManipulation.isLeagleScore(mathtext.getText())) {
					int num = Integer.parseInt(mathtext.getText())+Integer.parseInt(polittext.getText())
					+Integer.parseInt(foreitext.getText())+Integer.parseInt(pofetext.getText());
					totaltext.setText(num+"");	
				}else {
					JOptionPane.showMessageDialog(frame, "请输入合法数字！", "错误提示",JOptionPane.ERROR_MESSAGE);
					mathtext.setText(stuarr.get(index).getScore().getMathscores()+"");
				}
				
			}
		});
			polittext.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							if(DataManipulation.isLeagleScore(polittext.getText())) {
								int num = Integer.parseInt(mathtext.getText())+Integer.parseInt(polittext.getText())
								+Integer.parseInt(foreitext.getText())+Integer.parseInt(pofetext.getText());
								totaltext.setText(num+"");	
							}else {
								JOptionPane.showMessageDialog(frame, "请输入合法数字！", "错误提示",JOptionPane.ERROR_MESSAGE);
								polittext.setText(stuarr.get(index).getScore().getPoliticsscores()+"");
							}
							
						}
					});
			foreitext.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if(DataManipulation.isLeagleScore(foreitext.getText())) {
						int num = Integer.parseInt(mathtext.getText())+Integer.parseInt(polittext.getText())
						+Integer.parseInt(foreitext.getText())+Integer.parseInt(pofetext.getText());
						totaltext.setText(num+"");	
					}else {
						JOptionPane.showMessageDialog(frame, "请输入合法数字！", "错误提示",JOptionPane.ERROR_MESSAGE);
						foreitext.setText(stuarr.get(index).getScore().getForeignlanguagescores()+"");
					}
					
				}
			});
			pofetext.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if(DataManipulation.isLeagleScore(pofetext.getText())) {
						int num = Integer.parseInt(mathtext.getText())+Integer.parseInt(polittext.getText())
						+Integer.parseInt(foreitext.getText())+Integer.parseInt(pofetext.getText());
						totaltext.setText(num+"");	
					}else {
						JOptionPane.showMessageDialog(frame, "请输入合法数字！", "错误提示",JOptionPane.ERROR_MESSAGE);
						pofetext.setText(stuarr.get(index).getScore().getProfessionalbasiccoursescores()+"");
					}
					
				}
			});
		JTextField applyingtext = new JTextField(textfilen+15);
		
		oldidtext.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(DataManipulation.isLeagleId(oldidtext.getText())) {
					for(int i = 0;i <stuarr.size();++i) {
						if(oldidtext.getText().equals(stuarr.get(i).getID())) {
							index = i;
						}
					}
					if(index >= 0) {
						nametext.setText(stuarr.get(index).getName());
						sextext.setText(stuarr.get(index).getSex());
						agetext.setText(stuarr.get(index).getAge()+"");
						currenttext.setText(stuarr.get(index).getCurrent());
						mathtext.setText(stuarr.get(index).getScore().getMathscores()+"");
						polittext.setText(stuarr.get(index).getScore().getPoliticsscores()+"");
						foreitext.setText(stuarr.get(index).getScore().getForeignlanguagescores()+"");
						pofetext.setText(stuarr.get(index).getScore().getProfessionalbasiccoursescores()+"");
						totaltext.setText(stuarr.get(index).getScore().getTotalscores()+"");
						applyingtext.setText(stuarr.get(index).getApplyingmajor());
					}else {
						JOptionPane.showMessageDialog(frame, "学号输入有误！", "错误提示",JOptionPane.ERROR_MESSAGE);
						oldidtext.setText("");
					}	
				}else {
					JOptionPane.showMessageDialog(frame, "学号为12位数字！", "错误提示",JOptionPane.ERROR_MESSAGE);
					oldidtext.setText("");
				}
				
			}
		});
		
		newidtext.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(DataManipulation.isLeagleId(newidtext.getText())) {
					for (int i = 0; i < stuarr.size(); i++) {
						if(newidtext.getText().equals(stuarr.get(i).getID())) {
							JOptionPane.showMessageDialog(frame, "学号已经存在！", "错误提示",JOptionPane.ERROR_MESSAGE);
							newidtext.setText("");
							break;
						}
					}
				}else {
					JOptionPane.showMessageDialog(frame, "学号为12位数字！", "错误提示",JOptionPane.ERROR_MESSAGE);
					newidtext.setText("");
				}
				
			}
		});
		
		JButton savebut = new JButton("确定");
		savebut.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Score score = new Score(Integer.parseInt(mathtext.getText()), Integer.parseInt(polittext.getText()), Integer.parseInt(foreitext.getText()), Integer.parseInt(pofetext.getText()));
				Student stu = new Student(nametext.getText(), Integer.parseInt(agetext.getText()), sextext.getText(), newidtext.getText(), score, currenttext.getText(), applyingtext.getText());
				if(DataManipulation.changestuinfoindb(stu,oldidtext.getText())) {
					if(stu.getID().equals("")) {
						stu.setID(oldidtext.getText());
					}
					stuarr.set(index, stu);
					JOptionPane.showMessageDialog(null, "修改成功！");
					frame.setVisible(false);
					frame.dispose();
				}
			}
		});
		
		panle.add(oldidlab);panle.add(oldidtext);
		panle.add(newidlab);panle.add(newidtext);
		panle.add(namelab);panle.add(nametext);
		panle.add(sexlab);panle.add(sextext);
		panle.add(agelab);panle.add(agetext);
		panle.add(currentlab);panle.add(currenttext);
		panle.add(mathlab);panle.add(mathtext);
		panle.add(politlab);panle.add(polittext);
		panle.add(foreilab);panle.add(foreitext);
		panle.add(profelab);panle.add(pofetext);
		panle.add(totallab);panle.add(totaltext);
		panle.add(applyinglab);panle.add(applyingtext);
		panle.add(savebut);
		
		
		frame.add(panle);
		FrameUtil.initFrame(frame, 420, 200);
	}
}
