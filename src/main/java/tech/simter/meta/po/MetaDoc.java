package tech.simter.meta.po;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Meta Document
 *
 * @author RJ 2017-04-25
 */
@Entity
public class MetaDoc implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Integer id;

  /**
   * The MetaDoc identity, like "tech.simter.User"
   */
  @Column(nullable = false, unique = true)
  public String type;

  /**
   * The Name
   */
  public String name;
}