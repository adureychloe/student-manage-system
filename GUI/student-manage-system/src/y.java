
import java.util.Arrays;
        import java.util.Random;

public class y {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        info[] a= new info[6];{
            for(int i=0;i<a.length;i++)
                a[i]=new info();

            a[0].name="Jack";
            a[1].name="Rihanna";
            a[2].name="Vita";
            a[3].name="Furian";
            a[4].name="Kathy";
            a[5].name="Dan";
            for(int i=0;i<a.length ;i++) {
                a[i].number=String.format("172712%d%d",i,i);
            }
            Random rand = new Random();
            for(int j=0;j<a.length;j++) {
                a[j].birthdate =String.format("%d年%d月%d日",1998,rand.nextInt(12) + 1,rand.nextInt(28) + 1 );
            }

            for(int i=0;i<a.length;i++) {
                String str = String.format("第%d个成员姓名为：%s;学号为%s;出生日期为%s",i+1,a[i].name,a[i].number,a[i].birthdate);
                System.out.println(str);
            }

            for(int i=0;i<a.length;i++) {
                boolean b1="17271222".equals(a[i].number);
                if(b1) System.out.println(String.format("姓名为：%s;学号为%s;出生日期为%s", a[i].name,a[i].number,a[i].birthdate));
            }

            System.out.println("按照学号排序，姓名排序为：");
            for(int i=1;i<a.length;i++) {
                String temp;
                int i1=a[i].number.compareTo(a[i-1].number);
                if(i1<0) {
                    temp=a[i].name;
                    a[i].name=a[i-1].name;
                    a[i-1].name=temp;
                }
            }

            for(int i=0;i<a.length;i++) {
                System.out.println(String.format("%s",a[i].name));
            }

            System.out.println("按照出生日期排序，姓名排序为：");

            for(int i=1;i<a.length;i++) {
                String temp;
                int i1=a[i].birthdate.compareTo(a[i-1].birthdate);
                if(i1<0) {
                    temp=a[i].name;
                    a[i].name=a[i-1].name;
                    a[i-1].name=temp;
                }
            }
            for(int i=1;i<a.length;i++) {
                System.out.println(String.format("%s",a[i].name));
            }

            for(int i=0;i<a.length;i++) {
                StringBuilder a1=new StringBuilder(a[i].number);
                a1.replace(0, 4, "0000");
                System.out.println(String.format("姓名为：%s;学号为%s;出生日期为%s", a[i].name,a1,a[i].birthdate));
            }

            for(int i=0;i<a.length;i++) {
                StringBuilder a2=new StringBuilder(a[i].name);
                a2.append("_高级会员");
                System.out.println(String.format("%s", a2));
            }

        }
    }
}
class info{
    String name;
    String number;
    String birthdate;
}