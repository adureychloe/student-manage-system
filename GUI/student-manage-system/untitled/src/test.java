

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Random;
import javax.swing.JTable;
import javax.swing.table.TableColumn;


public class test extends  JFrame  {
    public static int n=6;
    public static void main(String[] args) {
        info[] a = new info[100];
        for(int i=0;i<a.length;i++)
            a[i]=new info();
        a[0].name = "Jack";
        a[1].name = "Rihanna";
        a[2].name = "Vita";
        a[3].name = "Furian";
        a[4].name = "Kathy";
        a[5].name = "Dan";
        for (int i = 0; i < n; i++) {
            a[i].number = String.format("172712%d%d", i, i);
        }
        Random rand = new Random();
        for (int j = 0; j < n; j++) {
            a[j].birthdate = String.format("%d年%d月%d日", 1998, rand.nextInt(12) + 1, rand.nextInt(28) + 1);
        }
        int size = 4;
        JButton jbs[] = new JButton[size];
        JPanel jp1, jp2, jp3, jp4, jp5, jp6, jp7;
        JLabel jlb1, jlb2, jlb3, jlb4, jlb5;
        JButton jb1;
        JTextField jtf1;
        JSplitPane jsp1, jsp2, jsp3;
        JTextArea tea = new JTextArea(6, 20);
        JFrame jf=new JFrame();
        jbs[0] = new JButton("查看个人信息");
        jbs[1] = new JButton("修改个人信息");
        jbs[2] = new JButton("添加新学生");
        jbs[3] = new JButton("数据排序输出");

        jp1 = new JPanel();
        jp2 = new JPanel();
        jp3 = new JPanel();
        jp4 = new JPanel();
        jp5 = new JPanel();
        jp6 = new JPanel();
        jp7 = new JPanel();


        jlb1 = new JLabel("请输入要查询的学生学号");
        jlb1.setFont(new Font("宋体", Font.PLAIN, 30));
        jlb2 = new JLabel(new ImageIcon("images/cat.jpg"));
        jlb3 = new JLabel("姓名");
        jlb4 = new JLabel("学号");
        jlb5 = new JLabel("出生日期");
        jlb3.setFont(new Font("宋体", Font.PLAIN, 30));
        jlb4.setFont(new Font("宋体", Font.PLAIN, 30));
        jlb5.setFont(new Font("宋体", Font.PLAIN, 30));

        jb1 = new JButton(("查询"));


        jtf1 = new JTextField(15);

        jsp1 = new JSplitPane(JSplitPane.VERTICAL_SPLIT, jp3, jp1);
        jsp2 = new JSplitPane(JSplitPane.VERTICAL_SPLIT, jp2, jp4);
        jsp3 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, jsp1, jsp2);

        jsp1.setOneTouchExpandable(true);
        jsp2.setOneTouchExpandable(true);
        jsp3.setOneTouchExpandable(true);

        jp1.setLayout(new GridLayout(4, 1, 10, 10));
        jp2.setLayout(new GridLayout(2, 1, 5, 0));
        jp2.setSize(20, 20);

        for (int i = 0; i < size; i++) {
            jp1.add(jbs[i]);
        }

        jp5.add(jlb1);
        jp6.add(jtf1);
        jp6.add(jb1);
        jp2.add(jp5);
        jp2.add(jp6);
        jp3.add(jlb2);
        jp7.add(jlb3);
        jp7.add(jlb4);
        jp7.add(jlb5);
        jp4.add(jp7);
        jp4.add(tea);
        jf.add(jsp3);

        jb1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String str;
                for(int i=0;i<n;i++){
                    if(a[i].number.equals((jtf1.getText()))){
                        str=String.format("姓名为：%s;学号为%s;出生日期为%s", a[i].name,a[i].number,a[i].birthdate);
                        tea.append(str+"\n");
                    }
                }
            }
        });

        jbs[1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showEdit(jf,a);
            }
        });

        jbs[2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showAdd(jf,a);
            }
        });

        jbs[3].addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                showInput(jf,a);
            }
        });

        jf.setTitle("学生考勤系统");
        jf.setSize(700, 900);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
    }

    private static void showEdit(Frame jf,info []a){
        final JDialog edit=new JDialog(jf,"修改",true);
        edit.setSize(400,350);

        JLabel jlb1 =new JLabel("请输入要修改的学生学号：");
        JTextField jtf1=new JTextField(15);
        JLabel jlb2=new JLabel("更改为：");
        JTextField jtf2,jtf3,jtf4;

        jtf2=new JTextField(8);
        jtf3=new JTextField(15);
        jtf4=new JTextField(18);

        JButton jb1=new JButton("确定");
        JButton jb2=new JButton("取消");

        jb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(int i=0;i<n;i++){
                    if(a[i].number.equals((jtf1.getText()))) {
                        a[i].name=jtf2.getText();
                        a[i].number=jtf3.getText();
                        a[i].birthdate=jtf4.getText();
                    }
                }
                JOptionPane.showMessageDialog(null,"修改成功！");
            }
        });

        jb2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                edit.dispose();
            }
        });

        JPanel jp1,jp2,jp3,jp4;
        jp1=new JPanel();
        jp2=new JPanel();
        jp3=new JPanel();
        jp4=new JPanel();

        jp1.add(jlb1);
        jp1.add(jtf1);
        jp2.add(jlb2);
        jp2.add(jtf2);
        jp2.add(jtf3);
        jp2.add(jtf4);
        jp3.add(jb1);
        jp3.add(jb2);
        jp4.setLayout(new GridLayout(3,1));
        jp4.add(jp1);
        jp4.add(jp2);
        jp4.add(jp3);

        edit.setContentPane(jp4);
        edit.setVisible(true);
    }

    private static void showAdd(Frame jf,info []a){
        JDialog add=new JDialog(jf,"添加",true);
        add.setSize(350,250);

        JLabel jlb1=new JLabel("请输入要添加的学生信息");

        JPanel jp1=new JPanel();
        JPanel jp2=new JPanel();
        JPanel jp3=new JPanel();

        JTextField jtf1,jtf2,jtf3;

        jtf1=new JTextField(8);
        jtf2=new JTextField(12);
        jtf3=new JTextField(12);

        JButton jb1=new JButton("确定");
        JButton jb2=new JButton("取消");

        jb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                a[n].name=jtf1.getText();
                a[n].number=jtf2.getText();
                a[n].birthdate=jtf3.getText();
                n++;
                JOptionPane.showMessageDialog(null,"添加成功！");
            }

        });

        jb2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                add.dispose();
            }
        });

        jp1.add(jtf1);
        jp1.add(jtf2);
        jp1.add(jtf3);
        jp3.add(jb1);
        jp3.add(jb2);
        jp2.setLayout(new GridLayout(2,1));
        jp2.add(jlb1);
        jp2.add(jp1);
        jp2.add(jp3);

        add.setContentPane(jp2);
        add.setVisible(true);
    }

    private static void showInput(Frame jf,info[] a){
        for(int i=1;i<n;i++) {
            String temp;
            int i1=a[i].number.compareTo(a[i-1].number);
            if(i1<0) {
                temp=a[i].name;
                a[i].name=a[i-1].name;
                a[i-1].name=temp;
            }
        }
        JDialog input=new JDialog(jf,"数据排序输出",true);
        JTextArea jtf=new JTextArea(40,40);
        jtf.setFont(new Font("宋体", Font.PLAIN, 30));
        for(int i=0;i<n;i++){
            jtf.append(a[i].name+"    "+a[i].number+"    "+a[i].birthdate+"\n");
        }
        input.setSize(600,620);
        input.setContentPane(jtf);
        input.setVisible(true);
        }
}


    class info {
        String name;
        String number;
        String birthdate;
    }
















