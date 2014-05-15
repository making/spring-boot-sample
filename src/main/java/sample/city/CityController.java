package sample.city;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.List;

@RestController
public class CityController {

    private final CityService cityService;

    @Inject
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @RequestMapping("/")
    public List<City> selectAll() {
        return cityService.selectAll();
    }

    @RequestMapping("/update")
    public List<City> updateAndSelectAll(
            @RequestParam(value = "id", defaultValue = "1") int id,
            @RequestParam("name") String name) {
        cityService.updateName(id, name);
        return cityService.selectAll();
    }

}
