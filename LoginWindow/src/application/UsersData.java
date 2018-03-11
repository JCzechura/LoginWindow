package application;

import java.util.ArrayList;
import java.util.List;

public class UsersData {
	
	List<User> users =new ArrayList<User>();
	UsersData()
	{
		users.add(new User(MyEnum.FIRST_CHOICE,"asiaczechura", "11yb23" ));
		users.add(new User(MyEnum.FIRST_CHOICE,"gabrielrêbacz", "511cc23" ));
		users.add(new User(MyEnum.SECOND_CHOICE,"martawinkiel", "13as4123" ));
		users.add(new User(MyEnum.SECOND_CHOICE,"klaudiachrzan", "1gf122as33" ));
		users.add(new User(MyEnum.THIRD_CHOICE,"majapytlasiñska", "1129df833" ));
		users.add(new User(MyEnum.THIRD_CHOICE,"ulaludwiczak", "1110;2sd3" ));
	}
	public boolean isPassCorrect (String env, String name, String pass)
	{
		for (User element : users) {
			if (element.enviroment.toString().equals(env) && element.name.equals(name) && element.pass.equals(pass))
				return true;
		}
		return false;
	}

}
