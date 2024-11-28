

public class KeywordsDetector {
    public static void main(String[] args) {
        String[] sentences = {
            "Our product will transform the market",
            "Programming is both painful and engaging",
            "This has nothing to do with machine learning",
            "We need to leverage our core competencies",
            "Let's talk about data and algorithms",
            "Chatbots are great but must be used carefully",
            "This blockchain-based solution will disrupt the industry",
            "The team showed great Synergy in the last project",
            "Use simple words without hype and fluff",
            "Our new technology presents a significant paradigm shift",
            "Effective presentations must be clear, concise, and humble"
        };
        // Some keywords that typically signal bullshit contents in business presentations 
        String[] keywords = {"synergy", "disrupt", "leverage", "Paradigm", "transform"};
        detectAndPrint(sentences, keywords);
    }

    // Iterates through all the sentences.
    // If a sentence contains one or more of the kewords, prints it.
    public static void detectAndPrint(String[] sentences, String[] keywords) {
        String [] duplicatedSentences = duplicateStringArray(sentences);
        String [] duplicatedKeywords = duplicateStringArray(keywords);

        for (int i = 0; i < sentences.length; i++) {
            duplicatedSentences[i] = lowerCase(duplicatedSentences[i]);   
        }
        for (int i = 0; i < keywords.length; i++) {
            duplicatedKeywords[i] = lowerCase(duplicatedKeywords[i]);   
        }

        for (int i = 0; i < sentences.length; i++) {
            for (int j = 0; j < keywords.length; j++) {
                if (contains(duplicatedSentences[i], duplicatedKeywords[j])) {
                    System.out.println(sentences[i]);
                }   
            }
               
        }

    }

    /** Returns the lowercase version of the given string. */
    public static String lowerCase(String str) {
       String otherStr = "";
       for (int i = 0; i < str.length(); i++) {
           if (str.charAt(i) < 91 && str.charAt(i) > 64) {
               otherStr += (char) (str.charAt(i) + 32);
           } else {
               otherStr += str.charAt(i);
           }
       }
       return otherStr;
    }

     /** If str1 contains str2, returns true; otherwise returns false. */
     public static boolean contains(String str1, String str2) {
        for (int i = 0; i <= str1.length() - str2.length(); i++) {
            if (str1.substring(i, i + str2.length()).equals(str2) ) {
                return true;
            }
        }
        return false;
    }

    /* duplicate String array */
    public static String [] duplicateStringArray(String[] arr) {
        String [] duplicatedString = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            duplicatedString[i] = arr[i];
        }

        return duplicatedString;
    }
}
