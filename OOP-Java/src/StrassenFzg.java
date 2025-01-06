package fahrzeug;

abstract class StrassenFzg {
	protected String bezeichung;
	protected short geschwindigkeit;
	protected boolean verliehen;

	abstract boolean eingeben();

	abstract boolean anzeigen();

	public boolean verliehen() {
		if (verliehen) {
			return false;
		} else {
			verliehen = true; /* boolean default ist false */
			return true;
		}
	}

}
