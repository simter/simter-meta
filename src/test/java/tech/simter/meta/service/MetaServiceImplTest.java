package tech.simter.meta.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import tech.simter.Context;
import tech.simter.meta.dao.MetaDao;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.StrictStubs.class)
public class MetaServiceImplTest {
  @Mock
  private MetaDao dao;

  @InjectMocks
  private MetaServiceImpl service;

  @Before
  public void setUp() throws Exception {
    Context.set("user.id", "1");
  }

  @Test
  public void addCreation() throws Exception {
    service.addCreation(MyDoc.class, 1);
    verify(dao, times(1)).createOperation(any());
  }

  @Test
  public void addModification() throws Exception {
    service.addModification(MyDoc.class, 1);
    verify(dao, times(1)).createOperation(any());
  }

  @Test
  public void addConfirmation() throws Exception {
    service.addConfirmation(MyDoc.class, 1);
    verify(dao, times(1)).createOperation(any());
  }

  @Test
  public void addApproval() throws Exception {
    service.addApproval(MyDoc.class, 1);
    verify(dao, times(1)).createOperation(any());
  }

  class MyDoc {
  }
}