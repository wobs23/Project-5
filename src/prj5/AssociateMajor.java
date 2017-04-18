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
     * number of math majors that
     * heard this song
     */
    int mathHeard; 
    /**
     * number of math majors that
     * like this song
     */
    int mathLike; 
    /**
     * Location of this songs data
     * in the responses array of the
     * individual people
     */
    int dataLoc; 
    /**
     * total number of cs people
     * with non-null responses
     */
    int totalcs; 
    /**
     * total number of other people
     * with non-null responses
     */
    int totalother; 
    /**
     * total number of enge people
     * with non-null responses
     */
    int totalenge; 
    /**
     * total number of math people
     * with non-null responses
     */
    int totalmath;

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
            
            //Do they like cs?
            if (people[i].getMajor().equals("Computer Science")) {
                //Add to total cs
                totalcs++;
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
                        csHeard++;
                        csLike++;
                    }
                    continue;
                }
                //If person heard song is not null
                else if (response[dataLoc * 2]) {
                    //add one to heard!
                    csHeard++;
                    
                    if (response[dataLoc * 2 + 1] == null)
                    {
                        //Remove the one we added earlier
                        //from total and heard
                        csHeard--;
                        totalcs--;
                        continue;
                    }
                }
                //We only get here if heard is not null
                //Is like null?
                if (response[dataLoc * 2 + 1] == null)
                {
                    //remove form total added earlier
                    totalcs--;
                    continue;
                }
                
                //Did they like it?
                if (response[dataLoc * 2 + 1]) {
                    //Add one to like!
                    csLike++;
                }
            }
            else if (people[i].getMajor().equals("Other")) {
              //Add to total cs
                totalother++;
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
                        otherHeard++;
                        otherLike++;
                    }
                    continue;
                }
                //If person heard song is not null
                else if (response[dataLoc * 2]) {
                    //add one to heard!
                    otherHeard++;
                    
                    if (response[dataLoc * 2 + 1] == null)
                    {
                        //Remove the one we added earlier
                        //from total and heard
                        otherHeard--;
                        totalother--;
                        continue;
                    }
                }
                //We only get here if heard is not null
                //Is like null?
                if (response[dataLoc * 2 + 1] == null)
                {
                    //remove form total added earlier
                    totalother--;
                    continue;
                }
                
                //Did they like it?
                if (response[dataLoc * 2 + 1]) {
                    //Add one to like!
                    otherLike++;
                }

            }
            else if (people[i].getMajor().equals("Other Engineering")) {
              //Add to total enge
                totalenge++;
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
                        engeHeard++;
                        engeLike++;
                    }
                    continue;
                }
                //If person heard song is not null
                else if (response[dataLoc * 2]) {
                    //add one to heard!
                    engeHeard++;
                    
                    if (response[dataLoc * 2 + 1] == null)
                    {
                        //Remove the one we added earlier
                        //from total and heard
                        engeHeard--;
                        totalenge--;
                        continue;
                    }
                }
                //We only get here if heard is not null
                //Is like null?
                if (response[dataLoc * 2 + 1] == null)
                {
                    //remove form total added earlier
                    totalenge--;
                    continue;
                }
                
                //Did they like it?
                if (response[dataLoc * 2 + 1]) {
                    //Add one to like!
                    engeLike++;
                }

            }
            else if (people[i].getMajor().equals("Math or CMDA")) {
              //Add to total math
                totalmath++;
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
                        mathHeard++;
                        mathLike++;
                    }
                    continue;
                }
                //If person heard song is not null
                else if (response[dataLoc * 2]) {
                    //add one to heard!
                    mathHeard++;
                    
                    if (response[dataLoc * 2 + 1] == null)
                    {
                        //Remove the one we added earlier
                        //from total and heard
                        mathHeard--;
                        totalmath--;
                        continue;
                    }
                }
                //We only get here if heard is not null
                //Is like null?
                if (response[dataLoc * 2 + 1] == null)
                {
                    //remove form total added earlier
                    totalmath--;
                    continue;
                }
                
                //Did they like it?
                if (response[dataLoc * 2 + 1]) {
                    //Add one to like!
                    mathLike++;
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
     * return mathHeard
     * @return number of math hobbiest that heard
     * this song
     */
    public int getmathHeard() {
        return mathHeard;
    }

    /**
     * return mathHeard
     * @return number of math hobbiest that like
     * this song
     */
    public int getmathLike() {
        return mathLike;
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
     * gets percentcsHeard
     * @return percentage of cs majors
     * that have heard this song
     */
    public int getPercentcsHeard()
    {
        if (totalcs == 0)
        {
            return 0;
        }
        
        return Math.round((((float)csHeard / (float)totalcs) * 100));
    }
    
    /**
     * gets percentotherHeard
     * @return percentage of other majors
     * that have heard this song
     */
    public int getPercentotherHeard()
    {
        if (totalother == 0)
        {
            return 0;
        }
        
        return Math.round((((float)otherHeard / (float)totalother) * 100));
    }   
    
    /**
     * gets percentmathHeard
     * @return percentage of math majors
     * that have heard this song
     */
    public int getPercentmathHeard()
    {
        if (totalmath == 0)
        {
            return 0;
        }
        
        return Math.round((((float)mathHeard / (float)totalmath) * 100));
    }   
    
    /**
     * gets percentengeHeard
     * @return percentage of enge majors
     * that have heard this song
     */
    public int getPercentengeHeard()
    {
        if (totalenge == 0)
        {
            return 0;
        }
        
        return Math.round((((float)engeHeard / (float)totalenge) * 100));
    }
    
    //*********************PERCET LIKE GETTERS****************************
    
    /**
     * @return percentage of cs majors that
     * like this song
     */
    public int getPercentcsLike()
    {
        if (totalcs == 0)
        {
            return 0;
        }
        
        return Math.round((((float)csLike / (float)totalcs) * 100));
    }

    /**
     * @return percentage of other majors that
     * like this song
     */
    public int getPercentotherLike()
    {
        if (totalother == 0)
        {
            return 0;
        }
        
        return Math.round((((float)otherLike / (float)totalother) * 100));
    }

    /**
     * @return percentage of math majors that
     * like this song
     */
    public int getPercentmathLike()
    {
        
        if (totalmath == 0)
        {
            return 0;
        }
        
        return Math.round((((float)mathLike / (float)totalmath) * 100));
    }

    /**
     * @return percentage of enge majors that
     * like this song
     */
    public int getPercentengeLike()
    {
        if (totalenge == 0)
        {
            return 0;
        }
        
        return Math.round((((float)engeLike / (float)totalenge) * 100));
    }

    
    /**
     * returns data as a string
     * @return a bit of dat just for testing purposes as a string
     */
    public String toString() {
        return "cs Heard: " + csHeard + " | cs Like: " + csLike;
    }

}
