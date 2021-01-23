package proyecto.views;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.graphstream.ui.view.Viewer;

import proyecto.datatypes.DataGenerator;

import java.awt.GridLayout;
import java.util.stream.IntStream;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Path extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -722262268188433702L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public Path(String[] airports, DataGenerator dataGeneartor, Viewer view) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));

		@SuppressWarnings({ "unchecked", "rawtypes" })
		JList list = new JList(this.invertArr(airports));
		contentPane.add(list);

		JButton goBackBtn = new JButton("Search again");
		goBackBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new MainView(dataGeneartor).setVisible(true);
				closeFrame(view);
			}
		});
		contentPane.add(goBackBtn);
	}

	private void closeFrame(Viewer v) {
		this.setVisible(false);
		v.close();
	}

	private Object[] invertArr(String[] array) {
		return IntStream.rangeClosed(1, array.length).mapToObj(i -> array[array.length - i]).toArray();
	}

}
