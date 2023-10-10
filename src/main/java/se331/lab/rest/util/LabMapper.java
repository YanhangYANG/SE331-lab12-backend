package se331.lab.rest.util;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.web.bind.annotation.Mapping;
import se331.lab.rest.entity.Event;
import se331.lab.rest.entity.EventDTO;
import se331.lab.rest.entity.Organizer;
import se331.lab.rest.entity.OrganizerDTO;

import java.util.List;

@Mapper
public interface LabMapper {
    LabMapper INSTANCE = Mappers.getMapper(LabMapper.class);


    OrganizerDTO getOrganizerDTO(Organizer organizer);

    EventDTO getEventDto(Event event);
    List<EventDTO> getEventDto(List<Event> events);


    List<OrganizerDTO> getOrganizerDto(List<Organizer> organizers);

}
