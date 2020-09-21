package common;

import javax.swing.*;
import java.awt.*;

public class GridPanel extends JPanel {
    private JButton[][] buttons = null;
    private int[][] grid = null;
    private boolean[][] selected = null;

    public void refreshGrid(int[][] grid) {
        assert grid != null && grid.length > 0 && grid[0].length > 0: "null grid is not allowed";
        setLayout(new GridLayout(grid.length, grid[0].length));
        this.grid = grid;
        this.buttons = new JButton[grid.length][grid[0].length];
        this.selected = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                buttons[i][j] = new JButton(String.valueOf(grid[i][j]));
                buttons[i][j].setActionCommand(i+","+j);
                buttons[i][j].addActionListener((event) -> {
                    String[] coordinates = event.getActionCommand().split(",");
                    int x = Integer.parseInt(coordinates[0]), y = Integer.parseInt(coordinates[1]);
                    selected[x][y] = !selected[x][y];
                    buttons[x][y].setBackground(selected[x][y] ? Color.RED : null);
                });
                add(buttons[i][j]);
            }
        }
        setVisible(true);
    }

    public static void main(String[] args) {
        JDialog jDialog = new JDialog();
        jDialog.setVisible(true);
        GridPanel gridPanel = new GridPanel();
        gridPanel.refreshGrid(new int[][]{
                {4, 0, -4, -4, 0, 3, -1, 3, 2, 4, 1, -4, 3},
                {3, -3, 1, 0, -4, 2, -1, -2, -3, -1, 2, 1, 3},
                {-3, -1, 2, 3, -1, 3, -1, -1, 3, 2, 0, -3, -2},
                {-3, -3, -2, -1, -4, -3, -2, 0, 4, -3, 0, 3, -2},
                {-1, -3, -2, -2, 1, -3, 4, 2, 3, 1, -1, 3, -1},
                {2, -2, -1, 2, -2, -4, 2, 0, -3, -3, -1, 1, 3},
                {-4, 1, -3, -4, 0, 3, 4, 0, 3, -2, 4, -3, -2},
                {1, -4, -2, -4, 4, -4, -3, 3, -4, 2, -2, 3, -4},
                {4, 4, -3, 1, 0, 0, 2, 4, -4, 2, -1, -4, -4},
                {1, 0, 3, 3, 4, 1, 4, 4, 3, -1, 4, 2, 0},
                {-1, -1, -3, -2, -3, 2, -1, -3, 2, 1, -3, -4, 4},
                {-2, -1, 2, -3, 4, 4, -2, -3, -4, -4, 2, 0, 0}
        });
        jDialog.add(gridPanel);
        jDialog.pack();
    }
}
