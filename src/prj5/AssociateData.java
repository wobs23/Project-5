package prj5;

/**
 * Associates the data of the survey with each
 * individual song
 * @author Brendan Kelly bmkelly
 * @version 4.18.2017
 *
 */
public class AssociateData {
    
    /**
     * Array of people to get data from
     */
    Person[] people;
    
    /**
     * song data structure 
     */
    DLList<Song> songs;
    
    /**
     * data based on major associations
     */
    AssociateMajor[] major;
    
    /**
     * data based on hobby associations
     */
    AssociateHobby[] hobby;
    
    /**
     * data based on region associations
     */
    AssociateRegion[] region;
    
    /**
     * builds arrays for storage and takes in
     * passed variables
     * @param people People to take data from
     * @param songs songs to store data about
     */
    public AssociateData(Person[] people, DLList<Song> songs)
    {
        major = new AssociateMajor[59]; //62
        hobby = new AssociateHobby[59];//62
        region = new AssociateRegion[59];//62
        this.people = people;
        this.songs = songs;
        
        createArrays();
    }
    
    /**
     * creates the arrays of associated data
     */
    public void createArrays()
    {
        for (int i = 0; i < songs.size(); i++)
        {
            major[i] = new AssociateMajor(songs.get(i), people);

            hobby[i] = new AssociateHobby(songs.get(i), people);
            
            region[i] = new AssociateRegion(songs.get(i), people);
        }
    }
    
    /**
     * returns data based on major
     * @return array of major data
     */
    public AssociateMajor[] getMajorData()
    {
        return major;
    }
    
    /**
     * returns data based on hobby
     * @return array of hobby data
     */
    public AssociateHobby[] getHobbyData()
    {
        return hobby;
    }
    
    /**
     * returns data baed on region
     * @return array of region data
     */
    public AssociateRegion[] getRegionData()
    {
        return region;
    }
}
