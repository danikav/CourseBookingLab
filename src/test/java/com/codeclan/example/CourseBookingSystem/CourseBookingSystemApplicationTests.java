package com.codeclan.example.CourseBookingSystem;

import com.codeclan.example.CourseBookingSystem.models.Booking;
import com.codeclan.example.CourseBookingSystem.models.Course;
import com.codeclan.example.CourseBookingSystem.models.Customer;
import com.codeclan.example.CourseBookingSystem.repositories.BookingRepository;
import com.codeclan.example.CourseBookingSystem.repositories.CourseRepository;
import com.codeclan.example.CourseBookingSystem.repositories.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
class CourseBookingSystemApplicationTests {

	@Autowired
	CourseRepository courseRepository;

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	BookingRepository bookingRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void canFindCoursesByRating(){
		List<Course> foundCourses = courseRepository.findCoursesByRating(5.0);
		assertEquals(3, foundCourses.size(), 0.1);
	}
	@Test
	public void canFindCustomersByCourse(){
		List<Customer> foundCustomers = customerRepository.findCustomersByBookingsCourseNameIgnoreCase("knitting");
		assertEquals(2, foundCustomers.size());
	}
	@Test
	public void canFindCoursesByCustomer(){
		List<Course> foundCourses = courseRepository.findCoursesByBookingsCustomerNameIgnoreCase("Zsolt");
		assertEquals(2, foundCourses.size());
	}
	@Test
	public void canFindBookingsByDate(){
		List<Booking> foundBookings = bookingRepository.findBookingsByDate("01/06/2022");
		assertEquals(2, foundBookings.size());
	}

}
