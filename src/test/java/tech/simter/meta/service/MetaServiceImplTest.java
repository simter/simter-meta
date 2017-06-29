package tech.simter.meta.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import tech.simter.Context;
import tech.simter.meta.dao.MetaDao;
import tech.simter.meta.po.Operator;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
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

  @Test
  public void getCreator() throws Exception {
    Operator operator = mock(Operator.class);
    operator.id = 1;
    when(dao.getCreator(MyDoc.class, 1)).thenReturn(operator);
    Operator creator = service.getCreator(MyDoc.class, 1);
    verify(dao).getCreator(MyDoc.class, 1);
    assertThat(creator, is(operator));
  }

  class MyDoc {
  }
}