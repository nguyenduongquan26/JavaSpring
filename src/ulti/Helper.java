package ulti;

import java.util.Random;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Helper {
	public static String randomString(int n) {
		String st = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLzXCVBNM1234567890";
		Random rd = new Random();
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<n;i++) {
			int index = rd.nextInt(st.length());
			sb.append(st.charAt(index));
		}
		return sb.toString();
	}
	public static long randomLong() {
		Random rd = new Random();
		return Math.abs(rd.nextLong());
	}
	public static String brypt(String text) {
		BCryptPasswordEncoder cr = new BCryptPasswordEncoder();
		return cr.encode(text);
	}
	public static void addCookie(String key, HttpServletRequest req, HttpServletResponse resp) {
		Cookie cookie = new Cookie(key, Helper.randomString(32));
		cookie.setMaxAge(3600*24*30);
		cookie.setPath(req.getServletContext().getContextPath());
		resp.addCookie(cookie);
	}
}
