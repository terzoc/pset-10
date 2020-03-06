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
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class Dictionay {

	private JFrame frmDictionary;
	private JTextField txtSearch;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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

	/**
	 * Create the application.
	 */
	public Dictionay() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmDictionary = new JFrame();
		frmDictionary.setResizable(false);
		frmDictionary.setTitle("Dictionary");
		frmDictionary.setBounds(100, 100, 800, 600);
		frmDictionary.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDictionary.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("add");
			}
		});
		btnNewButton.setBounds(2, 11, 89, 23);
		frmDictionary.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Remove");
		btnNewButton_1.addActionListener(new ActionListener() {
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
		
		DefaultListModel<String> DLM =  new DefaultListModel<String>();
		DLM.addElement("Apple");
		DLM.addElement("Bannana");
		DLM.addElement("Carrot");
		DLM.addElement("Apple");
		DLM.addElement("Bannana");
		DLM.addElement("Carrot");
		DLM.addElement("Apple");
		DLM.addElement("Bannana");
		DLM.addElement("Carrot");
		DLM.addElement("Apple");
		DLM.addElement("Bannana");
		DLM.addElement("Carrot");
		DLM.addElement("Apple");
		DLM.addElement("Bannana");
		DLM.addElement("Carrot");
		DLM.addElement("Apple");
		DLM.addElement("Bannana");
		DLM.addElement("Carrot");
		DLM.addElement("Apple");
		DLM.addElement("Bannana");
		DLM.addElement("Carrot");
		DLM.addElement("Apple");
		DLM.addElement("Bannana");
		DLM.addElement("Carrot");
		DLM.addElement("Carrot");
		DLM.addElement("Apple");
		DLM.addElement("Bannana");
		DLM.addElement("Carrot");
		DLM.addElement("Apple");
		DLM.addElement("Bannana");
		DLM.addElement("Carrot");
		DLM.addElement("Apple");
		DLM.addElement("Bannana");
		DLM.addElement("Carrot");
		DLM.addElement("Apple");
		DLM.addElement("Bannana");
		DLM.addElement("Carrot");
		list.setModel(DLM);
	}
}
