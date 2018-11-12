import java.util.Vector;

public class Module {
    //data member or data field
    private String code;
    private String title;
    private int credit;
    private String pre;
    private int studentCount; //counts number of students added
    static int modCount; //counts nummber of modules added to a student
    Student studentAdded;
    Vector listOfStudents; //used to hold the list of Student objects.
    
    //default constructor
    public Module(){
        code = "";
        title = "";
        pre = "";
        credit = 0;
        modCount++;
    } 
    
    //overloaded constructor
    public Module(String code, String title, String pre, int credit){
        this.code = code;
        this.title = title;
        this.pre = pre;
        this.credit = credit;
        listOfStudents = new Vector(60);
        modCount++;
    }
    
    // Accessor - Getter
    public String getCode(){return code;}
    public String getTitle(){return title;}
    public int getCredit(){return credit;}
    public String getPre(){return pre;}
    
    // Mutator - Setter
    public void addStudent(Student aStudent){
        studentAdded = aStudent;
        if(studentCount < 60){
            listOfStudents.add(aStudent);
            studentCount++;
        }
        else{
            System.out.println("Capacity Full for " + title + "(" + code + ") ");
        }
    }
    
    //prints registered students of a module
    public void print(){
        System.out.println("Student List for " + title + "(" + code + ")");
        System.out.println("----------------------------------------------------------------");
        System.out.println("No.\tID\t\tName");
        System.out.println("================================================================");
        for (int i = 0; i<= listOfStudents.size()-1;i++){
            studentAdded = (Student)listOfStudents.elementAt(i); 
            System.out.println((i+1) + "\t" + studentAdded.getID() + "\t\t" + studentAdded.getName()); 
        }
        System.out.println("================================================================");
        System.out.println("Total number of students is: " + studentCount);
    }
}