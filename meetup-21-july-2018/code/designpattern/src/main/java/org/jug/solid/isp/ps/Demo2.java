package org.jug.solid.isp.ps;

interface Foo{
	void foo1();
	void foo2();
}
class FooImpl implements Foo{
	public void foo1(){System.out.println("foo1 method ....");}
	public void foo2(){System.out.println("foo2 method ....");}
	void foo3(){System.out.println("foo3 method ....");}
	void foo4(){System.out.println("foo4 method ....");}
	void foo5(){System.out.println("foo5 method ....");}
	void foo6(){System.out.println("foo6 method ....");}
}
class Bar{
	private Foo fooImpl=new FooImpl();
	
	public void bar(){
		fooImpl.foo2();
	}
	
}
public class Demo2 {
	public static void main(String[] args) {
		
	}

}
