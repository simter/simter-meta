package tech.simter.meta.service;


/**
 * Document Meta-Info Service
 *
 * @author RJ 2017-04-25
 */
public interface MetaService {
  /**
   * Add a document creation meta-info
   *
   * @param docType Document type
   * @param docId Document ID
   */
  void addCreation(Class docType, Integer docId);

  /**
   * Add a document modification meta-info
   *
   * @param docType Document type
   * @param docId Document ID
   */
  void addModification(Class docType, Integer docId);
}