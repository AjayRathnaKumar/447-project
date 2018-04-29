import java.io.Serializable;
import java.util.GregorianCalendar;

public class Student implements Serializable{
    protected long stdId;
    protected  String firstName;
    protected  String lastName;
    protected  char  gender;
    protected GregorianCalendar birthDate;
    protected String major;
    protected float gpa;


    public void setstdId(long Id)
    {
        stdId = Id;
    }


    public void setFirstName(String fName)
    {
        firstName = fName;
    }

    public void setLastName(String lName)
    {

        lastName = lName;
    }

    public void setGender(char g)
    {
        gender = g;
    }

    public void setBirthDate(GregorianCalendar bDate)
    {
        birthDate = bDate;
    }
    public void setMajor(String m)
    {
        major = m;
    }
    public void setGPA(float gpa)throws InvalidGpaException
    {
        if (gpa>0 || gpa<4)
            this.gpa = gpa;
        else
            throw new InvalidGpaException(gpa);
    }

    public long getStdId()
    {
        return stdId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public char getGender() {
        return gender;
    }

    public GregorianCalendar getBirthDate() {
        return birthDate;
    }

    public String getMajor() {
        return major;
    }

    public float getGpa() {
        return gpa;
    }
    public void printStudent()
    {
        System.out.println("Student id: "+stdId+" \n First name: "+firstName+"\t Last name: "+lastName+"\n Gender: "+gender+"\t Date of Birth: "+birthDate+"\t Major: "+major+"\t GPA: "+gpa);
    }
    //comstructor without parameter
public Student()
    {
        stdId=0;
        firstName=" ";
        lastName= " ";
        gender= ' ';
        birthDate= new GregorianCalendar();
        major=" ";
        gpa=0;
    }

    //comstructor with parameter
    public Student(long id, String fname, String lname, char g, GregorianCalendar dbirth, String m)
    {
        stdId=id;
        firstName=fname;
        lastName=lname;
        gender=g;
        birthDate=dbirth;
        major=m;
        gpa=0;
    }

    public Student(long id, String fname, String lname, char g, GregorianCalendar dbirth, String m,float gp) throws InvalidGpaException {
        stdId=id;
        firstName=fname;
        lastName=lname;
        gender=g;
        birthDate=dbirth;
        major=m;
        if (gp>0 || gp<4)
            gpa = gp;
        else
            throw new InvalidGpaException("GPA should between 0 and 4.0",gp);
    }

}
