import java.io.*;

public class StudentList implements Serializable{
    Student[] list;
    int size, maxSize;

    public boolean addStudentEnd(Student student) {
        if (size < maxSize && !searchByStdId(student.getStdId()))
            {
                list[size] = student;
                size++;
                return true;
            }
            else
                return false;
        }


    public boolean addStudentAt(Student student, int index ) {
        if (size < maxSize && index >= 0 && index <= size &&!searchByStdId(student.getStdId()) ) {
            for (int i = size; i > index; i++) {
                list[i] = list[i - 1];
            }
            list[index] = student;
            size++;
            return true;
        }
        else
            return false;
    }

    public void deleteStudentAt( int index) {
        if (size < maxSize) {
            for (int i = size - 1; i >= index; i++) {
                list[i - 1] = list[i];
            }
            size--;
        }
    }

    public void deleteStudentEnd(long stdId) {
            for(int i=0;i<size;i++){
                if(list[i].getStdId()==stdId){
                    deleteStudentAt(i);
                    break;
                }
            }
    }

    public void updateRecord(long stdId,Student newDetails) throws InvalidGpaException {
        for(int i=0;i<size;i++){
            if(list[i].getStdId()==stdId){
                Student s=new Student(newDetails.getStdId(),newDetails.getFirstName(),newDetails.getLastName(),newDetails.getGender(),newDetails.getBirthDate(),newDetails.getMajor(),newDetails.getGpa());
                list[i]=s;
                break;
            }
        }
    }

    public boolean searchByStdId(long stdId){
        for(int i=0;i<size;i++){
            if(list[i].getStdId()==stdId){
                return true;
            }
        }
        return false;
    }


    public void sortByStdId(){
        for(int i=0;i<size-1;i++){
            long min=list[i].getStdId();
            int index=i;
            for(int j=1;j<size;j++){
                if(list[j].getStdId()<list[i].getStdId()){
                    index=j;
                }
            }
            Student temp=list[i];
            list[i]=list[index];
            list[index]=temp;

        }
    }
    public Student retrieve(long stdId){
        for(int i=0;i<size;i++){
            if(list[i].getStdId()==stdId){
                return list[i];
            }
        }
        return null;
    }
    public Student retrieveAt(int index){
        if(index>=0 && index<size)
            return list[index];
        else
            return null;
    }

    public void print(long stdId){
        for(int i=0;i<size;i++){
            if(list[i].getStdId()==stdId){
                list[i].printStudent();
                break;
            }
        }
    }

    public boolean isEmpty(){
        if(size>0)
            return true;
        else
            return false;
    }
    public int size(){
        return size;
    }

    public void expandArray(int increaseBy){
        maxSize+=increaseBy;
    }
    public StudentList(){
        maxSize=50;
        list=new Student[maxSize];
        size=0;
    }
    public StudentList(int size){
        maxSize=size;
        list=new Student[maxSize];
        size=0;
    }
    public StudentList(StudentList studentList) {

    }
    public StudentList(String fileName) {
        maxSize=50;
        list=new Student[maxSize];
        size=0;

               try
               {
                   ObjectInputStream objectInputStream=new ObjectInputStream(new FileInputStream(fileName));

                   while(true){
                       Student record=(Student) objectInputStream.readObject();
                       addStudentEnd(record);
                   }
               } catch (ClassNotFoundException e) {
                   e.printStackTrace();
               }
               catch (EOFException e){
                   e.printStackTrace();
               }
               catch (IOException e) {
            e.printStackTrace();
               }
    }
    public boolean SaveToFile(String fileName) {
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName));

                for (int i = 0; i < size; i++)
                    objectOutputStream.writeObject(list[i]);

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
