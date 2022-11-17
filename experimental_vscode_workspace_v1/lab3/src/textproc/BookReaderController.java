package textproc;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.plaf.PanelUI;
import java.util.Map.Entry;
import java.awt.event.*;


public class BookReaderController {
    private java.awt.event.KeyEvent evt;

    public BookReaderController(GeneralWordCounter counter) {
        SwingUtilities.invokeLater(() -> createWindow(counter, "BookReader", 100, 300));
        }

        private void createWindow(GeneralWordCounter counter, String title, int width, int height) {
        
        SortedListModel listModel = new SortedListModel(counter.getWordList());
        JList<SortedListModel> listView = new JList<SortedListModel>(listModel);
        listView.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);    
        
        JFrame frame = new JFrame(title);
        Container pane = frame.getContentPane();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JScrollPane scrollPane = new JScrollPane(listView);
        
        
        //Knappar
        JPanel buttonPanel = new JPanel();
        /* 
        JButton b1 = new JButton("Alphabetic");
        JButton b2 = new JButton("Frequency");*/

        //V4 
        JRadioButton b1 = new JRadioButton("Alphabetic");
        JRadioButton b2 = new JRadioButton("Frequency");
            
        b1.setSelected(true);
        
        buttonPanel.add(b1);
        buttonPanel.add(b2);

        //D6
        //b1.addActionListener(s -> System.out.print("Hej"));

        //Sortering
        b1.addActionListener(e -> listModel.sort((s1, s2) -> ((Entry<String, Integer>) s1).getKey().compareTo(((Entry<String, Integer>) s2).getKey())));
            
        b2.addActionListener(e -> listModel.sort((s1, s2) -> ((Entry<String, Integer>) s1).getValue() - ((Entry<String, Integer>) s2).getValue()));



            
        //Sökning
        JPanel searchJPanel = new JPanel();
        JTextField searchField = new JTextField();
        JButton searchButton = new JButton("Enter");
        searchField.setPreferredSize(new Dimension(500, (int) searchButton.getPreferredSize().getHeight()));
        JOptionPane d = new JOptionPane();
        searchJPanel.add(searchButton);
        searchJPanel.add(searchField);
;
/* 
        searchButton.addActionListener(e -> {
            String search = searchField.getText().toLowerCase().trim();
            boolean found = false;
            for(int i = 0; i < listModel.getSize(); i++){
                if(search.equals(((Entry<String, Integer>) listModel.getElementAt(i)).getKey())){
                    listView.setSelectedIndex(i);
                    listView.ensureIndexIsVisible(i); 
                    found = true; 
                }
            }
            //V2
            if(!found){
                d.showMessageDialog(null, search + " hittades inte. Försök igen", "Word not found", d.ERROR_MESSAGE);
            }
        });*/

        //v3
        ActionListener actionListener = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
               
                    String search = searchField.getText().toLowerCase().trim();
                    boolean found = false;
                    for(int i = 0; i < listModel.getSize(); i++){
                        if(search.equals(((Entry<String, Integer>) listModel.getElementAt(i)).getKey())){
                            listView.setSelectedIndex(i);
                            listView.ensureIndexIsVisible(i); 
                            found = true; 
                        }
                    }
                    //V2
                    if(!found){
                        d.showMessageDialog(null, search + " hittades inte. Försök igen", "Word not found", d.ERROR_MESSAGE);
                    }
                }
            };

            searchButton.addActionListener(actionListener);
            searchField.addActionListener(actionListener);
        
        //V3
        /*ActionListener thing = new ActionListener(e -> {
            String search = searchField.getText().toLowerCase().trim();
            boolean found = false;
            for(int i = 0; i < listModel.getSize(); i++){
                if(search.equals(((Entry<String, Integer>) listModel.getElementAt(i)).getKey())){
                    listView.setSelectedIndex(i);
                    listView.ensureIndexIsVisible(i); 
                    found = true; 
                }
            }

        //V2
            if(!found){
                d.showMessageDialog(null, "Ordet hittades inte. Försök igen", "Word not found", d.ERROR_MESSAGE);
            }
        });*/
        


        //Lägger till Panes
        pane.add(scrollPane);
        pane.add(buttonPanel, BorderLayout.SOUTH);
        pane.add(searchJPanel, BorderLayout.NORTH);
        frame.pack();
        frame.setVisible(true);
        }

}
