package kodlama.io.northwind.business.dtos.response.employee;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ListEmployeeResponse {
    private String lastName;
    private String firstName;
    private Date birthDate;
    private String  city;
    private String  country;
    private String  homePhone;
}
