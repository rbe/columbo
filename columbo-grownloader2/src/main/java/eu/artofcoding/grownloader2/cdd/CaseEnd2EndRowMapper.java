package eu.artofcoding.grownloader2.cdd;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CaseEnd2EndRowMapper implements RowMapper<CaseEnd2End> {

    @Override
    public CaseEnd2End mapRow(ResultSet rs, int rowNum) throws SQLException {
        CaseEnd2End caseEnd2End = new CaseEnd2End();
        caseEnd2End.setCaseId(rs.getString("case_id"));
        return caseEnd2End;
    }

}
