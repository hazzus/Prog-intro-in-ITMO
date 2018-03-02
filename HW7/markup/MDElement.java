package markup;

public interface MDElement {
    void toMarkdown(StringBuilder s);
    void toHtml(StringBuilder s);
    void toTex(StringBuilder s);
}
