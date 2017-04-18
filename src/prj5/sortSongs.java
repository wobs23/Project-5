package prj5;

public class sortSongs {
    
    public static Song[] sortByGenre(Song[] songs)
    {
        for (int i = 0; i < songs.length - 1; i++)
        {
            int index = i;
            for (int j = i + 1; j < songs.length; j++)
                if (songs[j].getGenre().compareToIgnoreCase(songs[index].getGenre()) < 0)
                {
                    index = j;
                }
      
            Song smaller = songs[index]; 
            songs[index] = songs[i];
            songs[i] = smaller;
        }
        return songs;
    }
    
    public static Song[] sortByArtist(Song[] songs)
    {
        for (int i = 0; i < songs.length - 1; i++)
        {
            int index = i;
            for (int j = i + 1; j < songs.length; j++)
                if (songs[j].getArtist().compareToIgnoreCase(songs[index].getArtist()) < 0)
                {
                    index = j;
                }
      
            Song smaller = songs[index]; 
            songs[index] = songs[i];
            songs[i] = smaller;
        }
        return songs;
    }
    
    public static Song[] sortByYear(Song[] songs)
    {
        for (int i = 0; i < songs.length - 1; i++)
        {
            int index = i;
            for (int j = i + 1; j < songs.length; j++)
                if (songs[j].getYear() < songs[index].getYear())
                {
                    index = j;
                }
      
            Song smaller = songs[index]; 
            songs[index] = songs[i];
            songs[i] = smaller;
        }
        return songs;
    }
    
    public static Song[] sortByTitle(Song[] songs)
    {
        for (int i = 0; i < songs.length - 1; i++)
        {
            int index = i;
            for (int j = i + 1; j < songs.length; j++)
                if (songs[j].getTitle().compareToIgnoreCase(songs[index].getTitle()) < 0)
                {
                    index = j;
                }
      
            Song smaller = songs[index]; 
            songs[index] = songs[i];
            songs[i] = smaller;
        }
        return songs;
    }
}
