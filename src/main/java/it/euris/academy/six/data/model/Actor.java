package it.euris.academy.six.data.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import it.euris.academy.six.data.archetype.Model;
import it.euris.academy.six.data.dto.ActorDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "actor")
@Entity
public class Actor implements Model {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_actor")
  private Long id;

  @Column(name = "name_actor")
  private String name;

  @OneToMany(mappedBy = "actor")
  @Builder.Default
  private List<MovieActor> moviesActor = new ArrayList<MovieActor>();

  public Actor(String actorId) {
    if (actorId != null) {
      this.id = Long.parseLong(actorId);
    }
  }

  @Override
  public ActorDto toDto() {
    return ActorDto.builder().idActor(id == null ? null : id.toString()).nameActor(name).build();
  }

}
