import java.util.*;
import java.lang.reflect.*;
public class ReflectionTest{
	public static void main(String args[]){
		System.out.println("Welcome to use our JavaCodingHelper");
		Scanner in=new Scanner(System.in);
		System.out.println("Which class do you want to know?");
		String classname=in.next();
		try{
			Class cl=Class.forName(classname);
			Object obj=cl.newInstance();
			System.out.println("I know "+obj.getClass().getName()+" very well!");
			System.out.println("----------------------------------------Constructors-----------------------------------");
			Constructor[] constructors=cl.getDeclaredConstructors();
			for(Constructor c:constructors){
				System.out.print(Modifier.toString(c.getModifiers())+" "+c.getName()+"(");
				Class[] paramTypes=c.getParameterTypes();
				for(Class p:paramTypes){
					System.out.print(p.getName()+" ");
				}
				System.out.println(")");
			}
			System.out.println("------------------------------------------Methods---------------------------------------");
			Method[] methods=cl.getDeclaredMethods();
			for(Method m:methods){
				System.out.print(Modifier.toString(m.getModifiers())+" "+m.getName()+"(");
				Class[] paramTypes=m.getParameterTypes();
				for(Class p:paramTypes){
					System.out.print(p.getName()+" ");
				}
				System.out.println(")");
			}
			System.out.println("------------------------------------------Fields---------------------------------------");
			Field[] fields=cl.getDeclaredFields();
			for(Field f:fields){
				System.out.println(Modifier.toString(f.getModifiers())+" "+f.getType().getName()+" "+f.getName());
			}
		}catch(Exception e){
			System.out.println("Oops,there is no such class called "+classname);
			e.printStackTrace();
		}
		
	}
}