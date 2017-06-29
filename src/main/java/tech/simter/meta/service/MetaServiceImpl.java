package tech.simter.meta.service;


import tech.simter.Context;
import tech.simter.meta.dao.MetaDao;
import tech.simter.meta.po.Document;
import tech.simter.meta.po.Operation;
import tech.simter.meta.po.Operator;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import java.time.OffsetDateTime;
import java.util.Objects;

/**
 * The default meta service implements.
 *
 * @author RJ
 */
@Named
@Singleton
public class MetaServiceImpl implements MetaService {
  @Inject
  private MetaDao metaDao;

  public void add(String documentType, Integer instanceId, int operationType) {
    Objects.requireNonNull(documentType, "The documentType could not be null.");
    Objects.requireNonNull(instanceId, "The instanceId could not be null.");

    // Create the Operation instance
    Operation history = new Operation();
    history.instanceId = instanceId;
    history.type = operationType;
    history.operateTime = OffsetDateTime.now();

    // Get the Document, create one if not exists.
    Document doc = metaDao.getDocument(documentType);
    if (doc == null) {
      doc = new Document();
      doc.type = documentType;
      metaDao.createDocument(doc);
    }
    history.document = doc;

    // Get the Operator, create one if not exists.
    String userId_ = Context.get("user.id");
    if (userId_ != null) {
      Integer userId = Integer.valueOf(userId_);
      Operator operator = metaDao.getOperator(userId);
      if (operator == null) {
        operator = new Operator();
        operator.id = userId;
        operator.name = Context.get("user.name");
        metaDao.createOperator(operator);
      }
      history.operator = operator;
    }

    // save
    metaDao.createOperation(history);
  }

  public void add(Class entityType, Integer entityId, int operationType) {
    Objects.requireNonNull(entityType, "The entityType could not be null.");
    add(entityType.getName(), entityId, operationType);
  }

  public void add(Class entityType, Integer entityId, Operation.Type operationType) {
    Objects.requireNonNull(operationType, "The operationType could not be null.");
    add(entityType, entityId, operationType.value());
  }

  @Override
  public void addCreation(Class entityType, Integer entityId) {
    add(entityType, entityId, Operation.Type.Creation);
  }

  @Override
  public void addModification(Class entityType, Integer entityId) {
    add(entityType, entityId, Operation.Type.Modification);
  }

  @Override
  public void addConfirmation(Class entityType, Integer entityId) {
    add(entityType, entityId, Operation.Type.Confirmation);
  }

  @Override
  public void addApproval(Class entityType, Integer entityId) {
    add(entityType, entityId, Operation.Type.Approval);
  }

  @Override
  public Operator getCreator(Class entityType, Integer entityId) {
    return metaDao.getCreator(entityType, entityId);
  }
}