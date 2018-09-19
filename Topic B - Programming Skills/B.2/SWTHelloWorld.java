package com.kiranhart.b2;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class SWTHelloWorld {

	private static boolean isInt(String s) {
		try {
			Integer.parseInt(s);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		Display display = new Display();
		final Shell shell = new Shell(display);
		shell.setText("Hello World");
		shell.setLayout(new FillLayout());

		final Text input = new Text(shell, SWT.TOP);
		input.setText("Random ass text");

		Button button = new Button(shell, SWT.PUSH);
		button.setText("GO");
		
		final Text result= new Text(shell, SWT.BOTTOM);
		result.setText("Current Value:");
		
		button.addListener(SWT.MouseDown, new Listener() {

			@Override
			public void handleEvent(Event event) {
				switch (event.type) {
				case SWT.MouseDown:
					if (!isInt(input.getText())) {
						System.out.println(input.getText());
						result.setText("Current Value: " + input.getText());
					} else {
						int number = Integer.parseInt(input.getText());
						System.out.println(number * 5);
						result.setText("Current Value: " + (number * 5));
					}
					break;
				default:
					break;
				}
			}

		});

		shell.pack();
		shell.setSize(600, 400);
		shell.open();

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}

		shell.dispose();
	}
}
