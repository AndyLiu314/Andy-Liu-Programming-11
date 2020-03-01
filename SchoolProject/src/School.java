import java.util.ArrayList;

//the school fields that I made
public class School {
    private String name;
    private String address;
    private String level;
    private String info;

    //this is the constructor for the School fields
    public School (){
        name = "Unknown";
        address = "Unknown";
        level = "Unknown";
        info = "Name: "+name+"\tAddress: "+address+"\tLevel: "+level;
    }

    //sets all the information of the field and puts it together in the info field
    public void setSchool (String name, String address, String level){
        this.name = name;
        this.address = address;
        this.level = level;
        this.info = "Name: "+name+"\tAddress: "+address+"\tLevel: "+level;
    }

    //gets the info field with all the other fields
    public String getSchool(){
        return info;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    //Array lists for teachers, students, courses.
    ArrayList<Teacher> tlist = new ArrayList<>();
    ArrayList<Student> slist = new ArrayList<>();
    ArrayList<String> clist = new ArrayList<>();

    //these are the methods for adding teachers, students, and courses to the array lists. I used the methods that were included with Arraylists to make these
    public void addteacher(Teacher Te){
        this.tlist.add(Te);
    }

    public void addstudent(Student St){
        this.slist.add(St);
    }

    public void addcourse(String Co){
        this.clist.add(Co);
    }

    //these are the methods for removing teachers, students, and courses from the array lists. I also used the methods within Arraylists to make this.
    public void deleteteacher(Teacher Te){
        this.tlist.remove(Te);
    }

    public void deletestudent(Student St){
        this.slist.remove(St);
    }

    public void deletecourse(String Co){
        this.clist.remove(Co);
    }

    //this shows the teachers by printing out the teacher info every position in the Arraylist
    public void showteachers(){
        for (int i=0; i<tlist.size(); i++){
            System.out.println(tlist.get(i).getTeacher());
        }
    }

    //this showstudents method does the same thing as the show teachers method
    public void showstudents(){
        for (int i=0; i<slist.size(); i++){
            System.out.println(slist.get(i).getStudent());
        }
    }


}
