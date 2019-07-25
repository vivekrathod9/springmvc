package com.indexial.mvc.serviceimpl;

public class MainTest {
public static void main(String[] args) {

	m();
	
	A.m3();
	
	B a=new C();
	a.m1();
	
	C c=new C();
	c.m1();
	
	A aa=new A() {
		
		@Override
		public void m1() {
			System.out.println("inner annonymous class");
		}
		
	}; 

}
public static void m(){
	System.out.println("m");
}


}

interface A{
	
	public void m1();
	public static  void m3(){
		System.out.println("inside m3-A");
	}
}


interface B{
	
	public void m1();
	public static  void m4(){
		System.out.println("inside m4-B");
	}
}

class C implements A,B{

	@Override
	public void m1() {
System.out.println("inside m1");
	}
	
}