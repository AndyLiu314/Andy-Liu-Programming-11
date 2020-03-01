public class Main {
    public static void main(String[] args) {
        //here I created the new students and teachers and set their fields
        Student farr = new Student();
        farr.setStudent("Farrah ", "Chan", 12);

        Student andy = new Student();
        andy.setStudent("Andy ", "Liu", 11);

        Student jatin = new Student();
        jatin.setStudent("Jatin ", "Parmar", 8);

        Student ethan = new Student();
        ethan.setStudent("Ethan ", "Ryder", 9);

        Student ryan = new Student();
        ryan.setStudent("Ryan ","Pao", 10);

        Student sajid = new Student();
        sajid.setStudent("Sajid ", "Hassan ", 11);

        Student bryan = new Student();
        bryan.setStudent("Bryan ", "Hui", 9);

        Student alexa = new Student();
        alexa.setStudent("Alexandra ", "Mitic", 11);

        Student ameya = new Student();
        ameya.setStudent("Ameya ", "Dhawan", 10);

        Student mack = new Student();
        mack.setStudent("Mack ", "Stewart", 12);


        Teacher janna = new Teacher();
        janna.setTeacher("Janna ", "Speed", "French");

        Teacher ernie = new Teacher();
        ernie.setTeacher("Ernie ", "Pao", "Math");

        Teacher mike = new Teacher();
        mike.setTeacher("Michael ", "Bodnar", "History");

        //this is the new school that I created
        School school = new School();

        //Here I set all the fields of the school
        school.setSchool("SW CHurchill","Heather St", "Secondary" );
        System.out.println(school.getSchool());

        //this is where I start adding the 10 students to the arraylist
        school.addstudent(mack);
        school.addstudent(sajid);
        school.addstudent(ameya);
        school.addstudent(bryan);
        school.addstudent(andy);
        school.addstudent(alexa);
        school.addstudent(ryan);
        school.addstudent(ethan);
        school.addstudent(jatin);
        school.addstudent(farr);
        //here I delete 2 students
        school.deletestudent(ryan);
        school.deletestudent(andy);

        //this is the arraylist for the teachers
        school.addteacher(mike);
        school.addteacher(janna);
        school.addteacher(ernie);
        //I remove 1 teacher here
        school.deleteteacher(mike);

        //THe 3 courses that the teachers teach
        school.addcourse("Math");
        school.addcourse("History");
        school.addcourse("French");

        //this shows all the teachers and students in the list
        school.showteachers();
        school.showstudents();




    }
}
