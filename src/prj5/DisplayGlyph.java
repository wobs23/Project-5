package prj5;

import java.awt.Color;
import CS2114.Shape;
import CS2114.TextShape;
import CS2114.Window;

public class DisplayGlyph {
    String songTitle;
    String artist;
    int year;
    String genre;
    
    TextShape title;
    TextShape data;
    
    Shape pinkHeard;
    Shape pinkLike;
    
    Shape blueHeard;
    Shape blueLike;
    
    Shape orangeHeard;
    Shape orangeLike;
    
    Shape greenHeard;
    Shape greenLike;
    
    Song song;
    InputScan input;
    
    int mode;
    
    public DisplayGlyph(String songTitle, String artist, int year, String genre, 
        Song song, InputScan input, int modeChecker)
    {
        this.songTitle = songTitle;
        this.artist = artist;
        this.year = year;
        this.genre = genre;
        this.song = song;
        this.input = input;
        mode = modeChecker;
    }
    
    public void drawGlyph(Window window, int offsetX, int offsetY, int represent)
    {
        int xValue = 150 + offsetX;
        title = new TextShape(60 + offsetX, 70 + offsetY, songTitle);
        xValue = xValue - title.getWidth()/2;
        title.setX(xValue);
        title.setBackgroundColor(Color.white);
        window.addShape(title);
        

        xValue = 150 + offsetX;
        if (represent == 0)
        {
            data = new TextShape(xValue, 85 + offsetY, artist);
            xValue = xValue - data.getWidth()/2;
            data.setX(xValue);
            data.setBackgroundColor(Color.white);
            window.addShape(data);
        }
        else if (represent == 1)
        {
            data = new TextShape(xValue, 85 + offsetY, year + "");
            xValue = xValue - data.getWidth()/2;
            data.setX(xValue);
            data.setBackgroundColor(Color.white);
            window.addShape(data);
        }
        else if (represent == 2)
        {
            data = new TextShape(xValue, 85 + offsetY, genre);
            xValue = xValue - data.getWidth()/2;
            data.setX(xValue);
            data.setBackgroundColor(Color.white);
            window.addShape(data);
        }
        
        if (mode == -1)
        {
            drawBarsGenre(offsetX, offsetY, window);
        }
        else if (mode == 0)
        {
            drawBarsMajor(offsetX, offsetY, window);
        }
        else if (mode == 1)
        {
            drawBarsRegion(offsetX, offsetY, window);
        }
    }
    
    public void drawBarsGenre(int offsetX, int offsetY, Window window)
    {
        //PINK BARS
        window.addShape(new Shape(150 + offsetX, 110 + offsetY, 3, 80, Color.BLACK));
        int heardPinkPerc = input.data.getHobbyData()[song.getDataLoc()].getPercentReadHeard();
        pinkHeard = new Shape(150 + offsetX, 110 + offsetY, heardPinkPerc, 20, Color.MAGENTA);
        window.addShape(pinkHeard);
        
        int likePinkPerc = input.data.getHobbyData()[song.getDataLoc()].getPercentReadLike();
        pinkLike = new Shape(150 + offsetX - likePinkPerc, 110 + offsetY, likePinkPerc, 20, Color.MAGENTA);
        window.addShape(pinkLike);
        
        //BLUE BARS
        int heardBluePerc = input.data.getHobbyData()[song.getDataLoc()].getPercentArtHeard();
        blueHeard = new Shape(150 + offsetX, 130 + offsetY, heardBluePerc, 20, Color.BLUE);
        window.addShape(blueHeard);
        
        int likeBluePerc = input.data.getHobbyData()[song.getDataLoc()].getPercentArtLike();
        blueLike = new Shape(150 + offsetX - likeBluePerc, 130 + offsetY, likeBluePerc, 20, Color.BLUE);
        window.addShape(blueLike);
        
        //ORANGE BARS
        int heardOrangePerc = input.data.getHobbyData()[song.getDataLoc()].getPercentSportsHeard();
        orangeHeard = new Shape(150 + offsetX, 150 + offsetY, heardOrangePerc, 20, Color.ORANGE);
        window.addShape(orangeHeard);
        
        int likeOrangePerc = input.data.getHobbyData()[song.getDataLoc()].getPercentSportsLike();
        orangeLike = new Shape(150 + offsetX - likeOrangePerc, 150 + offsetY, likeOrangePerc, 20, Color.ORANGE);
        window.addShape(orangeLike);
        
        //GREEN BARS
        int heardGreenPerc = input.data.getHobbyData()[song.getDataLoc()].getPercentMusicHeard();
        greenHeard = new Shape(150 + offsetX, 170 + offsetY, heardGreenPerc, 20, Color.GREEN);
        window.addShape(greenHeard);
        
        int likeGreenPerc = input.data.getHobbyData()[song.getDataLoc()].getPercentMusicLike();
        greenLike = new Shape(150 + offsetX - likeGreenPerc, 170 + offsetY, likeGreenPerc, 20, Color.GREEN);
        window.addShape(greenLike);
    }
    
    public void drawBarsRegion(int offsetX, int offsetY, Window window)
    {
        //PINK BARS
        window.addShape(new Shape(150 + offsetX, 110 + offsetY, 3, 80, Color.BLACK));
        int heardPinkPerc = input.data.getRegionData()[song.getDataLoc()].getPercentneHeard();
        pinkHeard = new Shape(150 + offsetX, 110 + offsetY, heardPinkPerc, 20, Color.MAGENTA);
        window.addShape(pinkHeard);
        
        int likePinkPerc = input.data.getRegionData()[song.getDataLoc()].getPercentneLike();
        pinkLike = new Shape(150 + offsetX - likePinkPerc, 110 + offsetY, likePinkPerc, 20, Color.MAGENTA);
        window.addShape(pinkLike);
        
        //BLUE BARS
        int heardBluePerc = input.data.getRegionData()[song.getDataLoc()].getPercentseHeard();
        blueHeard = new Shape(150 + offsetX, 130 + offsetY, heardBluePerc, 20, Color.BLUE);
        window.addShape(blueHeard);
        
        int likeBluePerc = input.data.getRegionData()[song.getDataLoc()].getPercentseLike();
        blueLike = new Shape(150 + offsetX - likeBluePerc, 130 + offsetY, likeBluePerc, 20, Color.BLUE);
        window.addShape(blueLike);
        
        //ORANGE BARS
        int heardOrangePerc = input.data.getRegionData()[song.getDataLoc()].getPercentusHeard();
        orangeHeard = new Shape(150 + offsetX, 150 + offsetY, heardOrangePerc, 20, Color.ORANGE);
        window.addShape(orangeHeard);
        
        int likeOrangePerc = input.data.getRegionData()[song.getDataLoc()].getPercentusLike();
        orangeLike = new Shape(150 + offsetX - likeOrangePerc, 150 + offsetY, likeOrangePerc, 20, Color.ORANGE);
        window.addShape(orangeLike);
        
        //GREEN BARS
        int heardGreenPerc = input.data.getRegionData()[song.getDataLoc()].getPercentotherHeard();
        greenHeard = new Shape(150 + offsetX, 170 + offsetY, heardGreenPerc, 20, Color.GREEN);
        window.addShape(greenHeard);
        
        int likeGreenPerc = input.data.getRegionData()[song.getDataLoc()].getPercentotherLike();
        greenLike = new Shape(150 + offsetX - likeGreenPerc, 170 + offsetY, likeGreenPerc, 20, Color.GREEN);
        window.addShape(greenLike);
    }
    
    public void drawBarsMajor(int offsetX, int offsetY, Window window)
    {
        //PINK BARS
        window.addShape(new Shape(150 + offsetX, 110 + offsetY, 3, 80, Color.BLACK));
        int heardPinkPerc = input.data.getMajorData()[song.getDataLoc()].getPercentcsHeard();
        pinkHeard = new Shape(150 + offsetX, 110 + offsetY, heardPinkPerc, 20, Color.MAGENTA);
        window.addShape(pinkHeard);
        
        int likePinkPerc = input.data.getMajorData()[song.getDataLoc()].getPercentcsLike();
        pinkLike = new Shape(150 + offsetX - likePinkPerc, 110 + offsetY, likePinkPerc, 20, Color.MAGENTA);
        window.addShape(pinkLike);
        
        //BLUE BARS
        int heardBluePerc = input.data.getMajorData()[song.getDataLoc()].getPercentengeHeard();
        blueHeard = new Shape(150 + offsetX, 130 + offsetY, heardBluePerc, 20, Color.BLUE);
        window.addShape(blueHeard);
        
        int likeBluePerc = input.data.getMajorData()[song.getDataLoc()].getPercentengeLike();
        blueLike = new Shape(150 + offsetX - likeBluePerc, 130 + offsetY, likeBluePerc, 20, Color.BLUE);
        window.addShape(blueLike);
        
        //ORANGE BARS
        int heardOrangePerc = input.data.getMajorData()[song.getDataLoc()].getPercentmathHeard();
        orangeHeard = new Shape(150 + offsetX, 150 + offsetY, heardOrangePerc, 20, Color.ORANGE);
        window.addShape(orangeHeard);
        
        int likeOrangePerc = input.data.getMajorData()[song.getDataLoc()].getPercentmathLike();
        orangeLike = new Shape(150 + offsetX - likeOrangePerc, 150 + offsetY, likeOrangePerc, 20, Color.ORANGE);
        window.addShape(orangeLike);
        
        //GREEN BARS
        int heardGreenPerc = input.data.getMajorData()[song.getDataLoc()].getPercentotherHeard();
        greenHeard = new Shape(150 + offsetX, 170 + offsetY, heardGreenPerc, 20, Color.GREEN);
        window.addShape(greenHeard);
        
        int likeGreenPerc = input.data.getMajorData()[song.getDataLoc()].getPercentotherLike();
        greenLike = new Shape(150 + offsetX - likeGreenPerc, 170 + offsetY, likeGreenPerc, 20, Color.GREEN);
        window.addShape(greenLike);
    }
    
    public void removeShapes(Window window)
    {
        window.removeShape(title);
        window.removeShape(data);
        window.removeShape(pinkHeard);
        window.removeShape(pinkLike);
        window.removeShape(blueHeard);
        window.removeShape(blueLike);
        window.removeShape(orangeHeard);
        window.removeShape(orangeLike);
        window.removeShape(greenHeard);
        window.removeShape(greenLike);
        
    }
}
