package com.akushwah.examples.bootse1;

import java.awt.Color;

public class User {

	private String name;
	private String url;
	private Color favoriteColor;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Color getFavoriteColor() {
		return favoriteColor;
	}

	public void setFavoriteColor(Color favoriteColor) {
		this.favoriteColor = favoriteColor;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", url=" + url + ", favoriteColor=" + favoriteColor + "]";
	}

	

}
