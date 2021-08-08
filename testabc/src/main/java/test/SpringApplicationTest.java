//package test;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.JwtBuilder;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import io.jsonwebtoken.impl.Base64Codec;
//
//import java.util.Date;
//
//@SpringBootApplication
//public class SpringApplicationTest {
//
//	/**
//	 * 解析token
//	 */
//	@Test
//	public void testParseToken() {
//		String token = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI4ODgiLCJzdWIiOiJSb2xlIiwiaWF0IjoxNjI3Nzk4NjM5LCJleHAiOjE2Mjc3OTg2OTh9.KfNxj2T8zCNJPlniN3Z7T_UvXHdH1PQaoAKS0tnW9nM";
//						
//		Claims claims = (Claims) Jwts.parser()
//				.setSigningKey("xxxx")
//				.parse(token)
//				// 簽發密鑰必須相同
//				.getBody();
//
//		System.out.println("id :  " + claims.getId());
//		System.out.println("sub" + claims.getSubject());
//		System.out.println("iat" + claims.getIssuedAt());
//	}
//
////	@Test
//	/**
//	 * 產生token
//	 */
//	public void testJwt() {
//
//		JwtBuilder jwtBuilder = Jwts.builder().setId("888")
//				// 唯一id
//				.setSubject("Role").
//				// 接受用戶
//				setIssuedAt(new Date())
//				// 產生時間
//				.signWith(SignatureAlgorithm.HS256, "xxxx");
//		// 演算法
//		String token = jwtBuilder.compact();
//		// 產生token
//		System.out.println(token);
//
//		System.out.println("=========================");
//
//		String[] split = token.split("\\.");
//
//		/**
//		 * 手動解密
//		 */
//		System.out.println(Base64Codec.BASE64.decodeToString(split[0]));
//
//		System.out.println(Base64Codec.BASE64.decodeToString(split[1]));
//
//		System.out.println(Base64Codec.BASE64.decodeToString(split[2]));
//	}
//
//	/**
//	 * 產生token(失效時間)
//	 */
////	@Test
//	public void testJwtHasExprire() {
//
//		long date = System.currentTimeMillis();
//		//失效時間
//		long exp = date + 60 * 1000;
//
//		JwtBuilder jwtBuilder = Jwts.builder().setId("888")
//				// 唯一id
//				.setSubject("Role").
//				// 接受用戶
//				setIssuedAt(new Date())
//				// 產生時間
//				.signWith(SignatureAlgorithm.HS256, "xxxx")
//				//演算法 解密法式
//				.setExpiration(new Date(exp));
//				//失效時間
//		// 演算法
//		String token = jwtBuilder.compact();
//		// 產生token
//		System.out.println(token);
//
//		System.out.println("=========================");
//
//		String[] split = token.split("\\.");
//
//		/**
//		 * 手動解密
//		 */
//		System.out.println(Base64Codec.BASE64.decodeToString(split[0]));
//
//		System.out.println(Base64Codec.BASE64.decodeToString(split[1]));
//
//		System.out.println(Base64Codec.BASE64.decodeToString(split[2]));
//	}
//
//}
