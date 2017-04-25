package tech.simter.meta.dao;


import tech.simter.meta.po.MetaDoc;
import tech.simter.meta.po.MetaHistory;
import tech.simter.meta.po.MetaType;

/**
 * Meta DAO
 *
 * @author RJ 2017-04-25
 */
public interface MetaDao {
  void createMetaType(MetaType metaType);

  void createMetaDoc(MetaDoc metaDoc);

  void createMetaHistory(MetaHistory metaHistory);

  MetaType getMetaType(String metaType);

  MetaDoc getMetaDoc(Class docType);
}