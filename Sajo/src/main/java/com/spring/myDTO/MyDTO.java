package com.spring.myDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MyDTO {
	private int no;
	private String title;
	private String content;
	private boolean accept;
	private String regDate;
	private Object type;

}
