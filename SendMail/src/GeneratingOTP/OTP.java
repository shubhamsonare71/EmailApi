package GeneratingOTP;

import java.util.Random;

public class OTP {
	
	 static char[] sendOTP(int length) {
		     
		      String number = "0123456789";
		      Random r = new Random();
		      char[] otp = new char[length];
		      for(int i =0; i<length; i++) {
		    	     otp[i] = number.charAt(r.nextInt(number.length()));
		      }
		      return otp;
	 }
	 
	 public static void main(String args[]) {
		          System.out.println("OTP for changing the password is:");
		          System.out.println(sendOTP(4));
	 }

}
