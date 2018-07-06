package rodzina.com.example.Rodzina;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;


public class FatherJDBC {
	
	 private DataSource dataSource;
	   private JdbcTemplate jdbcTemplateObject;
	   
	    public void setDataSource(DataSource dataSource) {
	        this.dataSource = dataSource;
	        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	     }
	    
	    public List<Father> getAllFathers() {
			   String sql = "SELECT * FROM father";
			   RowMapper<Father> rowMapper = new FatherMapper();
			   return this.jdbcTemplateObject.query(sql, rowMapper);
			} 
	    
	    public List<Child> getChildren(int id){	    	
	    	String sql = "SELECT * FROM child WHERE child.ID="+id;
	    	RowMapper<Child> rowMapper = new ChildMapper();
	    	return this.jdbcTemplateObject.query(sql, rowMapper);
	    }
	    public void addChild(Child child) {
	    	   String sql = "INSERT INTO child (Sex, FirstName, PESEL, SecondName, ID) values (?, ?, ?, ?, ?)";
	    	   jdbcTemplateObject.update(sql, child.GetSex() , child.GetImie(), child.GetPesel(), child.GetSecond(), child.GetID());    	  
	    	}
	    
	    
	    public void addFamily() {
	    	   String sql = "INSERT INTO family () values (null)";
	    	   jdbcTemplateObject.update(sql);
	    }
	    
	    public void addFather(Father father) {
	    	   String sql = "INSERT INTO father (BirthDate, FirstName, PESEL, SecondName) values (?, ?, ?, ?)";
	    	   jdbcTemplateObject.update(sql, father.GetDate(), father.GetImie(), father.GetPesel(), father.GetSecond());    	  
	    	}
	    
	  
	  
	}
