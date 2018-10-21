/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class contains all logic of game
 *
 */
public class Controller 
{
    private Model model;
/**
 * Class contructor
 * @param model
 */
    public Controller(Model model) {
        this.model = model;
    }
    /**
     * Function which load file by model method
     * @param fileName name of file with game
     */
    public void loadNewBoard(String fileName) 
    {
        try {
            model.load(fileName);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
    /**
     * model method which clear board
     */
    public void clear()
    {       
        model.Clear();        
    }
    /**
     * Function of the model which...
     * @return current selection co-ordianates on the board
     */
    public int[] getCurrentSelection()
    {
        return model.getSelected();
    }
    /**
     * Function which checks all logic of the game, if all conditions are met we can insert digit
     * @param row current row
     * @param column current column
     * @param digit digit which we want to insert
     */
    public void put(int row, int column, int digit) {
        try {
            if (digit > 0) {
                assert 0 <= row && row <= 8;
                assert 0 <= column && column <= 8;
                assert 1 <= digit && digit <= 9;
                assert this.model.getNumbers()[row][column] == 0;

                for (int r = 0; r <= 8; r++) {
                    assert this.model.getNumbers()[r][column] != digit;
                }
                for (int c = 0; c <= 8; c++) {
                    assert this.model.getNumbers()[row][c] != digit;
                }
                int r0 = (row ) / 3 ;
                int c0 = (column) / 3;
                
                for (int r = 0; r < 3; r++) {
                    for (int c = 0; c < 3; c++) {
                        assert this.model.getNumbers()[3*r0 + r][3*c0 + c] != digit;
                    }
                }
            }
            this.model.getNumbers()[row][column] = digit;
        } catch (AssertionError e) {
            // jesli pozycja lub cyfra jest bledna (w tym powiela sie w wierszu/kolumnie)
            // to nie zmienia krzyzowki,
        }
    }
    /**
     * Method which gives digit which is on given field 
     * @param row number of row
     * @param column number of column
     * @return digit which is in field
     */
    public int get(int row,int column)
    {
        return model.getNumbers()[row][column];
    }
    /**
     * Function which checks if sudoku is solved
     * @return text label if yes
     */
    public boolean isSolved() {
        for (int r = 0; r <= 8; r++) {
            for (int c = 0; c <= 8; c++) {
                if (this.model.getNumbers()[r][c] == 0) {
                    return false;
                }
            }
        }
        return true;
    }
    /**
     * Function which set current selection
     * @param x x coordinate
     * @param y y coordinate
     */
    void setCurentSelection(int x, int y) {
        model.getSelected()[0] = x;
        model.getSelected()[1] = y;
    }
}
