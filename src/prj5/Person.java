package prj5;

public class Person {
    
    String hobby;
    
    String major;
    
    String region;
    
    boolean[] responses;
    
    public Person(String hobby, String major, String region, boolean[] responses)
    {
        this.hobby = hobby;
        this.major = major;
        this.region = region;
        this.responses = responses;
    }
    
    public String getHobby()
    {
        return hobby;
    }
    
    public String getMajor()
    {
        return major;
    }
    
    public String getRegion()
    {
        return region;
    }
    
    public boolean[] getResponses()
    {
        return responses;
    }
    
    public String toString()
    {
        return "[" + major + ", " + hobby + ", " + region + ", " + responses.toString() + "]";
    }
}
