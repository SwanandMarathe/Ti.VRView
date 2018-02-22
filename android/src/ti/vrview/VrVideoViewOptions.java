package ti.vrview;

public class VrVideoViewOptions {
	private int inputFormat;

	/**
	 * @return the inputFormat
	 */
	public int getInputFormat() {
		return inputFormat;
	}

	/**
	 * @param inputFormat
	 *            the inputFormat to set
	 */
	public void setInputFormat(int inputFormat) {
		this.inputFormat = inputFormat;
	}

	/**
	 * @return the inputType
	 */
	public int getInputType() {
		return inputType;
	}

	/**
	 * @param inputType
	 *            the inputType to set
	 */
	public void setInputType(int inputType) {
		this.inputType = inputType;
	}

	private int inputType;

	public VrVideoViewOptions(int inputFormat, int inputType) {
		super();
		this.inputFormat = inputFormat;
		this.inputType = inputType;
	}
}
