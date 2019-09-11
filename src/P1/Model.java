package P1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Model {
    String name;
    int accno;
    int accno1;
    String custid;
    String pwd;
    int balance;
    String email;
    ArrayList al1=new ArrayList();
    ArrayList al2=new ArrayList();
    String url="jdbc:oracle:thin:@localhost:1521:xe";
	String user="SYSTEM";
	String password="system";
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet res;
  
  
  public String getName() {
	return name;
   }

  public void setName(String name) {
	this.name = name;
   }

  public int getAccno() {
	return accno;
   }

  public void setAccno(int accno) {
	this.accno = accno;
  }

  public String getCustid() {
	return custid;
  }

  public void setCustid(String custid) {
	this.custid = custid;
  }

  public String getPwd() {
	return pwd;
   }

  public void setPwd(String pwd) {
	this.pwd = pwd;
  }

  public int getBalance() {
	return balance;
  }

  public void setBalance(int balance) {
	this.balance = balance;
  }

  public String getEmail() {
	return email;
  }

  public void setEmail(String email) {
	this.email = email;
  }
  
  public int getAccno1() {
		return accno1;
	   }

	  public void setAccno1(int accno1) {
		this.accno1 = accno1;
	  }
    
  public Model() throws Exception{
	Class.forName("oracle.jdbc.driver.OracleDriver");
	con=DriverManager.getConnection(url,user,password);
    }
  
  boolean login() throws Exception{
  	String s="SELECT * FROM bank WHERE custid=? AND pwd=?";
  	pstmt=con.prepareStatement(s);
  	pstmt.setString(1,custid);
  	pstmt.setString(2,pwd);   
  	res=pstmt.executeQuery();
  	while(res.next()==true) {
  		name=res.getString("name");
  		custid=res.getString("custid");
  		accno=res.getInt("accno");
  		pwd=res.getString("pwd");
  		balance=res.getInt("balance");
  	    email=res.getString("email");
  		return true;
  	}
  	return false;
  }
   
    boolean checkBalance() throws Exception{
  	String s1="SELECT * FROM bank WHERE accno=?";
  	pstmt=con.prepareStatement(s1);
  	pstmt.setInt(1,accno);
  	res=pstmt.executeQuery();
  	while(res.next()==true) {
  		name=res.getString("name");
  	    balance=res.getInt("balance");
  	  return true;
  	}
  	return false;
  }
    
    boolean applyLoan() throws Exception{
    	String s2="SELECT * FROM bank WHERE accno=?";
      	pstmt=con.prepareStatement(s2);
      	pstmt.setInt(1,accno);
      	res=pstmt.executeQuery();
      	while(res.next()==true) {
      		name=res.getString("name");
      	    email=res.getString("email");
      	  return true;
      	}
      	return false;
      }

boolean changePwd() throws Exception{
	String s3="UPDATE bank SET pwd=? WHERE accno=?";
	pstmt=con.prepareStatement(s3);
	pstmt.setString(1,pwd);
  	pstmt.setInt(2,accno);
  	int x=pstmt.executeUpdate();
  	if(x==1){
  	  return true;
  	}
  	return false;
}

boolean transfer() throws Exception{
	String s4="SELECT * FROM bank WHERE accno=?";
	pstmt=con.prepareStatement(s4);
  	pstmt.setInt(1,accno1);
  	res=pstmt.executeQuery();
    while(res.next()==true) {
    	String s5="UPDATE bank SET balance=balance-? WHERE accno=?";
    	pstmt=con.prepareStatement(s5);
    	pstmt.setInt(1,balance);
      	pstmt.setInt(2,accno);
      	int x1=pstmt.executeUpdate();
        if(x1==1){
      	   String s6="UPDATE bank SET balance=balance+? WHERE accno=?";
      	   pstmt=con.prepareStatement(s6);
    	   pstmt.setInt(1,balance);
      	   pstmt.setInt(2,accno1);
      	   int x2=pstmt.executeUpdate();
           if(x2==1){
      	      String s7="INSERT INTO getstatement VALUES(?,?,?)"; 
      	          pstmt=con.prepareStatement(s7);
      	          pstmt.setInt(1,accno);
   	              pstmt.setInt(2,accno1);
	              pstmt.setInt(3,balance);
	              int x3=pstmt.executeUpdate();
	                if(x3==1){
             	    return true;
                    }
                 }
              }
           }
             return false;  
    }

ArrayList getStatement() throws Exception{
	String s8="SELECT * FROM getstatement WHERE saccno=?";
	pstmt=con.prepareStatement(s8);
  	pstmt.setInt(1,accno);
  	res=pstmt.executeQuery();
  	while(res.next()==true) {
  		al1.add(res.getInt(2));
  		al2.add(res.getInt(3));
  		return al1;
  		}
  	return al1;
  	}

boolean forgetPwd() throws Exception{
	String s3="UPDATE bank SET pwd=? WHERE email=?";
	pstmt=con.prepareStatement(s3);
	pstmt.setString(1,pwd);
  	pstmt.setString(2,email);
  	int x=pstmt.executeUpdate();
  	if(x==1){
  	  return true;
  	}
  	return false;
}
}