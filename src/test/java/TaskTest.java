import java.time.LocalDateTime;

import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;

public class TaskTest {

  @Rule
  public ClearRule clearRule = new ClearRule();

  @Test
  public void newTask_instatiateCorrectly_true() {
    Task testTask = new Task("Wash the dishes");
    assertEquals(true, testTask instanceof Task);
  }

  @Test
  public void newTask_displayATask() {
    Task testTask = new Task("Wash the dishes");
    assertEquals("Wash the dishes", testTask.getDescription());
  }

  @Test
  public void isCompleted_isFalseAfterInstantiaon_false() {
    Task testTask = new Task("Wash the dishes");
    assertEquals(false, testTask.isCompleted());
   }
  @Test
  public void getCreatedAt_instantiatesWithCurrentTime_today() {
    Task testTask = new Task("Wash the dishes");
    assertEquals(LocalDateTime.now().getDayOfWeek(), testTask.getCreatedAt().getDayOfWeek());
   }

   @Test
   public void all_returnsAllInstancesOfTask_true() {
     Task firstTask = new Task("Wash the dishes");
     Task secondTask = new Task("Buy groceries");
     assertTrue(Task.all().contains(firstTask));
     assertTrue(Task.all().contains(secondTask));
   }

   @Test
   public void newId_tasksInstantiateWithAnID_true() {
     Task testTask = new Task("Wash the dishes");
     assertEquals(Task.all().size(), testTask.getId());
   }

   @Test
   public void find_returnsTaskWithSameId_secondTask() {
     Task firstTask = new Task("Wash the dishes");
     Task secondTask = new Task("Buy groceries");
     assertEquals(Task.find(secondTask.getId()), secondTask);
   }

   @Test
   public void find_returnsNullWhenNoTaskFound_null() {
     assertTrue(Task.find(999)== null);
   }

   @Test
   public void clear_emptiesAllTasksFromArrayList() {
     Task testTask = new Task("Wash the dishes");
     Task.clear();
     assertEquals(Task.all().size(), 0);
   }
}
