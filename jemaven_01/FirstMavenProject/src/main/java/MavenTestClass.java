public class MavenTestClass {
    public static void main(String[] args) {
        try{
            System.out.println("Hello, World!");
            FirstCharUpperCase.toUpperCaseFirstChar("anything");
        }catch(Exception err) {
            err.printStackTrace();
        }
    }
}
