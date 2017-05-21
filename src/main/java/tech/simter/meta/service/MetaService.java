package tech.simter.meta.service;


import tech.simter.meta.po.Operation;

/**
 * The meta service.
 *
 * @author RJ
 */
public interface MetaService {
  /**
   * Add a specific document operation.
   *
   * @param documentType  The document type
   * @param instanceId    The document instance ID
   * @param operationType The custom operation type value
   */
  void add(String documentType, Integer instanceId, int operationType);

  /**
   * Add a specific entity operation.
   *
   * @param entityType    The entity type
   * @param entityId      The entity ID
   * @param operationType The operation type
   */
  void add(Class entityType, Integer entityId, int operationType);

  /**
   * Add a specific entity operation.
   *
   * @param entityType    The entity type
   * @param entityId      The entity ID
   * @param operationType The operation type
   */
  void add(Class entityType, Integer entityId, Operation.Type operationType);

  /**
   * Add a entity creation operation
   *
   * @param entityType The entity type
   * @param entityId   The entity ID
   */
  void addCreation(Class entityType, Integer entityId);

  /**
   * Add a entity modification operation
   *
   * @param entityType The entity type
   * @param entityId   The entity ID
   */
  void addModification(Class entityType, Integer entityId);

  /**
   * Add a entity confirmation operation
   *
   * @param entityType The entity type
   * @param entityId   The entity ID
   */
  void addConfirmation(Class entityType, Integer entityId);

  /**
   * Add a entity approval operation
   *
   * @param entityType The entity type
   * @param entityId   The entity ID
   */
  void addApproval(Class entityType, Integer entityId);
}