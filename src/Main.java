//Это класс Main. На данный момент я вывожу в нем текст json файла, с которым в дальнейшем буду работать
public class Main {
    public static void main(String[] args) {

        JsonParser parser = new JsonParser();
        Root root = parser.root_parse();
        System.out.println(root.toString());
    }
}