package chapter2.contracts;

public abstract class LoginAuthentication{
	   public String encryptPassword(String pwd){
		   return "BLABLA" + pwd;
	   }

	   public abstract void checkDBforUser();
}