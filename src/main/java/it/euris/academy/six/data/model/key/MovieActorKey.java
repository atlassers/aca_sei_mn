package it.euris.academy.six.data.model.key;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieActorKey implements Serializable {

  private static final long serialVersionUID = 1L;

  @Column(name = "movie_id")
  Long movieId;

  @Column(name = "actor_id")
  Long actorId;
  
}
