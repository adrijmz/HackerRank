package DataStructures.PriorityQueue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
/*
 * Create the Student and Priorities classes here.
 */
class Student{
    private int id;
    private String name;
    private double cgpa;

    public Student(String name, double cgpa, int id){
        this.id=id;
        this.name=name;
        this.cgpa=cgpa; 
    }
    public int getID(){return this.id;}
    public String getName(){return this.name;}
    public double getCGPA(){return this.cgpa;}
}
class Priorities{
    
    List<Student> myList = new ArrayList<>();

    public List<Student> getStudents(List<String> events){
        for(String line:events){
            Scanner scan = new Scanner(line);
            String command = scan.next();
            if(command.equals("ENTER")){
                String name = scan.next();
                double cgpa = scan.nextDouble();
                int id = scan.nextInt();

                Student st = new Student(name, cgpa, id);
                myList.add(st);
                Collections.sort(myList, new ComparatorStudents());
            }
            if(command.equals("SERVED") && !myList.isEmpty()) myList.remove(0);
            scan.close();
        }
        return myList;
    }
}

class ComparatorStudents implements Comparator<Student>{
    @Override
    public int compare(Student s1, Student s2) {
        if(s1.getCGPA()<s2.getCGPA()) return 1;
		else if(s1.getCGPA()>s2.getCGPA()) return -1;
		else{
			int aux=s1.getName().compareTo(s2.getName());
			if(aux==0){
				return (s1.getID()-s2.getID());
			}
			else return aux;
		}
    }   
}


public class PriorityQueueProblem {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();
    
    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());    
        List<String> events = new ArrayList<>();
        
        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }
        
        List<Student> students = priorities.getStudents(events);
        
        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st: students) {
                System.out.println(st.getName());
            }
        }
    }
}