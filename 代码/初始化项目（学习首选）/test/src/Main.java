/**
 * @author Pzr
 * @create ${DATE} - ${TIME}
 */
public class Main {
    public static void main(String[] args) {
        Inter3 i = Outer6.method();
        i.show();
    }

}
interface  Inter3{
    public  abstract void show();
}
class Outer6{
    public static Inter3 method(){
        return new Inter3(){
            public void show(){

                    System.out.println("1");
                }

        };
    }
}