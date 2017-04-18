package prj5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class InputScan
{

    File peopleFile, songFile;

    Scanner songInput;

    int count;

    LinkedList<String> songs;

    String[] survey;

    public InputScan(String peopleFileString, String songFileString)
    {
        peopleFile = new File(peopleFileString);
        songFile = new File(songFileString);

        Person[] peopleArray = getPeople(peopleFile);
        DLList<Song> songList = getSongs(songFile);
        
        AssociateData data = new AssociateData(peopleArray, songList);
        
        AssociateHobby[] testing = data.getHobbyData();
        
        songList.sortGenre();
        Iterator<Song> iter = songList.iterator();
        while (iter.hasNext())
        {
            Song output = (Song)iter.next();
            System.out.println("song title " + output.getTitle());
            System.out.println("song artist " + output.getArtist());
            System.out.println("song genre " + output.getGenre());
            System.out.println("song year " + output.getYear());
            System.out.println("heard");
            System.out.println("reading" + testing[output.getDataLoc()].getPercentReadHeard() + 
                    " art" + testing[output.getDataLoc()].getPercentArtHeard() + 
                    " sports" + testing[output.getDataLoc()].getPercentSportsHeard() + 
                    " music" + testing[output.getDataLoc()].getPercentMusicHeard());
            System.out.println("likes");
            System.out.println("reading" + testing[output.getDataLoc()].getPercentReadLike() + 
                    " art" + testing[output.getDataLoc()].getPercentArtLike() + 
                    " sports" + testing[output.getDataLoc()].getPercentSportsLike() + 
                    " music" + testing[output.getDataLoc()].getPercentMusicLike());

            System.out.println();
        }

        iter = songList.iterator();
        songList.sortTitle();
        while (iter.hasNext())
        {
            Song output = (Song)iter.next();
            System.out.println("song title " + output.getTitle());
            System.out.println("song artist " + output.getArtist());
            System.out.println("song genre " + output.getGenre());
            System.out.println("song year " + output.getYear());
            System.out.println("heard");
            System.out.println("reading" + testing[output.getDataLoc()].getPercentReadHeard() + 
                    " art" + testing[output.getDataLoc()].getPercentArtHeard() + 
                    " sports" + testing[output.getDataLoc()].getPercentSportsHeard() + 
                    " music" + testing[output.getDataLoc()].getPercentMusicHeard());
            System.out.println("likes");
            System.out.println("reading" + testing[output.getDataLoc()].getPercentReadLike() + 
                    " art" + testing[output.getDataLoc()].getPercentArtLike() + 
                    " sports" + testing[output.getDataLoc()].getPercentSportsLike() + 
                    " music" + testing[output.getDataLoc()].getPercentMusicLike());

            System.out.println();
        }
        

        // System.out.println(data.getHobbyData()[0].toString());
        // System.out.println(data.getMajorData()[0].toString());
        // System.out.println(data.getRegionData()[0].toString());
    }

    private DLList<Song> getSongs(File songFile)
    {
        BufferedReader br;
        DLList<Song> listOfSongs = new DLList<Song>();
        String line = "";
        String cvsSplitBy = ",";
        int count = 0;

        try
        {
            br = new BufferedReader(new FileReader(songFile));
            br.readLine();
            while ((line = br.readLine()) != null)
            {
                String[] songData = line.split(cvsSplitBy);

                String title = songData[0];
                String artist = songData[1];
                int year = Integer.parseInt(songData[2]);
                String genre = songData[3];
                Song song = new Song(title, genre, artist, year, count);

                listOfSongs.add(song);
                count++;
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        /**
        int newCount = 0;
        while (arrayOfSongs[newCount] != null)
        {
            newCount++;
        }

        Song[] returnArray = new Song[newCount];

        for (int i = 0; i < returnArray.length; i++)
        {
            returnArray[i] = arrayOfSongs[i];
        }
        */

        return listOfSongs;
    }

    @SuppressWarnings("unused")
    private Person[] getPeople(File peopleFile)
    {
        Person[] arrayOfPersons = new Person[209];
        BufferedReader br;
        String line = "";
        String cvsSplitBy = ",";
        int count = 0;

        try
        {

            br = new BufferedReader(new FileReader(peopleFile));
            br.readLine();
            while ((line = br.readLine()) != null)
            {

                String[] surveyData = line.split(cvsSplitBy);

                if (surveyData.length < 3)
                {
                    continue;
                }

                String major = surveyData[2];
                if (checkEmpty(major))
                {
                    continue;
                }

                String region = surveyData[3];
                if (checkEmpty(region))
                {
                    continue;
                }

                String hobby = surveyData[4];
                if (checkEmpty(hobby))
                {
                    continue;
                }

                Boolean[] responses = new Boolean[118];
                for (int i = 5; i < surveyData.length; i++)
                {
                    String temp = surveyData[i];
                    if (temp.equals("Yes"))
                    {
                        responses[i - 5] = true;
                    } else if (temp.equals("No"))
                    {
                        responses[i - 5] = false;
                    }
                    else
                    {
                        responses[i - 5] = null;
                    }
                }

                Person tempPerson = new Person(hobby, major, region, responses);
                arrayOfPersons[count] = tempPerson;
                count++;
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }

        int newCount = 0;
        while (arrayOfPersons[newCount] != null)
        {
            newCount++;
        }

        Person[] returnArray = new Person[newCount];

        for (int i = 0; i < returnArray.length; i++)
        {
            returnArray[i] = arrayOfPersons[i];
        }

        return returnArray;
    }

    public boolean checkEmpty(String string)
    {
        if (string.length() < 1)
        {
            return true;
        }
        return false;
    }
}
