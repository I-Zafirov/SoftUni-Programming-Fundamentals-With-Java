package T30RegularExpressions.lab;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class L0Demo {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("regex");
        //String text = "Hey guys, on 22-Jan-2015 I met a 08-Dec-2022   girl in bar. Then 2-Feb/2015 on 2/Fen/2015 we 5-Djv-2022 went on24-Dec-2022 3D a date. She had just turned 23 and I was going to have a birthday in 3-Mar 24\\Dec\\2022";
        String text = "today we are learning about regex, isn`t it fun?";

        Matcher matcher = pattern.matcher(text);

        boolean foundSomething = matcher.find();

        if(foundSomething){
            System.out.println(matcher.group(0));
        }else{
            System.out.println("Not found");
        }
    }
}
