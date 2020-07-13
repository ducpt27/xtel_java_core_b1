//package com.xtel.training.io_config.db.b4_student_manager.dao;
//
//import com.xtel.training.io_config.db.b4_student_manager.model.Student;
//
//import javax.swing.tree.RowMapper;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.List;
//
//public class StudentDao {
//
//    JdbcTemplate template;
//
//    public void setTemplate(JdbcTemplate template) {
//        this.template = template;
//    }
//
//    public int save(Student p) {
//        String sql = "INSERT INTO Student (name, salary, designation) values(?, ?, ?, ?)";
//        return template.update(sql);
//    }
//
//    public int update(Student p) {
//        String sql = "UPDATE Student SET name = ?, salary = ? WHERE id = ?";
//        return template.update(sql);
//    }
//
//    public int delete(int id) {
//        String sql = "DELETE FROM Student where id = " + id + "";
//        return template.update(sql);
//    }
//
//    public Student getStudentById(int id) {
//        String sql = "SELECT * FROM Student WHERE id = ?";
//        return template.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<Student>(Student.class));
//    }
//
//    public List<Student> getStudents() {
//        return template.query("SELECT * FROM Student", new RowMapper<Student>() {
//            public Student mapRow(ResultSet rs, int row) throws SQLException {
//                Student e = new Student();
//                e.setId(rs.getInt(""));
//                e.setFullName(rs.getString(""));
//                e.setHomeTown(rs.getString(""));
//                e.setGender(rs.getBoolean(""));
//                e.setAge(rs.getInt(""));
//                return e;
//            }
//        });
//    }
//}
