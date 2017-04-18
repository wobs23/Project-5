package prj5;

/**
 * Associates the Major data with the
 * given song and calculates totals heard and liked
 * for the song
 * @author Brendan Kelly bmkelly
 * @version 2017.4.18
 *
 */
public class AssociateMajor {

    /**
     * number of cs majors that
     * heard this song
     */
    int csHeard; 
    /**
     * number of cs majors that
     * like this song
     */
    int csLike; 
    /**
     * number of mathing majors that
     * heard this song
     */
    int mathHeard; 
    /**
     * number of mathing majors that
     * like this song
     */
    int mathLike; 
    /**
     * number of enge majors that
     * heard this song
     */
    int engeHeard; 
    /**
     * number of enge majors that
     * like this song
     */
    int engeLike;
    /**
     * number of other majors that
     * heard this song
     */
    int otherHeard; 
    /**
     * number of other majors that
     * like this song
     */
    int otherLike; 
    /**
     * Location of this songs data
     * in the responmaths array of the
     * individual people
     */
    int dataLoc; 
    /**
     * total number of cs people
     * who've heard the song
     */
    int totalcsHeard; 
    /**
     * total number of mathing people
     * who've heard the song
     */
    int totalmathHeard; 
    /**
     * total number of enge people
     * who've heard the song
     */
    int totalengeHeard; 
    /**
     * total number of other people
     * who've heard the song
     */
    int totalotherHeard;
    /**
     * total number of cs people
     * who liked the song
     */
    int totalcsLike; 
    /**
     * total number of mathing people
     * who liked the song
     */
    int totalmathLike; 
    /**
     * total number of enge people
     * who liked the song
     */
    int totalengeLike; 
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
    public AssociateMajor(Song song, Person[] people) {
        this.song = song;
        this.people = people;
        this.dataLoc = song.getDataLoc();

        absoluteMonstrocity();
    }


    /**
     * This disaster of a method parces the data
     * and keeps track of the total entries for
     * hearing and liking a song for each Major
     */
    public void absoluteMonstrocity() {

        for (int i = 0; i < people.length; i++) {
            
            Boolean[] responmath = people[i].getResponses();
            
            if (people[i].getMajor().equals("Computer Science")) {
                
                if (responmath[dataLoc * 2] != null)
                {
                    totalcsHeard++;
                    if (responmath[dataLoc * 2])
                    {
                        csHeard++;
                    }
                }
                
                if (responmath[dataLoc * 2 + 1] != null)
                {
                    totalcsLike++;
                    if (responmath[dataLoc * 2 + 1])
                    {
                        csLike++;
                    }
                }
            }
            else if (people[i].getMajor().equals("Math or CMDA")) {
                
                if (responmath[dataLoc * 2] != null)
                {
                    totalmathHeard++;
                    if (responmath[dataLoc * 2])
                    {
                        mathHeard++;
                    }
                }
                
                if (responmath[dataLoc * 2 + 1] != null)
                {
                    totalmathLike++;
                    if (responmath[dataLoc * 2 + 1])
                    {
                        mathLike++;
                    }
                }
            }
            else if (people[i].getMajor().equals("Other Engineering")) {
                
                if (responmath[dataLoc * 2] != null)
                {
                    totalengeHeard++;
                    if (responmath[dataLoc * 2])
                    {
                        engeHeard++;
                    }
                }
                
                if (responmath[dataLoc * 2 + 1] != null)
                {
                    totalengeLike++;
                    if (responmath[dataLoc * 2 + 1])
                    {
                        engeLike++;
                    }
                }
            }
            else {
                
                if (responmath[dataLoc * 2] != null)
                {
                    totalotherHeard++;
                    if (responmath[dataLoc * 2])
                    {
                        otherHeard++;
                    }
                }
                
                if (responmath[dataLoc * 2 + 1] != null)
                {
                    totalotherLike++;
                    if (responmath[dataLoc * 2 + 1])
                    {
                        otherLike++;
                    }
                }
            }
        }
    }


    /**
     * return csHeard
     * @return number of cs hobbiest that heard
     * this song
     */
    public int getcsHeard() {
        return csHeard;
    }

    /**
     * return csLike
     * @return number of cs hobbiest that like
     * this song
     */
    public int getcsLike() {
        return csLike;
    }

    /**
     * return mathHeard
     * @return number of mathing hobbiest that heard
     * this song
     */
    public int getmathHeard() {
        return mathHeard;
    }

    /**
     * return mathHeard
     * @return number of mathing hobbiest that like
     * this song
     */
    public int getmathLike() {
        return mathLike;
    }

    /**
     * return engeHeard
     * @return number of enge hobbiest that heard
     * this song
     */
    public int getengeHeard() {
        return engeHeard;
    }

    /**
     * return engeHeard
     * @return number of enge hobbiest that like
     * this song
     */
    public int getengeLike() {
        return engeLike;
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
     * @return location in responmaths array 
     * for an individual person
     */
    public int getDataLoc() {
        return dataLoc;
    }
    
    //*********************PERCET HEARD GETTERS****************************
    
    /**
     * gets percentcsHeard
     * @return percentage of cs majors
     * that have heard this song
     */
    public int getPercentcsHeard()
    {
        if (totalcsHeard == 0)
        {
            return 0;
        }

        return (int)(((float)csHeard / (float)totalcsHeard) * 100);
    }
    
    /**
     * gets percentmathHeard
     * @return percentage of mathing majors
     * that have heard this song
     */
    public int getPercentmathHeard()
    {
        if (totalmathHeard == 0)
        {
            return 0;
        }

        return (int)(((float)mathHeard / (float)totalmathHeard) * 100);
    }   
    
    /**
     * gets percentotherHeard
     * @return percentage of other majors
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
     * gets percentengeHeard
     * @return percentage of enge majors
     * that have heard this song
     */
    public int getPercentengeHeard()
    {
        if (totalengeHeard == 0)
        {
            return 0;
        }

        return (int)(((float)engeHeard / (float)totalengeHeard) * 100);
    }
    
    //*********************PERCET LIKE GETTERS****************************
    
    /**
     * @return percentage of cs majors that
     * like this song
     */
    public int getPercentcsLike()
    {
        if (totalcsLike == 0)
        {
            return 0;
        }

        return (int)(((float)csLike / (float)totalcsLike) * 100);
    }

    /**
     * @return percentage of mathing majors that
     * like this song
     */
    public int getPercentmathLike()
    {
        if (totalmathLike == 0)
        {
            return 0;
        }
        return (int)(((float)mathLike / (float)totalmathLike) * 100);
    }

    /**
     * @return percentage of other majors that
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
     * @return percentage of enge majors that
     * like this song
     */
    public int getPercentengeLike()
    {
        if (totalengeLike == 0)
        {
            return 0;
        }

        return (int)(((float)engeLike / (float)totalengeLike) * 100);
    }

}

