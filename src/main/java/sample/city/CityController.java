package sample.city;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.List;

@RestController
@Transactional
public class CityController {

    private final CityDao dao;

    @Inject
    public CityController(CityDao dao) {
        this.dao = dao;
    }

    @RequestMapping("/")
    public List<City> selectAll() {
        return dao.selectAll();
    }

    @RequestMapping("/update")
    public List<City> updateAndSelectAll(
            @RequestParam(value = "id", defaultValue = "1") int id,
            @RequestParam("name") String name) {
        City city = dao.selectById(id);
        city.name = name;
        dao.update(city);
        return dao.selectAll();
    }

}
