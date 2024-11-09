import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class JavaPractice {

    public static void main(String[] args) {
      // String str = "aabbbcca";

       //a2b3c2a1

/*
        String[] str1= str.split("");

        Map<String, Long> map=Arrays.stream(str1).
                collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        map.entrySet().stream().map(i -> i.getKey() + i.getValue()).forEach(System.out::print);

        String str2= new String("abc");*/


        String str = "aabbbccab";
    //      System.out.println(compressString(str));



        //To Remove duplicate Charcters
        String str1 = "settings";

        String[] str2 = str1.split("");


        Map<String, Long> map = Arrays.stream(str1.split("")).collect(Collectors.
                groupingBy(Function.identity(), Collectors.counting()));

        map.entrySet().stream().filter(e-> e.getValue()==1).forEach(s -> System.out.println(s.getKey()));

      Map<String, Integer> freqMap = new HashMap<>();
        System.out.println("-----------------------------");


        for(String s : str2){

           freqMap.put(s, freqMap.getOrDefault(s, 0)+1);
        }

        Arrays.stream(str2).filter(e -> freqMap.get(e)==1).forEach(System.out::println);


    }

    public static String compressString(String str){

        if(str==null || str.length()==0){
          return "";
        }

        StringBuilder result = new StringBuilder();
        int count = 1;

        for(int i=1; i<str.length(); i++){
            if(str.charAt(i) == str.charAt(i-1)){
                count++;
            }else{
                result.append(str.charAt(i-1)).append(count);
                count=1;
            }
        }

        result.append(str.charAt(str.length()-1)).append(count);

        return result.toString();
    }


}
