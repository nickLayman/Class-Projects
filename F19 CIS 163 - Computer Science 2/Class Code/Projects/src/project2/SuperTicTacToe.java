package project2;

import javax.swing.*;

public class SuperTicTacToe {

    private static int size;
    private static int timeLimit;

    public static void main (String[] args)
    {
        JFrame frame = new JFrame ("Super TicTacToe");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

        int height = 3;
        int width = 3;
        int connections = 3;
        boolean isError;
        String temp = "";
        Boolean AI = true;
        do {
            isError = false;
            try {
                do {String s = JOptionPane.showInputDialog(null,
                        "Enter the height of the board:");
                    if (s == null)
                            throw new NullPointerException();
                    height = Integer.parseInt(s);
                } while (height < 3 || height > 15);

                do {

                    String s = JOptionPane.showInputDialog(null,
                            "Enter the width of the board:");
                    if (s == null)
                        throw new NullPointerException();
                    width = Integer.parseInt(s);
                } while (width < 3 || width > 15);

                int minConnections = 3;
                if (height > 3 && width > 3)
                    minConnections = 4;
                do {
                    String s = JOptionPane.showInputDialog(null,
                            "How many in a row to win?");
                    if (s == null)
                        throw new NullPointerException();
                    connections = Integer.parseInt(s);
                } while (connections > width || connections > height
                        || connections < minConnections);

                temp = JOptionPane.showInputDialog (null,
                        "Who starts first? X or O");
                if (temp == null)
                    throw new NullPointerException();
            } catch (NumberFormatException e) {
                isError = true;
            } catch (NullPointerException n){
                System.exit(0);
            }
        } while(isError);

        if (!temp.toUpperCase().equals("O") && !temp.toUpperCase().equals("X"))
            JOptionPane.showMessageDialog(null,
                    "X has been used by default");

        Cell starter = (temp.toUpperCase().equals("O")) ? Cell.O : Cell.X;

        AI = JOptionPane.showConfirmDialog(null,
                "Would you like to play an AI?", "AI", JOptionPane.YES_NO_OPTION)
                == JOptionPane.YES_OPTION;
        SuperTicTacToePanel panel = new SuperTicTacToePanel(height, width,
                connections, starter, AI);
        frame.getContentPane().add(panel);

        frame.setSize((width+1)*70,(height+1)*70);
        frame.setVisible(true);
    }


}

