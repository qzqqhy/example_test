package imitate.string;

public class ImitateString implements java.io.Serializable {

	private static final long serialVersionUID = 3814692516912382349L;

	private char[] value;

	public ImitateString() {
	}

	public ImitateString(char[] value) {
		this.value = new char[value.length];
		System.arraycopy(value, 0, this.value, 0, value.length);
	}

	public ImitateString(char[] value, int offset, int count, SoftTypeEnum softType) {
		if (SoftTypeEnum.ASC.getCode() == softType.getCode()) {
			asc(value, offset, count);
		} else {
			desc(value, offset, count);
		}
	}

	public ImitateString(int[] codePoints, int offset, int count) {
		if (codePoints == null) {
			return;
		}
		if (codePoints.length == 0) {
			return;
		}
		if (count <= offset) {
			return;
		}

		this.value = new char[count - offset];

		for (int i = offset; i < count - offset; i++) {
			this.value[i] = (char) codePoints[i];
		}
	}

	private void asc(char[] value, int offset, int count) {
		this.value = new char[count];
		for (int i = offset; i < count; i++) {
			this.value[i] = value[i];
		}
	}

	private void desc(char[] value, int offset, int count) {
		this.value = new char[count - offset];
		for (int i = 0; i < count - offset; i++) {
			this.value[i] = value[count - offset - (i + 1)];
		}
	}

	public String toString() {
		return new String(value).trim();
	}

}