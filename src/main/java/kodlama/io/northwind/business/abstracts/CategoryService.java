package kodlama.io.northwind.business.abstracts;

import kodlama.io.northwind.entities.concretes.Category;
import kodlama.io.northwind.entities.concretes.Product;

import java.util.List;

public interface CategoryService {
    List<Category> getAll();
    Category getById(int id);
}
