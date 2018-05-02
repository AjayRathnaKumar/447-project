import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.*;
import javax.swing.event.*;


public class StudentRecordsManager  {
   StudentList myList;
    static StudentList list=new StudentList();
    static GridLayout dl=new GridLayout(1,1);

    public static void main(String[] Args){

       final String labels[]={"ID","First Name","Last Name","Gender","DOB","Major","GPA"};
     final JFrame myWindow = new JFrame("447 Project");
        FlowLayout layoutForbottomMenu=new FlowLayout();
        JPanel bottomMenu=new JPanel();
        final JButton positon=new JButton("At at");
        final JTextField studentDetails[]=new JTextField[5];
        bottomMenu.setLayout(layoutForbottomMenu);
        myWindow.add(bottomMenu,BorderLayout.SOUTH);
        final JButton create=new JButton("Add");
        final JButton select=new JButton("Import List");
        final JButton end=new JButton("End");
        final JButton sort=new JButton("Sort");
        JPanel topPanel=new JPanel();
        topPanel.setLayout(new BorderLayout());
         JPanel addPanel = new JPanel();
       final JPanel detailViewer = new JPanel();
       detailViewer.setLayout(dl);
       topPanel.add(detailViewer,BorderLayout.CENTER);
      // JPanel header=new JPanel();
      // header.setLayout(new GridLayout(1,7));
       for(int i=0;i<7;i++) {
          detailViewer.add(new JLabel(labels[i]));

       }
       detailViewer.add(new Panel());
     //  topPanel.add(header,BorderLayout.NORTH);
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

        final JComboBox major=new JComboBox();
        major.addItem("IS");
        major.addItem("CS");
        major.addItem("CE");
        {
            JLabel temp=new JLabel(labels[5]+": ");
            temp.setHorizontalAlignment(SwingConstants.RIGHT);
            addPanel.add(temp);
        }
        addPanel.add(major);
       for(int i=3;i<4;i++) {
          studentDetails[i] = new JTextField(10);
           JLabel temp=new JLabel(labels[i+3]+": ");
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
                     Student s = new Student(Long.parseLong(studentDetails[0].getText()), studentDetails[1].getText(), studentDetails[2].getText(), g, date.getdate(), major.getSelectedItem().toString(), Float.parseFloat(studentDetails[3].getText()));
                     final int pos=list.size();
                     boolean x=list.addStudentEnd(s);
                     if(x==true)
                     {
                         if(s!=null) {
                             final JButton update=new JButton("Edit");
                             final JButton remove=new JButton("remove");
                             final JPanel upre=new JPanel();
                             upre.setLayout(new GridLayout(1,2));
                             upre.add(update);
                             upre.add(remove);
                             dl.setRows(dl.getRows() + 1);
                             final JTextField a= new JTextField(String.valueOf(s.getStdId()));
                             detailViewer.add(a);
                             final JTextField a1=new JTextField(s.getFirstName());
                             detailViewer.add(a1);
                             final JTextField a2=new JTextField(s.getLastName());
                             detailViewer.add(a2);
                             final JTextField a3=new JTextField(String.valueOf(s.getGender()));
                             detailViewer.add(a3);
                             final date a4=new date();
                             a4.setDay(date.getDay());
                             a4.setYear(date.getYear());
                             a4.setMonth(date.getMonth());
                             detailViewer.add(a4);
                             final JTextField a5=new JTextField(s.getMajor());
                             detailViewer.add(a5);
                             final JTextField a6=new JTextField(String.valueOf(s.getGpa()));
                             detailViewer.add(a6);
                             detailViewer.add(upre);
                             a.setEditable(false);
                             a1.setEditable(false);
                             a2.setEditable(false);
                             a3.setEditable(false);
                             a4.setEditable(false);
                             a5.setEditable(false);
                             a6.setEditable(false);
                             remove.addActionListener(new ActionListener() {
                                 @Override
                                 public void actionPerformed(ActionEvent e) {
                                     list.deleteStudentAt(pos);
                                     detailViewer.remove(a);
                                     detailViewer.remove(a1);
                                     detailViewer.remove(a2);
                                     detailViewer.remove(a3);
                                     detailViewer.remove(a4);
                                     detailViewer.remove(a5);
                                     detailViewer.remove(a6);
                                     detailViewer.remove(upre);
                                     dl.setRows(dl.getRows()-1);
                                     myWindow.pack();
                                 }
                             });
                             update.addActionListener(new ActionListener() {
                                 int stidToChange;
                                 boolean switch1=false;
                                 @Override
                                 public void actionPerformed(ActionEvent e) {
                                     if(switch1) {
                                         update.setText("Update");
                                         a.setEditable(true);
                                         a1.setEditable(true);
                                         a2.setEditable(true);
                                         a3.setEditable(true);
                                         a4.setEditable(true);
                                         a5.setEditable(true);
                                         a6.setEditable(true);
                                         switch1=!switch1;
                                         stidToChange=Integer.parseInt(a.getText());
                                     }
                                     else
                                     {
                                         a.setEditable(false);
                                         a1.setEditable(false);
                                         a2.setEditable(false);
                                         a3.setEditable(false);
                                         a4.setEditable(false);
                                         a5.setEditable(false);
                                         a6.setEditable(false);
                                         try {
                                             Student s=new Student(Integer.parseInt(a.getText()),a1.getText(),a2.getText(),a3.getText().charAt(0),a4.getdate(),a5.getText(),Float.parseFloat( a6.getText()));
                                             list.updateRecord(stidToChange,s);
                                         } catch (InvalidGpaException e1) {
                                             e1.printStackTrace();
                                         }

                                         switch1=!switch1;
                                     }
                                 }
                             });
                             myWindow.pack();
                         }}
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
                 detailViewer.removeAll();
                 dl=new GridLayout(1,8);
                 for(int i=0;i<7;i++) {
                     detailViewer.add(new JLabel(labels[i]));

                 }
                 detailViewer.add(new Panel());
                 detailViewer.setLayout(dl);
                 list = new StudentList("abc");

                 for(int i=0;i<list.size();i++)
                 {
                     final int ii=i;
                     final Student s= list.retrieveAt(i);
                     if(s!=null) {
                         final JButton update=new JButton("Edit");
                         final JButton remove=new JButton("remove");
                         final JPanel upre=new JPanel();
                         upre.setLayout(new GridLayout(1,2));
                         upre.add(update);
                         upre.add(remove);
                         dl.setRows(dl.getRows() + 1);
                         final JTextField a= new JTextField(String.valueOf(s.getStdId()));
                         detailViewer.add(a);
                         final JTextField a1=new JTextField(s.getFirstName());
                         detailViewer.add(a1);
                         final JTextField a2=new JTextField(s.getLastName());
                         detailViewer.add(a2);
                         final JTextField a3=new JTextField(String.valueOf(s.getGender()));
                         detailViewer.add(a3);
                         final date a4=new date();
                         a4.setDay((s.getBirthDate()).get(Calendar.DAY_OF_MONTH));
                         a4.setYear((s.getBirthDate()).get(Calendar.YEAR));
                         a4.setMonth((s.getBirthDate()).get(Calendar.MONTH));
                         detailViewer.add(a4);
                         final JTextField a5=new JTextField(s.getMajor());
                         detailViewer.add(a5);
                         final JTextField a6=new JTextField(String.valueOf(s.getGpa()));
                         detailViewer.add(a6);
                         detailViewer.add(upre);
                         a.setEditable(false);
                         a1.setEditable(false);
                         a2.setEditable(false);
                         a3.setEditable(false);
                         a4.setEditable(false);
                         a5.setEditable(false);
                         a6.setEditable(false);
                         remove.addActionListener(new ActionListener() {
                             @Override
                             public void actionPerformed(ActionEvent e) {
                                 list.deleteStudentAt(ii);
                                 detailViewer.remove(a);
                                 detailViewer.remove(a1);
                                 detailViewer.remove(a2);
                                 detailViewer.remove(a3);
                                 detailViewer.remove(a4);
                                 detailViewer.remove(a5);
                                 detailViewer.remove(a6);
                                 detailViewer.remove(upre);
                                 dl.setRows(dl.getRows()-1);
                                 myWindow.pack();
                             }
                         });
                         update.addActionListener(new ActionListener() {
                             int stidToChange;
                             boolean switch1=false;
                             @Override
                             public void actionPerformed(ActionEvent e) {
                                 if(switch1) {
                                     update.setText("Update");
                                     a.setEditable(true);
                                     a1.setEditable(true);
                                     a2.setEditable(true);
                                     a3.setEditable(true);
                                     a4.setEditable(true);
                                     a5.setEditable(true);
                                     a6.setEditable(true);
                                     switch1=!switch1;
                                     stidToChange=Integer.parseInt(a.getText());
                                 }
                                 else
                                 {
                                     update.setText("Edit");
                                     a.setEditable(false);
                                     a1.setEditable(false);
                                     a2.setEditable(false);
                                     a3.setEditable(false);
                                     a4.setEditable(false);
                                     a5.setEditable(false);
                                     a6.setEditable(false);
                                     try {
                                         Student s=new Student(Integer.parseInt(a.getText()),a1.getText(),a2.getText(),a3.getText().charAt(0),a4.getdate(),a5.getText(),Float.parseFloat( a6.getText()));
                                         list.updateRecord(stidToChange,s);
                                     } catch (InvalidGpaException e1) {
                                         e1.printStackTrace();
                                     }

                                     switch1=!switch1;
                                 }
                             }
                         });
                         myWindow.pack();
                     }
                 }


             }
             else
                 if(e.getSource()==sort){
                 list.sortByStdId();
                     detailViewer.removeAll();
                     dl=new GridLayout(1,8);
                     for(int i=0;i<7;i++) {
                         detailViewer.add(new JLabel(labels[i]));

                     }
                     detailViewer.add(new Panel());
                     detailViewer.setLayout(dl);
                     for(int i=0;i<list.size();i++)
                     {
                         final int ii=i;
                         final Student s= list.retrieveAt(i);
                         if(s!=null) {
                             final JButton update=new JButton("Edit");
                             final JButton remove=new JButton("remove");
                             final JPanel upre=new JPanel();
                             upre.setLayout(new GridLayout(1,2));
                             upre.add(update);
                             upre.add(remove);
                             dl.setRows(dl.getRows() + 1);
                             final JTextField a= new JTextField(String.valueOf(s.getStdId()));
                             detailViewer.add(a);
                             final JTextField a1=new JTextField(s.getFirstName());
                             detailViewer.add(a1);
                             final JTextField a2=new JTextField(s.getLastName());
                             detailViewer.add(a2);
                             final JTextField a3=new JTextField(String.valueOf(s.getGender()));
                             detailViewer.add(a3);
                             final date a4=new date();
                             a4.setDay((s.getBirthDate()).get(Calendar.DAY_OF_MONTH));
                             a4.setYear((s.getBirthDate()).get(Calendar.YEAR));
                             a4.setMonth((s.getBirthDate()).get(Calendar.MONTH));
                             detailViewer.add(a4);
                             final JTextField a5=new JTextField(s.getMajor());
                             detailViewer.add(a5);
                             final JTextField a6=new JTextField(String.valueOf(s.getGpa()));
                             detailViewer.add(a6);
                             detailViewer.add(upre);
                             a.setEditable(false);
                             a1.setEditable(false);
                             a2.setEditable(false);
                             a3.setEditable(false);
                             a4.setEditable(false);
                             a5.setEditable(false);
                             a6.setEditable(false);
                             remove.addActionListener(new ActionListener() {
                                 @Override
                                 public void actionPerformed(ActionEvent e) {
                                     list.deleteStudentAt(ii);
                                     detailViewer.remove(a);
                                     detailViewer.remove(a1);
                                     detailViewer.remove(a2);
                                     detailViewer.remove(a3);
                                     detailViewer.remove(a4);
                                     detailViewer.remove(a5);
                                     detailViewer.remove(a6);
                                     detailViewer.remove(upre);
                                     dl.setRows(dl.getRows()-1);
                                     myWindow.pack();
                                 }
                             });
                             update.addActionListener(new ActionListener() {
                                 int stidToChange;
                                 boolean switch1=false;
                                 @Override
                                 public void actionPerformed(ActionEvent e) {
                                     if(switch1) {
                                         update.setText("Update");
                                         a.setEditable(true);
                                         a1.setEditable(true);
                                         a2.setEditable(true);
                                         a3.setEditable(true);
                                         a4.setEditable(true);
                                         a5.setEditable(true);
                                         a6.setEditable(true);
                                         switch1=!switch1;
                                         stidToChange=Integer.parseInt(a.getText());
                                     }
                                     else
                                     {
                                         update.setText("Edit");
                                         a.setEditable(false);
                                         a1.setEditable(false);
                                         a2.setEditable(false);
                                         a3.setEditable(false);
                                         a4.setEditable(false);
                                         a5.setEditable(false);
                                         a6.setEditable(false);
                                         try {
                                             Student s=new Student(Integer.parseInt(a.getText()),a1.getText(),a2.getText(),a3.getText().charAt(0),a4.getdate(),a5.getText(),Float.parseFloat( a6.getText()));
                                             list.updateRecord(stidToChange,s);
                                         } catch (InvalidGpaException e1) {
                                             e1.printStackTrace();
                                         }

                                         switch1=!switch1;
                                     }
                                 }
                             });
                             myWindow.pack();
                         }
                     }

                 }
              else
             if(e.getSource()==end){
                 //todo
                 list.SaveToFile("abc");
                 System.exit(0);
             }
          }
       };
        bottomMenu.add(sort);
        bottomMenu.add(select);
        bottomMenu.add(end);
        myWindow.setSize(500,300);
        myWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myWindow.setVisible(true);
       create.addActionListener(buttonListener);
       end.addActionListener(buttonListener);
       select.addActionListener(buttonListener);
       sort.addActionListener(buttonListener);

    }
}
