public class Palindrome {
    public Deque<Character> wordToDeque(String word){
        Deque<Character> result= new LinkedListDeque<>();
        if (word.length()==0){
            return result;
        }else{
            for (int i =0; i<word.length();i+=1){
                char c =word.charAt(i);
                result.addLast(c);
            }

        }
        result.printDeque();
        return result;
    }
    public boolean isPalindrome(String word){
        if (word.length()==0 || word.length()== 1){
            return true;
        }
        Deque<Character> d1=new LinkedListDeque<>();
        Deque<Character> d2=new LinkedListDeque<>();
        for (int i =0;i<word.length();i+=1){
            ((LinkedListDeque<Character>) d1).addFirst(word.charAt(i));
            ((LinkedListDeque<Character>) d2).addLast(word.charAt(i));
        }
        Deque<Character>dummy1=d1;
        Deque<Character>dummy2=d2;
        for (int i =0;i<d1.size();i+=1){
            if (dummy1.removeFirst()!=dummy2.removeFirst()){
                return false;
            }

        }
        return true;

    }
}
