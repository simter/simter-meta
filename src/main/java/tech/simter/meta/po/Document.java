package tech.simter.meta.po;

import javax.persistence.*;
import java.io.Serializable;

/**
 * The document.
 *
 * @author RJ
 */
@Entity
public class Document implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Integer id;

  /**
   * The document identity. Prefer to use the entity class name, such as "tech.simter.demo.po.Demo".
   */
  @Column(nullable = false, unique = true)
  public String type;

  /**
   * The name.
   */
  public String name;
}