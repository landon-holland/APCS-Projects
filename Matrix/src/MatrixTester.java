// MatrixTester.java
// Landon Holland - 11/11/19
// Do matrix stuff

import javax.swing.*; // Swing
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*; // other swing stuff
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException; // file stuff

public class MatrixTester {
    public static void main(String[] args) throws IOException {
        // Matrices init
        // we'll let them have 10 in an array
        Matrix[] m = new Matrix[10];

        // JFrame init
        JFrame theGUI = new JFrame("Matrix");
        theGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        theGUI.setSize(400, 800);
        theGUI.setResizable(false);
        theGUI.setLocationRelativeTo(null);

        // Container init
        Container contentPane = theGUI.getContentPane();
        contentPane.setLayout(new FlowLayout(FlowLayout.CENTER));

        // Set up buttons
        JButton jbtnCreate = new JButton("Create Matrix");
        JButton jbtnRandom = new JButton("Random Matrix");
        JButton jbtnFile = new JButton("File Matrix");
        JButton jbtnView = new JButton("View Matrix");
        JButton jbtnAdd = new JButton("Add");
        JButton jbtnSubtract = new JButton("Subtract");
        JButton jbtnMultiply = new JButton("Multiply");
        JButton jbtnScalar = new JButton("Scalar");

        // add the buttons
        contentPane.add(jbtnCreate);
        contentPane.add(jbtnRandom);
        contentPane.add(jbtnFile);
        contentPane.add(jbtnView);
        contentPane.add(jbtnAdd);
        contentPane.add(jbtnSubtract);
        contentPane.add(jbtnMultiply);
        contentPane.add(jbtnScalar);

        // init the buttons
        jbtnCreate.addActionListener(e -> {
            // first we ask for stuff with input boxes
            int rows = Integer.parseInt(JOptionPane.showInputDialog("Rows: "));
            int cols = Integer.parseInt(JOptionPane.showInputDialog("Columns: "));
            int mcount = Integer.parseInt(JOptionPane.showInputDialog("Save Number [0-9]: "));

            m[mcount] = new Matrix(rows, cols);

            // for Create we're going to make another JFrame and make a new matrix from the inputs in that JFrame
            JFrame createGUI = new JFrame("Create");
            createGUI.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            createGUI.setResizable(false);
            createGUI.setLocationRelativeTo(null);

            // setup the container for create
            Container createContentPane = createGUI.getContentPane();

            // let's setup the JTable now
            JTable jtbMatrix = new JTable(rows, cols);
            jtbMatrix.setFont(new Font("serif", Font.PLAIN, 30));
            jtbMatrix.setRowHeight(60);

            // setup center alignment for the JTable
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(JLabel.CENTER);
            for (int i = 0; i < cols; i++) {
                jtbMatrix.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
            }

            // add it
            createContentPane.add(jtbMatrix);

            // this code is gonna setup saving the stuff
            createGUI.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    // just loop through everything and add it to the matrix
                    for (int i = 0; i < rows; i++) {
                        for (int j = 0; j < cols; j++) {
                            m[mcount].setElement(Double.parseDouble(jtbMatrix.getValueAt(i, j).toString()), i, j);
                        }
                    }

                    // tell people what number matrix it is
                    JOptionPane.showMessageDialog(null, "Saved to Matrix" + mcount);

                    super.windowClosing(e);
                }
            });

            // final JFrame init
            createGUI.pack();
            createGUI.setVisible(true);
        });

        jbtnRandom.addActionListener(e -> {
            // first we ask for stuff with input boxes
            int rows = Integer.parseInt(JOptionPane.showInputDialog("Rows: "));
            int cols = Integer.parseInt(JOptionPane.showInputDialog("Columns: "));
            int bounds = Integer.parseInt(JOptionPane.showInputDialog("Bound: "));
            int mcount = Integer.parseInt(JOptionPane.showInputDialog("Save Number [0-9]: "));

            m[mcount] = new Matrix(rows, cols, bounds);

            JOptionPane.showMessageDialog(null, "Saved to Matrix " + mcount);
        });

        jbtnFile.addActionListener(e -> {
            // first we ask for stuff with input boxes
            int mcount = Integer.parseInt(JOptionPane.showInputDialog("Save Number [0-9]: "));

            try {
                m[mcount] = new Matrix(JOptionPane.showInputDialog("Path: "));
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            JOptionPane.showMessageDialog(null, "Saved to Matrix " + mcount);
        });

        jbtnView.addActionListener(e -> {
            // first we ask for stuff with input boxes
            int mcount = Integer.parseInt(JOptionPane.showInputDialog("View Number [0-9]: "));

            // for Create we're going to make another JFrame and make a new matrix from the inputs in that JFrame
            JFrame viewGUI = new JFrame("View");
            viewGUI.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            viewGUI.setResizable(false);
            viewGUI.setLocationRelativeTo(null);

            // setup the container for create
            Container createContentPane = viewGUI.getContentPane();

            // let's setup the JTable now
            JTable jtbMatrix = new JTable(m[mcount].getArrNums().length, m[mcount].getArrNums()[0].length);
            jtbMatrix.setFont(new Font("serif", Font.PLAIN, 30));
            jtbMatrix.setRowHeight(60);

            // setup center alignment for the JTable
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(JLabel.CENTER);
            for (int i = 0; i < m[mcount].getArrNums()[0].length; i++) {
                jtbMatrix.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
            }

            // fill the table with stuff
            for (int i = 0; i < m[mcount].getArrNums().length; i++) {
                for (int j = 0; j < m[mcount].getArrNums()[0].length; j++) {
                    jtbMatrix.setValueAt(m[mcount].getArrNums()[i][j], i, j);
                }
            }

            // add it
            createContentPane.add(jtbMatrix);

            // final JFrame init
            viewGUI.pack();
            viewGUI.setVisible(true);
        });

        jbtnAdd.addActionListener(e -> {
            // first we ask for stuff with input boxes
            int mcount1 = Integer.parseInt(JOptionPane.showInputDialog("Matrix 1 [0-9]: "));
            int mcount2 = Integer.parseInt(JOptionPane.showInputDialog("Matrix 2 [0-9]: "));

            // we're going to add the matrices here
            if (m[mcount1].chAdd(m[mcount2])) {
                m[mcount1].add(m[mcount2]);

                // for Create we're going to make another JFrame and make a new matrix from the inputs in that JFrame
                JFrame addGUI = new JFrame("View");
                addGUI.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                addGUI.setResizable(false);
                addGUI.setLocationRelativeTo(null);

                // setup the container for create
                Container createContentPane = addGUI.getContentPane();

                // let's setup the JTable now
                JTable jtbMatrix = new JTable(m[mcount1].getArrNums().length, m[mcount1].getArrNums()[0].length);
                jtbMatrix.setFont(new Font("serif", Font.PLAIN, 30));
                jtbMatrix.setRowHeight(60);

                // setup center alignment for the JTable
                DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
                centerRenderer.setHorizontalAlignment(JLabel.CENTER);
                for (int i = 0; i < m[mcount1].getArrNums()[0].length; i++) {
                    jtbMatrix.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
                }

                // fill the table with stuff
                for (int i = 0; i < m[mcount1].getArrNums().length; i++) {
                    for (int j = 0; j < m[mcount1].getArrNums()[0].length; j++) {
                        jtbMatrix.setValueAt(m[mcount1].getArrNums()[i][j], i, j);
                    }
                }

                // add it
                createContentPane.add(jtbMatrix);

                // final JFrame init
                addGUI.pack();
                addGUI.setVisible(true);
            }
            else {
                JOptionPane.showMessageDialog(null, "Bad dimensions.");
            }
        });

        jbtnSubtract.addActionListener(e -> {
            // first we ask for stuff with input boxes
            int mcount1 = Integer.parseInt(JOptionPane.showInputDialog("Matrix 1 [0-9]: "));
            int mcount2 = Integer.parseInt(JOptionPane.showInputDialog("Matrix 2 [0-9]: "));

            // we're going to add the matrices here
            if (m[mcount1].chAdd(m[mcount2])) {
                m[mcount1].subtract(m[mcount2]);

                // for Create we're going to make another JFrame and make a new matrix from the inputs in that JFrame
                JFrame subtractGUI = new JFrame("View");
                subtractGUI.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                subtractGUI.setResizable(false);
                subtractGUI.setLocationRelativeTo(null);

                // setup the container for create
                Container createContentPane = subtractGUI.getContentPane();

                // let's setup the JTable now
                JTable jtbMatrix = new JTable(m[mcount1].getArrNums().length, m[mcount1].getArrNums()[0].length);
                jtbMatrix.setFont(new Font("serif", Font.PLAIN, 30));
                jtbMatrix.setRowHeight(60);

                // setup center alignment for the JTable
                DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
                centerRenderer.setHorizontalAlignment(JLabel.CENTER);
                for (int i = 0; i < m[mcount1].getArrNums()[0].length; i++) {
                    jtbMatrix.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
                }

                // fill the table with stuff
                for (int i = 0; i < m[mcount1].getArrNums().length; i++) {
                    for (int j = 0; j < m[mcount1].getArrNums()[0].length; j++) {
                        jtbMatrix.setValueAt(m[mcount1].getArrNums()[i][j], i, j);
                    }
                }

                // add it
                createContentPane.add(jtbMatrix);

                // final JFrame init
                subtractGUI.pack();
                subtractGUI.setVisible(true);
            }
            else {
                JOptionPane.showMessageDialog(null, "Bad dimensions.");
            }
        });

        jbtnMultiply.addActionListener(e -> {
            // first we ask for stuff with input boxes
            int mcount1 = Integer.parseInt(JOptionPane.showInputDialog("Matrix 1 [0-9]: "));
            int mcount2 = Integer.parseInt(JOptionPane.showInputDialog("Matrix 2 [0-9]: "));

            // we're going to add the matrices here
            if (m[mcount1].chMult(m[mcount2])) {
                m[mcount1].multiply(m[mcount2]);

                // for Create we're going to make another JFrame and make a new matrix from the inputs in that JFrame
                JFrame multiGUI = new JFrame("View");
                multiGUI.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                multiGUI.setResizable(false);
                multiGUI.setLocationRelativeTo(null);

                // setup the container for create
                Container createContentPane = multiGUI.getContentPane();

                // let's setup the JTable now
                JTable jtbMatrix = new JTable(m[mcount1].getArrNums().length, m[mcount1].getArrNums()[0].length);
                jtbMatrix.setFont(new Font("serif", Font.PLAIN, 30));
                jtbMatrix.setRowHeight(60);

                // setup center alignment for the JTable
                DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
                centerRenderer.setHorizontalAlignment(JLabel.CENTER);
                for (int i = 0; i < m[mcount1].getArrNums()[0].length; i++) {
                    jtbMatrix.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
                }

                // fill the table with stuff
                for (int i = 0; i < m[mcount1].getArrNums().length; i++) {
                    for (int j = 0; j < m[mcount1].getArrNums()[0].length; j++) {
                        jtbMatrix.setValueAt(m[mcount1].getArrNums()[i][j], i, j);
                    }
                }

                // add it
                createContentPane.add(jtbMatrix);

                // final JFrame init
                multiGUI.pack();
                multiGUI.setVisible(true);
            }
            else {
                JOptionPane.showMessageDialog(null, "Bad dimensions.");
            }
        });

        jbtnScalar.addActionListener(e -> {
            // first we ask for stuff with input boxes
            int mcount1 = Integer.parseInt(JOptionPane.showInputDialog("Matrix [0-9]: "));
            double scale = Double.parseDouble(JOptionPane.showInputDialog("Scale: "));

            // we're going to add the matrices here
            m[mcount1].scmult(scale);

            // for Create we're going to make another JFrame and make a new matrix from the inputs in that JFrame
            JFrame scaleGUI = new JFrame("View");
            scaleGUI.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            scaleGUI.setResizable(false);
            scaleGUI.setLocationRelativeTo(null);

            // setup the container for create
            Container createContentPane = scaleGUI.getContentPane();

            // let's setup the JTable now
            JTable jtbMatrix = new JTable(m[mcount1].getArrNums().length, m[mcount1].getArrNums()[0].length);
            jtbMatrix.setFont(new Font("serif", Font.PLAIN, 30));
            jtbMatrix.setRowHeight(60);

            // setup center alignment for the JTable
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(JLabel.CENTER);
            for (int i = 0; i < m[mcount1].getArrNums()[0].length; i++) {
                jtbMatrix.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
            }

            // fill the table with stuff
            for (int i = 0; i < m[mcount1].getArrNums().length; i++) {
                for (int j = 0; j < m[mcount1].getArrNums()[0].length; j++) {
                    jtbMatrix.setValueAt(m[mcount1].getArrNums()[i][j], i, j);
                }
            }

            // add it
            createContentPane.add(jtbMatrix);

            // final JFrame init
            scaleGUI.pack();
            scaleGUI.setVisible(true);
        });

        // final JFrame init
        theGUI.pack();
        theGUI.setVisible(true); // final line for JFrame init
    }
}
