package prj5;

import student.TestCase;
import student.testingsupport.annotations.Hint;

/**
 * Test text output for Music Visualization Project
 * 
 * @author Brendan Kelly bmkelly
 * @version 2017.4.18
 */
public class RegionDataTest extends TestCase
{

    /**
     * Test the program with the class survey data from 6 students about only 1
     * song. Gathers the output from StdOut and compares it to the expect output
     * as stored in Output2TitleGenreHobby.txt
     * 
     */
    @Hint("main working properly with MusineurveyDataTest2, SongListTest2")
    public void testMain2()
    {

        InputScan input = new InputScan("MusicSurveyDataTest2.csv", 
            "SongListTest2.csv");

                
        AssociateData data = input.getData();
        AssociateRegion[] region = data.getRegionData();
        
        assertEquals(region[0].getneHeard(), 0);
        assertEquals(region[0].getneLike(), 0);
        assertEquals(region[0].getotherHeard(), 0);
        assertEquals(region[0].getotherLike(), 0);
        assertEquals(region[0].getseHeard(), 2);
        assertEquals(region[0].getseLike(), 3);
        assertEquals(region[0].getusHeard(), 0);
        assertEquals(region[0].getusLike(), 0);
        assertEquals(region[0].getPercentneHeard(), 0);
        assertEquals(region[0].getPercentneLike(), 0);
        assertEquals(region[0].getPercentotherHeard(), 0);
        assertEquals(region[0].getPercentotherLike(), 0);
        assertEquals(region[0].getPercentseHeard(), 33);
        assertEquals(region[0].getPercentseLike(), 50);
        assertEquals(region[0].getPercentusHeard(), 0);
        assertEquals(region[0].getPercentusLike(), 0);

    }

    /**
     * Test the program with the actual class survey data Gathers the output
     * from StdOut and compares it to the expect output as stored in
     * OutputTitleGenreHobby.txt
     */
     
    @Hint("The main method is not working properly with input files "
            + "MusineurveyDataNoGenreRepeats.nev and SongLisNoGenreRepeats.nev")
    public void testMain3()
    {

        InputScan input = new InputScan("MusicSurveyDataNoGenreRepeats.csv", 
            "SongListNoGenreRepeats.csv");

        AssociateData data = input.getData();
        AssociateRegion[] region = data.getRegionData();
        
        assertEquals(region[0].getneHeard(), 15);
        assertEquals(region[0].getneLike(), 10);
        assertEquals(region[0].getotherHeard(), 0);
        assertEquals(region[0].getotherLike(), 0);
        assertEquals(region[0].getseHeard(), 56);
        assertEquals(region[0].getseLike(), 59);
        assertEquals(region[0].getusHeard(), 3);
        assertEquals(region[0].getusLike(), 3);
        assertEquals(region[0].getPercentneHeard(), 46);
        assertEquals(region[0].getPercentneLike(), 33);
        assertEquals(region[0].getPercentotherHeard(), 0);
        assertEquals(region[0].getPercentotherLike(), 0);
        assertEquals(region[0].getPercentseHeard(), 36);
        assertEquals(region[0].getPercentseLike(), 40);
        assertEquals(region[0].getPercentusHeard(), 37);
        assertEquals(region[0].getPercentusLike(), 37);

    }
    
    
}

