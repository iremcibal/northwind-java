package kodlama.io.northwind.dataAccess.abstracts;

import kodlama.io.northwind.business.dtos.response.employeeTerritories.ListEmpTerriResponse;
import kodlama.io.northwind.entities.concretes.EmployeeTerritories;
import kodlama.io.northwind.entities.dtos.EmployeeTerritoryDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeTerritoriesRepository extends JpaRepository<EmployeeTerritories,Integer> {

    @Query("select new kodlama.io.northwind.business.dtos.response.employeeTerritories.ListEmpTerriResponse(et.employeeTerritoryId,et.employee.firstName,et.employee.lastName,et.territory.territoryDescription)" +
            "from EmployeeTerritories et join et.employee e join et.territory t " +
            "where et.employeeTerritoryId=:empTerriId")
    List<ListEmpTerriResponse> getByEmployerTerritoryId(int empTerriId);
}
