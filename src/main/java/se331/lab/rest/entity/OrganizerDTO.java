package se331.lab.rest.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import se331.lab.rest.security.user.User;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrganizerDTO {
    Long id;
    String name;
    Long userId; // Instead of the entire User object, just reference the ID
    @Builder.Default
    List<OrganizerOwnEventsDTO> ownEvents = new ArrayList<>();
}

