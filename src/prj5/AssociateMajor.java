package prj5;

public class AssociateMajor {

    int csHeard, csLike, mathHeard, mathLike, engeHeard, engeLike, otherHeard,
        otherLike, dataLoc;

    Song song;

    Person[] people;


    public AssociateMajor(Song song, Person[] people) {
        this.song = song;
        this.people = people;
        this.dataLoc = song.getDataLoc();

        absoluteMonstrocity();
    }


    public void absoluteMonstrocity() {
        for (int i = 0; i < people.length; i++) {
            boolean[] response = people[i].getResponses();
            try {
                if (people[i].getMajor().equals("Computer Science")) {
                    if (!response[dataLoc * 2]) {
                        continue;
                    }
                    csHeard++;
                    if (response[dataLoc * 2 + 1]) {
                        csLike++;
                    }
                }
                else if (people[i].getMajor().equals("Math or CMDA")) {
                    if (!response[dataLoc * 2]) {
                        continue;
                    }
                    mathHeard++;
                    if (response[dataLoc * 2 + 1]) {
                        mathLike++;
                    }

                }
                else if (people[i].getMajor().equals(
                    "Other")) {
                    if (!response[dataLoc * 2]) {
                        continue;
                    }
                    otherHeard++;
                    if (response[dataLoc * 2 + 1]) {
                        otherLike++;
                    }

                }
                else if (people[i].getMajor().equals(
                    "Other Engineering")) {
                    if (!response[dataLoc * 2]) {
                        continue;
                    }
                    engeHeard++;
                    if (response[dataLoc * 2 + 1]) {
                        engeLike++;
                    }
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    public int getCsHeard() {
        return csHeard;
    }


    public int getCSLike() {
        return csLike;
    }


    public int getMathHeard() {
        return mathHeard;
    }


    public int getMathLike() {
        return mathLike;
    }


    public int getEngeHeard() {
        return engeHeard;
    }


    public int getEngeLike() {
        return engeLike;
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
    
    public String toString()
    {
        return "Computer Science Heard: " + csHeard + " | Computer Science Like: " + csLike;
    }

}
