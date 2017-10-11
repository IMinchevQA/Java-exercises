package graphs_SoftUni_Lecture_21Apr2016;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Ivan Minchev on 10/2/2017.
 */
public class Ex01_Graph_Representations {
    public static void main(String[] args) {

        //Graph representation - adjacency list
        @SuppressWarnings("unchecked")
        List<Integer>[] graphList = new ArrayList[]{
            new ArrayList<Integer>(Arrays.asList(3, 6)),
            new ArrayList<Integer> (Arrays.asList(2, 3, 4, 5, 6)),
            new ArrayList<Integer> (Arrays.asList(1, 4, 5)),
            new ArrayList<Integer> (Arrays.asList(0, 1, 5)),
            new ArrayList<Integer> (Arrays.asList(1, 2, 6)),
            new ArrayList<Integer> (Arrays.asList(1, 2, 3)),
            new ArrayList<Integer> (Arrays.asList(0, 1, 4))
        };

        //Graph representation - adjacency matrix
        int[][] graphMatrix = {
            { 0, 0, 0, 1, 0, 0, 1 }, // node 0
            { 0, 0, 1, 1, 1, 1, 1 }, // node 1
            { 0, 1, 0, 0, 1, 1, 0 }, // node 2
            { 1, 1, 0, 0, 0, 1, 0 }, // node 3
            { 0, 1, 1, 0, 0, 0, 1 }, // node 4
            { 0, 1, 1, 1, 0, 0, 0 }, // node 5
            { 1, 1, 0, 0, 1, 0, 0 }, // node 6
        };

        //Graph representation - adjacency HashMap
        HashMap<String, List<String>> graphMap = new HashMap<String, List<String>>(){{
            put("Sofia", new ArrayList<>(Arrays.asList("Plovdiv", "Varna", "Bourgas", "Pleven", "Stara Zagora" )));
            put("Plovdiv", new ArrayList<>(Arrays.asList("Bourgas", "Ruse" )));
            put("Varna", new ArrayList<>(Arrays.asList("Ruse", "Stara Zagora")));
            put("Bourgas", new ArrayList<>(Arrays.asList("Plovdiv", "Pleven")));
            put("Ruse", new ArrayList<>(Arrays.asList("Varna", "Plovdiv")));
            put("Pleven", new ArrayList<>(Arrays.asList("Bourgas", "Stara Zagora")));
            put("Stara Zagora", new ArrayList<>(Arrays.asList("Varna", "Pleven")));
        }};

        System.out.println();

    }
}
