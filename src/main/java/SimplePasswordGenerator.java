import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public final class SimplePasswordGenerator
{

	// SETTINGS
	private static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789_-";
	private static final int PASSWORD_LENGTH = 64;


	// INIT
	private SimplePasswordGenerator()
	{

	}


	// RUN
	public static void main(String[] args) throws IOException, InterruptedException
	{
		String password = generatePassword();

		File tempFile = File.createTempFile("password", ".txt");
		try(PrintWriter out = new PrintWriter(tempFile))
		{
			out.println(password);
		}
		Desktop.getDesktop().edit(tempFile);

		Thread.sleep(3*1000);
		tempFile.delete();
	}

	private static String generatePassword()
	{
		Random random = new Random();

		String password = "";
		for(int i = 0; i < PASSWORD_LENGTH; i++)
		{
			int characterIndex = random.nextInt(CHARACTERS.length());
			char character = CHARACTERS.charAt(characterIndex);
			password += character;
		}

		return password;
	}

}
