import java.util.Scanner;

public class ModuleRegistrationSystem {
    public static Module[][] semester = new Module[7][6];
    public static Student[] students = new Student[60];
    public static Scanner select = new Scanner(System.in);
    public static Scanner input = new Scanner(System.in);
    
    public static void main(String[] args) {
        
        //Student list
        students[0] = new Student("Farhana Islam", "0320853", 1, 1);
        students[1] = new Student("Dalia Abdulkareem", "031666", 1, 1);
        students[2] = new Student("Afsana Islam", "0326710", 2, 3);
        students[3] = new Student("Jon Snow", "032412", 2, 4);
        students[4] = new Student("Tyrion Lannister", "0321576", 2, 5);
        students[5] = new Student("Chandler Bing", "0321224", 3, 6);
        students[6] = new Student("Leslie Knope", "0321267", 3, 7);
        
        //Module list
        semester[0][0] = new Module("ITS60404", "Computer Systems", "none", 4);
        semester[0][1] = new Module("ITS60304", "C Programming", "none", 4);
        semester[0][2] = new Module("ITS60103", "System Analysis and Design", "none", 3);
        semester[0][3] = new Module("MTH60104", "Mathematics for Computing 1", "none", 4);
        semester[0][4] = new Module("MPU3143", "Bahasa Melayu Komunikasi 2", "none", 3);
        semester[0][5] = new Module("MPU3123", "Tamadun Islam dan Tamadun Asia", "none", 3);
        
        semester[1][0] = new Module("MPU3173", "Malaysian Studies 3", "none", 3);
        semester[1][1] = new Module("MPU3113", "Hubungan Etnik", "none", 3);
        semester[1][2] = new Module("COM60303", "Communication Practice for IT Professionals", "none", 3);
        semester[1][3] = new Module("ITS61104", "Web Systems and Technologies", "none", 4);
        semester[1][4] = new Module("CSC60204", "Internet Fundamentals", "none", 4);
        semester[1][5] = new Module("ITS60704", "Fundamentals of Software Engineering", "none", 4);
    
        semester[2][0] = new Module("ITS60804", "Introduction to Object-Oriented Programming", "none", 4);
        semester[2][1] = new Module("ITS60604", "Fundamentals of Database Systems", "none", 4);
        semester[2][2] = new Module("ITS60203", "Fundamentals of Data Communications", "none", 3);
        semester[2][3] = new Module("CSC60104", "E-Commerce", "none", 4);
        semester[2][4] = new Module("UCM60503U2", "Personal Development", "none", 3);
        semester[2][5] = new Module("UCM60402U3", "Malaysian Indigenous Cultures", "none", 2);
        
        semester[3][0] = new Module("ITS61004", "Object-Oriented Programming using Java", "ITS60804", 4);
        semester[3][1] = new Module("ITS60503", "Operating Systems", "none", 3);
        semester[3][2] = new Module("CSC60103", "Online Presence Management**", "none", 3);
        semester[3][3] = new Module("CSC60703", "Project Management", "ITS60704", 3);
        semester[3][4] = new Module("ITS62304", "Web Database Applications", "ITS61104", 4);
        semester[3][5] = new Module("UCM60102U4", "Community Service Initiative", "U1 & U2", 2);
    
        semester[4][0] = new Module ("IND60206", "Industrial Training", "**", 6);
        
        semester[5][0] = new Module("PRJ60207", "Final Year Project (Semester I)", "**", 3);
        semester[5][1] = new Module("ITS61703", "Enterprise Computing", "none", 3);
        semester[5][2] = new Module("ITS62204", "Mobile Applications Development", "ITS60804", 4);
        semester[5][3] = new Module("CSC60304", "Multimedia Systems", "ITS62304", 4);
        semester[5][4] = new Module("CSC60403", "Technopreneurship", "none", 3);
        semester[5][5] = new Module("CSC60303", "Professional Computing Practice", "none", 3);
    
        semester[6][0] = new Module("PRJ60207", "Final Year Project (Semester II)", "Complete Part I", 4);
        semester[6][1] = new Module("ITS62504", "XML Technologies", "ITS61104", 4);
        semester[6][2] = new Module("ITS61704", "Windows Application using .NET Technologies", "ITS60804", 4);
        semester[6][3] = new Module("ITS61404", "Web Applications using .NET Technologies", "ITS60804", 4);
        semester[6][4] = new Module("ITS60504", "Data Structures and Algorithms", "ITS60304", 4);

        menu(); //invoke menu method
    }
    
    public static void menu(){
        System.out.println("\nModule Registration System");
        System.out.println("-----------------------------------------------");
        System.out.println("1. Register modules for a student.");
        System.out.println("2. View all modules registered by a student.");
        System.out.println("3. View registered students of a module.");
        System.out.println("4. Exit menu.");
        System.out.print("Enter your choice: ");
        
        int choice = select.nextInt();
        switch(choice){
            case 1:
                registerModules();
                break;
            case 2:
                viewRegModules();
                break;
            case 3:
                viewRegStudents();
                break;
            case 4:
                break;
            default:
                System.out.println("Invalid input. Please try again.\n");
                menu();
                break;
        }
    }
    
    public static void registerModules(){
        System.out.print("\nEnter Student ID: ");
        String IDCheck = input.nextLine();
        int student;
        for(int i = 0; i<Student.count; i++){
            if(IDCheck.equalsIgnoreCase(students[i].getID())){ //checks if id is valid
                student = i;
                listModules(student);
                break;
            }
            else if(i == (Student.count-1)){
                System.out.println("Student not found in database. Please enter correct student ID.");
                registerModules();
            }
        }
    }
    
    public static void listModules(int num){
        int semesterNum = students[num].getSemester()-1;
        
        System.out.println("No.\tCode\t\tModule Title\t\t\t\t\tPre-requisites\t\tCredit Hours");
        System.out.println("============================================================================================================");        
        System.out.println("YEAR " + students[semesterNum].getYear() + "\tSEMESTER " + students[semesterNum].getSemester());
        System.out.println("============================================================================================================");
        
        for(int i = 0; i<semester[semesterNum].length; i++){  //prints module list for the student's semester  
            System.out.println(String.format("%-3s\t%-10s\t%-40s\t%-30s\t%s",
                    (i+1), 
                    semester[semesterNum][i].getCode(), 
                    semester[semesterNum][i].getTitle(), 
                    semester[semesterNum][i].getPre(), 
                    semester[semesterNum][i].getCredit())
            );
            System.out.println("------------------------------------------------------------------------------------------------------------");
        }
        
        System.out.print("Enter subject code for registration: ");
        String tmpCode = input.nextLine();
        if(!tmpCode.equalsIgnoreCase("exit")){//goes to main menu if exit is enetered
            boolean flag = false;
            int row=0, col=0;
            for(int i = 0; i<semester[semesterNum].length; i++){    
                if(students[semesterNum].getSemester() <= 8){
                    if(semester[semesterNum][i].getCode().equalsIgnoreCase(tmpCode)){ //checks if subject code is valid
                        flag = true;
                        row = semesterNum;   
                        col = i;
                    }
                }
            }
            if(flag == false){
                System.out.println("Incorrect code. Please try again.");
                listModules(num);
            }
            else{
                students[num].addModule(semester[row][col]); //adds selected module to student after all the validation
                System.out.print("Registered successfully! Register another subject? (Y/N): ");
                String cont = input.nextLine();
                if(cont.equalsIgnoreCase("Y")){
                    listModules(num);
                }
                else{
                    menu();
                }
            }
        }
        else{
            menu();
        }
    }
    
    public static void viewRegModules(){
        System.out.print("\nEnter student ID: ");
        String tmpID = input.nextLine();
        if(!tmpID.equalsIgnoreCase("exit")){
            for(int i = 0; i<Student.count; i++){
                if (tmpID.equalsIgnoreCase(students[i].getID())){ //checks if subject code is valid
                    System.out.println("Code\t\tModule Title\t\t\t\t\tPre-requisites\t\tCredit Hours");
                    System.out.println("=====================================================================================================");
                    System.out.println(students[i].toString());
                    System.out.print("View another student's records? (Y/N): ");
                    String cont = input.nextLine();
                    if(cont.equalsIgnoreCase("Y")){
                        viewRegModules();
                    }
                    else{
                        menu();
                    }
                    break;
                }
                else if (i == (Student.count-1)){
                    System.out.println("Student not found in database");
                    viewRegModules();
                    break;
                }
            } 
        }
        else{
            menu();
        }
    }
    
    public static void viewRegStudents(){
        System.out.print("\nEnter subject code: ");
        String codeCheck = input.nextLine();
        for(int i=0; i<Module.modCount; i++){
            for(int j=0; j<semester[0].length; j++){
                if(semester[i][j].getCode().equalsIgnoreCase(codeCheck)){ //checks if subject code is valid
                    semester[i][j].print();     
                    System.out.print("View another subject's records? (Y/N): ");
                    String cont = input.nextLine();
                    if(cont.equalsIgnoreCase("Y")){
                        viewRegModules();
                    }
                    else{
                        menu();
                    }
                    break;
                }
                else if(i == (Module.modCount-1)){
                    System.out.println("Subject not found in database");
                    viewRegStudents();
                    break;
                }
            }     
        }
    }
}