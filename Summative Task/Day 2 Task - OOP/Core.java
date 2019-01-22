import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Text;

/*
 * Modified Version of the original B.3 Math Project to 
 * fit the needs of the Day 2 Task - OOP
 */
public class Core {

	/*
	 * Gotta find a better way of doing this.
	 */
	private static final ArrayList<Integer> selectedFunction = new ArrayList<>();

	static {
		selectedFunction.add(0);
	}

	public Core() {

		System.out.println("Starting Program"); // log the start time
		long start = System.currentTimeMillis();

		Display display = new Display();
		final Shell shell = new Shell(display);
		shell.setLayout(new GridLayout(2, false));
		GridData gridData = new GridData();
		gridData.horizontalAlignment = SWT.FILL;
		gridData.grabExcessHorizontalSpace = true;

		/*
		 * Spinners
		 */

		final Label numberOne = new Label(shell, SWT.NONE);
		numberOne.setText("Value #1: ");

		final Spinner spinnerOne = new Spinner(shell, SWT.BORDER);
		spinnerOne.setMinimum(1);
		spinnerOne.setSelection(1);
		spinnerOne.setMaximum(1000);
		spinnerOne.setLayoutData(gridData);

		final Label numberTwo = new Label(shell, SWT.NONE);
		numberTwo.setText("Value #2: ");
		numberTwo.setVisible(false);

		final Spinner spinnerTwo = new Spinner(shell, SWT.BORDER);
		spinnerTwo.setMinimum(1);
		spinnerTwo.setSelection(1);
		spinnerTwo.setMaximum(1000);
		spinnerTwo.setLayoutData(gridData);
		spinnerTwo.setVisible(false);

		/*
		 * Math Functions
		 */

		final List functions = new List(shell, SWT.BORDER);
		functions.add("Square Root"); // 0
		functions.add("Exponents"); // 1
		functions.add("Factorial"); // 2
		functions.setSelection(0);

		gridData = new GridData();
		gridData.heightHint = 156;
		gridData.horizontalAlignment = SWT.FILL;
		gridData.grabExcessHorizontalSpace = true;

		// btn
		Button calculate = new Button(shell, SWT.PUSH);
		calculate.setText("Calculate");
		calculate.setGrayed(true);
		calculate.setLayoutData(gridData);

		// Results
		Label resultLabelOne = new Label(shell, SWT.NONE);
		resultLabelOne.setText("Result 1:");

		final Text resultTextOne = new Text(shell, SWT.BORDER);
		resultTextOne.setLayoutData(gridData);
		resultTextOne.setText("Awaiting Result");



		/*
		 * Listeners
		 */

		// Selection Listener for function
		functions.addListener(SWT.Selection, new Listener() {
			@Override
			public void handleEvent(Event event) {

				int[] selection = functions.getSelectionIndices();
				for (int i = 0; i < selection.length; i++) {
					shell.setSize(300, 260);
					if (selection[i] == 1) {
						numberTwo.setVisible(true);
						spinnerTwo.setVisible(true);
						numberOne.setText("Number: ");
						numberTwo.setText("Exponent: ");
					} else {
						numberTwo.setVisible(false);
						spinnerTwo.setVisible(false);
						numberOne.setText("Value #1: ");
						numberTwo.setText("Value #2: ");
					}
					selectedFunction.clear();
					selectedFunction.add(selection[i]);
					System.out.println("Selected Function #: " + selectedFunction.get(0));
				}

			}
		});

		calculate.addListener(SWT.MouseDown, new Listener() {
			@Override
			public void handleEvent(Event event) {
				switch (event.type) {
				case SWT.MouseDown:
					switch (selectedFunction.get(0)) {
					case 0:
						shell.setSize(300, 430);
						resultTextOne.setText(MathFunctions.getInstance().squareRoot(spinnerOne.getSelection()));
						break;
					case 1:
						shell.setSize(300, 430);
						resultTextOne.setText(MathFunctions.getInstance().getExponent(spinnerOne.getSelection(), spinnerTwo.getSelection()));
						break;
					case 2:
						shell.setSize(300, 430);
						resultTextOne.setText(MathFunctions.getInstance().getFactorial(spinnerOne.getSelection()));
						break;
					}
				default:
					break;
				}
			}
		});

		/*
		 * Pre-Launch
		 */
		shell.pack();
		shell.setSize(300, 260);
		shell.setVisible(true);

		shell.open();
		System.out.println("Program Opened");
		System.out.println("Took: " + (System.currentTimeMillis() - start) + "ms to load.");
		System.out.println("=========================================");

		/*
		 * Run
		 */
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}

		shell.dispose();

	}

	public static void main(String[] args) {
		long programStart = System.currentTimeMillis();
		new Core();
		System.out.println("Program Closed, ran for a total of: " + TimeUnit.MILLISECONDS.toSeconds((System.currentTimeMillis() - programStart)) + " seconds.");
	}
}
