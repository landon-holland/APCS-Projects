import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class BookRecGUI extends JFrame implements ActionListener {
    private BookRec br;
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem jmnuiA, jmnuiB, jmnuiC;
    private JPanel p;
    private JTextField txtField;
    private JList bookList;
    private DefaultListModel demoList = new DefaultListModel();
    private JLabel readerName, img;

    public BookRecGUI() throws IOException {
        this(new BookRec());
    }
    public BookRecGUI(BookRec br) {
        this.br = br;

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setSize(1900, 1000);

        // Time to setup JMenu stuff
        menuBar = new JMenuBar();
        menu = new JMenu("BookRec");

        // menu items
        jmnuiA = new JMenuItem("Method A");
        jmnuiB = new JMenuItem("Method B");
        jmnuiC = new JMenuItem("Method C");

        // text field
        txtField = new JTextField(15);

        // add items to menu
        menu.add(txtField);
        menu.add(jmnuiA);
        menu.add(jmnuiB);
        menu.add(jmnuiC);

        // add actionlisteners
        jmnuiA.addActionListener(this);
        jmnuiB.addActionListener(this);
        jmnuiC.addActionListener(this);

        // add menubar to JPanel
        setJMenuBar(menuBar);

        // add menu to menubar
        menuBar.add(menu);

        // setup a panel to do stuff in
        p = new JPanel();

        // now we need to add a list and some label
        bookList = new JList(demoList);
        img = new JLabel();
        bookList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting() && !(bookList.getSelectedValue() == null)) {
                    img.setIcon(new ImageIcon(br.getBl().findBook(bookList.getSelectedValue().toString()).getCover()));
                }
            }
        });
        readerName = new JLabel();

        // add the stuff
        p.add(bookList);
        p.add(readerName);
        p.add(img);
        add(p);

        // final setup
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        demoList.clear(); // restart
        if (e.getActionCommand().equals("Method A")) {
            Book[] similarBooks = br.findBooksA(br.getRl().findReader(txtField.getText()));
            for (int i = 0; i < similarBooks.length; i++) {
                demoList.add(i, similarBooks[i].toString());
            }
        }
        else if (e.getActionCommand().equals("Method B")) {
            readerName.setText(br.findSimilarReaderB(br.getRl().findReader(txtField.getText())).toString());
            Book[] similarBooks = br.findSimilarBooks(br.getRl().findReader(txtField.getText()), br.findSimilarReaderB(br.getRl().findReader(txtField.getText())));
            for (int i = 0; i < similarBooks.length; i++) {
                demoList.add(i, similarBooks[i].toString());
            }
        }
        else if (e.getActionCommand().equals("Method C")) {
            Book similarBook = br.findSimilarBookC(br.getRl().findReader(txtField.getText()));
            demoList.add(0, similarBook.toString());
        }
    }
}
