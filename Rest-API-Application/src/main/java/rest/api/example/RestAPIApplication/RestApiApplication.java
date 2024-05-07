package rest.api.example.RestAPIApplication;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import rest.api.example.Entity.RestApiEntity;

@SpringBootApplication
public class RestApiApplication implements CommandLineRunner{

	@Autowired 
	JdbcTemplate jdbcTemplate;
	
	public static void main(String[] args) {
		SpringApplication.run(RestApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String sql = "SELECT * from department";
		List<RestApiEntity> lst = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(RestApiEntity.class));
			lst.forEach(System.out::println);	
	}

}
