import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class teat extends JFrame
{
    private final JLabel label1;
    private final JLabel label2;
    private final JLabel label3;
    private final JLabel label4;
    private final JLabel label5;
    private JTextField Field1,Field2,Field3,Field4;
    private JButton cButton;
    public teat()
    {

        super("Student information");
        setLayout(new FlowLayout());
        label1 = new JLabel("Student name:");
        add(label1);
        Field1 = new JTextField(5);
        add(Field1);
        label1.setToolTipText("studentA");

        Icon photo = new ImageIcon(getClass().getResource( "photo.gif"));
        label2 = new JLabel("Student photo:", photo,SwingConstants.RIGHT);
        label2.setHorizontalTextPosition(SwingConstants.LEFT);
        //Icon photo = new ImageIcon(getClass().getResource( "photo.gif"));
        add(label2);

        label3 = new JLabel("Student number: ");
        label3.setToolTipText("123456");
        add(label3);
        Field2 = new JTextField(5);
        add(Field2);

        label4 = new JLabel("major:");
        add(label4);
        Field3 = new JTextField(10);
        add(Field3);
        //label4.setHorizontalTextPosition(SwingConstants.CENTER);
        label5 = new JLabel("Student Age: ");
        add(label5);
        Field4 = new JTextField(5);
        add(Field4);
        cButton = new JButton("提交");
        add(cButton);
        ActionEventHandler handler=new ActionEventHandler();
        cButton.addActionListener(handler);
    }
    static JFrame jf = new JFrame();
    public static void main(String[] args)
    {
        teat labelFrame = new teat();
        labelFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        labelFrame.setSize(200,250);
        labelFrame.setVisible(true);
        jf.setSize(200,250);
        jf.setLayout(new FlowLayout());

    }
    private class ActionEventHandler implements ActionListener{
        public void actionPerformed(ActionEvent event){
            if (event.getSource()== cButton){
                jf.setVisible(true);
                JLabel labelx;
                JLabel labelx2;
                JLabel labelx3;
                JLabel labelx4;
                JLabel labelx5;
                Icon photo2 = new ImageIcon(getClass().getResource( "photo.gif"));
                labelx=new JLabel("Student name: "+Field1.getText());
                jf.add(labelx);
                labelx5 = new JLabel("Student photo:", photo2,SwingConstants.RIGHT);
                labelx5.setHorizontalTextPosition(SwingConstants.LEFT);
                jf.add(labelx5);
                labelx2=new JLabel(" Student number: "+Field2.getText());
                jf.add(labelx2);
                labelx3=new JLabel(" Student major: "+Field3.getText());
                jf.add(labelx3);
                labelx4=new JLabel(" Student Age: "+Field4.getText());
                jf.add(labelx4);


            }

        }
    }
}