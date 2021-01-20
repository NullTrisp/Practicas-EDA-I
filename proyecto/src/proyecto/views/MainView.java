package proyecto.views;

import proyecto.datatypes.DataGenerator;
import java.util.ArrayList;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;

public class MainView extends JFrame implements ActionListener {
	private static final long serialVersionUID = -3467006337195513157L;
	private JPanel contentPane;
	private DataGenerator dataGenerator;
	private ArrayList<String> airportsNames = new ArrayList<String>();
	private JList<String> listSource;
	private JList<String> listDestination;
	private JTextField filterSource;
	private JTextField filterDestination;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public MainView(DataGenerator dataGenerator) {
		this.dataGenerator = dataGenerator;
		for (int i = 0; i < this.dataGenerator.getAirports().size(); i++) {
			this.airportsNames.add(dataGenerator.getAirports().get(i).getName() + ", "
					+ dataGenerator.getAirports().get(i).getCountry());
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1081, 723);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenuItem mntmNewMenuItem = new JMenuItem("See whole data set");
		mntmNewMenuItem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				new GraphGenerator(dataGenerator).setNodes().setRoutes().setUp();
			}
		});
		menuBar.add(mntmNewMenuItem);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaptionBorder);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		contentPane.setLayout(new GridLayout(0, 1, 0, 0));

		filterSource = new JTextField();
		filterSource.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				ArrayList<String> filteredNames = new ArrayList<String>();
				airportsNames.stream().forEach((airportName) -> {
					String airpName = airportName.toString().toLowerCase();
					if (airpName.contains(filterSource.getText().toLowerCase())) {
						filteredNames.add(airportName);
					}
				});
				listSource.setListData(filteredNames.toArray(new String[filteredNames.size()]));
			}
		});
		contentPane.add(filterSource);
		filterSource.setColumns(10);

		this.listSource = new JList(this.airportsNames.toArray());
		JScrollPane scrollPaneFrom = new JScrollPane();
		scrollPaneFrom.setViewportView(listSource);
		contentPane.add(scrollPaneFrom);

		JLabel lblAirportFrom = new JLabel("Airport From");
		scrollPaneFrom.setColumnHeaderView(lblAirportFrom);

		filterDestination = new JTextField();
		filterDestination.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				ArrayList<String> filteredNames = new ArrayList<String>();
				airportsNames.stream().forEach((airportName) -> {
					String airpName = airportName.toString().toLowerCase();
					if (airpName.contains(filterDestination.getText().toLowerCase())) {
						filteredNames.add(airportName);
					}
				});
				listDestination.setListData(filteredNames.toArray(new String[filteredNames.size()]));
			}
		});
		contentPane.add(filterDestination);
		filterDestination.setColumns(10);

		this.listDestination = new JList(this.airportsNames.toArray());
		JScrollPane scrollPaneTo = new JScrollPane();
		scrollPaneTo.setViewportView(listDestination);
		contentPane.add(scrollPaneTo);

		JLabel lblAirportTo = new JLabel("Airport To");
		scrollPaneTo.setColumnHeaderView(lblAirportTo);

		JButton subBtn = new JButton("Submit");
		subBtn.setAlignmentX(Component.RIGHT_ALIGNMENT);
		subBtn.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		subBtn.setBackground(UIManager.getColor("Button.light"));
		subBtn.setFont(new Font("Arial", Font.BOLD, 15));
		subBtn.addActionListener(this);
		contentPane.add(subBtn);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String[] source = null, destination = null;
		try {
			source = this.listSource.getSelectedValue().split(", ");
			destination = this.listDestination.getSelectedValue().split(", ");
		} catch (Exception err) {
		}
		if (this.listSource.getSelectedIndex() == -1 || this.listDestination.getSelectedIndex() == -1) {
			JOptionPane.showMessageDialog(this, "You must select a destination and source airport", "Seriously?",
					JOptionPane.ERROR_MESSAGE);
		} else if (source[0].equals(destination[0])) {
			JOptionPane.showMessageDialog(this, "Source airport cannot be same as destination airport",
					"Why are you doing this?", JOptionPane.ERROR_MESSAGE);
		} else {
			this.setVisible(false);
			new GraphGenerator(this.dataGenerator, this.dataGenerator.getByNameAndCountry(source[0], source[1]),
					this.dataGenerator.getByNameAndCountry(destination[0], destination[1])).setNodes().setRoutes()
							.setDijkstra(this);
		}
	}
}
