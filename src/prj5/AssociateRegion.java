package prj5;

public class AssociateRegion {

    int seHeard, seLike, neHeard, neLike, usHeard, usLike, otherHeard,
        otherLike, dataLoc;

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
            boolean[] response = people[i].getResponses();
            try {
                if (people[i].getRegion().equals("Southeast")) {
                    if (!response[dataLoc * 2]) {
                        continue;
                    }
                    seHeard++;
                    if (response[dataLoc * 2 + 1]) {
                        seLike++;
                    }
                }
                else if (people[i].getRegion().equals("Northeast")) {
                    if (!response[dataLoc * 2]) {
                        continue;
                    }
                    neHeard++;
                    if (response[dataLoc * 2 + 1]) {
                        neLike++;
                    }

                }
                else if (people[i].getRegion().equals(
                    "Outside of United States")) {
                    if (!response[dataLoc * 2]) {
                        continue;
                    }
                    usHeard++;
                    if (response[dataLoc * 2 + 1]) {
                        usLike++;
                    }

                }
                else if (people[i].getRegion().equals(
                    "United States (other than Southeast or Northwest)")) {
                    if (!response[dataLoc * 2]) {
                        continue;
                    }
                    otherHeard++;
                    if (response[dataLoc * 2 + 1]) {
                        otherLike++;
                    }
                }
            }
            catch (Exception e) {
                e.printStackTrace();
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
