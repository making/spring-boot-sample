package sample.city;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;

@Service
@Transactional
public class CityService {
    private final CityDao dao;

    @Inject
    public CityService(CityDao dao) {
        this.dao = dao;
    }

    public List<City> selectAll() {
        return dao.selectAll();
    }

    public int updateName(int id, String name) {
        City city = dao.selectById(id);
        city.name = name;
        return dao.update(city);
    }
}
