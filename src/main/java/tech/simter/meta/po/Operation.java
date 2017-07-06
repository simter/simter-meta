package tech.simter.meta.po;

import tech.simter.persistence.PersistenceEnum;

import javax.persistence.*;
import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.Objects;

/**
 * The document operation.
 *
 * @author RJ
 */
@Entity
@Table(indexes = @Index(columnList = "document_id, instance_id"))
public class Operation implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Integer id;

  /**
   * The operate timestamp.
   */
  @Column(nullable = false)
  public OffsetDateTime operateOn;

  /**
   * The operation type.
   * <p>
   * Some common operation type had predefined in {@link Type}.
   * Use its persistence value {@link Type#value()}. The reserve values id less than 50.
   * So if you use some custom value, make it greater than or equals 50.
   */
  public int type;

  /**
   * The document operator, such as creator or modifier.
   */
  @ManyToOne
  public Operator operator;

  /**
   * The document.
   */
  @ManyToOne(optional = false)
  @JoinColumn(nullable = false)
  public Document document;

  /**
   * The document instance ID.
   */
  @Column(name = "instance_id", nullable = false)
  public Integer instanceId;

  /**
   * The document operation type.
   */
  public enum Type implements PersistenceEnum<Integer> {
    /**
     * The creation operation. It has a persistence value 10.
     */
    Creation(10),

    /**
     * The modification operation. It has a persistence value 20.
     */
    Modification(20),

    /**
     * The confirmation operation. It has a persistence value 30.
     */
    Confirmation(30),

    /**
     * The approval operation. It has a persistence value 40.
     */
    Approval(40);

    private final int value;

    Type(Integer value) {
      this.value = value;
    }

    @Override
    public Integer value() {
      return value;
    }

    /**
     * Get the {@link Type} with the persistence value.
     *
     * @param value The value
     * @return The {@link Type} of the persistence value
     * @throws IllegalArgumentException If the value is unsupported
     */
    public static Type valueOf(Integer value) {
      Objects.requireNonNull(value);
      for (Type type : Type.values()) {
        if (type.value().equals(value)) return type;
      }
      throw new IllegalArgumentException("unsupported Meta-Operation-Type value: " + value);
    }
  }
}