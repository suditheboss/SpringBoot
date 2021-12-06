package crud.in;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import crud.em.Emp;

public interface Empin extends JpaRepository<Emp, Integer> {

	public List<Emp> findAll();

	public Emp findById(int theId);

	//public void save(Emp theEmployee);

	public void deleteById(int theId);

}
