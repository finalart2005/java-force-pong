package controller;

import view.Window;

public class Core {
	public Window	window;

	public Core() {
		window = new Window();
	}

	public static void main(String[] args) {
		new Core();
	}
}
