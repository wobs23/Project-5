package prj5;

public class Person {
    
    String hobby;
    
    String major;
    
    String region;
    
    Boolean[] responses;
    
    public Person(String hobby, String major, String region, Boolean[] responses)
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
    
    public Boolean[] getResponses()
    {
        return responses;
    }
    
    public String toString()
    {
        return "[" + major + ", " + hobby + ", " + region + ", " + responses.toString() + "]";
    }
}
