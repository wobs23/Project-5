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
     * number of othering locals that
     * heard this song
     */
    int otherHeard; 
    /**
     * number of othering locals that
     * like this song
     */
    int otherLike; 
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
     * number of se locals that
     * heard this song
     */
    int seHeard; 
    /**
     * number of se locals that
     * like this song
     */
    int seLike; 
    /**
     * Location of this songs data
     * in the responses array of the
     * individual people
     */
    int dataLoc; 
    /**
     * total number of ne people
     * with non-null responses
     */
    int totalne; 
    /**
     * total number of othering people
     * with non-null responses
     */
    int totalother; 
    /**
     * total number of us people
     * with non-null responses
     */
    int totalus; 
    /**
     * total number of se people
     * with non-null responses
     */
    int totalse;

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
            
            //Do they like ne?
            if (people[i].getRegion().equals("ne")) {
                //Add to total ne
                totalne++;
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
                        neHeard++;
                        neLike++;
                    }
                    continue;
                }
                //If person heard song is not null
                else if (response[dataLoc * 2]) {
                    //add one to heard!
                    neHeard++;
                    
                    if (response[dataLoc * 2 + 1] == null)
                    {
                        //Remove the one we added earlier
                        //from total and heard
                        neHeard--;
                        totalne--;
                        continue;
                    }
                }
                //We only get here if heard is not null
                //Is like null?
                if (response[dataLoc * 2 + 1] == null)
                {
                    //remove form total added earlier
                    totalne--;
                    continue;
                }
                
                //Did they like it?
                if (response[dataLoc * 2 + 1]) {
                    //Add one to like!
                    neLike++;
                }
            }
            else if (people[i].getRegion().equals("othering")) {
              //Add to total ne
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
            else if (people[i].getRegion().equals("us")) {
              //Add to total us
                totalus++;
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
                        usHeard++;
                        usLike++;
                    }
                    continue;
                }
                //If person heard song is not null
                else if (response[dataLoc * 2]) {
                    //add one to heard!
                    usHeard++;
                    
                    if (response[dataLoc * 2 + 1] == null)
                    {
                        //Remove the one we added earlier
                        //from total and heard
                        usHeard--;
                        totalus--;
                        continue;
                    }
                }
                //We only get here if heard is not null
                //Is like null?
                if (response[dataLoc * 2 + 1] == null)
                {
                    //remove form total added earlier
                    totalus--;
                    continue;
                }
                
                //Did they like it?
                if (response[dataLoc * 2 + 1]) {
                    //Add one to like!
                    usLike++;
                }

            }
            else if (people[i].getRegion().equals("se")) {
              //Add to total se
                totalse++;
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
                        seHeard++;
                        seLike++;
                    }
                    continue;
                }
                //If person heard song is not null
                else if (response[dataLoc * 2]) {
                    //add one to heard!
                    seHeard++;
                    
                    if (response[dataLoc * 2 + 1] == null)
                    {
                        //Remove the one we added earlier
                        //from total and heard
                        seHeard--;
                        totalse--;
                        continue;
                    }
                }
                //We only get here if heard is not null
                //Is like null?
                if (response[dataLoc * 2 + 1] == null)
                {
                    //remove form total added earlier
                    totalse--;
                    continue;
                }
                
                //Did they like it?
                if (response[dataLoc * 2 + 1]) {
                    //Add one to like!
                    seLike++;
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
     * return otherHeard
     * @return number of othering hobbiest that heard
     * this song
     */
    public int getotherHeard() {
        return otherHeard;
    }

    /**
     * return otherHeard
     * @return number of othering hobbiest that like
     * this song
     */
    public int getotherLike() {
        return otherLike;
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
     * return seHeard
     * @return number of se hobbiest that heard
     * this song
     */
    public int getseHeard() {
        return seHeard;
    }

    /**
     * return seHeard
     * @return number of se hobbiest that like
     * this song
     */
    public int getseLike() {
        return seLike;
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
        if (totalne == 0)
        {
            return 0;
        }
        
        return Math.round((((float)neHeard / (float)totalne) * 100));
    }
    
    /**
     * gets percentotherHeard
     * @return percentage of othering locals
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
     * gets percentseHeard
     * @return percentage of se locals
     * that have heard this song
     */
    public int getPercentseHeard()
    {
        if (totalse == 0)
        {
            return 0;
        }
        
        return Math.round((((float)seHeard / (float)totalse) * 100));
    }   
    
    /**
     * gets percentusHeard
     * @return percentage of us locals
     * that have heard this song
     */
    public int getPercentusHeard()
    {
        if (totalus == 0)
        {
            return 0;
        }
        
        return Math.round((((float)usHeard / (float)totalus) * 100));
    }
    
    //*********************PERCET LIKE GETTERS****************************
    
    /**
     * @return percentage of ne locals that
     * like this song
     */
    public int getPercentneLike()
    {
        if (totalne == 0)
        {
            return 0;
        }
        
        return Math.round((((float)neLike / (float)totalne) * 100));
    }

    /**
     * @return percentage of othering locals that
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
     * @return percentage of se locals that
     * like this song
     */
    public int getPercentseLike()
    {
        
        if (totalse == 0)
        {
            return 0;
        }
        
        return Math.round((((float)seLike / (float)totalse) * 100));
    }

    /**
     * @return percentage of us locals that
     * like this song
     */
    public int getPercentusLike()
    {
        if (totalus == 0)
        {
            return 0;
        }
        
        return Math.round((((float)usLike / (float)totalus) * 100));
    }

    
    /**
     * returns data as a string
     * @return a bit of dat just for testing purposes as a string
     */
    public String toString() {
        return "ne Heard: " + neHeard + " | ne Like: " + neLike;
    }

}
