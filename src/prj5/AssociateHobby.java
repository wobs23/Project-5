package prj5;

public class AssociateHobby {

    int sportsHeard, sportsLike, readHeard, readLike, musicHeard, musicLike,
        artHeard, artLike, dataLoc;

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
            boolean[] response = people[i].getResponses();
            
            //System.out.println("Person Number " + i + ": " + response[(dataLoc * 2 + 1)]);
            
            if (people[i].getHobby().equals("sports")) {
                if (!response[dataLoc * 2]) {
                    continue;
                }
                sportsHeard++;
                if (response[dataLoc * 2 + 1]) {
                    sportsLike++;
                }
            }
            else if (people[i].getHobby().equals("reading")) {
                if (!response[dataLoc * 2]) {
                    continue;
                }
                readHeard++;
                if (response[dataLoc * 2 + 1]) {
                    readLike++;
                }

            }
            else if (people[i].getHobby().equals("music")) {
                if (!response[dataLoc * 2]) {
                    continue;
                }
                musicHeard++;
                if (response[dataLoc * 2 + 1]) {
                    musicLike++;
                }

            }
            else if (people[i].getHobby().equals("art")) {
                if (!response[dataLoc * 2]) {
                    continue;
                }
                artHeard++;
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


    public String toString() {
        return "Sports Heard: " + sportsHeard + " | Sports Like: " + sportsLike;
    }

}
