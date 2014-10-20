import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.util.*;
import java.io.*;

public class OpenTextFile
{
	public static void main(String[] args) throws FileNotFoundException, IOException
	{
		int n, n2;
		ArrayList<String> a = new ArrayList<String>();

		// PROMPT WINDOW
		JOptionPane askWindow = new JOptionPane();
		String fileName = askWindow.showInputDialog("Enter external TextFile to open:");
		
		File f = new File(fileName);
		InputStream i = new FileInputStream(f);
		Reader r = new InputStreamReader(i);
		
		File f2 = new File(fileName);
		InputStream i2 = new FileInputStream(f2);
		Reader r2 = new InputStreamReader(i2);
		
		// ORIGINAL TEXT WINDOW	
		JTextArea originalTextOutput = new JTextArea(10,30);
		JScrollPane scroll = new JScrollPane(originalTextOutput);
		
		while((n = r.read()) != -1)
		{
			char ch = (char) n;
			originalTextOutput.append(String.valueOf(ch));
		}
		JOptionPane.showMessageDialog(null, scroll, "Original File was:\n", JOptionPane.INFORMATION_MESSAGE);
		
		// EDITTED TEXT WINDOW
		JTextArea newTextOutput = new JTextArea(10, 110);
		JScrollPane scroll2 = new JScrollPane(newTextOutput);
		
		while((n2 = r2.read()) != -1)
		{
			char ch2 = (char) n2;
			if(ch2 == ' ') 
				a.add("BL");
			else if(ch2 == '\n')
				a.add("EOL");
			else if(ch2 == '\r' || ch2 == '\t'){}
			else
				a.add(String.valueOf(ch2));
		}
		
		a.add("EOF");
		newTextOutput.append(a.get(0)); // add the first element
		
		for(int x = 1; x < a.size(); x++)
		{
			if(x % 20 == 0)
				newTextOutput.append("\n");	
			else newTextOutput.append("\t");
			newTextOutput.append(a.get(x));
		}
		JOptionPane.showMessageDialog(null, scroll2, "Output:\n", JOptionPane.INFORMATION_MESSAGE);
	}
}
