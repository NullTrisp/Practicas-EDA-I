package edai.tema4.ejercicio1;

import edai.tema4.Queue;

public class Airport {

	private Queue<Plane> firstLandingStrip;
	private Queue<Plane> secondLandingStrip;

	public Airport() {
		this.firstLandingStrip = new Queue<Plane>();
		this.secondLandingStrip = new Queue<Plane>();
	}

	/**
	 * 
	 * @param plane
	 */
	public void addPlane(Plane plane) {
		if (this.getFirstLandingStripTakeoutSeconds() == 0 && this.getSecondLandingStripTakeoutSeconds() == 0) {
			this.firstLandingStrip.push(plane);
		} else if (this.getFirstLandingStripTakeoutSeconds() < this.getSecondLandingStripTakeoutSeconds()) {
			this.firstLandingStrip.push(plane);
		} else {
			this.secondLandingStrip.push(plane);
		}

	}

	public Plane[] getFirstLandingStripPlanes() {
		int landingStripSize = this.firstLandingStrip.size(), i;
		Plane[] Planes = new Plane[landingStripSize];
		for (i = 0; i < landingStripSize; i++) {
			Planes[i] = this.firstLandingStrip.pop();
		}
		return Planes;
	}

	public int getFirstLandingStripTakeoutSeconds() {
		int landingStripSize = this.firstLandingStrip.size(), i, seconds = 0;
		Plane aux;
		for (i = 0; i < landingStripSize; i++) {
			aux = this.firstLandingStrip.pop();
			this.firstLandingStrip.push(aux);
			seconds += aux.getTakeoutSeconds();
		}
		return seconds;
	}

	public Plane[] getSecondLandingStripPlanes() {
		int landingStripSize = this.secondLandingStrip.size(), i;
		Plane[] Planes = new Plane[landingStripSize];
		for (i = 0; i < landingStripSize; i++) {
			Planes[i] = this.secondLandingStrip.pop();
		}
		return Planes;
	}

	public int getSecondLandingStripTakeoutSeconds() {
		int landingStripSize = this.secondLandingStrip.size(), i, seconds = 0;
		Plane aux;
		for (i = 0; i < landingStripSize; i++) {
			aux = this.secondLandingStrip.pop();
			this.secondLandingStrip.push(aux);
			seconds += aux.getTakeoutSeconds();
		}
		return seconds;
	}

}
