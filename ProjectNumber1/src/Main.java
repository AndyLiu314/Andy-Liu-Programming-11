public class Main {
    //solution to problem 1
    static int problemOne(String s){
        //counter refers to the number of vowels in the string
        int counter = 0;
        //this is a for loop that is the length of string s
        for (int i = 0; i < s.length(); i++) {
            //lettr is the letter at a given index position in the string
            char lettr = s.charAt(i);
            //this makes it so that if lettr is either a,e,i,o, or u it will add 1 to the counter
            if (lettr == 'a'||lettr =='e'||lettr =='i'||lettr =='o'||lettr =='u'){
                counter++;
            }
        }
        //the number of vowels will then be returned
        return counter;
    }
    //Second answer to the problem
    static int problemTwo(String s) {
        //counter refers to the number of bobs within a string
        int counter = 0;
        //len refers to the length of the given string
        int len = s.length();
        //this is a for loop that runs for the length of the string
        for (int i = 0; i < len; i++) {
            //if the current character is b, and the two next characters are 'o' and 'b', then the counter will increase by one.
            if (i + 2 < len) {
                //ch is the current character
                char ch = s.charAt(i);
                //ch2 is the next character
                char ch2 = s.charAt(i + 1);
                //ch3 is the character after that
                char ch3 = s.charAt(i + 2);
                //if 'b', 'o', and 'b' line up consecutively then the counter increases by 1
                if (ch == 'b' && ch2 == 'o' && ch3 == 'b') {
                    counter++;
                }
            }
        }
        //this returns the number of bobs
        return counter;
    }

    static String problemThree(String s){
        //al is the alphabet which is used to determine whether a character is in alphabetical order by using index positions
        String al="abcdefghijklmnopqrstuvwxyz";
        //longStr is the longest substring that is in alphabetical order with the string s
        String longStr= "";
        //newstr is the newest substring can be longer than the previously found longStr
        //this is meant to prevent the method from only finding the first substring in alphabetical order and not the longest
        String newStr=Character.toString(s.charAt(0));
        //index and 1 and 2 are the first two letters of the string
        int index1=0;
        int index2=0;
        //a for loop that starts from the second letter
        for(int i=1;i<s.length();i++){
            //the current character in the position i
            char current = s.charAt(i);
            //index position in the alphabet of the previous character
            index1=al.indexOf(s.charAt(i-1));
            //alphabetical index of the current character
            index2=al.indexOf(current);

            //if the index position in the alphabet of the current character is greater than equal to the alphabet index of the previous character it will execute the code
            //this makes sure that the letters are in alphabetical order
            if(index2>=index1){
                //current characters are added onto newStr if they are in alphabetical order
                newStr +=Character.toString(current);

             //this happens when they aren't in alphabetical order
            }else{
                //if a character isn't in alphabetical order the newStr becomes longStr and gets saved
                if(newStr.length() > longStr.length()){
                    longStr=newStr;
                }
                //this will continue to look for characters to add onto the newStr if they are in alphabetical order
                newStr=Character.toString(current);
            }
        }
        //this is meant to prevent the method from overlooking a longer alphabetical substring at the very end of string s
        if(newStr.length() > longStr.length()){
            longStr=newStr;
        }
        //the longest alphabetical substring is returned
        return longStr;
    }


    public static void main(String[] args) {
        //this sets string s for testing of the method
        String s = "adsxgbobgpabobabcdefg";
        //this prints the number of vowels within a string
        System.out.println("Number of Vowels: " + problemOne(s));
        //this prints the number of bobs within a string
        System.out.println("Number of Bobs: " + problemTwo(s));
        //this prints the longest alphabetical substring within a string
        System.out.println("Longest Alphabetical Substring: " + problemThree(s));
    }
}
