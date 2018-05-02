import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.GregorianCalendar;

/**
 * Created by Student on 4/30/2018.
 */
public class date extends JPanel{
    protected int day;
    protected int month;
    protected int year;
    protected JTextField editnot;
    protected boolean editable =true;
    protected JComboBox d,m,y;
    ActionListener al;
    GridLayout gl=new GridLayout(1,3);
    ActionListener actionlistener=new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource().equals(d))
            day=Integer.parseInt(d.getSelectedItem().toString());
            else if(e.getSource().equals(m))
            month=Integer.parseInt(m.getSelectedItem().toString());
            else if(e.getSource().equals(y));
            year=Integer.parseInt(y.getSelectedItem().toString());
        }
    };
    public date() {
        super();
        d= new JComboBox();
        m= new JComboBox();
        y= new JComboBox();
        d.addActionListener(al);
        m.addActionListener(al);
        y.addActionListener(al);
        for(int i=1;i<=31;i++)
        {
            d.addItem(String.valueOf(i));
        }

        for(int i=1;i<=12;i++)
        {
            m.addItem(i);
        }
       for(int i=1980;i<=2018;i++)
        {
            y.addItem(String.valueOf(i));
        }

        d.addActionListener(actionlistener);
        m.addActionListener(actionlistener);
        y.addActionListener(actionlistener);
        setLayout(gl);
        add(d);
        add(m);
        add(y);

        day=Integer.parseInt(d.getSelectedItem().toString());

            month=Integer.parseInt(m.getSelectedItem().toString());

        year=Integer.parseInt(y.getSelectedItem().toString());
editnot=new JTextField();
editnot.setEditable(false);
al=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                year=Integer.parseInt(y.getSelectedItem().toString());
                month=Integer.parseInt(m.getSelectedItem().toString());
                day=Integer.parseInt(d.getSelectedItem().toString());
            }
        };
}



    public GregorianCalendar getdate(){
        return new GregorianCalendar(year,month,day);
    }

    public int getDay() {
        return day;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public void setDay(int day) {
        this.day = day;
        d.setSelectedItem(String.valueOf(day));
    }

    public void setYear(int year) {
        this.year = year;
        d.setSelectedItem(String.valueOf(year));
    }

    public void setMonth(int month) {
        this.month = month;
        d.setSelectedItem(String.valueOf(year));
    }

    public void setEditable(boolean b){

        if(b==true && editable==false){
            gl.setColumns(3);
            add(d);
            add(m);
            add(y);
            remove(editnot);
            editable=!editable;

        }
        else if(b==false && editable==true){
            remove(d);
            remove(m);
            remove(y);
            editnot.setText(day + "/" + month + "/" +year);
            gl.setColumns(1);
            add(editnot);
            editable=!editable;
        }
    }
}
