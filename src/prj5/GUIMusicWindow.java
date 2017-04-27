package prj5;

import java.awt.Color;
import CS2114.Button;
import CS2114.Shape;
import CS2114.TextShape;
import CS2114.Window;
import CS2114.WindowSide;

public class GUIMusicWindow {

    /**
     * horizontal offset for songs
     */
    int offsetX = 300;
    
    /**
     * vertical offset for songs
     */
    int offsetY = 320;
    
    /**
     * button for previous page
     */
    Button prev;
    
    /**
     * button to sort by artist
     */
    Button sortByArtist;
    
    /**
     * button to sort by title
     */
    Button sortByTitle;
    
    /**
     * button to sort by year
     */
    Button sortByYear;
    
    /**
     * button to sort by genre
     */
    Button sortByGenre;
    
    /**
     * button to go to next page
     */
    Button next;
    
    /**
     * button to represent hobby data
     */
    Button repHobby; 
    /**
     * button to represent major data
     */
    Button repMajor; 
    
    /**
     * button to represent region data
     */
    Button repRegion; 
    
    /**
     * button to close program
     */
    Button quit;
    
    /**
     * main window to draw shapes
     */
    Window window;
    
    /**
     * object that reads in input and generates data
     */
    InputScan input;
    
    /**
     * divider shape in legend
     */
    Shape divisor;
    
    /**
     * shape that makes up legend
     */
    Shape legend;
    
    /**
     * title for legend
     */
    TextShape titleLegend;
    
    /**
     * first descirptor to display
     * (region/major/hobby first output)
     */
    TextShape activity1;
    
    /**
     * second discriptor to display
     * (region/major/hobby second output)
     */
    TextShape activity2;
    
    /**
     * third descirptor to display
     * (region/major/hobby third output)
     */
    TextShape activity3;
    
    /**
     * third descirptor to display
     * (region/major/hobby third output)
     */
    TextShape activity4;
    
    /**
     * title of song
     */
    TextShape songTitle;
    
    /**
     * literal word "heard" for legend
     */
    TextShape heard;
    
    /**
     * word for legend "likes"
     */
    TextShape likes;
    
    /**
     * have they clicked a represent button yet?
     */
    Boolean initialized;
    
    /**
     * song we are on
     */
    private int counter;
    
    /**
     * what we are sorted by
     */
    private int represent = 0;
    
    /**
     * array of the 9 display glyphs
     * on screen at a time
     */
    GUIDisplayGlyph[] display;
    
    /**
     * what are representing?
     * (region/major/hobby)
     */
    int modeChecker = 0;

    /**
     * initilizes all the values
     * @param musicFile music file to read from
     * @param songFile song file to read from
     */
    public GUIMusicWindow(String musicFile, String songFile) {
        display = new GUIDisplayGlyph[9];
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

    /**
     * creaetes the displayglyphes
     */
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
                display[i] = new GUIDisplayGlyph(song.getTitle(), song.getArtist(),
                    song.getYear(), song.getGenre(), song, input, modeChecker);
            }

            drawDisplayGlyphs(9);
        }
    }

    /**
     * draws the display glyphs
     * @param stopAt if page is not complete with
     * 9 entries this tlls us when to stop
     */
    public void drawDisplayGlyphs(int stopAt) {
        for (int i = 0; i < stopAt; i++) {
            display[i].drawGlyph(window, offsetX * (i % 3), offsetY * (i / 3),
                represent);
        }
    }


    /**
     * initializes everything after a representation
     * has been selected
     */
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


    /**
     * quits program
     * @param b button pressed
     */
    public void clickedQuit(Button b) {
        System.exit(0);
    }

    /**
     * goes to next page
     * @param b button pressed
     */
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

    /**
     * sorts by artist
     * @param b button pressed
     */
    public void clickedSortByArtist(Button b) {
        represent = 0;
        counter = 0;
        next.enable();
        prev.disable();

        input.songs.sortArtist();

        populateDisplayGlyphs();
    }

    /**
     * sorts by title
     * @param b button pressed
     */
    public void clickedSortByTitle(Button b) {
        represent = 0;
        counter = 0;
        next.enable();
        prev.disable();

        input.songs.sortTitle();

        populateDisplayGlyphs();

    }

    /**
     * sorts by year
     * @param b button pressed
     */
    public void clickedSortByYear(Button b) {
        represent = 1;
        counter = 0;
        next.enable();
        prev.disable();

        input.songs.sortYear();

        populateDisplayGlyphs();

    }

    /**
     * sorts by genre
     * @param b button pressed
     */
    public void clickedSortByGenre(Button b) {
        represent = 2;
        counter = 0;
        next.enable();
        prev.disable();

        input.songs.sortGenre();

        populateDisplayGlyphs();
    }

    /**
     * goes to next page
     * @param b button pressed
     */
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

    /**
     * represents hobby data
     * @param b button pressed
     */
    public void clickedRepHobby(Button b) {
        modeChecker = -1;
        
        if (!initialized)
        {
            initialize();
        }
        
        updateLegendHobby();
        populateDisplayGlyphs();
    }

    /**
     * represents major data
     * @param b button pressed
     */
    public void clickedRepMajor(Button b) {
        modeChecker = 0;
        
        if (!initialized)
        {
            initialize();
        }

        updateLegendMajor();
        populateDisplayGlyphs();
    }

    /**
     * represents region data
     * @param b button pressed
     */
    public void clickedRepRegion(Button b) {
        modeChecker = 1;
        
        if (!initialized)
        {
            initialize();
        }

        updateLegendRegion();
        populateDisplayGlyphs();
    }
    
    /**
     * updates legend when hobbyRep button
     * has been pressed
     */
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
    
    /**
     * updates legend when regionRep button
     * has been pressed
     */
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
    
    /**
     * updates legend when majorRep button
     * has been pressed
     */
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
