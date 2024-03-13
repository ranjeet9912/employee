package com.example.Employee.Controller;

import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.when;
import com.example.Employee.Model.Employee;
import com.example.Employee.Service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {EmployeeController.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class EmployeeControllerDiffblueTest {
  @Autowired
  private EmployeeController employeeController;

  @MockBean
  private EmployeeService employeeService;

  /**
   * Method under test: {@link EmployeeController#updateEmployee(int, Employee)}
   */
  @Test
  void testUpdateEmployee() throws Exception {
    // Arrange
    Employee employee = new Employee();
    employee.setEmail("jane.doe@example.org");
    employee.setFirstName("Jane");
    employee.setId(1);
    employee.setLastName("Doe");
    when(employeeService.updateEmployee(anyInt(), Mockito.<Employee>any())).thenReturn(employee);

    Employee employee2 = new Employee();
    employee2.setEmail("jane.doe@example.org");
    employee2.setFirstName("Jane");
    employee2.setId(1);
    employee2.setLastName("Doe");
    String content = (new ObjectMapper()).writeValueAsString(employee2);
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/employee/update/{id}", 1)
            .contentType(MediaType.APPLICATION_JSON)
            .content(content);

    // Act and Assert
    MockMvcBuilders.standaloneSetup(employeeController)
            .build()
            .perform(requestBuilder)
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
            .andExpect(MockMvcResultMatchers.content()
                    .string("{\"id\":1,\"firstName\":\"Jane\",\"lastName\":\"Doe\",\"email\":\"jane.doe@example.org\"}"));
  }

  /**
   * Method under test: {@link EmployeeController#addEmplyee(Employee)}
   */
  @Test
  void testAddEmplyee() throws Exception {
    // Arrange
    Employee employee = new Employee();
    employee.setEmail("jane.doe@example.org");
    employee.setFirstName("Jane");
    employee.setId(1);
    employee.setLastName("Doe");
    when(employeeService.addEmployee(Mockito.<Employee>any())).thenReturn(employee);

    Employee employee2 = new Employee();
    employee2.setEmail("jane.doe@example.org");
    employee2.setFirstName("Jane");
    employee2.setId(1);
    employee2.setLastName("Doe");
    String content = (new ObjectMapper()).writeValueAsString(employee2);
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/employee/addEmployee")
            .contentType(MediaType.APPLICATION_JSON)
            .content(content);

    // Act and Assert
    MockMvcBuilders.standaloneSetup(employeeController)
            .build()
            .perform(requestBuilder)
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
            .andExpect(MockMvcResultMatchers.content()
                    .string("{\"id\":1,\"firstName\":\"Jane\",\"lastName\":\"Doe\",\"email\":\"jane.doe@example.org\"}"));
  }

  /**
   * Method under test: {@link EmployeeController#deleteEmp(int)}
   */
  @Test
  void testDeleteEmp() throws Exception {
    // Arrange
    when(employeeService.deleteEmp(anyInt())).thenReturn("Delete Emp");
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/employee/delete/{id}", 1);

    // Act and Assert
    MockMvcBuilders.standaloneSetup(employeeController)
            .build()
            .perform(requestBuilder)
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
            .andExpect(MockMvcResultMatchers.content().string("Delete Emp"));
  }

  /**
   * Method under test: {@link EmployeeController#getEmployee()}
   */
  @Test
  void testGetEmployee() throws Exception {
    // Arrange
    when(employeeService.getEployee()).thenReturn(new ArrayList<>());
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/employee/getEmployee");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(employeeController)
            .build()
            .perform(requestBuilder)
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
            .andExpect(MockMvcResultMatchers.content().string("[]"));
  }
}
