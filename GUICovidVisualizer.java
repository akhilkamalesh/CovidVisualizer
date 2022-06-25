package prj5;

import java.text.DecimalFormat;
import cs2.Button;
import cs2.Shape;
import cs2.TextShape;
import cs2.Window;
import cs2.WindowSide;

/**
 * GUICovidVisualizer creates and updates the front-end of this project, to make
 * a visual representation of the Covid-19 CFR charts per region. To use this
 * class, just instantiate an object in DataLoader and pass a regions object.
 * 
 * @author Zachary Gaydos (zachg), Roshan Sanyal (roshans19), Akhil Kamalesh
 *         (akhilk24)
 * @version 2020.11.21
 *
 */

public class GUICovidVisualizer {

    private int selectedRegions;
    private Region[] regions;
    private Window window;
    private Button sortCFR;
    private Button sortAlpha;
    private Button quit;
    private Button[] region;
    private TextShape title;

    /**
     * Constructor
     * 
     * @param r
     *            Region[] regions that are shown in the visual representation
     */
    public GUICovidVisualizer(Region[] r) {
        window = new Window();
        window.setTitle("Covid Visualition");

        title = new TextShape(0, 0, "");

        // Initialize Buttons
        sortCFR = new Button("Sort by CFR");
        sortCFR.onClick(this, "clickedSortCFR");

        quit = new Button("Quit");
        quit.onClick(this, "clickedQuit");

        sortAlpha = new Button("Sort by Alpha");
        sortAlpha.onClick(this, "clickedSortAlpha");

        window.addButton(sortAlpha, WindowSide.NORTH);
        window.addButton(quit, WindowSide.NORTH);
        window.addButton(sortCFR, WindowSide.NORTH);

        regions = r;
        region = new Button[regions.length];
        for (int i = 0; i < regions.length; i++) {
            region[i] = new Button("Represent " + regions[i].getName());
            region[i].onClick(this, "clickedRegion");
            window.addButton(region[i], WindowSide.SOUTH);
        }
    }


    /**
     * This method quits out of the window
     * 
     * @param button
     *            Button to click out of the window
     */
    public void clickedQuit(Button button) {
        System.exit(0);
    }


    /**
     * This method is used when a region button is clicked. This shows the
     * visual representation of the Covid-19 cases per race there are in that
     * region
     * 
     * @param button
     *            Button to click on the region
     * 
     */
    public void clickedRegion(Button button) {
        window.removeAllShapes();

        String buttonPress = button.getTitle().split(" ")[1];
        for (int i = 0; i < regions.length; i++) {
            if (buttonPress.equals(regions[i].getName())) {
                selectedRegions = i;
                break;
            }
        }

        title = new TextShape(300, 25, buttonPress
            + " Case Fatality Ratios by Race");
        window.addShape(title);

        for (int i = 0; i < regions[selectedRegions].getEthinicities()
            .getSize(); i++) {
            TextShape ethnicity = new TextShape(150 + (100 * i), 250,
                regions[selectedRegions].getEthinicities().getAnEntry(i)
                    .getName());
            window.addShape(ethnicity);
            String per = new DecimalFormat("#.#").format(
                regions[selectedRegions].getEthinicities().getAnEntry(i)
                    .getCFR());
            if (regions[selectedRegions].getEthinicities().getAnEntry(i)
                .getCFR() == -1.0) {
                TextShape na = new TextShape(155 + (100 * i), 230, "NA");
                window.addShape(na);
            }
            else {
                TextShape cfr = new TextShape(155 + (100 * i), 275, per + "%");
                window.addShape(cfr);
            }
            Shape bars = new Shape(160 + (100 * i), 250
                - (int)(regions[selectedRegions].getEthinicities().getAnEntry(i)
                    .getCFR() * 20.0), 20, (int)(regions[selectedRegions]
                        .getEthinicities().getAnEntry(i).getCFR() * 20.0),
                java.awt.Color.blue);
            window.addShape(bars);
        }
    }


    /**
     * Sorts the races in the region in alphabetical order
     * 
     * @param button
     *            Button to click on sortAlpha
     */
    public void clickedSortAlpha(Button button) {
        window.removeAllShapes();
        for (int i = 0; i < regions.length; i++) {
            regions[i].sortAlpha();
        }
        clickedRegion(button);
        window.removeShape(title);
        title = new TextShape(300, 25, regions[selectedRegions].getName()
            + " Case Fatality Ratios by Race");
        window.addShape(title);
    }


    /**
     * Sorts the races in the region based on their CFR percentage
     * 
     * @param button
     *            Button to click on sortAlpha
     */
    public void clickedSortCFR(Button button) {
        window.removeAllShapes();
        for (int i = 0; i < regions.length; i++) {
            regions[i].sortByCFR();
        }
        clickedRegion(button);
        window.removeShape(title);
        title = new TextShape(300, 25, regions[selectedRegions].getName()
            + " Case Fatality Ratios by Race");
        window.addShape(title);
    }

}
