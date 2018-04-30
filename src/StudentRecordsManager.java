import java.awt.*;
import java.awt.event.*;
import java.util.GregorianCalendar;
import javax.swing.*;
import javax.swing.event.*;


public class StudentRecordsManager  {
   StudentList myList;

    public static void main(String[] Args){
      final StudentList list=new StudentList();
       String labels[]={"ID","First Name","Last Name","Gender","DOB","Major","GPA"};
     final JFrame myWindow = new JFrame("447 Project");
        FlowLayout layoutForbottomMenu=new FlowLayout();
        JPanel bottomMenu=new JPanel();
        final JTextField positon=new JTextField();
        final JTextField studentDetails[]=new JTextField[5];
        bottomMenu.setLayout(layoutForbottomMenu);
        myWindow.add(bottomMenu,BorderLayout.SOUTH);
        final JButton create=new JButton("Create List at :");
        final JButton select=new JButton("Import List");
        final JButton end=new JButton("End");
        JPanel topPanel=new JPanel();
        topPanel.setLayout(new BorderLayout());
         JPanel addPanel = new JPanel();
       final JPanel detailViewer = new JPanel();
        final GridLayout dl=new GridLayout(1,7);
       detailViewer.setLayout(dl);
       topPanel.add(detailViewer,BorderLayout.CENTER);
       for(int i=0;i<7;i++) {
          detailViewer.add(new JLabel(labels[i]));

       }
       topPanel.add(addPanel,BorderLayout.EAST);
        addPanel.setBackground(Color.WHITE);
      addPanel.setLayout(new GridLayout(8,1,5,5));
       for(int i=0;i<3;i++) {
          studentDetails[i] = new JTextField(10);
            JLabel temp=new JLabel(labels[i]+": ");
            temp.setHorizontalAlignment(SwingConstants.RIGHT);
          addPanel.add(temp);
      addPanel.add(studentDetails[i]);
       }

       final JComboBox jComboBox=new JComboBox();
        jComboBox.addItem("Male");

        final date date=new date();
        jComboBox.addItem("Female");
        {

            JLabel temp=new JLabel(labels[3]+": ");
            temp.setHorizontalAlignment(SwingConstants.RIGHT);
        addPanel.add(temp);
        addPanel.add(jComboBox);

        temp=new JLabel(labels[4]+": ");
        temp.setHorizontalAlignment(SwingConstants.RIGHT);
        addPanel.add(temp);
        }
        addPanel.add(date);
       for(int i=3;i<5;i++) {
          studentDetails[i] = new JTextField(10);
           JLabel temp=new JLabel(labels[i+2]+": ");
            temp.setHorizontalAlignment(SwingConstants.RIGHT);
          addPanel.add(temp);
      addPanel.add(studentDetails[i]);
       }
       addPanel.add(create);
        addPanel.add(positon);
       myWindow.add(topPanel,BorderLayout.NORTH);

       ActionListener buttonListener=new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
             if(e.getSource()==create) {
                 try {
                     char g;
                     if(jComboBox.getSelectedIndex()==0)
                         g='M';
                     else
                         g='F';
                     Student s = new Student(Long.parseLong(studentDetails[0].getText()), studentDetails[1].getText(), studentDetails[2].getText(), g, date.getdate(), studentDetails[3].getText(), Float.parseFloat(studentDetails[4].getText()));
                     boolean x=list.addStudentAt(s,Integer.parseInt(positon.getText()));
                     if(x==true)
                     {dl.setRows(dl.getRows()+1);
                     detailViewer.add(new JLabel(String.valueOf(s.getStdId())));
                     detailViewer.add(new JTextField(s.getFirstName()));
                     detailViewer.add(new JTextField(s.getLastName()));
                     detailViewer.add(new JTextField(String.valueOf(s.getGender())));
                     detailViewer.add(new JTextField(date.getDay()+"/"+date.getMonth()+"/"+date.getYear()));
                     detailViewer.add(new JTextField(s.getMajor()));
                     detailViewer.add(new JTextField(String.valueOf(s.getGpa())));
                     myWindow.pack();}
                     else
                         JOptionPane.showMessageDialog(null,"either the list is full or student is already in list");
                 } catch (InvalidGpaException e1) {
                     e1.printStackTrace();
                 } catch (NumberFormatException e1) {
                     e1.printStackTrace();
                 }
             }
              else
             if(e.getSource()==select){

             }
              else
             if(e.getSource()==end){
                 //todo
                 list.SaveToFile("abc");
                 System.exit(0);
             }
          }
       };
        bottomMenu.add(select);
        bottomMenu.add(end);
        myWindow.setSize(500,300);
        myWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myWindow.setVisible(true);
       create.addActionListener(buttonListener);
       end.addActionListener(buttonListener);
    }
}
