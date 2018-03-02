package markup;

public class Text implements MDElement{
    private String text;

    public Text(String s){
        text = s;
    }

    public void toMarkdown(StringBuilder s){
        s.append(text);
    }
}