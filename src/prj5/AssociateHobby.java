package prj5;

/**
 * Associates the hobby data with the
 * given song and calculates totals heard and liked
 * for the song
 * @author Brendan Kelly bmkelly
 * @version 2017.4.18
 *
 */
public class AssociateHobby {

    /**
     * number of sports hobbiests that
     * heard this song
     */
    int sportsHeard; 
    /**
     * number of sports hobbiests that
     * like this song
     */
    int sportsLike; 
    /**
     * number of reading hobbiests that
     * heard this song
     */
    int readHeard; 
    /**
     * number of reading hobbiests that
     * like this song
     */
    int readLike; 
    /**
     * number of music hobbiests that
     * heard this song
     */
    int musicHeard; 
    /**
     * number of music hobbiests that
     * like this song
     */
    int musicLike;
    /**
     * number of art hobbiests that
     * heard this song
     */
    int artHeard; 
    /**
     * number of art hobbiests that
     * like this song
     */
    int artLike; 
    /**
     * Location of this songs data
     * in the responses array of the
     * individual people
     */
    int dataLoc; 
    /**
     * total number of sports people
     * who've heard the song
     */
    int totalSportsHeard; 
    /**
     * total number of reading people
     * who've heard the song
     */
    int totalReadHeard; 
    /**
     * total number of music people
     * who've heard the song
     */
    int totalMusicHeard; 
    /**
     * total number of art people
     * who've heard the song
     */
    int totalArtHeard;
    /**
     * total number of sports people
     * who liked the song
     */
    int totalSportsLike; 
    /**
     * total number of reading people
     * who liked the song
     */
    int totalReadLike; 
    /**
     * total number of music people
     * who liked the song
     */
    int totalMusicLike; 
    /**
     * total number of art people
     * who liked the song
     */
    int totalArtLike;

    /**
     * song to collect data for
     */
    Song song;

    /**
     * people to get data from
     */
    Person[] people;


    /**
     * intitizalizes the song and people as well
     * as grabbing the data location
     * @param song song to collect dat for
     * @param people people to collect data from
     */
    public AssociateHobby(Song song, Person[] people) {
        this.song = song;
        this.people = people;
        this.dataLoc = song.getDataLoc();

        absoluteMonstrocity();
    }


    /**
     * This disaster of a method parces the data
     * and keeps track of the total entries for
     * hearing and liking a song for each hobby
     */
    public void absoluteMonstrocity() {

        for (int i = 0; i < people.length; i++) {
            Boolean[] response = people[i].getResponses();
            
            if (people[i].getHobby().equals("sports")) {
                
                if (response[dataLoc * 2] != null)
                {
                    totalSportsHeard++;
                    if (response[dataLoc * 2])
                    {
                        sportsHeard++;
                    }
                }
                
                if (response[dataLoc * 2 + 1] != null)
                {
                    totalSportsLike++;
                    if (response[dataLoc * 2 + 1])
                    {
                        sportsLike++;
                    }
                }
            }
            else if (people[i].getHobby().equals("reading")) {
                
                if (response[dataLoc * 2] != null)
                {
                    totalReadHeard++;
                    if (response[dataLoc * 2])
                    {
                        readHeard++;
                    }
                }
                
                if (response[dataLoc * 2 + 1] != null)
                {
                    totalReadLike++;
                    if (response[dataLoc * 2 + 1])
                    {
                        readLike++;
                    }
                }
            }
            else if (people[i].getHobby().equals("music")) {
                
                if (response[dataLoc * 2] != null)
                {
                    totalMusicHeard++;
                    if (response[dataLoc * 2])
                    {
                        musicHeard++;
                    }
                }
                
                if (response[dataLoc * 2 + 1] != null)
                {
                    totalMusicLike++;
                    if (response[dataLoc * 2 + 1])
                    {
                        musicLike++;
                    }
                }
            }
            else {
                
                if (response[dataLoc * 2] != null)
                {
                    totalArtHeard++;
                    if (response[dataLoc * 2])
                    {
                        artHeard++;
                    }
                }
                
                if (response[dataLoc * 2 + 1] != null)
                {
                    totalArtLike++;
                    if (response[dataLoc * 2 + 1])
                    {
                        artLike++;
                    }
                }
            }
        }
    }


    /**
     * return sportsHeard
     * @return number of sports hobbiest that heard
     * this song
     */
    public int getSportsHeard() {
        return sportsHeard;
    }

    /**
     * return sportsLike
     * @return number of sports hobbiest that like
     * this song
     */
    public int getSportsLike() {
        return sportsLike;
    }

    /**
     * return readHeard
     * @return number of reading hobbiest that heard
     * this song
     */
    public int getReadHeard() {
        return readHeard;
    }

    /**
     * return readHeard
     * @return number of reading hobbiest that like
     * this song
     */
    public int getReadLike() {
        return readLike;
    }

    /**
     * return musicHeard
     * @return number of music hobbiest that heard
     * this song
     */
    public int getMusicHeard() {
        return musicHeard;
    }

    /**
     * return musicHeard
     * @return number of music hobbiest that like
     * this song
     */
    public int getMusicLike() {
        return musicLike;
    }

    /**
     * return artHeard
     * @return number of art hobbiest that heard
     * this song
     */
    public int getArtHeard() {
        return artHeard;
    }

    /**
     * return artHeard
     * @return number of art hobbiest that like
     * this song
     */
    public int getArtLike() {
        return artLike;
    }


    /**
     * The data location for this song
     * @return location in responses array 
     * for an individual person
     */
    public int getDataLoc() {
        return dataLoc;
    }
    
    //*********************PERCET HEARD GETTERS****************************
    
    /**
     * gets percentSportsHeard
     * @return percentage of sports hobbiests
     * that have heard this song
     */
    public int getPercentSportsHeard()
    {
        if (totalSportsHeard == 0)
        {
            return 0;
        }

        return (int)(((float)sportsHeard / (float)totalSportsHeard) * 100);
    }
    
    /**
     * gets percentReadHeard
     * @return percentage of reading hobbiests
     * that have heard this song
     */
    public int getPercentReadHeard()
    {
        if (totalReadHeard == 0)
        {
            return 0;
        }

        return (int)(((float)readHeard / (float)totalReadHeard) * 100);
    }   
    
    /**
     * gets percentArtHeard
     * @return percentage of art hobbiests
     * that have heard this song
     */
    public int getPercentArtHeard()
    {
        if (totalArtHeard == 0)
        {
            return 0;
        }

        return (int)(((float)artHeard / (float)totalArtHeard) * 100);
    }   
    
    /**
     * gets percentMusicHeard
     * @return percentage of music hobbiests
     * that have heard this song
     */
    public int getPercentMusicHeard()
    {
        if (totalMusicHeard == 0)
        {
            return 0;
        }

        return (int)(((float)musicHeard / (float)totalMusicHeard) * 100);
    }
    
    //*********************PERCET LIKE GETTERS****************************
    
    /**
     * @return percentage of sports hobbiests that
     * like this song
     */
    public int getPercentSportsLike()
    {
        if (totalSportsLike == 0)
        {
            return 0;
        }

        return (int)(((float)sportsLike / (float)totalSportsLike) * 100);
    }

    /**
     * @return percentage of reading hobbiests that
     * like this song
     */
    public int getPercentReadLike()
    {
        if (totalReadLike == 0)
        {
            return 0;
        }
        return (int)(((float)readLike / (float)totalReadLike) * 100);
    }

    /**
     * @return percentage of art hobbiests that
     * like this song
     */
    public int getPercentArtLike()
    {
        
        if (totalArtLike == 0)
        {
            return 0;
        }

        return (int)(((float)artLike / (float)totalArtLike) * 100);
    }

    /**
     * @return percentage of music hobbiests that
     * like this song
     */
    public int getPercentMusicLike()
    {
        if (totalMusicLike == 0)
        {
            return 0;
        }

        return (int)(((float)musicLike / (float)totalMusicLike) * 100);
    }

}
