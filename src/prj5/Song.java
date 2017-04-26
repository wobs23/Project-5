package prj5;

/**
 * Stores the basic data on each song
 * @author Brendan Kelly bmkelly
 * @version 2017.4.18
 */
public class Song {
    
    /**
     * string for title
     */
    private String title;
    
    /**
     * string for genre
     */
    private String genre;
    
    /**
     * string for artist
     */
    private String artist;
    
    /**
     * int for year
     */
    int year;
    
    /**
     * int for location in responses array
     * that holds this songs data
     */
    int dataLoc;
    
    /**
     * builds song data
     * @param title title of song
     * @param genre genre of song
     * @param artist artist of song
     * @param year year of song
     * @param dataLoc dataLoc inside responses array for song
     */
    public Song(String title, String genre, String artist, 
            int year, int dataLoc)
    {
        this.title = title;
        this.genre = genre;
        this.artist = artist;
        this.year = year;
        this.dataLoc = dataLoc;
    }
    
    /**
     * 
     * @return title of song
     */
    public String getTitle()
    {
        return title;
    }
    
    /**
     * 
     * @return genre of song
     */
    
    public String getGenre()
    {
        return genre;
    }
    
    /**
     * 
     * @return artist of song
     */
    
    public String getArtist()
    {
        return artist;
    }
    
    /**
     * 
     * @return year of song
     */
    
    public int getYear()
    {
        return year;
    }
    
    /**
     * 
     * @return data location of song
     */
    
    public int getDataLoc()
    {
        return dataLoc;
    }
}
