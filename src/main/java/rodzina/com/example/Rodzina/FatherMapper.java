package rodzina.com.example.Rodzina;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;



public class FatherMapper implements RowMapper<Father> {
	
	   @Override
	   public Father mapRow(ResultSet row, int rowNum) throws SQLException {
		   Father father = new Father();
		   father.SetImie(row.getString("FirstName"));
		   father.SetDate(row.getDate("BirthDate"));
		   father.SetPesel(row.getString("PESEL"));
		   father.SetSecond(row.getString("SecondName"));
		   father.SetID(row.getInt("ID"));
		return father;
	   }
	   
	   
	}