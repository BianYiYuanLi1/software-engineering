package com.book.manager;

import com.alibaba.excel.EasyExcel;
import com.book.manager.entity.Book;
import com.book.manager.entity.Student;
import com.book.manager.entity.Users;
import com.book.manager.service.BookService;
import com.book.manager.service.UserService;
import com.book.manager.util.excel.ReadExcelUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@SpringBootTest
@RunWith(SpringRunner.class)
public class ManagerApplicationTests {

	@Autowired
	private BookService bookService;

	@Autowired
	private UserService userService;


	@Test
	public void contextLoads() {
		for (int i = 0; i < 15; i++) {
			Book book = new Book();
			book.setIsbn("121312"+i);
			book.setAuthor("Jason"+i);
			book.setName("《高等数学必修》"+i);
			book.setPages(150+i);
			book.setPrice(15d+i);
			book.setPublish("北京邮电出版社分社"+i);
			book.setSize(i);
			book.setTranslate("翻译者"+i);
//			book.setType(0);
			book.setPublishTime(new Date());
			bookService.addBook(book);

			Users user = new Users();
			user.setSize(i);
			user.setAddress("北京街道"+i);
			user.setAvatar("avatar"+i+".jpg");
			user.setBirthday(new Date());
			user.setEmail("demo"+i+"@163.com");
			user.setIdentity(0);
			user.setIsAdmin(0);
			user.setNickname("admin"+i);
			user.setUsername("admin"+i);
			user.setPassword("123"+i);
			userService.addUser(user);
		}

	}

	@Test
	public void test2(){
		ReadExcelUtil readExcelUtil = new ReadExcelUtil();
		File file = new File("C:\\Users\\365469wen\\Desktop\\studentinfo.xlsx");
		EasyExcel.read(file, Student.class,readExcelUtil)
				.sheet()
				.headRowNumber(1)
				.doRead();
		List<Student> list = readExcelUtil.list;
		List<Users> users = new ArrayList<>();
		for (Student student : list) {
			String id = student.getId();
			Users user = new Users();
			//身份默认为学生
			user.setNickname(student.getName());
			//用户名为学号
			user.setUsername(student.getStudentId());
			//后六位为密码
			user.setPassword(id.substring(id.length()-6,id.length()));
			//默认可接数量为10
			user.setSize(10);
			//手机号
			user.setTel(student.getTel());
			//学生身份
			user.setIdentity(0);
			//非管理员
			user.setIsAdmin(1);
			//地址
			user.setAddress("南宁");
			users.add(user);
		}
		userService.addBatchUser(users);
	}

}
