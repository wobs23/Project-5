package prj5;

public class AssociateRegion {

    int seHeard, seLike, neHeard, neLike, usHeard, usLike, otherHeard,
        otherLike, dataLoc, seTotal, neTotal, usTotal, otherTotal;

    Song song;

    Person[] people;


    public AssociateRegion(Song song, Person[] people) {
        this.song = song;
        this.people = people;
        this.dataLoc = song.getDataLoc();

        absoluteMonstrocity();
    }


    public void absoluteMonstrocity() {
        for (int i = 0; i < people.length; i++) {

            Boolean[] response = people[i].getResponses();
            
            if (response[dataLoc * 2] == null || response[dataLoc * 2 + 1] == null)
            {
                continue;
            }
           
            if (people[i].getHobby().equals("Southeast")) {
                seTotal++;
                if (response[dataLoc * 2]) {
                    seHeard++;
                }
                
                if (response[dataLoc * 2 + 1]) {
                    seLike++;
                }
            }
            else if (people[i].getHobby().equals("Northeast")) {
                neTotal++;
                if (response[dataLoc * 2]) {
                    neHeard++;
                }
                
                if (response[dataLoc * 2 + 1]) {
                    neLike++;
                }

            }
            else if (people[i].getHobby().equals("United States (other than Southeast or Northwest)")) {
                usTotal++;
                if (response[dataLoc * 2]) {
                    usHeard++;
                }
                
                if (response[dataLoc * 2 + 1]) {
                    usLike++;
                }

            }
            else if (people[i].getHobby().equals("Outside of United States")) {
                otherTotal++;
                if (response[dataLoc * 2]) {
                    otherHeard++;
                }
                
                if (response[dataLoc * 2 + 1]) {
                    otherLike++;
                }
            }
        }
    }


    public int getSeHeard() {
        return seHeard;
    }


    public int getSeLike() {
        return seLike;
    }


    public int getNeHeard() {
        return neHeard;
    }


    public int getNeLike() {
        return neLike;
    }


    public int getUsHeard() {
        return usHeard;
    }


    public int getUsLike() {
        return usLike;
    }


    public int getOtherHeard() {
        return otherHeard;
    }


    public int getOtherLike() {
        return otherLike;
    }


    public int getDataLoc() {
        return dataLoc;
    }


    public String toString() {
        return "South East Heard: " + seHeard + " | South East Like: " + seLike;
    }

}
