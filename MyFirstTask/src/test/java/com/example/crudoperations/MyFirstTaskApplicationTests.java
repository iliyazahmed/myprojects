package com.example.crudoperations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.crudoperations.daolayer.EmployeeDao;
import com.example.crudoperations.dtolayer.EmployeeDto;
import com.example.crudoperations.servicelayer.EmployeeServiceLayer;


@SpringBootTest
class MyFirstTaskApplicationTests {
	
    @MockBean
	private EmployeeDao employeeDao;
	
	@Autowired
	private EmployeeServiceLayer employeeServiceLayer;
	

	@Test
	public void saveEmpTest() {
		EmployeeDto dto = new EmployeeDto(110,"kohli", 287.9);
		when(employeeDao.save(dto)).thenReturn(dto);
		assertEquals(dto, employeeServiceLayer.addEmployee(dto));
	}
	
	@Test
	public void findEmpTest() {
		Optional<EmployeeDto> dto = Optional.of(new EmployeeDto(105,"sachin", 230.56));
        when(employeeDao.findById(105)).thenReturn(dto);
        EmployeeDto dto2 = employeeServiceLayer.getDetails(105);
        assertEquals(230.56, dto2.getSalary());
        assertEquals("sachin", dto2.getEName());
	 
	}
	
	@Test
	public void deletEmpTest() {
		EmployeeDto dto = new EmployeeDto();
		dto.setEmpId(dto.getEmpId());
		employeeServiceLayer.deleteEmployee(dto.getEmpId());
		verify(employeeDao,times(1)).deleteById(dto.getEmpId());
	}
	
	@Test
	public void updateEmpSalaryTest() {
		EmployeeDto dto = new EmployeeDto(105,"sachin", 450.98);
//		EmployeeDto dto2 = new EmployeeDto();
//        dto2.setSalary(dto2.getSalary());
//        dto2.setEName(dto2.getEName());
		//Optional<EmployeeDto> find1  = employeeDao.findById(123);
		//employeeServiceLayer.updateDetails(dto2);
		assertThat(dto.getSalary()).isEqualTo(450.98);
		assertThat(dto.getEName()).isEqualTo("sachin");

	}
}
