
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.aszy.ezmooc.po.Course;
import com.aszy.ezmooc.po.CourseCatg;
import com.aszy.ezmooc.po.EzUser;
import com.aszy.ezmooc.po.Video;
import com.aszy.ezmooc.service.CourseService;
import com.aszy.ezmooc.service.EzUserService;
import com.aszy.ezmooc.service.VideoService;

public class TestService {

	ApplicationContext ctx;
	CourseService cs;
	VideoService vs;
	EzUserService us;
	
	@Before
	public void setUp() throws Exception {
		ctx = new ClassPathXmlApplicationContext("classpath:spring/spring-*.xml");
		cs = (CourseService) ctx.getBean("courseServiceImpl");
		vs = (VideoService) ctx.getBean("videoServiceImpl");
		us = (EzUserService) ctx.getBean("ezUserServiceImpl");
	}
	
	@SuppressWarnings({ "unchecked", "unused", "rawtypes" })
	@Test
	public void testQueryCourse(){
		Map map = new HashMap();
		
		Course course = new Course();
		
		CourseCatg cc = new CourseCatg();
		cc.setCourseCatgId("1");
		
		course.setCourseCatg(cc);
		
		map.put("course", course);
		
		List<Course> list = (List<Course>) cs.queryCourse(map);
		
		System.out.println();
	}
	
	@Test
	public void testQueryCourseByUserId(){
		List<Course> list = cs.queryCourseByUserId("003");
		
		System.out.println();
		
	}
	@Test
	public void testQueryCourseById(){
		Course course = cs.queryCourseById("001");
		
		System.out.println();
		
	}
	@Test
	public void testAddCourse(){
		Course course = new Course();
		
		CourseCatg cc = new CourseCatg();
		cc.setCourseCatgId("111");
		
		course.setCourseCatg(cc);
		
		cs.addCourse(course);
		
		System.out.println();
		
	}
	@Test
	public void testUpdateCourse(){
		Course course = new Course();
		course.setCourseId("9");
		
		CourseCatg cc = new CourseCatg();
		cc.setCourseCatgId("1111");
		
		course.setCourseCatg(cc);
		
		cs.editCourse(course);
		
		System.out.println();
		
	}
	@Test
	public void testDeleteCourse(){ 
		cs.deleteCourse("111");
	}
	
	@Test
	public void testQueryVideo(){
		
		List<Video> list = vs.queryVideoByCourseId("001");
		
		Video video = vs.queryVideoById("010");
		
		System.out.println();
		
	}
	
	@Test
	public void testRegist(){
		EzUser u = new EzUser();
		us.userRegist(u);
	}
	
	
	

}
