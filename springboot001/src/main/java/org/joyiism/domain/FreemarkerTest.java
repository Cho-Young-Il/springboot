package org.joyiism.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class FreemarkerTest {
	private String url;
	private String title;
	public FreemarkerTest(){}
	public FreemarkerTest(String url, String title) {
		this.url = url;
		this.title = title;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<FreemarkerTest> getFreemarkerTestList() {
           List<FreemarkerTest> list = new ArrayList<>();
           list.add(new FreemarkerTest("http://FreemarkerTest1.com","FreemarkerTest One"));
           list.add(new FreemarkerTest("http://FreemarkerTest2.com","FreemarkerTest Two"));
           list.add(new FreemarkerTest("http://FreemarkerTest3.com","FreemarkerTest Three"));
	   return list;
	}
}
