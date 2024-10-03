import java.util.HashMap;

public class User {
    private String userName;
    private String password;
    private UUID uuid;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private HashMap<Course, Integer> courses;
    private int proficiencyPointTotal;
    private Settings settings;

    public User(String userName, String password, UUID uuid, String firstName, String lastName, 
                String emailAddress, HashMap<Course, Integer> courses, int proficiencyPointTotal, Settings settings ){
    this.userName=userName;
    this.password=password;
    this.uuid=uuid;
    this.firstName=firstName;
    this.lastName=lastName;
    this.emailAddress=emailAddress;
    this.courses=courses;
    this.proficiencyPointTotal=proficiencyPointTotal;
    this.settings=settings;                    
    }

    public User(String userName, String password, String emailAddress){
        this.userName=userName;
        this.password=password;
        this.emailAddress=emailAddress;

    }

    public String getUsername(){
        return userName;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public String getPassword(){
        return password;
    }

    public String getEmailAddress(){
        return emailAddress;
    }

    public Course getCourse(String language){
        Course course;

        return course;
    }

    public int getCourseProgress(Course course){
        int courseProgress;

        return courseProgress;
    }

    public void setName(String firstName, String lastName){
        this.firstName=firstName;
        this.lastName=lastName;
    }

    public void setEmailAddress(String emailAddress){
        this.emailAddress=emailAddress;
    }

    public void setCourseProgress(ArrayList<Integer> lessonProgress){
        
    }

    public void addCourseProgress(Course course, int lesson, int lessonProgress){
        
    }

    public String toString(){

    }

    public boolean isMatch(String username, String password){
        
    }

    public setSettings(Boolean darkModeOn, Boolean emailNotifsOn){

    }

    public getSettings(){
        return settings;
    }

    private UUID creatUUID(){

    }




}
