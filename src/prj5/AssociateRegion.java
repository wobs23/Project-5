package prj5;

/**
 * Associates the Region data with the
 * given song and calculates totals heard and liked
 * for the song
 * @author Brendan Kelly bmkelly
 * @version 2017.4.18
 *
 */
public class AssociateRegion {

    /**
     * number of ne locals that
     * heard this song
     */
    int neHeard; 
    /**
     * number of ne locals that
     * like this song
     */
    int neLike; 
    /**
     * number of seing locals that
     * heard this song
     */
    int seHeard; 
    /**
     * number of seing locals that
     * like this song
     */
    int seLike; 
    /**
     * number of us locals that
     * heard this song
     */
    int usHeard; 
    /**
     * number of us locals that
     * like this song
     */
    int usLike;
    /**
     * number of other locals that
     * heard this song
     */
    int otherHeard; 
    /**
     * number of other locals that
     * like this song
     */
    int otherLike; 
    /**
     * Location of this songs data
     * in the responses array of the
     * individual people
     */
    int dataLoc; 
    /**
     * total number of ne people
     * who've heard the song
     */
    int totalneHeard; 
    /**
     * total number of seing people
     * who've heard the song
     */
    int totalseHeard; 
    /**
     * total number of us people
     * who've heard the song
     */
    int totalusHeard; 
    /**
     * total number of other people
     * who've heard the song
     */
    int totalotherHeard;
    /**
     * total number of ne people
     * who liked the song
     */
    int totalneLike; 
    /**
     * total number of seing people
     * who liked the song
     */
    int totalseLike; 
    /**
     * total number of us people
     * who liked the song
     */
    int totalusLike; 
    /**
     * total number of other people
     * who liked the song
     */
    int totalotherLike;

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
    public AssociateRegion(Song song, Person[] people) {
        this.song = song;
        this.people = people;
        this.dataLoc = song.getDataLoc();

        absoluteMonstrocity();
    }


    /**
     * This disaster of a method parces the data
     * and keeps track of the total entries for
     * hearing and liking a song for each region
     */
    public void absoluteMonstrocity() {

        for (int i = 0; i < people.length; i++) {
            
            Boolean[] response = people[i].getResponses();
            
            if (people[i].getRegion().equals("Northeast")) {
                
                if (response[dataLoc * 2] != null)
                {
                    totalneHeard++;
                    if (response[dataLoc * 2])
                    {
                        neHeard++;
                    }
                }
                
                if (response[dataLoc * 2 + 1] != null)
                {
                    totalneLike++;
                    if (response[dataLoc * 2 + 1])
                    {
                        neLike++;
                    }
                }
            }
            else if (people[i].getRegion().equals("Southeast")) {
                
                if (response[dataLoc * 2] != null)
                {
                    totalseHeard++;
                    if (response[dataLoc * 2])
                    {
                        seHeard++;
                    }
                }
                
                if (response[dataLoc * 2 + 1] != null)
                {
                    totalseLike++;
                    if (response[dataLoc * 2 + 1])
                    {
                        seLike++;
                    }
                }
            }
            else if (people[i].getRegion().equals("United States "
                + "(other than Southeast or Northwest)")) {
                
                if (response[dataLoc * 2] != null)
                {
                    totalusHeard++;
                    if (response[dataLoc * 2])
                    {
                        usHeard++;
                    }
                }
                
                if (response[dataLoc * 2 + 1] != null)
                {
                    totalusLike++;
                    if (response[dataLoc * 2 + 1])
                    {
                        usLike++;
                    }
                }
            }
            else {
                
                if (response[dataLoc * 2] != null)
                {
                    totalotherHeard++;
                    if (response[dataLoc * 2])
                    {
                        otherHeard++;
                    }
                }
                
                if (response[dataLoc * 2 + 1] != null)
                {
                    totalotherLike++;
                    if (response[dataLoc * 2 + 1])
                    {
                        otherLike++;
                    }
                }
            }
        }
    }


    /**
     * return neHeard
     * @return number of ne hobbiest that heard
     * this song
     */
    public int getneHeard() {
        return neHeard;
    }

    /**
     * return neLike
     * @return number of ne hobbiest that like
     * this song
     */
    public int getneLike() {
        return neLike;
    }

    /**
     * return seHeard
     * @return number of seing hobbiest that heard
     * this song
     */
    public int getseHeard() {
        return seHeard;
    }

    /**
     * return seHeard
     * @return number of seing hobbiest that like
     * this song
     */
    public int getseLike() {
        return seLike;
    }

    /**
     * return usHeard
     * @return number of us hobbiest that heard
     * this song
     */
    public int getusHeard() {
        return usHeard;
    }

    /**
     * return usHeard
     * @return number of us hobbiest that like
     * this song
     */
    public int getusLike() {
        return usLike;
    }

    /**
     * return otherHeard
     * @return number of other hobbiest that heard
     * this song
     */
    public int getotherHeard() {
        return otherHeard;
    }

    /**
     * return otherHeard
     * @return number of other hobbiest that like
     * this song
     */
    public int getotherLike() {
        return otherLike;
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
     * gets percentneHeard
     * @return percentage of ne locals
     * that have heard this song
     */
    public int getPercentneHeard()
    {
        if (totalneHeard == 0)
        {
            return 0;
        }

        return (int)(((float)neHeard / (float)totalneHeard) * 100);
    }
    
    /**
     * gets percentseHeard
     * @return percentage of seing locals
     * that have heard this song
     */
    public int getPercentseHeard()
    {
        if (totalseHeard == 0)
        {
            return 0;
        }

        return (int)(((float)seHeard / (float)totalseHeard) * 100);
    }   
    
    /**
     * gets percentotherHeard
     * @return percentage of other locals
     * that have heard this song
     */
    public int getPercentotherHeard()
    {
        if (totalotherHeard == 0)
        {
            return 0;
        }

        return (int)(((float)otherHeard / (float)totalotherHeard) * 100);
    }   
    
    /**
     * gets percentusHeard
     * @return percentage of us locals
     * that have heard this song
     */
    public int getPercentusHeard()
    {
        if (totalusHeard == 0)
        {
            return 0;
        }

        return (int)(((float)usHeard / (float)totalusHeard) * 100);
    }
    
    //*********************PERCET LIKE GETTERS****************************
    
    /**
     * @return percentage of ne locals that
     * like this song
     */
    public int getPercentneLike()
    {
        if (totalneLike == 0)
        {
            return 0;
        }

        return (int)(((float)neLike / (float)totalneLike) * 100);
    }

    /**
     * @return percentage of seing locals that
     * like this song
     */
    public int getPercentseLike()
    {
        if (totalseLike == 0)
        {
            return 0;
        }
        return (int)(((float)seLike / (float)totalseLike) * 100);
    }

    /**
     * @return percentage of other locals that
     * like this song
     */
    public int getPercentotherLike()
    {
        
        if (totalotherLike == 0)
        {
            return 0;
        }

        return (int)(((float)otherLike / (float)totalotherLike) * 100);
    }

    /**
     * @return percentage of us locals that
     * like this song
     */
    public int getPercentusLike()
    {
        if (totalusLike == 0)
        {
            return 0;
        }

        return (int)(((float)usLike / (float)totalusLike) * 100);
    }

}
