package com.codeclan.example.CourseBookingSystem.components;

import com.codeclan.example.CourseBookingSystem.models.Booking;
import com.codeclan.example.CourseBookingSystem.models.Course;
import com.codeclan.example.CourseBookingSystem.models.Customer;
import com.codeclan.example.CourseBookingSystem.repositories.BookingRepository;
import com.codeclan.example.CourseBookingSystem.repositories.CourseRepository;
import com.codeclan.example.CourseBookingSystem.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CourseRepository courseRepository;

    public DataLoader() {
    }

    public void run(ApplicationArguments args) {
        Course python = new Course("Python", "Edinburgh", 2.7);
        courseRepository.save(python);

        Course javascript = new Course("Javascript", "Edinburgh", 4.8);
        courseRepository.save(javascript);

        Course java = new Course("Java", "Edinburgh", 5.0);
        courseRepository.save(java);

        Course csharp = new Course("Csharp", "Aberdeen", 5.0);
        courseRepository.save(csharp);

        Course salmoncooking = new Course("Salmoncooking", "Glasgow", 3.0);
        courseRepository.save(salmoncooking);

        Course brewing = new Course("Brewing", "Budapest", 5.0);
        courseRepository.save(brewing);

        Course knitting = new Course("Knitting", "Budapest", 3.7);
        courseRepository.save(knitting);

        Course salsadancing = new Course("Salsadancing", "Madrid", 2.5);
        courseRepository.save(salsadancing);

        Customer malcolm = new Customer("Malcolm", "Edinburgh", 45);
        customerRepository.save(malcolm);

        Customer zsolt = new Customer("Zsolt", "Budapest", 21);
        customerRepository.save(zsolt);

        Customer jon = new Customer("Jon", "Edinburgh", 30);
        customerRepository.save(jon);

        Customer tim = new Customer("Tim", "Glasgow", 50);
        customerRepository.save(tim);

        Customer kamil = new Customer("Kamil", "Aberdeen", 25);
        customerRepository.save(kamil);


        Booking booking1 = new Booking("01/06/2021", tim, knitting);
        bookingRepository.save(booking1);


        Booking booking2 = new Booking("01/06/2021", tim, javascript);
        bookingRepository.save(booking2);


        Booking booking3 = new Booking("01/06/2021", malcolm, salmoncooking);
        bookingRepository.save(booking3);

        Booking booking4 = new Booking("01/06/2021", malcolm, salsadancing);
        bookingRepository.save(booking4);

        Booking booking5 = new Booking("01/06/2021", zsolt, knitting);
        bookingRepository.save(booking5);

        Booking booking6 = new Booking("01/06/2021", zsolt, brewing);
        bookingRepository.save(booking6);


        Booking booking7 = new Booking("01/06/2021", kamil, salsadancing);
        bookingRepository.save(booking7);

        Booking booking8 = new Booking("01/06/2021", jon, csharp);
        bookingRepository.save(booking8);


        Booking booking9 = new Booking("01/06/2021", jon, brewing);
        bookingRepository.save(booking9);


        Booking booking10 = new Booking("01/06/2021", kamil, java);
        bookingRepository.save(booking10);


        Booking booking11 = new Booking("01/06/2021", kamil, python);
        bookingRepository.save(booking11);


        Booking booking12 = new Booking("01/06/2021", kamil, javascript);
        bookingRepository.save(booking12);

    }
}
