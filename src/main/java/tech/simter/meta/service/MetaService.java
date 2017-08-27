package tech.simter.meta.service;


import tech.simter.meta.po.Operation;
import tech.simter.meta.po.Operator;

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
   * @param operator      The operator, use current user if null
   */
  void add(String documentType, Integer instanceId, int operationType, Operator operator);

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
   * Add a specific entity operation.
   *
   * @param entityType    The entity type
   * @param entityId      The entity ID
   * @param operationType The operation type
   * @param operator      The operator, use current user if null
   */
  void add(Class entityType, Integer entityId, Operation.Type operationType, Operator operator);

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

  /**
   * Get the entity creator
   *
   * @param entityType The entity type
   * @param entityId   The entity ID
   * @return the creator or null if not exists
   */
  Operator getCreator(Class entityType, Integer entityId);

  /**
   * Get the last operation on the specify entity
   *
   * @param entityType    The entity type
   * @param entityId      The entity ID
   * @param operationType The operation type
   * @return the operation or null if not exists
   */
  Operation getLastOperation(Class entityType, Integer entityId, Operation.Type operationType);

  /**
   * Get the last operation on the specify entity
   *
   * @param entityType    The entity type
   * @param entityId      The entity ID
   * @param operationType The operation type
   * @return the operation or null if not exists
   */
  Operation getLastOperation(Class entityType, Integer entityId, int operationType);

  /**
   * Get the last operation on the specify entity
   *
   * @param entityType     The entity type
   * @param entityId       The entity ID
   * @param operationTypes The operation types
   * @return the operation or null if not exists
   */
  Operation getLastOperation(Class entityType, Integer entityId, Operation.Type[] operationTypes);

  /**
   * Get the last operation on the specify entity
   *
   * @param entityType     The entity type
   * @param entityId       The entity ID
   * @param operationTypes The operation types
   * @return the operation or null if not exists
   */
  Operation getLastOperation(Class entityType, Integer entityId, int[] operationTypes);
}