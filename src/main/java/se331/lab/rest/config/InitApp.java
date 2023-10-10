package se331.lab.rest.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import se331.lab.rest.entity.Event;
import se331.lab.rest.entity.Org;
import se331.lab.rest.entity.Organizer;
import se331.lab.rest.repository.EventRepository;
import se331.lab.rest.repository.OrgRepository;
import se331.lab.rest.repository.OrganizerRepository;
import se331.lab.rest.security.user.User;
import se331.lab.rest.security.user.UserRepository;

import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Collections;

@Component
@RequiredArgsConstructor
public class InitApp implements ApplicationListener<ApplicationReadyEvent> {
    @Autowired
    EventRepository eventRepository;


    final OrgRepository orgRepository;
    final OrganizerRepository organizerRepository;
    final UserRepository userRepository;

    @Override
     @Transactional
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        Organizer org1, org2, org3;
        org1 = organizerRepository.save(Organizer.builder()
                .name("CAMT").build());
        org2 = organizerRepository.save(Organizer.builder()
                .name("CMU").build());
        org3 = organizerRepository.save(Organizer.builder()
                .name("Chiang Mai").build());
        Event tempEvent;
        tempEvent = eventRepository.save(Event.builder()
                .category("Academic")
                .title("Midterm Exam")
                .description("A time for taking the exam")
                .location("CAMT Building")
                .date("3rd Sept")
                .time("3.00-4.00 pm.")
                .petsAllowed(false)
                .build());
        tempEvent.setOrganizer(org1);
        org1.getOwnEvents().add(tempEvent);




               tempEvent = eventRepository.save(Event.builder()
                                .category("Academic")
                                .title("Commencement Day")
                                .description("A time for celebration")
                                .location("CMU Convention hall")
                                .date("21th Jan")
                                .time("8.00am-4.00 pm.")
                                .petsAllowed(false)
                                .build());
                tempEvent.setOrganizer(org1);
                org1.getOwnEvents().add(tempEvent);
                tempEvent = eventRepository.save(Event.builder()
                                .category("Cultural")
                                .title("Loy Krathong")
                                .description("A time for Krathong")
                                .location("Ping River")
                                .date("21th Nov")
                                .time("8.00-10.00 pm.")
                                .petsAllowed(false)
                                .build());
                tempEvent.setOrganizer(org2);
                org2.getOwnEvents().add(tempEvent);
                tempEvent = eventRepository.save(Event.builder()
                                .category("Cultural")
                                .title("Songkran")
                                .description("Let's Play Water")
                                .location("Chiang Mai Moat")
                                .date("13th April")
                                .time("10.00am - 6.00 pm.")
                                .petsAllowed(true)
                                .build());
                tempEvent.setOrganizer(org3);
                org3.getOwnEvents().add(tempEvent);
                addUser();
                org1.setUser(user1);
                user1.setOrganizer(org1);
                userRepository.save(user1);
                org2.setUser(user2);
                user2.setOrganizer(org2);
        userRepository.save(user2);
                org3.setUser(user3);
                user3.setOrganizer(org3);
        userRepository.save(user3);

                orgRepository.save(Org.builder()
                                .name("CMU")
                                .address("239 Huay Kaew Rd., Muang District, Chiang Mai 50200")
                                .build());
                orgRepository.save(Org.builder()
                                .name("CAMT")
                                .address("abc 4L")
                                .build());
                orgRepository.save(Org.builder()
                                .name("X")
                                .address("abc 1L")
                                .build());
                 orgRepository.save(Org.builder()
                                 .name("N")
                                 .address("abc 2L")
                                 .build());

            }

            User user1, user2, user3;
    private void addUser(){
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        user1 = User.builder()
                .username("admin")
                .password(encoder.encode("admin"))
                .firstname("admin")
                .lastname("admin")
                .email("admin@admin.com")
                .build();

        user2 = User.builder()
                .username("user")
                .password(encoder.encode("user"))
                .firstname("user")
                .lastname("user")
                .email("email@user.com")
                .build();

        user3 = User.builder()
                .username("user2")
                .password(encoder.encode("user2"))
                .firstname("user2")
                .lastname("user2")
                .email("disableUser@user.com")
                .build();





    }



}


