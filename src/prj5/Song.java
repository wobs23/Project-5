package prj5;

public class Song {
    
    String title;
    
    String genre;
    
    String artist;
    
    int year, dataLoc;
    
    public Song(String title, String genre, String artist, int year, int dataLoc)
    {
        this.title = title;
        this.genre = genre;
        this.artist = artist;
        this.year = year;
        this.dataLoc = dataLoc;
    }
    
    public String getTitle()
    {
        return title;
    }
    
    public String getGenre()
    {
        return genre;
    }
    
    public String getArtist()
    {
        return artist;
    }
    
    public int getYear()
    {
        return year;
    }
    
    public int getDataLoc()
    {
        return dataLoc;
    }
    
    public String toString()
    {
        return artist;
        //return "[" + title + ", " + genre + ", " + artist + ", " + year + ", " + dataLoc + "]";
    }
}
