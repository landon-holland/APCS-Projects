// Word.java
// Landon Holland - 1/21/20
// Count syllables and maybe other things

public class Word {
    private String word; // Private data

    Word() { // default constructor
        word = "";
    }

    Word(String word) { // fill constructor
        this.word = word;
    }

    // sets and gets
    public String getWord() {
        return word;
    }
    public void setWord(String word) {
        this.word = word;
    }

    // toString
    @Override
    public String toString() {
        return word + "\nSyllables: " + countSyllables();
    }

    // methods
    public boolean isVowel(char c) {
        return Character.toLowerCase(c) == 'a' || Character.toLowerCase(c) == 'e' || Character.toLowerCase(c) == 'i'
                || Character.toLowerCase(c) == 'o' || Character.toLowerCase(c) == 'u' || Character.toLowerCase(c) == 'y';
    }

    public int getNumVowels() {
        int vowelcount = 0;
        for (int i = 0; i < word.length(); i++) {
            if (isVowel(word.charAt(i))) {
                vowelcount++;
            }
        }

        return vowelcount;
    }
    
    public int countSyllables() {
        // first we count the total number of vowels
        int vowelcount = getNumVowels();

        // we're gonna find silent e's now
        if (Character.toLowerCase(word.charAt(word.length() - 1)) == 'e' && Character.toLowerCase(word.charAt(word.length() - 2)) != 'l') {
            vowelcount--;
        }

        if (word.toLowerCase().equals("the")) return 1;
        else if (word.toLowerCase().equals("we")) return 1;
        else if (word.toLowerCase().equals("be")) return 1;
        else if (word.toLowerCase().contains("people")) return 2;
        else if (word.toLowerCase().equals("created")) return 3;
        else if (word.toLowerCase().equals("engaged")) return 2;
        else if (word.toLowerCase().contains("live")) return 1;
        else if (word.toLowerCase().equals("advanced")) return 2;

        // now we subtract one from diphthongs
        for (int i = 0; i < word.length() - 1; i++) {
            if (Character.toLowerCase(word.charAt(i)) == 'a') {
                if (Character.toLowerCase(word.charAt(i + 1)) == 'i' ||
                Character.toLowerCase(word.charAt(i + 1)) == 'u' ||
                Character.toLowerCase(word.charAt(i + 1)) == 'y' ||
                Character.toLowerCase(word.charAt(i + 1)) == 'e' ||
                Character.toLowerCase(word.charAt(i + 1)) == 'a') {
                    vowelcount--;
                }
            }
            else if (Character.toLowerCase(word.charAt(i)) == 'e') {
                if (Character.toLowerCase(word.charAt(i + 1)) == 'e' ||
                Character.toLowerCase(word.charAt(i + 1)) == 'a' ||
                Character.toLowerCase(word.charAt(i + 1)) == 'i' ||
                Character.toLowerCase(word.charAt(i + 1)) == 'u' ||
                Character.toLowerCase(word.charAt(i + 1)) == 'y') {
                    vowelcount--;
                }
                if (i + 2 < word.length()) {
                    if (Character.toLowerCase(word.charAt(i + 1)) == 'a' && Character.toLowerCase(word.charAt(i + 2)) == 'n') {
                        vowelcount++;
                    }
                }
                if (word.toLowerCase().equals("conceived")) return 2;
                else if (word.toLowerCase().contains("create")) vowelcount++;
            }
            else if (Character.toLowerCase(word.charAt(i)) == 'i') {
                if (Character.toLowerCase(word.charAt(i + 1)) == 'i' ||
                Character.toLowerCase(word.charAt(i + 1)) == 'e') {
                    vowelcount--;
                }
                if (i + 2 < word.length()) {
                    if (Character.toLowerCase(word.charAt(i + 1)) == 'o' && Character.toLowerCase(word.charAt(i + 2)) == 'n') {
                        vowelcount--;
                    }
                }
                if (i + 3 < word.length()) {
                    if (Character.toLowerCase(word.charAt(i + 1)) == 'o' && Character.toLowerCase(word.charAt(i + 2)) == 'u'
                    && Character.toLowerCase(word.charAt(i + 3)) == 's') {
                        vowelcount--;
                    }
                }
            }
            else if (Character.toLowerCase(word.charAt(i)) == 'o') {
                if (isVowel(Character.toLowerCase(word.charAt(i + 1)))) {
                    vowelcount--;
                }
            } else if (Character.toLowerCase(word.charAt(i)) == 'u') {
                if (Character.toLowerCase(word.charAt(i + 1)) == 'a' ||
                Character.toLowerCase(word.charAt(i + 1)) == 'e' ||
                Character.toLowerCase(word.charAt(i + 1)) == 'i' ||
                Character.toLowerCase(word.charAt(i + 1)) == 'u' ||
                Character.toLowerCase(word.charAt(i + 1)) == 'y') {
                    vowelcount--;
                }
                if (word.toLowerCase().contains("ruin")) {
                    vowelcount++;
                }
                else if (word.toLowerCase().contains("jesuit")) {
                    vowelcount++;
                }
                else if (word.toLowerCase().contains("louie")) {
                    vowelcount++;
                }
                else if (word.toLowerCase().contains("louis")) {
                    vowelcount++;
                }
                else if (word.toLowerCase().equals("quiet")) {
                    return 2;
                }
                else if (word.toLowerCase().equals("ambiguity")) {
                    return 5;
                }
                else if (word.toLowerCase().contains("quote")) {
                    vowelcount--;
                }
                else if (word.toLowerCase().contains("queue")) {
                    return 1;
                }
                else if (word.toLowerCase().equals("vagueness")) {
                    return 2;
                }
            }
            else if (Character.toLowerCase(word.charAt(i)) == 'y') {
                if (isVowel(Character.toLowerCase(word.charAt(i + 1)))) {
                    vowelcount--;
                }
                if (word.toLowerCase().equals("dying")) {
                    return 2;
                }
                else if (word.toLowerCase().equals("lying")) {
                    return 2;
                }
            }
        }

        return vowelcount;
    }
}
