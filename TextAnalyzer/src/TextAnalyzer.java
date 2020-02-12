// TextAnalyzer.java
// Landon Holland - 1/27/20
// Use the Word class to input text and output the grade level using the Flesch readability test

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TextAnalyzer {
    // Private data
    private String s;

    // Default constructor
    TextAnalyzer() {
        s = "";
    }

    // Fill constructor with a String
    TextAnalyzer(String s) {
        this.s = s;
    }

    // Fill constructor via a file
    TextAnalyzer(File f) {
        try {
            s = new String(Files.readAllBytes(Paths.get(f.getPath())));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Sets and gets
    public List<Word> getWords() {
        List<Word> words = new ArrayList<Word>();
        String temp = s.replaceAll("[\\[\\]+.,:;'{}()\\\\/-]", "");
        temp = temp.replace("\n", "").replace("\r", "");

        for (int i = 0; i < s.split(" ").length; i++) {
            try {
                words.add(new Word(temp.split(" ")[i]));
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }

        return words;
    }

    // toString
    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        out.append(s).append("\nWords: ").append(numWords());
        out.append("\nSentences: ").append(numSentences());
        out.append("\nSyllables: ").append(numSyllables());
        out.append("\nFlesh Score: ").append(findFlesch());
        out.append("\nGrade: ").append(findGradeLevel());
        out.append("\n Linsear Write Score: ").append(findLinsear());
        out.append("\nAutomated Readability Index: ").append(findAri());
        out.append("\nColeman-Liau Index: ").append(findColemonLiau());

        return out.toString();
    }

    // Methods for the project
    public int numWords() {
        return getWords().size();
    }

    public int numSentences() {
        return s.split("[.?!;:]").length - 1;
    }

    public int numSyllables() {
        List<Word> words = getWords();
        int n = 0;

        for (int i = 0; i < words.size(); i++) {
            n += words.get(i).countSyllables();
        }
        return n;
    }

    public int numCharacters() {
        int c = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                c++;
            }
        }
        return c;
    }

    public double findFlesch() {
        return 206.835 - (((numWords() / (double) numSentences()) * 1.015)
                + ((numSyllables() / (double) numWords()) * 84.6));
    }

    public String findGradeLevel() {
        if (findFlesch() < 30) {
            return "College Graduate";
        }
        else if (findFlesch() >= 30 && findFlesch() < 50) {
            return "College Student";
        }
        else if (findFlesch() >= 50 && findFlesch() < 60) {
            return "10th to 12th Grade";
        }
        else if (findFlesch() >= 60 && findFlesch() < 70) {
            return "8th and 9th Grade";
        }
        else if (findFlesch() >= 70 && findFlesch() < 80) {
            return "7th Grade";
        }
        else if (findFlesch() >= 80 && findFlesch() < 90) {
            return "6th Grade";
        }
        else if (findFlesch() >= 90) {
            return "5th Grade";
        }
        return "what";
    }

    public double findLinsear() {
        int nume = 0;
        int numh = 0;
        List<Word> words = getWords();

        for (int i = 0; i < words.size(); i++) {
            if (words.get(i).countSyllables() <= 2) {
                nume++;
            }
            else {
                numh++;
            }
        }

        double score = (nume + (numh * 3)) / (double) (numSentences());

        if (score > 20) {
            return score / 2;
        }
        else {
            return (score - 2) / 2;
        }
    }

    public double findAri() {
        return (4.71 * (numCharacters() / (double) numWords())) + (0.5 * (numWords() / (double) numSentences())) - 21.43;
    }

    public double findColemonLiau() {
        List<Word> words = getWords();
        double numc = numCharacters() * (100 / (double) numWords());
        double nums = numSentences() * (100 / (double) numWords());

        return (0.0588 * numc) - (0.296 * nums) - 15.8;
    }
}

// TODO: 2/3/2020 Automated readability score