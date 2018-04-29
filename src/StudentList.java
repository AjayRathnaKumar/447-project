public class StudentList {
    Student[] list;
    int size, maxSize;

    public void addStudentEnd(Student student) {
        if (size < maxSize) {
            list[size] = student;
            size++;
        }
    }

    public void addStudentAt(Student student, int index) {
        if (size < maxSize && index >= 0 && index < size) {
            for (int i = size; i > index; i++) {
                list[i] = list[i - 1];
            }
            list[index] = student;
            size++;
        }
    }

    public void deleteStudentAt( int index) {
        if (size < maxSize) {
            for (int i = size - 1; i >= index; i++) {
                list[i - 1] = list[i];
            }
            list[index] = student;
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

    public void updateRecord(long stdId,Student newDetails){
        for(int i=0;i<size;i++){
            if(list[i].getStdId()==stdId){
                deleteStudentAt(i);
                break;
            }
        }
    }

    public Student searchByStdId(long stdId){
        for(int i=0;i<size;i++){
            if(list[i].getStdId()==stdId){
                return list[i];
            }
        }
        return null;
    }


    public void sortByStdId(){
        for(int i=0;i<size-1;i++){
            long min=list[j].getStdId();
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

}
