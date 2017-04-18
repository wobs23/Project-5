package prj5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.Scanner;

public class InputScan {

    File peopleFile, songFile;

    Scanner songInput;

    int count;

    LinkedList<String> songs;

    String[] survey;


    public InputScan(String peopleFileString, String songFileString) {
        peopleFile = new File(peopleFileString);
        songFile = new File(songFileString);

        Person[] peopleArray = getPeople(peopleFile);
        Song[] songArray = getSongs(songFile);
        
        songArray = sortSongs.sortByTitle(songArray);
        
        for (int i = 0; i < songArray.length; i++)
        {
            System.out.println(songArray[i].getTitle());
        }
        
        AssociateData data = new AssociateData(peopleArray, songArray);
        
        //System.out.println(data.getHobbyData()[0].toString());
        //System.out.println(data.getMajorData()[0].toString());
        //System.out.println(data.getRegionData()[0].toString());
    }


    private Song[] getSongs(File songFile) {
        BufferedReader br;
        Song[] returnArray = new Song[59];
        String line = "";
        String cvsSplitBy = ",";
        int count = 0;

        try {
            br = new BufferedReader(new FileReader(songFile));
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] songData = line.split(cvsSplitBy);
                
                String title = songData[0];
                String artist = songData[1];
                int year = Integer.parseInt(songData[2]);
                String genre = songData[3];
                Song song = new Song(title, genre, artist, year, count);
                
                returnArray[count] = song;
                count++;
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        
        return returnArray;
    }


    @SuppressWarnings("unused")
    private Person[] getPeople(File peopleFile) {
        Person[] arrayOfPersons = new Person[209];
        BufferedReader br;
        String line = "";
        String cvsSplitBy = ",";
        int count = 0;

        try {

            br = new BufferedReader(new FileReader(peopleFile));
            br.readLine();
            while ((line = br.readLine()) != null) {

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

                boolean[] responses = new boolean[118];
                for (int i = 5; i < surveyData.length; i++) {
                     String temp = surveyData[i];
                     if (temp.equals("Yes"))
                     {
                         responses[i - 5] = true;
                     }
                     else if (temp.equals("No"))
                     {
                         responses[i - 5] = false;
                     }
                }
                
                Person tempPerson = new Person(hobby, major, region, responses);
                arrayOfPersons[count] = tempPerson;
                count++;
            }
        }
        catch (Exception e) {
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
