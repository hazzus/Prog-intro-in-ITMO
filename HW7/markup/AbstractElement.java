package markup;

import java.util.List;

public abstract class AbstractElement {
    private List<MDElement> el;
    protected String sur;

    public AbstractElement(String s, List<MDElement> e){
        sur = s;
        el = e;
    }

    public void toMarkdown(StringBuilder s){
        s.append(sur);
        for (int i = 0; i < el.size(); i++){
            el.get(i).toMarkdown(s);
        }
        s.append(sur);
    }
}
