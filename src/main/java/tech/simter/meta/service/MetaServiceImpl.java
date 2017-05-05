package tech.simter.meta.service;


import tech.simter.Context;
import tech.simter.meta.dao.MetaDao;
import tech.simter.meta.po.MetaDoc;
import tech.simter.meta.po.MetaHistory;
import tech.simter.meta.po.MetaType;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import java.time.OffsetDateTime;

/**
 * Document Meta-Info Service
 *
 * @author RJ 2017-04-25
 */
@Named
@Singleton
public class MetaServiceImpl implements MetaService {
  @Inject
  private MetaDao metaDao;

  @Override
  public void addCreation(Class docType, Integer docId) {
    add(docType, docId, "creation");
  }

  @Override
  public void addModification(Class docType, Integer docId) {
    add(docType, docId, "modification");
  }

  private void add(Class docType, Integer docId, String metaType) {
    // Get the MetaType, create one if not exists.
    MetaType mt = metaDao.getMetaType(metaType);
    if (mt == null) {
      mt = new MetaType();
      mt.type = metaType;
      if ("creation".equals(metaType)) mt.name = "Create document";
      else if ("modification".equals(metaType)) mt.name = "Modify document";
      metaDao.createMetaType(mt);
    }

    // Get the MetaDoc, create one if not exists.
    MetaDoc metaDoc = metaDao.getMetaDoc(docType);
    if (metaDoc == null) {
      metaDoc = new MetaDoc();
      metaDoc.type = docType.getName();
      metaDao.createMetaDoc(metaDoc);
    }

    // Create the MetaHistory instance
    MetaHistory metaHistory = new MetaHistory();
    metaHistory.docId = docId;
    metaHistory.metaType = mt;
    metaHistory.metaDoc = metaDoc;
    String userId = Context.get("user.id");
    metaHistory.actor = userId == null ? null : Integer.valueOf(userId);
    metaHistory.time = OffsetDateTime.now();
    metaDao.createMetaHistory(metaHistory);

  }
}