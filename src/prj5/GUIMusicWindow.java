package prj5;

import java.awt.Color;
import CS2114.Button;
import CS2114.Shape;
import CS2114.TextShape;
import CS2114.Window;
import CS2114.WindowSide;

public class GUIMusicWindow {

    int offsetX = 300;
    int offsetY = 320;
    private Button prev, sortByArtist, sortByTitle, sortByYear, sortByGenre,
        next, repHobby, repMajor, repRegion, quit;
    private Window window;
    private InputScan input;
    private Shape divisor, legend;
    private TextShape titleLegend, activity1, activity2, activity3, activity4,
        songTitle, heard, likes;
    private Boolean initialized;
    private int counter;
    private int represent = 0;
    DisplayGlyph[] display;
    int modeChecker = 0;


    public GUIMusicWindow(String musicFile, String songFile) {
        display = new DisplayGlyph[9];
        counter = 0;

        initialized = false;
        // input = new InputScan("MusicSurveyDataNoGenreRepeats.csv",
        // "SongListNoGenreRepeats.csv");

        window = new Window();
        window.setSize(1200, 1000);
        window.setTitle("Project 5");
        input = new InputScan(musicFile, songFile);

        // populateDisplayGlyphs();

        prev = new Button("<-- Prev");
        window.addButton(prev, WindowSide.NORTH);
        prev.onClick(this, "clickedPrev");

        sortByArtist = new Button("Sort by Artist Name");
        window.addButton(sortByArtist, WindowSide.NORTH);
        sortByArtist.onClick(this, "clickedSortByArtist");

        sortByTitle = new Button("Sort by Song Title");
        window.addButton(sortByTitle, WindowSide.NORTH);
        sortByTitle.onClick(this, "clickedSortByTitle");

        sortByYear = new Button("Sort by Release Year");
        window.addButton(sortByYear, WindowSide.NORTH);
        sortByYear.onClick(this, "clickedSortByYear");

        sortByGenre = new Button("Sort by Genre");
        window.addButton(sortByGenre, WindowSide.NORTH);
        sortByGenre.onClick(this, "clickedSortByGenre");

        next = new Button("Next -->");
        window.addButton(next, WindowSide.NORTH);
        next.onClick(this, "clickedNext");

        repHobby = new Button("Represent Hobby");
        window.addButton(repHobby, WindowSide.SOUTH);
        repHobby.onClick(this, "clickedRepHobby");

        repMajor = new Button("Represent Major");
        window.addButton(repMajor, WindowSide.SOUTH);
        repMajor.onClick(this, "clickedRepMajor");

        repRegion = new Button("Represent Region");
        window.addButton(repRegion, WindowSide.SOUTH);
        repRegion.onClick(this, "clickedRepRegion");

        quit = new Button("Quit");
        window.addButton(quit, WindowSide.SOUTH);
        quit.onClick(this, "clickedQuit");

        prev.disable();
    }


    public void populateDisplayGlyphs() {
        if (initialized) {
            Song song;

            for (int i = 0; i < 9; i++) {
                try {
                    song = input.getSongList().get(counter + i);
                }
                catch (Exception e) {
                    drawDisplayGlyphs(i);

                    for (int j = i; j < 9; j++) {
                        display[j].removeShapes(window);
                    }

                    return;
                }

                if (display[i] != null) {
                    display[i].removeShapes(window);
                }
                display[i] = new DisplayGlyph(song.getTitle(), song.getArtist(),
                    song.getYear(), song.getGenre(), song, input, modeChecker);
            }

            drawDisplayGlyphs(9);
        }
    }


    public void drawDisplayGlyphs(int stopAt) {
        for (int i = 0; i < stopAt; i++) {
            display[i].drawGlyph(window, offsetX * (i % 3), offsetY * (i / 3),
                represent);
        }
    }


    public void initialize() {

        // Legend set up
        divisor = new Shape(900, 520, 270, 330, Color.BLACK);
        window.addShape(divisor);
        legend = new Shape(910, 530, 250, 310, Color.WHITE);
        window.addShape(legend);
        window.moveToFront(legend);
        
        titleLegend = new TextShape(990, 550, "Hobby Legend", Color.BLACK);
        titleLegend.setBackgroundColor(Color.WHITE);
        window.addShape(titleLegend);
        window.moveToFront(titleLegend);
        
        songTitle = new TextShape(1000, 700, "Song Title", Color.BLACK);
        songTitle.setBackgroundColor(Color.WHITE);
        window.addShape(songTitle);
        window.moveToFront(songTitle);
        
        divisor = new Shape(1030, 720, 10, 100, Color.BLACK);
        window.addShape(divisor);
        window.moveToFront(divisor);
        
        heard = new TextShape(970, 760, "Heard", Color.BLACK);
        window.addShape(heard);
        window.moveToFront(heard);
        heard.setBackgroundColor(Color.WHITE);
        
        likes = new TextShape(1055, 760, "Likes", Color.BLACK);
        window.addShape(likes);
        window.moveToFront(likes);
        likes.setBackgroundColor(Color.WHITE);

        initialized = true;
        populateDisplayGlyphs();
        
    }


    public void clickedQuit(Button b) {
        System.exit(0);
    }


    public void clickedPrev(Button b) {

        counter -= 9;

        if (counter < 54) {
            next.enable();
        }

        if (counter == 0) {
            prev.disable();
        }

        populateDisplayGlyphs();
    }


    public void clickedSortByArtist(Button b) {
        represent = 0;
        counter = 0;
        next.enable();
        prev.disable();

        input.songs.sortArtist();

        populateDisplayGlyphs();
    }


    public void clickedSortByTitle(Button b) {
        represent = 0;
        counter = 0;
        next.enable();
        prev.disable();

        input.songs.sortTitle();

        populateDisplayGlyphs();

    }


    public void clickedSortByYear(Button b) {
        represent = 1;
        counter = 0;
        next.enable();
        prev.disable();

        input.songs.sortYear();

        populateDisplayGlyphs();

    }


    public void clickedSortByGenre(Button b) {
        represent = 2;
        counter = 0;
        next.enable();
        prev.disable();

        input.songs.sortGenre();

        populateDisplayGlyphs();
    }


    public void clickedNext(Button button) {
        counter += 9;
        System.out.println(counter);
        if (counter != 0) {
            prev.enable();
        }

        if (counter == 54) {
            next.disable();
        }

        populateDisplayGlyphs();

    }


    public void clickedRepHobby(Button b) {
        modeChecker = -1;
        
        if (!initialized)
        {
            initialize();
        }
        
        updateLegendHobby();
        populateDisplayGlyphs();
    }


    public void clickedRepMajor(Button b) {
        modeChecker = 0;
        
        if (!initialized)
        {
            initialize();
        }

        updateLegendMajor();
        populateDisplayGlyphs();
    }


    public void clickedRepRegion(Button b) {
        modeChecker = 1;
        
        if (!initialized)
        {
            initialize();
        }

        updateLegendRegion();
        populateDisplayGlyphs();
    }
    
    public void updateLegendHobby()
    {
        if (activity1 != null)
        {
            window.removeShape(activity1);
            window.removeShape(activity2);
            window.removeShape(activity3);
            window.removeShape(activity4);
        }
        
        activity1 = new TextShape(930, 590, "Read", Color.MAGENTA);
        activity1.setBackgroundColor(Color.WHITE);
        window.addShape(activity1);
        window.moveToFront(activity1);

        activity2 = new TextShape(930, 620, "Art", Color.BLUE);
        activity2.setBackgroundColor(Color.WHITE);
        window.addShape(activity2);
        window.moveToFront(activity2);

        activity3 = new TextShape(930, 650, "Sports", Color.ORANGE);
        activity3.setBackgroundColor(Color.WHITE);
        window.addShape(activity3);
        window.moveToFront(activity3);

        activity4 = new TextShape(930, 680, "Music", Color.GREEN);
        activity4.setBackgroundColor(Color.WHITE);
        window.addShape(activity4);
        window.moveToFront(activity4);
    }
    
    public void updateLegendRegion()
    {
        if (activity1 != null)
        {
            window.removeShape(activity1);
            window.removeShape(activity2);
            window.removeShape(activity3);
            window.removeShape(activity4);
        }
        
        activity1 = new TextShape(930, 590, "Northeast", Color.MAGENTA);
        activity1.setBackgroundColor(Color.WHITE);
        window.addShape(activity1);
        window.moveToFront(activity1);

        activity2 = new TextShape(930, 620, "Southeast", Color.BLUE);
        activity2.setBackgroundColor(Color.WHITE);
        window.addShape(activity2);
        window.moveToFront(activity2);

        activity3 = new TextShape(930, 650, "Other US", Color.ORANGE);
        activity3.setBackgroundColor(Color.WHITE);
        window.addShape(activity3);
        window.moveToFront(activity3);

        activity4 = new TextShape(930, 680, "Outside US", Color.GREEN);
        activity4.setBackgroundColor(Color.WHITE);
        window.addShape(activity4);
        window.moveToFront(activity4);
    }
    
    public void updateLegendMajor()
    {
        if (activity1 != null)
        {
            window.removeShape(activity1);
            window.removeShape(activity2);
            window.removeShape(activity3);
            window.removeShape(activity4);
        }
        
        activity1 = new TextShape(930, 590, "Comp Sci", Color.MAGENTA);
        activity1.setBackgroundColor(Color.WHITE);
        window.addShape(activity1);
        window.moveToFront(activity1);

        activity2 = new TextShape(930, 620, "Other Eng", Color.BLUE);
        activity2.setBackgroundColor(Color.WHITE);
        window.addShape(activity2);
        window.moveToFront(activity2);

        activity3 = new TextShape(930, 650, "Math/CMDA", Color.ORANGE);
        activity3.setBackgroundColor(Color.WHITE);
        window.addShape(activity3);
        window.moveToFront(activity3);

        activity4 = new TextShape(930, 680, "Other", Color.GREEN);
        activity4.setBackgroundColor(Color.WHITE);
        window.addShape(activity4);
        window.moveToFront(activity4);
    }
}
