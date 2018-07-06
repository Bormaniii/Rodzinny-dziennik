package rodzina.com.example.Rodzina;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ChildMapper implements RowMapper<Child> {
	
	@Override
	   public Child mapRow(ResultSet row, int rowNum) throws SQLException {
		   Child child = new Child();
		   child.SetImie(row.getString("FirstName"));
		   child.SetSex(row.getString("Sex"));
		   child.SetPesel(row.getString("PESEL"));
		   child.SetSecond(row.getString("SecondName"));
		   child.SetID(row.getInt("ID"));
		return child;
	   }

}
