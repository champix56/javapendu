/**
 * 
 */
package pendu;

import java.io.IOException;

/**
 * @author champix
 *
 */
public class pendu {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("coucou");
		String initialWord = "ornithologue";
		char[] found = fillEmptyResult(initialWord);
		int falseResultCount = 0;
		int countEssais = 0;
		int countFalseResultAdmitBeforeHang = 5;
		int countletterNotAlreadyFound = initialWord.length();
		do {
			countletterNotAlreadyFound = showFoundWord(found, initialWord.length());
			System.out.print("saisissez la lettre :");
			char c='_';
			int tmp='\0';
			try {
				c = (char) System.in.read();
				tmp = (char) System.in.read();
				tmp = (char) System.in.read();
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			int fcount = isCharFound(initialWord, found, c);

			if (fcount > 0) {
				System.out.println("bravo la lettre " + c + " est bien pr�sente");
			} else {
				System.out.println("Aucune position trouver pour la lettre " + c);
				falseResultCount++;
			}
			countEssais++;

			// int position = found.IndexOf('_');
			// System.Console.WriteLine("position" + position);
			System.out.println("found " + new String(found));
		} while (countletterNotAlreadyFound>0 && falseResultCount < countFalseResultAdmitBeforeHang);
		if (falseResultCount >= countFalseResultAdmitBeforeHang) {
			System.out.println("Perdu le mot etait : " + initialWord);
		} else {

			System.out.println("Bravo le mot etait bien " + initialWord + " trouver en " + countEssais + " tentatives");
		}
	}

	private static int showFoundWord(char[] wordFound,int size) {
		int countLettersNotFound = 0;
		//char[] word = wordFound.toCharArray();
		for (int i = 0; i < size; i++) {
			System.out.print(wordFound[i] + " ");
			if (wordFound[i] == '_')
				countLettersNotFound++;
		}
		return countLettersNotFound;
	}

	private static char[] fillEmptyResult(String initialWord) {
		char[] found = initialWord.toCharArray();
		for (int i = 0; i < initialWord.length(); i++) {
			found[i] = '_';
		}
		return found;
	}

	private static int isCharFound(String initial, char[] foundWord, char letter) {
		int countFound = 0;
		//char[] tabFound = foundWord.toCharArray();
		char[] tabInitial = initial.toCharArray();
		for (int i = 0; i < initial.length(); i++) {
			if (tabInitial[i] == letter) {
				foundWord[i] = letter;
				countFound++;
			}
		}
		//foundWord = new String(tabFound);
		//System.out.println(foundWord);
		return countFound;
	}

}
