package tech.simter.meta.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import tech.simter.meta.dao.MetaDao;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.StrictStubs.class)
public class MetaServiceImplTest {
  @Mock
  private MetaDao dao;

  @InjectMocks
  private MetaServiceImpl service;

  @Test
  public void addCreation() throws Exception {
    service.addCreation(MyDoc.class, 1);
    verify(dao, times(1)).createMetaHistory(any());
  }

  @Test
  public void addModification() throws Exception {
    service.addModification(MyDoc.class, 1);
    verify(dao, times(1)).createMetaHistory(any());
  }

  class MyDoc {
  }
}