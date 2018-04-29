import java.awt.*;
import java.awt.event.*;
import java.util.GregorianCalendar;
import javax.swing.*;
import javax.swing.event.*;


public class StudentRecordsManager  {
   StudentList myList;

    public static void main(String[] Args){
      StudentList list=new StudentList();
       String labels[]={"ID","First Name","Last Name","Gender","DOB","Major","GPA"};
     JFrame myWindow = new JFrame("447 Project");
        FlowLayout layoutForbottomMenu=new FlowLayout();
        JPanel bottomMenu=new JPanel();
        JTextField studentDetails[]=new JTextField[7];
        bottomMenu.setLayout(layoutForbottomMenu);
        myWindow.add(bottomMenu,BorderLayout.SOUTH);
        JButton create=new JButton("Create List");
        JButton select=new JButton("Import List");
        JButton end=new JButton("End");
        JPanel topPanel=new JPanel();
        topPanel.setLayout(new BorderLayout());
         JPanel addPanel = new JPanel();
       JPanel detailViewer = new JPanel();
       detailViewer.setLayout(new GridLayout(1,7));
       topPanel.add(detailViewer,BorderLayout.CENTER);
       for(int i=0;i<7;i++) {
          detailViewer.add(new JLabel(labels[i]));

       }
       topPanel.add(addPanel,BorderLayout.SOUTH);
      addPanel.setLayout(new GridLayout(1,15));
       for(int i=0;i<7;i++) {
          studentDetails[i] = new JTextField(10);
            JLabel temp=new JLabel(labels[i]+": ");
            temp.setHorizontalAlignment(SwingConstants.RIGHT);
          addPanel.add(temp);
      addPanel.add(studentDetails[i]);
       }
       addPanel.add(create);
       myWindow.add(topPanel,BorderLayout.NORTH);

       ActionListener buttonListener=new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
             switch(e.getActionCommand()){
                case "Create List":
                   try {
                      Student s=new Student(Long.parseLong(studentDetails[0].getText()),studentDetails[1].getText(),studentDetails[2].getText(),studentDetails[3].getText().charAt(0),new GregorianCalendar(),studentDetails[5].getText(),Float.parseFloat(studentDetails[6].getText()));
                      list.addStudentEnd(s);

                      detailViewer.add(new JLabel("kuhy"));
                      detailViewer.add(new JLabel("kuhy"));
                      detailViewer.add(new JLabel("kuhy"));
                      detailViewer.add(new JLabel("kuhy"));
                      detailViewer.add(new JLabel("kuhy"));
                      detailViewer.add(new JLabel("kuhy"));
                      detailViewer.add(new JLabel("kuhy"));
                   } catch (InvalidGpaException e1) {
                      e1.printStackTrace();
                   }
                   catch (NumberFormatException e1) {
                      e1.printStackTrace();
                   }

                   break;
                case "Import List":
                   break;
                case "End":
                   System.exit(0);
             }
          }
       };
        bottomMenu.add(select);
        bottomMenu.add(end);
        myWindow.setSize(300,300);
        myWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myWindow.setVisible(true);
       create.addActionListener(buttonListener);
    }
}
