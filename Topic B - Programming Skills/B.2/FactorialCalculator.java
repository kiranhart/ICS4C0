package com.kiranhart.factorialcalculator;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class Core {

	public Core() {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setText("Factorial Calculator");
		shell.setLayout(new GridLayout(2, false));
		
		Label number = new Label(shell, SWT.NONE);
		number.setText("Number:");
		
		final Text numberText = new Text(shell, SWT.BORDER);
		GridData gridData = new GridData();
		gridData.horizontalAlignment = SWT.FILL;
		gridData.grabExcessHorizontalSpace = true;
		numberText.setLayoutData(gridData);
		numberText.setText("Enter an Integer!");
		
		Button goButton = new Button(shell, SWT.PUSH);
		goButton.setText("GO");
		gridData = new GridData();
		gridData.horizontalSpan = 2;
		gridData.verticalSpan = 3;
		gridData.horizontalAlignment = GridData.FILL;
		gridData.grabExcessHorizontalSpace = true;
		goButton.setLayoutData(gridData);
		
		Label resultLabel = new Label(shell, SWT.NONE);
		resultLabel.setText("Result:");
		
		final Text resultText = new Text(shell, SWT.MULTI);
		gridData.horizontalAlignment = SWT.FILL;
		gridData.grabExcessHorizontalSpace = true;
		resultText.setLayoutData(gridData);
		resultText.setText("");

		
		shell.pack();
		shell.setSize(300, 150);
		shell.open();

		goButton.addListener(SWT.MouseDown, new Listener() {

			@Override
			public void handleEvent(Event event) {
				switch (event.type) {
				case SWT.MouseDown:
					if (!isInteger(numberText.getText())) {
						resultText.setText("Please enter an integer!");
					} else {
						resultText.setText(NumberFormat.getInstance().format(getFactorialResult(Integer.parseInt(numberText.getText()))));
					}
					break;
				default:
					break;
				}
			}

		});
		
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}

		shell.dispose();
	}

	/**
	 * 
	 * @return Whether or not the specified input string is just integer numbers
	 */
	private boolean isInteger(String s) {
		try {
			Integer.parseInt(s);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}

	private long getFactorialResult(int number) {
		long val = 0;
		List<Integer> numbers = new ArrayList<>();
		for (int i = 1; i <= number; i++) {
			val++;
			numbers.add(i);
		}

		val = 1;
		Iterator<Integer> numberIterator = numbers.iterator();
		while (numberIterator.hasNext()) {
			val *= numberIterator.next();
		}

		return val;
	}

	public static void main(String[] args) {
		new Core();
	}

}
