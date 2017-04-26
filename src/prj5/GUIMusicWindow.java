package prj5;

import java.awt.Color;
import CS2114.Button;
import CS2114.Shape;
import CS2114.TextShape;
import CS2114.Window;
import CS2114.WindowSide;

// input.data.hobby[1].getPercentSportsLike();
public class GUIMusicWindow {

    private Button prev, sortByArtist, sortByTitle, sortByYear, sortByGenre,
        next, repHobby, repMajor, repRegion, quit;
    private Window window;
    private InputScan input;
    private Shape divisor, legend;
    private Shape glyph11, glyph12, glyph13, glyph14, glyph21, glyph22, glyph23,
        glyph24, glyph31, glyph32, glyph33, glyph34, glyph41, glyph42, glyph43,
        glyph44, glyph51, glyph52, glyph53, glyph54, glyph61, glyph62, glyph63,
        glyph64, glyph71, glyph72, glyph73, glyph74, glyph81, glyph82, glyph83,
        glyph84, glyph91, glyph92, glyph93, glyph94;
    private TextShape titleLegend, activity1, activity2, activity3, activity4,
        songTitle, heard, likes;
    private TextShape author1, author2, author3, author4, author5, author6,
        author7, author8, author9;
    private TextShape song1, song2, song3, song4, song5, song6, song7, song8,
        song9;
    private Boolean initialized;
    private int counter;
    private DLList<prj5.Song> songArtist, songGenre, songByTitle, songYear;
    private int modeChecker;

    public GUIMusicWindow(String musicFile, String songFile) {

        counter = 0;
        
        initialized = false;
        // input = new InputScan("MusicSurveyDataNoGenreRepeats.csv",
        // "SongListNoGenreRepeats.csv");
        input = new InputScan(musicFile, songFile);
        // input.data.hobby[1].getPercentArtHeard();

        songArtist = input.data.songs;
        songGenre = input.data.songs;
        songByTitle = input.data.songs;
        songYear = input.data.songs;

        window = new Window();
        window.setSize(1200, 1000);
        window.setTitle("Project 5");

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


    public void GUIMusicWindow() {

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
        activity1 = new TextShape(930, 590, "Read", Color.MAGENTA);
        activity1.setBackgroundColor(Color.WHITE);
        window.addShape(activity1);
        window.moveToFront(activity1);
        activity2 = new TextShape(930, 620, "Art", Color.BLUE);
        activity2.setBackgroundColor(Color.WHITE);
        window.addShape(activity2);
        window.moveToFront(activity2);
        activity3 = new TextShape(930, 650, "Sports", Color.yellow);
        // activity3.setBackgroundColor(Color.WHITE);
        window.addShape(activity3);
        window.moveToFront(activity3);
        activity4 = new TextShape(930, 680, "Music", Color.GREEN);
        activity4.setBackgroundColor(Color.WHITE);
        window.addShape(activity4);
        window.moveToFront(activity4);
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

        song1 = new TextShape(60, 70, input.data.songs.get(counter).getTitle(),
            Color.BLACK);
        window.addShape(song1);
        author1 = new TextShape(90, 85, "by " + input.data.songs.get(counter)
            .getArtist(), Color.BLACK);
        window.addShape(author1);
        counter++;
        song1.setBackgroundColor(Color.WHITE);
        author1.setBackgroundColor(Color.WHITE);
        divisor = new Shape(120, 120, 10, 120, Color.BLACK);
        window.addShape(divisor);
        glyph11 = new Shape(80, 120, 100, 30, Color.MAGENTA);
        window.addShape(glyph11);
        glyph12 = new Shape(70, 150, 90, 30, Color.BLUE);
        window.addShape(glyph12);
        glyph13 = new Shape(90, 180, 70, 30, Color.yellow);
        window.addShape(glyph13);
        glyph14 = new Shape(60, 210, 100, 30, Color.GREEN);
        window.addShape(glyph14);

        song2 = new TextShape(360, 70, input.data.songs.get(counter).getTitle(),
            Color.BLACK);
        window.addShape(song2);
        author2 = new TextShape(390, 85, "by " + input.data.songs.get(counter)
            .getArtist(), Color.BLACK);
        window.addShape(author2);
        counter++;
        song2.setBackgroundColor(Color.WHITE);
        author2.setBackgroundColor(Color.WHITE);
        divisor = new Shape(420, 120, 10, 120, Color.BLACK);
        window.addShape(divisor);
        glyph21 = new Shape(400, 120, 85, 30, Color.MAGENTA);
        window.addShape(glyph21);
        glyph22 = new Shape(390, 150, 70, 30, Color.BLUE);
        window.addShape(glyph22);
        glyph23 = new Shape(370, 180, 110, 30, Color.yellow);
        window.addShape(glyph23);
        glyph24 = new Shape(390, 210, 60, 30, Color.GREEN);
        window.addShape(glyph24);

        song3 = new TextShape(660, 70, input.data.songs.get(counter).getTitle(),
            Color.BLACK);
        window.addShape(song3);
        author3 = new TextShape(660, 85, "by " + input.data.songs.get(counter)
            .getArtist(), Color.BLACK);
        window.addShape(author3);
        counter++;
        divisor = new Shape(720, 120, 10, 120, Color.BLACK);
        window.addShape(divisor);
        song3.setBackgroundColor(Color.WHITE);
        author3.setBackgroundColor(Color.WHITE);
        glyph31 = new Shape(660, 120, 110, 30, Color.MAGENTA);
        window.addShape(glyph31);
        glyph32 = new Shape(680, 150, 60, 30, Color.BLUE);
        window.addShape(glyph32);
        glyph33 = new Shape(690, 180, 90, 30, Color.yellow);
        window.addShape(glyph33);
        glyph34 = new Shape(660, 210, 100, 30, Color.GREEN);
        window.addShape(glyph34);

        song4 = new TextShape(60, 370, input.data.songs.get(counter).getTitle(),
            Color.BLACK);
        window.addShape(song4);
        author4 = new TextShape(90, 385, "by " + input.data.songs.get(counter)
            .getArtist(), Color.BLACK);
        window.addShape(author4);
        counter++;
        song4.setBackgroundColor(Color.WHITE);
        author4.setBackgroundColor(Color.WHITE);
        divisor = new Shape(120, 420, 10, 120, Color.BLACK);
        window.addShape(divisor);
        glyph41 = new Shape(80, 420, 100, 30, Color.MAGENTA);
        window.addShape(glyph41);
        glyph42 = new Shape(70, 450, 90, 30, Color.BLUE);
        window.addShape(glyph42);
        glyph43 = new Shape(100, 480, 70, 30, Color.yellow);
        window.addShape(glyph43);
        glyph44 = new Shape(90, 510, 100, 30, Color.GREEN);
        window.addShape(glyph44);

        song5 = new TextShape(360, 370, input.data.songs.get(counter)
            .getTitle(), Color.BLACK);
        window.addShape(song5);
        author5 = new TextShape(390, 385, "by " + input.data.songs.get(counter)
            .getArtist(), Color.BLACK);
        window.addShape(author5);
        counter++;
        song5.setBackgroundColor(Color.WHITE);
        author5.setBackgroundColor(Color.WHITE);
        divisor = new Shape(420, 420, 10, 120, Color.BLACK);
        window.addShape(divisor);
        glyph51 = new Shape(400, 420, 100, 30, Color.MAGENTA);
        window.addShape(glyph51);
        glyph52 = new Shape(380, 450, 90, 30, Color.BLUE);
        window.addShape(glyph52);
        glyph53 = new Shape(370, 480, 70, 30, Color.yellow);
        window.addShape(glyph53);
        glyph54 = new Shape(360, 510, 100, 30, Color.GREEN);
        window.addShape(glyph54);

        song6 = new TextShape(660, 370, input.data.songs.get(counter)
            .getTitle(), Color.BLACK);
        window.addShape(song6);
        author6 = new TextShape(660, 385, "by " + input.data.songs.get(counter)
            .getArtist(), Color.BLACK);
        window.addShape(author6);
        counter++;
        divisor = new Shape(720, 420, 10, 120, Color.BLACK);
        window.addShape(divisor);
        song6.setBackgroundColor(Color.WHITE);
        author6.setBackgroundColor(Color.WHITE);
        glyph61 = new Shape(660, 420, 100, 30, Color.MAGENTA);
        window.addShape(glyph61);
        glyph62 = new Shape(680, 450, 90, 30, Color.BLUE);
        window.addShape(glyph62);
        glyph63 = new Shape(680, 480, 70, 30, Color.yellow);
        window.addShape(glyph63);
        glyph64 = new Shape(690, 510, 100, 30, Color.GREEN);
        window.addShape(glyph64);

        song7 = new TextShape(60, 670, input.data.songs.get(counter).getTitle(),
            Color.BLACK);
        window.addShape(song7);
        author7 = new TextShape(90, 685, "by " + input.data.songs.get(counter)
            .getArtist(), Color.BLACK);
        window.addShape(author7);
        counter++;
        song7.setBackgroundColor(Color.WHITE);
        author7.setBackgroundColor(Color.WHITE);
        divisor = new Shape(120, 720, 10, 120, Color.BLACK);
        window.addShape(divisor);
        glyph71 = new Shape(70, 720, 100, 30, Color.MAGENTA);
        window.addShape(glyph71);
        glyph72 = new Shape(90, 750, 90, 30, Color.BLUE);
        window.addShape(glyph72);
        glyph73 = new Shape(100, 780, 70, 30, Color.yellow);
        window.addShape(glyph73);
        glyph74 = new Shape(60, 810, 80, 30, Color.GREEN);
        window.addShape(glyph74);

        song8 = new TextShape(360, 670, input.data.songs.get(counter)
            .getTitle(), Color.BLACK);
        window.addShape(song8);
        author8 = new TextShape(390, 685, "by " + input.data.songs.get(counter)
            .getArtist(), Color.BLACK);
        window.addShape(author8);
        counter++;
        song8.setBackgroundColor(Color.WHITE);
        author8.setBackgroundColor(Color.WHITE);
        divisor = new Shape(420, 720, 10, 120, Color.BLACK);
        window.addShape(divisor);
        glyph81 = new Shape(380, 720, 70, 30, Color.MAGENTA);
        window.addShape(glyph81);
        glyph82 = new Shape(370, 750, 100, 30, Color.BLUE);
        window.addShape(glyph82);
        glyph83 = new Shape(390, 780, 90, 30, Color.yellow);
        window.addShape(glyph83);
        glyph84 = new Shape(380, 810, 80, 30, Color.GREEN);
        window.addShape(glyph84);

        song9 = new TextShape(660, 670, input.data.songs.get(counter)
            .getTitle(), Color.BLACK);
        window.addShape(song9);
        author9 = new TextShape(660, 685, "by " + input.data.songs.get(counter)
            .getArtist(), Color.BLACK);
        window.addShape(author9);
        counter++;
        divisor = new Shape(720, 720, 10, 120, Color.BLACK);
        window.addShape(divisor);
        song9.setBackgroundColor(Color.WHITE);
        author9.setBackgroundColor(Color.WHITE);
        glyph91 = new Shape(680, 720, 80, 30, Color.MAGENTA);
        window.addShape(glyph91);
        glyph92 = new Shape(670, 750, 100, 30, Color.BLUE);
        window.addShape(glyph92);
        glyph93 = new Shape(690, 780, 90, 30, Color.yellow);
        window.addShape(glyph93);
        glyph94 = new Shape(680, 810, 80, 30, Color.GREEN);
        window.addShape(glyph94);

    }


    public void clickedQuit(Button b) {
        System.exit(0);
    }


    public void clickedPrev(Button b) {

// if (counter - 1 == 8) {
// int count = counter - 1;
//
// song9.setText(songArtist.get(count).getTitle());
// author9.setText("by " + songArtist.get(count).getArtist());
// count--;
// song8.setText(songArtist.get(count).getTitle());
// author8.setText("by " + songArtist.get(count).getArtist());
// count--;
// song7.setText(songArtist.get(count).getTitle());
// author7.setText("by " + songArtist.get(count).getArtist());
// count--;
// song6.setText(songArtist.get(count).getTitle());
// author6.setText("by " + songArtist.get(count).getArtist());
// count--;
// song5.setText(songArtist.get(count).getTitle());
// author5.setText("by " + songArtist.get(count).getArtist());
// count--;
// song4.setText(songArtist.get(count).getTitle());
// author4.setText("by " + songArtist.get(count).getArtist());
// count--;
// song3.setText(songArtist.get(count).getTitle());
// author3.setText("by " + songArtist.get(count).getArtist());
// count--;
// song2.setText(songArtist.get(count).getTitle());
// author2.setText("by " + songArtist.get(count).getArtist());
// count--;
// song1.setText(songArtist.get(count).getTitle());
// author1.setText("by " + songArtist.get(count).getArtist());
//
// prev.disable();
// }
        if (counter % 9 != 0) {
            while (counter % 9 != 0) {
                counter--;
            }
            if (counter < 59) {
                next.enable();
            }

        }
        if (counter % 9 == 0) {
            counter--;
            song9.setText(songArtist.get(counter).getTitle());
            author9.setText("by " + songArtist.get(counter).getArtist());
            counter--;
            song8.setText(songArtist.get(counter).getTitle());
            author8.setText("by " + songArtist.get(counter).getArtist());
            counter--;
            song7.setText(songArtist.get(counter).getTitle());
            author7.setText("by " + songArtist.get(counter).getArtist());
            counter--;
            song6.setText(songArtist.get(counter).getTitle());
            author6.setText("by " + songArtist.get(counter).getArtist());
            counter--;
            song5.setText(songArtist.get(counter).getTitle());
            author5.setText("by " + songArtist.get(counter).getArtist());
            counter--;
            song4.setText(songArtist.get(counter).getTitle());
            author4.setText("by " + songArtist.get(counter).getArtist());
            counter--;
            song3.setText(songArtist.get(counter).getTitle());
            author3.setText("by " + songArtist.get(counter).getArtist());
            counter--;
            song2.setText(songArtist.get(counter).getTitle());
            author2.setText("by " + songArtist.get(counter).getArtist());
            counter--;
            song1.setText(songArtist.get(counter).getTitle());
            author1.setText("by " + songArtist.get(counter).getArtist());
            if (counter == 0) {
                prev.disable();
            }
        }
// if (counter == 9 )
// {
// prev.disable();
// }
    }


    public void clickedSortByArtist(Button b) {
        songArtist.sortArtist();

        counter = 0;
        // input.data.songs.get(0);
        song1.setText(songArtist.get(counter).getTitle());
        author1.setText("by " + songArtist.get(counter).getArtist());
        counter++;
        song2.setText(songArtist.get(counter).getTitle());
        author2.setText("by " + songArtist.get(counter).getArtist());
        counter++;
        song3.setText(songArtist.get(counter).getTitle());
        author3.setText("by " + songArtist.get(counter).getArtist());
        counter++;
        song4.setText(songArtist.get(counter).getTitle());
        author4.setText("by " + songArtist.get(counter).getArtist());
        counter++;
        song5.setText(songArtist.get(counter).getTitle());
        author5.setText("by " + songArtist.get(counter).getArtist());
        counter++;
        song6.setText(songArtist.get(counter).getTitle());
        author6.setText("by " + songArtist.get(counter).getArtist());
        counter++;
        song7.setText(songArtist.get(counter).getTitle());
        author7.setText("by " + songArtist.get(counter).getArtist());
        counter++;
        song8.setText(songArtist.get(counter).getTitle());
        author8.setText("by " + songArtist.get(counter).getArtist());
        counter++;
        song9.setText(songArtist.get(counter).getTitle());
        author9.setText("by " + songArtist.get(counter).getArtist());
        counter++;

    }


    public void clickedSortByTitle(Button b) {
        songByTitle.sortTitle();

        counter = 0;
        // input.data.songs.get(0);
        song1.setText(songByTitle.get(counter).getTitle());
        author1.setText("by " + songByTitle.get(counter).getArtist());
        counter++;
        song2.setText(songByTitle.get(counter).getTitle());
        author2.setText("by " + songByTitle.get(counter).getArtist());
        counter++;
        song3.setText(songByTitle.get(counter).getTitle());
        author3.setText("by " + songByTitle.get(counter).getArtist());
        counter++;
        song4.setText(songByTitle.get(counter).getTitle());
        author4.setText("by " + songByTitle.get(counter).getArtist());
        counter++;
        song5.setText(songByTitle.get(counter).getTitle());
        author5.setText("by " + songByTitle.get(counter).getArtist());
        counter++;
        song6.setText(songByTitle.get(counter).getTitle());
        author6.setText("by " + songByTitle.get(counter).getArtist());
        counter++;
        song7.setText(songByTitle.get(counter).getTitle());
        author7.setText("by " + songByTitle.get(counter).getArtist());
        counter++;
        song8.setText(songByTitle.get(counter).getTitle());
        author8.setText("by " + songByTitle.get(counter).getArtist());
        counter++;
        song9.setText(songByTitle.get(counter).getTitle());
        author9.setText("by " + songByTitle.get(counter).getArtist());
        counter++;
    }


    public void clickedSortByYear(Button b) {
        songYear.sortYear();
        counter = 0;
        // input.data.songs.get(0);
        song1.setText(songYear.get(counter).getTitle());
        author1.setText("Year: " + songYear.get(counter).getYear());
        counter++;
        song2.setText(songYear.get(counter).getTitle());
        author2.setText("Year: " + songYear.get(counter).getYear());
        counter++;
        song3.setText(songYear.get(counter).getTitle());
        author3.setText("Year: " + songYear.get(counter).getYear());
        counter++;
        song4.setText(songYear.get(counter).getTitle());
        author4.setText("Year: " + songYear.get(counter).getYear());
        counter++;
        song5.setText(songYear.get(counter).getTitle());
        author5.setText("Year: " + songYear.get(counter).getYear());
        counter++;
        song6.setText(songYear.get(counter).getTitle());
        author6.setText("Year: " + songYear.get(counter).getYear());
        counter++;
        song7.setText(songYear.get(counter).getTitle());
        author7.setText("Year: " + songYear.get(counter).getYear());
        counter++;
        song8.setText(songYear.get(counter).getTitle());
        author8.setText("Year: " + songYear.get(counter).getYear());
        counter++;
        song9.setText(songYear.get(counter).getTitle());
        author9.setText("Year: " + songYear.get(counter).getYear());
        counter++;
    }


    public void clickedSortByGenre(Button b) {
        // songGenre = input.data.songs;
        songGenre.sortGenre();
        counter = 0;
        // input.data.songs.get(0);
        song1.setText(songGenre.get(counter).getTitle());
        author1.setText("Genre: " + songGenre.get(counter).getGenre());
        counter++;
        song2.setText(songGenre.get(1).getTitle());
        author2.setText("Genre: " + songGenre.get(1).getGenre());
        counter++;
        song3.setText(songGenre.get(2).getTitle());
        author3.setText("Genre: " + songGenre.get(2).getGenre());
        counter++;
        song4.setText(songGenre.get(3).getTitle());
        author4.setText("Genre: " + songGenre.get(3).getGenre());
        counter++;
        song5.setText(songGenre.get(4).getTitle());
        author5.setText("Genre: " + songGenre.get(4).getGenre());
        counter++;
        song6.setText(songGenre.get(5).getTitle());
        author6.setText("Genre: " + songGenre.get(5).getGenre());
        counter++;
        song7.setText(songGenre.get(6).getTitle());
        author7.setText("Genre: " + songGenre.get(6).getGenre());
        counter++;
        song8.setText(songGenre.get(7).getTitle());
        author8.setText("Genre: " + songGenre.get(7).getGenre());
        counter++;
        song9.setText(songGenre.get(8).getTitle());
        author9.setText("Genre: " + songGenre.get(8).getGenre());
        counter++;
    }


    public void clickedNext(Button button) {

        if (counter == 0) {
            counter = counter + 9;
        }

        if (counter % 9 == 0) {
            if (counter < 59) {
                song1.setText(input.data.songs.get(counter).getTitle());
                author1.setText("by " + input.data.songs.get(counter)
                    .getArtist());
                updateSong1(counter);
                
                counter++;
            }
            else {
                song1.setText(" Nothing to Show");
                author1.setText(" ");
                window.removeShape(glyph11);
                window.removeShape(glyph12);
                window.removeShape(glyph13);
                window.removeShape(glyph14);
                next.disable();
            }

            if (counter < 59) {
                song2.setText(input.data.songs.get(counter).getTitle());
                author2.setText("by " + input.data.songs.get(counter)
                    .getArtist());
                counter++;
            }
            else {
                song2.setText("Nothing to Show" );
                author2.setText(" ");
                window.removeShape(glyph21);
                window.removeShape(glyph22);
                window.removeShape(glyph23);
                window.removeShape(glyph24);
                next.disable();
            }
            if (counter < 59) {
                song3.setText(input.data.songs.get(counter).getTitle());
                author3.setText("by " + input.data.songs.get(counter)
                    .getArtist());
                counter++;

            }
            else {
                song3.setText(" Nothing to Show");
                author3.setText(" ");
                window.removeShape(glyph31);
                window.removeShape(glyph32);
                window.removeShape(glyph33);
                window.removeShape(glyph34);
                next.disable();
            }

            if (counter < 59) {
                song4.setText(input.data.songs.get(counter).getTitle());
                author4.setText("by " + input.data.songs.get(counter)
                    .getArtist());
                counter++;

            }
            else {
                song4.setText(" Nothing to Show");
                author4.setText(" ");
                window.removeShape(glyph41);
                window.removeShape(glyph42);
                window.removeShape(glyph43);
                window.removeShape(glyph44);
                next.disable();
            }

            if (counter < 59) {
                song5.setText(input.data.songs.get(counter).getTitle());
                author5.setText("by " + input.data.songs.get(counter)
                    .getArtist());
                counter++;
            }
            else {
                song5.setText(" Nothing to Show");
                author5.setText(" ");
                window.removeShape(glyph51);
                window.removeShape(glyph52);
                window.removeShape(glyph53);
                window.removeShape(glyph54);
                next.disable();
            }
            if (counter < 59) {
                song6.setText(input.data.songs.get(counter).getTitle());
                author6.setText("by " + input.data.songs.get(counter)
                    .getArtist());
                counter++;
            }
            else {
                song6.setText(" Nothing to Show");
                author6.setText(" ");
                window.removeShape(glyph61);
                window.removeShape(glyph62);
                window.removeShape(glyph63);
                window.removeShape(glyph64);
                next.disable();
            }

            if (counter < 59) {
                song7.setText(input.data.songs.get(counter).getTitle());
                author7.setText("by " + input.data.songs.get(counter)
                    .getArtist());
                counter++;
            }
            else {
                song7.setText(" Nothing to Show");
                author7.setText(" ");
                window.removeShape(glyph71);
                window.removeShape(glyph72);
                window.removeShape(glyph73);
                window.removeShape(glyph74);
                next.disable();
            }

            if (counter < 59) {
                song8.setText(input.data.songs.get(counter).getTitle());
                author8.setText("by " + input.data.songs.get(counter)
                    .getArtist());
                counter++;
            }
            else {
                song8.setText(" Nothing to Show");
                author8.setText(" ");
                window.removeShape(glyph81);
                window.removeShape(glyph82);
                window.removeShape(glyph83);
                window.removeShape(glyph84);
                next.disable();
            }
            if (counter < 59) {
                song9.setText(input.data.songs.get(counter).getTitle());
                author9.setText("by " + input.data.songs.get(counter)
                    .getArtist());
                counter++;
            }
            else {
                song9.setText(" Nothing to Show");
                author9.setText(" ");
                window.removeShape(glyph91);
                window.removeShape(glyph92);
                window.removeShape(glyph93);
                window.removeShape(glyph94);
                next.disable();
            }
            prev.enable();
        }
    }


    public void clickedRepHobby(Button b) {
        modeChecker = -1;
        if (!initialized) {
            GUIMusicWindow();
            titleLegend.setText("Hobby Legend");
            activity1.setText("Read");
            activity2.setText("Art");
            activity3.setText("Sports");
            activity4.setText("Music");
            window.repaint();
            initialized = true;
        }
        else {
            titleLegend.setText("Hobby Legend");
            activity1.setText("Read");
            activity2.setText("Art");
            activity3.setText("Sports");
            activity4.setText("Music");
            window.repaint();
        }
//        glyph11.moveTo(x, y);
//        glyph11.move(dx, dy);
//        glyph11.setX(x);
        //divisors width is 10
       // input.data.songs.get(counter);
//        int widthLike = input.data.hobby[input.data.songs.get(counter).getDataLoc()].getPercentReadLike();
//        int widthHeard = input.data.hobby[input.data.songs.get(counter).getDataLoc()].getPercentReadHeard(); 
//        window.removeShape(glyph11);
//        glyph11 = new Shape(120, 120, (widthHeard + widthLike) + 10, 30, Color.MAGENTA);
//        glyph11.moveTo(120 - widthHeard, 120);
//        window.addShape(glyph11);
//        window.repaint();
        //input.data.hobby[input.data.songs.get(counter).getDataLoc()].getPercentSportsLike();
    }


    public void clickedRepMajor(Button b) {
        modeChecker = 0;
        if (!initialized) {
            GUIMusicWindow();
            titleLegend.setText("Major Legend");
            activity1.setText("Comp Sci");
            activity2.setText("Other Eng");
            activity3.setText("Math/CMDA");
            activity4.setText("Other");
            initialized = true;
        }
        else {
            titleLegend.setText("Major Legend");
            activity1.setText("Comp Sci");
            activity2.setText("Other Eng");
            activity3.setText("Math/CMDA");
            activity4.setText("Other");
            window.repaint();
        }
    }


    public void clickedRepRegion(Button b) {
        modeChecker = 1;
        if (!initialized) {
            GUIMusicWindow();

            titleLegend.setText("Region Legend");
            activity1.setText("NortheEast US");
            activity2.setText("SouthEast US");
            activity3.setText("Rest of US");
            activity4.setText("Outside the US");
            initialized = true;
        }
        else {
            titleLegend.setText("Region Legend");
            activity1.setText("NortheEast US");
            activity2.setText("SouthEast US");
            activity3.setText("Rest of US");
            activity4.setText("Outside the US");
            window.repaint();
        }
    }
    
    private void updateSong1(int counter)
    {
       // input.data.
        AssociateData assData = input.data;
        if (modeChecker == -1)
        {
        AssociateHobby song1 = input.data.hobby[counter];
        window.removeShape(glyph11);
        glyph11 = new Shape(120, 120, ((song1.getPercentReadHeard()) + (song1.getPercentReadLike())) + 10, 30, Color.MAGENTA);
        glyph11.moveTo(120 - (song1.getPercentReadHeard()), 120);
        window.addShape(glyph11);
        window.repaint();
        
        window.removeShape(glyph12);
        glyph12 = new Shape(120, 150, ((song1.getPercentArtHeard()) + (song1.getPercentArtLike())) + 10, 30, Color.BLUE);
        glyph12.moveTo(120 - (song1.getPercentArtHeard()), 150);
        window.addShape(glyph12);
        window.repaint();
        
        window.removeShape(glyph13);
        glyph13 = new Shape(120, 180, ((song1.getSportsHeard()) + (song1.getSportsLike())) + 10, 30, Color.YELLOW);
        glyph13.moveTo(120 - (song1.getSportsHeard()), 180);
        window.addShape(glyph13);
        window.repaint();
        
        window.removeShape(glyph14);
        glyph14 = new Shape(120, 210, ((song1.getMusicHeard()) + (song1.getMusicLike())) + 10, 30, Color.GREEN);
        glyph14.moveTo(120 - (song1.getMusicHeard()), 210);
        window.addShape(glyph14);
        window.repaint();
        }
        else 
            if (modeChecker == 0)
            {
            AssociateMajor song1 = input.data.major[counter];
            window.removeShape(glyph11);
            glyph11 = new Shape(120, 120, ((song1.getPercentcsHeard()) + (song1.getPercentcsLike())) + 10, 30, Color.MAGENTA);
            glyph11.moveTo(120 - (song1.getPercentcsHeard()), 120);
            window.addShape(glyph11);
            window.repaint();
            
            window.removeShape(glyph12);
            glyph12 = new Shape(120, 150, ((song1.getPercentengeHeard()) + (song1.getPercentengeLike())) + 10, 30, Color.BLUE);
            glyph12.moveTo(120 - (song1.getPercentengeHeard()), 150);
            window.addShape(glyph12);
            window.repaint();
            
            window.removeShape(glyph13);
            glyph13 = new Shape(120, 180, ((song1.getmathHeard()) + (song1.getmathLike())) + 10, 30, Color.YELLOW);
            glyph13.moveTo(120 - (song1.getmathHeard()), 180);
            window.addShape(glyph13);
            window.repaint();
            
            window.removeShape(glyph14);
            glyph14 = new Shape(120, 210, ((song1.getotherHeard()) + (song1.getotherLike())) + 10, 30, Color.GREEN);
            glyph14.moveTo(120 - (song1.getotherHeard()), 210);
            window.addShape(glyph14);
            window.repaint();
            }
            else 
                if (modeChecker == 1)
                {
                AssociateHobby song1 = input.data.hobby[counter];
                window.removeShape(glyph11);
                glyph11 = new Shape(120, 120, ((song1.getPercentReadHeard()) + (song1.getPercentReadLike())) + 10, 30, Color.MAGENTA);
                glyph11.moveTo(120 - (song1.getPercentReadHeard()), 120);
                window.addShape(glyph11);
                window.repaint();
                
                window.removeShape(glyph12);
                glyph12 = new Shape(120, 150, ((song1.getPercentArtHeard()) + (song1.getPercentArtLike())) + 10, 30, Color.BLUE);
                glyph12.moveTo(120 - (song1.getPercentArtHeard()), 150);
                window.addShape(glyph12);
                window.repaint();
                
                window.removeShape(glyph13);
                glyph13 = new Shape(120, 180, ((song1.getSportsHeard()) + (song1.getSportsLike())) + 10, 30, Color.YELLOW);
                glyph13.moveTo(120 - (song1.getSportsHeard()), 180);
                window.addShape(glyph13);
                window.repaint();
                
                window.removeShape(glyph14);
                glyph14 = new Shape(120, 210, ((song1.getMusicHeard()) + (song1.getMusicLike())) + 10, 30, Color.GREEN);
                glyph14.moveTo(120 - (song1.getMusicHeard()), 210);
                window.addShape(glyph14);
                window.repaint();
                }
    }
    
    
}
