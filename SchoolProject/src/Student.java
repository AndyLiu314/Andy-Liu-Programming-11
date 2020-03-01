public class Student {
    //these are the fields of the Students
    private String fname;
    private String lname;
    private int grade;
    //this field includes all the required fields when printing out to the console
    private String info;
    //these 2 fields are for creating the unique Id for each student
    static int id = 1;
    private int studentnum;

    //this is the constructor for the student
    public Student() {
        fname = "Unknown";
        lname = "Unknown";
        grade = 0;
        info = "Name: Unknown "+"Grade: "+grade;
        studentnum = id;
        id++;
    }

    //this returns the info field
    public String getStudent() {
        return info;
    }

    //this method sets all the necessary fields for each student. It then puts it all together in the info field
    public void setStudent(String fname, String lname, int grade) {
        this.fname = fname;
        this.lname = lname;
        this.grade = grade;
        this.info = "Name: "+fname+lname+"\tGrade: "+grade+"\tID: "+studentnum;
    }


    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public int getGrade() {
        return grade;
    }

    public String getInfo() {
        return info;
    }

    public int getStudentnum() {
        return studentnum;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getFullname() {
        return fname+" "+lname;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}

