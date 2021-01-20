package proyecto.views;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.util.stream.IntStream;
import javax.swing.JList;

public class Path extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -722262268188433702L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public Path(String[] airports) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));

		@SuppressWarnings({ "unchecked", "rawtypes" })
		JList list = new JList(this.invertArr(airports));
		contentPane.add(list);
	}

	private Object[] invertArr(String[] array) {
		return IntStream.rangeClosed(1, array.length).mapToObj(i -> array[array.length - i]).toArray();
	}

}
