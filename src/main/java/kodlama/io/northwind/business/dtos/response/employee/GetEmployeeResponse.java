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
public class GetEmployeeResponse {
    private String lastName;
    private String firstName;
    private String title;
    private String titleOfCourtesy;
    private Date birthDate;
    private Date hireDate;
    private String  address;
    private String  city;
    private String  region;
    private String postalCode;
    private String  country;
    private String  homePhone;
    private String extension;
//    private String  photo;
    private String  notes;
//    private int reportsTo;
    private String photoPath;
}
