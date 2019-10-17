package rc.demo.app;

public class LogMessageDecorator {

	public static String decorateInfo(String message) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(String.format("<<< %s >>>%s", getString('='), "\n")).append("\n");
		buffer.append(message).append("\n\n");
		buffer.append(String.format("INFO: <<< %s >>>", getString('=')));
		return buffer.toString();
	}
	
	private static String getString(char character) {
		StringBuffer result = new StringBuffer();
		for(int i = 1; i <= 136; i++) {
			result.append(character);
		}
		return result.toString();
	}

}
