package com.ice1155.DA;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {
	private String username;
	private String password;
	private String token;
	
	public User() {}
	
	public User(Parcel p) {
		readFromParcel(p);
	}
	
	public User (String username, String pwd) {
		this.username = username;
		this.password = pwd;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {		
		dest.writeString(username);
		dest.writeString(password);
		dest.writeString(token);
	}
	
	public void readFromParcel(Parcel in) {
		username = in.readString();
		password = in.readString();
		token = in.readString();
	}
}
