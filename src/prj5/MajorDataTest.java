package prj5;

import student.TestCase;
import student.testingsupport.annotations.Hint;

/**
 * Test text output for Music Visualization Project
 * 
 * @author Brendan Kelly bmkelly
 * @version 2017.4.18
 */
public class MajorDataTest extends TestCase
{

    /**
     * Test the program with the class survey data from 6 students about only 1
     * song. Gathers the output from StdOut and compares it to the expect output
     * as stored in Output2TitleGenreHobby.txt
     * 
     */
    @Hint("main working properly with MusicSurveyDataTest2, SongListTest2")
    public void testMain2()
    {

        Input.main(new String[] { "MusicSurveyDataTest2.csv", 
            "SongListTest2.csv" });

                
        AssociateData data = Input.input.getData();
        AssociateMajor[] major = data.getMajorData();
        
        assertEquals(major[0].getcsHeard(), 1);
        assertEquals(major[0].getcsLike(), 2);
        assertEquals(major[0].getotherHeard(), 0);
        assertEquals(major[0].getotherLike(), 0);
        assertEquals(major[0].getengeHeard(), 0);
        assertEquals(major[0].getengeLike(), 0);
        assertEquals(major[0].getmathHeard(), 1);
        assertEquals(major[0].getmathLike(), 1);
        assertEquals(major[0].getPercentcsHeard(), 33);
        assertEquals(major[0].getPercentcsLike(), 66);
        assertEquals(major[0].getPercentotherHeard(), 0);
        assertEquals(major[0].getPercentotherLike(), 0);
        assertEquals(major[0].getPercentengeHeard(), 0);
        assertEquals(major[0].getPercentengeLike(), 0);
        assertEquals(major[0].getPercentmathHeard(), 33);
        assertEquals(major[0].getPercentmathLike(), 33);

    }

    /**
     * Test the program with the actual class survey data Gathers the output
     * from StdOut and compares it to the expect output as stored in
     * OutputTitleGenreHobby.txt
     */
     
    @Hint("The main method is not working properly with input files "
            + "MusicSurveyDataNoGenreRepeats.csv and SongLisNoGenreRepeats.csv")
    public void testMain3()
    {

        Input.main(new String[] { "MusicSurveyDataNoGenreRepeats.csv", 
            "SongListNoGenreRepeats.csv" });

        AssociateData data = Input.input.getData();
        AssociateMajor[] major = data.getMajorData();
        
        assertEquals(major[0].getcsHeard(), 37);
        assertEquals(major[0].getcsLike(), 34);
        assertEquals(major[0].getotherHeard(), 15);
        assertEquals(major[0].getotherLike(), 16);
        assertEquals(major[0].getengeHeard(), 14);
        assertEquals(major[0].getengeLike(), 15);
        assertEquals(major[0].getmathHeard(), 8);
        assertEquals(major[0].getmathLike(), 7);
        assertEquals(major[0].getPercentcsHeard(), 33);
        assertEquals(major[0].getPercentcsLike(), 32);
        assertEquals(major[0].getPercentotherHeard(), 48);
        assertEquals(major[0].getPercentotherLike(), 53);
        assertEquals(major[0].getPercentengeHeard(), 42);
        assertEquals(major[0].getPercentengeLike(), 50);
        assertEquals(major[0].getPercentmathHeard(), 28);
        assertEquals(major[0].getPercentmathLike(), 28);

    }
}

