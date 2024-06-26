package hgcq.photobook.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Event {

    @Id
    @GeneratedValue
    @Column(name = "event_id")
    private Long id;

    private String name;

    private LocalDate date;

    private String content;

    @OneToMany(mappedBy = "event")
    private List<Photo> photos;

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
    private List<EventMember> eventMembers;

    public Event(String name, LocalDate date) {
        this.name = name;
        this.date = date;
    }

    public Event(String name, LocalDate date, String content) {
        this.name = name;
        this.date = date;
        this.content = content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
