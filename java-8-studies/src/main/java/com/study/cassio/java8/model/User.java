package com.study.cassio.java8.model;

public class User {
	
	public User(String name) {
		super();
		this.name = name;
	}

	public User(String name, int point) {
		super();
		this.name = name;
		this.point = point;
	}
	
	private String name;
	private int point;
	private boolean moderator;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public boolean isModerator() {
		return moderator;
	}

	public void setModerator(boolean moderator) {
		this.moderator = moderator;
	}

}
