package it.euris.academy.six.data.model;

import java.time.Instant;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import it.euris.academy.six.data.archetype.Model;
import it.euris.academy.six.data.dto.ProjectionDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "projection")
@Entity
public class Projection implements Model {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_projection")
  private Long id;

  @Column(name = "time_projection")
  private Instant time;

  @ManyToOne
  @JoinColumn(name = "movie_id", nullable = false)
  private Movie movie;

  @ManyToOne
  @JoinColumn(name = "hall_id", nullable = false)
  private Hall hall;


  @OneToMany(mappedBy = "projection") // FetchType.Eager?
  private List<Ticket> tickets;

  public Projection(String projectionId) {
    if (projectionId != null) {
      this.id = Long.parseLong(projectionId);
    }
  }

  @Override
  public ProjectionDto toDto() {
    return ProjectionDto.builder().idProjection(id == null ? null : id.toString())
        .movieProjection(movie.getId().toString()).timeProjection(time.toString())
        .hallProjection(hall.getId().toString()).build();
  }



}
