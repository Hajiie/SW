package Student;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StudentManagerTest {
	StudentManager studentmanager;

	@BeforeEach
	void setUp() throws Exception {
		studentmanager = new StudentManager();
	}

	@Test
	void testAddStudentException() {
		studentmanager.addStudent("KIM");
		Exception exception = assertThrows(IllegalArgumentException.class,()->
		studentmanager.addStudent("KIM"));
		assertTrue(exception.getMessage().equals("이미 존재하는 학생입니다: KIM"));
	}


	@Test
	void testRemoveStudentException() {
//		studentmanager.addStudent("KIM");
//		studentmanager.removeStudent("KIM");
		Exception exception = assertThrows(IllegalArgumentException.class,()->
		studentmanager.removeStudent("KIM"));
		assertTrue(exception.getMessage().equals("존재하지 않는 학생입니다: KIM"));
	}
	
	@Test
	void testHasStudent() {
		assertFalse(studentmanager.hasStudent("KIM"));
	}

	@Test
	void testAddStudent() {
		studentmanager.addStudent("KIM");
		assertTrue(studentmanager.hasStudent("KIM"));
	}
	
	@Test
	void testRemoveStudent() {
		studentmanager.addStudent("KIM");
		studentmanager.removeStudent("KIM");
		assertFalse(studentmanager.hasStudent("KIM"));
	}

}
