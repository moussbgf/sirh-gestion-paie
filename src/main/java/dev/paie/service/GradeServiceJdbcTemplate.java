package dev.paie.service;

import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import dev.paie.entite.Grade;

@Service
public class GradeServiceJdbcTemplate implements GradeService {

	private JdbcTemplate jdbcTemplate;
	
	private static final RowMapper<Grade> GRADE_MAPPER = (rs, rowNum) -> new Grade(rs.getInt("id"), rs.getString("code"), rs.getBigDecimal("nbHeuresBase"), rs.getBigDecimal("tauxBase"));

	@Autowired
	public GradeServiceJdbcTemplate(DataSource dataSource) {
		super();
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void sauvegarder(Grade nouveauGrade) {
		
		String sql = "INSERT INTO grade VALUES (?,?,?,?)";
		
		this.jdbcTemplate.update(sql, nouveauGrade.getId(), nouveauGrade.getCode(), nouveauGrade.getNbHeuresBase(), nouveauGrade.getTauxBase());
		
	}

	@Override
	public void mettreAJour(Grade grade) {
		String sql = "UPDATE grade SET code = ? , nbHeuresBase = ? , tauxBase = ?  WHERE id = ? ";
		this.jdbcTemplate.update(sql, grade.getCode(), grade.getNbHeuresBase(), grade.getTauxBase(), grade.getId());
	}

	@Override
	public List<Grade> lister() {
		
		String sql = "SELECT * from grade";
		
		return this.jdbcTemplate.query("select * from GRADE", GRADE_MAPPER);
	}
}
