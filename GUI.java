package prj5;

import java.awt.Color;
import java.text.DecimalFormat;
import java.util.Iterator;
import cs2.Button;
import cs2.Shape;
import cs2.TextShape;
import cs2.Window;
import cs2.WindowSide;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Paul Yang (906394368)
/**
 * COVIDWindow Class
 * 
 * @author Paul Yang <yangaapaul@vt.edu>
 * @version Nov 30, 2021
 */
public class GUI {
    private Window window;
    private State[] states;
    // variable keeps track of the current State displayed for sorting
    private int currState;
    /**
     * constant for the space between the bars
     */
    private static final int BAR_SPACE = 120;
    /**
     * constant for the x value for very leftmost bar
     */
    private static final int BAR_STARTX = 100;
    /**
     * constant for the y value for very leftmost bar
     */
    private static final int BAR_STARTY = 0;

    /**
     * scalar constant which changes the proportions of the bar height
     */
    private static final int BAR_HEIGHT_SCALE = 20;

    /**
     * constant for bar width
     */
    private static final int BAR_WIDTH = 15;

    /**
     * COVIDWindow Constructor
     * 
     * @param states
     *            data that was parsed from COVIDReader
     */
    public GUI(State[] states) {
        this.states = states;
        window = new Window();
        window.setTitle("yangaapaul ernieb kulbis");

        // initializes all buttons
        Button dc = new Button("Represent DC");
        dc.onClick(this, "clickedState");
        window.addButton(dc, WindowSide.SOUTH);

        Button ga = new Button("Represent GA");
        ga.onClick(this, "clickedState");
        window.addButton(ga, WindowSide.SOUTH);

        Button md = new Button("Represent MD");
        md.onClick(this, "clickedState");
        window.addButton(md, WindowSide.SOUTH);

        Button nc = new Button("Represent NC");
        nc.onClick(this, "clickedState");
        window.addButton(nc, WindowSide.SOUTH);

        Button tn = new Button("Represent TN");
        tn.onClick(this, "clickedState");
        window.addButton(tn, WindowSide.SOUTH);

        Button va = new Button("Represent VA");
        va.onClick(this, "clickedState");
        window.addButton(va, WindowSide.SOUTH);

        Button sortByAlpha = new Button("Sort By Alpha");
        sortByAlpha.onClick(this, "sortByAlpha");
        window.addButton(sortByAlpha, WindowSide.NORTH);

        Button quit = new Button("Quit");
        quit.onClick(this, "clickedQuit");
        window.addButton(quit, WindowSide.NORTH);

        Button sortByCFR = new Button("Sort By CFR");
        sortByCFR.onClick(this, "sortByCFR");
        window.addButton(sortByCFR, WindowSide.NORTH);
    }


    /**
     * Method that will visually sort the cases by CFR for the current state
     * 
     * @param sort
     *            sortByCFR Button
     */
    public void sortByCFR(Button sort) {
        for (State s : states) {
            s.getRaces().sort(new SortCFR<Race>());
        }
        updateBars(BAR_STARTX, BAR_STARTY, currState);
    }


    /**
     * Method that will visually sort the cases lexiconigraphically for the
     * current state
     * 
     * @param sort
     *            SortByAlpha button
     */
    public void sortByAlpha(Button sort) {
        for (State s : states) {
            s.getRaces().sort(new SortAlpha<Race>());
        }
        updateBars(BAR_STARTX, BAR_STARTY, currState);
    }


    /**
     * method quits out of the window
     * 
     * @param quitButton
     *            quit button
     */
    public void clickedQuit(Button quitButton) {
        System.exit(0);
    }


    /**
     * Core method in charge of updating the window as well as
     * simultaneously updating the text
     * 
     * @param barX
     *            x value of the starting bar
     * @param barY
     *            y value of the starting bar
     * @param index
     *            Index indicates which state is being updated
     */
    private void updateBars(int barX, int barY, int index) {
        // clears the window before adding bars
        window.removeAllShapes();
        // updates the instance variable current state to keep track of which
        // state is being displayed currently
        currState = index;
        State state = states[index];
        updateState(state);

        // variable increment spaces out the bars equally
        int increment = 0;
        // iterator iterates through the contents of the specific state
        for (Iterator<Race> iter = state.getRaces().iterator(); iter
            .hasNext();) {

            Race race = iter.next();
            // height of the bar
            int barHeight = (int)((race.getCFR()) * BAR_HEIGHT_SCALE);
            // determines coordinate for the bottom of the bar
            int barBottom = 215;
            // creates 5 different bars that are equally spaced apart
            Shape bar = new Shape(barX + (BAR_SPACE * increment), barBottom
                - barHeight, BAR_WIDTH, barHeight);
            bar.setBackgroundColor(Color.BLUE);
            bar.setForegroundColor(Color.BLUE);

            // sets the text for the race below the bar coordinates
            textRace(bar.getX(), bar.getY() + bar.getHeight() + 5, race
                .getName(), bar);

            // adds the bar to the window if the CFR is not -1
            if (race.getCFR() != -1) {
                window.addShape(bar);
                textRace(bar.getX(), bar.getY() + bar.getHeight() + 25,
                    new DecimalFormat("##.#").format(race.getCFR()) + "%", bar);
            }
            // window adds "NA" where the bar should be if the CFR is -1
            else {
                window.addShape(new TextShape(bar.getX(), bar.getY() + bar
                    .getHeight() - BAR_WIDTH, "NA"));
            }
            increment++;
        }
    }


    /**
     * method adds the descriptive text below the given bar bar
     * 
     * @param raceX
     *            x position of the given race
     * @param raceY
     *            y position of the given race
     * @param index
     *            specifies which state
     * @param bar
     *            specific bar that the text is being added to
     */
    private void textRace(int raceX, int raceY, String text, Shape bar) {
        TextShape shape = new TextShape(raceX, raceY, text);
        // centers text below the bar
        shape.setX(raceX + bar.getWidth() / 2 - shape.getWidth() / 2);
        window.addShape(shape);
    }


    /**
     * Method updates the text in the upper middle of the Window
     * 
     * @param state
     *            state text that is being updated
     */
    private void updateState(State state) {
        String text = state.getName() + " Case Fatality Ratios by Race";
        int textY = 20;
        TextShape shape = new TextShape(0, textY, text, Color.black);
        // centers the x value of the text in the window
        shape.setX(window.getWidth() / 2 - shape.getWidth() / 2);
        window.addShape(shape);
    }


    /**
     * method updates bars depending on the state
     * 
     * @param state
     *            button that was clicked
     */
    public void clickedState(Button state) {
        switch (state.getTitle()) {
            case ("Represent DC"):
                updateBars(BAR_STARTX, BAR_STARTY, 0);
                break;
            case ("Represent GA"):
                updateBars(BAR_STARTX, BAR_STARTY, 1);
                break;
            case ("Represent MD"):
                updateBars(BAR_STARTX, BAR_STARTY, 2);
                break;
            case ("Represent NC"):
                updateBars(BAR_STARTX, BAR_STARTY, 3);
                break;
            case ("Represent TN"):
                updateBars(BAR_STARTX, BAR_STARTY, 4);
                break;
            case ("Represent VA"):
                updateBars(BAR_STARTX, BAR_STARTY, 5);
                break;
            default:
                updateBars(BAR_STARTX, BAR_STARTY, 0);
                break;
        }
    }

}
