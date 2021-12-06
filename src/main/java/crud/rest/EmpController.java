package crud.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import crud.em.Emp;
import crud.in.Empin;

@RestController
@RequestMapping("/apis")
public class EmpController {

	@Autowired
	Empin pin;

	public EmpController(Empin thepin) {
		pin = thepin;
	}

	@RequestMapping("/employees")
	@ResponseBody
	public List<Emp> findAll() {

		return pin.findAll();
	}

	public void save(Emp theEmployee) {
		pin.save(theEmployee);
	}

	@GetMapping("/employees/{employeeId}")
	public Emp getEmployee(@PathVariable int employeeId) {

		Emp theEmployee = pin.findById(employeeId);

		return theEmployee;
	}

	@PostMapping("/employees")
	public Emp addEmployee(@RequestBody Emp theEmployee) {

		pin.save(theEmployee);

		return theEmployee;
	}

	@PutMapping("/employees")
	public Emp updateEmployee(@RequestBody Emp theEmployee) {
		pin.save(theEmployee);

		return theEmployee;
	}

	@DeleteMapping("/employees/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId) {
		Emp tempEmployee = pin.findById(employeeId);

		pin.deleteById(employeeId);

		return "Deleted employee id - " + employeeId;
	}
}
