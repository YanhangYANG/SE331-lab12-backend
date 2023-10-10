package se331.lab.rest.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import se331.lab.rest.entity.Event;
import se331.lab.rest.entity.Org;
import se331.lab.rest.entity.Organizer;
import se331.lab.rest.repository.EventRepository;
import se331.lab.rest.repository.OrgRepository;
import se331.lab.rest.repository.OrganizerRepository;

import java.util.Collections;

@Component
@RequiredArgsConstructor
public class InitApp implements ApplicationListener<ApplicationReadyEvent> {
    @Autowired
    EventRepository eventRepository;


    final OrgRepository orgRepository;
    final OrganizerRepository organizerRepository;
    @Override
     @Transactional
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
                Organizer org1,org2,org3;
                org1=organizerRepository.save(Organizer.builder()
                        .name("CAMT").build());
                org2=organizerRepository.save(Organizer.builder()
                        .name("CMU").build());
                org3=organizerRepository.save(Organizer.builder()
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



}


