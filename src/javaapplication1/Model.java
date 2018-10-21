package javaapplication1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
/**
 *Source of data, consists of two-dimensional array, one array with co-ordinates of actual selected square  
 *
 */
public class Model {

    private int[][] numbers = new int[9][9]; //dwuwymiarowa tablica
    private int[] selected = new int[2]; //wspolrzedne zaznaczenia
    /**
     * Get numbers of row and column
     * @return number
     */
    public int[][] getNumbers() {
        return numbers;
    }
    /**
     * Get select co-ordinates
     * @return co-ordinates of selection
     */
    public int[] getSelected() {
        return selected;
    }
    /**
     * Empty class constructor  
     */
    public Model() 
    {
    }
    /**
    *Clear the board 
    */
    public void Clear()
    {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                numbers[i][j] = 0;
            }
        }
    }
    /**
     * Load and parse file with game
     * @param name the name of file with game
     * @throws IOException if IOException is detected
     */
    public void load(String name) throws IOException {
        if (name == null) {
            Clear();
        } else {
            String filename = new java.io.File(String.format("./src/javaapplication1/premade/%s", name)).getCanonicalPath();
            String data = new String(Files.readAllBytes(Paths.get(filename)));
            for (int r = 0; r <= 8; r++) {
                for (int c = 0; c <= 8; c++) {
                    this.numbers[r][c] = Integer.parseInt(Character.toString(data.charAt(r * 10 + c)));
                }
            }
        }

        selected = new int[2];
    }
}
