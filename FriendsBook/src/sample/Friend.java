package sample;

public class Friend {
    private String name;
    private int age;
    private long phone;
    private String nickname;

    Friend (String n, int age, long phone, String nickname){
        this.name = n;
        this.age = age;
        this.phone = phone;
        this.nickname = nickname;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone (long phone) {
        this.phone = phone;
    }

    public String toString(){
        return name;
    }
}
