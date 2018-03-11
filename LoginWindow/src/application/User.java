package application;

public class User {
	MyEnum enviroment;
	String name;
	String pass;
	
    public User(MyEnum enviroment, String name,String pass) {
        this.enviroment = enviroment;
        this.name = name;
        this.pass = pass;
    }
}
