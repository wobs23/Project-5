package prj5;

/**
 * Person object for storing data
 * on people who took the survey
 * @author Brendan Kelly bmkelly
 * @version 2017.4.18
 */
public class Person {
    
    /**
     * string to hold hobby
     */
    String hobby;
    
    /**
     * string to hold major
     */
    String major;
    
    /**
     * string to hold region
     */
    String region;
    
    /**
     * array of all responses
     */
    Boolean[] responses;
    
    /**
     * builds person
     * @param hobby hobby they have
     * @param major major they study
     * @param region region they lived
     * @param responses responses to survey
     */
    public Person(String hobby, String major, 
            String region, Boolean[] responses)
    {
        this.hobby = hobby;
        this.major = major;
        this.region = region;
        this.responses = responses;
    }
    
    /**
     * returns their hobby
     * @return their hobby
     */
    public String getHobby()
    {
        return hobby;
    }
    
    /**
     * returns their major
     * @return their major
     */
    public String getMajor()
    {
        return major;
    }
    
    /**
     * returns their region
     * @return their region
     */
    public String getRegion()
    {
        return region;
    }
    
    /**
     * returns all their responses
     * @return all their responses
     */
    public Boolean[] getResponses()
    {
        return responses;
    }
    
    /**
     * outputs some basic data as a string mainly for testing
     * @return some data as a string
     */
    public String toString()
    {
        return "[" + major + ", " + hobby + ", " + region + 
                ", " + responses.toString() + "]";
    }
}
