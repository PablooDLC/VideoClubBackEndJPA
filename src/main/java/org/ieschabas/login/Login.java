package org.ieschabas.login;

import java.util.Objects;

import javax.persistence.*;

public class Login {

	private int id;
	private String email;
	private String password;

	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Login(int id, String email, String password) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Login [id=" + id + ", email=" + email + ", password=" + password + "]";
	}
	

	@Override
	public int hashCode() {
		return Objects.hash(email, id, password);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Login other = (Login) obj;
		return Objects.equals(email, other.email) && id == other.id && Objects.equals(password, other.password);
	}

	public void login(String email, String password) {
		
	}
}