package Hospital.management.system;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    //we have to declare JTextField globally for enter the text
    //1.
    JTextField textField;

    //2.
    JPasswordField jPasswordField;

    //3.for button we have to declared it globally
    JButton b1,b2;

    Login() {
        //1.
        JLabel namelabel=new JLabel("Username");
        //set name position
        namelabel.setBounds(40,20,100,30);
        //now for font style
        namelabel.setFont(new Font("Tahoma",Font.BOLD,16));
        namelabel.setForeground(Color.BLACK);
        // now lebel is ready then we have to add it on the frame
        add(namelabel);


        //2. this is for password portion
        JLabel password=new JLabel("Password");
        password.setBounds(40,60,100,30);// change value of setBounds for password position
        password.setFont(new Font("Tahoma",Font.BOLD,16));
        password.setForeground(Color.BLACK);
        add(password);


        //3. Now i added textField for input text
        textField =new JTextField();
        textField.setBounds(150,20,150,30);
        textField.setFont(new Font("Tahoma",Font.PLAIN,15));
        textField.setBackground(new Color(255,179,0));
        add(textField);

        //4.Now i added for password input section
        jPasswordField =new JPasswordField();
        jPasswordField.setBounds(150,60,150,30);
        jPasswordField.setFont(new Font("Tahoma",Font.PLAIN,15));
        jPasswordField.setBackground(new Color(255,179,0));
        add(jPasswordField);

        //5.for adding icon we have  //not understandable so much
        ImageIcon imageIcon=new ImageIcon(ClassLoader.getSystemResource("icon/login.png"));
        Image i1=imageIcon.getImage().getScaledInstance(500,500,Image.SCALE_DEFAULT);
        //now i will add the image to frame
        ImageIcon imageIcon1=new ImageIcon(i1);
        JLabel label=new JLabel(imageIcon1);
        label.setBounds(320,-80,400,300);
        add(label);

        //6.Now we have to set bottons
        b1 =new JButton("Login");
        b1.setBounds(40,140,120,30);
        b1.setFont(new Font("serif",Font.BOLD,15));
        b1.setBackground(Color.red);
        b1.setForeground(Color.white);
        b1.addActionListener(this);
        add(b1);

        //7 for cancel button
        b2 =new JButton("Cancel");
        b2.setBounds(180,140,120,30);
        b2.setFont(new Font("serif",Font.BOLD,15));
        b2.setBackground(Color.red);
        b2.setForeground(Color.white);
        b2.addActionListener(this);
        add(b2);



        getContentPane().setBackground(new Color(109,164,170));
        //1.//i ll set size
        setSize(750,300);
        setLocation(325,325); // it set the location of the layout in centre
        setLayout(null);
        setVisible(true);// it is true because by default the visibility of JFrame is hidden
        // don't write any thing below the setVisibility Otherwise it wont visible
    }

    public static void main(String[] args) {
    new Login();
    }

    //connection with data base wala video 3 number
    @Override
    public void actionPerformed(ActionEvent e) {
        //if click on b1 button then if block will run and if click on b2 then else will run
        if(e.getSource()==b1){
            //there may be exceptions
            try{
                connection c=new connection();
                String user=textField.getText();  // whatever password and text will be entered will be saved
                String pass=jPasswordField.getText(); //in this user and pass variables
                //now we have to match this with the id and password that are saved in the database

                String q="select * from login where ID = '"+user+"' and pw ='"+pass+"'";  //it is a query that
                // will help in matching id and password with database
                ResultSet resultSet=c.statement.executeQuery(q);

                //it is for checking data is available or not
                if(resultSet.next()){
                    new Reception();
                    setVisible(false);
                }
                else{
                    JOptionPane.showMessageDialog(null,"Invalid");
                }
            }
            catch(Exception E){
                E.printStackTrace();
            }
        }
        //if clicked on b2 the else condition wll be executed
        else{
            System.exit(10);
        }
    }

}
