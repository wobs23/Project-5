package prj5;

public class AssociateHobby {

    int sportsHeard, sportsLike, readHeard, readLike, musicHeard, musicLike,
        artHeard, artLike, dataLoc, totalSports, totalRead, totalMusic, totalArt;

    Song song;

    Person[] people;


    public AssociateHobby(Song song, Person[] people) {
        this.song = song;
        this.people = people;
        this.dataLoc = song.getDataLoc();

        absoluteMonstrocity();
    }


    public void absoluteMonstrocity() {

        for (int i = 0; i < people.length; i++) {
            
            Boolean[] response = people[i].getResponses();
            
            if (people[i].getHobby().equals("sports")) {
                totalSports++;
                if (response[dataLoc * 2] == null)
                {
                    if (response[dataLoc * 2 + 1] == null)
                    {
                        continue;
                    }
                    
                    if (response[dataLoc * 2 + 1])
                    {
                        sportsHeard++;
                        sportsLike++;
                    }
                    continue;
                }
                else if (response[dataLoc * 2]) {
                    sportsHeard++;
                }
                
                if (response[dataLoc * 2 + 1] == null)
                {
                    sportsHeard--;
                    totalSports--;
                    continue;
                }
                
                if (response[dataLoc * 2 + 1]) {
                    sportsLike++;
                }
            }
            else if (people[i].getHobby().equals("reading")) {
                totalRead++;
                if (response[dataLoc * 2] == null)
                {
                    
                    if (response[dataLoc * 2 + 1] == null)
                    {
                        continue;
                    }
                    
                    if (response[dataLoc * 2 + 1])
                    {
                        readHeard++;
                        readLike++;
                    }
                    continue;
                }
                else if (response[dataLoc * 2]) {
                    readHeard++;
                }
                
                if (response[dataLoc * 2 + 1] == null)
                {
                    continue;
                }
                
                if (response[dataLoc * 2 + 1]) {
                    readLike++;
                }

            }
            else if (people[i].getHobby().equals("music")) {
                totalMusic++;
                if (response[dataLoc * 2] == null)
                {
                    
                    if (response[dataLoc * 2 + 1] == null)
                    {
                        continue;
                    }
                    
                    if (response[dataLoc * 2 + 1])
                    {
                        musicHeard++;
                        musicLike++;
                    }
                    continue;
                }
                else if (response[dataLoc * 2]) {
                    musicHeard++;
                }
                
                if (response[dataLoc * 2 + 1] == null)
                {
                    continue;
                }
                
                if (response[dataLoc * 2 + 1]) {
                    musicLike++;
                }

            }
            else if (people[i].getHobby().equals("art")) {
                totalArt++;
                if (response[dataLoc * 2] == null)
                {
                    
                    if (response[dataLoc * 2 + 1] == null)
                    {
                        continue;
                    }
                    
                    if (response[dataLoc * 2 + 1])
                    {
                        artHeard++;
                        artLike++;
                    }
                    continue;
                }
                else if (response[dataLoc * 2]) {
                    artHeard++;
                }
                
                if (response[dataLoc * 2 + 1] == null)
                {
                    continue;
                }
                
                if (response[dataLoc * 2 + 1]) {
                    artLike++;
                }
            }
        }
    }


    public int getSportsHeard() {
        return sportsHeard;
    }


    public int getSportsLike() {
        return sportsLike;
    }


    public int getReadHeard() {
        return readHeard;
    }


    public int getReadLike() {
        return readLike;
    }


    public int getMusicHeard() {
        return musicHeard;
    }


    public int getMusicLike() {
        return musicLike;
    }


    public int getArtHeard() {
        return artHeard;
    }


    public int getArtLike() {
        return artLike;
    }


    public int getDataLoc() {
        return dataLoc;
    }
    //*********************PERCET HEARD GETTERS****************************
    
    public int getPercentSportsHeard()
    {
        if (totalSports == 0)
        {
            return 0;
        }
        
        return Math.round((((float)sportsHeard / (float)totalSports) * 100));
    }
    
    public int getPercentReadHeard()
    {
        if (totalRead == 0)
        {
            return 0;
        }
        
        return Math.round((((float)readHeard / (float)totalRead) * 100));
    }
    
    public int getPercentArtHeard()
    {
        //System.out.println(song.getTitle() + " " + totalArt + " " + artHeard);
        if (totalArt == 0)
        {
            return 0;
        }
        
        return Math.round((((float)artHeard / (float)totalArt) * 100));
    }
    
    public int getPercentMusicHeard()
    {
        if (totalMusic == 0)
        {
            return 0;
        }
        
        return Math.round((((float)musicHeard / (float)totalMusic) * 100));
    }
    
    //*********************PERCET LIKE GETTERS****************************
    public int getPercentSportsLike()
    {
        if (totalSports == 0)
        {
            return 0;
        }
        
        return Math.round((((float)sportsLike / (float)totalSports) * 100));
    }
    
    public int getPercentReadLike()
    {
        if (totalRead == 0)
        {
            return 0;
        }
        
        return Math.round((((float)readLike / (float)totalRead) * 100));
    }
    
    public int getPercentArtLike()
    {
        
        if (totalArt == 0)
        {
            return 0;
        }
        
        return Math.round((((float)artLike / (float)totalArt) * 100));
    }
    
    public int getPercentMusicLike()
    {
        if (totalMusic == 0)
        {
            return 0;
        }
        
        return Math.round((((float)musicLike / (float)totalMusic) * 100));
    }


    public String toString() {
        return "Sports Heard: " + sportsHeard + " | Sports Like: " + sportsLike;
    }

}
