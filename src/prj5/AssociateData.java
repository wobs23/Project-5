package prj5;

public class AssociateData {
    
    Person[] people;
    
    DLList<Song> songs;
    
    AssociateMajor[] major;
    
    AssociateHobby[] hobby;
    
    AssociateRegion[] region;
    
    public AssociateData(Person[] people, DLList<Song> songs)
    {
        major = new AssociateMajor[59];
        hobby = new AssociateHobby[59];
        region = new AssociateRegion[59];
        this.people = people;
        this.songs = songs;
        
        createArrays();
    }
    
    public void createArrays()
    {
        for (int i = 0; i < songs.size(); i++)
        {
            major[i] = new AssociateMajor(songs.get(i), people);

            hobby[i] = new AssociateHobby(songs.get(i), people);
            
            region[i] = new AssociateRegion(songs.get(i), people);
        }
    }
    
    public AssociateMajor[] getMajorData()
    {
        return major;
    }
    
    public AssociateHobby[] getHobbyData()
    {
        return hobby;
    }
    
    public AssociateRegion[] getRegionData()
    {
        return region;
    }
}
