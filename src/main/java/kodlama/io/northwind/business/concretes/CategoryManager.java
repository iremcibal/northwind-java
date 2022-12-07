package kodlama.io.northwind.business.concretes;

import kodlama.io.northwind.business.abstracts.CategoryService;
import kodlama.io.northwind.dataAccess.abstracts.CategoryRepository;
import kodlama.io.northwind.entities.concretes.Category;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryManager implements CategoryService {

    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getById(int id) {
        return categoryRepository.findById(id).orElseThrow();
    }
}
