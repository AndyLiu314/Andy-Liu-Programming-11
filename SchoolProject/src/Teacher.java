public class Teacher {
    //these are the fields for the teacher. I also added an info field to help print all the fields together
    private String fname;
    private String lname;
    private String subject;
    private String info;

    //this is the constructor
    public Teacher(){
        fname = "Unknown";
        lname = "Unknown";
        subject = "Unknown";
        info = "Name: Unknown "+"Subject: "+subject;
    }

    //this gets all the information that was set
    public String getTeacher(){
        return info;
    }

    //this does the same thing as the setStudent method in the Student class
    public void setTeacher(String fname, String lname, String subject) {
        this.fname = fname;
        this.lname = lname;
        this.subject = subject;
        this.info = "Name: "+fname+lname+"\tSubject: "+subject;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getFullname() {
        return fname+" "+lname;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
