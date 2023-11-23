package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * @author Mads, Kevin, Daniel
 * The following method is the main method containing the method that runs the program
 * keeping the code clean and simple
 */
public class Main {
    public static void main(String[] args) {

        Streaming streaming = new Streaming();
        TextUI textui = new TextUI();

        streaming.setup();

    }
}