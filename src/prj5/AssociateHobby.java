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
     * with non-null responses
     */
    int totalSports; 
    /**
     * total number of reading people
     * with non-null responses
     */
    int totalRead; 
    /**
     * total number of music people
     * with non-null responses
     */
    int totalMusic; 
    /**
     * total number of art people
     * with non-null responses
     */
    int totalArt;

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
     * A horrible mess that somehow magically sorts out
     * all the data and catagorizes it, it's basically 
     * magic, I'm afraid to touch it at this point but
     * I'm pretty sure it works... most of the time...
     * 
     * I heavily commented this method to try and make
     * it easier to follow, hope it helps
     */
    public void absoluteMonstrocity() {

        for (int i = 0; i < people.length; i++) {
            //Get responses
            Boolean[] response = people[i].getResponses();
            
            //Do they like sports?
            if (people[i].getHobby().equals("sports")) {
                //Add to total sports
                totalSports++;
                //Have they heard is null?
                if (response[dataLoc * 2] == null)
                {
                    //If do they like is also null do nothing
                    if (response[dataLoc * 2 + 1] == null)
                    {
                        continue;
                    }
                    
                    //If not null and they like we
                    //add to heard and like, that's what
                    //the test you guys gave us said, even
                    //if this is super stupid
                    if (response[dataLoc * 2 + 1])
                    {
                        sportsHeard++;
                        sportsLike++;
                    }
                    continue;
                }
                //If person heard song is not null
                else if (response[dataLoc * 2]) {
                    //add one to heard!
                    sportsHeard++;
                    
                    if (response[dataLoc * 2 + 1] == null)
                    {
                        //Remove the one we added earlier
                        //from total and heard
                        sportsHeard--;
                        totalSports--;
                        continue;
                    }
                }
                //We only get here if heard is not null
                //Is like null?
                if (response[dataLoc * 2 + 1] == null)
                {
                    //remove form total added earlier
                    totalSports--;
                    continue;
                }
                
                //Did they like it?
                if (response[dataLoc * 2 + 1]) {
                    //Add one to like!
                    sportsLike++;
                }
            }
            else if (people[i].getHobby().equals("reading")) {
              //Add to total sports
                totalRead++;
                //Have they heard is null?
                if (response[dataLoc * 2] == null)
                {
                    //If do they like is also null do nothing
                    if (response[dataLoc * 2 + 1] == null)
                    {
                        continue;
                    }
                    
                    //If not null and they like we
                    //add to heard and like, that's what
                    //the test you guys gave us said, even
                    //if this is super stupid
                    if (response[dataLoc * 2 + 1])
                    {
                        readHeard++;
                        readLike++;
                    }
                    continue;
                }
                //If person heard song is not null
                else if (response[dataLoc * 2]) {
                    //add one to heard!
                    readHeard++;
                    
                    if (response[dataLoc * 2 + 1] == null)
                    {
                        //Remove the one we added earlier
                        //from total and heard
                        readHeard--;
                        totalRead--;
                        continue;
                    }
                }
                //We only get here if heard is not null
                //Is like null?
                if (response[dataLoc * 2 + 1] == null)
                {
                    //remove form total added earlier
                    totalRead--;
                    continue;
                }
                
                //Did they like it?
                if (response[dataLoc * 2 + 1]) {
                    //Add one to like!
                    readLike++;
                }

            }
            else if (people[i].getHobby().equals("music")) {
              //Add to total music
                totalMusic++;
                //Have they heard is null?
                if (response[dataLoc * 2] == null)
                {
                    //If do they like is also null do nothing
                    if (response[dataLoc * 2 + 1] == null)
                    {
                        continue;
                    }
                    
                    //If not null and they like we
                    //add to heard and like, that's what
                    //the test you guys gave us said, even
                    //if this is super stupid
                    if (response[dataLoc * 2 + 1])
                    {
                        musicHeard++;
                        musicLike++;
                    }
                    continue;
                }
                //If person heard song is not null
                else if (response[dataLoc * 2]) {
                    //add one to heard!
                    musicHeard++;
                    
                    if (response[dataLoc * 2 + 1] == null)
                    {
                        //Remove the one we added earlier
                        //from total and heard
                        musicHeard--;
                        totalMusic--;
                        continue;
                    }
                }
                //We only get here if heard is not null
                //Is like null?
                if (response[dataLoc * 2 + 1] == null)
                {
                    //remove form total added earlier
                    totalMusic--;
                    continue;
                }
                
                //Did they like it?
                if (response[dataLoc * 2 + 1]) {
                    //Add one to like!
                    musicLike++;
                }

            }
            else if (people[i].getHobby().equals("art")) {
              //Add to total art
                totalArt++;
                //Have they heard is null?
                if (response[dataLoc * 2] == null)
                {
                    //If do they like is also null do nothing
                    if (response[dataLoc * 2 + 1] == null)
                    {
                        continue;
                    }
                    
                    //If not null and they like we
                    //add to heard and like, that's what
                    //the test you guys gave us said, even
                    //if this is super stupid
                    if (response[dataLoc * 2 + 1])
                    {
                        artHeard++;
                        artLike++;
                    }
                    continue;
                }
                //If person heard song is not null
                else if (response[dataLoc * 2]) {
                    //add one to heard!
                    artHeard++;
                    
                    if (response[dataLoc * 2 + 1] == null)
                    {
                        //Remove the one we added earlier
                        //from total and heard
                        artHeard--;
                        totalArt--;
                        continue;
                    }
                }
                //We only get here if heard is not null
                //Is like null?
                if (response[dataLoc * 2 + 1] == null)
                {
                    //remove form total added earlier
                    totalArt--;
                    continue;
                }
                
                //Did they like it?
                if (response[dataLoc * 2 + 1]) {
                    //Add one to like!
                    artLike++;
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
        if (totalSports == 0)
        {
            return 0;
        }
        
        return Math.round((((float)sportsHeard / (float)totalSports) * 100));
    }
    
    /**
     * gets percentReadHeard
     * @return percentage of reading hobbiests
     * that have heard this song
     */
    public int getPercentReadHeard()
    {
        if (totalRead == 0)
        {
            return 0;
        }
        
        return Math.round((((float)readHeard / (float)totalRead) * 100));
    }   
    
    /**
     * gets percentArtHeard
     * @return percentage of art hobbiests
     * that have heard this song
     */
    public int getPercentArtHeard()
    {
        //System.out.println(song.getTitle() + " " + totalArt + " " + artHeard);
        if (totalArt == 0)
        {
            return 0;
        }
        
        return Math.round((((float)artHeard / (float)totalArt) * 100));
    }   
    
    /**
     * gets percentMusicHeard
     * @return percentage of music hobbiests
     * that have heard this song
     */
    public int getPercentMusicHeard()
    {
        if (totalMusic == 0)
        {
            return 0;
        }
        
        return Math.round((((float)musicHeard / (float)totalMusic) * 100));
    }
    
    //*********************PERCET LIKE GETTERS****************************
    
    /**
     * @return percentage of sports hobbiests that
     * like this song
     */
    public int getPercentSportsLike()
    {
        if (totalSports == 0)
        {
            return 0;
        }
        
        return Math.round((((float)sportsLike / (float)totalSports) * 100));
    }

    /**
     * @return percentage of reading hobbiests that
     * like this song
     */
    public int getPercentReadLike()
    {
        if (totalRead == 0)
        {
            return 0;
        }
        
        return Math.round((((float)readLike / (float)totalRead) * 100));
    }

    /**
     * @return percentage of art hobbiests that
     * like this song
     */
    public int getPercentArtLike()
    {
        
        if (totalArt == 0)
        {
            return 0;
        }
        
        return Math.round((((float)artLike / (float)totalArt) * 100));
    }

    /**
     * @return percentage of music hobbiests that
     * like this song
     */
    public int getPercentMusicLike()
    {
        if (totalMusic == 0)
        {
            return 0;
        }
        
        return Math.round((((float)musicLike / (float)totalMusic) * 100));
    }

    
    /**
     * returns data as a string
     * @return a bit of dat just for testing purposes as a string
     */
    public String toString() {
        return "Sports Heard: " + sportsHeard + " | Sports Like: " + sportsLike;
    }

}
