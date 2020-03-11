import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultCaret;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import javax.swing.event.ListSelectionEvent;
import javax.swing.BorderFactory;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.CardLayout;
import java.awt.Font;

public class Dictionay {

  private JFrame frmDictionary;
  private JTextField txtSearch;
  private final ButtonGroup buttonGroup = new ButtonGroup();
  private JTextField textField;
  private JTextField txtDefinitions;
  private JTextField textField_2;
  private JTextField textField_1;
  private JTextField textField_3;

  /**
   * Launch the application.
   * @throws FileNotFoundException
   */
  public static void main(String[] args) throws FileNotFoundException {
    getWords();
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          Dictionay window = new Dictionay();
          window.frmDictionary.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

//  get DLM of words sorted in asc order
  private static DefaultListModel<String> getWords() throws FileNotFoundException{
    Gson gson = new Gson();
        String classpathDirectory = Utils.getClasspathDir();
        BufferedReader br = new BufferedReader(new FileReader(classpathDirectory + "words.json"));
        Words[] words = gson.fromJson(br, Words[].class);
        System.out.println(words.length + " words added");
        DefaultListModel<String> listOfWords = new DefaultListModel<String>();
        for (Words word : words) {
          listOfWords.addElement(word.getWord());
        }
       ;
        return  Utils.sortWordsAsc(listOfWords);
  }

//  get ArrayList of words sorted in asc order
  private static ArrayList<Words> getWordClass() throws FileNotFoundException{
    Gson gson = new Gson();
        String classpathDirectory = Utils.getClasspathDir();
        BufferedReader br = new BufferedReader(new FileReader(classpathDirectory + "words.json"));
        Words[] words = gson.fromJson(br, Words[].class);
        ArrayList<Words> listOfWords = new ArrayList<Words>();
        for (Words word : words) {
          listOfWords.add(word);
        }
       ;
        return listOfWords;
  }

  /**
   * Create the application.
   * @throws FileNotFoundException
   * @throws BadLocationException
   */
  public Dictionay() throws FileNotFoundException, BadLocationException {
    initialize();
  }

  /**
   * Initialize the contents of the frame.
   * @throws FileNotFoundException
   * @throws BadLocationException
   */
  private void initialize() throws FileNotFoundException, BadLocationException {
    frmDictionary = new JFrame();
    frmDictionary.setResizable(false);
    frmDictionary.setTitle("Dictionary");
    frmDictionary.setBounds(100, 100, 800, 600);
    frmDictionary.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frmDictionary.getContentPane().setLayout(null);

    JPanel panel = new JPanel();
    panel.setBounds(207, 11, 566, 549);
    frmDictionary.getContentPane().add(panel);
    panel.setLayout(new CardLayout(0, 0));
    
    JScrollPane scrollPane_3 = new JScrollPane();
    panel.add(scrollPane_3, "addWord");
    
    JPanel panel_1 = new JPanel();
    panel_1.setToolTipText("");
    panel_1.setBackground(Color.WHITE);
    scrollPane_3.setViewportView(panel_1);
    panel_1.setLayout(null);
    
    JLabel lblNewLabel = new JLabel("Word");
    lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 32));
    lblNewLabel.setBounds(10, 11, 117, 54);
    panel_1.add(lblNewLabel);
    
    textField = new JTextField();
    textField.setToolTipText("word");
    textField.setBounds(20, 76, 286, 20);
    panel_1.add(textField);
    textField.setColumns(10);
    
    JButton btnNewButton_2 = new JButton("Add");
    btnNewButton_2.setBounds(465, 513, 89, 23);
    panel_1.add(btnNewButton_2);
    
    JLabel lblDefinitions = new JLabel("Definitions");
    lblDefinitions.setFont(new Font("Tahoma", Font.BOLD, 32));
    lblDefinitions.setBounds(10, 107, 199, 54);
    panel_1.add(lblDefinitions);
    
    txtDefinitions = new JTextField();
    txtDefinitions.setToolTipText("Definitions");
    txtDefinitions.setColumns(10);
    txtDefinitions.setBounds(20, 182, 286, 20);
    panel_1.add(txtDefinitions);
    
    textField_2 = new JTextField();
    textField_2.setToolTipText("Part of Speech");
    textField_2.setColumns(10);
    textField_2.setBounds(346, 182, 147, 20);
    panel_1.add(textField_2);
    
    JLabel lblPartOfSpech = new JLabel("Parts of Speech");
    lblPartOfSpech.setFont(new Font("Tahoma", Font.BOLD, 18));
    lblPartOfSpech.setBounds(336, 130, 157, 20);
    panel_1.add(lblPartOfSpech);
    
    JLabel lblSynonyms = new JLabel("Synonyms");
    lblSynonyms.setFont(new Font("Tahoma", Font.BOLD, 32));
    lblSynonyms.setBounds(10, 213, 184, 54);
    panel_1.add(lblSynonyms);
    
    textField_1 = new JTextField();
    textField_1.setToolTipText("synonym");
    textField_1.setColumns(10);
    textField_1.setBounds(20, 287, 286, 20);
    panel_1.add(textField_1);
    
    JLabel lblSeperateByComma = new JLabel("Seperate by comma");
    lblSeperateByComma.setFont(new Font("Tahoma", Font.PLAIN, 12));
    lblSeperateByComma.setBounds(20, 264, 137, 20);
    panel_1.add(lblSeperateByComma);
    
    JLabel label = new JLabel("Seperate by comma");
    label.setFont(new Font("Tahoma", Font.PLAIN, 12));
    label.setBounds(20, 157, 137, 20);
    panel_1.add(label);
    
    JLabel label_1 = new JLabel("Seperate by comma");
    label_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
    label_1.setBounds(346, 161, 137, 20);
    panel_1.add(label_1);
    
    JLabel lblAntonyms = new JLabel("Antonyms");
    lblAntonyms.setFont(new Font("Tahoma", Font.BOLD, 32));
    lblAntonyms.setBounds(10, 318, 184, 54);
    panel_1.add(lblAntonyms);
    
    JLabel label_2 = new JLabel("Seperate by comma");
    label_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
    label_2.setBounds(20, 369, 137, 20);
    panel_1.add(label_2);
    
    textField_3 = new JTextField();
    textField_3.setToolTipText("antonyms");
    textField_3.setColumns(10);
    textField_3.setBounds(20, 400, 286, 20);
    panel_1.add(textField_3);
    
    JScrollPane scrollPane_2 = new JScrollPane();
    panel.add(scrollPane_2, "defintions");
    
    CardLayout cardLayout = (CardLayout) panel.getLayout();
    cardLayout.show(panel, "defintions");
    
    JTextPane textPane = new JTextPane();
    textPane.setEditable(false);
    scrollPane_2.setViewportView(textPane);

    StyledDocument doc = textPane.getStyledDocument();
    DefaultCaret caret = (DefaultCaret) textPane.getCaret();
    caret.setUpdatePolicy(DefaultCaret.NEVER_UPDATE);
    textPane.setBorder(BorderFactory.createCompoundBorder(
        textPane.getBorder(),
            BorderFactory.createEmptyBorder(10, 10 ,10 , 10)));
    
    Style bigWord = textPane.addStyle("Style", null);
    Style header = textPane.addStyle("Style", null);
    StyleConstants.setFontSize(header, 20);
//    StyleConstants.setBold(header, true);
    StyleConstants.setFontSize(bigWord, 36);
    StyleConstants.setBold(bigWord, true);

    doc.remove(0, doc.getLength());
    doc.insertString(doc.getLength(),"Example Word\n" ,bigWord );
    doc.insertString(doc.getLength(),"\n" , null );
    doc.insertString(doc.getLength(),"Definitions\n" ,header );
    doc.insertString(doc.getLength(),"\n" ,null );
    doc.insertString(doc.getLength(),"1. Example Word (pos) \n\n    Definition of example word\n\n" ,null );
    doc.insertString(doc.getLength(),"\n" ,null );
    doc.insertString(doc.getLength(),"Synonyms\n" ,header );
    doc.insertString(doc.getLength(),"\n1.Synonym " ,null );
    doc.insertString(doc.getLength(),"\n\n" ,null );
    doc.insertString(doc.getLength(),"Antonyms\n" ,header );
    doc.insertString(doc.getLength(),"\n1.Antonym " ,null );

    JScrollPane scrollPane_1 = new JScrollPane();
    scrollPane_1.setBounds(12, 114, 179, 446);
    frmDictionary.getContentPane().add(scrollPane_1);

    JList<String> list = new JList<String>();
    list.addListSelectionListener(new ListSelectionListener() {
      boolean ranOnce = false;
      public void valueChanged(ListSelectionEvent arg0) {
        if(ranOnce) {
          ranOnce = false;
        }else {
          ranOnce = true;

          String selectedWord = list.getSelectedValue();
          System.out.println(selectedWord);

          try {
            ArrayList<Words> Words = getWordClass();
            for(Words word: Words) {
              if(word.getWord().equals(selectedWord)) {
                doc.remove(0, doc.getLength());
                doc.insertString(doc.getLength(),selectedWord.substring(0, 1).toUpperCase() + selectedWord.substring(1) + "\n" ,bigWord );
                doc.insertString(doc.getLength(),"\n" ,null );
                doc.insertString(doc.getLength(),"Definitions\n" ,header );
                doc.insertString(doc.getLength(),"\n" ,null );
                Definitions[] definitions = word.getDefinitions();
                int definitionCounter = 1;
                for (Definitions definition : definitions) {
                  doc.insertString(doc.getLength(), definitionCounter + "." + selectedWord +" (" + definition.getPartOfSpeech() +")\n\n    "  +  definition.getDefinition() + "\n\n", null);
                  definitionCounter++;
                }
                String[] synonyms = word.getSynonyms();
                if(synonyms.length != 0) {
                  doc.insertString(doc.getLength(),"Synonyms\n" ,header );
                  doc.insertString(doc.getLength(),"\n" ,null );
                  int synonymCounter = 1;
                  for(String synonym : synonyms) {

                    doc.insertString(doc.getLength(), synonymCounter + "." + synonym + "\n", null);
                    synonymCounter++;
                  }
                }
                String[] antonyms = word.getAntonyms();
                if (antonyms.length != 0) {
                  doc.insertString(doc.getLength(),"\n" ,null );
                  doc.insertString(doc.getLength(),"Antonyms\n" ,header );
                  doc.insertString(doc.getLength(),"\n" ,null );
                  int antonymCounter = 1;
                  for(String antonym : antonyms) {
                    doc.insertString(doc.getLength(), antonymCounter + "." + antonym + "\n", null);
                    antonymCounter++;
                  }
                }

              }
            }
          } catch (FileNotFoundException | BadLocationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
          }
        }
      }
    });
    scrollPane_1.setViewportView(list);

    DefaultListModel<String> DLM =  getWords();

    list.setModel(DLM);
    
    JRadioButton rdbtnNewRadioButton = new JRadioButton("Asc");
    JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Desc");

    JButton btnNewButton = new JButton("Add");
    btnNewButton.addActionListener(new ActionListener() {
//      add
      public void actionPerformed(ActionEvent e) {
    	  System.out.println("add");
          cardLayout.show(panel, "addWord"); 
      }
    });
    btnNewButton.setBounds(2, 11, 89, 23);
    frmDictionary.getContentPane().add(btnNewButton);

    btnNewButton_2.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    	  String word = textField.getText().toLowerCase();
      	  String definitionInput = txtDefinitions.getText().toLowerCase();
      	  String posInput = textField_2.getText().toLowerCase();
      	  String synonymInput = textField_1.getText().toLowerCase();
      	  String antonymsInput = textField_3.getText().toLowerCase();
      	  
      	  ArrayList<Words> wordList = new ArrayList<Words>();
      	  try {
  			wordList = getWordClass();
      	  } catch (FileNotFoundException e1) {
  			// TODO Auto-generated catch block
  			e1.printStackTrace();
      	  }
      	  String[] definitions = definitionInput.split("\\s*,\\s*");
      	  String[] poss = posInput.split("\\s*,\\s*");
      	  String[] synonyms = synonymInput.split("\\s*,\\s*");
      	  String[] antonyms = antonymsInput.split("\\s*,\\s*");
      	  
      	  if(definitions.length == poss.length) {
      		  System.out.println("pass");
      		  Definitions[] deffs = new Definitions[definitions.length];
          	  for (int i = 0; i < definitions.length; i++) {
          		  deffs[i] = new Definitions(definitions[i],poss[i]);
          	  }
          	  Words wordToAdd = new Words(word, deffs, synonyms,antonyms);
          	  wordList.add(wordToAdd);
          	Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String classpathDirectory = Utils.getClasspathDir();
             try (FileWriter writer = new FileWriter(classpathDirectory +"words.json")) {
                      gson.toJson(wordList, writer);
                      System.out.println("word added");
                  } catch (IOException e1) {
                      e1.printStackTrace( );
                  }
             DefaultListModel<String> DLM = null;
             if (!rdbtnNewRadioButton.isSelected()) {
			     try {
			     	DLM = Utils.reverseOrder(getWords());
			   } catch (FileNotFoundException e2) {
			     // TODO Auto-generated catch block
			     e2.printStackTrace();
			   }

			 } else {
			   try {
			 	  DLM = getWords();
			   } catch (FileNotFoundException e1) {
			     // TODO Auto-generated catch block
			     e1.printStackTrace();
			   }
			 }
             list.setModel(DLM);
      	  }else {
      		  System.out.println("fail");
      		  JOptionPane.showMessageDialog(null, "Amount of definitions and parts of speech do not match!");
      	  }
    		cardLayout.show(panel, "defintions");
    	}
    });
    
    JButton btnNewButton_1 = new JButton("Remove");
    btnNewButton_1.addActionListener(new ActionListener() {
//      remove
      public void actionPerformed(ActionEvent arg0) {
    List<String> selectedWords = list.getSelectedValuesList();
        System.out.println("remove");
        try {
          Boolean wordFound = false;
      ArrayList<Words> words = getWordClass();
      ArrayList<Words> wordsToRemove = new ArrayList<Words>();
      for(String selectedWord : selectedWords) {
        for (Words word : words) {
                if(selectedWord.equals(word.getWord())) {
                  wordsToRemove.add(word);
                  wordFound = true;
                }
            }
          }
      if(wordFound) {
    	  int dialogResult = JOptionPane.showConfirmDialog (null, "Are you sure you want to delete the following word(s)\nfrom the ditionary?\n\nThis action cannot be undone.\n\n","Warning",JOptionPane.YES_NO_OPTION);
    	  if(dialogResult == JOptionPane.YES_OPTION){
    		  for (Words word: wordsToRemove) {
    	          words.remove(word);
    	        }
    	  }
        
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String classpathDirectory = Utils.getClasspathDir();
         try (FileWriter writer = new FileWriter(classpathDirectory +"words.json")) {
                  gson.toJson(words, writer);
                  System.out.println("word removed");
              } catch (IOException e) {
                  e.printStackTrace( );
              }


      }
    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
        DefaultListModel<String> DLM = null;
    try {  
        if (!rdbtnNewRadioButton.isSelected()) {
            try {
            	DLM = Utils.reverseOrder(getWords());
          } catch (FileNotFoundException e2) {
            // TODO Auto-generated catch block
            e2.printStackTrace();
          }

        } else {
          try {
        	  DLM = getWords();
          } catch (FileNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
          }
        }
      list.setModel(DLM);
      doc.remove(0, doc.getLength());
      doc.insertString(doc.getLength(),"Example Word\n" ,bigWord );
        doc.insertString(doc.getLength(),"\n" , null );
        doc.insertString(doc.getLength(),"Definitions\n" ,header );
        doc.insertString(doc.getLength(),"\n" ,null );
        doc.insertString(doc.getLength(),"1. Example Word (pos) \n\n    Definition of example word\n\n" ,null );
        doc.insertString(doc.getLength(),"\n" ,null );
        doc.insertString(doc.getLength(),"Synonyms\n" ,header );
        doc.insertString(doc.getLength(),"\n1.Synonym " ,null );
        doc.insertString(doc.getLength(),"\n\n" ,null );
        doc.insertString(doc.getLength(),"Antonyms\n" ,header );
        doc.insertString(doc.getLength(),"\n1.Antonym " ,null );
    } catch (BadLocationException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }



      }
    });

    btnNewButton_1.setBounds(101, 11, 89, 23);
    frmDictionary.getContentPane().add(btnNewButton_1);

    JScrollPane scrollPane = new JScrollPane();
    scrollPane.setBounds(490, 332, -57, -98);
    frmDictionary.getContentPane().add(scrollPane);
   
    buttonGroup.add(rdbtnNewRadioButton);
    rdbtnNewRadioButton.setBounds(36, 78, 59, 23);
    frmDictionary.getContentPane().add(rdbtnNewRadioButton);
    rdbtnNewRadioButton.setSelected(true);

    
    buttonGroup.add(rdbtnNewRadioButton_1);
    rdbtnNewRadioButton_1.setBounds(110, 78, 59, 23);
    frmDictionary.getContentPane().add(rdbtnNewRadioButton_1);
    rdbtnNewRadioButton_1.addItemListener(new ItemListener() {
//       select asc or desc order
        @Override
        public void itemStateChanged(ItemEvent event) {

            int state = event.getStateChange();
            if (state == ItemEvent.SELECTED) {
                System.out.println("desc");
                try {
                  txtSearch.setText("");
            list.setModel(Utils.reverseOrder(getWords()));
            doc.remove(0, doc.getLength());
            doc.insertString(doc.getLength(),"Example Word\n" ,bigWord );
              doc.insertString(doc.getLength(),"\n" , null );
              doc.insertString(doc.getLength(),"Definitions\n" ,header );
              doc.insertString(doc.getLength(),"\n" ,null );
              doc.insertString(doc.getLength(),"1. Example Word (pos) \n\n    Definition of example word\n\n" ,null );
              doc.insertString(doc.getLength(),"\n" ,null );
              doc.insertString(doc.getLength(),"Synonyms\n" ,header );
              doc.insertString(doc.getLength(),"\n1.Synonym " ,null );
              doc.insertString(doc.getLength(),"\n\n" ,null );
              doc.insertString(doc.getLength(),"Antonyms\n" ,header );
              doc.insertString(doc.getLength(),"\n1.Antonym " ,null );
          } catch (FileNotFoundException | BadLocationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
          }

            } else if (state == ItemEvent.DESELECTED) {
              System.out.println("asc");
              try {
                txtSearch.setText("");
            list.setModel(getWords());
            doc.remove(0, doc.getLength());
            doc.insertString(doc.getLength(),"Example Word\n" ,bigWord );
              doc.insertString(doc.getLength(),"\n" , null );
              doc.insertString(doc.getLength(),"Definitions\n" ,header );
              doc.insertString(doc.getLength(),"\n" ,null );
              doc.insertString(doc.getLength(),"1. Example Word (pos) \n\n    Definition of example word\n\n" ,null );
              doc.insertString(doc.getLength(),"\n" ,null );
              doc.insertString(doc.getLength(),"Synonyms\n" ,header );
              doc.insertString(doc.getLength(),"\n1.Synonym " ,null );
              doc.insertString(doc.getLength(),"\n\n" ,null );
              doc.insertString(doc.getLength(),"Antonyms\n" ,header );
              doc.insertString(doc.getLength(),"\n1.Antonym " ,null );
          } catch (FileNotFoundException | BadLocationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
          }
            }
        }

    });

    txtSearch = new JTextField();
    txtSearch.addKeyListener(new KeyAdapter() {
      @Override
//      search box
      public void keyReleased(KeyEvent e) {
        String searched = txtSearch.getText().toLowerCase();
        System.out.println(searched);
        DefaultListModel<String> words = new DefaultListModel<String>();
        if (!rdbtnNewRadioButton.isSelected()) {
            try {
              words = Utils.reverseOrder(getWords());
          } catch (FileNotFoundException e2) {
            // TODO Auto-generated catch block
            e2.printStackTrace();
          }

        } else {
          try {
            words = getWords();
          } catch (FileNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
          }
        }
        DefaultListModel<String> filtered = new DefaultListModel<String>();
        for(int i = 0 ; i < words.size(); i++) {
          if((words.get(i).startsWith(searched))) {
            System.out.println(words.get(i));
            filtered.addElement(words.get(i));
          }
        }
        list.setModel(filtered);
        try {
			doc.remove(0, doc.getLength());
			doc.insertString(doc.getLength(),"Example Word\n" ,bigWord );
	        doc.insertString(doc.getLength(),"\n" , null );
	        doc.insertString(doc.getLength(),"Definitions\n" ,header );
	        doc.insertString(doc.getLength(),"\n" ,null );
	        doc.insertString(doc.getLength(),"1. Example Word (pos) \n\n    Definition of example word\n\n" ,null );
	        doc.insertString(doc.getLength(),"\n" ,null );
	        doc.insertString(doc.getLength(),"Synonyms\n" ,header );
	        doc.insertString(doc.getLength(),"\n1.Synonym " ,null );
	        doc.insertString(doc.getLength(),"\n\n" ,null );
	        doc.insertString(doc.getLength(),"Antonyms\n" ,header );
	        doc.insertString(doc.getLength(),"\n1.Antonym " ,null );
		} catch (BadLocationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
      

      }
    });
    txtSearch.setToolTipText("Search");
    txtSearch.setBounds(12, 45, 179, 20);
    frmDictionary.getContentPane().add(txtSearch);
    txtSearch.setColumns(10);
  }
}
