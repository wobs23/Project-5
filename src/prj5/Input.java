package prj5;

public class Input {
    
    public static InputScan input;
    
    public static void main(String[] args)
    {
       // input = new InputScan(args[0], args[1]);
       // input = new InputScan("MusicSurveyDataNoGenreRepeats.csv", "SongListNoGenreRepeats.csv");
       // GUIMusicWindow window = new GUIMusicWindow("MusicSurveyDataNoGenreRepeats.csv", "SongListNoGenreRepeats.csv");
        GUIMusicWindow window = new GUIMusicWindow("MusicSurveyData.csv", "SongList.csv");
        //GUIMusicWindow window = new GUIMusicWindow("MusicSurveyData2017S.csv", "SongList2017S.csv");
    }
}
