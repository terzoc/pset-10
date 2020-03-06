import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.ScrollPane;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListSelectionModel;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

public class Dictionay {

	private JFrame frmDictionary;
	private JTextField txtSearch;
	private final ButtonGroup buttonGroup = new ButtonGroup();

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

	private static DefaultListModel<String> getWords() throws FileNotFoundException{
		Gson gson = new Gson();
        String classpathDirectory = Utils.getClasspathDir();
        BufferedReader br = new BufferedReader(new FileReader(classpathDirectory + "words.json"));
        Words[] words = gson.fromJson(br, Words[].class);
        DefaultListModel<String> listOfWords = new DefaultListModel<String>();
        for (Words word : words) {
        	listOfWords.addElement(word.getWord());
        }
       ;
        return  Utils.sortWordsAsc(listOfWords);
	}

	/**
	 * Create the application.
	 * @throws FileNotFoundException 
	 */
	public Dictionay() throws FileNotFoundException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws FileNotFoundException 
	 */
	private void initialize() throws FileNotFoundException {
		frmDictionary = new JFrame();
		frmDictionary.setResizable(false);
		frmDictionary.setTitle("Dictionary");
		frmDictionary.setBounds(100, 100, 800, 600);
		frmDictionary.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDictionary.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
//			add
			public void actionPerformed(ActionEvent e) {
				System.out.println("add");
			}
		});
		btnNewButton.setBounds(2, 11, 89, 23);
		frmDictionary.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Remove");
		btnNewButton_1.addActionListener(new ActionListener() {
//			remove
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Remove");
			}
		});
		btnNewButton_1.setBounds(101, 11, 89, 23);
		frmDictionary.getContentPane().add(btnNewButton_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(490, 332, -57, -98);
		frmDictionary.getContentPane().add(scrollPane);
		
		txtSearch = new JTextField();
		txtSearch.addKeyListener(new KeyAdapter() {
			@Override
//			search box
			public void keyReleased(KeyEvent e) {
				System.out.println(txtSearch.getText());
			}
		});
		txtSearch.setToolTipText("");
		txtSearch.setBounds(12, 45, 179, 20);
		frmDictionary.getContentPane().add(txtSearch);
		txtSearch.setColumns(10);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Asc");
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setBounds(36, 78, 59, 23);
		frmDictionary.getContentPane().add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setSelected(true);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Desc");
		buttonGroup.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.setBounds(110, 78, 59, 23);
		frmDictionary.getContentPane().add(rdbtnNewRadioButton_1);
		
		rdbtnNewRadioButton_1.addItemListener(new ItemListener() {
//			 select asc or desc order
		    @Override
		    public void itemStateChanged(ItemEvent event) {
		        int state = event.getStateChange();
		        if (state == ItemEvent.SELECTED) {
		            System.out.println("desc");
		 
		        } else if (state == ItemEvent.DESELECTED) {
		 
		        	System.out.println("asc");
		 
		        }
		    }

		});
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(207, 11, 566, 549);
		frmDictionary.getContentPane().add(scrollPane_2);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(12, 114, 179, 446);
		frmDictionary.getContentPane().add(scrollPane_1);
		
		JList<String> list = new JList<String>();
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				System.out.println(list.getSelectedValue());
			}
		});
		scrollPane_1.setViewportView(list);
		
		DefaultListModel<String> DLM =  getWords();
		
		list.setModel(DLM);
	}
}
