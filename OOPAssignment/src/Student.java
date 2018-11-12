public class Student {
    //data member or data field
    private String name;
    private String studentID;
    private int year;
    private int semester;
    private int moduleCount; //counts number of modules taken
    int totCredits; //calculates total number of credits for a student
    static int count; //counts number of students added to a module
    Module moduleTaken;

    //default constructor
    public Student(){
        name = "";
        studentID = "";
        year = 0;
        semester = 0;
        count++;
    } 

    //overloaded constructor
    public Student(String name, String studentID, int year, int sem){
        this.name = name;
        this.studentID = studentID;
        this.semester = sem;
        this.year = year;
        count++;
    }

    // Accessor - Getter
    public String getName(){return name;}
    public String getID(){return studentID;}
    public int getSemester(){return semester;}
    public int getYear(){return year;}
    public int getmoduleCount(){return moduleCount;}

    // Mutator - Setter
    public void addModule(Module aModule){
        moduleTaken=aModule;
        if(moduleCount <= 10 || totCredits <= 50){
            aModule.addStudent(this);
            moduleCount++;
            totCredits += aModule.getCredit();
        }
        else{
            System.out.println("Subject limit or credit limit exceeded");
        }
    }

    //prints modules registered by a student
    @Override
    public String toString(){
        return  String.format("%-10s\t%-40s\t%-30s\t%s", 
                    moduleTaken.getCode(), 
                    moduleTaken.getTitle(), 
                    moduleTaken.getPre(), 
                    moduleTaken.getCredit()
            );
    }
}
