package cj.oshopping.user.model;

import java.io.Serializable;

import lombok.Data;

/**
 * 웹사용자 Service
 * 
 * @author passion
 *
 */
@Data
public class WebMember implements Serializable {
	private static final long serialVersionUID = 5970882747119288724L;
	
	/**
	 * 사용자번호
	 */
	String custNo;
}
