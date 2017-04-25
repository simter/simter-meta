package tech.simter.meta.po;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Meta Type
 *
 * @author RJ 2017-04-25
 */
@Entity
public class MetaType implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Integer id;

  /**
   * The MetaType identity, like "creation", "modification"
   */
  @Column(nullable = false, unique = true)
  public String type;

  /**
   * The Name
   */
  @Column(nullable = false)
  public String name;

  public MetaType() {
  }

  public MetaType(String type, String name) {
    this.type = type;
    this.name = name;
  }
}