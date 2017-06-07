package tech.simter.meta.dao;


import tech.simter.meta.po.Document;
import tech.simter.meta.po.Operation;
import tech.simter.meta.po.Operator;

/**
 * The meta DAO
 *
 * @author RJ
 */
public interface MetaDao {
  /**
   * Get the specific type document.
   *
   * @param type the document type
   * @return the document
   */
  Document getDocument(Class type);

  /**
   * Get the specific type document.
   *
   * @param type the document type
   * @return the document
   */
  Document getDocument(String type);

  /**
   * Create a document.
   *
   * @param document the document to be created
   */
  void createDocument(Document document);

  /**
   * Get the specific identity operator.
   *
   * @param operatorId the operator ID
   * @return the operator
   */
  Operator getOperator(Integer operatorId);

  /**
   * Create a operator.
   *
   * @param operator the operator to be created
   */
  void createOperator(Operator operator);

  /**
   * Create a operation.
   *
   * @param operation the operation to be created
   */
  void createOperation(Operation operation);

  /**
   * Create a {@link Document} if not exists, otherwise get by type.
   *
   * @param type the document type
   * @param type the type description
   * @return the exists one or create a new one if not exists
   */
  Document createOrGetDocumentByType(String type, String name);
}