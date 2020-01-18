package lecture;

public class StringConcatter implements DoStringStuff{
    @Override
    public String operate(String str1, String str2){
        return str1 + " " + str2;
    }
}

