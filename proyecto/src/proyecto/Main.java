package proyecto;

import java.awt.EventQueue;
import proyecto.datatypes.DataGenerator;
import proyecto.views.MainView;

public class Main {
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainView frame = new MainView(
							new DataGenerator().getRawAirports().createAirports().getRawRoutes().createRoutes());
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}