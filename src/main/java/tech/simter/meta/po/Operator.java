package tech.simter.meta.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * The document operator.
 *
 * @author RJ
 */
@Entity
public class Operator implements Serializable {
  @Id
  public Integer id;

  /**
   * The operator name.
   */
  @Column(nullable = false)
  public String name;
}