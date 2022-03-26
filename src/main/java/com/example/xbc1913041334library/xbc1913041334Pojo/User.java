package com.example.xbc1913041334library.xbc1913041334Pojo;

public class User {
    private Integer id;
    private String userName;
    private  String passWord;
    private String note;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord(){
    	return passWord;
	}
	public void setPassWord(String passWord){
    	this.passWord=passWord;
	}

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public User(Integer id, String userName,String passWord,String note) {
        super();
        this.id = id;
        this.userName = userName;
        this.passWord=passWord;
        this.note = note;
    }

    public User() {
        super();
        // TODO Auto-generated constructor stub
    }


}
