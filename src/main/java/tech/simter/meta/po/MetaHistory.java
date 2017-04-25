package tech.simter.meta.po;

import javax.persistence.*;
import java.io.Serializable;
import java.time.OffsetDateTime;

/**
 * The Document Meta History
 *
 * @author RJ 2017-04-25
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
  @Column(nullable = false)
  public Integer actor;

  @Column(nullable = false)
  public MetaType metaType;
  @Column(nullable = false)
  public MetaDoc metaDoc;
  @Column(nullable = false)

  /**
   * The document instance ID
   */
  public Integer docId;
}