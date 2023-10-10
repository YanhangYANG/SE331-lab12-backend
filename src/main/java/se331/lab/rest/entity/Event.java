package se331.lab.rest.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    Long id;
    String category;
    String title;
    String description;
    String location;
    String date;
    String time;
    @ManyToOne
    Organizer organizer;
    @ManyToMany(mappedBy = "eventHistory")
    List<Participant> participants;
    @ElementCollection(fetch = FetchType.EAGER)
    List<String> images;
    Boolean petsAllowed;
}
