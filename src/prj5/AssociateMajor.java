package prj5;

public class AssociateMajor {

    int csHeard, csLike, mathHeard, mathLike, engeHeard, engeLike, otherHeard,
        otherLike, dataLoc, totalCS, totalMath, totalEnge, totalOther;

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

            Boolean[] response = people[i].getResponses();
            
            if (response[dataLoc * 2] == null || response[dataLoc * 2 + 1] == null)
            {
                continue;
            }
           
            if (people[i].getHobby().equals("Computer Science")) {
                totalCS++;
                if (response[dataLoc * 2]) {
                    csHeard++;
                }
                
                if (response[dataLoc * 2 + 1]) {
                    csLike++;
                }
            }
            else if (people[i].getHobby().equals("Math or CMDA")) {
                totalMath++;
                if (response[dataLoc * 2]) {
                    mathHeard++;
                }
                
                if (response[dataLoc * 2 + 1]) {
                    mathLike++;
                }

            }
            else if (people[i].getHobby().equals("Other Engineering")) {
                totalEnge++;
                if (response[dataLoc * 2]) {
                    engeHeard++;
                }
                
                if (response[dataLoc * 2 + 1]) {
                    engeLike++;
                }

            }
            else if (people[i].getHobby().equals("Other")) {
                totalOther++;
                if (response[dataLoc * 2]) {
                    otherHeard++;
                }
                
                if (response[dataLoc * 2 + 1]) {
                    otherLike++;
                }
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
