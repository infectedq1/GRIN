package com.nstu.grin.model;

import au.com.bytecode.opencsv.CSVReader;
import com.nstu.grin.pojo.GraphLine;
import com.nstu.grin.pojo.Graphic;
import com.nstu.grin.pojo.Point;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class Parser {

    public static Graphic parse(String csv) {
        CSVReader reader;
        Graphic gr = new Graphic();
        try {
            reader = new CSVReader(new FileReader(csv), ',');
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
            return null;
        }

        String[] nextLine;

        try {
            nextLine = reader.readNext();

            for (String funcName : nextLine) {
                GraphLine graphLine = new GraphLine();
                graphLine.setName(funcName);
                gr.addGraphLine(graphLine);
            }

            while ((nextLine = reader.readNext()) != null) {
                if (nextLine != null) {
                    Double argument = Double.parseDouble(nextLine[0]);

                    for (int i = 0; i < nextLine.length; ++i) {
                        gr.getGraphLines().get(i).addPoint(new Point(argument, Double.parseDouble(nextLine[i])));
                    }
                }
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }

        return gr;
    }

}
