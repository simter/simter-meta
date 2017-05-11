package tech.simter.meta.po;

import javax.persistence.*;
import java.io.Serializable;
import java.time.OffsetDateTime;

/**
 * The Document Meta History
 *
 * @author RJ
 */
@Entity
public class MetaHistory implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Integer id;

  /**
   * The creation date-time
   */
  @Column(nullable = false)
  public OffsetDateTime time;

  /**
   * The Actor ID, like creator or modifier ID
   */
  @Column
  public Integer actor;

  @ManyToOne(optional = false)
  @JoinColumn(nullable = false)
  public MetaType metaType;

  @ManyToOne(optional = false)
  @JoinColumn(nullable = false)
  public MetaDoc metaDoc;

  /**
   * The document instance ID
   */
  @Column(nullable = false)
  public Integer docId;
}