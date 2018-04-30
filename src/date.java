import javax.swing.*;
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
    protected JComboBox d,m,y;
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
        add(d);
        add(m);
        add(y);

        day=Integer.parseInt(d.getSelectedItem().toString());

            month=Integer.parseInt(m.getSelectedItem().toString());

        year=Integer.parseInt(y.getSelectedItem().toString());

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
}
