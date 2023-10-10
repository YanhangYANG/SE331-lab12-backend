package se331.lab.rest.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import se331.lab.rest.security.user.User;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class EventOrganizerDTO {
    Long id;
    String name;
}
